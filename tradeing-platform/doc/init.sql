/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 127.0.0.1:3306
 Source Schema         : localdata

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 06/02/2023 23:27:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `advice` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `buy_id` int(11) DEFAULT NULL,
  `sell_id` int(11) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of audit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for broadcast
-- ----------------------------
DROP TABLE IF EXISTS `broadcast`;
CREATE TABLE `broadcast` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `advice` varchar(50) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  `truename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of broadcast
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for broadcastread
-- ----------------------------
DROP TABLE IF EXISTS `broadcastread`;
CREATE TABLE `broadcastread` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `read` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of broadcastread
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for buymesg
-- ----------------------------
DROP TABLE IF EXISTS `buymesg`;
CREATE TABLE `buymesg` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `sellid` int(11) DEFAULT NULL,
  `figure` varchar(50) DEFAULT NULL,
  `fw_id` int(11) DEFAULT NULL,
  `buyfirm_name` varchar(50) DEFAULT NULL,
  `document_no` varchar(50) DEFAULT NULL,
  `applicant` varchar(50) DEFAULT NULL,
  `issuer` varchar(50) DEFAULT NULL,
  `application_date` datetime DEFAULT NULL,
  `deliverytime1` datetime DEFAULT NULL,
  `deliverytime2` datetime DEFAULT NULL,
  `coaltype1` int(11) DEFAULT NULL,
  `coaltype2` int(11) DEFAULT NULL,
  `num` varchar(50) DEFAULT NULL,
  `freight` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `shiptype` int(11) DEFAULT NULL,
  `deliveryplace` varchar(50) DEFAULT NULL,
  `transactionmode` int(11) DEFAULT NULL,
  `acceptancemode` int(11) DEFAULT NULL,
  `paymentmode` int(11) DEFAULT NULL,
  `offerbond` varchar(50) DEFAULT NULL,
  `performbond` varchar(50) DEFAULT NULL,
  `kcal` varchar(50) DEFAULT NULL,
  `sulfur` varchar(50) DEFAULT NULL,
  `water` varchar(50) DEFAULT NULL,
  `ash` varchar(50) DEFAULT NULL,
  `vol1` varchar(50) DEFAULT NULL,
  `vol2` varchar(50) DEFAULT NULL,
  `kwater` varchar(50) DEFAULT NULL,
  `ksulfur` varchar(50) DEFAULT NULL,
  `kvol1` varchar(50) DEFAULT NULL,
  `kvol2` varchar(50) DEFAULT NULL,
  `gkcal` varchar(50) DEFAULT NULL,
  `gsulfur` varchar(50) DEFAULT NULL,
  `gvol1` varchar(50) DEFAULT NULL,
  `gvol2` varchar(50) DEFAULT NULL,
  `granularity` varchar(50) DEFAULT NULL,
  `melting` varchar(50) DEFAULT NULL,
  `hgi` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `coal_type3` varchar(50) DEFAULT NULL,
  `coal_type4` varchar(50) DEFAULT NULL,
  `ship_type1` varchar(50) DEFAULT NULL,
  `transaction_mode1` varchar(50) DEFAULT NULL,
  `acceptance_mode1` varchar(50) DEFAULT NULL,
  `payment_mode1` varchar(50) DEFAULT NULL,
  `advice` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of buymesg
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for firm
-- ----------------------------
DROP TABLE IF EXISTS `firm`;
CREATE TABLE `firm` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firmname` varchar(50) DEFAULT NULL,
  `firmtype` int(11) DEFAULT NULL,
  `represent` varchar(50) DEFAULT NULL,
  `represent_idcard` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `postal` varchar(50) DEFAULT NULL,
  `register_fund` varchar(50) DEFAULT NULL,
  `license_no` varchar(50) DEFAULT NULL,
  `org_no` varchar(50) DEFAULT NULL,
  `certificate_no` varchar(50) DEFAULT NULL,
  `tax_no` varchar(50) DEFAULT NULL,
  `bankname` varchar(50) DEFAULT NULL,
  `bank_no` varchar(50) DEFAULT NULL,
  `coalmesg` varchar(50) DEFAULT NULL,
  `transportmesg` varchar(50) DEFAULT NULL,
  `firminfo` varchar(50) DEFAULT NULL,
  `treasurername` varchar(50) DEFAULT NULL,
  `treasurertelephone` varchar(50) DEFAULT NULL,
  `treasureremail` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of firm
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for firm_attach
-- ----------------------------
DROP TABLE IF EXISTS `firm_attach`;
CREATE TABLE `firm_attach` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `image_type` varchar(50) DEFAULT NULL,
  `image_url` varchar(50) DEFAULT NULL,
  `image_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of firm_attach
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for firmworker
-- ----------------------------
DROP TABLE IF EXISTS `firmworker`;
CREATE TABLE `firmworker` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `truename` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `firmtype` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `is_deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of firmworker
-- ----------------------------
BEGIN;
INSERT INTO `firmworker` (`serial_version_UID`, `id`, `firm_id`, `truename`, `telephone`, `email`, `password`, `firmtype`, `type`, `is_deleted`) VALUES (NULL, 1, 0, '1234567890', '1234567890', '2222', 'e10adc3949ba59abbe56e057f20f883e', 0, 0, '0');
COMMIT;

