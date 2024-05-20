DROP SCHEMA IF EXISTS `smart_care`;

CREATE SCHEMA `smart_care`;

use `smart_care`;

drop table if exists `doctor`;
drop table if exists `patient`;
drop table if exists `hospital`;
drop table if exists `document`;
drop table if exists `medical_history`;

CREATE TABLE `hospital` (
  `hospital_id` int NOT NULL AUTO_INCREMENT,
  `name`varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hospital_id`)
);


CREATE TABLE `doctor` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `name`varchar(100) DEFAULT NULL,
  `speciality` varchar(100) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  `experience`varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `email`varchar(100) DEFAULT NULL,
  `hospital` int DEFAULT  NULL,
  -- `hospital_id` int DEFAULT  NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`) -- idhr comma lagana hai niche wala code uncomment krke 
  /*KEY `FK_HOSPITAL_idx` (`hospital_id`),
  CONSTRAINT `FK_HOSPITAL` FOREIGN KEY (`hospital_id`) 
  REFERENCES `hospital` (`hospital_id`) ON DELETE NO ACTION ON UPDATE NO ACTION*/
);

CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `name`varchar(100) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  `medical_history` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  -- `doctor_id` int DEFAULT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`patient_id`) -- idhr comma lagana hai niche wala code uncomment krke 
  -- KEY `FK_PATIENT_idx` (`doctor_id`),
--   CONSTRAINT `FK_PATIENT` FOREIGN KEY (`doctor_id`) 
--   REFERENCES `doctor` (`doctor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE `document` (
  `document_id` int NOT NULL AUTO_INCREMENT,
  `doc_date`varchar(100) DEFAULT NULL,
  `doc_type` varchar(100) DEFAULT NULL,
  -- `patient_id` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`document_id`) -- idhr comma lagana hai niche wala code uncomment krke 
  -- KEY `FK_PATIENT_idx` (`patient_id`),
--   CONSTRAINT `FK_PATIENT_ID` FOREIGN KEY (`patient_id`) 
--   REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE `medical_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date`varchar(100) DEFAULT NULL,
  `conditon` varchar(100) DEFAULT NULL,
  `treatment` varchar(100) DEFAULT NULL,
  `doctor` varchar(100) DEFAULT NULL,
  -- `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) -- idhr comma lagana hai niche wala code uncomment krke 
 --  KEY `FK_PATIENT_idx` (`patient_id`),
--   CONSTRAINT `FK_PATIENT_IDS` FOREIGN KEY (`patient_id`) 
--   REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `contact_messages` (
  `contact_id` varchar(50) NOT NULL,
  `contact_name` varchar(50) NOT NULL,
  `contact_email` varchar(100) NOT NULL,
  `subject` varchar(500) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
);
