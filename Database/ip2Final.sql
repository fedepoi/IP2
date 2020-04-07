-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2020 at 12:03 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ip2d`
--
drop database if exists ip2Final;
CREATE DATABASE IF NOT EXISTS ip2Final DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE ip2Final;





-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `answerId` int(3) NOT NULL,
  `answerdesc` varchar(50) NOT NULL,
  `questionId` int(3) DEFAULT NULL,
  `correct` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answerId`, `answerdesc`, `questionId`, `correct`) VALUES
(1, '54 r5', 1, 1),
(2, '133 r5', 1, 0),
(3, '233 r7', 1, 0),
(4, '453 r5', 1, 0),
(5, '117 r1', 2, 1),
(6, '17 r3', 2, 0),
(7, '130 r1', 2, 0),
(8, '117 r15', 2, 0),
(9, '0.071', 3, 1),
(10, '0.1', 3, 0),
(11, '15', 3, 0),
(12, '116', 3, 0),
(13, '5.61', 4, 1),
(14, '12', 4, 0),
(15, '1', 4, 0),
(16, '5.89', 4, 0),
(17, '0.1947', 5, 1),
(18, '3', 5, 0),
(19, '0.123', 5, 0),
(20, '67', 5, 0),
(21, '1.2', 6, 1),
(22, '1.5', 6, 0),
(23, '4', 6, 0),
(24, '41', 6, 0),
(25, '9', 7, 1),
(26, '93', 7, 0),
(27, '3', 7, 0),
(28, '123', 7, 0),
(29, '39', 8, 1),
(30, '12', 8, 0),
(31, '349', 8, 0),
(32, '78', 8, 0),
(33, '3.9', 9, 1),
(34, '5.7', 9, 0),
(35, '89', 9, 0),
(36, '67', 9, 0),
(37, '0.049', 10, 1),
(38, '0.5', 10, 0),
(39, '0.9', 10, 0),
(40, '9', 10, 0),
(41, 'Saudi Arabia', 11, 1),
(42, 'America', 11, 0),
(43, 'Europe', 11, 0),
(44, 'Oceania', 11, 0),
(45, 'River Seine', 12, 1),
(46, 'River Tevere', 12, 0),
(47, 'River Thames', 12, 0),
(48, 'River Nile', 12, 0),
(49, 'Isle of Man', 13, 1),
(50, 'Isle of Skye', 13, 0),
(51, 'Isle of Sardinia', 13, 0),
(52, 'Gran Canaria', 13, 0),
(53, 'Ljubljana', 14, 1),
(54, 'Porto', 14, 0),
(55, 'Rome', 14, 0),
(56, 'Algeri', 14, 0),
(57, 'Germany', 15, 1),
(58, 'Italy', 15, 0),
(59, 'Romania', 15, 0),
(60, 'UK', 15, 0),
(61, 'Mongolia', 16, 1),
(62, 'Tibet', 16, 0),
(63, 'China', 16, 0),
(64, 'Japan', 16, 0),
(65, 'Port of Rotterdam', 17, 1),
(66, 'Port of Civitavecchia', 17, 0),
(67, 'Port of Naples', 17, 0),
(68, 'Port of London', 17, 0),
(69, 'Bermuda', 18, 1),
(70, 'Hawai', 18, 0),
(71, 'Portugal', 18, 0),
(72, 'Himalaya', 18, 0),
(73, 'Scotland', 19, 1),
(74, 'France', 19, 0),
(75, 'Wales', 19, 0),
(76, 'Swissland', 19, 0),
(77, 'Naples', 20, 1),
(78, 'Rome', 20, 0),
(79, 'Pistoia', 20, 0),
(80, 'Brindisi', 20, 0),
(81, 'Central processing unit', 21, 1),
(82, 'PC', 21, 0),
(83, 'Hamburger', 21, 0),
(84, 'Ram', 21, 0),
(85, 'Random access memory', 22, 1),
(86, 'Cache', 22, 0),
(87, 'ROM', 22, 0),
(88, 'CPU', 22, 0),
(89, 'Asdf jkl;', 23, 1),
(90, 'qwerty jkl;', 23, 0),
(91, 'Asdf poi;', 23, 0),
(92, 'asdfghjkl;', 23, 0),
(93, 'Code or program', 24, 1),
(94, 'Apple', 24, 0),
(95, 'Method', 24, 0),
(96, 'Class', 24, 0),
(97, 'Flaming (sending hurtful or mean messages on the I', 25, 1),
(98, 'Hakers', 25, 0),
(99, 'Onions', 25, 0),
(100, 'Push Notifications', 25, 0),
(101, 'Modem', 26, 1),
(102, 'Phone', 26, 0),
(103, 'Mainframe', 26, 0),
(104, 'Cable', 26, 0),
(105, 'Calendars, cards, brochures, flyers, etc.', 27, 1),
(106, 'Poster', 27, 0),
(107, 'A4 page', 27, 0),
(108, 'Pasta', 27, 0),
(109, 'Documents', 28, 1),
(110, 'Files', 28, 0),
(111, 'Images', 28, 0),
(112, 'Deckstop', 28, 0),
(113, '_underscore', 29, 1),
(114, ' and', 29, 0),
(115, '. Period', 29, 0),
(116, ', Comma', 29, 0),
(117, 'Format painter', 30, 1),
(118, 'Printer', 30, 0),
(119, 'Toner', 30, 0),
(120, 'July', 30, 0);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryId` int(3) NOT NULL,
  `categoryName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryId`, `categoryName`) VALUES
(1, 'Math'),
(2, 'Geography'),
(3, 'Computer Science');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `questionId` int(3) NOT NULL,
  `questionDesc` varchar(50) NOT NULL,
  `categoryId` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionId`, `questionDesc`, `categoryId`) VALUES
