-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema burger_tracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `burger_tracker` ;

-- -----------------------------------------------------
-- Schema burger_tracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `burger_tracker` DEFAULT CHARACTER SET utf8 ;
USE `burger_tracker` ;

-- -----------------------------------------------------
-- Table `burger_tracker`.`burgers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `burger_tracker`.`burgers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `restaurant` VARCHAR(100) NULL,
  `rating` INT NULL,
  `notes` VARCHAR(500) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
