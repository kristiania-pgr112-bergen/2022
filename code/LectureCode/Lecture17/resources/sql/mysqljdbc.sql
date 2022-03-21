USE mysqljdbc;
SET FOREIGN_KEY_CHECKS=0;


/*Table structure for table `candidate_skills` */

DROP TABLE IF EXISTS candidate_skills;

CREATE TABLE candidate_skills (
  candidate_id int(11) NOT NULL,
  skill_id int(11) NOT NULL,
  PRIMARY KEY (candidate_id,skill_id),
  KEY skill_id (skill_id),
  CONSTRAINT candidate_skills_ibfk_1 FOREIGN KEY (candidate_id) REFERENCES candidates (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT candidate_skills_ibfk_2 FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*Data for the table `candidate_skills` */

insert  into candidate_skills(candidate_id,skill_id) values (133,1),(133,2),(133,3);

DROP TABLE IF EXISTS candidates;

CREATE TABLE candidates (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  dob date NOT NULL,
  phone varchar(20) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

/*Data for the table `candidates` */

insert  into candidates(id,first_name,last_name,dob,phone,email) values (1,'Carine ','Schmitt','1980-01-01','(403) 225-5556','carine.s@gmail.com'),(2,'Jean','King','1980-01-02','(702) 555-1838','jean.k@gmail.com'),(3,'Peter','Ferguson','1980-01-03','(395) 204-5558','peter.f@gmail.com'),(4,'Janine ','Labrune','1980-01-04','(406) 785-5588','janine.l@gmail.com'),(5,'Jonas ','Bergulfsen','1980-01-05','(798) 955-5888','jonas.b@gmail.com'),(6,'Susan','Nelson','1980-01-06','(415) 555-1450','susan.n@gmail.com'),(7,'Zbyszek ','Piestrzeniewicz','1980-01-07','(266) 427-5558','zbyszek.p@gmail.com'),(8,'Roland','Keitel','1980-01-08','(496) 966-9025','roland.k@gmail.com'),(9,'Julie','Murphy','1980-01-09','(650) 555-5787','julie.m@gmail.com\r'),(10,'Kwai','Lee','1980-01-10','(212) 555-7818','kwai.l@gmail.com'),(11,'Diego ','Freyre','1980-01-11','(915) 559-4440','diego.f@gmail.com'),(12,'Christina ','Berglund','1980-01-12','(921) 123-5550','christina.b@gmail.com'),(13,'Jytte ','Petersen','1980-01-13','(311) 235-5500','jytte.p@gmail.com'),(14,'Mary ','Saveley','1980-01-14','(783) 255-5500','mary.s@gmail.com'),(15,'Eric','Natividad','1980-01-15','(652) 217-5550','eric.n@gmail.com'),(16,'Jeff','Young','1980-01-16','(212) 555-7413','jeff.y@yahoo.com'),(17,'Kelvin','Leong','1980-01-17','(215) 555-1555','kelvin.l@yahoo.com'),(18,'Juri','Hashimoto','1980-01-18','(650) 555-6809','juri.h@yahoo.com'),(19,'Wendy','Victorino','1980-01-19','(652) 241-5550','wendy.v@yahoo.com'),(20,'Veysel','Oeztan','1980-01-20','(472) 267-3215','veysel.o@yahoo.com'),(21,'Keith','Franco','1980-01-21','(203) 555-7845','keith.f@yahoo.com'),(22,'Isabel ','de Castro','1980-01-22','(135) 655-5500','isabel.d@yahoo.com\r'),(23,'Martine ','RancÃ©','1980-01-23','(201) 615-5500','martine.r@yahoo.com'),(24,'Marie','Bertrand','1980-01-24','(142) 342-5550','marie.b@yahoo.com'),(25,'Jerry','Tseng','1980-01-25','(617) 555-5555','jerry.t@yahoo.com'),(26,'Julie','King','1980-01-26','(203) 555-2570','julie.k@yahoo.com'),(27,'Mory','Kentary','1980-01-27','(810) 663-4258','mory.k@yahoo.com'),(28,'Michael','Frick','1980-01-28','(212) 555-1500','michael.f@yahoo.com'),(29,'Matti','Karttunen','1980-01-29','(902) 248-5550','matti.k@yahoo.com'),(30,'Rachel','Ashworth','1980-01-30','(171) 555-1555','rachel.a@yahoo.com');

DROP TABLE IF EXISTS skills;

CREATE TABLE skills (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

/*Data for the table `skills` */

insert  into skills(id,name) values (1,'Java'),(2,'JDBC'),(3,'MySQL'),(4,'Web Application'),(5,'Mobile App');
/*Table structure for table `candidates` */
SET foreign_key_checks = 1;
