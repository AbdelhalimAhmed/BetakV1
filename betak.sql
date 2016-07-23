-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2016 at 08:57 PM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `betak`
--

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE IF NOT EXISTS `ads` (
  `IdAds` int(11) NOT NULL,
  `TitleAds` varchar(45) NOT NULL,
  `decreptionAds` varchar(255) NOT NULL,
  `PhotoAds` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ads`
--

INSERT INTO `ads` (`IdAds`, `TitleAds`, `decreptionAds`, `PhotoAds`) VALUES
(4, 'coca-cola', ' global leader in the beverage industry, the Coca-Cola company offers hundreds of brands, including soft drinks, fruit juices, sports drinks and other bev', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcScBmyQV977s6Oz7nBN9TWK4SgkwU4JjszpX_DNjNrnfIIbjvKsBg'),
(5, 'coca-cola', 'A global leader in the beverage industry, the Coca-Cola company offers hundreds of brands, including soft drinks, fruit juices, sports drinks and other beverages ', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABBVBMVEXfAB/////8///fAADcAADgAAD//v/fABz5///gAB7//f/dAR/8/v/ZAADhACD8//3fABbeABLdAAjiABraAx/iABvjAB7cABjhACLcAA7bABvhAAneACXbABDjABf+/vr54eLwp6z57ez2wcT21tvseIHnVGT+9ff86u3pfoT2ysnqiJD64');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `IdMessage` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `IdUsers` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE IF NOT EXISTS `units` (
  `IdUnits` int(11) NOT NULL,
  `TitleUnits` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `price` int(15) NOT NULL,
  `NumberOfTunant` int(15) NOT NULL,
  `Place` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `PhotoUnit` varchar(255) NOT NULL,
  `IdUsers` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`IdUnits`, `TitleUnits`, `Type`, `price`, `NumberOfTunant`, `Place`, `Address`, `PhotoUnit`, `IdUsers`) VALUES
(1, 'شقة مائة متر للايجار', 'شقة', 1000, 4, 'بولاق الدكرور', 'شارع مصطفي العسال', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTyAIjPy09TtchGgnCnCoTBSA-CgZzJ3zcyMb_Zy-X_KZ7L8m4U', 1),
(2, 'غرفة للايجار', 'room', 200, 1, 'bolak', 'شارع ناهيا', 'http://archive.aawsat.com/2008/04/14/images/fashion1.466808.jpg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `IdUsers` int(11) NOT NULL,
  `NameUsers` varchar(45) NOT NULL,
  `EmailUsers` varchar(45) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `ConfirmPassword` varchar(50) NOT NULL,
  `PhoneUsers` int(15) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `photo` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`IdUsers`, `NameUsers`, `EmailUsers`, `Password`, `ConfirmPassword`, `PhoneUsers`, `Gender`, `photo`) VALUES
(1, 'ahmed', 'ahmed@yahoo.com', '123', '123', 11, 'male', 'https://scontent-cai1-1.xx.fbcdn.net/v/t34.0-12/13152626_782678488533137_1418061010_n.jpg?oh=a58366a'),
(2, 'halim', 'halim@yahoo.com', '456', '456', 12, 'male', 'https://scontent-cai1-1.xx.fbcdn.net/v/t34.0-12/13162160_782680658532920_224089347_n.jpg?oh=f6d5db2d8b4a8c8d467e59626795c24f&oe=572ED2CE'),
(8, 'tarek', 'tarek@yahoo.com', '789', '789', 10, 'male', 'https://scontent-cai1-1.xx.fbcdn.net/v/t34.0-12/13183202_782680641866255_1475285092_n.jpg?oh=8dcacf3d3ad2476277bfc9482008166f&oe=572FBC6F'),
(9, 'reham', 'reham@yahoo.com', '852', '852', 14, 'female', 'https://scontent-cai1-1.xx.fbcdn.net/v/t34.0-12/13153519_782681711866148_649524166_n.jpg?oh=cb702959143cff794ca181a4b5d18fd3&oe=572EB6E7'),
(11, 'omar', 'omar@yahoo.com', '789', '789', 15, 'male', 'https://scontent-cai1-1.xx.fbcdn.net/v/t34.0-12/13153490_782682041866115_85975083_n.jpg?oh=57d2defc4de02c5d11a3a17d2fc2f86f&oe=572FB1F2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ads`
--
ALTER TABLE `ads`
  ADD PRIMARY KEY (`IdAds`),
  ADD UNIQUE KEY `countryid_UNIQUE` (`IdAds`),
  ADD UNIQUE KEY `PhotoAds` (`PhotoAds`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`IdMessage`),
  ADD UNIQUE KEY `countryid_UNIQUE` (`IdMessage`),
  ADD KEY `IdUsers_idx` (`IdUsers`);

--
-- Indexes for table `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`IdUnits`),
  ADD UNIQUE KEY `countryid_UNIQUE` (`IdUnits`),
  ADD UNIQUE KEY `PhotoUnit` (`PhotoUnit`),
  ADD KEY `IdUsers_idx` (`IdUsers`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`IdUsers`),
  ADD UNIQUE KEY `countryid_UNIQUE` (`IdUsers`),
  ADD UNIQUE KEY `EmailUsers` (`EmailUsers`),
  ADD UNIQUE KEY `photo` (`photo`),
  ADD UNIQUE KEY `PhoneUsers` (`PhoneUsers`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ads`
--
ALTER TABLE `ads`
  MODIFY `IdAds` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `IdMessage` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `IdUnits` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `IdUsers` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
