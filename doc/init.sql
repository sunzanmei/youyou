CREATE DATABASE `youyou` ;

use youyou;

create TABLE customer(
id int not null PRIMARY KEY auto_increment comment '主键',
login_name VARCHAR(20) not null comment '登录名',
password VARCHAR(20) not null comment '密码',
role tinyint not null comment '角色 0:nomal costomer 1:manager',
cus_status tinyint not null comment '状态 0:regist and apply 1:approve and online',
gmt_created datetime not null default now() comment '创建时间',
gmt_modified datetime not null default now() comment '修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';


create TABLE customer_extension(
id int not null PRIMARY KEY auto_increment comment '主键',
customer_id int not null comment '用户id',
nick_name VARCHAR(50) not null comment '昵称',
real_name VARCHAR(50) not null comment '真实姓名',
sex tinyint  not null comment '性别',
birthday date  not null comment '出生日期',
phone_num varchar(15) not null default '' comment '手机号',
weixin_num varchar(15) not null default '' comment '微信号',
home_town int  not null default 0 comment '祖籍',
residence int  not null comment '现居地',
single boolean  not null default true comment '是否单身',
self_introduce varchar(500) not null comment '自我描述',
image_url varchar(100) not null default '' comment '图片地址',
tags varchar(20) not null default '' comment '标签',
gmt_created datetime not null default now() comment '创建时间',
gmt_modified datetime not null default now() comment '修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户扩展表';