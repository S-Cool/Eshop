-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema eshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eshop` DEFAULT CHARACTER SET utf8 ;
USE `eshop` ;

-- -----------------------------------------------------
-- Table `eshop`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshop`.`category` (
  `CategoryID` INT(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(45) NOT NULL,
  `CategoryDescription` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`CategoryID`),
  UNIQUE INDEX `idCategory_UNIQUE` (`CategoryID` ASC),
  UNIQUE INDEX `CategoryName_UNIQUE` (`CategoryName` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eshop`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshop`.`customer` (
  `CustomerID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Age` DATE NOT NULL,
  `Phone` INT(11) NOT NULL,
  `City` VARCHAR(30) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE INDEX `idusers_UNIQUE` (`CustomerID` ASC),
  UNIQUE INDEX `email_UNIQUE` (`Email` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eshop`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshop`.`employees` (
  `EmployeeName` VARCHAR(30) NOT NULL,
  `EmployeePassword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EmployeeName`),
  UNIQUE INDEX `EmployeesName_UNIQUE` (`EmployeeName` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eshop`.`order`
-- -----------------------------------------------------
  CREATE TABLE `order` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_CustomerID` int(11) NOT NULL,
  `employees_EmployeeName` varchar(30) NOT NULL,
  `OrderDate` date NOT NULL,
  `ShippedDate` date NOT NULL,
  `PaymentMethods` varchar(45) NOT NULL,
  `Delivery` varchar(45) NOT NULL,
  `ShipFName` varchar(45) NOT NULL,
  `ShipLName` varchar(45) NOT NULL,
  `ShipPhone` int(11) NOT NULL,
  `ShipCity` varchar(30) NOT NULL,
  `ShipAddress` varchar(45) NOT NULL,
  `ShipEmail` varchar(45) NOT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `OrderID_UNIQUE` (`OrderID`),
  UNIQUE KEY `Customer_CustomerID_UNIQUE` (`Customer_CustomerID`),
  KEY `fk_Order_Customer1_idx` (`Customer_CustomerID`),
  KEY `fk_order_employees1_idx` (`employees_EmployeeName`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`Customer_CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_employees1` FOREIGN KEY (`employees_EmployeeName`) REFERENCES `employees` (`EmployeeName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



-- -----------------------------------------------------
-- Table `eshop`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshop`.`products` (
  `ProductID` VARCHAR(15) NOT NULL,
  `ProductName` VARCHAR(60) NOT NULL,
  `QuantityInStock` INT(11) NOT NULL,
  `Price` INT(11) NOT NULL,
  `Description` VARCHAR(800) NOT NULL,
  `Brand` VARCHAR(30) NOT NULL,
  `Category_CategoryID` INT(11) NOT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE INDEX `idproducts_UNIQUE` (`ProductID` ASC),
  INDEX `fk_Products_Category1_idx` (`Category_CategoryID` ASC),
  CONSTRAINT `fk_Products_Category1`
  FOREIGN KEY (`Category_CategoryID`)
  REFERENCES `eshop`.`category` (`CategoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eshop`.`orderproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshop`.`orderproducts` (
  `ProductID` VARCHAR(15) NOT NULL,
  `OrderID` INT(11) NOT NULL,
  `UnitPrice` FLOAT NOT NULL,
  `Quantity` INT(11) NOT NULL,
  `Discount` INT(11) NOT NULL,
  PRIMARY KEY (`ProductID`, `OrderID`),
  INDEX `fk_products_has_order_order1_idx` (`OrderID` ASC),
  INDEX `fk_products_has_order_products1_idx` (`ProductID` ASC),
  CONSTRAINT `fk_products_has_order_order1`
  FOREIGN KEY (`OrderID`)
  REFERENCES `eshop`.`order` (`OrderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_has_order_products1`
  FOREIGN KEY (`ProductID`)
  REFERENCES `eshop`.`products` (`ProductID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
