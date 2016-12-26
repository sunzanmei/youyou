/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther sunzanmei
 * @date 16/12/25
 */
@Controller
public class HelloController {

    private Logger logger = Logger.getLogger(HelloController.class);

    /*
    *   http://localhost:8080/hello?name=cn.7player
     */

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        logger.info("hello");
        model.addAttribute("name", name);
        return "hello";
    }


    @RequestMapping("/hello1")
    @ResponseBody
    public String hello1() {
        return "hello";
    }
}
