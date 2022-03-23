/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 19/03/2022 18:35:05
*/

SET NAMES utf8mb4;
-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `ratio` int DEFAULT NULL COMMENT '任务占比',
  `is_finish` tinyint(1) DEFAULT '0' COMMENT '是否完成',
  `is_open_comment` tinyint(1) DEFAULT '0' COMMENT '是否开启总评',
  `is_qualified` tinyint(1) DEFAULT '0' COMMENT '是否合格',
  `sid` int DEFAULT NULL COMMENT '学生id',
  `tid` int DEFAULT NULL COMMENT '老师id',
  `score` int DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='任务表';

-- ----------------------------
-- Records of task
-- ----------------------------
BEGIN;
INSERT INTO `task` VALUES (19, '2022-03-17 09:51:31', '2022-03-17 09:51:31', '任务1', 80, 0, 1, 0, 5, 4, 454);
INSERT INTO `task` VALUES (20, '2022-03-17 09:51:31', '2022-03-17 09:51:31', '任务1', 80, 1, 1, 0, 7, 4, 454);
INSERT INTO `task` VALUES (27, '2022-03-18 22:25:39', '2022-03-18 22:25:39', '任务2', 20, 1, 1, 0, 5, 2, 454);
INSERT INTO `task` VALUES (28, '2022-03-18 22:25:39', '2022-03-18 22:25:39', '任务2', 20, 1, 1, 0, 7, 2, 454);
INSERT INTO `task` VALUES (29, '2022-03-18 22:29:59', '2022-03-18 22:29:59', '12', 22, 0, 1, 0, 5, 2, 454);
INSERT INTO `task` VALUES (30, '2022-03-18 22:29:59', '2022-03-18 22:29:59', '12', 22, 0, 1, 0, 7, 2, 454);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `no` varchar(50) DEFAULT NULL COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `gender` int DEFAULT NULL COMMENT '性别',
  `role_type` int DEFAULT NULL COMMENT '所属角色（1-管理员，2-老师，3-学生）',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '6', '管理员', 'admin', 1, 1, '666', '2022-03-13 13:39:26', '2022-03-19 12:46:21');
INSERT INTO `user` VALUES (2, '123', '老师2', 't2', 1, 2, '123', '2022-03-15 23:40:20', '2022-03-16 22:02:14');
INSERT INTO `user` VALUES (4, '22', '老师1', 't1', 1, 2, '123', '2022-03-15 23:42:09', '2022-03-16 22:37:48');
INSERT INTO `user` VALUES (5, '133', '学生1', 's1', 1, 3, '123', '2022-03-16 21:07:27', '2022-03-17 09:29:50');
INSERT INTO `user` VALUES (7, '22', '学生2', 's2', 1, 3, '123', '2022-03-16 22:53:06', '2022-03-16 22:53:06');
INSERT INTO `user` VALUES (8, '1', 'qwq', 'q1', 1, 1, '12', '2022-03-17 09:17:06', '2022-03-17 09:17:06');
COMMIT;