/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.my.app.youyou.common.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LogAnnotation
 *
 * @author wuzhongxing
 * @since 2016-12-08.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
}
