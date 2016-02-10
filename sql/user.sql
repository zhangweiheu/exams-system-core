/*
Navicat MySQL Data Transfer

Source Server         : zhangweiheu.cn_3306
Source Server Version : 50542
Source Host           : zhangweiheu.cn:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2016-02-09 21:42:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(30) NOT NULL DEFAULT '' COMMENT '密码',
  `avatar` varchar(40) DEFAULT NULL COMMENT '头像',
  `intro` varchar(50) DEFAULT NULL COMMENT '简介',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `wechat` varchar(11) DEFAULT NULL COMMENT '微信',
  `total_score` int(11) DEFAULT NULL,
  `total_done` int(11) DEFAULT NULL,
  `average_score` int(11) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`email`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
