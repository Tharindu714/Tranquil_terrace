-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for hotel_db
CREATE DATABASE IF NOT EXISTS `hotel_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel_db`;

-- Dumping structure for table hotel_db.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.city: ~6 rows (approximately)
REPLACE INTO `city` (`id`, `name`) VALUES
	(1, 'Bandarwela'),
	(2, 'Nugegoda'),
	(3, 'Haliela'),
	(4, 'Badulla'),
	(5, 'Kaluphana'),
	(6, 'Ella');

-- Dumping structure for table hotel_db.country
CREATE TABLE IF NOT EXISTS `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.country: ~7 rows (approximately)
REPLACE INTO `country` (`id`, `name`) VALUES
	(1, 'Sri Lanka'),
	(2, 'France'),
	(3, 'India'),
	(4, 'Canada'),
	(5, 'Australia'),
	(6, 'England'),
	(7, 'USA');

-- Dumping structure for table hotel_db.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `nic/passport` varchar(20) NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `points` int NOT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`nic/passport`),
  KEY `fk_customer_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_customer_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.customer: ~7 rows (approximately)
REPLACE INTO `customer` (`nic/passport`, `mobile`, `full_name`, `points`, `gender_id`) VALUES
	('200134568902', '+94753457892', 'Sadeesha Nilakshini', 0, 2),
	('200985436497', '+94703900423', 'Prabhashi Tharindya', 0, 2),
	('851246793V', '+94751441845', 'Bhagya Weerasinghe', 2, 2),
	('925671472V', '+94721678925', 'Saman Hettiarachchi', 1, 1),
	('D2H6862M2', '+447450838783', 'Helana Joe', 0, 2),
	('G2N9834K3', '+17588106582', 'Mavis David', 1, 1),
	('NONE', 'NONE', 'NONE', 0, 1);

