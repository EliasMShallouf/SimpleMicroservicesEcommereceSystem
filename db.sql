-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2024 at 01:49 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecomm-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
('3ee54159-9eea-450a-af1c-1a4660d134aa', 'Fast Food'),
('ec0d0ea3-1b5d-491c-8478-eb43e961ee0a', 'Meals');

-- --------------------------------------------------------

--
-- Table structure for table `orderline`
--

CREATE TABLE `orderline` (
  `id` int(11) NOT NULL,
  `line_number` int(11) NOT NULL,
  `order_id` varchar(255) NOT NULL,
  `product_id` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `qty` double NOT NULL,
  `discount` double NOT NULL COMMENT 'discount in % format [0-1]'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `orderline`
--

INSERT INTO `orderline` (`id`, `line_number`, `order_id`, `product_id`, `price`, `qty`, `discount`) VALUES
(2, 1, '632a795d-9d69-453b-ad8f-6d61d2b3235b', '01', 500, 2, 0),
(3, 1, '497072fb-14e1-4195-a625-caad05368692', '01', 500, 2, 0),
(4, 2, '497072fb-14e1-4195-a625-caad05368692', '01', 800, 1, 0),
(5, 1, '478fe5ec-0fb7-4b89-994f-a260802eb2b5', '01', 500, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `name` text NOT NULL,
  `category_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `category_id`) VALUES
('6fb4cf66-82f6-47a6-8683-352fdfcf3db4', 'Shawrma', '3ee54159-9eea-450a-af1c-1a4660d134aa');

-- --------------------------------------------------------

--
-- Table structure for table `salesorder`
--

CREATE TABLE `salesorder` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `order_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `salesorder`
--

INSERT INTO `salesorder` (`id`, `user_id`, `order_date`) VALUES
('478fe5ec-0fb7-4b89-994f-a260802eb2b5', 'c827999a-95ed-40e3-97fc-dfc297eca373', '2024-06-02 05:32:50'),
('497072fb-14e1-4195-a625-caad05368692', 'c827999a-95ed-40e3-97fc-dfc297eca373', '2024-06-03 05:32:50'),
('632a795d-9d69-453b-ad8f-6d61d2b3235b', 'c827999a-95ed-40e3-97fc-dfc297eca373', '2024-06-02 05:32:50');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `name` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
('20d35f75-9fa8-47cd-890f-507dd495048c', 'Elias', 'elias@gmail.com', '123'),
('7494ef7b-f912-42ed-839c-a3e512ba3601', 'Elias-gateway2', 'elias4s@gmail.com', '123'),
('79dad6a3-4853-4335-8b9b-77ff72103712', 'Elias2', 'elias2@gmail.com', '123'),
('b6cbb9e0-16ba-4afe-bc9c-0c6791c9f866', 'Elias3', 'elias3@gmail.com', '123'),
('c827999a-95ed-40e3-97fc-dfc297eca373', 'Elias-gateway', 'elias4@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderline`
--
ALTER TABLE `orderline`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_fk` (`order_id`);

--
-- Indexes for table `salesorder`
--
ALTER TABLE `salesorder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderline`
--
ALTER TABLE `orderline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderline`
--
ALTER TABLE `orderline`
  ADD CONSTRAINT `order_fk` FOREIGN KEY (`order_id`) REFERENCES `salesorder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
