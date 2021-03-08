
USE `UD22`;


DROP TABLE IF EXISTS `proyectos`;

CREATE TABLE `proyectos` (
  `ID` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

SELECT *
FROM PROYECTOS;

UPDATE proyectos 
 set  nombre=?  WHERE id= ? 