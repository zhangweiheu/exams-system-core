/*
Navicat MySQL Data Transfer

Source Server         : pc
Source Server Version : 50629
Source Host           : 192.168.1.115:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-03-14 09:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户 id',
  `mongo_paper_id` int(11) NOT NULL DEFAULT '0' COMMENT 'mongo试卷 id',
  `paper_type` tinyint(4) unsigned DEFAULT '0' COMMENT '试卷类型,枚举：0单选题 | 1多选题 | 2编程题 | 3单选、多选 | 4单选、编程 | 5多选、编程',
  `difficulty` tinyint(4) DEFAULT NULL COMMENT '难度系数0-10',
  `total_points` int(11) DEFAULT '0' COMMENT '总分',
  `score` int(11) DEFAULT '0' COMMENT '得分',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态：0正常 | 1删除 | 2有错误',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`,`mongo_paper_id`,`paper_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `question_type` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '试题类型，枚举：0单选 | 1多选 | 2编程题',
  `title` varchar(11) DEFAULT '' COMMENT '试题主干',
  `options` varchar(11) DEFAULT '' COMMENT '试题选项',
  `answers` varchar(11) DEFAULT '' COMMENT '试题答案， 编程题：test_case的id；',
  `difficulty` tinyint(4) unsigned DEFAULT '5' COMMENT '难度系数1-10',
  `priority` tinyint(4) unsigned DEFAULT '5' COMMENT '优先级1-10',
  `status` tinyint(4) DEFAULT '0' COMMENT '题目状态，枚举：0正常 | 1已删除 | 2有错误',
  `total_done` int(11) DEFAULT '0' COMMENT '总完成数',
  `total_success` int(11) DEFAULT '0' COMMENT '总正确数',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `question_index` (`question_type`,`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ref_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联 id',
  `ref_type` tinyint(4) unsigned zerofill NOT NULL DEFAULT '0000' COMMENT '关联类型，枚举：0用户 | 1试题 | 2试卷',
  `tag_value` tinyint(4) unsigned zerofill NOT NULL DEFAULT '0000' COMMENT 'tag value： 0java | 1html | 2操作系统｜３计算机网络｜４ＣＳＳ',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_tag` (`ref_id`,`ref_type`,`tag_value`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `is_admin` tinyint(4) unsigned zerofill NOT NULL DEFAULT '0000' COMMENT '身份标识，普通用户：0|管理员：1',
  `is_delete` tinyint(4) unsigned zerofill DEFAULT '0000' COMMENT '是否删除',
  `avatar` varchar(40) DEFAULT NULL COMMENT '头像',
  `intro` varchar(50) DEFAULT NULL COMMENT '简介',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `wechat` varchar(11) DEFAULT NULL COMMENT '微信号',
  `total_score` int(11) DEFAULT NULL COMMENT '总得分',
  `total_done` int(11) DEFAULT NULL COMMENT '总题量',
  `average_score` int(11) DEFAULT NULL COMMENT '平均得分',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`email`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangwei', '287740f40653c8ff4504515c9fca81dc', '0001', '0000', null, null, 'zhangweiheu@gmail.com', null, null, null, null, null, '0000-00-00 00:00:00', '2016-03-10 16:42:46');
INSERT INTO `user` VALUES ('2', '1111', 'b59c67bf196a4758191e42f76670ceba', '0001', '0000', 'eee', null, '1562282234@qq.com', null, null, null, null, null, '0000-00-00 00:00:00', '2016-03-10 16:42:47');
INSERT INTO `user` VALUES ('3', '111111', 'werew', '0000', '0000', null, '', '', '', '', null, null, null, '0000-00-00 00:00:00', '2016-03-10 16:42:47');
INSERT INTO `user` VALUES ('4', 'zhang', 'wei', '0000', '0000', null, '', '', '', '', null, null, null, '0000-00-00 00:00:00', '2016-03-10 16:42:48');
INSERT INTO `user` VALUES ('11', '1111112', '21432', '0000', '0000', null, '', '', '2342332', '', null, null, null, '0000-00-00 00:00:00', '2016-03-10 16:42:52');
