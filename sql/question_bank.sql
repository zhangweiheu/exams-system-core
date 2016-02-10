/*
Navicat MySQL Data Transfer

Source Server         : zhangweiheu.cn_3306
Source Server Version : 50542
Source Host           : zhangweiheu.cn:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2016-02-09 21:41:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(4) DEFAULT '0' COMMENT '试题类型，枚举：0用户 | 1试题',
  `title` varchar(11) DEFAULT '' COMMENT '试题标题',
  `options` varchar(11) DEFAULT '' COMMENT '试题选项',
  `answers` varchar(11) DEFAULT '' COMMENT '试题答案',
  `difficulty` tinyint(4) DEFAULT '0' COMMENT '难度系数0-10',
  `priority` tinyint(4) DEFAULT '0' COMMENT '优先级0-10',
  `status` tinyint(4) DEFAULT '0' COMMENT '题目状态，枚举：',
  `total_done` int(11) DEFAULT '0' COMMENT '总完成数',
  `total_success` int(11) DEFAULT '0' COMMENT '总正确数',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
