CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `locality` varchar(20) NOT NULL,
  `streetName` varchar(45) DEFAULT NULL,
  `buildingName` varchar(45) DEFAULT NULL,
  `flatNumber` varchar(20) DEFAULT NULL,
  `pin` int(11) NOT NULL,
  `landmark` varchar(100) DEFAULT NULL,
  `coordinates` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chef` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `languages` varchar(50) DEFAULT NULL,
  `maritalStatus` int(11) DEFAULT NULL,
  `ethnicity` varchar(50) DEFAULT NULL,
  `chefCategory` int(11) DEFAULT NULL,
  `mealCategory` int(11) DEFAULT NULL,
  `workingDays` varchar(10) DEFAULT NULL,
  `workingTime` int(11) DEFAULT NULL,
  `mealTypes` varchar(100) DEFAULT NULL,
  `speciality` varchar(100) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` varchar(100) DEFAULT NULL,
  `customerName` varchar(100) NOT NULL,
  `primaryPhone` varchar(45) NOT NULL,
  `secondaryPhone` varchar(45) DEFAULT NULL,
  `primaryEmail` varchar(100) DEFAULT NULL,
  `secondaryEmail` varchar(100) DEFAULT NULL,
  `totalHitsOnApp` int(11) DEFAULT NULL,
  `noOfTImesOrdered` int(11) DEFAULT NULL,
  `timesStayingMoreThan2Mins` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customerId_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer_address_mapping` (
  `customerId` int(11) NOT NULL,
  `addressId` int(11) NOT NULL,
  `priority` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Meal` (
  `mealId` int(11) NOT NULL AUTO_INCREMENT,
  `mealName` varchar(100) NOT NULL,
  `mealContent` varchar(200) DEFAULT NULL,
  `mealDescription` varchar(500) DEFAULT NULL,
  `mealType` varchar(100) DEFAULT NULL,
  `mealCategory` int(11) NOT NULL,
  `mealNote` varchar(500) DEFAULT NULL,
  `mealNutrients` varchar(500) DEFAULT NULL,
  `mealImageUrl` varchar(100) DEFAULT NULL,
  `chefName` varchar(100) NOT NULL,
  `chefImageUrl` varchar(100) DEFAULT NULL,
  `chefId` int(11) NOT NULL,
  `spicyness` int(11) DEFAULT NULL,
  `mealPrice` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `totalMealsOrdered` int(11) DEFAULT NULL,
  PRIMARY KEY (`mealId`),
  UNIQUE KEY `mealId_UNIQUE` (`mealId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer_meal_mapping` (
  `customerId` int(11) NOT NULL,
  `mealId` int(11) NOT NULL,
  `hitsOnMeal` int(11) DEFAULT NULL,
  `noOfTimesOrdered` int(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `review` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `menu` (
  `mealId` int(11) NOT NULL,
  `mealDate` date NOT NULL,
  `mealTime` int(11) NOT NULL,
  `mealQuantity` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `addressId` int(11) NOT NULL,
  `orderDate` date NOT NULL,
  `orderTime` time NOT NULL,
  `mealId` varchar(100) NOT NULL,
  `mealQuantity` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `orderId_UNIQUE` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;