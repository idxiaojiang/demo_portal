/*
Navicat MySQL Data Transfer

Source Server         : notedb
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : portaldb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-23 01:02:10
*/

SET FOREIGN_KEY_CHECKS=0;

/**
 * 系统配置表
 */
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `attribute_key` varchar(20) NOT NULL COMMENT '属性key',
  `attribute_value` varchar(100) NOT NULL COMMENT '属性value',
  `attribute_module` varchar(20) NOT NULL COMMENT '属性所属模块',
  `attribute_enable` varchar(10) NOT NULL COMMENT '是否启用true/false',
  `environment` varchar(10) NOT NULL COMMENT '系统环境，all/dev/sit/pro',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`attribute_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * 用户账号信息表
 */
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `account` varchar(255) NOT NULL COMMENT '用户账号，系统生成，外部使用',
  `user_id` int(11) NOT NULL COMMENT '用户id系统生成，内部使用',
  `user_name` varchar(255) NOT NULL COMMENT '用户昵称',
  `register_phone` int(11) DEFAULT NULL COMMENT '手机号码',
  `register_way` varchar(255) NOT NULL COMMENT '注册方式：qq,wx,weibo,account,phone,mail',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码MD5',
  `register_date` datetime DEFAULT NULL COMMENT '注册日期',
  `register_qq` varchar(255) DEFAULT NULL COMMENT '注册的QQ号',
  `register_wx` varchar(255) DEFAULT NULL COMMENT '注册的微信号',
  `register_mail` varchar(255) DEFAULT NULL COMMENT '注册邮箱地址',
  `register_weibo` varchar(255) DEFAULT NULL COMMENT '注册的微博账号',
  `created_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`account`,`user_id`,`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * 笔记详情表
 */
DROP TABLE IF EXISTS `t_note_detail`;
CREATE TABLE `t_note_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `row_id` varchar(100) NOT NULL COMMENT '业务id',
  `title` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `comment_num` int(10) DEFAULT '0' COMMENT '评论数',
  `read_num` int(10) DEFAULT '0',
  `module` varchar(10) DEFAULT NULL COMMENT '所属模块',
  `note_type` varchar(10) DEFAULT NULL COMMENT '笔记类型',
  `note_state` char(5) DEFAULT NULL COMMENT '状态（100：草稿；200：发表中;300：不公开；400：删除）',
  `flow_state` char(5) DEFAULT NULL COMMENT '流程状态（100:审核中；200：审核通过；300：驳回）',
  `content_html` longtext NOT NULL COMMENT 'html内容',
  `content_text` longtext NOT NULL COMMENT '文字内容',
  `coverImage_url` varchar(100) DEFAULT NULL COMMENT '封面图URL',
  `create_userid` varchar(15) DEFAULT NULL COMMENT '创建人userid',
  `created_date` datetime DEFAULT NULL,
  `last_update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

