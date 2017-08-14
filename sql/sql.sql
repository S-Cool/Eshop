CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(45) NOT NULL,
  `CategoryDescription` varchar(200) NOT NULL,
  PRIMARY KEY (`CategoryID`),
  UNIQUE KEY `idCategory_UNIQUE` (`CategoryID`),
  UNIQUE KEY `CategoryName_UNIQUE` (`CategoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SELECT * FROM eshop.category;


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
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`Customer_CustomerID`) REFERENCES `user` (`CustomerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `orderproducts` (
  `OrderProductID` int(11) NOT NULL,
  `ProductID` varchar(45) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `UnitPrice` float NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Discount` int(11) NOT NULL,
  PRIMARY KEY (`OrderProductID`),
  UNIQUE KEY `OrderProductID_UNIQUE` (`OrderProductID`),
  KEY `fk_orderproducts_order1_idx` (`OrderID`),
  KEY `fk_orderproducts_products1_idx` (`ProductID`),
  CONSTRAINT `fk_orderproducts_order1` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderproducts_products1` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `products` (
  `ProductID` varchar(45) NOT NULL,
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


CREATE TABLE `user` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Age` date DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `idusers_UNIQUE` (`CustomerID`),
  UNIQUE KEY `email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
