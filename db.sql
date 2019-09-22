/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.6-MariaDB : Database - apiplanet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`apiplanet` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `apiplanet`;

/*Table structure for table `api_planet` */

DROP TABLE IF EXISTS `api_planet`;

CREATE TABLE `api_planet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `planet_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `planet_size` double DEFAULT NULL,
  `star_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kts81gsrn4xh0karsgoedpcsg` (`planet_name`),
  KEY `FKcfkluxwvct33659r7m18l9sbl` (`star_id`),
  CONSTRAINT `FKcfkluxwvct33659r7m18l9sbl` FOREIGN KEY (`star_id`) REFERENCES `api_star` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `api_planet` */

insert  into `api_planet`(`id`,`planet_name`,`planet_size`,`star_id`) values (1,'tierra',353552,2);

/*Table structure for table `api_star` */

DROP TABLE IF EXISTS `api_star`;

CREATE TABLE `api_star` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `star_density` double DEFAULT NULL,
  `star_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5jujcq70cal97sqf49bi75mqb` (`star_name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `api_star` */

insert  into `api_star`(`id`,`star_density`,`star_name`) values (2,13413,'vega'),(5,1241,'canopus');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
