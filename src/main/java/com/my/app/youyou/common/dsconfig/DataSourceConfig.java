///*
// * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
// */
//package com.my.app.youyou.common.dsconfig;
//
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.baidu.bjf.datasource.lb.RoundRobinLBStrategy;
//import com.baidu.bjf.datasource.proxy.DynamicDataSource;
//import com.google.common.collect.Maps;
///**
// * DataSourceConfig
// *
// * @author wuzhongxing
// * @since 2016-12-07.
// */
//
///**
// * 配置mybatis扫描mapperclass包,设置SqlSessionFactory
// * 配置datasource、TransactionManager等
// */
//@Configuration
//@MapperScan(basePackages = "com.my.app.youyou.persistence.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
//public class DataSourceConfig {
//
//    /**
//     * 配置SqlSessionFactory bean
//     *
//     * @param dynamicDataSource Datasource
//     * @return SqlSessionFactory
//     * @throws Exception iferror
//     */
//    @Bean(name = "sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory woSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * 配置TransactionManager
//     *
//     * @param dataSource dataSource
//     * @return DataSourceTransactionManager
//     */
//    @Bean(name = "woTransactionManager")
//    public DataSourceTransactionManager woTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    /**
//     * 配置datasource1
//     *
//     * @param driverClass dbdriver
//     * @param url         dburl
//     * @param username    dbusername
//     * @param password    dbpass
//     * @return DataSource
//     */
//    @Bean(name = "db1DataSource")
//    public DataSource db1DataSource(@Value("${spring.datasource.db01.driverClassName}") String driverClass,
//                                    @Value("${spring.datasource.db01.url}") String url,
//                                    @Value("${spring.datasource.db01.username}") String username,
//                                    @Value("${spring.datasource.db01.password}") String password) {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(driverClass);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }
//
//    /**
//     * 配置datasource2
//     *
//     * @param driverClass dbdriver
//     * @param url         dburl
//     * @param username    dbusername
//     * @param password    dbpass
//     * @return DataSource
//     */
//    @Bean(name = "db2DataSource")
//    public DataSource db2DataSource(@Value("${spring.datasource.db02.driverClassName}") String driverClass,
//                                    @Value("${spring.datasource.db02.url}") String url,
//                                    @Value("${spring.datasource.db02.username}") String username,
//                                    @Value("${spring.datasource.db02.password}") String password) {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(driverClass);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }
//
//    /**
//     * 配置动态datasource
//     *
//     * @param db1DataSource        db1
//     * @param db2DataSource        db2
//     * @param roundRobinLBStrategy lbstrategy
//     * @return DataSource
//     */
//    @Bean(name = "dynamicDataSource")
//    @Primary
//    public DataSource dynamicDataSource(@Qualifier("db1DataSource") DataSource db1DataSource,
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
//
//    /**
//     * lbstrategy
//     *
//     * @return RoundRobinLBStrategy
//     */
//    @Bean(name = "roundRobinLBStrategy")
//    public RoundRobinLBStrategy roundRobinLBStrategy() {
//        Map<String, Integer> dsMap = Maps.newHashMap();
//        dsMap.put("ds1", 1);
//        dsMap.put("ds2", 1);
//        RoundRobinLBStrategy strategy = new RoundRobinLBStrategy(dsMap);
//        return strategy;
//    }
//
////    @Bean(name="msoaProcessor")
////    public ExtBundleContextPostProcessor msoaProcessor(@Value("${msoa.cspworkorder.bundleName}")String bundleName){
////        ExtBundleContextPostProcessor bean = new ExtBundleContextPostProcessor(bundleName);
////        bean.setReloadBundleContext(true);
////        return bean;
////    }
//}
