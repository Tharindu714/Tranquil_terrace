-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `hotel_db`
--

/*!40000 DROP DATABASE IF EXISTS `hotel_db`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hotel_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `hotel_db`;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Bandarwela'),(2,'Nugegoda'),(3,'Haliela'),(4,'Badulla'),(5,'Kaluphana'),(6,'Ella');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Sri Lanka'),(2,'France'),(3,'India'),(4,'Canada'),(5,'Australia'),(6,'England'),(7,'USA');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `nic/passport` varchar(20) NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `points` int NOT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`nic/passport`),
  KEY `fk_customer_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_customer_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('200132200757','+94704832705','Maleesha Shehan',100,1),('200134568902','+94753457892','Sadeesha Nilakshini',25,2),('200985436497','+94703900423','Prabhashi Tharindya',56,2),('851246793V','+94751441845','Bhagya Weerasinghe',12,2),('925671472V','+94721678925','Saman Hettiarachchi',134,1),('D2H6862M2','+447450838783','Helana Joe',200,2),('G2N9834K3','+17588106582','Mavis David',24,1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `customer_city_id` int NOT NULL,
  `customer_nic/passport` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_address_customer_city1_idx` (`customer_city_id`),
  KEY `fk_customer_address_customer1_idx` (`customer_nic/passport`),
  CONSTRAINT `fk_customer_address_customer1` FOREIGN KEY (`customer_nic/passport`) REFERENCES `customer` (`nic/passport`),
  CONSTRAINT `fk_customer_address_customer_city1` FOREIGN KEY (`customer_city_id`) REFERENCES `customer_city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` VALUES (1,'209/1,','athulkotte',7,'851246793V'),(2,'2nd lane,','Flower Street',5,'D2H6862M2'),(3,'3rd cross street,','Huwakins',4,'G2N9834K3'),(4,'291/1,','Uduhulpotha',1,'200985436497'),(5,'804/6,','Samagipura',8,'925671472V');
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_city`
--

DROP TABLE IF EXISTS `customer_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_city_country1_idx` (`country_id`),
  CONSTRAINT `fk_customer_city_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_city`
--

LOCK TABLES `customer_city` WRITE;
/*!40000 ALTER TABLE `customer_city` DISABLE KEYS */;
INSERT INTO `customer_city` VALUES (1,'Bandarawela',1),(2,'Mumbai',3),(3,'Los Angeles',7),(4,'Chicago',7),(5,'London',6),(6,'Texas ',7),(7,'Colombo',1),(8,'Nugegoda',1),(9,'Ottawa',4);
/*!40000 ALTER TABLE `customer_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_visit_hotel`
--

DROP TABLE IF EXISTS `customer_visit_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_visit_hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `check_in` datetime NOT NULL,
  `pax` int NOT NULL,
  `check_out` datetime NOT NULL,
  `total` double NOT NULL,
  `customer_nic/passport` varchar(20) NOT NULL,
  `payment_method_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_custermer_visit_hotel_customer1_idx` (`customer_nic/passport`),
  KEY `fk_custermer_visit_hotel_payment_method1_idx` (`payment_method_id`),
  CONSTRAINT `fk_custermer_visit_hotel_customer1` FOREIGN KEY (`customer_nic/passport`) REFERENCES `customer` (`nic/passport`),
  CONSTRAINT `FK_customer_visit_hotel_payement_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payement_method` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_visit_hotel`
--

LOCK TABLES `customer_visit_hotel` WRITE;
/*!40000 ALTER TABLE `customer_visit_hotel` DISABLE KEYS */;
INSERT INTO `customer_visit_hotel` VALUES (1,'2024-05-10 10:00:00',2,'2024-05-18 15:00:00',15000,'G2N9834K3',1),(2,'2024-05-01 14:00:00',1,'2024-05-18 17:35:57',250000,'D2H6862M2',2),(3,'2024-05-05 04:30:00',4,'2024-05-10 21:00:00',130000,'G2N9834K3',2),(4,'2024-05-15 16:00:00',2,'2024-05-18 17:37:42',20000,'851246793V',1),(5,'2024-05-17 06:00:00',4,'2024-05-18 17:38:19',25000,'925671472V',2),(6,'2024-05-25 22:36:48',2,'2024-05-30 22:36:56',50000,'200985436497',1),(7,'2024-05-26 07:09:45',1,'2024-05-28 17:54:05',50000,'925671472V',2),(8,'2024-05-27 09:06:50',10,'2024-05-28 00:00:03',500000,'851246793V',2),(9,'2024-05-29 07:00:00',2,'2024-05-30 22:40:44',76800,'G2N9834K3',2),(10,'2024-05-02 09:05:46',4,'2024-05-02 00:11:11',46000,'851246793V',2),(11,'2024-05-11 21:35:45',3,'2024-05-13 21:35:49',50000,'D2H6862M2',2),(12,'2024-05-03 11:36:47',2,'2024-05-08 21:36:59',75000,'925671472V',2);
/*!40000 ALTER TABLE `customer_visit_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Administrator'),(2,'Reception'),(3,'Back Office'),(4,'Kitchen');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` int NOT NULL,
  `registered_date` date NOT NULL,
  `employee_type_id` int NOT NULL,
  `gender_id` int NOT NULL,
  `loggedtime` datetime NOT NULL,
  `department_id` int NOT NULL,
  `image_path` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci,
  `qr_path` text,
  PRIMARY KEY (`id`),
  KEY `fk_user_u8ser_type_idx` (`employee_type_id`),
  KEY `fk_user_gender1_idx` (`gender_id`),
  KEY `fk_employee_department1_idx` (`department_id`),
  CONSTRAINT `fk_employee_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_user_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_user_u8ser_type` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Tharindu','Chanaka','0751441754','TChanaka','tharindu1122',1,'2024-03-20',1,1,'2024-06-06 17:12:04',1,'',NULL),(2,'Sadeesha','Nilakshini','0747179730','SNilakshini','Sadeesha123',1,'2024-03-18',6,2,'2024-05-22 21:16:51',1,'',NULL),(3,'Kasuni','Jayamali','0748763400','KJayamali2003','KasuniJaYamaLI6785',1,'2024-04-01',4,2,'2024-05-29 08:34:02',3,'',NULL),(4,'Maleesha','Shehan','0754329874','MShehan','Malee789',1,'2024-05-10',3,1,'2024-06-06 14:45:49',2,'',NULL),(5,'Dhanushka','Lakmal','0712346789','DLakmal','LakmalD865',1,'2024-05-01',2,1,'2024-05-22 03:03:06',4,'',NULL),(6,'Kavindaya','Rathnayaka','0785670034','SKavindaya','kaveS567',1,'2024-04-12',5,2,'2024-05-29 16:14:21',4,'',NULL),(7,'Sandaruwan','Jayasinghe','0781236743','sandaruwan De Jaysinghe','sandaru123',0,'2024-05-20',4,1,'2024-05-29 15:54:30',3,'',NULL),(8,'Anya','Hasalwood','0712346790','AHasalwood678','anya456haselwood',1,'2024-05-20',4,2,'2024-05-22 03:03:08',3,'',NULL),(9,'Madushanka','Lakmal','0763472300','MaduLakmal','Madushanka8790',1,'2024-05-20',6,1,'2024-05-22 21:21:27',1,'',NULL),(10,'Brayan','Gabrial','0785641234','BGabrial','bgnotme335',1,'2024-05-21',4,1,'2024-06-06 16:05:49',3,'',NULL),(11,'Tharaka','Sankalpa','0765432390','Tharka@JavaInstitute','tharakasankalpa678',1,'2024-05-22',6,1,'2024-06-01 12:57:47',1,'',NULL),(12,'Chathuri','Rathnayake','0786543211','Chathu Rathnayaka','ChathuCh8976',1,'2024-05-25',6,2,'2024-06-01 13:12:52',1,'',NULL),(13,'Varunn','De Soyza','0765431287','Varunn De Soyza','varuvaru890',1,'2024-05-25',4,1,'2024-05-25 12:08:42',3,'',NULL),(14,'Sahan','Perera','0786543213','Sahan Perera','sahan123',1,'2024-05-26',6,1,'2024-06-06 11:51:28',1,'',NULL),(15,'Sadee','Nimhara','0764532190','Nimhara Sadee','sadee1234',1,'2024-05-26',4,2,'2024-05-26 14:25:28',3,'',NULL),(16,'Dinil','Withanage','0712236756','DWithanage','Dw456dinil',1,'2024-05-29',4,1,'2024-05-29 00:10:16',3,'',NULL),(17,'Test','User','0714443322','Tuser','tyuioo',1,'2024-05-29',4,1,'2024-05-29 15:26:37',3,'',NULL),(18,'Dinil','Withanage','0752236756','DWithanage','Dw456dinil',1,'2024-05-29',4,1,'2024-05-29 00:00:00',3,'',NULL),(19,'Dinil','Withanage','0762236756','DWithanage','Dw456dinil',1,'2024-05-29',4,1,'2024-05-29 00:00:00',3,'',NULL),(20,'Yohan','Siriwardana','0754567890','YohanS','yohansiriwardana',1,'2024-06-01',4,1,'2024-06-01 14:53:51',3,'',NULL),(21,'Tharaka','Madushanka','0765432189','ceR-0944','tharaka789',1,'2024-06-06',3,1,'2024-06-06 16:13:42',2,'/profile_image/ceR-0944.jpg','/Qr_Code/ceR-0944.png'),(22,'Chamini','Gunawardanna','0786321144','ChaminiG67','chamichami67',1,'2024-06-06',4,2,'2024-06-06 17:09:19',3,NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_type`
--

DROP TABLE IF EXISTS `employee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_type`
--

LOCK TABLES `employee_type` WRITE;
/*!40000 ALTER TABLE `employee_type` DISABLE KEYS */;
INSERT INTO `employee_type` VALUES (1,'Super Admin'),(2,'Staff'),(3,'Receptionist'),(4,'HR'),(5,'Kitchen Operator'),(6,'Admin');
/*!40000 ALTER TABLE `employee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eq_category`
--

DROP TABLE IF EXISTS `eq_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eq_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eq_category`
--

LOCK TABLES `eq_category` WRITE;
/*!40000 ALTER TABLE `eq_category` DISABLE KEYS */;
INSERT INTO `eq_category` VALUES (1,'Electronic Items'),(2,'Bedding & linens'),(3,'Furniture Items'),(4,'Appliances'),(5,'Bathroom Amenities'),(6,'Decor Items'),(7,'Stationary & Information'),(8,'Maintenance Tools'),(10,'Sanititation'),(11,'Notebooks'),(12,'Diaries'),(13,'Test');
/*!40000 ALTER TABLE `eq_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eq_status`
--

DROP TABLE IF EXISTS `eq_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eq_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eq_status`
--

LOCK TABLES `eq_status` WRITE;
/*!40000 ALTER TABLE `eq_status` DISABLE KEYS */;
INSERT INTO `eq_status` VALUES (1,'Active'),(2,'Inactive');
/*!40000 ALTER TABLE `eq_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_item_added`
--

DROP TABLE IF EXISTS `extra_item_added`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_item_added` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_item_added`
--

LOCK TABLES `extra_item_added` WRITE;
/*!40000 ALTER TABLE `extra_item_added` DISABLE KEYS */;
INSERT INTO `extra_item_added` VALUES (1,'No Extras'),(2,'Extra Chicken'),(3,'Extra Spices'),(4,'Extra Sugar'),(5,'Extra Shrimp'),(6,'Extra Chocolate'),(7,'Less Salt'),(8,'Extra Fish'),(9,'Extra Sausages'),(10,'Extra CuttleFish'),(11,'Extra Cheese'),(12,'Without Cheese'),(13,'Less Suger'),(14,'Suger free');
/*!40000 ALTER TABLE `extra_item_added` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_category`
--

DROP TABLE IF EXISTS `food_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_category`
--

LOCK TABLES `food_category` WRITE;
/*!40000 ALTER TABLE `food_category` DISABLE KEYS */;
INSERT INTO `food_category` VALUES (1,'Soup'),(2,'Salad'),(3,'Juice'),(4,'Rice'),(5,'Noodles'),(6,'Spegatti'),(7,'Macaroni'),(8,'Devilled'),(9,'Chicken'),(10,'Fried foods'),(11,'Fish'),(12,'Dessert'),(13,'Hot Drinks');
/*!40000 ALTER TABLE `food_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_item`
--

DROP TABLE IF EXISTS `food_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `food_category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_food_item_food_category1_idx` (`food_category_id`),
  CONSTRAINT `fk_food_item_food_category1` FOREIGN KEY (`food_category_id`) REFERENCES `food_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_item`
--

LOCK TABLES `food_item` WRITE;
/*!40000 ALTER TABLE `food_item` DISABLE KEYS */;
INSERT INTO `food_item` VALUES (3,'Vegitable Soup',350,1),(4,'Chicken Soup',550,1),(5,'Cucumber Salad',200,2),(6,'Vegetable Mixed Salad',350,2),(7,'Fruit Salad',400,2),(8,'Lime Juice',200,3),(9,'Mixed Fruit Juice',450,3),(10,'Vegetable Rice ',650,4),(11,'Chicken Rice Samba',600,4),(12,'Chicken Rice Basmati',700,4),(13,'Mixed Rice',1200,4),(14,'Biriyani',1000,4),(15,'Nasi goreng ',1250,4),(16,'Egg Noodles',650,5),(17,'Chicken Noodles',750,5),(18,'Mixed Noodles',950,5),(19,'Cheese Spegatti',900,6),(20,'Sea food Spegatti',1050,6),(21,'Cheese Macaroni',850,7),(22,'Prawn cheese Macaroni',1050,7),(23,'Chicken Devilled',950,8),(24,'Cuttlefish Devilled',1100,8),(25,'Mixed Devilled',1600,8),(26,'Fish Devilled',950,8),(27,'Pepper Chicken',1100,9),(28,'Chicken Steak ',1600,9),(29,'Roasted Chicken',2600,9),(30,'Potato Chips',700,10),(31,'Fried Chicken',950,10),(32,'Fried Sausages',700,10),(33,'Spicy Fish',1050,11),(34,'Pepper Fish',1050,11),(35,'Hot Butter Fish',1050,11),(36,'Watalappan',400,12),(37,'Ice Cream',350,12),(38,'Tea',200,13),(39,'Coffee',200,13),(40,'Hot Chocalate ',350,13);
/*!40000 ALTER TABLE `food_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Male'),(2,'Female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn`
--

DROP TABLE IF EXISTS `grn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `supplier_mobile` varchar(10) NOT NULL,
  `payment_method_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_mobile`),
  KEY `fk_grn_payment_method1_idx` (`payment_method_id`),
  CONSTRAINT `FK_grn_payement_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payement_method` (`id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_mobile`) REFERENCES `supplier` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn`
--

LOCK TABLES `grn` WRITE;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
INSERT INTO `grn` VALUES (1,'2024-05-02','0712345698',1),(2,'2024-05-02','0761665789',2),(3,'2024-05-02','0785432178',2),(4,'2024-05-03','0714327832',2),(5,'2024-05-04','0743765050',1),(6,'2024-05-04','0712345698',2),(7,'2024-05-05','0761665789',2),(8,'2024-05-06','0785432178',1),(9,'2024-05-10','0714327832',1),(10,'2024-05-12','0785432178',1);
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn_item`
--

DROP TABLE IF EXISTS `grn_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_price` double NOT NULL,
  `qty` int NOT NULL,
  `expiry_date` date NOT NULL,
  `grn_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`),
  KEY `fk_grn_item_item1_idx` (`item_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_item_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn_item`
--

LOCK TABLES `grn_item` WRITE;
/*!40000 ALTER TABLE `grn_item` DISABLE KEYS */;
INSERT INTO `grn_item` VALUES (1,100,30,'2025-05-18',1,4),(2,1000,10,'2024-07-10',5,1),(3,1400,5,'2024-06-18',4,3),(4,600,13,'2024-07-01',9,2);
/*!40000 ALTER TABLE `grn_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_eq`
--

DROP TABLE IF EXISTS `hotel_eq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_eq` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `department_id` int NOT NULL,
  `eq_category_id` int NOT NULL,
  `eq_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hotel_eq_department1_idx` (`department_id`),
  KEY `fk_hotel_eq_eq_category1_idx` (`eq_category_id`),
  KEY `fk_hotel_eq_eq_status1_idx` (`eq_status_id`),
  CONSTRAINT `fk_hotel_eq_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_hotel_eq_eq_category1` FOREIGN KEY (`eq_category_id`) REFERENCES `eq_category` (`id`),
  CONSTRAINT `fk_hotel_eq_eq_status1` FOREIGN KEY (`eq_status_id`) REFERENCES `eq_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_eq`
--

LOCK TABLES `hotel_eq` WRITE;
/*!40000 ALTER TABLE `hotel_eq` DISABLE KEYS */;
INSERT INTO `hotel_eq` VALUES (1,'Telephones',2,1,1),(2,'Microwave',4,1,1),(3,'Fans',2,1,1),(4,'Routers',2,1,1),(5,'Bed & other furnitures',1,3,1),(6,'Chairs & Table',1,3,1),(7,'Soap & Shampoo',1,5,1),(8,'Sachet food items',4,4,1),(9,'Bed sheets & Pillows',1,2,1),(10,'Flower vases',1,6,1),(11,'Wall hangers',1,6,1),(12,'Employee Stationaries',1,7,1),(17,'Dishwashing Bar',4,8,1),(18,'Wallpaper',2,6,2);
/*!40000 ALTER TABLE `hotel_eq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediant`
--

DROP TABLE IF EXISTS `ingrediant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` double NOT NULL,
  `food_item_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ingrediant_food_item1_idx` (`food_item_id`),
  KEY `fk_ingrediant_item1_idx` (`item_id`),
  CONSTRAINT `fk_ingrediant_food_item1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`),
  CONSTRAINT `fk_ingrediant_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediant`
--

LOCK TABLES `ingrediant` WRITE;
/*!40000 ALTER TABLE `ingrediant` DISABLE KEYS */;
INSERT INTO `ingrediant` VALUES (1,1,14,1),(2,2,26,3),(3,1,19,5),(4,2,7,0),(5,3,8,0),(6,1,4,0),(7,2,16,0),(8,3,13,0),(9,3,36,0),(10,2,15,0),(11,2,38,0),(12,2,8,0),(13,5,36,0),(14,2,7,0),(15,2,7,0),(16,2,7,0),(17,0,4,0),(18,0,4,0),(19,2,4,0),(20,0,14,0),(21,0,14,0),(22,2,14,0);
/*!40000 ALTER TABLE `ingrediant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `min_qty` double NOT NULL,
  `current_qty` double NOT NULL,
  `item_unit_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_item_unit1_idx` (`item_unit_id`),
  CONSTRAINT `fk_item_item_unit1` FOREIGN KEY (`item_unit_id`) REFERENCES `item_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Chicken',5,5,2),(2,'Lime',6,4,2),(3,'Chilli 1kg',2,3,6),(4,'Coca Cola',20,10,7),(5,'Sauce',30,10,7),(6,'Pepper',10,10,6),(7,'Cocktail',10,8,11),(8,'Chicken',20,18,2),(9,'Chicken',20,20,2),(10,'Test',10,10,4);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_unit`
--

DROP TABLE IF EXISTS `item_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_unit`
--

LOCK TABLES `item_unit` WRITE;
/*!40000 ALTER TABLE `item_unit` DISABLE KEYS */;
INSERT INTO `item_unit` VALUES (2,'kg'),(3,'g'),(4,'l'),(5,'ml'),(6,'packets'),(7,'Bottels'),(8,'Bundle'),(9,'Bunch'),(10,'mg'),(11,'glance'),(12,'test');
/*!40000 ALTER TABLE `item_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kot`
--

DROP TABLE IF EXISTS `kot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordered_time` datetime DEFAULT NULL,
  `req_time` datetime NOT NULL,
  `meal_time_id` int DEFAULT NULL,
  `kot_status_id` int NOT NULL,
  `customer_visit_hotel_id` int DEFAULT NULL,
  `kot_customer_type_id` int NOT NULL,
  `extra_item_added_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kot_meal_time1_idx` (`meal_time_id`),
  KEY `fk_kot_kot_status1_idx` (`kot_status_id`),
  KEY `fk_kot_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  KEY `fk_kot_kot_customer_type1_idx` (`kot_customer_type_id`),
  KEY `fk_kot_extra_item_added1_idx` (`extra_item_added_id`),
  CONSTRAINT `fk_kot_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`),
  CONSTRAINT `fk_kot_extra_item_added1` FOREIGN KEY (`extra_item_added_id`) REFERENCES `extra_item_added` (`id`),
  CONSTRAINT `fk_kot_kot_customer_type1` FOREIGN KEY (`kot_customer_type_id`) REFERENCES `kot_customer_type` (`id`),
  CONSTRAINT `fk_kot_kot_status1` FOREIGN KEY (`kot_status_id`) REFERENCES `kot_status` (`id`),
  CONSTRAINT `fk_kot_meal_time1` FOREIGN KEY (`meal_time_id`) REFERENCES `meal_time` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kot`
--

LOCK TABLES `kot` WRITE;
/*!40000 ALTER TABLE `kot` DISABLE KEYS */;
INSERT INTO `kot` VALUES (1,'2024-05-17 19:00:00','2024-05-18 19:10:00',3,2,1,1,11),(2,'2024-05-17 19:00:00','2024-05-17 19:10:00',4,4,1,1,10),(3,'2024-05-18 20:00:00','2024-05-18 20:10:00',3,1,4,2,9),(4,'2024-05-18 20:47:07','2024-05-18 20:50:00',3,4,5,2,3),(5,'2024-05-18 21:00:00','2024-05-18 21:05:00',3,2,2,2,4),(6,'2024-05-19 08:00:00','2024-05-19 08:00:00',1,3,1,2,4),(7,'2024-05-27 23:30:31','2024-05-27 23:30:33',1,1,7,1,14),(8,NULL,'2024-06-05 00:16:20',4,1,1,1,1),(9,NULL,'2024-06-05 01:09:45',5,1,NULL,2,1),(10,NULL,'2024-06-05 01:54:22',2,1,5,1,1),(11,NULL,'2024-06-05 02:05:20',3,1,1,2,9),(12,NULL,'2024-06-05 02:11:47',2,1,4,1,2),(13,NULL,'2024-06-05 03:38:54',3,1,2,1,8),(14,NULL,'2024-06-05 03:50:07',5,1,2,1,4),(15,NULL,'2024-06-05 03:53:05',2,1,NULL,2,1),(16,NULL,'2024-06-06 10:20:32',3,1,NULL,2,2);
/*!40000 ALTER TABLE `kot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kot_customer_type`
--

DROP TABLE IF EXISTS `kot_customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kot_customer_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kot_customer_type`
--

LOCK TABLES `kot_customer_type` WRITE;
/*!40000 ALTER TABLE `kot_customer_type` DISABLE KEYS */;
INSERT INTO `kot_customer_type` VALUES (1,'Guest'),(2,'Customer');
/*!40000 ALTER TABLE `kot_customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kot_has_food`
--

DROP TABLE IF EXISTS `kot_has_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kot_has_food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kot_id` int NOT NULL,
  `food_item_id` int NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kot_has_food_kot1_idx` (`kot_id`),
  KEY `fk_kot_has_food_food_item1_idx` (`food_item_id`),
  CONSTRAINT `fk_kot_has_food_food_item1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`),
  CONSTRAINT `fk_kot_has_food_kot1` FOREIGN KEY (`kot_id`) REFERENCES `kot` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kot_has_food`
--

LOCK TABLES `kot_has_food` WRITE;
/*!40000 ALTER TABLE `kot_has_food` DISABLE KEYS */;
INSERT INTO `kot_has_food` VALUES (1,1,13,2),(2,2,36,1),(3,3,12,1),(4,4,11,1),(5,5,23,2),(6,6,16,2),(14,8,21,3),(15,9,40,2),(16,10,11,4),(17,11,11,4),(18,12,23,1),(19,13,33,1),(20,14,38,2),(21,15,12,1),(22,16,28,2);
/*!40000 ALTER TABLE `kot_has_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kot_status`
--

DROP TABLE IF EXISTS `kot_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kot_status` (
  `id` int NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kot_status`
--

LOCK TABLES `kot_status` WRITE;
/*!40000 ALTER TABLE `kot_status` DISABLE KEYS */;
INSERT INTO `kot_status` VALUES (1,'Pending'),(2,'Received'),(3,'Cooking'),(4,'Prepared'),(5,'Delivered');
/*!40000 ALTER TABLE `kot_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laundry_aux`
--

DROP TABLE IF EXISTS `laundry_aux`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laundry_aux` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service_description` text NOT NULL,
  `price_added` double NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_laundry_aux_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_laundry_aux_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laundry_aux`
--

LOCK TABLES `laundry_aux` WRITE;
/*!40000 ALTER TABLE `laundry_aux` DISABLE KEYS */;
INSERT INTO `laundry_aux` VALUES (1,'Electric Iron Provided',1000,1),(2,'Room Applience provided',8000,2),(3,'Laundary Services',1500,3),(4,'Extra pillows',600,5);
/*!40000 ALTER TABLE `laundry_aux` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_time`
--

DROP TABLE IF EXISTS `meal_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal_time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_time`
--

LOCK TABLES `meal_time` WRITE;
/*!40000 ALTER TABLE `meal_time` DISABLE KEYS */;
INSERT INTO `meal_time` VALUES (1,'Breakfast'),(2,'Lunch'),(3,'Dinner'),(4,'Dessart'),(5,'Tea time');
/*!40000 ALTER TABLE `meal_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_services`
--

DROP TABLE IF EXISTS `other_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service` text NOT NULL,
  `price` double NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Other_services_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_Other_services_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_services`
--

LOCK TABLES `other_services` WRITE;
/*!40000 ALTER TABLE `other_services` DISABLE KEYS */;
INSERT INTO `other_services` VALUES (1,'Night Camping',15000,2),(2,'Adventure Tours',20000,1),(3,'Cycle Riding',12000,5),(4,'Family tours',15000,4),(5,'Night Camping',15000,3);
/*!40000 ALTER TABLE `other_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payement_method`
--

DROP TABLE IF EXISTS `payement_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payement_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `method` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payement_method`
--

LOCK TABLES `payement_method` WRITE;
/*!40000 ALTER TABLE `payement_method` DISABLE KEYS */;
INSERT INTO `payement_method` VALUES (1,'Cash'),(2,'Card'),(3,'Pending Payment');
/*!40000 ALTER TABLE `payement_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_assigned_customer`
--

DROP TABLE IF EXISTS `room_assigned_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_assigned_customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `rooms_id` int NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rooms_has_customer_rooms1_idx` (`rooms_id`),
  KEY `fk_room_assigned_customer_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_room_assigned_customer_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`),
  CONSTRAINT `fk_rooms_has_customer_rooms1` FOREIGN KEY (`rooms_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_assigned_customer`
--

LOCK TABLES `room_assigned_customer` WRITE;
/*!40000 ALTER TABLE `room_assigned_customer` DISABLE KEYS */;
INSERT INTO `room_assigned_customer` VALUES (1,'2024-05-15','2024-05-19',2,1),(2,'2024-05-13','2024-05-18',6,4),(3,'2024-05-14','2024-05-20',8,2),(4,'2024-05-18','2024-05-21',5,5),(5,'2024-05-18','2024-05-23',3,3),(6,'2024-05-19','2024-05-25',5,4);
/*!40000 ALTER TABLE `room_assigned_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_status`
--

DROP TABLE IF EXISTS `room_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_status`
--

LOCK TABLES `room_status` WRITE;
/*!40000 ALTER TABLE `room_status` DISABLE KEYS */;
INSERT INTO `room_status` VALUES (1,'Booked'),(2,'Available'),(3,'Preparing'),(4,'Maintaining');
/*!40000 ALTER TABLE `room_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'AC rooms'),(2,'Balconies'),(3,'Double Bed'),(4,'Family'),(5,'Single Bed');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(45) NOT NULL,
  `room_status_id` int NOT NULL,
  `price` double NOT NULL,
  `room_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rooms_room_status1_idx` (`room_status_id`),
  KEY `fk_rooms_room_type1_idx` (`room_type_id`),
  CONSTRAINT `fk_rooms_room_status1` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`id`),
  CONSTRAINT `fk_rooms_room_type1` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'No 1',2,7500,4),(2,'No 2',1,8000,3),(3,'No 3',4,7000,5),(4,'No 4',2,10000,3),(5,'No 5',3,20000,1),(6,'No 6',1,8000,5),(7,'No 7',2,10000,4),(8,'No 8',1,12000,2),(9,'No 9',4,6500,1),(10,'N0 10',3,8500,4);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salary` double NOT NULL,
  `employee_id` int NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `salary_due` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salary_user1_idx` (`employee_id`),
  CONSTRAINT `fk_salary_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (36,85000,7,'2024-04-20','2024-05-20',73000),(38,70000,5,'2024-04-21','2024-05-21',60000),(39,100000,1,'2024-04-22','2024-05-26',85000),(40,70000,8,'2024-04-23','2024-05-23',70000),(41,69000,10,'2024-04-24','2024-05-26',64000),(42,75000,12,'2024-04-26','2024-05-26',65000),(43,80000,3,'2024-05-01','2024-05-31',70000),(44,55000,6,'2024-05-02','2024-06-02',50000),(45,93000,9,'2024-05-03','2024-06-03',80000),(46,100000,4,'2024-05-04','2024-06-04',90000),(47,78000,15,'2024-05-05','2024-06-10',70000),(48,80000,2,'2024-05-10','2024-06-14',65000),(49,85000,16,'2024-05-29','2024-06-29',75000),(50,50000,3,'2024-05-07','2024-06-07',53000),(51,80000,17,'2024-05-29','2024-06-29',79000);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_advance`
--

DROP TABLE IF EXISTS `salary_advance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_advance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `advance` double NOT NULL,
  `salary_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salary_advance_salary1_idx` (`salary_id`),
  CONSTRAINT `fk_salary_advance_salary1` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_advance`
--

LOCK TABLES `salary_advance` WRITE;
/*!40000 ALTER TABLE `salary_advance` DISABLE KEYS */;
INSERT INTO `salary_advance` VALUES (48,5000,36),(49,8000,36),(50,12000,36),(51,10000,38),(52,15000,39),(53,0,40),(54,5000,41),(55,10000,42),(56,10000,43),(57,5000,44),(58,13000,45),(59,10000,46),(60,3000,47),(61,15000,48),(62,8000,47),(63,0,49),(64,5000,49),(65,2000,50),(66,15000,49),(67,10000,49),(68,5000,51),(69,-3000,50),(70,4000,51),(71,3000,51),(72,1000,51);
/*!40000 ALTER TABLE `salary_advance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_address`
--

DROP TABLE IF EXISTS `staff_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `city_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_staff_address_city1_idx` (`city_id`),
  KEY `fk_staff_address_user1_idx` (`employee_id`),
  CONSTRAINT `fk_staff_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_staff_address_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_address`
--

LOCK TABLES `staff_address` WRITE;
/*!40000 ALTER TABLE `staff_address` DISABLE KEYS */;
INSERT INTO `staff_address` VALUES (1,'291/1,','Uduhulpotha',1,1),(2,'303/2,','Boghamadiththa',4,2),(3,'344/5,','2nd lane',1,7),(4,'89/6','Royals street',5,3),(5,'324-10 Havelock Rd','Colombo 05',2,8),(6,'First Cross Street','colombo 05',2,13),(7,'No 373/2','Samagi Mawatha',3,15),(8,'2nd maple Street','colombo 5.',2,16),(9,'345/2','colombo 5',2,17);
/*!40000 ALTER TABLE `staff_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_attendence`
--

DROP TABLE IF EXISTS `staff_attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_attendence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `on_time` datetime NOT NULL,
  `off_time` datetime NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_staff_attendence_user1_idx` (`employee_id`),
  CONSTRAINT `fk_staff_attendence_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_attendence`
--

LOCK TABLES `staff_attendence` WRITE;
/*!40000 ALTER TABLE `staff_attendence` DISABLE KEYS */;
INSERT INTO `staff_attendence` VALUES (1,'2024-05-01','2024-05-01 07:00:00','2024-05-01 22:00:00',2),(2,'2024-05-02','2024-05-02 07:00:00','2024-05-02 22:00:00',3),(3,'2024-05-03','2024-05-03 07:00:00','2024-05-03 22:00:00',2),(4,'2024-05-03','2024-05-03 07:00:00','2024-05-03 22:00:00',3),(5,'2024-05-03','2024-05-03 10:00:00','2024-05-03 21:00:00',6),(6,'2024-05-04','2024-05-04 08:00:00','2024-05-04 19:00:00',1),(7,'2024-05-05','2024-05-05 08:30:00','2024-05-05 19:30:00',4),(8,'2024-05-05','2024-05-05 07:00:00','2024-05-05 22:00:00',5),(9,'2024-05-05','2024-05-05 09:00:00','2024-05-05 18:00:00',2),(10,'2024-05-05','2024-05-05 08:00:00','2024-05-05 20:00:00',3),(11,'2024-05-22','2024-05-22 03:03:04','2024-05-22 09:40:12',3),(12,'2024-05-22','2024-05-22 03:03:07','2024-05-22 09:50:04',7),(13,'2024-05-22','2024-05-22 03:03:10','2024-05-22 09:57:57',10),(14,'2024-05-22','2024-05-22 03:03:08','2024-05-23 02:08:56',8),(15,'2024-05-22','2024-05-22 03:03:07','2024-05-24 23:26:13',7),(16,'2024-05-25','2024-05-25 12:08:42','2024-05-25 12:55:38',13),(17,'2024-05-26','2024-05-26 14:25:28','2024-05-26 15:48:48',15),(18,'2024-05-29','2024-05-29 15:26:37','2024-05-29 15:39:04',17),(19,'2024-05-29','2024-05-29 15:26:37','2024-05-05 17:00:00',17);
/*!40000 ALTER TABLE `staff_attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Active'),(2,'Inactive');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_usage`
--

DROP TABLE IF EXISTS `stock_usage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_usage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `qty` double NOT NULL,
  `item_id` int NOT NULL,
  `department_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_usage_item1_idx` (`item_id`),
  KEY `fk_stock_usage_department1_idx` (`department_id`),
  KEY `fk_stock_usage_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_stock_usage_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_stock_usage_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_stock_usage_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_usage`
--

LOCK TABLES `stock_usage` WRITE;
/*!40000 ALTER TABLE `stock_usage` DISABLE KEYS */;
INSERT INTO `stock_usage` VALUES (1,'2024-05-18',5,1,4,3),(2,'2024-05-17',20,4,4,4);
/*!40000 ALTER TABLE `stock_usage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `mobile` varchar(10) NOT NULL,
  `fname` varchar(25) NOT NULL,
  `lname` varchar(25) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('0712223367','Kumudumalii','Nethsara','kumuneth@gmail.com'),('0712345698','Geeth','Kalhara','geethk@gmail.com'),('0714327832','Saman','De Silva','samanp@gmail.com'),('0743765050','Sewwandi ','Madushi','sewwandimadush@gmail.com'),('0744567890','Yeshitha','Yohan','yyohan@gmail.com'),('0755678900','Chamika','Karunarathna','ckarunarathna@gmail.com'),('0761665789','Heshan','Perera','heshan@gmail.com'),('0771336984','test','test2','test@gmail.com'),('0785432178','Piyumika','Udari','udarisellahewa@gmail.com'),('0786543212','Sahan','De Peris','sahand@gmail.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_schedule`
--

DROP TABLE IF EXISTS `work_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `on_time` datetime NOT NULL,
  `off_time` datetime NOT NULL,
  `employee_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_work_schedule_user1_idx` (`employee_id`),
  KEY `fk_work_schedule_status1_idx` (`status_id`),
  CONSTRAINT `fk_work_schedule_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `fk_work_schedule_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_schedule`
--

LOCK TABLES `work_schedule` WRITE;
/*!40000 ALTER TABLE `work_schedule` DISABLE KEYS */;
INSERT INTO `work_schedule` VALUES (1,'2024-05-18','2024-05-24 17:49:36','2024-05-24 17:49:37',2,1),(2,'2024-05-14','2024-05-24 17:49:39','2024-05-24 17:49:40',2,1),(3,'2024-05-16','2024-05-24 17:49:41','2024-05-24 17:49:42',1,1),(4,'2024-05-16','2024-05-24 17:49:43','2024-05-24 17:49:44',2,2),(5,'2024-05-17','2024-05-24 17:49:45','2024-05-24 17:49:46',3,1),(6,'2024-05-18','2024-05-24 17:49:47','2024-05-24 17:49:48',3,2),(7,'2024-05-29','2024-05-29 14:05:00','2024-05-29 14:05:00',8,2),(8,'2024-05-29','2024-05-29 14:59:00','2024-05-29 17:59:00',8,2);
/*!40000 ALTER TABLE `work_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06 17:12:49