(1, '491/9=?', 1),
(2, '703/6', 1),
(3, 'Express 71/1000 as a decimal.', 1),
(4, ' 4.7 + .9 + .01 =', 1),
(5, '33 × .59 =?', 1),
(6, '.84/0.7 =?', 1),
(7, 'Express the ten thousandths place in 1.7389', 1),
(8, '1.87 – 1.48 =?', 1),
(9, 'Round 3.864 to the nearest tenth.', 1),
(10, 'Which is the equivalent decimal number for forty n', 1),
(11, 'What is the only country with a coastline on both ', 2),
(12, 'Which river flows through Paris?', 2),
(13, 'Where in the British isles is Lady Isabella, the w', 2),
(14, 'What is the capital city of Slovenia, formerly par', 2),
(15, 'Which European country shares its border with the ', 2),
(16, 'Which Asian country is bigger than France, Spain a', 2),
(17, 'What is Europe’s largest port?', 2),
(18, 'Hamilton is the capital of which island in the Nor', 2),
(19, 'In which country is the UK’s highest mountain, Ben', 2),
(20, 'Mount Vesuvius overlooks which modern Italian city', 2),
(21, 'What is CPU an acronym for?', 3),
(22, 'What is RAM?', 3),
(23, 'What are the home row keys on a keyboard?', 3),
(24, 'SCRATCH is a program used to do what in computer s', 3),
(25, 'Which of the following is a form of cyberbullying?', 3),
(26, 'This is used to connect your computer to the Inter', 3),
(27, 'When using Microsoft Publisher, you would create w', 3),
(28, 'Microsoft Word is used to create which of the foll', 3),
(29, 'When saving files on your computer, which characte', 3),
(30, 'In Microsoft Office programs, this enables the use', 3);

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `scoreId` int(3) NOT NULL,
  `score` int(3) NOT NULL,
  `seconds` int(3) DEFAULT NULL,
   rating int(3) default null,
   scoreDate date 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scores`
--

-- --------------------------------------------------------

--
-- Table structure for table `userquiz`
--

CREATE TABLE `userquiz` (
  `quizId` int(3) NOT NULL,
  `categoryId` int(3) NOT NULL,
  `scoreId` int(3) NOT NULL,
  `userId` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userquiz`
--
-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `userId` int(3) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `admin` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`userId`, `firstName`, `lastName`, `email`, `password`, `admin`) VALUES
(1, 'Federico', 'Vivaldo', 'fviv@cal.com', 'pass1', 1),
(2, 'Smith', 'Brown', 'mrbrown@cal.com', 'hey98', 0),
(3, 'Jane', 'Rose', 'jane@gmail.com', 'Koala98', 0),
(4, 'Joey', 'Loch', 'joy@live.it', 'xilo12', 0),
(5, 'Vicky', 'Tsiro', 'vicky@cal.com', 'x1p8', 0),
(6, 'Chloe', 'Ruby', 'miss.ruby@gmail.com', 'rugby78', 0),
(7, 'Evangeline', 'Brown', 'evangeline.b@gmail.com', 'star95', 0),
(8, 'Nancy', 'Fredson', 'nancy.fred@cal.com', 'nana7', 0),
(9, 'Susanne', 'Swan', 'susy.swan@gmail.com', 'susy.s', 0),
(10, 'Mia', 'Roscini', 'mia.r@gmail.com', 'mia.17', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answerId`),
  ADD KEY `questionId` (`questionId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`),
  ADD UNIQUE KEY `category_uk1` (`categoryName`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `categoryId` (`categoryId`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`scoreId`);

--
-- Indexes for table `userquiz`
--
ALTER TABLE `userquiz`
  ADD PRIMARY KEY (`quizId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `categoryId` (`categoryId`),
  ADD KEY `scoreId` (`scoreId`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `user_uk1` (`userId`,`email`,`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `answerId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `scoreId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- AUTO_INCREMENT for table `userquiz`
--
ALTER TABLE `userquiz`
  MODIFY `quizId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `userId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `questions` (`questionId`)
   ON DELETE CASCADE;

--
-- Constraints for table `category`
--
-- ALTER TABLE `category`
  -- ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `questions` (`questionId`),
  -- ADD CONSTRAINT `category_ibfk_2` FOREIGN KEY (`quizId`) REFERENCES `userquiz` (`quizId`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
   ON DELETE CASCADE;

--
-- Constraints for table `scores`
--
-- ALTER TABLE `scores`
  -- ADD CONSTRAINT `scores_ibfk_1` FOREIGN KEY (`quizId`) REFERENCES `userquiz` (`quizId`);

--
-- Constraints for table `userquiz`
--
ALTER TABLE `userquiz`
  ADD CONSTRAINT `userquiz_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `usertable` (`userId`),
  ADD CONSTRAINT `userquiz_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`),
  ADD CONSTRAINT `userquiz_ibfk_3` FOREIGN KEY (`scoreId`) REFERENCES `scores` (`scoreId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
