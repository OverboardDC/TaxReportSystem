CREATE DATABASE  IF NOT EXISTS `tax_reporting_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tax_reporting_system`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tax_reporting_system
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `inspector`
--

DROP TABLE IF EXISTS `inspector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inspector` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `role` enum('Inspector','Admin') NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspector`
--

LOCK TABLES `inspector` WRITE;
/*!40000 ALTER TABLE `inspector` DISABLE KEYS */;
INSERT INTO `inspector` VALUES (1,'Inspector','steve','d4541250b586296fcce5dea4463ae17f','Steve	','Townsend'),(2,'Inspector','edgar','d4541250b586296fcce5dea4463ae17f','Edgar','White'),(3,'Inspector','cristian','d4541250b586296fcce5dea4463ae17f','Cristian','Nash'),(4,'Admin','lorenzo','d4541250b586296fcce5dea4463ae17f','Lorenzo','Russel'),(5,'Admin','adam','d4541250b586296fcce5dea4463ae17f','Adam','Wilson');
/*!40000 ALTER TABLE `inspector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `taxpayer_id` bigint(255) NOT NULL,
  `inspector_id` bigint(255) NOT NULL,
  `status` enum('Pending','Approved','Rejected') NOT NULL,
  `period_from` date NOT NULL,
  `period_to` date NOT NULL,
  `revenue` bigint(200) NOT NULL,
  `tax` decimal(10,0) NOT NULL,
  `commentary` mediumtext,
  `reject_reason` mediumtext,
  `submission_date` datetime NOT NULL,
  `editing_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_report_user_idx` (`taxpayer_id`),
  KEY `fk_report_inspector_idx` (`inspector_id`),
  CONSTRAINT `fk_report_inspector` FOREIGN KEY (`inspector_id`) REFERENCES `inspector` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_taxpayer` FOREIGN KEY (`taxpayer_id`) REFERENCES `taxpayer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (43,27,2,'Approved','2018-02-01','2018-05-22',220134,24,'My revenue for February, edited','Incorrect report','2018-05-20 17:11:31','2018-05-20 17:20:39'),(44,27,2,'Approved','2018-03-01','2018-05-31',175632,25,'My revenue for March',NULL,'2018-05-20 17:12:19',NULL),(45,27,2,'Approved','2018-04-01','2018-05-31',204523,22,'Revenue for April',NULL,'2018-05-20 17:13:27',NULL),(46,27,2,'Approved','2018-05-01','2018-05-31',190067,25,'My revenue for May',NULL,'2018-05-20 17:14:22',NULL),(47,27,2,'Approved','2018-01-01','2018-01-31',124567,21,'Additional report',NULL,'2018-05-20 17:16:59',NULL),(48,27,2,'Approved','2017-11-01','2018-05-31',145687,24,'Report for november',NULL,'2018-05-20 17:18:57',NULL),(49,26,1,'Approved','2018-05-01','2018-05-31',234578,22,'Revenue for May',NULL,'2018-05-21 10:54:22',NULL),(50,30,2,'Pending','2018-04-01','2018-05-16',84523,23,NULL,NULL,'2018-05-21 10:57:18',NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `taxpayer_id` bigint(255) NOT NULL,
  `inspector_id` bigint(255) NOT NULL,
  `reason` mediumtext NOT NULL,
  `status` enum('Pending','Approved','Rejected') NOT NULL,
  `reject_reason` varchar(45) DEFAULT NULL,
  `submission_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_request_user_idx` (`taxpayer_id`),
  KEY `fk_rewuest_inspector_idx` (`inspector_id`),
  CONSTRAINT `fk_request_taxpayer` FOREIGN KEY (`taxpayer_id`) REFERENCES `taxpayer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rewuest_inspector` FOREIGN KEY (`inspector_id`) REFERENCES `inspector` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (37,27,2,'Strange decisions','Pending',NULL,'2018-05-20 17:23:29');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxpayer`
--

DROP TABLE IF EXISTS `taxpayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxpayer` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `inspector_id` bigint(255) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `identification_code` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_user_inspector_idx` (`inspector_id`),
  CONSTRAINT `fk_user_inspector` FOREIGN KEY (`inspector_id`) REFERENCES `inspector` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxpayer`
--

LOCK TABLES `taxpayer` WRITE;
/*!40000 ALTER TABLE `taxpayer` DISABLE KEYS */;
INSERT INTO `taxpayer` VALUES (26,1,'wendy','d4541250b586296fcce5dea4463ae17f','Wendy','Freeman','582048567'),(27,2,'tony','d4541250b586296fcce5dea4463ae17f','Tony','Torres','385945723'),(28,NULL,'jenna','d4541250b586296fcce5dea4463ae17f','Jenna','Collins','274957384'),(29,3,'ronnie','d4541250b586296fcce5dea4463ae17f','Ronnie','Jensen','492748592'),(30,2,'martin','d4541250b586296fcce5dea4463ae17f','Martin','Henderson','482047527');
/*!40000 ALTER TABLE `taxpayer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21 13:58:38
