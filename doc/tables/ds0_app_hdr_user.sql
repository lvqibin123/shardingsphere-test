-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 139.155.31.113    Database: ds0
-- ------------------------------------------------------
-- Server version	5.6.49-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_hdr_user`
--

DROP TABLE IF EXISTS `app_hdr_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_hdr_user` (
  `id` bigint(20) NOT NULL COMMENT '序号(自动递增)',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `password` varchar(1000) DEFAULT NULL COMMENT '密码(明文)',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `super_id` varchar(50) DEFAULT NULL COMMENT '上级推荐人id',
  `deduct` float(10,2) DEFAULT '0.00' COMMENT '抵扣券余额',
  `stype` int(11) DEFAULT '2' COMMENT '0微信注册 1支付宝注册 2其他 ',
  `type` int(11) DEFAULT '0' COMMENT '登录标志（当前登录的是什么类型）0用户 1骑手 2商家',
  `checkcode` varchar(50) DEFAULT NULL COMMENT '验证码',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户银行名称',
  `bank_no` varchar(50) DEFAULT NULL COMMENT '开户银行卡号',
  `account_bank_name` varchar(100) DEFAULT NULL COMMENT '开户人姓名',
  `receiving_phone` varchar(50) DEFAULT NULL COMMENT '收款人电话',
  `receiving_code_picture_img` varchar(100) DEFAULT NULL COMMENT '收款码图片',
  `is_agree_agreement` varchar(5) DEFAULT '0' COMMENT '是否同意协议（0/未同意 1/已同意）',
  `index_no` bigint(20) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_hdr_user`
--

LOCK TABLES `app_hdr_user` WRITE;
/*!40000 ALTER TABLE `app_hdr_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_hdr_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 14:57:05
