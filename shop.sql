-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `thumbnail` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Car Electronics','./assets/img/cat6.jpg'),(2,'Replacement Parts','./assets/img/35.jpg'),(3,'Smart Electronic Devices','./assets/img/43.jpg'),(30,' Laptop Accessories ','./assets/img/home-banner-2.jpg'),(66,'Office Electronic','./assets/img/61-300x300.jpg'),(83,' Portable Audio & Video ','./assets/img/cat1.jpg'),(96,'flycam','./assets/img/72.jpg'),(100,'Dien thoai','./assets/img/27.jpg');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galleries`
--

DROP TABLE IF EXISTS `galleries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galleries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(1024) DEFAULT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Gallenies_products1_idx` (`product_id`),
  CONSTRAINT `fk_Gallenies_products1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galleries`
--

LOCK TABLES `galleries` WRITE;
/*!40000 ALTER TABLE `galleries` DISABLE KEYS */;
INSERT INTO `galleries` VALUES (1,'http://localhost:8080/CornSaladStore/assets/img/16-300x300.jpg',41),(2,'http://localhost:8080/CornSaladStore/assets/img/17.jpg',41),(3,'http://localhost:8080/CornSaladStore/assets/img/19.jpg',41),(4,'http://localhost:8080/CornSaladStore/assets/img/1.jpg',41),(5,'http://localhost:8080/CornSaladStore/assets/img/20-300x300.jpg',42),(6,'http://localhost:8080/CornSaladStore/assets/img/14-300x300.jpg',43),(7,'http://localhost:8080/CornSaladStore/assets/img/8-300x300.jpg',44),(10,'http://localhost:8080/CornSaladStore/assets/img/5-300x300.jpg',47),(12,'http://localhost:8080/CornSaladStore/assets/img/21.jpg',42),(13,'http://localhost:8080/CornSaladStore/assets/img/22.jpg',42),(14,'http://localhost:8080/CornSaladStore/assets/img/23.jpg',42),(15,'http://localhost:8080/CornSaladStore/assets/img/15.jpg',43),(16,'http://localhost:8080/CornSaladStore/assets/img/9.jpg',44),(17,'http://localhost:8080/CornSaladStore/assets/img/101.jpg',44),(18,'http://localhost:8080/CornSaladStore/assets/img/102.jpg',44),(19,'http://localhost:8080/CornSaladStore/assets/img/6.jpg',47),(20,'http://localhost:8080/CornSaladStore/assets/img/7.jpg',47),(22,'assets/admin/img/products/1-300x300.jpg',49),(23,'assets/admin/img/products/2-720x720.jpg',49),(24,'assets/admin/img/products/4-300x300.jpg',49),(25,'assets/admin/img/products/01.jpg',46),(26,'assets/admin/img/products/02.jpg',46),(27,'assets/admin/img/products/03.jpg',46),(28,'assets/admin/img/products/04.jpg',46),(29,'assets/admin/img/products/22.jpg',48),(30,'assets/admin/img/products/1-300x300.jpg',45),(31,'assets/admin/img/products/2-720x720.jpg',45),(32,'assets/admin/img/products/4-300x300.jpg',45),(33,'assets/admin/img/products/5-chia-o-sac-pz-507-3005-1.jpg',50),(34,'assets/admin/img/products/5-chia-o-sac-pz-507-3005-3.jpg',50),(35,'assets/admin/img/products/24.jpg',51),(36,'assets/admin/img/products/25.jpg',51),(37,'assets/admin/img/products/26.jpg',51),(38,'assets/admin/img/products/27.jpg',52),(39,'assets/admin/img/products/28.jpg',52),(40,'assets/admin/img/products/29.jpg',52),(41,'assets/admin/img/products/30.jpg',52),(42,'assets/admin/img/products/38.jpg',53),(43,'assets/admin/img/products/39.jpg',53),(44,'assets/admin/img/products/40.jpg',53),(45,'assets/admin/img/products/41.jpg',53),(46,'assets/admin/img/products/57.jpg',54),(47,'assets/admin/img/products/58.jpg',54),(48,'assets/admin/img/products/59.jpg',54),(49,'assets/admin/img/products/42.jpg',55),(50,'assets/admin/img/products/43.jpg',55),(51,'assets/admin/img/products/44.jpg',55),(52,'assets/admin/img/products/49.jpg',56),(53,'assets/admin/img/products/50.jpg',56),(54,'assets/admin/img/products/51.jpg',56),(55,'assets/admin/img/products/52.jpg',56),(56,'assets/admin/img/products/65.jpg',57),(57,'assets/admin/img/products/65-300x300.jpg',57),(58,'assets/admin/img/products/66.jpg',57),(59,'assets/admin/img/products/61-300x300.jpg',58),(60,'assets/admin/img/products/62.jpg',58),(61,'assets/admin/img/products/63.jpg',58),(62,'assets/admin/img/products/53.jpg',59),(63,'assets/admin/img/products/54.jpg',59),(64,'assets/admin/img/products/55-300x300.jpg',59),(65,'assets/admin/img/products/69.jpg',60),(66,'assets/admin/img/products/70.jpg',60),(67,'assets/admin/img/products/72.jpg',60);
/*!40000 ALTER TABLE `galleries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order-detais_orders1_idx` (`order_id`),
  KEY `fk_order-items_products1_idx` (`product_id`),
  CONSTRAINT `fk_order-detais_orders1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `fk_order-items_products1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,150,1,41),(2,1,599,2,42),(3,2,599,3,58),(4,1,129,3,59),(5,1,799,4,57),(6,1,799,5,57),(7,1,290,5,52),(8,1,129,6,59),(9,1,43000,7,48);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(1028) NOT NULL,
  `status` varchar(1028) DEFAULT NULL,
  `user_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_orders_users1_idx` (`user_id`),
  CONSTRAINT `fk_orders_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'GfsGV1fgE','finished',2,'2023-06-16 15:11:35'),(2,'8R1is8dVG','pending',2,'2023-06-16 15:21:03'),(3,'zaHLECyfo','pending',1,'2023-06-16 15:38:39'),(4,'ihnSdcXMC','pending',1,'2023-06-16 15:38:43'),(5,'zmJG2rhT5','finished',2,'2023-06-16 15:39:29'),(6,'2oR3wopyC','pending',2,'2023-06-16 16:15:49'),(7,'KFbJqEElT','finished',2,'2023-06-16 16:30:30');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` text,
  `price` decimal(10,0) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `view` int DEFAULT NULL,
  `category_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_products_categories_idx` (`category_id`),
  CONSTRAINT `fk_products_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (41,'Beats Studio Wireless Over-Ear','MP3 / MP4 Player Accessories',150,24,10,1,NULL),(42,'Bose SoundLink Mini','Engine',599,45,11,2,NULL),(43,'Bose® 35 Wireless Headphones','MP3 / MP4 Player Accessories',170,55,101,3,NULL),(44,'Beats Solo3 Wireless On-Ear','Speakers',129,193,2,66,NULL),(45,'AirPods Pro','Electronic Components & Supplies',500,12,124,96,NULL),(46,'Cầu chì 1 ra 8 BX080 đồng nguyên chất','Có Kim Búa Thoát Hiểm',1200,14,3,66,NULL),(47,'UE Megaboom Portable Wireless ','Electronic Components & Supplies',5000,680,4,83,NULL),(48,'LapTop','Engine',43000,366,135,96,NULL),(49,'AirPods','MP3 / MP4 Player Accessories',1200,14,1,66,'2023-05-19 09:11:19'),(50,'Beats Studio Wireless Over-Ear','MP3 / MP4 Player Accessories',150,24,1,96,'2023-05-19 09:23:16'),(51,'Robotic Arm Edge','Engine',599,12,1,96,'2023-05-19 09:23:16'),(52,'Sphero Star Wars BB-8','Accessory Bundles',290,123,157,3,'2023-06-16 15:30:39'),(53,'RoboXplorer Multi Terrain Robotic','Accessory Bundles',129,12,NULL,30,'2023-06-16 15:31:11'),(54,'ExoLens With Optics By ZEISS','Electronic Components & Supplies',129,32,158,66,'2023-06-16 15:31:47'),(55,'Office Electronic','Beautiful',399,12,NULL,66,'2023-06-16 15:32:10'),(56,'Photex FT3150 Black (95463)','Phones & Telecommunications',1350,132,201,66,'2023-06-16 15:32:40'),(57,'flycam','MP3 / MP4 Player Accessories',799,32,333,96,'2023-06-16 15:33:46'),(58,'DJI Mavic Pro Camera Drone','Được sản xuất bởi hãng PZ',599,12,235,100,'2023-06-16 15:34:12'),(59,'Photex FT3150 Black (95463)','Electronic Components & Supplies',129,13,252,100,'2023-06-16 15:34:47'),(60,'flycam','Smart Electronic Devices',1355,12,NULL,96,'2023-06-16 15:35:19');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abc@gmail.com','123','admin'),(2,'nguyennhatminh191a@gmail.com','123','User'),(3,'ngoquocloi2911@gmail.com','12345','Admin'),(4,'abc@gmail.com123','123','User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-16 23:32:00
