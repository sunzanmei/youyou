/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou.common.dsconfig;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * DataSourceConfig
 *
 * @author sunzanmei
 * @since 2017-03-07.
 */

/**
 * 配置mybatis扫描mapperclass包,设置SqlSessionFactory
 * 配置datasource、TransactionManager等
 */
@Configuration
@MapperScan(basePackages = "com.my.app.youyou.persistence.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    /**
     * 配置SqlSessionFactory bean
     *
     * @param dataSource Datasource
     * @return SqlSessionFactory
     * @throws Exception iferror
     */
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置TransactionManager
     *
     * @param dataSource dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置datasource1
     *
     * @param driverClass dbdriver
     * @param url         dburl
     * @param username    dbusername
     * @param password    dbpass
     * @return DataSource
     */
    @Bean(name = "dataSource")
    public DataSource dataSource(@Value("${spring.datasource.driverClassName}") String driverClass,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    /**
     * 配置动态datasource
     *
     * @param db1DataSource        db1
     * @param db2DataSource        db2
     * @param roundRobinLBStrategy lbstrategy
     * @return DataSource
     */
//    @Bean(name = "dataSource")
//    @Primary
//    public DataSource dataSource(@Qualifier("db1DataSource") DataSource db1DataSource,
//                                        @Qualifier("db2DataSource") DataSource db2DataSource,
//                                        @Qualifier("roundRobinLBStrategy") RoundRobinLBStrategy roundRobinLBStrategy) {
//        Map<Object, Object> dsMap = Maps.newHashMap();
//        dsMap.put("ds1", db1DataSource);
//        dsMap.put("ds2", db2DataSource);
//        DynamicDataSource ds = new DynamicDataSource();
//        ds.setTargetDataSources(dsMap);
//        ds.setStrategy(roundRobinLBStrategy);
//        return ds;
//    }

    /**
     * lbstrategy
     *
     * @return RoundRobinLBStrategy
     */
//    @Bean(name = "roundRobinLBStrategy")
//    public RoundRobinLBStrategy roundRobinLBStrategy() {
//        Map<String, Integer> dsMap = Maps.newHashMap();
//        dsMap.put("ds1", 1);
//        dsMap.put("ds2", 1);
//        RoundRobinLBStrategy strategy = new RoundRobinLBStrategy(dsMap);
//        return strategy;
//    }

//    @Bean(name="msoaProcessor")
//    public ExtBundleContextPostProcessor msoaProcessor(@Value("${msoa.cspworkorder.bundleName}")String bundleName){
//        ExtBundleContextPostProcessor bean = new ExtBundleContextPostProcessor(bundleName);
//        bean.setReloadBundleContext(true);
//        return bean;
//    }
}
