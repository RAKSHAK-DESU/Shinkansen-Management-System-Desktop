-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2024 at 03:06 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `railway management system`
--
CREATE DATABASE IF NOT EXISTS `railway management system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `railway management system`;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Email` text NOT NULL,
  `Tel` text NOT NULL,
  `Salary` double NOT NULL,
  `Position` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`ID`, `Name`, `Email`, `Tel`, `Salary`, `Position`) VALUES
(0, 'Employee 1', 'employee1@railway.com', '111111', 1100, 'Driver');

-- --------------------------------------------------------

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
CREATE TABLE `passengers` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Email` text NOT NULL,
  `Tel` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `passengers`
--

INSERT INTO `passengers` (`ID`, `Name`, `Email`, `Tel`) VALUES
(0, 'Passenger 1', 'passenger1@railway.com', '123123'),
(1, 'Passenger 2', 'passenger2@railway.com', '222222');

-- --------------------------------------------------------

--
-- Table structure for table `trains`
--

DROP TABLE IF EXISTS `trains`;
CREATE TABLE `trains` (
  `ID` int(11) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trains`
--

INSERT INTO `trains` (`ID`, `Capacity`, `Description`) VALUES
(0, 500, 'Train 1'),
(1, 350, 'Train 2 VIP'),
(2, 1, 'Train 3');

-- --------------------------------------------------------

--
-- Table structure for table `trip 1 passengers`
--

DROP TABLE IF EXISTS `trip 1 passengers`;
CREATE TABLE `trip 1 passengers` (
  `Passenger` int(11) DEFAULT NULL,
  `Tickets` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trip 1 passengers`
--

INSERT INTO `trip 1 passengers` (`Passenger`, `Tickets`) VALUES
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trip 2 passengers`
--

DROP TABLE IF EXISTS `trip 2 passengers`;
CREATE TABLE `trip 2 passengers` (
  `Passenger` int(11) DEFAULT NULL,
  `Tickets` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trip 3 passengers`
--

DROP TABLE IF EXISTS `trip 3 passengers`;
CREATE TABLE `trip 3 passengers` (
  `Passenger` int(11) DEFAULT NULL,
  `Tickets` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trip 4 passengers`
--

DROP TABLE IF EXISTS `trip 4 passengers`;
CREATE TABLE `trip 4 passengers` (
  `Passenger` int(11) DEFAULT NULL,
  `Tickets` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trip 4 passengers`
--

INSERT INTO `trip 4 passengers` (`Passenger`, `Tickets`) VALUES
(0, 1),
(0, 1),
(1, 2),
(0, 1),
(1, 1),
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trip 5 passengers`
--

DROP TABLE IF EXISTS `trip 5 passengers`;
CREATE TABLE `trip 5 passengers` (
  `Passenger` int(11) DEFAULT NULL,
  `Tickets` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trip 5 passengers`
--

INSERT INTO `trip 5 passengers` (`Passenger`, `Tickets`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips` (
  `ID` int(11) NOT NULL,
  `Start` text NOT NULL,
  `Destination` text NOT NULL,
  `DepartureTime` text NOT NULL,
  `ArrTime` text NOT NULL,
  `Date` text NOT NULL,
  `BookedSeats` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Driver` int(11) NOT NULL,
  `Train` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trips`
--

INSERT INTO `trips` (`ID`, `Start`, `Destination`, `DepartureTime`, `ArrTime`, `Date`, `BookedSeats`, `Price`, `Driver`, `Train`) VALUES
(1, 'Rome', 'Paris', '06:00', '09:00', '2010-01-02', 0, 200, 0, 1),
(2, 'Athens', 'London', '04:30', '10:00', '2014-05-04', 0, 150, 0, 0),
(3, 'London', 'Athens', '16:00', '19:50', '2013-02-01', 0, 120, 0, 0),
(4, 'London', 'Athens', '04:00', '08:15', '2010-01-01', 1, 175, 0, 2),
(5, 'Berlin', 'Vienna', '04:05', '12:00', '2014-04-04', 1, 250, 0, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
