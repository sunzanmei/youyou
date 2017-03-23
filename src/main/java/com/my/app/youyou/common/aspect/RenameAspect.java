///*
// * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
// */
//package com.my.app.youyou.common.aspect;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//
///**
// * 类AopAspect
// *
// * @author wuzhongxing
// * @since 2016-12-08.
// */
//// @Aspect
//// @Component
//// @Order(2)
//public class RenameAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(RenameAspect.class);
//
//    @Around("execution(public * com.baidu.fsg.csp.workorder.web.controller.*.*(..))")
//    @Order(1)
//    public Object threadRename(ProceedingJoinPoint jp) throws Throwable {
//        String oldThreadName = Thread.currentThread().getName();
//        try {
//            String newThreadName = new StringBuilder("CSP-").append(System.currentTimeMillis())
//                    .append(ThreadLocalRandom.current().nextInt(9999)).toString();
//            Thread.currentThread().setName(newThreadName);
//        } catch (Throwable e) {
//            logger.error("ThreadRenameAspect.error", e);
//        }
//        try {
//            return jp.proceed();
//        } catch (Throwable e) {
//            throw e;
//        } finally {
//            Thread.currentThread().setName(oldThreadName);
//        }
//
//    }
//}