-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema restaurantpickerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `restaurantpickerdb` ;

-- -----------------------------------------------------
-- Schema restaurantpickerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurantpickerdb` DEFAULT CHARACTER SET utf8 ;
USE `restaurantpickerdb` ;

-- -----------------------------------------------------
-- Table `restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurant` ;

CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` ENUM('CHEAP', 'AVERAGE', 'PRICEY', 'NONE') NULL DEFAULT 'NONE',
  `category` VARCHAR(45) NULL DEFAULT 'NONE',
  `distance` ENUM('CLOSE', 'AVERAGE', 'FAR', 'NONE') NULL DEFAULT 'NONE',
  `address` VARCHAR(300) NULL DEFAULT 'PLACEHOLDER',
  `logo` VARCHAR(1000) NULL DEFAULT 'PLACEHOLDER',
  `favorite` TINYINT(4) NULL DEFAULT 0,
  `user_id` INT(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 52
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO rest@localhost;
 DROP USER rest@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'rest'@'localhost' IDENTIFIED BY 'foodcritic';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'rest'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `restaurantpickerdb`;
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (1, 'Subway', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (2, 'Applebees', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (3, 'Osaka', 'Pricey', 'Asian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (4, 'Sonic', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (5, 'Qdoba', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (6, 'Thai Pan', 'Cheap', 'Asian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (7, 'El Taco Del Mexico', 'Cheap', 'Mexican', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (8, 'Taco Bell', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (9, 'Biker Jims', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (10, 'The Egg And I', 'Average', 'Breakfast', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (11, 'Waffle Bros', 'Average', 'Breakfast', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (12, 'Villiage Inn', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (13, 'Dennys', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (14, 'Olive Garden', 'Average', 'Italian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (15, 'Nonnas', 'Average', 'Italian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (16, 'Indian Place', 'Pricey', 'Indian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (17, 'The Oddesy', 'Pricey', 'Italian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (18, 'The Athenian', 'Pricey', 'Greek', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (19, 'Pete\'s Kitchen', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (20, 'Burger King', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (21, 'Panda Express', 'Cheap', 'Asian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (22, 'Pizza Hut', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (23, 'Hillstone', 'Pricey', 'Steakhouse', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (24, 'Red Robin', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (25, 'Senor Rics', 'Average', 'Mexican', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (26, 'Cinzettis', 'Average', 'Italian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (27, 'Chillis', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (28, 'Mataam Fez', 'Pricey', 'Mediterranian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (29, 'La Fondue', 'Pricey', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (30, 'Mongolian Barbecue', 'Cheap', 'Mediterranian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (31, 'Donuts', 'Cheap', 'Fast Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (32, 'Lincolns Roadhouse', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (33, 'Texas Roadhouse', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (34, 'The Copper Pot', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (35, 'Movie Tavern', 'Pricey', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (36, 'The Aquarium', 'Pricey', 'Seafood', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (37, 'Red Lobster', 'Pricey', 'Seafood', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (38, 'Joe\'s Crab Shack', 'Pricey', 'Seafood', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (39, 'Watering Bowl', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (40, 'BJs', 'Average', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (41, 'Columbine Steakhouse', 'Cheap', 'Steakhouse', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (42, 'CasaBonita', 'Average', 'Mexican', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (43, 'Anthony\'s Pizza', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (44, 'Texas De Brazil', 'Pricey', 'Steakhouse', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (45, 'Pho', 'Cheap', 'Asian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (46, 'GyroZ', 'Cheap', 'Greek', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (47, 'Jerusalem', 'Cheap', 'Mediterranian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (48, 'Chedders', 'Pricey', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (49, 'PeaksLounge', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (50, 'Cake', 'Cheap', 'American Casual', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);
INSERT INTO `restaurant` (`id`, `name`, `price`, `category`, `distance`, `address`, `logo`, `favorite`, `user_id`) VALUES (51, 'Bennihanna', 'Pricey', 'Asian', 'NONE', 'PLACEHOLDER', 'PLACEHOLDER', 0, 0);

COMMIT;
