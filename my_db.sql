-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my_db` DEFAULT CHARACTER SET latin1 ;
USE `my_db` ;

-- -----------------------------------------------------
-- Table `my_db`.`expense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`expense` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `my_db`.`income`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`income` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `my_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `dompet` DOUBLE NOT NULL,
  `nama` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

INSERT INTO 'my_db'.'user' ('username', 'password', 'saldo', 'dompet', 'nama') VALUES ('admin', 'admin', 0, 0, 'admin');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
