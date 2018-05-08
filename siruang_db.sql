-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2018 at 03:10 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siruang_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_ruangan`
--

CREATE TABLE `peminjaman_ruangan` (
  `id` int(11) NOT NULL,
  `id_ruang` int(11) NOT NULL,
  `id_mahasiswa` int(11) NOT NULL,
  `waktu_mulai` varchar(100) NOT NULL,
  `waktu_selesai` varchar(100) NOT NULL,
  `tanggal_mulai` varchar(100) NOT NULL,
  `tanggal_selesai` varchar(100) NOT NULL,
  `tujuan` varchar(100) NOT NULL,
  `keterangan` varchar(500) DEFAULT NULL,
  `jumlah_peserta` int(11) NOT NULL,
  `fasilitas` varchar(100) NOT NULL,
  `is_disetujui` varchar(100) NOT NULL,
  `disetujui_oleh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman_ruangan`
--

INSERT INTO `peminjaman_ruangan` (`id`, `id_ruang`, `id_mahasiswa`, `waktu_mulai`, `waktu_selesai`, `tanggal_mulai`, `tanggal_selesai`, `tujuan`, `keterangan`, `jumlah_peserta`, `fasilitas`, `is_disetujui`, `disetujui_oleh`) VALUES
(1, 4, 2, '1:32', '22:01', '17/02/2018', '16/03/2018', 'drive impactful deliverables', 'key on hand', 82, 'black board,socket,chair', '0', 36),
(2, 10, 16, '0:59', '17:58', '27/02/2018', '23/03/2018', 'deploy sexy content', 'can not be disturbed', 23, 'projector,  speaker,socket,chair', '0', 36),
(3, 44, 3, '4:42', '18:28', '18/01/2018', '26/03/2018', 'monetize magnetic web-readiness', 'key on hand', 96, 'microphone,monitor,chair', '1', 36),
(4, 30, 1, '3:47', '16:18', '27/02/2018', '17/04/2018', 'transform clicks-and-mortar e-services', 'can not be disturbed', 54, 'white board,monitor,chair', '0', 36),
(5, 22, 3, '10:11', '23:39', '11/01/2018', '14/03/2018', 'revolutionize distributed bandwidth', NULL, 91, 'microphone,socket,chair', '0', 36),
(6, 32, 19, '6:49', '14:43', '13/01/2018', '21/03/2018', 'unleash seamless web services', 'key on hand', 75, 'projector,  speaker,socket,chair', '1', 36),
(7, 17, 6, '6:50', '18:55', '15/02/2018', '16/04/2018', 'streamline seamless users', 'key on hand', 17, 'microphone,monitor,chair', '0', 36),
(8, 31, 15, '5:58', '13:17', '07/01/2018', '29/03/2018', 'enable killer applications', NULL, 51, 'white board,monitor,chair', '1', 36),
(9, 19, 10, '6:36', '22:32', '12/02/2018', '27/03/2018', 'grow compelling communities', NULL, 19, 'microphone,socket,chair', '1', 36),
(10, 50, 17, '3:01', '17:18', '09/01/2018', '14/03/2018', 'integrate vertical users', 'can not be disturbed', 53, 'microphone,socket,chair', '1', 36),
(11, 33, 19, '7:29', '15:50', '27/01/2018', '02/04/2018', 'implement turn-key ROI', NULL, 28, 'white board,monitor,chair', '0', 36),
(12, 45, 8, '2:41', '17:31', '10/02/2018', '08/04/2018', 'generate ubiquitous experiences', NULL, 43, 'microphone,monitor,chair', '1', 36),
(13, 42, 15, '8:55', '15:55', '22/02/2018', '04/04/2018', 'visualize proactive paradigms', NULL, 55, 'projector,  speaker,socket,chair', '1', 36),
(14, 1, 6, '2:32', '13:27', '12/02/2018', '16/04/2018', 'engage cross-media web services', NULL, 55, 'microphone,monitor,chair', '0', 36),
(15, 27, 18, '11:08', '17:52', '10/02/2018', '07/04/2018', 'empower 24/7 experiences', 'key on hand', 22, 'black board,monitor,chair', '1', 36);

-- --------------------------------------------------------

--
-- Table structure for table `ruang`
--

CREATE TABLE `ruang` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kapasitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruang`
--

