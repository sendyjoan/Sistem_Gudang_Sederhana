-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2021 at 04:07 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `idbarang` int(11) NOT NULL,
  `namabarang` varchar(255) NOT NULL,
  `harga` bigint(20) NOT NULL,
  `stock` int(11) NOT NULL,
  `idsatuan` int(11) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`idbarang`, `namabarang`, `harga`, `stock`, `idsatuan`, `keterangan`) VALUES
(1, 'Sabun Mandi 200Gr', 5000, 10, 1, 'Sabun ini digunakan untuk mandi'),
(2, 'Shampo Panten 150Ml', 20000, 5, 2, 'keterangan'),
(21, 'Vitamin C 100 Ml', 7000, 20, 7, 'Vitamin C untuk kesehatan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_barangkeluar`
--

CREATE TABLE `tb_barangkeluar` (
  `idkeluar` int(11) NOT NULL,
  `idbarang` int(11) NOT NULL,
  `idpelanggan` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlahbarang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barangkeluar`
--

INSERT INTO `tb_barangkeluar` (`idkeluar`, `idbarang`, `idpelanggan`, `tanggal`, `jumlahbarang`) VALUES
(9, 1, 16, '2021-12-20', 1),
(10, 2, 15, '2021-12-20', 2),
(13, 2, 2, '2021-12-19', 20);

-- --------------------------------------------------------

--
-- Table structure for table `tb_barangmasuk`
--

CREATE TABLE `tb_barangmasuk` (
  `idmasuk` int(11) NOT NULL,
  `idbarang` int(11) NOT NULL,
  `idsupplier` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlahbarang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barangmasuk`
--

INSERT INTO `tb_barangmasuk` (`idmasuk`, `idbarang`, `idsupplier`, `tanggal`, `jumlahbarang`) VALUES
(29, 1, 1, '2021-12-20', 10),
(30, 2, 2, '2021-12-20', 15),
(31, 21, 16, '2021-12-20', 120),
(34, 2, 2, '2021-12-19', 10);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `idpelanggan` int(11) NOT NULL,
  `namapelanggan` varchar(30) NOT NULL,
  `notelepone` varchar(13) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`idpelanggan`, `namapelanggan`, `notelepone`, `alamat`) VALUES
(1, 'Antonio', '089456852196', 'Malang'),
(2, 'Imam Ghoblin', '085700633029', 'Bondowoso'),
(14, 'Rizka Musyarofa', '083456987234', 'Tulungagung'),
(15, 'M. Al Husen', '083476105829', 'Tulungagung'),
(16, 'Sendy Joan Kevin', '082244767431', 'Trenggalek'),
(18, 'Tunggul Pambudi', '098246097124', 'Madiun');

-- --------------------------------------------------------

--
-- Table structure for table `tb_satuan`
--

CREATE TABLE `tb_satuan` (
  `idsatuan` int(11) NOT NULL,
  `namasatuan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_satuan`
--

INSERT INTO `tb_satuan` (`idsatuan`, `namasatuan`) VALUES
(1, 'Galon'),
(2, 'Kardus'),
(7, 'Botol');

-- --------------------------------------------------------

--
-- Table structure for table `tb_stock`
--

CREATE TABLE `tb_stock` (
  `idstock` int(11) NOT NULL,
  `idbarang` int(11) NOT NULL,
  `jumlahstock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_stock`
--

INSERT INTO `tb_stock` (`idstock`, `idbarang`, `jumlahstock`) VALUES
(1, 1, 20),
(2, 2, 15),
(3, 1, 10),
(4, 2, 10),
(5, 1, 10),
(6, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `idsupplier` int(11) NOT NULL,
  `namasupplier` varchar(50) NOT NULL,
  `perusahaansupplier` varchar(70) NOT NULL,
  `alamatperusahaan` text NOT NULL,
  `teleponeperusahaan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_supplier`
--

INSERT INTO `tb_supplier` (`idsupplier`, `namasupplier`, `perusahaansupplier`, `alamatperusahaan`, `teleponeperusahaan`) VALUES
(1, 'Andiyanto', 'PT. Sinarmas Jaya Sentosa', 'Surabaya', '089675456987'),
(2, 'Intan Pra', 'PT. Indah Jara', 'Bandung', '086345876286'),
(16, 'Sendy Joan', 'PT. Sinde Tbk.', 'Bandung', '087345120562');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`idbarang`),
  ADD KEY `idsatuan` (`idsatuan`);

--
-- Indexes for table `tb_barangkeluar`
--
ALTER TABLE `tb_barangkeluar`
  ADD PRIMARY KEY (`idkeluar`),
  ADD KEY `idbarang` (`idbarang`),
  ADD KEY `idpelanggan` (`idpelanggan`);

--
-- Indexes for table `tb_barangmasuk`
--
ALTER TABLE `tb_barangmasuk`
  ADD PRIMARY KEY (`idmasuk`),
  ADD KEY `idbarang` (`idbarang`),
  ADD KEY `idsupplier` (`idsupplier`);

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`idpelanggan`);

--
-- Indexes for table `tb_satuan`
--
ALTER TABLE `tb_satuan`
  ADD PRIMARY KEY (`idsatuan`);

--
-- Indexes for table `tb_stock`
--
ALTER TABLE `tb_stock`
  ADD PRIMARY KEY (`idstock`),
  ADD KEY `idbarang` (`idbarang`);

--
-- Indexes for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`idsupplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `idbarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tb_barangkeluar`
--
ALTER TABLE `tb_barangkeluar`
  MODIFY `idkeluar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tb_barangmasuk`
--
ALTER TABLE `tb_barangmasuk`
  MODIFY `idmasuk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  MODIFY `idpelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tb_satuan`
--
ALTER TABLE `tb_satuan`
  MODIFY `idsatuan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_stock`
--
ALTER TABLE `tb_stock`
  MODIFY `idstock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  MODIFY `idsupplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD CONSTRAINT `tb_barang_ibfk_1` FOREIGN KEY (`idsatuan`) REFERENCES `tb_satuan` (`idsatuan`);

--
-- Constraints for table `tb_barangkeluar`
--
ALTER TABLE `tb_barangkeluar`
  ADD CONSTRAINT `tb_barangkeluar_ibfk_1` FOREIGN KEY (`idbarang`) REFERENCES `tb_barang` (`idbarang`),
  ADD CONSTRAINT `tb_barangkeluar_ibfk_2` FOREIGN KEY (`idpelanggan`) REFERENCES `tb_pelanggan` (`idpelanggan`);

--
-- Constraints for table `tb_barangmasuk`
--
ALTER TABLE `tb_barangmasuk`
  ADD CONSTRAINT `tb_barangmasuk_ibfk_1` FOREIGN KEY (`idbarang`) REFERENCES `tb_barang` (`idbarang`),
  ADD CONSTRAINT `tb_barangmasuk_ibfk_2` FOREIGN KEY (`idsupplier`) REFERENCES `tb_supplier` (`idsupplier`);

--
-- Constraints for table `tb_stock`
--
ALTER TABLE `tb_stock`
  ADD CONSTRAINT `tb_stock_ibfk_1` FOREIGN KEY (`idbarang`) REFERENCES `tb_barang` (`idbarang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
