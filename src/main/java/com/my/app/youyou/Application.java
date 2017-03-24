/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther sunzanmei
 * @date 16/12/25
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        // 启动Spring Boot项目的唯一入口
        SpringApplication.run(Application.class, args);
    }
}
