-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: tarea03aed
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `nombre` varchar(50) NOT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `fechaNacimiento` int DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES ('asd','asd',1922),('MCMAIRE','SCOTLAND',1944),('mcnamara','SCOTLAND',1922),('Pedro','China',1993),('sssss','asd',1922);
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajeros`
--

DROP TABLE IF EXISTS `pasajeros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasajeros` (
  `NUM` int NOT NULL,
  `COD_VUELO` varchar(10) NOT NULL,
  `TIPO_PLAZA` varchar(2) DEFAULT NULL,
  `FUMADOR` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`NUM`,`COD_VUELO`),
  KEY `FK_PASAJEROS` (`COD_VUELO`),
  CONSTRAINT `FK_PASAJEROS` FOREIGN KEY (`COD_VUELO`) REFERENCES `vuelos` (`COD_VUELO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajeros`
--

LOCK TABLES `pasajeros` WRITE;
/*!40000 ALTER TABLE `pasajeros` DISABLE KEYS */;
INSERT INTO `pasajeros` VALUES (123,'IB-SP-4567','TU','NO'),(124,'IB-SP-4567','PR','NO'),(125,'IB-SP-4567','PR','NO'),(126,'FR-DC-4667','PR','NO'),(126,'IB-BA-46DC','TU','NO'),(127,'IB-BA-46DC','PR','NO'),(128,'FR-DC-4667','TU','NO'),(129,'FR-DC-4667','TU','NO'),(130,'AV-DC2-269','TU','NO'),(130,'AV-DC9-233','TU','NO'),(131,'AV-DC2-269','TU','NO'),(131,'AV-DC9-233','TU','NO'),(132,'AV-DC2-269','PR','NO'),(132,'AV-DC9-233','PR','NO'),(133,'AI-1289-9','PR','NO'),(133,'IB-D5-347','PR','NO'),(134,'AI-1289-9','PR','NO'),(134,'IB-D5-347','PR','NO'),(135,'AI-1289-9','TU','NO'),(135,'IB-D5-347','TU','NO'),(136,'AI-1289-9','TU','NO'),(136,'IB-D5-347','TU','NO'),(137,'FR-DC-4667','TU','NO'),(137,'SP-DC-438','TU','NO'),(138,'FR-DC-4667','TU','NO'),(138,'SP-DC-438','TU','NO'),(139,'FR-DC-4667','PR','NO'),(139,'SP-DC-438','PR','NO'),(140,'SP-DC-438','PR','NO'),(141,'FR-DC7-247','PR','NO'),(142,'FR-DC7-247','TU','NO'),(143,'FR-DC7-247','TU','NO');
/*!40000 ALTER TABLE `pasajeros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos` (
  `COD_VUELO` varchar(10) NOT NULL,
  `HORA_SALIDA` varchar(20) DEFAULT NULL,
  `DESTINO` varchar(15) DEFAULT NULL,
  `PROCEDENCIA` varchar(15) DEFAULT NULL,
  `PLAZAS_FUMADOR` int DEFAULT NULL,
  `PLAZAS_NO_FUMADOR` int DEFAULT NULL,
  `PLAZAS_TURISTA` int DEFAULT NULL,
  `PLAZAS_PRIMERA` int DEFAULT NULL,
  PRIMARY KEY (`COD_VUELO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos`
--

LOCK TABLES `vuelos` WRITE;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` VALUES ('AI-1289-9','02/04/99-\n14:30','BARCELONA','BONN',150,100,180,70),('AI-D7-347','30/03/99-\n13:35','BILBAO','MOSCÚ',100,200,210,90),('AV-DC-347','29/03/99-\n13:35','VALENCIA','ROMA',100,200,210,90),('AV-DC2-269','02/04/99-12:00','MADRID','LA \nHAYA',100,100,180,20),('AV-DC9-233','01/04/99-\n17:35','VALENCIA','SOFÍA',100,100,100,100),('FR-DC-4667','28/03/99-\n13:30','BRUSELAS','SEVILLA',90,100,160,30),('FR-DC2-269','01/04/99-\n19:00','CÓRDOBA','MANILA',100,100,180,20),('FR-DC7-247','01/04/99-15:35','CORDOBA','EL \nCAIRO',100,100,100,100),('IB-98779','02/04/99-\n08:00','MADRID','LIMA',200,100,250,50),('IB-BA-46DC','28/03/99-\n12:30','ROMA','MADRID',90,100,160,30),('IB-D5-347','01/04/99-\n13:35','ZARAGOZA','PARIS',100,200,210,90),('IB-SP-4567','27/03/99-\n10:30','PARIS','MADRID',100,100,160,40),('SP-DC-438','30/03/99-\n09:20','MOSCÚ','SEVILLA',90,100,160,30);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-19 11:20:39