-- Dumping structure for table hotel_db.customer_address
CREATE TABLE IF NOT EXISTS `customer_address` (
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

-- Dumping data for table hotel_db.customer_address: ~5 rows (approximately)
REPLACE INTO `customer_address` (`id`, `line1`, `line2`, `customer_city_id`, `customer_nic/passport`) VALUES
	(1, '209/1,', 'athulkotte', 7, '851246793V'),
	(2, '2nd lane,', 'Flower Street', 5, 'D2H6862M2'),
	(3, '3rd cross street,', 'Huwakins', 4, 'G2N9834K3'),
	(4, '291/1,', 'Uduhulpotha', 1, '200985436497'),
	(5, '804/6,', 'Samagipura', 8, '925671472V');

-- Dumping structure for table hotel_db.customer_city
CREATE TABLE IF NOT EXISTS `customer_city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_city_country1_idx` (`country_id`),
  CONSTRAINT `fk_customer_city_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.customer_city: ~8 rows (approximately)
REPLACE INTO `customer_city` (`id`, `name`, `country_id`) VALUES
	(1, 'Bandarawela', 1),
	(2, 'Mumbai', 3),
	(3, 'Los Angeles', 7),
	(4, 'Chicago', 7),
	(5, 'London', 6),
	(6, 'Texas ', 7),
	(7, 'Colombo', 1),
	(8, 'Nugegoda', 1),
	(9, 'Ottawa', 4);

-- Dumping structure for table hotel_db.customer_visit_hotel
CREATE TABLE IF NOT EXISTS `customer_visit_hotel` (
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.customer_visit_hotel: ~4 rows (approximately)
REPLACE INTO `customer_visit_hotel` (`id`, `check_in`, `pax`, `check_out`, `total`, `customer_nic/passport`, `payment_method_id`) VALUES
	(1, '2024-05-10 10:00:00', 2, '2024-05-18 15:00:00', 15000, 'G2N9834K3', 1),
	(2, '2024-05-01 14:00:00', 1, '2024-05-18 17:35:57', 50000, 'D2H6862M2', 2),
	(3, '2024-05-05 04:30:00', 4, '2024-05-10 21:00:00', 130000, 'G2N9834K3', 2),
	(4, '2024-05-15 16:00:00', 2, '2024-05-18 17:37:42', 20000, '851246793V', 1),
	(5, '2024-05-17 06:00:00', 4, '2024-05-18 17:38:19', 25000, '925671472V', 2);

-- Dumping structure for table hotel_db.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.department: ~4 rows (approximately)
REPLACE INTO `department` (`id`, `name`) VALUES
	(1, 'Administrator'),
	(2, 'Reception'),
	(3, 'Back Office'),
	(4, 'Kitchen');

-- Dumping structure for table hotel_db.employee
CREATE TABLE IF NOT EXISTS `employee` (
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
  PRIMARY KEY (`id`),
  KEY `fk_user_u8ser_type_idx` (`employee_type_id`),
  KEY `fk_user_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_user_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_user_u8ser_type` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.employee: ~10 rows (approximately)
REPLACE INTO `employee` (`id`, `first_name`, `last_name`, `mobile`, `username`, `password`, `status`, `registered_date`, `employee_type_id`, `gender_id`, `loggedtime`) VALUES
	(1, 'Tharindu', 'Chanaka', '0751441764', 'TChanaka', 'tharindu1122', 1, '2024-03-20', 1, 1, '2024-05-22 03:03:01'),
	(2, 'Sadeesha', 'Nilakshini', '0747179730', 'SNilakshini', 'Sadeesha123', 1, '2024-03-18', 1, 2, '2024-05-22 03:03:03'),
	(3, 'Kasuni', 'Jayamali', '0748763400', 'KJayamali2003', 'KasuniJaYamaLI6785', 1, '2024-04-01', 4, 2, '2024-05-22 03:03:04'),
	(4, 'Maleesha', 'Shehan', '0754329874', 'MShehan', 'Malee789', 1, '2024-05-10', 3, 1, '2024-05-22 03:03:05'),
	(5, 'Dhanushka', 'Lakmal', '0712346789', 'DLakmal', 'LakmalD865', 1, '2024-05-01', 2, 1, '2024-05-22 03:03:06'),
	(6, 'Kavindaya', 'Rathnayaka', '0785670034', 'SKavindaya', 'kaveS567', 1, '2024-04-12', 5, 2, '2024-05-22 03:03:07'),
	(7, 'Sandaruwan', 'Jayasinghe', '0781236743', 'sandaruwan De Jaysinghe', 'sandaru123', 1, '2024-05-20', 4, 1, '2024-05-22 03:03:07'),
	(8, 'Anya', 'Hasalwood', '0712346790', 'AHasalwood678', 'anya456haselwood', 1, '2024-05-20', 4, 2, '2024-05-22 03:03:08'),
	(9, 'Madushanka', 'Lakmal', '0763472300', 'MaduLakmal', 'Madushanka8790', 1, '2024-05-20', 1, 1, '2024-05-22 03:03:09'),
	(10, 'Brayan', 'Gabrial', '0785641234', 'BGabrial', 'bgnotme335', 1, '2024-05-21', 4, 1, '2024-05-22 03:03:10'),
	(11, 'Tharaka', 'Sankalpa', '0765432390', 'Tharka@JavaInstitute', 'tharakasankalpa678', 1, '2024-05-22', 1, 1, '2024-05-22 03:05:09');

-- Dumping structure for table hotel_db.employee_type
CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.employee_type: ~4 rows (approximately)
REPLACE INTO `employee_type` (`id`, `type`) VALUES
	(1, 'Administrator'),
	(2, 'Staff'),
	(3, 'Receptionist'),
	(4, 'HR'),
	(5, 'Kitchen Operator');

-- Dumping structure for table hotel_db.eq_category
CREATE TABLE IF NOT EXISTS `eq_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.eq_category: ~8 rows (approximately)
REPLACE INTO `eq_category` (`id`, `name`) VALUES
	(1, 'Electronic Items'),
	(2, 'Bedding & linens'),
	(3, 'Furniture Items'),
	(4, 'Appliances'),
	(5, 'Bathroom Amenities'),
	(6, 'Decor Items'),
	(7, 'Stationary & Information'),
	(8, 'Maintenance Tools');

-- Dumping structure for table hotel_db.eq_status
CREATE TABLE IF NOT EXISTS `eq_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.eq_status: ~2 rows (approximately)
REPLACE INTO `eq_status` (`id`, `status`) VALUES
	(1, 'Active'),
	(2, 'Inactive');

-- Dumping structure for table hotel_db.food_category
CREATE TABLE IF NOT EXISTS `food_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.food_category: ~11 rows (approximately)
REPLACE INTO `food_category` (`id`, `category`) VALUES
	(1, 'Soup'),
	(2, 'Salad'),
	(3, 'Juice'),
	(4, 'Rice'),
	(5, 'Noodles'),
	(6, 'Spegatti'),
	(7, 'Macaroni'),
	(8, 'Devilled'),
	(9, 'Chicken'),
	(10, 'Fried foods'),
	(11, 'Fish'),
	(12, 'Dessert'),
	(13, 'Hot Drinks');

-- Dumping structure for table hotel_db.food_item
CREATE TABLE IF NOT EXISTS `food_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `food_category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_food_item_food_category1_idx` (`food_category_id`),
  CONSTRAINT `fk_food_item_food_category1` FOREIGN KEY (`food_category_id`) REFERENCES `food_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.food_item: ~34 rows (approximately)
REPLACE INTO `food_item` (`id`, `name`, `price`, `food_category_id`) VALUES
	(3, 'Vegitable Soup', 350, 1),
	(4, 'Chicken Soup', 550, 1),
	(5, 'Cucumber Salad', 200, 2),
	(6, 'Vegetable Mixed Salad', 350, 2),
	(7, 'Fruit Salad', 400, 2),
	(8, 'Lime Juice', 200, 3),
	(9, 'Mixed Fruit Juice', 450, 3),
	(10, 'Vegetable Rice ', 500, 4),
	(11, 'Chicken Rice Samba', 600, 4),
	(12, 'Chicken Rice Basmati', 700, 4),
	(13, 'Mixed Rice', 1000, 4),
	(14, 'Biriyani', 1000, 4),
	(15, 'Nasi goreng ', 1250, 4),
	(16, 'Egg Noodles', 650, 5),
	(17, 'Chicken Fried Noodles', 750, 5),
	(18, 'Mixed Noodles', 950, 5),
	(19, 'Cheese Spegatti', 900, 6),
	(20, 'Sea food Spegatti', 1050, 6),
	(21, 'Cheese Macaroni', 850, 7),
	(22, 'Prawn cheese Macaroni', 1050, 7),
	(23, 'Chicken Devilled', 950, 8),
	(24, 'Cuttlefish Devilled', 1100, 8),
	(25, 'Mixed Devilled', 1600, 8),
	(26, 'Fish Devilled', 950, 8),
	(27, 'Pepper Chicken', 1100, 9),
	(28, 'Chicken Steak ', 1600, 9),
	(29, 'Roasted Chicken', 2600, 9),
	(30, 'Potato Chips', 700, 10),
	(31, 'Fried Chicken', 950, 10),
	(32, 'Fried Sausages', 700, 10),
	(33, 'Spicy Fish', 1050, 11),
	(34, 'Pepper Fish', 1050, 11),
	(35, 'Hot Butter Fish', 1050, 11),
	(36, 'Watalappan', 400, 12),
	(37, 'Ice Cream', 350, 12),
	(38, 'Tea', 200, 13),
	(39, 'Coffee', 200, 13),
	(40, 'Hot Chocalate ', 350, 13);

-- Dumping structure for table hotel_db.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.gender: ~2 rows (approximately)
REPLACE INTO `gender` (`id`, `gender`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table hotel_db.grn
CREATE TABLE IF NOT EXISTS `grn` (
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

-- Dumping data for table hotel_db.grn: ~9 rows (approximately)
REPLACE INTO `grn` (`id`, `date`, `supplier_mobile`, `payment_method_id`) VALUES
	(1, '2024-05-02', '0712345698', 1),
	(2, '2024-05-02', '0761665789', 2),
	(3, '2024-05-02', '0785432178', 2),
	(4, '2024-05-03', '0714327832', 2),
	(5, '2024-05-04', '0743765050', 1),
	(6, '2024-05-04', '0712345698', 2),
	(7, '2024-05-05', '0761665789', 2),
	(8, '2024-05-06', '0785432178', 1),
	(9, '2024-05-10', '0714327832', 1),
	(10, '2024-05-12', '0785432178', 1);

-- Dumping structure for table hotel_db.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
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

-- Dumping data for table hotel_db.grn_item: ~4 rows (approximately)
REPLACE INTO `grn_item` (`id`, `unit_price`, `qty`, `expiry_date`, `grn_id`, `item_id`) VALUES
	(1, 100, 30, '2025-05-18', 1, 4),
	(2, 1000, 10, '2024-07-10', 5, 1),
	(3, 1400, 5, '2024-06-18', 4, 3),
	(4, 600, 13, '2024-07-01', 9, 2);

-- Dumping structure for table hotel_db.hotel_eq
CREATE TABLE IF NOT EXISTS `hotel_eq` (
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.hotel_eq: ~13 rows (approximately)
REPLACE INTO `hotel_eq` (`id`, `name`, `department_id`, `eq_category_id`, `eq_status_id`) VALUES
	(1, 'Telephones', 2, 1, 1),
	(2, 'Microwave', 4, 1, 1),
	(3, 'Fans', 2, 1, 1),
	(4, 'Routers', 2, 1, 1),
	(5, 'Bed & other furnitures', 1, 3, 1),
	(6, 'Chairs & Table', 1, 3, 1),
	(7, 'Soap & Shampoo', 1, 5, 1),
	(8, 'Sachet food items', 4, 4, 1),
	(9, 'Bed sheets & Pillows', 1, 2, 1),
	(10, 'Flower vases', 1, 6, 1),
	(11, 'Wall hangers', 1, 6, 1),
	(12, 'Employee Stationaries', 1, 7, 1),
	(17, 'Dishwashing Bar', 4, 8, 1);

-- Dumping structure for table hotel_db.ingrediant
CREATE TABLE IF NOT EXISTS `ingrediant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` double NOT NULL,
  `food_item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ingrediant_food_item1_idx` (`food_item_id`),
  CONSTRAINT `fk_ingrediant_food_item1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.ingrediant: ~11 rows (approximately)
REPLACE INTO `ingrediant` (`id`, `qty`, `food_item_id`) VALUES
	(1, 1, 14),
	(2, 2, 26),
	(3, 1, 19),
	(4, 2, 7),
	(5, 3, 8),
	(6, 1, 4),
	(7, 2, 16),
	(8, 3, 13),
	(9, 4, 36),
	(10, 2, 15),
	(11, 2, 38);

-- Dumping structure for table hotel_db.item
CREATE TABLE IF NOT EXISTS `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `min_qty` double NOT NULL,
  `current_qty` double NOT NULL,
  `item_unit_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_item_unit1_idx` (`item_unit_id`),
  CONSTRAINT `fk_item_item_unit1` FOREIGN KEY (`item_unit_id`) REFERENCES `item_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.item: ~5 rows (approximately)
REPLACE INTO `item` (`id`, `name`, `min_qty`, `current_qty`, `item_unit_id`) VALUES
	(1, 'Chicken', 5, 5, 2),
	(2, 'Lime', 6, 4, 2),
	(3, 'Chilli 1kg', 2, 3, 6),
	(4, 'Coca Cola', 20, 10, 7),
	(5, 'Sauce', 30, 10, 7),
	(6, 'Pepper', 10, 10, 6);

-- Dumping structure for table hotel_db.item_unit
CREATE TABLE IF NOT EXISTS `item_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.item_unit: ~6 rows (approximately)
REPLACE INTO `item_unit` (`id`, `unit`) VALUES
	(2, 'kg'),
	(3, 'g'),
	(4, 'l'),
	(5, 'ml'),
	(6, 'packets'),
	(7, 'Bottels'),
	(8, 'Bundle');

-- Dumping structure for table hotel_db.kot
CREATE TABLE IF NOT EXISTS `kot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordered_time` datetime NOT NULL,
  `req_time` datetime NOT NULL,
  `meal_time_id` int NOT NULL,
  `kot_status_id` int NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kot_meal_time1_idx` (`meal_time_id`),
  KEY `fk_kot_kot_status1_idx` (`kot_status_id`),
  KEY `fk_kot_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_kot_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`),
  CONSTRAINT `fk_kot_kot_status1` FOREIGN KEY (`kot_status_id`) REFERENCES `kot_status` (`id`),
  CONSTRAINT `fk_kot_meal_time1` FOREIGN KEY (`meal_time_id`) REFERENCES `meal_time` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.kot: ~6 rows (approximately)
REPLACE INTO `kot` (`id`, `ordered_time`, `req_time`, `meal_time_id`, `kot_status_id`, `customer_visit_hotel_id`) VALUES
	(1, '2024-05-17 19:00:00', '2024-05-18 19:10:00', 3, 5, 1),
	(2, '2024-05-17 19:00:00', '2024-05-17 19:10:00', 4, 5, 1),
	(3, '2024-05-18 20:00:00', '2024-05-18 20:10:00', 3, 3, 4),
	(4, '2024-05-18 20:47:07', '2024-05-18 20:50:00', 3, 1, 5),
	(5, '2024-05-18 21:00:00', '2024-05-18 21:05:00', 3, 2, 2),
	(6, '2024-05-19 08:00:00', '2024-05-19 08:00:00', 1, 1, 1);

-- Dumping structure for table hotel_db.kot_has_food
CREATE TABLE IF NOT EXISTS `kot_has_food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kot_id` int NOT NULL,
  `food_item_id` int NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kot_has_food_kot1_idx` (`kot_id`),
  KEY `fk_kot_has_food_food_item1_idx` (`food_item_id`),
  CONSTRAINT `fk_kot_has_food_food_item1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`),
  CONSTRAINT `fk_kot_has_food_kot1` FOREIGN KEY (`kot_id`) REFERENCES `kot` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.kot_has_food: ~6 rows (approximately)
REPLACE INTO `kot_has_food` (`id`, `kot_id`, `food_item_id`, `qty`) VALUES
	(1, 1, 13, 2),
	(2, 2, 36, 2),
	(3, 3, 12, 1),
	(4, 4, 11, 1),
	(5, 5, 23, 2),
	(6, 6, 16, 2);

-- Dumping structure for table hotel_db.kot_status
CREATE TABLE IF NOT EXISTS `kot_status` (
  `id` int NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.kot_status: ~4 rows (approximately)
REPLACE INTO `kot_status` (`id`, `status`) VALUES
	(1, 'Pending'),
	(2, 'Received'),
	(3, 'Cooking'),
	(4, 'Prepared'),
	(5, 'Delivered');

-- Dumping structure for table hotel_db.laundry_aux
CREATE TABLE IF NOT EXISTS `laundry_aux` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service_description` text NOT NULL,
  `price_added` double NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_laundry_aux_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_laundry_aux_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.laundry_aux: ~4 rows (approximately)
REPLACE INTO `laundry_aux` (`id`, `service_description`, `price_added`, `customer_visit_hotel_id`) VALUES
	(1, 'Electric Iron Provided', 1000, 1),
	(2, 'Room Applience provided', 8000, 2),
	(3, 'Laundary Services', 1500, 3),
	(4, 'Extra pillows', 600, 5);

-- Dumping structure for table hotel_db.meal_time
CREATE TABLE IF NOT EXISTS `meal_time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.meal_time: ~5 rows (approximately)
REPLACE INTO `meal_time` (`id`, `type`) VALUES
	(1, 'Breakfast'),
	(2, 'Lunch'),
	(3, 'Dinner'),
	(4, 'Dessart'),
	(5, 'Tea time');

-- Dumping structure for table hotel_db.other_services
CREATE TABLE IF NOT EXISTS `other_services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service` text NOT NULL,
  `price` double NOT NULL,
  `customer_visit_hotel_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Other_services_custermer_visit_hotel1_idx` (`customer_visit_hotel_id`),
  CONSTRAINT `fk_Other_services_custermer_visit_hotel1` FOREIGN KEY (`customer_visit_hotel_id`) REFERENCES `customer_visit_hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.other_services: ~4 rows (approximately)
REPLACE INTO `other_services` (`id`, `service`, `price`, `customer_visit_hotel_id`) VALUES
	(1, 'Night Camping', 15000, 2),
	(2, 'Adventure Tours', 20000, 1),
	(3, 'Cycle Riding', 12000, 5),
	(4, 'Family tours', 15000, 4),
	(5, 'Night Camping', 15000, 3);

-- Dumping structure for table hotel_db.payement_method
CREATE TABLE IF NOT EXISTS `payement_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `method` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.payement_method: ~2 rows (approximately)
REPLACE INTO `payement_method` (`id`, `method`) VALUES
	(1, 'Cash'),
	(2, 'Card');

-- Dumping structure for table hotel_db.res_order
CREATE TABLE IF NOT EXISTS `res_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` datetime NOT NULL,
  `total` double NOT NULL,
  `payment_method_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_res_order_payment_method1_idx` (`payment_method_id`),
  CONSTRAINT `FK_res_order_payement_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payement_method` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.res_order: ~4 rows (approximately)
REPLACE INTO `res_order` (`id`, `order_date`, `total`, `payment_method_id`) VALUES
	(1, '2024-05-18 20:58:36', 1500, 1),
	(2, '2024-05-18 20:58:39', 2000, 2),
	(3, '2024-05-18 17:00:00', 1000, 2),
	(4, '2024-05-19 10:59:12', 1700, 1),
	(5, '2024-05-19 13:00:00', 2500, 2);

-- Dumping structure for table hotel_db.res_order_has_food_item
CREATE TABLE IF NOT EXISTS `res_order_has_food_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `res_order_id` int NOT NULL,
  `food_item_id` int NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_res_order_has_food_item_food_item1_idx` (`food_item_id`),
  KEY `fk_res_order_has_food_item_res_order1_idx` (`res_order_id`),
  CONSTRAINT `fk_res_order_has_food_item_food_item1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`),
  CONSTRAINT `fk_res_order_has_food_item_res_order1` FOREIGN KEY (`res_order_id`) REFERENCES `res_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.res_order_has_food_item: ~4 rows (approximately)
REPLACE INTO `res_order_has_food_item` (`id`, `res_order_id`, `food_item_id`, `qty`) VALUES
	(1, 1, 12, 1),
	(2, 2, 26, 2),
	(3, 3, 16, 1),
	(4, 4, 14, 2),
	(5, 5, 9, 6);

-- Dumping structure for table hotel_db.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(45) NOT NULL,
  `room_status_id` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rooms_room_status1_idx` (`room_status_id`),
  CONSTRAINT `fk_rooms_room_status1` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.rooms: ~8 rows (approximately)
REPLACE INTO `rooms` (`id`, `room_name`, `room_status_id`, `price`) VALUES
	(1, 'No 1', 2, 7500),
	(2, 'No 2', 1, 8000),
	(3, 'No 3', 4, 7000),
	(4, 'No 4', 2, 10000),
	(5, 'No 5', 3, 20000),
	(6, 'No 6', 1, 8000),
	(7, 'No 7', 2, 10000),
	(8, 'No 8', 1, 12000),
	(9, 'No 9', 4, 6500),
	(10, 'N0 10', 3, 8500);

-- Dumping structure for table hotel_db.room_assigned_customer
CREATE TABLE IF NOT EXISTS `room_assigned_customer` (
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

-- Dumping data for table hotel_db.room_assigned_customer: ~6 rows (approximately)
REPLACE INTO `room_assigned_customer` (`id`, `from_date`, `to_date`, `rooms_id`, `customer_visit_hotel_id`) VALUES
	(1, '2024-05-15', '2024-05-19', 2, 1),
	(2, '2024-05-13', '2024-05-18', 6, 4),
	(3, '2024-05-14', '2024-05-20', 8, 2),
	(4, '2024-05-18', '2024-05-21', 5, 5),
	(5, '2024-05-18', '2024-05-23', 3, 3),
	(6, '2024-05-19', '2024-05-25', 5, 4);

-- Dumping structure for table hotel_db.room_status
CREATE TABLE IF NOT EXISTS `room_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.room_status: ~4 rows (approximately)
REPLACE INTO `room_status` (`id`, `status`) VALUES
	(1, 'Booked'),
	(2, 'Available'),
	(3, 'Preparing'),
	(4, 'Maintaining');

-- Dumping structure for table hotel_db.salary
CREATE TABLE IF NOT EXISTS `salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salary` double NOT NULL,
  `employee_id` int NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `salary_due` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salary_user1_idx` (`employee_id`),
  CONSTRAINT `fk_salary_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.salary: ~4 rows (approximately)
REPLACE INTO `salary` (`id`, `salary`, `employee_id`, `from_date`, `to_date`, `salary_due`) VALUES
	(12, 60000, 7, '2024-04-01', '2024-05-01', 60000),
	(13, 100000, 7, '2024-04-01', '2024-05-21', 0),
	(14, 40000, 3, '2024-05-01', '2024-05-21', 30000),
	(15, 75000, 8, '2024-04-03', '2024-05-01', 73000);

-- Dumping structure for table hotel_db.salary_advance
CREATE TABLE IF NOT EXISTS `salary_advance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `advance` double NOT NULL,
  `salary_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salary_advance_salary1_idx` (`salary_id`),
  CONSTRAINT `fk_salary_advance_salary1` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.salary_advance: ~3 rows (approximately)
REPLACE INTO `salary_advance` (`id`, `advance`, `salary_id`) VALUES
	(12, 49000, 13),
	(13, 10000, 14),
	(14, 2000, 15);

-- Dumping structure for table hotel_db.staff_address
CREATE TABLE IF NOT EXISTS `staff_address` (
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.staff_address: ~4 rows (approximately)
REPLACE INTO `staff_address` (`id`, `line1`, `line2`, `city_id`, `employee_id`) VALUES
	(1, '291/1,', 'Uduhulpotha', 1, 1),
	(2, '303/2,', 'Boghamadiththa', 4, 2),
	(3, '344/5,', '2nd lane', 1, 7),
	(4, '89/6', 'Royals street', 5, 3),
	(5, '324-10 Havelock Rd', 'Colombo 05', 2, 8);

-- Dumping structure for table hotel_db.staff_attendence
CREATE TABLE IF NOT EXISTS `staff_attendence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `on_time` datetime NOT NULL,
  `off_time` datetime NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_staff_attendence_user1_idx` (`employee_id`),
  CONSTRAINT `fk_staff_attendence_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.staff_attendence: ~8 rows (approximately)
REPLACE INTO `staff_attendence` (`id`, `date`, `on_time`, `off_time`, `employee_id`) VALUES
	(1, '2024-05-01', '2024-05-01 07:00:00', '2024-05-01 22:00:00', 2),
	(2, '2024-05-02', '2024-05-02 07:00:00', '2024-05-02 22:00:00', 3),
	(3, '2024-05-03', '2024-05-03 07:00:00', '2024-05-03 22:00:00', 2),
	(4, '2024-05-03', '2024-05-03 07:00:00', '2024-05-03 22:00:00', 3),
	(5, '2024-05-03', '2024-05-03 10:00:00', '2024-05-03 21:00:00', 6),
	(6, '2024-05-04', '2024-05-04 08:00:00', '2024-05-04 19:00:00', 1),
	(7, '2024-05-05', '2024-05-05 08:30:00', '2024-05-05 19:30:00', 4),
	(8, '2024-05-05', '2024-05-05 07:00:00', '2024-05-05 22:00:00', 5),
	(9, '2024-05-05', '2024-05-05 09:00:00', '2024-05-05 18:00:00', 2),
	(10, '2024-05-05', '2024-05-05 08:00:00', '2024-05-05 20:00:00', 3),
	(11, '2024-05-22', '2024-05-22 03:03:04', '2024-05-22 09:40:12', 3),
	(12, '2024-05-22', '2024-05-22 03:03:07', '2024-05-22 09:50:04', 7);

-- Dumping structure for table hotel_db.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.status: ~2 rows (approximately)
REPLACE INTO `status` (`id`, `type`) VALUES
	(1, 'Active'),
	(2, 'Inactive');

-- Dumping structure for table hotel_db.stock_usage
CREATE TABLE IF NOT EXISTS `stock_usage` (
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

-- Dumping data for table hotel_db.stock_usage: ~0 rows (approximately)
REPLACE INTO `stock_usage` (`id`, `date`, `qty`, `item_id`, `department_id`, `employee_id`) VALUES
	(1, '2024-05-18', 5, 1, 4, 3),
	(2, '2024-05-17', 20, 4, 4, 4);

-- Dumping structure for table hotel_db.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `mobile` varchar(10) NOT NULL,
  `fname` varchar(25) NOT NULL,
  `lname` varchar(25) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.supplier: ~4 rows (approximately)
REPLACE INTO `supplier` (`mobile`, `fname`, `lname`, `email`) VALUES
	('0712345698', 'Geeth', 'Kalhara', 'geethk@gmail.com'),
	('0714327832', 'Saman', 'Perera', 'samanp@gmail.com'),
	('0743765050', 'Sewwandi ', 'Madushi', 'sewwandimadush@gmail.com'),
	('0761665789', 'Heshan', 'Muditha', 'heshan@gmail.com'),
	('0785432178', 'Piyumika', 'Udari', 'udarisellahewa@gmail.com');

-- Dumping structure for table hotel_db.work_schedule
CREATE TABLE IF NOT EXISTS `work_schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `employee_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_work_schedule_user1_idx` (`employee_id`),
  KEY `fk_work_schedule_status1_idx` (`status_id`),
  CONSTRAINT `fk_work_schedule_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `fk_work_schedule_user1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel_db.work_schedule: ~6 rows (approximately)
REPLACE INTO `work_schedule` (`id`, `date`, `employee_id`, `status_id`) VALUES
	(1, '2024-05-18', 2, 1),
	(2, '2024-05-14', 2, 1),
	(3, '2024-05-16', 1, 1),
	(4, '2024-05-16', 2, 2),
	(5, '2024-05-17', 3, 1),
	(6, '2024-05-18', 3, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
