/*
 Navicat Premium Data Transfer

 Source Server         : EXP1
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mypage

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 16/11/2019 15:05:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `head_img` varchar(2083) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像（文件位置url）',
  `account_type` tinyint(4) NOT NULL COMMENT '账户类型(0：管理员/1：个人用户/2:团体用户）',
  `safe_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '安全邮箱（用于找回密码）',
  `account_status` tinyint(4) NOT NULL COMMENT '账户状态（0：正常/1：封停/2：冻结）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `safe_email`(`safe_email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_follower
-- ----------------------------
DROP TABLE IF EXISTS `user_follower`;
CREATE TABLE `user_follower`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `subject_user_id` bigint(20) NOT NULL COMMENT '关注者编号',
  `object_user_id` bigint(20) NOT NULL COMMENT '被关注者编号',
  `user_group_id` bigint(20) NOT NULL COMMENT '分组编号',
  `follow_status` bit(1) NOT NULL COMMENT '关注状态（0：单向关注/1：双向关注）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `subject_user_id`(`subject_user_id`) USING BTREE,
  INDEX `object_user_id`(`object_user_id`) USING BTREE,
  INDEX `user_group_id`(`user_group_id`) USING BTREE,
  CONSTRAINT `user_follower_ibfk_1` FOREIGN KEY (`subject_user_id`) REFERENCES `user_base` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_follower_ibfk_2` FOREIGN KEY (`object_user_id`) REFERENCES `user_base` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_follower_ibfk_3` FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '所属用户编号',
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分组名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_base` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '性别（0：男/1:女）',
  `birth_year` year NULL DEFAULT NULL COMMENT '出生年份',
  `home_province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家乡-省份',
  `home_city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家乡-城市',
  `live_province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地-省份',
  `live_city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地-城市',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `enrollment_year` year NULL DEFAULT NULL COMMENT '入学年份（YYYY）',
  `work_status` bit(1) NULL DEFAULT NULL COMMENT '工作状态（0：在读/1：工作）',
  `emotion_status` bit(1) NULL DEFAULT NULL COMMENT '情感状态（0：单身/1：非单身）',
  `head_img` varchar(2083) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_label
-- ----------------------------
DROP TABLE IF EXISTS `user_label`;
CREATE TABLE `user_label`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `label_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签内容',
  `label_type` tinyint(4) NULL DEFAULT NULL COMMENT '标签类型（0：性格/1：兴趣/2：技能）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_label_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_base` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
