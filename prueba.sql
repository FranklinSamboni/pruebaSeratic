-- Script was generated by Devart dbForge Studio Express for MySQL, Version 5.0.97.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 1/09/2017 11:54:11 a. m.
-- Server version: 5.5.5-10.1.13-MariaDB
-- Client version: 4.1

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

--
-- Definition for table cliente
--
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  cedula VARCHAR(80) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  telefono VARCHAR(80) NOT NULL,
  correo VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (cedula)
)
ENGINE = INNODB
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table evento
--
DROP TABLE IF EXISTS evento;
CREATE TABLE evento (
  id INT(11) UNSIGNED NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  ciudad VARCHAR(120) NOT NULL,
  fecha DATETIME NOT NULL,
  cantidadBoletos INT(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AVG_ROW_LENGTH = 16384
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tipo
--
DROP TABLE IF EXISTS tipo;
CREATE TABLE tipo (
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table usuario
--
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(125) DEFAULT NULL,
  apellido VARCHAR(122) DEFAULT NULL,
  usuario VARCHAR(255) NOT NULL,
  clave VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL,
  fechaRegistro VARCHAR(255) DEFAULT NULL,
  habilitado BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table boleto
--
DROP TABLE IF EXISTS boleto;
CREATE TABLE boleto (
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  idEvento INT(11) UNSIGNED NOT NULL,
  valor DOUBLE NOT NULL DEFAULT 0,
  idTipo INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_boleto_evento_id FOREIGN KEY (idEvento)
    REFERENCES evento(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_boleto_tipo_id FOREIGN KEY (idTipo)
    REFERENCES tipo(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 2
AVG_ROW_LENGTH = 16384
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

-- 
-- Dumping data for table cliente
--
-- Table bdboletos.cliente does not contain any data (it is empty)

-- 
-- Dumping data for table evento
--
INSERT INTO evento VALUES 
  (1, 'EVENTO 1', 'CALLE FALSA 123', 'POPAYAN', '2017-09-02 10:45:42', 150);

-- 
-- Dumping data for table tipo
--
INSERT INTO tipo VALUES 
  (1, 'VIP'),
  (2, 'PLATINO'),
  (3, 'GENERAL'),
  (4, 'PALCO');

-- 
-- Dumping data for table usuario
--
-- Table bdboletos.usuario does not contain any data (it is empty)

-- 
-- Dumping data for table boleto
--
INSERT INTO boleto VALUES 
  (1, 1, 25000, 3);

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;