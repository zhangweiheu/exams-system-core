/*
Navicat MySQL Data Transfer

Source Server         : zhangweiheu.cn_3306
Source Server Version : 50542
Source Host           : zhangweiheu.cn:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2016-02-09 21:42:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ref_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联 id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'tag类型，枚举：0用户 | 1试题 | 2Java 试题',
  `content` varchar(11) NOT NULL DEFAULT '' COMMENT '标签内容',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
