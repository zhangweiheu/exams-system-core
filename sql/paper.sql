/*
Navicat MySQL Data Transfer

Source Server         : zhangweiheu.cn_3306
Source Server Version : 50542
Source Host           : zhangweiheu.cn:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2016-02-09 21:40:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户 id',
  `paper_id` int(11) NOT NULL DEFAULT '0' COMMENT '试卷 id',
  `paper_type` tinyint(4) DEFAULT '0' COMMENT '试卷类型,枚举：',
  `difficulty` tinyint(4) DEFAULT NULL COMMENT '难度系数0-10',
  `total_points` int(11) DEFAULT '0' COMMENT '总分',
  `score` int(11) DEFAULT '0' COMMENT '得分',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态，枚举：',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`,`paper_id`,`paper_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
