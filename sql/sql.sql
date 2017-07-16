CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(45) NOT NULL,
  `CategoryDescription` varchar(200) NOT NULL,
  PRIMARY KEY (`CategoryID`),
  UNIQUE KEY `idCategory_UNIQUE` (`CategoryID`),
  UNIQUE KEY `CategoryName_UNIQUE` (`CategoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Age` date NOT NULL,
  `Phone` int(11) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `idusers_UNIQUE` (`CustomerID`),
  UNIQUE KEY `email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `employees` (
  `EmployeeName` varchar(30) NOT NULL,
  `EmployeePassword` varchar(45) NOT NULL,
  PRIMARY KEY (`EmployeeName`),
  UNIQUE KEY `EmployeesName_UNIQUE` (`EmployeeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_CustomerID` int(11) NOT NULL,
  `Products_ProductID` varchar(15) NOT NULL,
  `Employee_EmployeeName` varchar(30) NOT NULL,
  `OrderDate` date NOT NULL,
  `ShippedDate` date NOT NULL,
  `PaymentMethods` enum('CASH','MASTERCARD') NOT NULL,
  `Delivery` enum('PICKUP','DELIVERY','DELCOMPANY') NOT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `OrderID_UNIQUE` (`OrderID`),
  UNIQUE KEY `Customer_CustomerID_UNIQUE` (`Customer_CustomerID`),
  KEY `fk_Order_Customer1_idx` (`Customer_CustomerID`),
  KEY `fk_Order_Products1_idx` (`Products_ProductID`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`Customer_CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Products1` FOREIGN KEY (`Products_ProductID`) REFERENCES `products` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `orderproducts` (
    `ProductID` VARCHAR(15) NOT NULL,
    `OrderID` INT(11) NOT NULL,
    `UnitPrice` FLOAT NOT NULL,
    `Quantity` INT(11) NOT NULL,
    `Discount` INT(11) NOT NULL,
    PRIMARY KEY (`ProductID` , `OrderID`),
    KEY `fk_products_has_order_order1_idx` (`OrderID`),
    KEY `fk_products_has_order_products1_idx` (`ProductID`),
    CONSTRAINT `fk_products_has_order_order1` FOREIGN KEY (`OrderID`)
        REFERENCES `order` (`OrderID`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_products_has_order_products1` FOREIGN KEY (`ProductID`)
        REFERENCES `products` (`ProductID`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `products` (
  `ProductID` varchar(15) NOT NULL,
  `ProductName` varchar(60) NOT NULL,
  `QuantityInStock` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(800) NOT NULL,
  `Brand` varchar(30) NOT NULL,
  `Category_CategoryID` int(11) NOT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `idproducts_UNIQUE` (`ProductID`),
  KEY `fk_Products_Category1_idx` (`Category_CategoryID`),
  CONSTRAINT `fk_Products_Category1` FOREIGN KEY (`Category_CategoryID`) REFERENCES `category` (`CategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