INSERT INTO `ruang` (`id`, `nama`, `kapasitas`) VALUES
(1, 'Eagle, pallas\'s fish', 100),
(2, 'Red-billed buffalo weaver', 30),
(3, 'Gull, lava', 62),
(4, 'Squirrel, grey-footed', 42),
(5, 'Buffalo, wild water', 54),
(6, 'Peacock, blue', 5),
(7, 'Grey heron', 67),
(8, 'Antelope ground squirrel', 81),
(9, 'Ring-necked pheasant', 9),
(10, 'Mara', 54),
(11, 'Steller\'s sea lion', 47),
(12, 'Deer, white-tailed', 93),
(13, 'Colobus, white-mantled', 19),
(14, 'Fox, blue', 64),
(15, 'Bahama pintail', 22),
(16, 'Golden jackal', 6),
(17, 'Mouse, four-striped grass', 17),
(18, 'Penguin, galapagos', 71),
(19, 'Pelican, australian', 36),
(20, 'Eleven-banded armadillo (unidentified)', 33),
(21, 'American alligator', 98),
(22, 'Snake, tiger', 56),
(23, 'Dog, african wild', 92),
(24, 'White-necked raven', 69),
(25, 'Whale, baleen', 71),
(26, 'Blue-footed booby', 98),
(27, 'Tamandua, southern', 95),
(28, 'Chestnut weaver', 74),
(29, 'Green-winged trumpeter', 58),
(30, 'Spider, wolf', 59),
(31, 'Nyala', 33),
(32, 'Small Indian mongoose', 54),
(33, 'Puma', 58),
(34, 'Goldeneye, barrows', 85),
(35, 'Chilean flamingo', 33),
(36, 'Turtle, eastern box', 84),
(37, 'Crested porcupine', 34),
(38, 'Crane, blue', 69),
(39, 'Lilac-breasted roller', 5),
(40, 'Antelope, sable', 7),
(41, 'Jackrabbit, white-tailed', 10),
(42, 'Macaw, blue and yellow', 37),
(43, 'Brown and yellow marshbird', 48),
(44, 'Radiated tortoise', 53),
(45, 'Great egret', 64),
(46, 'Cormorant (unidentified)', 6),
(47, 'Wolf spider', 78),
(48, 'Greater rhea', 95),
(49, 'White-faced tree rat', 19),
(50, 'Seal, northern elephant', 68),
(51, 'Possum, pygmy', 54),
(52, 'Mongoose, banded', 42),
(53, 'Eastern boa constrictor', 47),
(54, 'Ass, asiatic wild', 50),
(55, 'Heron, yellow-crowned night', 27),
(56, 'Falcon, peregrine', 35),
(57, 'Pelican, australian', 27),
(58, 'African porcupine', 24),
(59, 'Wombat, southern hairy-nosed', 39),
(60, 'Blesbok', 77),
(61, 'Rainbow lory', 30),
(62, 'Dog, black-tailed prairie', 92),
(63, 'Squirrel, european red', 70),
(64, 'Indian red admiral', 34),
(65, 'Eagle owl (unidentified)', 67),
(66, 'Common nighthawk', 29),
(67, 'Vulture, turkey', 95),
(68, 'Deer, spotted', 37),
(69, 'Common turkey', 40),
(70, 'Cormorant, pied', 66),
(71, 'White-browed sparrow weaver', 10),
(72, 'Bear, sloth', 11),
(73, 'Common green iguana', 34),
(74, 'Plover, blacksmith', 6),
(75, 'Lion, southern sea', 30),
(76, 'Ground monitor (unidentified)', 41),
(77, 'Black-collared barbet', 88),
(78, 'South African hedgehog', 49),
(79, 'Southern right whale', 91),
(80, 'Tern, white-winged', 79),
(81, 'Phalarope, red-necked', 10),
(82, 'Loris, slender', 95),
(83, 'Siskin, yellow-rumped', 79),
(84, 'African polecat', 60),
(85, 'Deer, savannah', 95),
(86, 'Lion, steller\'s sea', 40),
(87, 'Blue catfish', 69),
(88, 'Sandhill crane', 66),
(89, 'Otter, canadian river', 89),
(90, 'Turkey, common', 30),
(91, 'Blue and yellow macaw', 23),
(92, 'Tortoise, desert', 34),
(93, 'Golden brush-tailed possum', 26),
(94, 'Levaillant\'s barbet', 40),
(95, 'Hoffman\'s sloth', 76),
(96, 'Banded mongoose', 30),
(97, 'Duck, blue', 58),
(98, 'Golden brush-tailed possum', 10),
(99, 'Lemur, grey mouse', 34),
(100, 'Caribou', 44);

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`username`, `password`, `role`) VALUES
('1506721756', 'password', 'mahasiswa'),
('1506721762', 'password', 'mahasiswa'),
('1506721775', 'password', 'mahasiswa'),
('1506721781', 'password', 'mahasiswa'),
('1506721794', 'password', 'mahasiswa'),
('1506721806', 'password', 'mahasiswa'),
('1506721812', 'password', 'mahasiswa'),
('1506721825', 'password', 'mahasiswa'),
('1506721831', 'password', 'mahasiswa'),
('1506721844', 'password', 'mahasiswa'),
('1506721863', 'password', 'mahasiswa'),
('1506721876', 'password', 'mahasiswa'),
('1506721882', 'password', 'mahasiswa'),
('1506721895', 'password', 'mahasiswa'),
('1506721900', 'password', 'mahasiswa'),
('1506757642', 'password', 'mahasiswa'),
('1506757655', 'password', 'mahasiswa'),
('1506757661', 'password', 'mahasiswa'),
('1506757680', 'password', 'mahasiswa'),
('1506757693', 'password', 'mahasiswa'),
('1290578809', 'password', 'dosen'),
('1290578803', 'password', 'dosen'),
('1290578805', 'password', 'dosen'),
('1290578897', 'password', 'dosen'),
('1290578843', 'password', 'dosen'),
('1290578845', 'password', 'dosen'),
('1290578815', 'password', 'dosen'),
('1290578817', 'password', 'dosen'),
('1290578811', 'password', 'dosen'),
('1290578813', 'password', 'dosen'),
('1290578823', 'password', 'dosen'),
('1290578825', 'password', 'dosen'),
('1290578819', 'password', 'dosen'),
('1290578821', 'password', 'dosen'),
('1290578831', 'password', 'dosen'),
('1290578833', 'password', 'dosen'),
('1290578827', 'password', 'dosen'),
('1290578829', 'password', 'dosen'),
('1290578839', 'password', 'dosen'),
('1290578841', 'password', 'dosen'),
('1290578835', 'password', 'dosen'),
('1290578837', 'password', 'dosen'),
('1290578783', 'password', 'dosen'),
('1290578785', 'password', 'dosen'),
('1290578781', 'password', 'dosen'),
('1290578791', 'password', 'dosen'),
('1290578793', 'password', 'dosen'),
('1290578787', 'password', 'dosen'),
('1290578789', 'password', 'dosen'),
('1290578799', 'password', 'dosen'),
('1290578801', 'password', 'dosen'),
('1290578795', 'password', 'dosen'),
('1290578797', 'password', 'dosen'),
('1290578807', 'password', 'dosen'),
('1506737823', 'password', 'staf'),
('1506689692', 'password', 'staf'),
('1506723231', 'password', 'staf'),
('1406575815', 'password', 'staf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `peminjaman_ruangan`
--
ALTER TABLE `peminjaman_ruangan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ruang`
--
ALTER TABLE `ruang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `peminjaman_ruangan`
--
ALTER TABLE `peminjaman_ruangan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=501;
--
-- AUTO_INCREMENT for table `ruang`
--
ALTER TABLE `ruang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
