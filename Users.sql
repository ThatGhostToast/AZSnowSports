-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jan 30, 2022 at 11:38 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AZSnowSports`
--

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `ID` int(11) NOT NULL COMMENT 'The ID of the user',
  `FIRSTNAME` varchar(100) NOT NULL COMMENT 'The First Name of the user',
  `LASTNAME` varchar(100) NOT NULL COMMENT 'The Last Name of the user',
  `EMAIL` varchar(100) NOT NULL COMMENT 'The user''s email',
  `ADDRESS` varchar(100) NOT NULL COMMENT 'The user''s address',
  `PHONENUMBER` bigint(14) NOT NULL COMMENT 'The user''s phone number',
  `USERNAME` varchar(100) NOT NULL COMMENT 'The user''s username',
  `PASSWORD` varchar(100) NOT NULL COMMENT 'The user''s password',
  `ROLE` varchar(100) NOT NULL DEFAULT 'User'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`ID`, `FIRSTNAME`, `LASTNAME`, `EMAIL`, `ADDRESS`, `PHONENUMBER`, `USERNAME`, `PASSWORD`, `ROLE`) VALUES
(1, 'User', 'User', 'user@user.com', '1234 Street Lane', 5555555555, 'username', 'password', 'User'),
(2, 'Admin', 'Admin', 'admin@adminuser.com', '321 Ave Street', 5551115151, 'Admin', 'Admin', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'The ID of the user', AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
