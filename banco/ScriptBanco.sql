-- MySQL Script generated by MySQL Workbench
-- Dom 10 Set 2017 17:01:22 BRT
-- Model: New Model    Version: 1.0
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
-- Table `mydb`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estado` (
  `idEstado` INT NOT NULL AUTO_INCREMENT,
  `Estado_Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idEstado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT,
  `Cidade_Nome` VARCHAR(45) NULL,
  `Estado_idEstado` INT NOT NULL,
  PRIMARY KEY (`idCidade`, `Estado_idEstado`),
  INDEX `fk_Cidade_Estado1_idx` (`Estado_idEstado` ASC),
  CONSTRAINT `fk_Cidade_Estado1`
    FOREIGN KEY (`Estado_idEstado`)
    REFERENCES `mydb`.`Estado` (`idEstado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedores` (
  `idFornecedores` INT NOT NULL AUTO_INCREMENT COMMENT '		',
  `Fornecedor_Nome` VARCHAR(45) NULL,
  `Fornecedor_Telefone` VARCHAR(45) NULL,
  `Fornecedor_CPF` INT NULL,
  `Fornecedor_Endereco` VARCHAR(45) NULL,
  `Fornecedor_NRua` INT NULL,
  `Fornecedor_Bairro` VARCHAR(45) NULL,
  `Cidade_idCidade` INT NOT NULL,
  PRIMARY KEY (`idFornecedores`, `Cidade_idCidade`),
  INDEX `fk_Fornecedores_Cidade_idx` (`Cidade_idCidade` ASC),
  CONSTRAINT `fk_Fornecedores_Cidade`
    FOREIGN KEY (`Cidade_idCidade`)
    REFERENCES `mydb`.`Cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;