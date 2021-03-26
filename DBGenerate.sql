-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `role` varchar(225) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_role`),
  KEY `fk_user` (`id_user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `useruniversity` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN',3),(2,'ROLE_ADMIN',4),(3,'ROLE_USER',1),(4,'ROLE_USER',2),(5,'ROLE_USER',5),(6,'ROLE_USER',6);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id_subject` int NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `schedule` varchar(225) DEFAULT NULL,
  `id_teacher` int DEFAULT NULL,
  `quota_max_students` int DEFAULT NULL,
  PRIMARY KEY (`id_subject`),
  KEY `fk_teacher` (`id_teacher`),
  CONSTRAINT `fk_teacher` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'English','Here will you learn more english for your life, you are the best. ¡Successes!','Monday-Tuesday 08:00 am - 10:00pm',1,39),(2,'Programaming','Here will you learn more Programaming for you laboral life, you are the best. ¡Successes!','Monday-Wednesday-Friday 10:00 am - 12:00pm',2,20),(3,'Theory','You will shoulder know all about programming ¡Successes!','Monday-Wednesday-Friday 03:00 pm - 06:00pm',2,10),(4,'Spanish','Here you will learn lenguaje spanish ¡Successes!','Monday-Friday 12:00 am - 3:00pm',14,10),(5,'English1','Here will you learn more english for your life, you are the best. ¡Successes!','Monday-Tuesday-Friday 08:00 am - 10:00pm',1,9),(6,'Java','Here will you learn more Programaming in JAVA for you laboral life, you are the best. ¡Successes','Wednesday-Friday 05:00 pm - 07:00pm',14,10);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id_teacher` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `DNI` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Julieth','Jolie Manhathan','142029023',1),(2,'Oscar','Bermudez Roberts','4890023',1),(3,'Julio','Brows Santillana','19029023',0),(14,'Yamileth','Baldio Ramirez','7625919',1),(15,'Emily','Betancurth Killaxe','2431114',1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_subject`
--

DROP TABLE IF EXISTS `user_has_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_has_subject` (
  `user_id_user` int NOT NULL,
  `subject_id_subject` int NOT NULL,
  PRIMARY KEY (`user_id_user`,`subject_id_subject`),
  KEY `fk_user_has_subject_subject1_idx` (`subject_id_subject`),
  KEY `fk_user_has_subject_user1_idx` (`user_id_user`),
  CONSTRAINT `fk_user_has_subject_subject1` FOREIGN KEY (`subject_id_subject`) REFERENCES `subject` (`id_subject`),
  CONSTRAINT `fk_user_has_subject_user1` FOREIGN KEY (`user_id_user`) REFERENCES `useruniversity` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_subject`
--

LOCK TABLES `user_has_subject` WRITE;
/*!40000 ALTER TABLE `user_has_subject` DISABLE KEYS */;
INSERT INTO `user_has_subject` VALUES (1,1),(2,1),(2,5);
/*!40000 ALTER TABLE `user_has_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useruniversity`
--

DROP TABLE IF EXISTS `useruniversity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useruniversity` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `number_phone` varchar(45) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `mail` varchar(225) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useruniversity`
--

LOCK TABLES `useruniversity` WRITE;
/*!40000 ALTER TABLE `useruniversity` DISABLE KEYS */;
INSERT INTO `useruniversity` VALUES (1,'456700','Cristhen','James Bill','3208402029','Av 9c #d4','Cristhen@mail.com',25,'$2a$10$9RK4HYyegV8kijLuSMHvq.eqNRZsaZ70wgMT12oHcTxLaVhxL9OJ.'),(2,'456312','Jessica','Cameron Diaz','3219823377','Av Philadelphia 34c','JCameron@mail.com',20,'$2a$10$papN4u.7HV4.c/NKn8FHueCMpwaSivaLqfXlZYd/m4kvYwusirOfy'),(3,'457624','James','Wridel Jener','3140928821','Av Philadelphia 36d','JamesJener@mail.com',21,'$2a$10$m9W3nUc7p6qvQ9z1yytMROz0U6eIoGabhoV4cJzLLEZtw2IefzsUS'),(4,'230013','Roberth Davinson','Huil','3167823411','Av Washinton 16a','RobertDH@mail.com',40,'$2a$10$SFOmMxEzJWCRhlqaLtSMCOqiQYmqoR.S85MqmMZyQ/ufN.whcMykO'),(5,'230014','Gian Josue','James Mendez','3140928829','Av Washinton pp0','Gian123@mail.com',30,'$2a$10$YLhKy2QwoIIHkhyBGUw85e.idXds0X.RkwKDFwFsKUswuyns2NJGS'),(6,'230001','Manuel Nick','Bermudex Huil','3163433411','Av Philadelphia 1a','Manuel@mail.com',24,'$2a$10$GDiu4/6EmzLQTeBwl5W9V.4hWlO4Kwq8I6UD4AlratKdFjGTnPZ8K');
/*!40000 ALTER TABLE `useruniversity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-26 17:34:29
