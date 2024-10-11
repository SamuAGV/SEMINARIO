-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 16-02-2024 a las 07:28:23
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `seminario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alumnos_Samuel`
--

CREATE TABLE `Alumnos_Samuel` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `ap1` varchar(250) NOT NULL,
  `ap2` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Alumnos_Samuel`
--

INSERT INTO `Alumnos_Samuel` (`id`, `nombre`, `ap1`, `ap2`, `email`, `edad`) VALUES
(1, 'Alexis Armando', 'Arriaga', 'Martinez', 'Alexis@gmail.com', 18),
(2, 'Samuel Antonio', 'Garduño', 'Vivina', 'Samuel@gmail.com', 17),
(3, 'Sandra Gisell', 'Montero', 'Delgado', 'Sandra@gmail.com', 17),
(4, 'Yeris', 'Mirranda', 'Mata', 'Yeris@gmail.com', 18),
(5, 'Ivan', 'Perez', 'Campos', 'Ivan@gmail.com', 18),
(6, 'Diego De Jesus', 'Muñoz', 'Hernandez', 'Diego@gmail.com', 17),
(7, 'Alexa Sofia', 'De Anda', 'Sanchez', 'Alexa@gmail.com', 17),
(8, 'Edgar', 'Martinez', 'Heredia', 'Edgar@gmail.com', 17),
(9, 'Ingrid Ximena', 'Vera', 'Sedillo', 'Ingrid@gmail.com', 17),
(10, 'Rodrigo De Jesus', 'Muñoz', 'Hernandez', 'Rodrigo@gmail.com', 17),
(11, 'roy', 'Hernandez', 'Hernandez', 'Roy@utvt.com', 18),
(13, 'Predro Yael', 'Martinez', 'Chavez', 'Predro@gmail.com', 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Profesores_Samuel`
--

CREATE TABLE `Profesores_Samuel` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `ap1` varchar(250) NOT NULL,
  `ap2` varchar(250) NOT NULL,
  `especialidad` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Profesores_Samuel`
--

INSERT INTO `Profesores_Samuel` (`id`, `nombre`, `ap1`, `ap2`, `especialidad`) VALUES
(1, 'Alberto', 'Gomez', 'Blas', 'Programacion'),
(2, 'Edwin', 'Alfredo', 'Guzman', 'Programacion'),
(3, 'Sonia', 'Briceida', 'Campos', 'Programacion'),
(4, 'Iris', 'Terron', 'Cordero', 'Fisica'),
(5, 'Eduardo', 'Leal', 'Garcia', 'Algebra');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alumnos_Samuel`
--
ALTER TABLE `Alumnos_Samuel`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Profesores_Samuel`
--
ALTER TABLE `Profesores_Samuel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Alumnos_Samuel`
--
ALTER TABLE `Alumnos_Samuel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `Profesores_Samuel`
--
ALTER TABLE `Profesores_Samuel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
