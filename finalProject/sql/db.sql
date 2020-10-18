drop database `kolesnick_db`;
create database if not exists `kolesnick_db`; 
use kolesnick_db;
CREATE TABLE IF NOT EXISTS `kolesnick_db`.`role` (
  `id` INT NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `kolesnick_db`.`role` (`id`, `type`) VALUES (1, 'admin');
INSERT INTO `kolesnick_db`.`role` (`id`, `type`) VALUES (2, 'manager');
INSERT INTO `kolesnick_db`.`role` (`id`, `type`) VALUES (3, 'client');

  
  
  CREATE TABLE IF NOT EXISTS `kolesnick_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `adress` VARCHAR(255) NULL,
  `user_name` VARCHAR(45) NULL,
  `user_firstname` VARCHAR(45) NULL,
  `user_lastname` VARCHAR(45) NULL,
  `pasport` VARCHAR(45) NULL,
  `tel` INT NULL,
  `blocked` TINYINT NOT NULL DEFAULT 0,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  INDEX `fk_user_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `kolesnick_db`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
INSERT INTO `kolesnick_db`.`user` (`id`, `login`, `password`, `adress`, `user_name`, `user_firstname`, `user_lastname`, `pasport`, `tel`, `role_id`) VALUES (1, 'user', 'user', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `kolesnick_db`.`user` (`id`, `login`, `password`, `adress`, `user_name`, `user_firstname`, `user_lastname`, `pasport`, `tel`, `role_id`) VALUES (2, 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, 1);

    
    
    CREATE TABLE IF NOT EXISTS `kolesnick_db`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `discription` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);
  
INSERT INTO `kolesnick_db`.`status` (`id`, `name`, `discription`) VALUES (1, 'waiting_for_payment', NULL);
INSERT INTO `kolesnick_db`.`status` (`id`, `name`, `discription`) VALUES (2, 'decliened', NULL);
INSERT INTO `kolesnick_db`.`status` (`id`, `name`, `discription`) VALUES (3, 'paid', NULL);
INSERT INTO `kolesnick_db`.`status` (`id`, `name`, `discription`) VALUES (4, 'closed', NULL);
INSERT INTO `kolesnick_db`.`status` (`id`, `name`, `discription`) VALUES (5, 'damage', NULL);

  
  
  CREATE TABLE IF NOT EXISTS `kolesnick_db`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(25) NOT NULL,
  `model` VARCHAR(25) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `image` VARCHAR(225) NOT NULL,
  `ear_of_issue` int NOT NULL,
  `quality_class` VARCHAR(45)NOT NULL,
  `price` DECIMAL UNSIGNED NOT NULL,
  `rentered` TINYINT NOT NULL,
  `damage` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (1, 'tesla', 's', 'sport', 'tesla.jpg', 2020, 'elita', 5000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (2, 'audi', 'a6', 'sport', 'audi.jpg', 2019, 'elita', 4500, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (3, 'bmw', 'x3', 'sport', 'bmw.jpg', 2018, 'elita', 4000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (4, 'deo', 'lanos', 'sport', 'deo.jpg', 2016, 'elita', 3500, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (5, 'nissan', 'leaf', 'sport', 'nissan.jpg', 2015, 'elita', 3000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (6, 'toyota', 'camry', 'sport', 'toyota.jpg', 2014, 'elita', 2500, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (7, 'honda', 'accord', 'sport', 'honda.jpg', 2013, 'elita', 2000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (8, 'mitsubisi', 'supra', 'sport', 'mitsubishi.jpg', 2012, 'elita', 1500, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (9, 'ford', 'mustang', 'sport', 'ford.jpg', 2011, 'elita', 1000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (10, 'suzuki', 'zuki', 'sport', 'suzuki.jpg', 2010, 'elita', 1200, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (11, 'citroen', 'troen', 'sport', 'sitroen.jpg', 2009, 'elita', 1300, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (12, 'porshe', 'camaro', 'sport', 'porshe.jpg', 2008, 'elita', 5000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (13, 'mersedes', 's', 'sport', 'mersedes.jpg', 2007, 'elita', 4200, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (14, 'hundai', 'dai', 'sport', 'hundai.jpg', 2006, 'elita', 2000, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (15, 'wolksvagen', 'passad', 'sport', 'volkswagen.jpg', 2005, 'elita', 1500, false, 0);
  INSERT INTO `kolesnick_db`.`car` (`id`, `brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (16, 'mazda', 'rx7', 'sport', 'mazda.jpg', 2004, 'elita', 4000, false, 0);

  
  
  CREATE TABLE IF NOT EXISTS `kolesnick_db`.`contract` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rental_term` INT UNSIGNED NOT NULL DEFAULT 1,
  `car_id` INT NOT NULL,
  `with_driver` TINYINT NOT NULL,
  `user_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  PRIMARY KEY (`id`, `car_id`, `user_id`),
  INDEX `fk_contract_car1_idx` (`car_id` ASC) VISIBLE,
  INDEX `fk_contract_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_contract_status1_idx` (`status_id` ASC) VISIBLE,
  CONSTRAINT `fk_contract_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `kolesnick_db`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `kolesnick_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `kolesnick_db`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_price` DECIMAL unsigned NOT NULL,
  `contract_id` int NOT NULL,
  PRIMARY KEY (`id`,`contract_id`),
  KEY `fk_bill_contract1_idx` (`contract_id`),
  CONSTRAINT `fk_bill_contract1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB 
  
  