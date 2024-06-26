-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET utf8 ;
USE `mydb2` ;

-- -----------------------------------------------------
-- Table `mydb2`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Cliente` (
  `ID` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `endereço` VARCHAR(45) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Remédio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Remédio` (
  `idRemedio` INT NOT NULL,
  `nomeRemedio` VARCHAR(45) NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  `tipoRemedio` VARCHAR(45) NOT NULL,
  `estoque` INT NOT NULL,
  `validade` DATE NOT NULL,
  `preço` DOUBLE NOT NULL,
  PRIMARY KEY (`idRemedio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Empregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Empregado` (
  `idEmpregado` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `função` VARCHAR(45) NOT NULL,
  `salário` DOUBLE NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`idEmpregado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`LoginEmpregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`LoginEmpregado` (
  `id` INT NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `Empregado_idEmpregado` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_LoginEmpregado_Empregado1_idx` (`Empregado_idEmpregado` ASC) VISIBLE,
  CONSTRAINT `fk_LoginEmpregado_Empregado1`
    FOREIGN KEY (`Empregado_idEmpregado`)
    REFERENCES `mydb2`.`Empregado` (`idEmpregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Pedido` (
  `IDPedido` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `Cliente_ID` INT NOT NULL,
  `Empregado_idEmpregado` INT NOT NULL,
  PRIMARY KEY (`IDPedido`),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_ID` ASC) VISIBLE,
  INDEX `fk_Pedido_Empregado1_idx` (`Empregado_idEmpregado` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_ID`)
    REFERENCES `mydb2`.`Cliente` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Empregado1`
    FOREIGN KEY (`Empregado_idEmpregado`)
    REFERENCES `mydb2`.`Empregado` (`idEmpregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Pedido_has_Remédio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Pedido_has_Remédio` (
  `Pedido_IDPedido` INT NOT NULL,
  `Remédio_idRemedio` INT NOT NULL,
  `Preco` DOUBLE NOT NULL,
  `Quantidade_pedida` INT NOT NULL,
  `Id_do_pedido` INT NOT NULL,
  PRIMARY KEY (`Pedido_IDPedido`, `Remédio_idRemedio`),
  INDEX `fk_Pedido_has_Remédio_Remédio1_idx` (`Remédio_idRemedio` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Remédio_Pedido1_idx` (`Pedido_IDPedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Remédio_Pedido1`
    FOREIGN KEY (`Pedido_IDPedido`)
    REFERENCES `mydb2`.`Pedido` (`IDPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Remédio_Remédio1`
    FOREIGN KEY (`Remédio_idRemedio`)
    REFERENCES `mydb2`.`Remédio` (`idRemedio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
