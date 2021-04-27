-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 21, 2021 at 07:33 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bike`
--

-- --------------------------------------------------------

--
-- Table structure for table `addpizza`
--

CREATE TABLE IF NOT EXISTS `addpizza` (
  `pid` varchar(10) NOT NULL DEFAULT '',
  `pname` varchar(30) DEFAULT NULL,
  `pprice` int(30) DEFAULT NULL,
  `pflavour` varchar(30) DEFAULT NULL,
  `psize` varchar(30) DEFAULT NULL,
  `pcrust` varchar(30) DEFAULT NULL,
  `pincredient` varchar(30) DEFAULT NULL,
  `ptoppings` varchar(30) DEFAULT NULL,
  `psauces` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addpizza`
--

INSERT INTO `addpizza` (`pid`, `pname`, `pprice`, `pflavour`, `psize`, `pcrust`, `pincredient`, `ptoppings`, `psauces`) VALUES
('101', 'non veg pizza', 400, 'spicy', 'extra large', 'soft', 'tomato,potato', 'cheese', 'tomato');

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE IF NOT EXISTS `buyer` (
  `pid` int(10) DEFAULT NULL,
  `pname` varchar(30) DEFAULT NULL,
  `price` int(30) NOT NULL,
  `buyerid` int(30) NOT NULL,
  `buyername` varchar(60) NOT NULL,
  `phoneno` int(20) NOT NULL,
  `address` varchar(60) NOT NULL,
  `state` varchar(60) NOT NULL,
  `city` varchar(60) NOT NULL,
  `pincode` int(10) NOT NULL,
  `paymentdate` date NOT NULL,
  PRIMARY KEY (`buyerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`pid`, `pname`, `price`, `buyerid`, `buyername`, `phoneno`, `address`, `state`, `city`, `pincode`, `paymentdate`) VALUES
(1, 'hero1', 60000, 5460, 'Mayank', 1235, 'rjpm', 'up', 'lko', 226017, '2021-04-21'),
(2, 'apache', 600000, 9372, 'akash', 74656546, 'se45y', 'lko', 'lko', 226017, '2021-04-21'),
(2, 'apache', 600000, 9911, 'Saif', 1234567, 'xyz', 'up', 'lko', 221212, '2021-04-21');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE IF NOT EXISTS `registration` (
  `id` int(10) NOT NULL,
  `name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `name`, `email`, `password`) VALUES
(1012, 'Akash kumar', 'akash@gmail.com', '123'),
(3532, 'ankur', 'ankur@gmail.com', '123'),
(4298, 'saif', 'saif@gmail.com', '123'),
(8663, 'Mayank', 'M@gmail.com', 'M123');
