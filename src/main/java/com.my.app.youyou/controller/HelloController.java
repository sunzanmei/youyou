/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther sunzanmei
 * @date 16/12/25
 */
@Controller
public class HelloController {

    @RequestMapping("/hellow")
    @ResponseBody
    public String hellow(){

        return "哈喽，Spring Boot ！";
    }
}
