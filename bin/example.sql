/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-08-14 10:25:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cno` varchar(10) NOT NULL,
  `Cname` varchar(10) DEFAULT NULL,
  `Tno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01', '语言', '02');
INSERT INTO `course` VALUES ('02', '数学', '01');
INSERT INTO `course` VALUES ('03', '英语', '03');
INSERT INTO `course` VALUES ('04', '物理', '01');
INSERT INTO `course` VALUES ('05', '化学', '01');
INSERT INTO `course` VALUES ('06', '生物', '01');
INSERT INTO `course` VALUES ('07', '美术', '01');
INSERT INTO `course` VALUES ('08', '计算机', '01');
INSERT INTO `course` VALUES ('09', '瑜伽', '02');
INSERT INTO `course` VALUES ('10', '地理', '03');
INSERT INTO `course` VALUES ('11', '历史', '01');
INSERT INTO `course` VALUES ('12', '政治', '01');
INSERT INTO `course` VALUES ('13', '体育', '02');
INSERT INTO `course` VALUES ('14', '音乐', '03');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Sno` varchar(10) DEFAULT NULL,
  `Cno` varchar(10) DEFAULT NULL,
  `score` decimal(18,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('01', '01', '80.0');
INSERT INTO `score` VALUES ('01', '02', '90.0');
INSERT INTO `score` VALUES ('01', '03', '99.0');
INSERT INTO `score` VALUES ('02', '01', '70.0');
INSERT INTO `score` VALUES ('02', '02', '60.0');
INSERT INTO `score` VALUES ('02', '03', '80.0');
INSERT INTO `score` VALUES ('03', '01', '80.0');
INSERT INTO `score` VALUES ('03', '02', '80.0');
INSERT INTO `score` VALUES ('03', '04', '80.0');
INSERT INTO `score` VALUES ('04', '01', '50.0');
INSERT INTO `score` VALUES ('04', '02', '30.0');
INSERT INTO `score` VALUES ('04', '03', '20.0');
INSERT INTO `score` VALUES ('05', '01', '76.0');
INSERT INTO `score` VALUES ('05', '02', '87.0');
INSERT INTO `score` VALUES ('06', '01', '31.0');
INSERT INTO `score` VALUES ('06', '03', '34.0');
INSERT INTO `score` VALUES ('07', '02', '89.0');
INSERT INTO `score` VALUES ('07', '03', '98.0');
INSERT INTO `score` VALUES ('09', '09', '0.0');
INSERT INTO `score` VALUES ('10', '09', '0.0');
INSERT INTO `score` VALUES ('11', '09', '100.0');
INSERT INTO `score` VALUES ('09', '14', '99.0');
INSERT INTO `score` VALUES ('10', '08', '59.0');
INSERT INTO `score` VALUES ('11', '11', '99.0');
INSERT INTO `score` VALUES ('12', '04', '60.0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sno` varchar(10) DEFAULT NULL,
  `Sname` varchar(10) DEFAULT NULL,
  `Sage` datetime DEFAULT NULL,
  `Ssex` varchar(10) DEFAULT NULL,
  KEY `IDX_STUDENT_SNO` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('01', 'haha', '1990-01-01 00:00:00', '男');
INSERT INTO `student` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `student` VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `student` VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `student` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `student` VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `student` VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `student` VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');
INSERT INTO `student` VALUES ('09', '石磊', '1986-01-01 00:00:00', '男');
INSERT INTO `student` VALUES ('10', '张煜', '1970-01-01 00:00:00', '女');
INSERT INTO `student` VALUES ('11', '刘松', '1988-12-12 00:00:00', '男');
INSERT INTO `student` VALUES ('12', '小强', '1900-12-01 00:00:00', '男');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tno` varchar(10) NOT NULL,
  `Tname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('01', '张三');
INSERT INTO `teacher` VALUES ('02', '李四');
INSERT INTO `teacher` VALUES ('03', '王五');
INSERT INTO `teacher` VALUES ('04', '赵六');
INSERT INTO `teacher` VALUES ('111', 'haha');
