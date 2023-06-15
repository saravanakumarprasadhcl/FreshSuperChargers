-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: freshersuperchargers
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
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_details` (
  `sap_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alternate_contact_no` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender_key` varchar(255) DEFAULT NULL,
  `region_key` varchar(255) DEFAULT NULL,
  `state_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sap_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES (52070399,'up',NULL,'7454909729','sarajaved09@gmail.com','Sara Javed','FEMALE','NORTH','IN-BR'),(4567,'#92, MEL PALUR, VADAKKU STREET,KALSAPAKAM TALUK, TIRUVANNAMALAI - 623120',NULL,'6379894104','ebala9355@gmail.com','E BALAKRISHNAN','MALE','SOUTH','IN-TN'),(52115007,'At post KhAMe ,near pirachi vihir, TAM-patan Distsatara,Satara,Maharashtra',NULL,'7028230060','kacharejeevan@gmail.com','kachare Jeevan Jalindar','MALE','WEST','IN-MH'),(52115005,'NEW NANDANVAN, GURUDEV NAGAR NAGPUR.,Nagpur,Maharashtra',NULL,'8767024032','mo7770742@gmail.com,','OMKAR AMOLRAO SHENDE','MALE','WEST','IN-MH');
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_educational_details`
--

DROP TABLE IF EXISTS `employee_educational_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_educational_details` (
  `id` bigint NOT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `graduation_college` varchar(255) DEFAULT NULL,
  `graduation_passing_year` varchar(255) DEFAULT NULL,
  `high_school_passing_year` varchar(255) DEFAULT NULL,
  `intermediate_passing_year` varchar(255) DEFAULT NULL,
  `intermediate_percentage` varchar(255) DEFAULT NULL,
  `pg_college_name` varchar(255) DEFAULT NULL,
  `post_graduation_degree` varchar(255) DEFAULT NULL,
  `post_graduation_passing_year` varchar(255) DEFAULT NULL,
  `post_graduation_percentage` varchar(255) DEFAULT NULL,
  `post_graduation_specialisation` varchar(255) DEFAULT NULL,
  `sap_id` bigint DEFAULT NULL,
  `university_registration_id` bigint DEFAULT NULL,
  `graduation_specialization_key` varchar(255) DEFAULT NULL,
  `ug_degree_key` varchar(255) DEFAULT NULL,
  `ug_or_pg_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_educational_details`
--

LOCK TABLES `employee_educational_details` WRITE;
/*!40000 ALTER TABLE `employee_educational_details` DISABLE KEYS */;
INSERT INTO `employee_educational_details` VALUES (1,'2022','Padmahree Dr. D.Y.Patil Institue Of Engineering and Technology, Pune','2018','2012','2014',NULL,NULL,NULL,NULL,NULL,NULL,52115007,NULL,NULL,'B.TECH/B.E',NULL);
/*!40000 ALTER TABLE `employee_educational_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_educational_details_seq`
--

DROP TABLE IF EXISTS `employee_educational_details_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_educational_details_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_educational_details_seq`
--

LOCK TABLES `employee_educational_details_seq` WRITE;
/*!40000 ALTER TABLE `employee_educational_details_seq` DISABLE KEYS */;
INSERT INTO `employee_educational_details_seq` VALUES (51);
/*!40000 ALTER TABLE `employee_educational_details_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_onboarding_details`
--

DROP TABLE IF EXISTS `employee_onboarding_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_onboarding_details` (
  `id` bigint NOT NULL,
  `br` varchar(255) DEFAULT NULL,
  `fpm_spoc` varchar(255) DEFAULT NULL,
  `drive_college` varchar(255) DEFAULT NULL,
  `drive_date` varchar(255) DEFAULT NULL,
  `h1orh2` varchar(255) DEFAULT NULL,
  `intern_joining_date` varchar(255) DEFAULT NULL,
  `intern_joining_status` varchar(255) DEFAULT NULL,
  `intern_sapid` varchar(255) DEFAULT NULL,
  `joining_status` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `onbaording_details` varchar(255) DEFAULT NULL,
  `onboarding_status` varchar(255) DEFAULT NULL,
  `planneddoj` varchar(255) DEFAULT NULL,
  `preotpstatus` varchar(255) DEFAULT NULL,
  `requisition_source` varchar(255) DEFAULT NULL,
  `sap_id` bigint DEFAULT NULL,
  `tentativedoj` varchar(255) DEFAULT NULL,
  `tentative_joining_month` varchar(255) DEFAULT NULL,
  `tentative_joiningqtr` varchar(255) DEFAULT NULL,
  `tp_panel` varchar(255) DEFAULT NULL,
  `tp_sap` varchar(255) DEFAULT NULL,
  `college_tiering_key` varchar(255) DEFAULT NULL,
  `location_key` varchar(255) DEFAULT NULL,
  `offered_band_key` varchar(255) DEFAULT NULL,
  `offered_designation_key` varchar(255) DEFAULT NULL,
  `offered_sub_band_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_onboarding_details`
--

LOCK TABLES `employee_onboarding_details` WRITE;
/*!40000 ALTER TABLE `employee_onboarding_details` DISABLE KEYS */;
INSERT INTO `employee_onboarding_details` VALUES (1,NULL,NULL,'CDAC Noida ','26/05/2022','ERROR:#NAME?',NULL,NULL,NULL,'Joined','Aug',NULL,'Pending for Joining','17-Aug-22',NULL,NULL,52115007,NULL,NULL,NULL,'Shwetank Gupta ',NULL,NULL,NULL,'E1','SSE','E1.2'),(2,NULL,NULL,'CDAC Noida ','26/05/2022','ERROR:#NAME?',NULL,NULL,NULL,'Joined','Aug',NULL,'Pending for Joining','17-Aug-22',NULL,NULL,52115005,NULL,NULL,NULL,'Hemant Mahadik',NULL,NULL,NULL,'E1','SSE','E1.2');
/*!40000 ALTER TABLE `employee_onboarding_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_onboarding_details_seq`
--

DROP TABLE IF EXISTS `employee_onboarding_details_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_onboarding_details_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_onboarding_details_seq`
--

LOCK TABLES `employee_onboarding_details_seq` WRITE;
/*!40000 ALTER TABLE `employee_onboarding_details_seq` DISABLE KEYS */;
INSERT INTO `employee_onboarding_details_seq` VALUES (101);
/*!40000 ALTER TABLE `employee_onboarding_details_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_recruitment_details`
--

DROP TABLE IF EXISTS `employee_recruitment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_recruitment_details` (
  `id` int NOT NULL,
  `candidate_mapping` varchar(255) DEFAULT NULL,
  `demand_owner` varchar(255) DEFAULT NULL,
  `demand_ownersap` varchar(255) DEFAULT NULL,
  `hr_panel` varchar(255) DEFAULT NULL,
  `project_skills` varchar(255) DEFAULT NULL,
  `remapped_location` varchar(255) DEFAULT NULL,
  `remapped_profile` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `sap_id` bigint DEFAULT NULL,
  `sr_mapping` varchar(255) DEFAULT NULL,
  `sr_number` varchar(255) DEFAULT NULL,
  `sr_status` varchar(255) DEFAULT NULL,
  `team_rdu` varchar(255) DEFAULT NULL,
  `l1_key` varchar(255) DEFAULT NULL,
  `l2_key` varchar(255) DEFAULT NULL,
  `l3_key` varchar(255) DEFAULT NULL,
  `l4_key` varchar(255) DEFAULT NULL,
  `lob_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_recruitment_details`
--

LOCK TABLES `employee_recruitment_details` WRITE;
/*!40000 ALTER TABLE `employee_recruitment_details` DISABLE KEYS */;
INSERT INTO `employee_recruitment_details` VALUES (1,NULL,'Kiran G Kumar (Not Listed)','Not Listed',NULL,NULL,NULL,NULL,NULL,52115007,NULL,'ERS/ERS/2022/1906984',NULL,'Siemens',NULL,'ERS MMT-DIGITAL TECH',NULL,NULL,'ERS'),(2,NULL,'Kiran G Kumar (Not Listed)','Not Listed',NULL,NULL,NULL,NULL,NULL,52115005,NULL,'ERS/ERS/2022/1906984',NULL,'Siemens',NULL,'ERS MMT-DIGITAL TECH',NULL,NULL,'ERS');
/*!40000 ALTER TABLE `employee_recruitment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_recruitment_details_seq`
--

DROP TABLE IF EXISTS `employee_recruitment_details_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_recruitment_details_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_recruitment_details_seq`
--

LOCK TABLES `employee_recruitment_details_seq` WRITE;
/*!40000 ALTER TABLE `employee_recruitment_details_seq` DISABLE KEYS */;
INSERT INTO `employee_recruitment_details_seq` VALUES (101);
/*!40000 ALTER TABLE `employee_recruitment_details_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_college_tiering`
--

DROP TABLE IF EXISTS `master_college_tiering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_college_tiering` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_college_tiering`
--

LOCK TABLES `master_college_tiering` WRITE;
/*!40000 ALTER TABLE `master_college_tiering` DISABLE KEYS */;
INSERT INTO `master_college_tiering` VALUES (1,'TIER 1','Tier-1'),(2,'TIER 2','Tier-2'),(3,'TIER 3','Tier-3');
/*!40000 ALTER TABLE `master_college_tiering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_gender`
--

DROP TABLE IF EXISTS `master_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_gender` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_gender`
--

LOCK TABLES `master_gender` WRITE;
/*!40000 ALTER TABLE `master_gender` DISABLE KEYS */;
INSERT INTO `master_gender` VALUES (2,'FEMALE','Female'),(1,'MALE','Male'),(3,'TRANSGENDER','Others');
/*!40000 ALTER TABLE `master_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_l1`
--

DROP TABLE IF EXISTS `master_l1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_l1` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(30) NOT NULL,
  `VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_l1`
--

LOCK TABLES `master_l1` WRITE;
/*!40000 ALTER TABLE `master_l1` DISABLE KEYS */;
INSERT INTO `master_l1` VALUES (1,'ERS','ERS'),(4,'ERS EBT','ERS EBT'),(2,'ERS MMT','ERS MMT'),(6,'ERS MMT-DIGITAL TECH','ERS MMT-DIGITAL TECH'),(7,'ERS MMT-MEDICAL','ERS MMT-MEDICAL'),(3,'ERS Research','ERS Research'),(5,'ERS T&S _SIE','ERS T&S _SIE'),(8,'Unmapped','Unmapped');
/*!40000 ALTER TABLE `master_l1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_l2`
--

DROP TABLE IF EXISTS `master_l2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_l2` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_l2`
--

LOCK TABLES `master_l2` WRITE;
/*!40000 ALTER TABLE `master_l2` DISABLE KEYS */;
INSERT INTO `master_l2` VALUES (10,'ERS EBT - MODE 2','ERS EBT - MODE 2'),(5,'ERS MMT-DIGITAL TECH','ERS MMT-DIGITAL TECH'),(9,'ERS MMT-MEDICAL','ERS MMT-MEDICAL'),(8,'ERS MMT-MFG','ERS MMT-MFG'),(12,'ERS MMT-MMT','ERS MMT-MMT'),(6,'ERS MMT-TRANSPORTATION','ERS MMT-TRANSPORTATION'),(13,'ERS Research-Research','ERS Research-Research'),(2,'ERS-CET','ERS-CET'),(1,'ERS-ERS','ERS-ERS'),(11,'ERS-ET2','ERS-ET2'),(4,'ERS-SIE','ERS-SIE'),(3,'ERS-T&S','ERS-T&S'),(7,'Unmapped','Unmapped');
/*!40000 ALTER TABLE `master_l2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_l3`
--

DROP TABLE IF EXISTS `master_l3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_l3` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_l3`
--

LOCK TABLES `master_l3` WRITE;
/*!40000 ALTER TABLE `master_l3` DISABLE KEYS */;
INSERT INTO `master_l3` VALUES (49,'DIGITAL-PLM','DIGITAL-PLM'),(36,'ERS EBT - MODE 2 - 5G','ERS EBT - MODE 2 - 5G'),(30,'ERS EBT - MODE 2 - DATA ENGG','ERS EBT - MODE 2 - DATA ENGG'),(34,'ERS EBT - MODE 2 - PRODUCT','ERS EBT - MODE 2 - PRODUCT'),(35,'ERS EBT - MODE 2 - SOFTWARIZATION','ERS EBT - MODE 2 - SOFTWARIZATION'),(6,'ERS MMT-DIGITAL TECH-DIGITAL ENGG','ERS MMT-DIGITAL TECH-DIGITAL ENGG'),(21,'ERS MMT-DIGITAL TECH-DIGITAL MFG','ERS MMT-DIGITAL TECH-DIGITAL MFG'),(45,'ERS MMT-DIGITAL TECH-DIGITAL PLM','ERS MMT-DIGITAL TECH-DIGITAL PLM'),(10,'ERS MMT-DIGITAL TECH-PLM','ERS MMT-DIGITAL TECH-PLM'),(41,'ERS MMT-DIGITAL TECH-PLM MMIH','ERS MMT-DIGITAL TECH-PLM MMIH'),(39,'ERS MMT-DIGITAL TECH-PLM TRANSP','ERS MMT-DIGITAL TECH-PLM TRANSP'),(23,'ERS MMT-MEDICAL-DEVICES','ERS MMT-MEDICAL-DEVICES'),(24,'ERS MMT-MEDICAL-DIAGNOSTICS','ERS MMT-MEDICAL-DIAGNOSTICS'),(33,'ERS MMT-MEDICAL-IMP COE','ERS MMT-MEDICAL-IMP COE'),(26,'ERS MMT-MEDICAL-J&J','ERS MMT-MEDICAL-J&J'),(28,'ERS MMT-MEDICAL-RMPL COE','ERS MMT-MEDICAL-RMPL COE'),(51,'ERS MMT-MEDICAL-RMPL COE-MATERIALS','ERS MMT-MEDICAL-RMPL COE-MATERIALS'),(52,'ERS MMT-MEDICAL-RMPL COE-PACKAGING','ERS MMT-MEDICAL-RMPL COE-PACKAGING'),(19,'ERS MMT-MFG-INDUSTRIAL','ERS MMT-MFG-INDUSTRIAL'),(20,'ERS MMT-MFG-MECH HnC','ERS MMT-MFG-MECH HnC'),(27,'ERS MMT-MFG-OA','ERS MMT-MFG-OA'),(15,'ERS MMT-MFG-SEMI EQUIPMENT','ERS MMT-MFG-SEMI EQUIPMENT'),(37,'ERS MMT-MMT-MCOE','ERS MMT-MMT-MCOE'),(7,'ERS MMT-TRANSPORTATION-AND','ERS MMT-TRANSPORTATION-AND'),(17,'ERS MMT-TRANSPORTATION-AUTO','ERS MMT-TRANSPORTATION-AUTO'),(13,'ERS MMT-TRANSPORTATION-OHE','ERS MMT-TRANSPORTATION-OHE'),(50,'ERS Research-Research-Research','ERS Research-Research-Research'),(46,'ERS T&S _SIE-T&S','ERS T&S _SIE-T&S'),(47,'ERS T&S _SIE-T&S- DCSS','ERS T&S _SIE-T&S- DCSS'),(48,'ERS T&S _SIE-T&S-TFNW','ERS T&S _SIE-T&S-TFNW'),(31,'ERS-CET-CONSUMERIZATION','ERS-CET-CONSUMERIZATION'),(42,'ERS-CET-NEXT GEN TECH','ERS-CET-NEXT GEN TECH'),(2,'ERS-CET-System Eng','ERS-CET-System Eng'),(38,'ERS-CET-TECH EXCELLENCE','ERS-CET-TECH EXCELLENCE'),(44,'ERS-CET-TECHNOLOGY OFFICE','ERS-CET-TECHNOLOGY OFFICE'),(1,'ERS-ERS-Microsoft','ERS-ERS-Microsoft'),(32,'ERS-ET2-CENTRAL SUPPORT','ERS-ET2-CENTRAL SUPPORT'),(5,'ERS-SIE- Alphabet','ERS-SIE- Alphabet'),(8,'ERS-SIE- OISV&Fintech','ERS-SIE- OISV&Fintech'),(29,'ERS-SIE-Consumer Hitech','ERS-SIE-Consumer Hitech'),(25,'ERS-SIE-EISV','ERS-SIE-EISV'),(14,'ERS-SIE-S&DE','ERS-SIE-S&DE'),(12,'ERS-SIE-VEI&PE','ERS-SIE-VEI&PE'),(43,'ERS-T&S- CISCO','ERS-T&S- CISCO'),(11,'ERS-T&S-CISCO','ERS-T&S-CISCO'),(3,'ERS-T&S-DCSS','ERS-T&S-DCSS'),(40,'ERS-T&S-OISV&FINTECH','ERS-T&S-OISV&FINTECH'),(18,'ERS-T&S-SiPS','ERS-T&S-SiPS'),(22,'ERS-T&S-SiS','ERS-T&S-SiS'),(16,'ERS-T&S-TFNW','ERS-T&S-TFNW'),(4,'ERS-T&S-TSP','ERS-T&S-TSP'),(9,'ERS-T&S-TWRS','ERS-T&S-TWRS'),(53,'Unmapped','Unmapped');
/*!40000 ALTER TABLE `master_l3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_l4`
--

DROP TABLE IF EXISTS `master_l4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_l4` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_l4`
--

LOCK TABLES `master_l4` WRITE;
/*!40000 ALTER TABLE `master_l4` DISABLE KEYS */;
INSERT INTO `master_l4` VALUES (46,'CSSGDU','CSSGDU'),(57,'DCSRG','DCSRG'),(19,'ERS EBT - MODE 2 - 5G - Day 0 & Capacity','ERS EBT - MODE 2 - 5G - Day 0 & Capacity'),(61,'ERS EBT - MODE 2 - 5G - Solution Engg','ERS EBT - MODE 2 - 5G - Solution Engg'),(38,'ERS EBT - MODE 2 - S/W - Central support','ERS EBT - MODE 2 - S/W - Central support'),(52,'ERS MMT-DIGITAL TECH-DIGITAL ENGG','ERS MMT-DIGITAL TECH-DIGITAL ENGG'),(9,'ERS MMT-DIGITAL TECH-DIGITAL ENGG-CS','ERS MMT-DIGITAL TECH-DIGITAL ENGG-CS'),(11,'ERS MMT-DIGITAL TECH-DIGITAL ENGG-MED','ERS MMT-DIGITAL TECH-DIGITAL ENGG-MED'),(15,'ERS MMT-DIGITAL TECH-DIGITAL ENGG-MFG','ERS MMT-DIGITAL TECH-DIGITAL ENGG-MFG'),(17,'ERS MMT-DIGITAL TECH-DIGITAL ENGG-TRANSP','ERS MMT-DIGITAL TECH-DIGITAL ENGG-TRANSP'),(12,'ERS MMT-DIGITAL TECH-DIGITAL MFG-MFG','ERS MMT-DIGITAL TECH-DIGITAL MFG-MFG'),(43,'ERS MMT-DIGITAL TECH-DIGITAL MFG-MTH','ERS MMT-DIGITAL TECH-DIGITAL MFG-MTH'),(22,'ERS MMT-DIGITAL TECH-PLM MMIH-INDUS_SEMI','ERS MMT-DIGITAL TECH-PLM MMIH-INDUS_SEMI'),(53,'ERS MMT-DIGITAL TECH-PLM MMIH-RCPG','ERS MMT-DIGITAL TECH-PLM MMIH-RCPG'),(13,'ERS MMT-DIGITAL TECH-PLM TRANSP-AERO','ERS MMT-DIGITAL TECH-PLM TRANSP-AERO'),(14,'ERS MMT-DIGITAL TECH-PLM TRANSP-EU_APAC','ERS MMT-DIGITAL TECH-PLM TRANSP-EU_APAC'),(21,'ERS MMT-DIGITAL TECH-PLM TRANSP-FORD','ERS MMT-DIGITAL TECH-PLM TRANSP-FORD'),(40,'ERS MMT-DIGITAL TECH-PLM TRANSP-NORAM','ERS MMT-DIGITAL TECH-PLM TRANSP-NORAM'),(41,'ERS MMT-DIGITAL TECH-PLM TRANSP-NORDIC','ERS MMT-DIGITAL TECH-PLM TRANSP-NORDIC'),(58,'ERS MMT-DIGITAL TECH-PLM-PLM_COE','ERS MMT-DIGITAL TECH-PLM-PLM_COE'),(65,'ERS MMT-MEDICAL-RMPL COE-LABELLING','ERS MMT-MEDICAL-RMPL COE-LABELLING'),(62,'ERS MMT-MEDICAL-RMPL COE-MATERIALS','ERS MMT-MEDICAL-RMPL COE-MATERIALS'),(63,'ERS MMT-MEDICAL-RMPL COE-PACKAGING','ERS MMT-MEDICAL-RMPL COE-PACKAGING'),(64,'ERS MMT-MEDICAL-RMPL COE-REGULATORY','ERS MMT-MEDICAL-RMPL COE-REGULATORY'),(66,'ERS MMT-MFG-INDUSTRIAL-CS','ERS MMT-MFG-INDUSTRIAL-CS'),(16,'ERS MMT-MFG-INDUSTRIAL-MECH_CPG','ERS MMT-MFG-INDUSTRIAL-MECH_CPG'),(33,'ERS MMT-MFG-OA-DPT','ERS MMT-MFG-OA-DPT'),(48,'ERS MMT-MFG-SEMI EQUIPMENT-AMAT ODC DU','ERS MMT-MFG-SEMI EQUIPMENT-AMAT ODC DU'),(49,'ERS MMT-MFG-SEMI EQUIPMENT-KLA DU1','ERS MMT-MFG-SEMI EQUIPMENT-KLA DU1'),(51,'ERS MMT-MFG-SEMI EQUIPMENT-KLA DU3','ERS MMT-MFG-SEMI EQUIPMENT-KLA DU3'),(59,'ERS MMT-MFG-SEMI EQUIPMENT-KLA DU4','ERS MMT-MFG-SEMI EQUIPMENT-KLA DU4'),(24,'ERS MMT-MMT-MCOE-STRIDE','ERS MMT-MMT-MCOE-STRIDE'),(56,'ERS MMT-TRANSPORTATION-AUTO-CS','ERS MMT-TRANSPORTATION-AUTO-CS'),(35,'ERS MMT-TRANSPORTATION-AUTO-GBL_SUPPLIER','ERS MMT-TRANSPORTATION-AUTO-GBL_SUPPLIER'),(34,'ERS MMT-TRANSPORTATION-AUTO-VEONEER','ERS MMT-TRANSPORTATION-AUTO-VEONEER'),(29,'ERS MMT-TRANSPORTATION-OHE-CMMA','ERS MMT-TRANSPORTATION-OHE-CMMA'),(60,'ERS Research-Research-Research-DU1','ERS Research-Research-Research-DU1'),(42,'ERS T&S _SIE-T&S- DCSS- DU3','ERS T&S _SIE-T&S- DCSS- DU3'),(47,'ERS T&S _SIE-T&S-TFNW-Collab','ERS T&S _SIE-T&S-TFNW-Collab'),(37,'ERS T&S _SIE-T&S-TWRS-ERICSSON','ERS T&S _SIE-T&S-TWRS-ERICSSON'),(32,'ERS-CET-Consumerization-Consumerization','ERS-CET-Consumerization-Consumerization'),(27,'ERS-CET-NEXT GEN TECH-IRL','ERS-CET-NEXT GEN TECH-IRL'),(25,'ERS-CET-NEXT GEN TECH-TFG','ERS-CET-NEXT GEN TECH-TFG'),(2,'ERS-CET-System Eng','ERS-CET-System Eng'),(10,'ERS-CET-SYSTEM ENG-ATE_CoE','ERS-CET-SYSTEM ENG-ATE_CoE'),(23,'ERS-CET-TECH EXCELLENCE-EDGE','ERS-CET-TECH EXCELLENCE-EDGE'),(68,'ERS-CET-TECH EXCELLENCE-EPL','ERS-CET-TECH EXCELLENCE-EPL'),(1,'ERS-ERS-Microsoft','ERS-ERS-Microsoft'),(30,'ERS-ERS-Microsoft-Data Engg','ERS-ERS-Microsoft-Data Engg'),(5,'ERS-SIE- Alphabet','ERS-SIE- Alphabet'),(6,'ERS-T&S-DCSS-Dell','ERS-T&S-DCSS-Dell'),(3,'ERS-T&S-DCSS-DELL_DP&MGMT','ERS-T&S-DCSS-DELL_DP&MGMT'),(7,'ERS-T&S-DCSS-DU3','ERS-T&S-DCSS-DU3'),(20,'ERS-T&S-OISV&FINTECH-TM','ERS-T&S-OISV&FINTECH-TM'),(67,'ERS-T&S-SiPs-DV','ERS-T&S-SiPs-DV'),(44,'ERS-T&S-TFNW-Collab','ERS-T&S-TFNW-Collab'),(18,'ERS-T&S-TFNW-TM','ERS-T&S-TFNW-TM'),(50,'ERS-T&S-TFNW-VID&CABL','ERS-T&S-TFNW-VID&CABL'),(8,'ERS-T&S-TSP','ERS-T&S-TSP'),(4,'ERS-T&S-TSP-Verizon','ERS-T&S-TSP-Verizon'),(39,'ERS-T&S-TWRS','ERS-T&S-TWRS'),(36,'ERS-T&S-TWRS-HetRAN','ERS-T&S-TWRS-HetRAN'),(45,'JEAP','JEAP'),(28,'MITD','MITD'),(54,'SIAM','SIAM'),(31,'SPICE','SPICE'),(26,'SPRX','SPRX'),(55,'WISE','WISE');
/*!40000 ALTER TABLE `master_l4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_lob`
--

DROP TABLE IF EXISTS `master_lob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_lob` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_lob`
--

LOCK TABLES `master_lob` WRITE;
/*!40000 ALTER TABLE `master_lob` DISABLE KEYS */;
INSERT INTO `master_lob` VALUES (1,'ERS','ERS');
/*!40000 ALTER TABLE `master_lob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_location`
--

DROP TABLE IF EXISTS `master_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_location` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(30) NOT NULL,
  `VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_location`
--

LOCK TABLES `master_location` WRITE;
/*!40000 ALTER TABLE `master_location` DISABLE KEYS */;
INSERT INTO `master_location` VALUES (4,'BANGALORE','Bangalore'),(3,'CHENNAI','Chennai'),(1,'HUBLI','Hubli'),(5,'KOCHI','Kochi'),(2,'KOLKATA','Kolkata'),(6,'NOIDA','Noida');
/*!40000 ALTER TABLE `master_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_offered_band`
--

DROP TABLE IF EXISTS `master_offered_band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_offered_band` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_offered_band`
--

LOCK TABLES `master_offered_band` WRITE;
/*!40000 ALTER TABLE `master_offered_band` DISABLE KEYS */;
INSERT INTO `master_offered_band` VALUES (1,'E1','E1'),(2,'YTD','Yet To Deliver');
/*!40000 ALTER TABLE `master_offered_band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_offered_designation`
--

DROP TABLE IF EXISTS `master_offered_designation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_offered_designation` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_offered_designation`
--

LOCK TABLES `master_offered_designation` WRITE;
/*!40000 ALTER TABLE `master_offered_designation` DISABLE KEYS */;
INSERT INTO `master_offered_designation` VALUES (3,'GET','Graduate Engineer Trainee'),(4,'PGET','Post Graduate Engineer Trainee'),(1,'SE','Software Engineer'),(2,'SSE','Senior Software Engineer'),(5,'YTD','Yet To Deliver');
/*!40000 ALTER TABLE `master_offered_designation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_offered_sub_band`
--

DROP TABLE IF EXISTS `master_offered_sub_band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_offered_sub_band` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_offered_sub_band`
--

LOCK TABLES `master_offered_sub_band` WRITE;
/*!40000 ALTER TABLE `master_offered_sub_band` DISABLE KEYS */;
INSERT INTO `master_offered_sub_band` VALUES (1,'E1.1','E1.1'),(2,'E1.2','E1.2'),(3,'YTD','Yet To Deliver');
/*!40000 ALTER TABLE `master_offered_sub_band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_onboarding_status`
--

DROP TABLE IF EXISTS `master_onboarding_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_onboarding_status` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(30) NOT NULL,
  `VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_onboarding_status`
--

LOCK TABLES `master_onboarding_status` WRITE;
/*!40000 ALTER TABLE `master_onboarding_status` DISABLE KEYS */;
INSERT INTO `master_onboarding_status` VALUES (1,'JOINED','Joined'),(2,'PENDING','Pending for Joining');
/*!40000 ALTER TABLE `master_onboarding_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_region`
--

DROP TABLE IF EXISTS `master_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_region` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_region`
--

LOCK TABLES `master_region` WRITE;
/*!40000 ALTER TABLE `master_region` DISABLE KEYS */;
INSERT INTO `master_region` VALUES (3,'EAST','East'),(1,'NORTH','North'),(2,'SOUTH','South'),(4,'WEST','West');
/*!40000 ALTER TABLE `master_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_state`
--

DROP TABLE IF EXISTS `master_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_state` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(30) NOT NULL,
  `VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_state`
--

LOCK TABLES `master_state` WRITE;
/*!40000 ALTER TABLE `master_state` DISABLE KEYS */;
INSERT INTO `master_state` VALUES (1,'IN-AP','Andhra Pradesh'),(2,'IN-AR','Arunachal Pradesh'),(3,'IN-AS','Assam'),(4,'IN-BR','Bihar'),(5,'IN-CT','Chhattisgarh'),(6,'IN-GA','Goa'),(7,'IN-GJ','Gujarat'),(9,'IN-HP','Himachal Pradesh'),(8,'IN-HR','Haryana'),(10,'IN-JH','Jharkhand'),(11,'IN-KA','Karnataka'),(12,'IN-KL','Kerala'),(14,'IN-MH','Maharashtra'),(16,'IN-ML','Meghalaya'),(15,'IN-MN','Manipur'),(13,'IN-MP','Madhya Pradesh'),(17,'IN-MZ','Mizoram'),(18,'IN-NL','Nagaland'),(19,'IN-OR','Odisha'),(20,'IN-PB','Punjab'),(21,'IN-RJ','Rajasthan'),(22,'IN-SK','Sikkim'),(24,'IN-TG','Telangana'),(23,'IN-TN','Tamil Nadu'),(25,'IN-TR','Tripura'),(26,'IN-UP','Uttar Pradesh'),(27,'IN-UT','Uttarakhand'),(28,'IN-WB','West Bengal');
/*!40000 ALTER TABLE `master_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_ug_degree`
--

DROP TABLE IF EXISTS `master_ug_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_ug_degree` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_ug_degree`
--

LOCK TABLES `master_ug_degree` WRITE;
/*!40000 ALTER TABLE `master_ug_degree` DISABLE KEYS */;
INSERT INTO `master_ug_degree` VALUES (3,'B.D.','Bachelor Of Divinity'),(4,'B.DES.','Bachelor Of Design '),(2,'B.E.','Bachelor of Engineering '),(6,'B.PHARM','Bachelor Of Pharmacy'),(5,'B.SC.','Bachelor Of Science'),(1,'B.TECH/B.E','B.Tech/B.E'),(7,'BME','Biomedical engineering'),(8,'MBA  ','MBA Integrated  Degree');
/*!40000 ALTER TABLE `master_ug_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_ug_specialization`
--

DROP TABLE IF EXISTS `master_ug_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_ug_specialization` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_ug_specialization`
--

LOCK TABLES `master_ug_specialization` WRITE;
/*!40000 ALTER TABLE `master_ug_specialization` DISABLE KEYS */;
INSERT INTO `master_ug_specialization` VALUES (2,'AEI','Applied Electronics and Instrumentation'),(1,'AERO','Aerospace engineering'),(20,'AGRI.','Agricultural Engineering'),(22,'ARCHIT.','Architectural Design'),(3,'AUTO','Automobile engineering'),(17,'BE','Biomedical Engineering'),(23,'BIOTECH','Biotechnology Engineering'),(16,'CERAMIC','Ceramic Engineering'),(35,'CHEM. ENG ','Chemical Engineering'),(5,'CIVIL','Civil Engineering'),(4,'CSEorCS','Computer Science Engineering'),(6,'ECorECE','Electronics and communication Engineering'),(9,'EE','Electronics and Embedded Systems'),(7,'EEE','Electrical and Electronics Engineering'),(8,'EIE','Electronics and Instrumentation Engineering'),(34,'ELECTRICAM','Electricam'),(10,'ETCorETE','Electronics and Telecommunication Engineer'),(18,'FPE','Food Processing Engineering'),(30,'GD','Graphic Design '),(33,'IEE','Instrumentation and Electronics Engineering'),(11,'ISE','Industrial and Systems Engineering'),(13,'IT','Information Technology'),(29,'MD','Machine Design'),(27,'ME','Mining Engineering '),(12,'MECH','Mechanical Enginering'),(24,'MECHATRONICS ','Mechatronics Engineering'),(19,'MI','Moving Images'),(26,'MME','Metallurgical and Materials Engineering'),(21,'MSE','Materials Science and Engineering'),(25,'NAOE','Naval Architecture and Ocean Engineering'),(28,'PIE','Production and Industrial Engineering'),(31,'PSE','Physical Sience Engineering'),(14,'RA','Robotics and Automation'),(15,'SE','Software Engineering'),(32,'TD','Textile Design');
/*!40000 ALTER TABLE `master_ug_specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_ugorpg`
--

DROP TABLE IF EXISTS `master_ugorpg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_ugorpg` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `KEY` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`KEY`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_ugorpg`
--

LOCK TABLES `master_ugorpg` WRITE;
/*!40000 ALTER TABLE `master_ugorpg` DISABLE KEYS */;
INSERT INTO `master_ugorpg` VALUES (2,'PG','Postgraduation'),(1,'UG','Undergraduation');
/*!40000 ALTER TABLE `master_ugorpg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 19:41:08
