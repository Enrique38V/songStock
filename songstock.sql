-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2024 a las 07:00:52
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `songstock`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `idComprador` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`idComprador`, `direccion`, `telefono`) VALUES
(2, NULL, NULL),
(3, NULL, NULL),
(5, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompramusica`
--

CREATE TABLE `detallecompramusica` (
  `idDetalleMusica` int(11) NOT NULL,
  `idFactura` int(11) DEFAULT NULL,
  `idMusica` int(11) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompravinilo`
--

CREATE TABLE `detallecompravinilo` (
  `idDetalleVinilo` int(11) NOT NULL,
  `idFactura` int(11) DEFAULT NULL,
  `idVinilo` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `direccionPersona` int(11) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `idComprador` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listamusica`
--

CREATE TABLE `listamusica` (
  `idListaMusica` int(11) NOT NULL,
  `idLista` int(11) DEFAULT NULL,
  `idMusica` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `listamusica`
--

INSERT INTO `listamusica` (`idListaMusica`, `idLista`, `idMusica`) VALUES
(1, 2, 1),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listareproduccion`
--

CREATE TABLE `listareproduccion` (
  `idLista` int(11) NOT NULL,
  `idComprador` int(11) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `listareproduccion`
--

INSERT INTO `listareproduccion` (`idLista`, `idComprador`, `nombre`) VALUES
(2, 2, 'PEERROOOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musica`
--

CREATE TABLE `musica` (
  `idMusica` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `artista` varchar(20) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `peso` varchar(255) DEFAULT NULL,
  `precio` decimal(38,2) DEFAULT NULL,
  `idVendedor` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `musica`
--

INSERT INTO `musica` (`idMusica`, `nombre`, `artista`, `genero`, `peso`, `precio`, `idVendedor`, `descripcion`) VALUES
(1, 'BBE BBE', 'CONEJO MALO', 'REGUETON', 'Kb', '50000.00', 1, NULL),
(2, 'TAN SOLO FUIMOS', 'ALMAS DE BARRIO', 'RAP', 'Kb', '20000.00', 1, NULL),
(3, 'BYOB', 'SYSTEM OF A DOWN', 'ROCK', NULL, '25000.00', 1, NULL),
(4, 'AERIALS', 'SYSTEM OF A DOWN', 'ROCK', NULL, '28000.00', 1, NULL),
(5, 'SAVE ME', 'XXXTENTACION', 'TRAP', NULL, '100000.00', 1, NULL),
(6, 'ANGEL', 'XXXTENTACION', 'TRAP', NULL, '90000.00', 1, NULL),
(7, 'LOS VERBOS', 'PETITFELLAS', 'ALTERNO', NULL, '30000.00', 1, 'Cancion iconica de los petifellas donde se ve como la persona que relata la cancion busca su auto sabotaje, incluso cuando no lo quiere, cancion lanzada al mercado en el 2014'),
(8, 'Ponmela en el aire', 'Apache', 'RAP', NULL, '45000.00', 1, NULL),
(9, 'Gaminar', 'Crack family', 'RAP', NULL, '35000.00', 1, NULL),
(11, '122 Days', 'SuicideBoys', 'TRAP', NULL, '10000.00', 1, 'Cancion creada por el grupo de primos suicideboys, donde relata una parte del apocalipsis, cancion fue lanzada al mercado en el 2012'),
(12, 'Mercury', 'GHOSTEMANE ', 'TRAP', NULL, '40000.00', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musicacomprada`
--

CREATE TABLE `musicacomprada` (
  `idMusicaComprada` int(11) NOT NULL,
  `idComprador` int(11) DEFAULT NULL,
  `idMusica` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `musicacomprada`
--

INSERT INTO `musicacomprada` (`idMusicaComprada`, `idComprador`, `idMusica`) VALUES
(1, 2, 11),
(2, 2, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `numeroIdentificacion` varchar(15) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `tipoperfil` enum('COMPRADOR','VENDEDOR') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `usuario`, `contrasena`, `numeroIdentificacion`, `correo`, `estado`, `tipoperfil`) VALUES
(1, 'marlon', 'aguirre', 'enrique.aguirre', 'MTIzNDU2Nzg5', NULL, 'aguirre.20023marlones@gmail.com', 1, 'VENDEDOR'),
(2, 'marlon', 'aguirre', 'Aguirre.aguirre', 'MTIzNDU2Nzg5', NULL, 'aguirre.2002marlon@gmail.com', 1, 'COMPRADOR'),
(3, 'marlon', 'aguirre', 'vergas.aguirre', 'MTIzNDU2Nzg5', NULL, 'aguirre.202marlon@gmail.com', 1, NULL),
(5, 'marlon', 'aguirre', 'vergas.aguuirre', 'MTIzNDU2Nzg5', NULL, 'aguirre.202marlon@ggggggmail.com', 1, 'COMPRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `idVendedor` int(11) NOT NULL,
  `nombreTienda` varchar(20) DEFAULT NULL,
  `direccionTienda` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`idVendedor`, `nombreTienda`, `direccionTienda`) VALUES
(1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vinilo`
--

CREATE TABLE `vinilo` (
  `idVinilo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `artista` varchar(50) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio` decimal(38,2) DEFAULT NULL,
  `idVendedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vinilo`
--

INSERT INTO `vinilo` (`idVinilo`, `nombre`, `artista`, `genero`, `stock`, `precio`, `idVendedor`) VALUES
(1, 'TAN SOLO FUIMOS', 'ALMAS DE BARRIO', 'RAP', 10, '20000.00', 1),
(2, 'NO ME TOQUEN ESE VALS', 'JULIO JARAMILLO', 'BOLERO', 5, '30000.00', 1),
(3, 'Llora mi guitarra', 'Julio Jaramillo', 'BOLERO', 10, '40000.00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vinilocomprado`
--

CREATE TABLE `vinilocomprado` (
  `idViniloComprado` int(11) NOT NULL,
  `idComprador` int(11) DEFAULT NULL,
  `idVinilo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`idComprador`);

--
-- Indices de la tabla `detallecompramusica`
--
ALTER TABLE `detallecompramusica`
  ADD PRIMARY KEY (`idDetalleMusica`),
  ADD KEY `idFactura` (`idFactura`),
  ADD KEY `idMusica` (`idMusica`);

--
-- Indices de la tabla `detallecompravinilo`
--
ALTER TABLE `detallecompravinilo`
  ADD PRIMARY KEY (`idDetalleVinilo`),
  ADD KEY `idFactura` (`idFactura`),
  ADD KEY `idVinilo` (`idVinilo`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `idComprador` (`idComprador`);

--
-- Indices de la tabla `listamusica`
--
ALTER TABLE `listamusica`
  ADD PRIMARY KEY (`idListaMusica`),
  ADD KEY `idMusica` (`idMusica`),
  ADD KEY `idLista` (`idLista`);

--
-- Indices de la tabla `listareproduccion`
--
ALTER TABLE `listareproduccion`
  ADD PRIMARY KEY (`idLista`),
  ADD KEY `idComprador` (`idComprador`);

--
-- Indices de la tabla `musica`
--
ALTER TABLE `musica`
  ADD PRIMARY KEY (`idMusica`),
  ADD KEY `idVendedor` (`idVendedor`);

--
-- Indices de la tabla `musicacomprada`
--
ALTER TABLE `musicacomprada`
  ADD PRIMARY KEY (`idMusicaComprada`),
  ADD KEY `idMusica` (`idMusica`),
  ADD KEY `idComprador` (`idComprador`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`idVendedor`);

--
-- Indices de la tabla `vinilo`
--
ALTER TABLE `vinilo`
  ADD PRIMARY KEY (`idVinilo`),
  ADD KEY `idVendedor` (`idVendedor`);

--
-- Indices de la tabla `vinilocomprado`
--
ALTER TABLE `vinilocomprado`
  ADD PRIMARY KEY (`idViniloComprado`),
  ADD KEY `idComprador` (`idComprador`),
  ADD KEY `idVinilo` (`idVinilo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallecompramusica`
--
ALTER TABLE `detallecompramusica`
  MODIFY `idDetalleMusica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detallecompravinilo`
--
ALTER TABLE `detallecompravinilo`
  MODIFY `idDetalleVinilo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idFactura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `listamusica`
--
ALTER TABLE `listamusica`
  MODIFY `idListaMusica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `listareproduccion`
--
ALTER TABLE `listareproduccion`
  MODIFY `idLista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `musica`
--
ALTER TABLE `musica`
  MODIFY `idMusica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `musicacomprada`
--
ALTER TABLE `musicacomprada`
  MODIFY `idMusicaComprada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vinilo`
--
ALTER TABLE `vinilo`
  MODIFY `idVinilo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `vinilocomprado`
--
ALTER TABLE `vinilocomprado`
  MODIFY `idViniloComprado` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD CONSTRAINT `comprador_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `detallecompramusica`
--
ALTER TABLE `detallecompramusica`
  ADD CONSTRAINT `detallecompramusica_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`),
  ADD CONSTRAINT `detallecompramusica_ibfk_2` FOREIGN KEY (`idMusica`) REFERENCES `musica` (`idMusica`);

--
-- Filtros para la tabla `detallecompravinilo`
--
ALTER TABLE `detallecompravinilo`
  ADD CONSTRAINT `detallecompravinilo_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`),
  ADD CONSTRAINT `detallecompravinilo_ibfk_2` FOREIGN KEY (`idVinilo`) REFERENCES `vinilo` (`idVinilo`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`);

--
-- Filtros para la tabla `listamusica`
--
ALTER TABLE `listamusica`
  ADD CONSTRAINT `listamusica_ibfk_1` FOREIGN KEY (`idMusica`) REFERENCES `musica` (`idMusica`),
  ADD CONSTRAINT `listamusica_ibfk_2` FOREIGN KEY (`idLista`) REFERENCES `listareproduccion` (`idLista`);

--
-- Filtros para la tabla `listareproduccion`
--
ALTER TABLE `listareproduccion`
  ADD CONSTRAINT `listareproduccion_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`);

--
-- Filtros para la tabla `musica`
--
ALTER TABLE `musica`
  ADD CONSTRAINT `musica_ibfk_1` FOREIGN KEY (`idVendedor`) REFERENCES `vendedor` (`idVendedor`);

--
-- Filtros para la tabla `musicacomprada`
--
ALTER TABLE `musicacomprada`
  ADD CONSTRAINT `musicacomprada_ibfk_1` FOREIGN KEY (`idMusica`) REFERENCES `musica` (`idMusica`),
  ADD CONSTRAINT `musicacomprada_ibfk_2` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`);

--
-- Filtros para la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`idVendedor`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `vinilo`
--
ALTER TABLE `vinilo`
  ADD CONSTRAINT `vinilo_ibfk_1` FOREIGN KEY (`idVendedor`) REFERENCES `vendedor` (`idVendedor`);

--
-- Filtros para la tabla `vinilocomprado`
--
ALTER TABLE `vinilocomprado`
  ADD CONSTRAINT `vinilocomprado_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`),
  ADD CONSTRAINT `vinilocomprado_ibfk_2` FOREIGN KEY (`idVinilo`) REFERENCES `vinilo` (`idVinilo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
