///*
// * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
// */
//package com.my.app.youyou.common.aspect;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
///**
// * 类AopAspect
// *
// * @author wuzhongxing
// * @since 2016-12-08.
// */
//@Aspect
//@Component
//@Order(3)
//public class AopAspect {
//    public static final int LOG_SIZE = 500;
//
//    public static final String SKIP_STR = "...skipping...";
//
//    private static final Logger logger = LoggerFactory.getLogger(AopAspect.class);
//
//    @Around("execution(* com.baidu.fsg.csp.workorder.service.*.*(..)) ")
//    public Object runTime(ProceedingJoinPoint jp) throws Throwable {
//        long time = System.currentTimeMillis();
//        Object obj = null;
//        try {
//            obj = jp.proceed();
//        } catch (Throwable e) {
//            printLog(jp, time);
//            throw e;
//        }
//        printLog(jp, time);
//        return obj;
//    }
//
//    @Around("@within(com.baidu.fsg.csp.inner.common.aspect.LogAnnotation) "
//            + "|| @annotation(com.baidu.fsg.csp.inner.common.aspect.LogAnnotation)")
//    public Object log(ProceedingJoinPoint jp) throws Throwable {
//        String methodName = jp.toShortString();
//        Object obj;
//        try {
//            methodName = methodName.substring(10, methodName.length() - 5);
//            StringBuilder sb = new StringBuilder(" [");
//            Object[] parames = jp.getArgs();
//            if (!ArrayUtils.isEmpty(parames)) {
//                for (Object param : parames) {
//                    if (param != null && StringUtils.isNotEmpty(param.toString())) {
//                        sb.append(param.toString()).append("][");
//                    }
//                }
//            }
//            String requestLog = sb.substring(0, sb.length() - 1);
//            logger.info("method:{} parameter:{}", methodName, getProdSkipStr(requestLog));
//            obj = jp.proceed();
//        } catch (Exception e) {
//            throw e;
//        }
//        logger.info("method:{} response:{}", methodName, getProdSkipStr(obj));
//        return obj;
//    }
//
//    private void printLog(ProceedingJoinPoint jp, long time) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(jp.getTarget().getClass().getSimpleName());
//        sb.append(".");
//        sb.append(jp.getSignature().getName());
//        sb.append(" run time:");
//        sb.append(System.currentTimeMillis() - time);
//        sb.append(" ms ");
//        logger.info(sb.toString());
//    }
//
//    private static String getProdSkipStr(Object obj) {
//        if (obj == null) {
//            return null;
//        }
//        String str = obj.toString();
//        if (str != null && str.length() > LOG_SIZE) {
//            return str.substring(0, LOG_SIZE) + SKIP_STR;
//        } else {
//            return str;
//        }
//    }
//}