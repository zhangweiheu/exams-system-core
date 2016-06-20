/*
Navicat MySQL Data Transfer

Source Server         : pc
Source Server Version : 50629
Source Host           : 192.168.1.115:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-06-15 13:26:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT '' COMMENT '考试主题',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户 id',
  `mongo_paper_id` int(11) NOT NULL DEFAULT '0' COMMENT 'mongo试卷 id',
  `is_exam` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '枚举 ：0练习卷 | 1考试卷',
  `paper_type` tinyint(1) unsigned DEFAULT '0' COMMENT '试卷类型,枚举：0单选题 | 1多选题 | 2编程题 | 3单选、多选 | 4单选、编程 | 5多选、编程 | 6单选多选和编程题',
  `difficulty` double(4,0) DEFAULT NULL COMMENT '难度系数0-10',
  `total_right` int(3) unsigned zerofill DEFAULT '000' COMMENT '总做对题数',
  `total_points` double(11,0) unsigned zerofill DEFAULT '00000000000' COMMENT '总分',
  `score` double(11,0) unsigned zerofill DEFAULT '00000000000' COMMENT '得分',
  `status` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '状态：0正常 | 1删除 | 2有错误 | 3已关闭',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`,`mongo_paper_id`,`paper_type`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('50', '', '13', '57', '0', '6', '0', '004', '00000000000', '00000000039', '3', '2016-03-21 19:10:16', '2016-03-23 10:56:20');
INSERT INTO `paper` VALUES ('51', '', '13', '58', '0', '6', '0', '000', '00000000000', '00000000000', '3', '2016-03-23 10:58:05', '2016-03-23 14:33:15');
INSERT INTO `paper` VALUES ('52', '', '13', '59', '0', '6', '0', '002', '00000000000', '00000000002', '3', '2016-04-06 16:14:29', '2016-04-07 14:23:26');
INSERT INTO `paper` VALUES ('53', '', '13', '60', '0', '6', '0', '002', '00000000000', '00000000002', '1', '2016-05-11 13:41:48', '2016-05-11 20:59:48');
INSERT INTO `paper` VALUES ('54', '', '13', '61', '0', '6', '0', '000', '00000000000', '00000000000', '3', '2016-05-17 15:19:31', '2016-05-17 15:19:31');
INSERT INTO `paper` VALUES ('55', '', '13', '62', '0', '6', '0', '000', '00000000000', '00000000000', '3', '2016-05-18 00:13:16', '2016-05-18 00:13:16');
INSERT INTO `paper` VALUES ('56', '', '13', '63', '0', '6', '0', '000', '00000000000', '00000000000', '3', '2016-05-21 23:28:59', '2016-05-23 17:28:25');
INSERT INTO `paper` VALUES ('57', '', '35', '64', '0', '6', '0', '009', '00000000000', '00000000011', '3', '2016-05-22 09:31:20', '2016-05-22 11:09:07');
INSERT INTO `paper` VALUES ('58', '', '35', '69', '0', '6', '0', '005', '00000000000', '00000000006', '3', '2016-05-22 11:21:38', '2016-05-22 11:21:38');
INSERT INTO `paper` VALUES ('59', '', '35', '73', '0', '6', '5', '003', '00000000000', '00000000004', '0', '2016-05-22 12:11:32', '2016-05-22 12:19:32');
INSERT INTO `paper` VALUES ('60', '', '13', '74', '0', '6', '6', '006', '00000000000', '00000000042', '3', '2016-05-23 17:29:26', '2016-05-23 17:29:26');
INSERT INTO `paper` VALUES ('61', '', '13', '75', '0', '6', '6', '000', '00000000000', '00000000000', '0', '2016-05-26 14:49:38', '2016-05-26 14:49:38');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `question_type` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '试题类型，枚举：0单选 | 1多选 | 2编程题',
  `title` varchar(1500) DEFAULT '' COMMENT '试题主干',
  `options` varchar(1500) DEFAULT '' COMMENT '试题选项',
  `answers` varchar(50) DEFAULT '' COMMENT '试题答案， 编程题：test_case的id；',
  `difficulty` tinyint(4) unsigned DEFAULT '5' COMMENT '难度系数1-10',
  `priority` tinyint(4) unsigned DEFAULT '5' COMMENT '优先级1-10',
  `status` tinyint(1) DEFAULT '0' COMMENT '题目状态，枚举：0正常 | 1已删除 | 2有错误',
  `total_done` int(11) DEFAULT '0' COMMENT '总完成数',
  `total_success` int(11) DEFAULT '0' COMMENT '总正确数',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('14', '0', '在Java中，负责对字节代码解释执行的是：', '{\"A\":\"应用服务器\",\"B\":\"虚拟机\",\"C\":\"垃圾回收器\",\"D\":\"编译器\"}', 'B', '6', '6', '0', '11', '7', '2016-03-21 16:54:31', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('15', '0', '要想在你的视图上成功的执行查询需要做什么？', '{\"A\":\"只能在基础表中有select权限\",\"B\":\"在视图中需要有select权限\",\"C\":\"基础表中必须有数据\",\"D\":\"基础表必须在同一个 用户模式中\"}', 'B', '5', '5', '0', '15', '7', '2016-03-21 16:56:15', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('16', '0', '关于MVC,下面说法正确的是：', '{\"A\":\"Servlet实现MVC的Model部分\",\"B\":\"EJB实现MVC的Model部分\",\"C\":\"Http实现MVC的View部分\",\"D\":\"JSP实现MVC的Control部分\"}', 'B', '7', '6', '0', '12', '10', '2016-03-21 16:57:36', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('18', '0', '下面哪个Set是排序的？', '{\"A\":\"LinkedHashSet\",\"B\":\"HashSet\",\"C\":\"AbstractSet\",\"D\":\"TreeSet\"}', 'A', '7', '7', '0', '12', '4', '2016-03-21 17:00:24', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('19', '0', '类的实例方法表示的是什么？', '{\"A\":\"父类对象的行为\",\"B\":\"类的属性\",\"C\":\"类对象的行为\",\"D\":\"类的行为\"}', 'C', '6', '5', '0', '10', '7', '2016-03-21 17:01:19', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('20', '0', '下面说法正确的是', '{\"A\":\"JAVA中线程是非抢占式的\",\"B\":\"JAVA中的线程不可以共享数据\",\"C\":\"每个JAVA程序都至少有一个线程，即主线程\",\"D\":\"JAVA中的线程不可以共享代码\"}', 'C', '4', '4', '0', '10', '4', '2016-03-21 17:02:38', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('21', '1', '评估下面的一组SQL语句: CREATE TABLE dept (deptno NUMBER(2), dname VARCNAR2(14), 1oc VARCNAR2 (13)); ROLLBACK; DESCRIBE DEPT 下面关于该组语句的哪个描述是错误的？', '{\"A\":\"DESCRIBE DEPT语句将显示DEPT表的结构描述内容\",\"B\":\"DESCRIBE DEPT语句将只有在ROLLBACK之前引入一个COMMIT语句时，才会显示DEPT表的结构描述内容\",\"C\":\"ROLLBACK语句将释放DEPT占用的存储空间\",\"D\":\"DESCRIBE DEPT语句将返回一个错误ORA-04043: object DEPT does not exist.\"}', 'BCD', '6', '6', '0', '12', '5', '2016-03-21 17:04:38', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('22', '0', 'TCP协议在每次建立或拆除连接时，都要在收发双方之间交换_________ 报文。', '{\"A\":\"一个\",\"B\":\"四个\",\"C\":\"三个\",\"D\":\"两个\"}', 'C', '5', '5', '0', '3', '1', '2016-03-21 17:06:19', '2016-04-07 19:12:34');
INSERT INTO `question` VALUES ('23', '1', '网络操作系统和分布式操作系统的主要区别是（）', '{\"A\":\"是否连接多台计算机\",\"B\":\"计算机之间能否通信\",\"C\":\"网上资源能否共享\",\"D\":\"各台计算机有没有主次之分\"}', 'C', '5', '5', '0', '9', '4', '2016-03-21 17:07:44', '2016-04-07 19:18:55');
INSERT INTO `question` VALUES ('24', '0', '在操作系统中，Wait(s)和Signal(s)操作是一种', '{\"A\":\"机器指令\",\"B\":\"作业控制命令\",\"C\":\"系统调用命令\",\"D\":\"低级进程通信原语\"}', 'D', '5', '5', '0', '1', '1', '2016-03-21 17:09:01', '2016-04-07 19:18:18');
INSERT INTO `question` VALUES ('25', '1', '执行下面代码,下面描述不正确的是： public class Person{    static int arr[] = new int[10];    public static void main(String a[]){      System.out.println(arr[1]);    } }', '{\"A\":\"产生编译错误\",\"B\":\"输出空\",\"C\":\"编译正确,运行错误\",\"D\":\"输出0\"}', 'ABC', '6', '6', '0', '12', '6', '2016-03-21 17:11:29', '2016-05-23 17:55:29');
INSERT INTO `question` VALUES ('26', '2', '打印出所有的\"水仙花数\"，所谓\"水仙花数\"是指一个三位数，其各位数字立方和等于该数本身。例如： 153是一个\"水仙花数\"，因为153=1的三次方＋5的三次方＋3的三次方。', '无', '56', '9', '9', '0', '7', '2', '2016-03-21 17:28:49', '2016-05-23 17:55:29');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ref_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联 id',
  `ref_type` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '关联类型，枚举：0用户 | 1试题 | 2试卷',
  `tag_value` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT 'tag value： 0java | 1html | 2操作系统｜３计算机网络｜４ＣＳＳ',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_tag` (`ref_id`,`ref_type`,`tag_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('80', '21', '1', '7', '2016-03-21 17:04:38', '2016-03-21 17:04:38');
INSERT INTO `tag` VALUES ('81', '22', '1', '3', '2016-03-21 17:06:19', '2016-03-21 17:06:19');
INSERT INTO `tag` VALUES ('82', '23', '1', '2', '2016-03-21 17:07:44', '2016-03-21 17:07:44');
INSERT INTO `tag` VALUES ('83', '23', '1', '3', '2016-03-21 17:07:44', '2016-03-21 17:07:44');
INSERT INTO `tag` VALUES ('84', '24', '1', '2', '2016-03-21 17:09:01', '2016-03-21 17:09:01');
INSERT INTO `tag` VALUES ('85', '25', '1', '0', '2016-03-21 17:11:29', '2016-03-21 17:11:29');
INSERT INTO `tag` VALUES ('86', '26', '1', '0', '2016-03-21 17:28:55', '2016-03-21 17:28:55');
INSERT INTO `tag` VALUES ('87', '50', '2', '0', '2016-03-21 19:10:16', '2016-03-21 19:10:16');
INSERT INTO `tag` VALUES ('88', '51', '2', '0', '2016-03-23 10:58:06', '2016-03-23 10:58:06');
INSERT INTO `tag` VALUES ('89', '51', '2', '6', '2016-03-23 10:58:06', '2016-03-23 10:58:06');
INSERT INTO `tag` VALUES ('90', '52', '2', '0', '2016-04-06 16:14:30', '2016-04-06 16:14:30');
INSERT INTO `tag` VALUES ('92', '53', '2', '0', '2016-05-11 13:41:48', '2016-05-11 13:41:48');
INSERT INTO `tag` VALUES ('95', '18', '1', '0', '2016-05-11 21:07:20', '2016-05-11 21:07:20');
INSERT INTO `tag` VALUES ('96', '18', '1', '4', '2016-05-11 21:07:20', '2016-05-11 21:07:20');
INSERT INTO `tag` VALUES ('107', '19', '1', '0', '2016-05-11 21:36:05', '2016-05-11 21:36:05');
INSERT INTO `tag` VALUES ('108', '19', '1', '4', '2016-05-11 21:36:05', '2016-05-11 21:36:05');
INSERT INTO `tag` VALUES ('123', '16', '1', '0', '2016-05-11 21:45:20', '2016-05-11 21:45:20');
INSERT INTO `tag` VALUES ('124', '16', '1', '5', '2016-05-11 21:45:20', '2016-05-11 21:45:20');
INSERT INTO `tag` VALUES ('125', '20', '1', '0', '2016-05-11 21:49:59', '2016-05-11 21:49:59');
INSERT INTO `tag` VALUES ('126', '20', '1', '4', '2016-05-11 21:49:59', '2016-05-11 21:49:59');
INSERT INTO `tag` VALUES ('127', '15', '1', '0', '2016-05-11 21:50:31', '2016-05-11 21:50:31');
INSERT INTO `tag` VALUES ('128', '15', '1', '2', '2016-05-11 21:50:31', '2016-05-11 21:50:31');
INSERT INTO `tag` VALUES ('129', '14', '1', '0', '2016-05-11 21:50:43', '2016-05-11 21:50:43');
INSERT INTO `tag` VALUES ('130', '20', '0', '0', '2016-05-11 21:57:19', '2016-05-11 21:57:19');
INSERT INTO `tag` VALUES ('131', '20', '0', '4', '2016-05-11 21:57:20', '2016-05-11 21:57:20');
INSERT INTO `tag` VALUES ('135', '13', '0', '0', '2016-05-11 21:57:48', '2016-05-11 21:57:48');
INSERT INTO `tag` VALUES ('136', '19', '0', '0', '2016-05-11 21:58:04', '2016-05-11 21:58:04');
INSERT INTO `tag` VALUES ('137', '19', '0', '4', '2016-05-11 21:58:04', '2016-05-11 21:58:04');
INSERT INTO `tag` VALUES ('142', '22', '0', '0', '2016-05-11 22:00:24', '2016-05-11 22:00:24');
INSERT INTO `tag` VALUES ('143', '22', '0', '4', '2016-05-11 22:00:25', '2016-05-11 22:00:25');
INSERT INTO `tag` VALUES ('144', '54', '2', '0', '2016-05-17 15:19:31', '2016-05-17 15:19:31');
INSERT INTO `tag` VALUES ('145', '55', '2', '0', '2016-05-18 00:13:16', '2016-05-18 00:13:16');
INSERT INTO `tag` VALUES ('146', '55', '2', '1', '2016-05-18 00:13:16', '2016-05-18 00:13:16');
INSERT INTO `tag` VALUES ('147', '56', '2', '0', '2016-05-21 23:28:59', '2016-05-21 23:28:59');
INSERT INTO `tag` VALUES ('148', '56', '2', '4', '2016-05-21 23:28:59', '2016-05-21 23:28:59');
INSERT INTO `tag` VALUES ('149', '35', '0', '0', '2016-05-22 09:15:55', '2016-05-22 09:15:55');
INSERT INTO `tag` VALUES ('150', '35', '0', '5', '2016-05-22 09:15:55', '2016-05-22 09:15:55');
INSERT INTO `tag` VALUES ('151', '35', '0', '6', '2016-05-22 09:15:55', '2016-05-22 09:15:55');
INSERT INTO `tag` VALUES ('152', '57', '2', '0', '2016-05-22 09:31:20', '2016-05-22 09:31:20');
INSERT INTO `tag` VALUES ('153', '57', '2', '5', '2016-05-22 09:31:21', '2016-05-22 09:31:21');
INSERT INTO `tag` VALUES ('154', '57', '2', '7', '2016-05-22 09:31:21', '2016-05-22 09:31:21');
INSERT INTO `tag` VALUES ('155', '58', '2', '0', '2016-05-22 11:21:59', '2016-05-22 11:21:59');
INSERT INTO `tag` VALUES ('156', '58', '2', '7', '2016-05-22 11:21:59', '2016-05-22 11:21:59');
INSERT INTO `tag` VALUES ('157', '59', '2', '0', '2016-05-22 12:12:07', '2016-06-13 17:21:28');
INSERT INTO `tag` VALUES ('158', '59', '2', '1', '2016-05-22 12:12:07', '2016-05-22 12:12:07');
INSERT INTO `tag` VALUES ('159', '60', '2', '0', '2016-05-23 17:29:26', '2016-05-23 17:29:26');
INSERT INTO `tag` VALUES ('160', '60', '2', '7', '2016-05-23 17:29:26', '2016-05-23 17:29:26');
INSERT INTO `tag` VALUES ('161', '61', '2', '0', '2016-05-26 14:49:38', '2016-05-26 14:49:38');
INSERT INTO `tag` VALUES ('162', '61', '2', '3', '2016-05-26 14:49:38', '2016-05-26 14:49:38');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `type` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '用户类型：0普通用户 | 1管理员 | 2系统管理员',
  `status` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '状态:0未审核，1：审核不通过，2审核通过，3已删除，4黑名单',
  `avatar` varchar(50) DEFAULT '' COMMENT '头像',
  `intro` varchar(50) DEFAULT '' COMMENT '简介',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号',
  `wechat` varchar(11) DEFAULT '' COMMENT '微信号',
  `total_score` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '总得分',
  `total_done` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '总题量',
  `average_score` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '平均得分',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`email`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', 'zhangwei', '287740f40653c8ff4504515c9fca81dc', '2', '2', '', 'zwtest13', '1562282234@qq.com', '15663461691', 'zhangwei', '00000000042', '00000000001', '00000000000', '2016-05-03 19:25:14', '2016-05-26 15:03:18');
INSERT INTO `user` VALUES ('19', 'root', 'e26b87ff21019fb0c21a8459c49e50cd', '1', '2', null, 'zw', '1562282234@qq.com', '15663461691', 'zw', '00000000000', '00000000000', '00000000000', '2016-05-11 20:40:39', '2016-05-17 19:51:55');
INSERT INTO `user` VALUES ('20', 'zw', 'e4227a7bf62979a0d1f4e5bc95fa6fc6', '0', '2', null, 'zwtest', '1562282234@qq.com', '15663461691', 'zw', '00000000000', '00000000000', '00000000000', '2016-05-11 20:46:15', '2016-05-17 19:51:56');
INSERT INTO `user` VALUES ('28', 'www', '4eae35f1b35977a00ebd8086c259d4c9', '0', '0', null, '111', '1562282234@qq.com', '15663461691', '1213', '00000000000', '00000000000', null, '2016-05-17 21:35:16', '2016-05-22 11:05:01');
INSERT INTO `user` VALUES ('29', 'wwww', 'e34a8899ef6468b74f8a1048419ccc8b', '0', '0', null, '111', '1562282234@qq.com', '15663461691', '1213', '00000000000', '00000000000', null, '2016-05-17 21:40:03', '2016-05-22 11:05:01');
INSERT INTO `user` VALUES ('30', 'q', '7694f4a66316e53c8cdd9d9954bd611d', '0', '0', null, '111', '1562282234@qq.com', '15663461691', '111', '00000000000', '00000000000', null, '2016-05-17 21:40:54', '2016-05-22 11:05:02');
INSERT INTO `user` VALUES ('31', 'wq', '2c204d849495890a8fad6b44ee78ac73', '0', '0', null, '123', '123@qq.com', '15663461691', '1213', '00000000000', '00000000000', null, '2016-05-17 21:42:43', '2016-05-22 11:05:03');
INSERT INTO `user` VALUES ('32', 'zwzwzw', 'a1555463c361e7036a274a8b44e29192', '0', '0', null, '', '1562282234@qq.com', '15663461691', '1213', '00000000000', '00000000000', null, '2016-05-17 21:44:49', '2016-05-22 11:05:04');
INSERT INTO `user` VALUES ('35', 'ceshi', 'cc17c30cd111c7215fc8f51f8790e0e1', '0', '2', null, '这是测试', '1562282234@qq.com', '15663461691', 'weixin', '00000000019', '00000000003', null, '2016-05-22 00:00:38', '2016-05-22 12:12:49');
