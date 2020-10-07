/*
Navicat MySQL Data Transfer
Source Server         : MySQL
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : petz
Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001
Date: 2020-07-27 12:15:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'SAO PAULO', 'BRASIL');
INSERT INTO `address` VALUES ('2', 'BRASILIA', 'BRASIL');

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl63rkjkd4rggxh14d9ydtei43` (`address_id`),
  CONSTRAINT `FKl63rkjkd4rggxh14d9ydtei43` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', 'Heitor Araujo Martins', '1');
INSERT INTO `client` VALUES ('2', 'Valmir Santos Neto', '1');
INSERT INTO `client` VALUES ('3', 'Luciano Paccios', '2');

-- ----------------------------
-- Table structure for `client_documents`
-- ----------------------------
DROP TABLE IF EXISTS `client_documents`;
CREATE TABLE `client_documents` (
  `Client_id` bigint(20) NOT NULL,
  `documents_id` bigint(20) NOT NULL,
  KEY `FKhb0ttuu9gpspmid13leodbj50` (`documents_id`),
  KEY `FK9gho7tm6pmfcqj8jxdnpypkkc` (`Client_id`),
  CONSTRAINT `FK9gho7tm6pmfcqj8jxdnpypkkc` FOREIGN KEY (`Client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKhb0ttuu9gpspmid13leodbj50` FOREIGN KEY (`documents_id`) REFERENCES `document` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of client_documents
-- ----------------------------
INSERT INTO `client_documents` VALUES ('1', '1');
INSERT INTO `client_documents` VALUES ('2', '2');
INSERT INTO `client_documents` VALUES ('3', '3');

-- ----------------------------
-- Table structure for `document`
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('1', '98176897272', 'CPF');
INSERT INTO `document` VALUES ('2', '583437965', 'RG');
INSERT INTO `document` VALUES ('3', '583437965', 'RG');

-- ----------------------------
-- Table structure for `pet`
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKill1queq7m2fox8ktdhh56546` (`client_id`),
  CONSTRAINT `FKill1queq7m2fox8ktdhh56546` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES ('4', '9', 'Kelly', '1');
INSERT INTO `pet` VALUES ('5', '2', 'Pluft', '2');