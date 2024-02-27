-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/11/2023 às 00:05
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locadoraautos`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cambio`
--

CREATE TABLE `cambio` (
  `Cod_Cambio` int(11) NOT NULL,
  `Nome_Cambio` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cambio`
--

INSERT INTO `cambio` (`Cod_Cambio`, `Nome_Cambio`) VALUES
(1, 'Manual'),
(2, 'Automatico'),
(3, 'Automatizado'),
(4, 'CVT');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cartao`
--

CREATE TABLE `cartao` (
  `Pagamento` varchar(7) DEFAULT NULL,
  `Bandeira` varchar(10) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Numero` int(16) NOT NULL,
  `Vence` varchar(5) DEFAULT NULL,
  `CVV` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cartao`
--

INSERT INTO `cartao` (`Pagamento`, `Bandeira`, `Nome`, `Numero`, `Vence`, `CVV`) VALUES
('Debido', 'MasterCard', 'teste', 222, '22', 222);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `Cod_Categoria` int(11) NOT NULL,
  `Nome_Categoria` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`Cod_Categoria`, `Nome_Categoria`) VALUES
(1, 'Familiar'),
(2, 'Esportivo'),
(3, 'Conversivel'),
(4, 'Off-Road'),
(5, 'Duas-Rodas'),
(6, 'Picape'),
(7, 'SUV'),
(8, 'Van'),
(9, 'Jipe');

-- --------------------------------------------------------

--
-- Estrutura para tabela `direcao`
--

CREATE TABLE `direcao` (
  `Cod_Direcao` int(11) NOT NULL,
  `Nome_Direcao` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `direcao`
--

INSERT INTO `direcao` (`Cod_Direcao`, `Nome_Direcao`) VALUES
(1, 'Hidralica'),
(2, 'Mecanica'),
(3, 'Eletrica'),
(4, 'Eletro-Hidraulica');

-- --------------------------------------------------------

--
-- Estrutura para tabela `frota_carro`
--

CREATE TABLE `frota_carro` (
  `Placa` varchar(7) NOT NULL,
  `Chassi` varchar(17) NOT NULL,
  `Marca` int(11) DEFAULT NULL,
  `Modelo` varchar(15) DEFAULT NULL,
  `Ano` year(4) DEFAULT NULL,
  `Combustivel` varchar(10) DEFAULT NULL,
  `Motorizacao` char(3) DEFAULT NULL,
  `Cambio` int(11) DEFAULT NULL,
  `Direcao` int(11) DEFAULT NULL,
  `Preco` decimal(10,2) DEFAULT NULL,
  `Categoria` int(11) DEFAULT NULL,
  `Quilometragem` decimal(10,2) DEFAULT NULL,
  `MaxVelocidade` varchar(7) DEFAULT NULL,
  `ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `frota_carro`
--

INSERT INTO `frota_carro` (`Placa`, `Chassi`, `Marca`, `Modelo`, `Ano`, `Combustivel`, `Motorizacao`, `Cambio`, `Direcao`, `Preco`, `Categoria`, `Quilometragem`, `MaxVelocidade`, `ID`) VALUES
('123gfd', '1as5f1', 9, 'teste', '2000', 'asfikhjas', '1.1', 1, 2, 151.00, 6, 156315.00, '151', 1),
('444tes', '444tes', 4, 'teste2', '2002', 'teste2', '4.4', 4, 4, 4444.00, 4, 222.00, '444', 1),
('456qwe', 'asfasf', 5, 'dgsdg', '2002', 'asfas', '1.1', 2, 2, 121.00, 3, 2136.00, '546', 1),
('456xcv', 'asasfa', 5, 'asdasd', '2000', 'asfasf', '1.1', 2, 2, 1213.00, 2, 544.00, '123', 1),
('541asf', 'asfa45', 8, 'asfasf', '2011', 'gahg', '1.2', 3, 2, 5451.00, 2, 451.00, '15', 1),
('871asd', 'asfyug', 4, 'testerealmente', '2012', 'safasf', '3.0', 3, 3, 4854.00, 4, 454.00, '123', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `marca`
--

CREATE TABLE `marca` (
  `Cod_Marca` int(11) NOT NULL,
  `Nome_Marca` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `marca`
--

INSERT INTO `marca` (`Cod_Marca`, `Nome_Marca`) VALUES
(1, 'Ford'),
(2, 'Fiat'),
(3, 'Volkswagen'),
(4, 'Tesla'),
(5, 'Mercedes-Benz'),
(6, 'Toyota'),
(7, 'BMW'),
(8, 'Porsche'),
(9, 'Hyundai'),
(10, 'Honda'),
(11, 'Audi'),
(12, 'Chevrolet');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `CPF` varchar(14) NOT NULL,
  `Nome` varchar(30) DEFAULT NULL,
  `Sobrenome` varchar(30) DEFAULT NULL,
  `Endereco` varchar(70) DEFAULT NULL,
  `Cidade` varchar(20) DEFAULT NULL,
  `Estado` varchar(20) DEFAULT NULL,
  `Telefone` char(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Num_Cartao` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`CPF`, `Nome`, `Sobrenome`, `Endereco`, `Cidade`, `Estado`, `Telefone`, `Email`, `Num_Cartao`) VALUES
('125', 'g', 'g', 'g', 'g', 'g', '6', 'g', NULL),
('481', 'g', 'g', 'g', 'g', 'g', '6', 'g', NULL),
('4816', 'sad', 'asd', 'asd', 'asd', 'asd', '414', 'asd', NULL),
('teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 222);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario_alocar_carro`
--

CREATE TABLE `usuario_alocar_carro` (
  `Data_Alocacao` varchar(10) DEFAULT NULL,
  `Termino_Alocacao` varchar(10) DEFAULT NULL,
  `Aluguel` char(10) DEFAULT NULL,
  `Placa_Frota` varchar(7) DEFAULT NULL,
  `CPF_Usuario` varchar(12) DEFAULT NULL,
  `Total` decimal(20,2) DEFAULT NULL,
  `SubTotal` decimal(20,2) DEFAULT NULL,
  `Taxa` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario_alocar_carro`
--

INSERT INTO `usuario_alocar_carro` (`Data_Alocacao`, `Termino_Alocacao`, `Aluguel`, `Placa_Frota`, `CPF_Usuario`, `Total`, `SubTotal`, `Taxa`) VALUES
('30/12/2012', '30/12/2013', 'Diaria', '871asd', '125', 4854.12, 4854.00, 582.48),
('28/12/2012', '30/12/2012', 'Diaria', '871asd', '481', 4854.12, 4854.00, 582.48),
('12/12/2002', '12/12/2003', 'Quinzenal', '456xcv', '4816', 18195.12, 18195.00, 2183.40),
('22', '22', 'Diaria', '123gfd', 'teste', 169.12, 151.00, 18.12);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cambio`
--
ALTER TABLE `cambio`
  ADD PRIMARY KEY (`Cod_Cambio`);

--
-- Índices de tabela `cartao`
--
ALTER TABLE `cartao`
  ADD PRIMARY KEY (`Numero`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Cod_Categoria`);

--
-- Índices de tabela `direcao`
--
ALTER TABLE `direcao`
  ADD PRIMARY KEY (`Cod_Direcao`);

--
-- Índices de tabela `frota_carro`
--
ALTER TABLE `frota_carro`
  ADD PRIMARY KEY (`Placa`),
  ADD KEY `Categoria` (`Categoria`),
  ADD KEY `Cambio` (`Cambio`),
  ADD KEY `Direcao` (`Direcao`),
  ADD KEY `Marca` (`Marca`);

--
-- Índices de tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`Cod_Marca`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CPF`),
  ADD KEY `Num_Cartao` (`Num_Cartao`);

--
-- Índices de tabela `usuario_alocar_carro`
--
ALTER TABLE `usuario_alocar_carro`
  ADD KEY `Placa_Frota` (`Placa_Frota`),
  ADD KEY `CPF_Usuario` (`CPF_Usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cambio`
--
ALTER TABLE `cambio`
  MODIFY `Cod_Cambio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `Cod_Categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `direcao`
--
ALTER TABLE `direcao`
  MODIFY `Cod_Direcao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `Cod_Marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `frota_carro`
--
ALTER TABLE `frota_carro`
  ADD CONSTRAINT `frota_carro_ibfk_1` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`Cod_Categoria`),
  ADD CONSTRAINT `frota_carro_ibfk_2` FOREIGN KEY (`Cambio`) REFERENCES `cambio` (`Cod_Cambio`),
  ADD CONSTRAINT `frota_carro_ibfk_3` FOREIGN KEY (`Direcao`) REFERENCES `direcao` (`Cod_Direcao`),
  ADD CONSTRAINT `frota_carro_ibfk_4` FOREIGN KEY (`Marca`) REFERENCES `marca` (`Cod_Marca`);

--
-- Restrições para tabelas `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Num_Cartao`) REFERENCES `cartao` (`Numero`);

--
-- Restrições para tabelas `usuario_alocar_carro`
--
ALTER TABLE `usuario_alocar_carro`
  ADD CONSTRAINT `usuario_alocar_carro_ibfk_1` FOREIGN KEY (`Placa_Frota`) REFERENCES `frota_carro` (`Placa`),
  ADD CONSTRAINT `usuario_alocar_carro_ibfk_2` FOREIGN KEY (`CPF_Usuario`) REFERENCES `usuario` (`CPF`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
