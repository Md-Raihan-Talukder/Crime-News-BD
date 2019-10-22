-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2018 at 10:43 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pstu`
--

-- --------------------------------------------------------

--
-- Table structure for table `allnews`
--

CREATE TABLE `allnews` (
  `id` int(11) NOT NULL,
  `title` varchar(250) CHARACTER SET latin1 NOT NULL,
  `news` varchar(2500) CHARACTER SET latin1 NOT NULL,
  `time` varchar(250) CHARACTER SET latin1 NOT NULL,
  `type` varchar(50) CHARACTER SET latin1 NOT NULL,
  `location` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `allnews`
--

INSERT INTO `allnews` (`id`, `title`, `news`, `time`, `type`, `location`) VALUES
(2, '12 killed, 30 injured', 'ashg ahdfg ahgfh tadgj jkxc,  jkbcashg ahdfg ahgfh tadgj jkxc,  jkbcashg ahdfg ahgfh tadgj jkxc,  jkbcashg ahdfg ahgfh tadgj jkxc,  jkbcashg ahdfg ahgfh tadgj jkxc,  jkbc', '2/9/88', '', ''),
(3, '12 years girl rapped rapidly whole night', '12 years girl rapped rapidly whole night\r\n12 years girl rapped rapidly whole night\r\n12 years girl rapped rapidly whole night\r\n12 years girl rapped rapidly whole night\r\n12 years girl rapped rapidly whole night', '8/7/99', '', ''),
(5, 'pstu cultural week', 'every year 22th february is decleared as culture day .every year 22th february is decleared as culture day \r\nevery year 22th february is decleared as culture day ', '5/9/77', '', ''),
(51, 'rat 12ta 1', 'moddho rater khobor', '1/8/9', 'murder', 'Rajshahi'),
(72, 'fiinsh test', 'result', '1/14/18, 12:09:54 PM', 'murder', 'Chittagong'),
(65, '', '', '', '', 'Dhaka'),
(66, '', '', '', '', 'Dhaka'),
(67, '', '', '', '', 'Dhaka'),
(68, 'hmhhh', 'hmmm', '1/14/1804:23:43 AM', 'select one', 'select one'),
(69, 'rat 12 ta beja gase 5 hour age ', 'am Mr gese', '1/14/18, 04:35:36 AM', 'robbery', 'Chittagong'),
(70, 'rat dupure kerabera ', 'aj shamsu kupabe', '1/14/18, 04:43:07 AM', 'sports', 'Rajshahi'),
(71, 'tomorrow a girl raped miraz', 'Miraz,a student of ptsu raped by a girl who was HIV positive', '1/14/18, 12:04:57 PM', 'rape', 'Barisal'),
(63, 'A White was send to Kim by Donald Tramp', 'A White was send to Kim by Donald TrampA White was send to Kim by Donald TrampA White was send to Kim by Donald Tramp', '5/8/8', 'rape', 'Dhaka'),
(64, 'bd news 24 vuya', 'You have successfully installed XAMPP on this system! Now you can start using Apache, MariaDB, PHP and other components. You can find more info in theÂ FAQsÂ section or check theÂ HOW-TO GuidesÂ for getting started with PHP applications.You have successfully installed XAMPP on this system! Now you can start using Apache, MariaDB, PHP and other components. You can find more info in theÂ FAQsÂ section or check theÂ HOW-TO GuidesÂ for getting started with PHP applications.', 'Saturday, January 13, 2018', 'murder', 'Shylet'),
(73, 'à¦œà¦²à¦¸à¦¾ à¦¸à¦¨à§à¦§à§à¦¯à¦¾', 'à¦†à¦®à¦¿ à¦¯à§‡ à¦œà¦²à¦¸à¦¾ à¦˜à¦°à§‡\n', '1/14/18, 02:35:12 PM', 'murder', 'Rajshahi'),
(74, 'Test ', 'a girl is fucked by herself with dildo.', '1/14/18, 02:55:04 PM', 'rape', 'Barisal'),
(75, 'a', 'b', 'c', 'rape', 'Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `corruption`
--

CREATE TABLE `corruption` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `corruption`
--

INSERT INTO `corruption` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'cc', 'cc', '', 'cc'),
(2, 'corrup', 'kll', '', '8/8/8');

-- --------------------------------------------------------

--
-- Table structure for table `illegal`
--

CREATE TABLE `illegal` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `illegal`
--

INSERT INTO `illegal` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'rari', 'kotha bole ', '0', '1/2/8'),
(2, 'rari', 'kotha bole ', '0', '1/2/8');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `pin` varchar(100) NOT NULL,
  `age` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `division` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `name`, `email`, `password`, `pin`, `age`, `gender`, `division`, `district`, `phone`) VALUES
(8, '111', '111', '111', '', '', '', '', '', ''),
(9, 'kisuna', 'raihanbappi@gmail.com', '1234', '', '', '', '', '', ''),
(35, 'Rafi', 'rafihayder@gmail.com', '1234', '112233', '22', 'Male', 'Dhaka', 'Dhaka', '01878072845');

-- --------------------------------------------------------

--
-- Table structure for table `murder`
--

CREATE TABLE `murder` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `murder`
--

INSERT INTO `murder` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'rari', 'kotha bole ', '', '1/2/8'),
(2, 'mm', 'mm', '', 'mm'),
(3, 'rat 12ta 1', 'moddho rater khobor', 'Rajshahi', '1/8/9'),
(4, 'ghjhbbhghhh', 'fbhvb\ngghj\ngggh\nggg\n', 'Chittagong', 'Thursday, January 18, 2018'),
(6, ' à¦†à¦¹à¦¾ à¦¹à¦¾ à¦¹à¦¾ à¦¹à¦¾', 'à¦†à¦¹à¦¾à§Ÿà¦¾à§Ÿà¦¾à§Ÿà¦¾à§Ÿà¦¾', 'Khulna', 'Saturday, January 13, 2018'),
(7, 'bd news 24 vuya', 'You have successfully installed XAMPP on this system! Now you can start using Apache, MariaDB, PHP and other components. You can find more info in theÂ FAQsÂ section or check theÂ HOW-TO GuidesÂ for getting started with PHP applications.You have successfu', 'Shylet', 'Saturday, January 13, 2018'),
(8, 'fiinsh test', 'result', 'Chittagong', '1/14/18, 12:09:54 PM'),
(9, 'à¦œà¦²à¦¸à¦¾ à¦¸à¦¨à§à¦§à§à¦¯à¦¾', 'à¦†à¦®à¦¿ à¦¯à§‡ à¦œà¦²à¦¸à¦¾ à¦˜à¦°à§‡\n', 'Rajshahi', '1/14/18, 02:35:12 PM');

-- --------------------------------------------------------

--
-- Table structure for table `policestation`
--

CREATE TABLE `policestation` (
  `id` int(11) NOT NULL,
  `station_name` varchar(100) NOT NULL,
  `number` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policestation`
