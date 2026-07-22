-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema farmacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `farmacia` DEFAULT CHARACTER SET utf8 ;
USE `farmacia` ;

-- -----------------------------------------------------
-- Table `farmacia`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Funcionario` (
  `login` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `farmacia`.`Telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Telefone` (
    `cod` INT NOT NULL AUTO_INCREMENT,
    `numero` VARCHAR(20) NOT NULL, -- <--- Mude de INT para VARCHAR(20) aqui
    PRIMARY KEY (`cod`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `farmacia`.`Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Cidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `farmacia`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Fornecedor` (
  `cnpj` CHAR(18) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `Telefone` INT NOT NULL,
  `Cidade` INT NOT NULL,
  PRIMARY KEY (`cnpj`),
  INDEX `fk_Fornecedor_Telefone_idx` (`Telefone` ASC),
  INDEX `fk_Fornecedor_Cidade1_idx` (`Cidade` ASC),
  CONSTRAINT `fk_Fornecedor_Telefone`
    FOREIGN KEY (`Telefone`)
    REFERENCES `farmacia`.`Telefone` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fornecedor_Cidade1`
    FOREIGN KEY (`Cidade`)
    REFERENCES `farmacia`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `farmacia`.`Medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Medicamento` (
  `cod` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `quantidade` INT NULL,
  `Fornecedor` CHAR(18) NOT NULL,
  PRIMARY KEY (`cod`),
  INDEX `fk_Medicamento_Fornecedor_idx` (`Fornecedor` ASC),
  CONSTRAINT `fk_Medicamento_Fornecedor`
    FOREIGN KEY (`Fornecedor`)
    REFERENCES `farmacia`.`Fornecedor` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `farmacia`.`Medicamento_has_Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`Medicamento_has_Fornecedor` (
  `Medicamento` VARCHAR(45) NOT NULL,
  `Fornecedor` CHAR(18) NOT NULL,
  PRIMARY KEY (`Medicamento`, `Fornecedor`),
  INDEX `fk_Medicamento_has_Fornecedor_Fornecedor1_idx` (`Fornecedor` ASC),
  INDEX `fk_Medicamento_has_Fornecedor_Medicamento1_idx` (`Medicamento` ASC),
  CONSTRAINT `fk_Medicamento_has_Fornecedor_Medicamento1`
    FOREIGN KEY (`Medicamento`)
    REFERENCES `farmacia`.`Medicamento` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medicamento_has_Fornecedor_Fornecedor1`
    FOREIGN KEY (`Fornecedor`)
    REFERENCES `farmacia`.`Fornecedor` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Inserção do funcionário padrão para acesso ao sistema
INSERT INTO Funcionario (login, nome, senha) VALUES ('teste', 'Bruno', '12345');