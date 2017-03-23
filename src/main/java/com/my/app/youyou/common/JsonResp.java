///*
// * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
// */
//
//package com.my.app.youyou.common;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.util.CollectionUtils;
//
//import com.google.common.base.Preconditions;
//import com.google.common.collect.Maps;
//import com.google.gson.GsonBuilder;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @author : CK
// * @since : 2016/1/12
// */
//public class JsonResp {
//    /**
//     * 成功标志
//     */
//    public static final int STATUS_SUCCESS = 0;
//    /**
//     * 失败标志
//     */
//    public static final int STATUS_ERROR = 1;
//    /**
//     * 返回状态代码
//     */
//    private int status;
//    /**
//     * 返回状态信息
//     */
//    private String statusInfo = "";
//    /**
//     * null序列化开关,默认关闭
//     */
//    private transient boolean showNull = false;
//    /**
//     * 日期格式化模版
//     */
//    private transient String datePattern = "yyyy-MM-dd";
//    /**
//     * 数据对象
//     */
//    private Object data = null;
//    /**
//     * 数据列表指针
//     */
//    private List<Object> dataList = null;
//
//    /**
//     * 响应类型
//     *
//     * @author chenyan06
//     */
//    static enum RespType {
//        /**
//         * 数据列表
//         */
//        LIST,
//
//        /**
//         * 树形结构
//         */
//        TREE
//    }
//
//    /**
//     * 响应类型
//     */
//    private transient RespType type;
//
//    /**
//     * 构造函数, 使用默认的信息.
//     *
//     * @param type 类型.
//     */
//    public JsonResp(RespType type) {
//        this.type = type;
//    }
//
//    /**
//     * 返回json串.
//     *
//     * @return json串.
//     */
//    public String toJson() {
//        GsonBuilder builder = new GsonBuilder().enableComplexMapKeySerialization();
//        if (showNull) {
//            builder.serializeNulls();
//        }
//        if (!StringUtils.isBlank(datePattern)) {
//            builder.setDateFormat(datePattern);
//        }
//        return builder.create().toJson(this, JsonResp.class);
//    }
//
//    /**
//     * 返回map.
//     *
//     * @return map.
//     */
//    public Map<String, Object> toMapResp() {
//        Map<String, Object> result = Maps.newLinkedHashMap();
//        result.put("status", status);
//        result.put("statusInfo", statusInfo);
//        if (data != null) {
//            result.put("data", data);
//        }
//        if (!CollectionUtils.isEmpty(dataList)) {
//            result.put("dataList", dataList);
//        }
//        return result;
//    }
//
//    /**
//     * 设置日期模式
//     *
//     * @param datePattern 日期模式
//     * @return 该响应对象.
//     */
//    public JsonResp setDatePattern(String datePattern) {
//        this.datePattern = datePattern;
//        return this;
//    }
//
//    /**
//     * 空值序列化
//     *
//     * @return 该响应对象.
//     */
//    public JsonResp withNulls() {
//        this.showNull = true;
//        return this;
//    }
//
//    /**
//     * 设置响应成功标志.
//     *
//     * @return 该响应对象.
//     */
//    public JsonResp success() {
//        this.status = STATUS_SUCCESS;
//        return this;
//    }
//
//    /**
//     * 设置响应成功标志.
//     * @param statusInfo statusInfo
//     * @return 该响应对象
//     */
//    public JsonResp success(String statusInfo) {
//        this.statusInfo = statusInfo;
//        return success();
//    }
//
//    /**
//     * 设置响应失败标志.
//     *
//     * @param message 消息.
//     * @return 该响应对象.
//     */
//    public JsonResp error(String message) {
//        this.status = STATUS_ERROR;
//        this.statusInfo = message;
//        return this;
//    }
//
//    public JsonResp error(int status, String message) {
//        this.status = status;
//        this.statusInfo = message;
//        return this;
//    }
//
//    /**
//     * 基础响应
//     */
//    public static class BaseResp {
//        /**
//         * resp
//         */
//        JsonResp resp;
//
//        /**
//         * 构造方法
//         *
//         * @param resp resp
//         */
//        public BaseResp(JsonResp resp) {
//            this.resp = resp;
//        }
//
//        /**
//         * get
//         *
//         * @return resp
//         */
//        public JsonResp getResp() {
//            return resp;
//        }
//
//        /**
//         * 设置响应成功标志.
//         *
//         * @return 该响应对象.
//         */
//        public JsonResp success() {
//            resp.success();
//            return resp;
//        }
//
//        /**
//         * 设置响应成功标志.
//         *
//         * @param message 消息.
//         * @return 该响应对象.
//         */
//        public JsonResp success(String message) {
//            resp.success(message);
//            return resp;
//        }
//
//        /**
//         * 设置响应失败标志.
//         *
//         * @param message 消息.
//         * @return 该响应对象.
//         */
//        public JsonResp error(String message) {
//            resp.error(message);
//            return resp;
//        }
//
//        /**
//         * 设置响应失败标志.
//         *
//         * @param status status.
//         * @param message 消息.
//         * @return 该响应对象.
//         */
//        public JsonResp error(int status, String message) {
//            resp.error(status, message);
//            return resp;
//        }
//
//        /**
//         * 显示null
//         *
//         * @return 该响应对象
//         */
//        public JsonResp withNulls() {
//            resp.withNulls();
//            return resp;
//        }
//
//        /**
//         * 设置日期格式
//         *
//         * @param pattern 格式,非null
//         * @return 该响应对象
//         */
//        public JsonResp setDatePattern(String pattern) {
//            resp.setDatePattern(pattern);
//            return resp;
//        }
//
//        /**
//         * 返回json串.
//         *
//         * @return json串.
//         */
//        public String toJson() {
//            return resp.toJson();
//        }
//        /**
//         * 返回map.
//         *
//         * @return map.
//         */
//        public Map<String, Object> toMapResp() {
//            return resp.toMapResp();
//        }
//    }
//
//    /**
//     * 创建列表响应
//     *
//     * @return 列表响应
//     */
//    public static JList asList() {
//        JsonResp resp = new JsonResp(RespType.LIST);
//        JList jList = new JList(resp);
//        return jList;
//    }
//
//    /**
//     * 列表类
//     */
//    public static class JList extends BaseResp {
//        /**
//         * 构造方法
//         *
//         * @param resp resp
//         */
//        public JList(JsonResp resp) {
//            super(resp);
//            resp.dataList = new ArrayList<Object>();
//        }
//
//        /**
//         * 增加数据集合到数据列表中.
//         *
//         * @param <T>  对象类型变量
//         * @param objs 数据集合
//         * @return 该响应对象.
//         */
//        public <T> JList addAll(Collection<T> objs) {
//            Preconditions.checkNotNull(resp.dataList, "dataList不能为空");
//            if (!objs.isEmpty()) {
//                resp.dataList.addAll(objs);
//            }
//            return this;
//        }
//    }
//
//    /**
//     * 创建树形结构响应.
//     *
//     * @param o 响应数据
//     * @return 响应对象.
//     */
//    public static JsonResp asData(Object o) {
//        JsonResp resp = new JsonResp(RespType.TREE);
//        resp.data = o;
//        return resp;
//    }
//
//    /**
//     * 创建树形结构响应.
//     *
//     * @return 响应对象.
//     */
//    public static JData asData() {
//        JsonResp resp = new JsonResp(RespType.TREE);
//        JData jData = new JData(resp);
//        return jData;
//    }
//
//    /**
//     * 树形结构响应
//     */
//    public static class JData extends BaseResp {
//        /**
//         * 构造方法
//         *
//         * @param resp resp
//         */
//        public JData(JsonResp resp) {
//            super(resp);
//            resp.data = new HashMap<String, Object>();
//        }
//
//        /**
//         * 增加一个map的内容到数据对象中.
//         *
//         * @param data map内容
//         * @return 返回该响应对象.
//         */
//        public JData addAll(Map<String, Object> data) {
//            Preconditions.checkNotNull(resp.data, "data不能为空");
//            if (resp.data instanceof Map) {
//                ((Map) resp.data).putAll(data);
//            } else {
//                Preconditions.checkArgument(false, "无效的参数类型");
//            }
//            return this;
//        }
//
//        /**
//         * 增加一个kv对到数据对象中.
//         *
//         * @param key   key
//         * @param value value
//         * @return 返回该响应对象.
//         */
//        public JData add(String key, Object value) {
//            Preconditions.checkNotNull(resp.data, "data不能为空");
//            if (resp.data instanceof Map) {
//                ((Map) resp.data).put(key, value);
//            } else {
//                Preconditions.checkArgument(false, "无效的参数类型");
//            }
//            return this;
//        }
//    }
//}