--

INSERT INTO `policestation` (`id`, `station_name`, `number`, `email`) VALUES
(1, '111', '111', '111'),
(3, '222', '222', '222'),
(4, '111111', '1111111', '111111'),
(5, '222222', '1111111111111111', '111111111111111111111111'),
(6, 'ppp', 'ppp', 'ppp'),
(7, '4444', '44444', '44444'),
(8, 'Dumki', '012346', 'jsfkjdk@lkml'),
(9, 'Razbari', '01783366577', 'rajbari_police@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `rape`
--

CREATE TABLE `rape` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rape`
--

INSERT INTO `rape` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'rari', 'kotha bole ', '', '1/2/8'),
(2, 'rari', 'kotha bole ', '', '1/2/8'),
(3, 'rr', 'rr', '', 'rr'),
(4, 'tomorrow a girl raped miraz', 'Miraz,a student of ptsu raped by a girl who was HIV positive', 'Barisal', '1/14/18, 12:04:57 PM'),
(5, 'Test ', 'a girl is fucked by herself with dildo.', 'Barisal', '1/14/18, 02:55:04 PM');

-- --------------------------------------------------------

--
-- Table structure for table `robbery`
--

CREATE TABLE `robbery` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `robbery`
--

INSERT INTO `robbery` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'rari', 'kotha bole ', '', '1/2/8'),
(2, 'rari', 'kotha bole ', '', '1/2/8'),
(3, 'rr', 'rr', '', 'rr'),
(4, 'bmi', 'deser obostha valo na r ojon', 'Chittagong', '4/8/9'),
(5, 'rat 12 ta beja gase 5 hour age ', 'am Mr gese', 'Chittagong', '1/14/18, 04:35:36 AM');

-- --------------------------------------------------------

--
-- Table structure for table `sports`
--

CREATE TABLE `sports` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `news` varchar(255) NOT NULL,
  `location` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports`
--

INSERT INTO `sports` (`id`, `title`, `news`, `location`, `time`) VALUES
(1, 'rizan', 'kotha khele', '', '1/2/8'),
(2, 'ss', 'ss', '', 'ss'),
(3, 'rat dupure kerabera ', 'aj shamsu kupabe', 'Rajshahi', '1/14/18, 04:43:07 AM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allnews`
--
ALTER TABLE `allnews`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `corruption`
--
ALTER TABLE `corruption`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `illegal`
--
ALTER TABLE `illegal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `murder`
--
ALTER TABLE `murder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `policestation`
--
ALTER TABLE `policestation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rape`
--
ALTER TABLE `rape`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `robbery`
--
ALTER TABLE `robbery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allnews`
--
ALTER TABLE `allnews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT for table `corruption`
--
ALTER TABLE `corruption`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `illegal`
--
ALTER TABLE `illegal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `murder`
--
ALTER TABLE `murder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `policestation`
--
ALTER TABLE `policestation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `rape`
--
ALTER TABLE `rape`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `robbery`
--
ALTER TABLE `robbery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `sports`
--
ALTER TABLE `sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
