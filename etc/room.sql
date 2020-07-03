-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rooms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place` INT NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `equipment` VARCHAR(45) NOT NULL,
  `beschreibung` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `telefon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `starttime` VARCHAR(45) NOT NULL DEFAULT '',
  `endtime` VARCHAR(45) NOT NULL,
  `rooms_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `rooms_id`, `customer_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_reservations_rooms1_idx` (`rooms_id` ASC),
  INDEX `fk_reservations_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_reservations_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `mydb`.`rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservations_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
