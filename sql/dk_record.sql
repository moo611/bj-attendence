/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/03/2025 13:11:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dk_record
-- ----------------------------
DROP TABLE IF EXISTS `dk_record`;
CREATE TABLE `dk_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `check_in_time` datetime NULL DEFAULT NULL,
  `check_out_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dk_record
-- ----------------------------
INSERT INTO `dk_record` VALUES (1, NULL, '2025-03-14 11:52:52', '2025-03-14 11:53:20', '0', '2025-03-14 11:52:52', 'user1', '2025-03-14 11:53:20', 'user1');
INSERT INTO `dk_record` VALUES (2, NULL, '2025-03-14 11:55:23', '2025-03-14 11:55:25', '0', '2025-03-14 11:55:23', 'user2', '2025-03-14 11:55:25', 'user2');

SET FOREIGN_KEY_CHECKS = 1;
