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
-- Table structure for table `app_goods_order`
--

DROP TABLE IF EXISTS `app_goods_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_goods_order` (
  `id` bigint(20) NOT NULL COMMENT '主键id(自动递增)',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `shop_id` varchar(50) DEFAULT NULL COMMENT '商铺id',
  `shop_province_id` varchar(50) DEFAULT NULL COMMENT '商铺省份id',
  `shop_city_id` varchar(50) DEFAULT NULL COMMENT '商铺城市id',
  `shop_county_id` varchar(50) DEFAULT NULL COMMENT '商铺县id',
  `discount` double(9,2) DEFAULT NULL COMMENT '商铺折扣率',
  `user_id` bigint(20) NOT NULL COMMENT '下单人的ID',
  `order_no` varchar(100) DEFAULT NULL COMMENT '订单号',
  `order_type` varchar(10) DEFAULT NULL COMMENT '订单类型',
  `delivery_code` varchar(10) DEFAULT NULL COMMENT '提货码',
  `delivery_phone` varchar(50) DEFAULT NULL COMMENT '提货电话号码',
  `is_delete` varchar(10) DEFAULT NULL COMMENT '是否删除',
  `order_date` datetime DEFAULT NULL COMMENT '下单时间',
  `estimated_delivery_time` datetime DEFAULT NULL COMMENT '预计送达时间',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `reason_cancellation` varchar(100) DEFAULT NULL COMMENT '订单取消原因',
  `reason_date` datetime DEFAULT NULL COMMENT '订单取消时间',
  `red_envelope_money` double(9,2) DEFAULT NULL COMMENT '红包金额',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_away` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `pay_money` double(9,2) DEFAULT NULL COMMENT '支付金额',
  `pay_order_id` varchar(300) DEFAULT NULL COMMENT '支付订单号',
  `error_msg` varchar(3000) DEFAULT NULL COMMENT '错误信息',
  `receipt_address_id` int(11) DEFAULT NULL COMMENT '收货地址',
  `shipment_time` datetime DEFAULT NULL COMMENT '发货日期',
  `receipt_time` datetime DEFAULT NULL COMMENT '收货日期',
  `delivery_user_id` varchar(50) DEFAULT NULL COMMENT '配送人ID',
  `delivery_money` double(9,2) DEFAULT NULL COMMENT '配送金额',
  `delivery_time` datetime DEFAULT NULL COMMENT '配送时间',
  `delivery_end_time` datetime DEFAULT NULL COMMENT '配送结束时间',
  `delivery_to_time` datetime DEFAULT NULL COMMENT '配送送达时间',
  `delivery_status` varchar(10) DEFAULT NULL COMMENT '配送状态',
  `delivery_cancellation` varchar(100) DEFAULT NULL COMMENT '配送取消原因',
  `delivery_reason_date` datetime DEFAULT NULL COMMENT '配送取消时间',
  `shop_message` varchar(3000) DEFAULT NULL COMMENT '商家留言',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注',
  `index_no` bigint(20) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_goods_order`
--

LOCK TABLES `app_goods_order` WRITE;
/*!40000 ALTER TABLE `app_goods_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_goods_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 14:57:03
