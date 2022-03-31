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
-- Table structure for table `app_goods_order_detail`
--

DROP TABLE IF EXISTS `app_goods_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_goods_order_detail` (
  `id` bigint(20) NOT NULL COMMENT '主键id(自动递增)',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `shop_id` varchar(50) DEFAULT NULL COMMENT '商铺id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品表id',
  `user_id` bigint(20) NOT NULL COMMENT '下单人的ID',
  `order_id` varchar(100) DEFAULT NULL COMMENT '订单表编号',
  `good_cart_id` int(11) DEFAULT NULL COMMENT '购物车id',
  `is_delete` varchar(10) DEFAULT NULL COMMENT '是否删除',
  `goods_sum` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_packing_price` double(9,2) DEFAULT NULL COMMENT '商品打包费',
  `goods_price` double(9,2) DEFAULT NULL COMMENT '商品金额',
  `order_date` datetime DEFAULT NULL COMMENT '下单时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注',
  `index_no` bigint(20) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_goods_order_detail`
--

LOCK TABLES `app_goods_order_detail` WRITE;
/*!40000 ALTER TABLE `app_goods_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_goods_order_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 14:57:04
