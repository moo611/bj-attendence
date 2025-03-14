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

 Date: 14/03/2025 12:33:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dk_user
-- ----------------------------
DROP TABLE IF EXISTS `dk_user`;
CREATE TABLE `dk_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dk_user
-- ----------------------------
INSERT INTO `dk_user` VALUES (1, 'admin', '$2a$10$wkgmZWGyGtBWmn/9NUjTT.xc9EOoo81unEkZS8dr0UTF1OvOJttXi', '管理员', '0', '0', '2025-03-13 16:28:54', NULL, NULL, NULL);
INSERT INTO `dk_user` VALUES (2, 'user1', '$2a$10$1JK289kZbEWN0On3uB1Uw.owDP6xm/n.OGFxAbnaJjXI/EEzMYEVu', '小李', '1', '0', '2025-03-14 10:36:31', NULL, NULL, NULL);
INSERT INTO `dk_user` VALUES (3, 'user2', '$2a$10$iOrKChDR6xkQAKt9NsOFNuTfxDhQyoktjWSDKbZlxcJsUL2F/cIAy', '小张', '1', '0', '2025-03-14 11:53:47', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
