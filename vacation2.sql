-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 26, 2022 at 05:08 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vacation`
--
CREATE DATABASE IF NOT EXISTS `vacation` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `vacation`;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) NOT NULL,
  `PRICE` int(11) NOT NULL,
  `LOCATION` varchar(500) NOT NULL,
  `DETAILS` varchar(500) NOT NULL,
  `AVAILABILITY` int(11) NOT NULL,
  `CONTACT` varchar(500) NOT NULL,
  `IMAGE` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `NAME`, `PRICE`, `LOCATION`, `DETAILS`, `AVAILABILITY`, `CONTACT`, `IMAGE`) VALUES
(1, 'Big Apple', 2000, 'New York, New Yorks', 'An all inclusive package for food, drinks, and two nights in a five star hotel in the middle of New York City.', 3, 'TravelAnywhere@travel.com', 'newyork.jpg'),
(2, 'london package', 250, 'london', 'this is a tour all around london and includes lunch/dinner', 6, '123-123-1234', 'london.jpg'),
(3, 'paris', 300, 'Paris, France', 'An all inclusive package for food, drinks, and three nights in a five star hotel in the middle of the eiffel tower', 8, '480-444-2313', 'paris.jpg'),
(4, 'Maui Package', 600, 'Maui, Hawaii', 'This package will take you on an adventure from the Road to Hana, swimming with the dolphins, Helicopter Ride, Private boat ride, Luau, and parachuting', 8, '602-989-9012', 'maui.jpg'),
(5, 'Rome Vacation', 400, 'Rome, Italy', 'This tour package includes a private tour inside of the Rome Colosseum and private tour 1 day tour in Rome.', 8, '234-123-4455', 'rome.jpg'),
(6, 'Tokyo', 180, 'Tokyo, Japan', 'This vacation will take you on an unforgettable journey in Tokyo, Japan. We will visit famous landmarks and finish off by shopping in Akihabara.', 20, '2', 'tokyo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PHONE` varchar(100) NOT NULL,
  `ROLE` varchar(20) DEFAULT 'NORMAL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `USERNAME`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PHONE`, `ROLE`) VALUES
(11, 'testing', '$2a$10$Pzk8DUK3OR6pZiWQxyfTEOUbN8G79cOktTz4GfNwaWOzdpTZTRKK2', 'testing', 'testing', 'testing@gmail.com', '123-123-1234', 'USER'),
(13, 'matt', '$2a$10$hqDWug1bwTsb6PZ36BjnruazZKnDELdbbofDvgOAENIPKB1lRo72W', 'matt', 'walker', 'matt@gmail.com', '123-123-1234', 'USER'),
(36, 'paul', '$2a$10$0FUDbjhouJCOG3fvQAW5GunqFJfiKk5t3EgI7HBukYGGCTwxFyagq', 'paul', 'mccartney', 'paul@outlook.com', '123-123-1234', 'ADMIN'),
(37, 'john', '$2a$10$5jNYKWIQQ3EZ5zxXrFlGuu0siG4oi/wJA81DX6UXRr8GgpdXhixtG', 'john', 'lennon', 'john@outlook.com', '123-123-1235', 'ADMIN'),
(38, 'george', '$2a$10$vLVLzQ8JqYU9AXaCT.nnfupLbsTSuA3ofryzU3fKi31ccaogPR0Ha', 'george', 'harrison', 'george@outlook.com', '123-123-1236', 'ADMIN'),
(39, 'ringo', '$2a$10$42BKsJgcVEbgMPkvp4T0yO3RXUeWJqSKoOpagW/3Km5HCK04jrVC2', 'ringo', 'starr', 'ringo@outlook.com', '123-123-1237', 'ADMIN'),
(40, 'brian', '$2a$10$esyVW2B/9orhToduhpPJTOk6J0tgunN0HY.1neHlWVzEUJft4Bb3m', 'brian', 'epstein', 'brian@outlook.com', '123-123-1238', 'ADMIN'),
(41, 'alex', '$2a$10$LZs7l/51vzVd5MmDd1Jxyu2J4ArhSM27a/kq8A8q8VpeVLprUnONu', 'alejandro', 'vergara', 'alexv_vergara@outlook.com', '123-123-1239', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