-- ----------------------------
-- Table structure for firmworker_account
-- ----------------------------
DROP TABLE IF EXISTS `firmworker_account`;
CREATE TABLE `firmworker_account` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fw_id` int(11) DEFAULT NULL,
  `figure` varchar(50) DEFAULT NULL,
  `trans_flow_list` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `freeze_amount` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of firmworker_account
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for personmesg
-- ----------------------------
DROP TABLE IF EXISTS `personmesg`;
CREATE TABLE `personmesg` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pep_id` int(11) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of personmesg
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sellmesg
-- ----------------------------
DROP TABLE IF EXISTS `sellmesg`;
CREATE TABLE `sellmesg` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `buyid` int(11) DEFAULT NULL,
  `figure` varchar(50) DEFAULT NULL,
  `fw_id` int(11) DEFAULT NULL,
  `coaltype1` int(11) DEFAULT NULL,
  `coaltype2` int(11) DEFAULT NULL,
  `num` varchar(50) DEFAULT NULL,
  `kcal` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `sulfur` varchar(50) DEFAULT NULL,
  `prodarea` varchar(50) DEFAULT NULL,
  `freight` varchar(50) DEFAULT NULL,
  `vol1` varchar(50) DEFAULT NULL,
  `vol2` varchar(50) DEFAULT NULL,
  `sendarea` varchar(50) DEFAULT NULL,
  `ash` varchar(50) DEFAULT NULL,
  `water` varchar(50) DEFAULT NULL,
  `offerbond` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  `advice` varchar(50) DEFAULT NULL,
  `firmname` varchar(50) DEFAULT NULL,
  `represent` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sellmesg
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for trans_flow
-- ----------------------------
DROP TABLE IF EXISTS `trans_flow`;
CREATE TABLE `trans_flow` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fw_id` int(11) DEFAULT NULL,
  `fw_name` varchar(50) DEFAULT NULL,
  `trans_no` varchar(50) DEFAULT NULL,
  `trans_type` int(11) DEFAULT NULL,
  `trans_type_name` varchar(50) DEFAULT NULL,
  `trans_amount` varchar(50) DEFAULT NULL,
  `memo` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of trans_flow
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for transactionbills
-- ----------------------------
DROP TABLE IF EXISTS `transactionbills`;
CREATE TABLE `transactionbills` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `buyid` int(11) DEFAULT NULL,
  `sellid` int(11) DEFAULT NULL,
  `agreementpath` varchar(50) DEFAULT NULL,
  `sellmesg_id` int(11) DEFAULT NULL,
  `buymesg_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of transactionbills
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `truename` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `deleted` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for verifyinfo
-- ----------------------------
DROP TABLE IF EXISTS `verifyinfo`;
CREATE TABLE `verifyinfo` (
  `serial_version_UID` varchar(50) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of verifyinfo
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
