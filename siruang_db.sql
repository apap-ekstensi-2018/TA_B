-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2018 at 04:18 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
  `id/_ruang` int(11) NOT NULL,
  `id_mahasiswa` int(11) NOT NULL,
  `waktu_mulai` varchar(100) NOT NULL,
  `waktu_selesai` varchar(100) NOT NULL,
  `tanggal_mulai` varchar(100) NOT NULL,
  `tanggal_selesai` varchar(100) NOT NULL,
  `tujuan` varchar(100) NOT NULL,
  `keterangan` varchar(500) NOT NULL,
  `jumlah_peserta` int(11) NOT NULL,
  `fasilitas` varchar(100) NOT NULL,
  `is_disetujui` varchar(100) NOT NULL,
  `disetujui_oleh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ruang`
--

CREATE TABLE `ruang` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kapasitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ruang`
--
ALTER TABLE `ruang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
