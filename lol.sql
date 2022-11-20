/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : 119.23.240.15:3306
 Source Schema         : lol

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 18/11/2022 01:26:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` int(11) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `context` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES (1, 2171407, '2022-11-12', 'Products', 'Meng', 'The star orbits the black hole at about the same distance as Earth orbits the sun.\r\n\r\nKareem El-Badry is an astrophysicist with the Harvard-Smithsonian Center for Astrophysics and Germany\'s Max Planck Institute for Astronomy. He was the lead writer of a study describing the discovery in Monthly Notices of the Royal Astronomical Society.\r\n\r\nThe black hole was first identified using the European Space Agency\'s (ESA) Gaia spacecraft. Gaia has already discovered more than 800,000 multi-star systems. El-Badry and his team then sought to confirm the discovery through numerous additional observations over a period of four months. This effort involved six different highly sensitive telescopes across the world.\r\n\r\nOne was the 6.5-meter Magellan Baade telescope, based at the Las Campanas Observatory in Chile. The team also used an instrument on the Gemini North telescope, which is based in Hawaii.\r\n\r\nThe researchers needed such telescopes to effectively observe the orbital motion of the black hole\'s star. The telescope in Chile and the Gemini instrument were able to provide the astronomers with high-resolution images. The telescopes also collected sensitive data on ultraviolet and near-infrared wavelengths.\r\n\r\nEl-Badry said in a statement the Gemini observations \"confirmed beyond a reasonable doubt\" that the team had discovered a normal star and at least one black hole. El-Badry added that the black hole appears to be dormant, meaning not currently active.\r\n\r\nWhen active, black holes give off high-energy light. While dormant, they give off nothing and are difficult to identify.\r\n\r\nHow did black hole form in our galaxy?\r\n\r\nThe scientists said it remains unclear how the black hole formed in our Milky Way galaxy. Examinations of data collected on Gaia BH1 suggests \"its existence is difficult to explain\" using traditional evolutionary modeling methods, said Tineke Roegiers. She is a project information specialist with the Gaia spacecraft team.\r\n\r\nThe researchers said if the black hole formed the traditional way – from the gravitational collapse of a star – that star would have been at least 20 times the mass of our sun. This means the star would have only lived a short time, maybe only a few million years.\r\n\r\nIf both stars had formed at the same time, the scientists say, the massive star would have quickly turned into a \"supergiant\" and swallowed the other star before it had a chance to fully develop.\r\n\r\nThese differences, Roegiers said, \"may indicate something important is missing from our current knowledge of black hole formation.\"\r\n\r\nEl-Badry said the mystery about Earth\'s closest black hole presents many questions about how it formed, \"as well as how many of these dormant black holes there are out there.\"\r\n\r\nHe added, \"I have been searching for a system like Gaia BH1 for the last four years, trying all kinds of methods – but none of them worked. It has been elating to see this search finally bear fruit.\"\r\n\r\nI\'m Bryan Lynn.', 'computer');
INSERT INTO `articles` VALUES (2, 2171407, '2022-11-13', 'Form Clubs', 'Meng', 'heihei', 'i wanna enter a club..');
INSERT INTO `articles` VALUES (3, 666, '2022-11-15', 'Form Clubs', 'test2', 'test is success.', 'Title for test.');
INSERT INTO `articles` VALUES (4, 666, '2022-11-15', 'Message', 'test2', 'message pass .', 'test2 for title');
INSERT INTO `articles` VALUES (5, 666, '2022-11-15', 'Advertise', 'test2', 'keke', 'next 123');
INSERT INTO `articles` VALUES (7, 666, '2022-11-16', 'Products', NULL, 'have 123', 'New title 123');

-- ----------------------------
-- Table structure for clubdetail
-- ----------------------------
DROP TABLE IF EXISTS `clubdetail`;
CREATE TABLE `clubdetail`  (
  `cId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clubdetail
-- ----------------------------
INSERT INTO `clubdetail` VALUES (1, 2171407);
INSERT INTO `clubdetail` VALUES (25, 2171407);
INSERT INTO `clubdetail` VALUES (25, 49);
INSERT INTO `clubdetail` VALUES (25, 2171403);
INSERT INTO `clubdetail` VALUES (1, 49);
INSERT INTO `clubdetail` VALUES (30, 2171407);
INSERT INTO `clubdetail` VALUES (31, 2171407);
INSERT INTO `clubdetail` VALUES (31, 138);
INSERT INTO `clubdetail` VALUES (31, 666);

