CREATE DATABASE  IF NOT EXISTS `e_learningmodel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `e_learningmodel`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: e_learningmodel
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `student_course_enrolment`
--

DROP TABLE IF EXISTS `student_course_enrolment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course_enrolment` (
  `registration_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_completion` date DEFAULT NULL,
  `date_of_enrolment` date DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `FK3ojly7rxn526596p70bty6qj1` (`student_id`),
  KEY `FKsb7365268lybjxq32v12b47xl` (`course_id`),
  CONSTRAINT `FK3ojly7rxn526596p70bty6qj1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKsb7365268lybjxq32v12b47xl` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_enrolment`
--

LOCK TABLES `student_course_enrolment` WRITE;
/*!40000 ALTER TABLE `student_course_enrolment` DISABLE KEYS */;
INSERT INTO `student_course_enrolment` VALUES (2,'2018-01-02','2018-01-02','khong',2,2);
/*!40000 ALTER TABLE `student_course_enrolment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-02 23:12:02
