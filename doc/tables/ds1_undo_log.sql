-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 47.108.165.160    Database: ds1
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `undo_log`
--

DROP TABLE IF EXISTS `undo_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'increment id',
  `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime NOT NULL COMMENT 'create datetime',
  `log_modified` datetime NOT NULL COMMENT 'modify datetime',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='AT transaction mode undo table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `undo_log`
--

LOCK TABLES `undo_log` WRITE;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
INSERT INTO `undo_log` VALUES (1,127844543440621568,'172.29.96.1:8091:127844518924914688','serializer=jackson','{\"@class\":\"io.seata.rm.datasource.undo.BranchUndoLog\",\"xid\":\"172.29.96.1:8091:127844518924914688\",\"branchId\":127844543440621568,\"sqlUndoLogs\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.undo.SQLUndoLog\",\"sqlType\":\"INSERT\",\"tableName\":\"app_hdr_user9\",\"beforeImage\":{\"@class\":\"io.seata.rm.datasource.sql.struct.TableRecords$EmptyTableRecords\",\"tableName\":\"app_hdr_user9\",\"rows\":[\"java.util.ArrayList\",[]]},\"afterImage\":{\"@class\":\"io.seata.rm.datasource.sql.struct.TableRecords\",\"tableName\":\"app_hdr_user9\",\"rows\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Row\",\"fields\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"id\",\"keyType\":\"PrimaryKey\",\"type\":-5,\"value\":[\"java.lang.Long\",1384458964889427969]},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"version\",\"keyType\":\"NULL\",\"type\":4,\"value\":1},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"password\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"RkMmLoF7thaGdUgr87u44w==\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"phone\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"13698711929\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"super_id\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"13698711929\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"deduct\",\"keyType\":\"NULL\",\"type\":7,\"value\":[\"java.lang.Float\",0.01]},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"stype\",\"keyType\":\"NULL\",\"type\":4,\"value\":0},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"type\",\"keyType\":\"NULL\",\"type\":4,\"value\":1},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"checkcode\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"123456\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"updatetime\",\"keyType\":\"NULL\",\"type\":93,\"value\":{\"@class\":\"java.time.LocalDateTime\",\"nano\":0,\"year\":2021,\"monthValue\":4,\"dayOfMonth\":20,\"hour\":18,\"minute\":48,\"second\":28,\"dayOfWeek\":\"TUESDAY\",\"dayOfYear\":110,\"month\":\"APRIL\",\"chronology\":{\"@class\":\"java.time.chrono.IsoChronology\",\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"bank_name\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"工商银行\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"bank_no\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"123456789\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"account_bank_name\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"王强\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"receiving_phone\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"13698711929\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"receiving_code_picture_img\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"1111111111111\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"is_agree_agreement\",\"keyType\":\"NULL\",\"type\":12,\"value\":\"1\"},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"index_no\",\"keyType\":\"NULL\",\"type\":-5,\"value\":[\"java.lang.Long\",101]}]]}]]}}]]}',0,'2021-04-20 18:48:35','2021-04-20 18:48:35');
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 14:57:51
