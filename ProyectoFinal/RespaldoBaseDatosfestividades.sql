SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

DROP DATABASE IF EXISTS festividades;
CREATE DATABASE festividades;
USE festividades;

--
-- Database: `festividades`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblboletas`
--

CREATE TABLE `tblboletas` (
  `codigoEvento` int(11) NOT NULL,
  `codigoLocalidad` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `tbleventos`
--

CREATE TABLE `tbleventos` (
  `codigoEvento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoEvento` varchar(1) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `horaInicio` varchar(10) NOT NULL,
  `horaFinal` varchar(10) NOT NULL,
  `lugar` varchar(100) NOT NULL,
  `boleteria` varchar(2) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbleventos`
--

INSERT INTO `tbleventos` (`codigoEvento`, `nombre`, `tipoEvento`, `fecha`, `horaInicio`, `horaFinal`, `lugar`, `boleteria`, `estado`) VALUES
(1, 'Tsunami vallenato', 'C', '20/09/2024', '8:00 p.m.', '12:00 a,m', 'plaza de toros La Macarena', 'si', 'programado');

-- --------------------------------------------------------

--
-- Table structure for table `tbllocalidad`
--

CREATE TABLE `tbllocalidad` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbllocalidad`
--

INSERT INTO `tbllocalidad` (`codigo`, `nombre`, `cupo`) VALUES
(1, 'General', 200),
(2, 'Preferencial', 100),
(3, 'VIP', 50),
(4, 'Platino', 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblboletas`
--
ALTER TABLE `tblboletas`
  ADD PRIMARY KEY (`codigoEvento`,`codigoLocalidad`),
  ADD KEY `codigoLocalidad` (`codigoLocalidad`);

--
-- Indexes for table `tbleventos`
--
ALTER TABLE `tbleventos`
  ADD PRIMARY KEY (`codigoEvento`);

--
-- Indexes for table `tbllocalidad`
--
ALTER TABLE `tbllocalidad`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbleventos`
--
ALTER TABLE `tbleventos`
  MODIFY `codigoEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbllocalidad`
--
ALTER TABLE `tbllocalidad`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblboletas`
--
ALTER TABLE `tblboletas`
  ADD CONSTRAINT `tblboletas_ibfk_1` FOREIGN KEY (`codigoEvento`) REFERENCES `tbleventos` (`codigoEvento`),
  ADD CONSTRAINT `tblboletas_ibfk_2` FOREIGN KEY (`codigoLocalidad`) REFERENCES `tbllocalidad` (`codigo`);
COMMIT;