-- ----------------------------
-- Table structure for clubs
-- ----------------------------
DROP TABLE IF EXISTS `clubs`;
CREATE TABLE `clubs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `count` int(11) NOT NULL,
  `president` int(11) NOT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clubs
-- ----------------------------
INSERT INTO `clubs` VALUES (1, 'club', 2, 2171407, 'sss');
INSERT INTO `clubs` VALUES (25, 'MICE', 3, 49, 'NEU and come in。');
INSERT INTO `clubs` VALUES (30, 'NEU', 1, 2171407, 'gaga');
INSERT INTO `clubs` VALUES (31, 'Test1', 3, 2171407, 'afa');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `articleId` int(11) NULL DEFAULT NULL,
  `comId` int(11) NOT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `who` int(255) NULL DEFAULT NULL,
  `comment` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `toto` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, 1, 1, 2171407, 'lol', '2022-11-14 19:00:00', 2171407);
INSERT INTO `comments` VALUES (2, 1, 1, 2171407, '1111', '2022-11-13 23:59:27', 2171407);
INSERT INTO `comments` VALUES (1, 2, 1, 2171407, 'keke', '2022-11-13 23:59:55', 2171407);
INSERT INTO `comments` VALUES (1, 2, 2, 2171407, 'hiehie', '2022-11-14 02:03:24', 2171407);
INSERT INTO `comments` VALUES (1, 1, 2, 2171407, 'ok,ok', '2022-11-14 02:09:02', 2171407);
INSERT INTO `comments` VALUES (1, 7, 1, 2171407, 'xixixi', '2022-11-14 15:19:27', 2171407);
INSERT INTO `comments` VALUES (1, 8, 1, 2171407, 'mk', '2022-11-14 21:11:57', 2171407);
INSERT INTO `comments` VALUES (2, 2, 1, 2171407, 'no.2 comment.', '2022-11-14 21:13:34', 2171407);
INSERT INTO `comments` VALUES (1, 9, 1, 666, 'new comment', '2022-11-15 00:15:13', 2171407);
INSERT INTO `comments` VALUES (1, 8, 2, 666, 'i know you bro', '2022-11-15 00:17:16', 2171407);
INSERT INTO `comments` VALUES (1, 2, 2, 49, 'Sand is soft', '2022-11-15 18:28:01', 2171407);
INSERT INTO `comments` VALUES (2, 3, 1, 666, '111', '2022-11-15 18:47:53', 2171407);
INSERT INTO `comments` VALUES (3, 1, 1, 666, 'this is the first comment.', '2022-11-15 19:02:30', 666);
INSERT INTO `comments` VALUES (4, 1, 1, 49, 'Chao', '2022-11-15 19:06:55', 666);
INSERT INTO `comments` VALUES (1, 10, 1, 666, '11', '2022-11-16 19:55:03', 2171407);
INSERT INTO `comments` VALUES (1, 10, 2, 666, '222', '2022-11-16 19:55:13', 666);
INSERT INTO `comments` VALUES (2, 4, 1, 666, '333', '2022-11-16 19:56:21', 2171407);
INSERT INTO `comments` VALUES (2, 5, 1, 666, '444', '2022-11-16 19:56:24', 2171407);
INSERT INTO `comments` VALUES (7, 1, 1, 666, 'new comment', '2022-11-16 19:57:35', 666);
INSERT INTO `comments` VALUES (3, 2, 1, 2171403, '22', '2022-11-17 09:21:25', 666);
INSERT INTO `comments` VALUES (3, 3, 1, 2171403, '33', '2022-11-17 09:21:30', 666);
INSERT INTO `comments` VALUES (3, 4, 1, 2171403, '44', '2022-11-17 09:21:34', 666);
INSERT INTO `comments` VALUES (3, 5, 1, 2171403, '55', '2022-11-17 09:21:39', 666);
INSERT INTO `comments` VALUES (4, 2, 1, 2171403, '22', '2022-11-17 09:21:49', 666);
INSERT INTO `comments` VALUES (4, 3, 1, 2171403, '33', '2022-11-17 09:21:53', 666);
INSERT INTO `comments` VALUES (4, 4, 1, 2171403, '44', '2022-11-17 09:21:57', 666);
INSERT INTO `comments` VALUES (1, 11, 1, 2171403, '666', '2022-11-17 11:01:36', 2171407);
INSERT INTO `comments` VALUES (1, 11, 2, 2171403, '789789', '2022-11-17 11:01:52', 2171403);
INSERT INTO `comments` VALUES (4, 5, 1, 2171403, '789798', '2022-11-17 11:02:41', 666);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `appraise` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'basketball', 'alice', 100.00, 'good');
INSERT INTO `course` VALUES (2, 'java', 'bob', 3.00, 'well done');
INSERT INTO `course` VALUES (3, 'football', 'alice', 100.00, 'everything is well');

-- ----------------------------
-- Table structure for coursetime
-- ----------------------------
DROP TABLE IF EXISTS `coursetime`;
CREATE TABLE `coursetime`  (
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` time NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coursetime
-- ----------------------------
INSERT INTO `coursetime` VALUES ('alice', 'basketball', '22:00:00');
INSERT INTO `coursetime` VALUES ('alice', 'basketball', '13:30:00');
INSERT INTO `coursetime` VALUES ('bob', 'java', '12:00:01');
INSERT INTO `coursetime` VALUES ('bob', 'java', '10:00:00');
INSERT INTO `coursetime` VALUES ('alice', 'football', '14:00:00');
INSERT INTO `coursetime` VALUES ('alice', 'basketball', '23:30:00');

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit`  (
  `number` bigint(16) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `cvv` int(4) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of credit
-- ----------------------------
INSERT INTO `credit` VALUES (1234567890123456, 'xixi', 1234);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('The representation of NorthEasten University', 'i guess you know that', 9999999.99, 'good1.jpg', 1);
INSERT INTO `goods` VALUES ('yangliu', 'zhenchou', 1.11, 'good2.jpg', 2);
INSERT INTO `goods` VALUES ('liuliu', 'shizhenchou', 0.01, 'good3.jpg', 3);
INSERT INTO `goods` VALUES ('huhu ', 'ss', 22.00, 'good5.jpg', 5);
INSERT INTO `goods` VALUES ('xiaoyang', 'handsome', 3.20, 'good4.jpg', 4);
INSERT INTO `goods` VALUES ('ly', 'ss', 12.00, 'good6.jpg', 6);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `question` int(11) NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2171407, '111', 'Meng', '1@qq.com', 'ShenYang', 101, 'no');
INSERT INTO `student` VALUES (666, '111', 'test2', '2@163.com', 'huhu', 101, 'no');
INSERT INTO `student` VALUES (2171417, 'seer88384865', 'wang yanjin', '3@163.com', 'china', 101, 'wang');
INSERT INTO `student` VALUES (49, '1234567', 'chaogetadie', '4@mavs.uta.edu', '东北大学浑南校区', 101, 'win!');
INSERT INTO `student` VALUES (2171403, '123456', 'LiLei', '5@qq.com', 'Hogwarts', 101, '666');
INSERT INTO `student` VALUES (138, '111', 'test1', '6@qq.com', 'huhu', 101, 'no');
INSERT INTO `student` VALUES (1111, 'Ly@2171404', 'moon', '7@163.com', '河北', 101, 'HeBei');
INSERT INTO `student` VALUES (2171408, '111', 'Ning,fuzhen', '8@qq.com', 'neu', 101, '111');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `id` bigint(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `imagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `authorId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES (1668042724936, 'product', 'this is a transation', 100.00, 'http://119.23.240.15:8080/upload/521da935906b45ccbd067fcec5217227-11111.jpg', 0, 2171407);
INSERT INTO `transaction` VALUES (1668608989938, 'dd', 'hello', 1111.00, 'http://119.23.240.15:8080/upload/da620df5d4b047179a7a4bea24b23a9d-11111.jpg', 0, 666);

SET FOREIGN_KEY_CHECKS = 1;
