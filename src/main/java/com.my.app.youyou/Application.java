/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther sunzanmei
 * @date 16/12/25
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        // 启动Spring Boot项目的唯一入口
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        // 设置启动端口号为9090
        configurableEmbeddedServletContainer.setPort(9090);
    }
}
