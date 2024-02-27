CREATE DATABASE LocadoraAutos;

USE LocadoraAutos;

CREATE TABLE Categoria(
    Cod_Categoria INT NOT NULL AUTO_INCREMENT,
    Nome_Categoria VARCHAR(20),
    PRIMARY KEY(Cod_Categoria)
);

CREATE TABLE Cambio(
    Cod_Cambio INT NOT NULL AUTO_INCREMENT,
    Nome_Cambio VARCHAR(20),
    PRIMARY KEY(Cod_Cambio)
);

CREATE TABLE Direcao(
    Cod_Direcao INT NOT NULL AUTO_INCREMENT,
    Nome_Direcao VARCHAR(20),
    PRIMARY KEY(Cod_Direcao)
);

CREATE TABLE Marca(
    Cod_Marca INT NOT NULL AUTO_INCREMENT,
    Nome_Marca VARCHAR(20),
    PRIMARY KEY(Cod_Marca)
);

CREATE TABLE Frota_Carro(
    Placa VARCHAR(7) NOT NULL,
    Chassi VARCHAR(17) NOT NULL,
    Marca INT,
    Modelo VARCHAR(15),
    Ano YEAR,
    Combustivel VARCHAR(10),
    Motorizacao CHAR(3),
    Cambio INT,
    Direcao INT,
    Preco DECIMAL(10,2),
    Categoria INT,
    Quilometragem DECIMAL(10,2),
    MaxVelocidade VARCHAR(7),
    ID INT,
    PRIMARY KEY (Placa),
    FOREIGN KEY (Categoria) REFERENCES Categoria(Cod_Categoria),
    FOREIGN KEY (Cambio) REFERENCES Cambio(Cod_Cambio),
    FOREIGN KEY (Direcao) REFERENCES Direcao(Cod_Direcao),
    FOREIGN KEY (Marca) REFERENCES Marca(Cod_Marca)
);

CREATE TABLE Cartao (
    Pagamento VARCHAR(7),
    Bandeira VARCHAR(10),
    Nome VARCHAR(50),
    Numero INT(16) PRIMARY KEY NOT NULL,
    Vence VARCHAR(5),
    CVV INT(3)
);

CREATE TABLE Usuario(
    CPF VARCHAR(11) NOT NULL,
    Nome VARCHAR(30),
    Sobrenome VARCHAR(30),
    Endereco VARCHAR(70),
    Cidade VARCHAR(20),
    Estado VARCHAR(20),
    Telefone CHAR(20),
    Email VARCHAR(20),
    Num_Cartao INT(16),
    PRIMARY KEY(CPF),
    FOREIGN KEY (Num_Cartao) REFERENCES Cartao(Numero)
);

CREATE TABLE Usuario_Alocar_Carro(
    Data_Alocacao VARCHAR(10),
    Termino_Alocacao VARCHAR(10),
    Aluguel CHAR(10),
    Placa_Frota VARCHAR(7),
    CPF_Usuario VARCHAR(12),
    Total DECIMAL(20,2),
    SubTotal DECIMAL(20,2),
    Taxa  DECIMAL(20,2),
    FOREIGN KEY (Placa_Frota) REFERENCES Frota_Carro(Placa),
    FOREIGN KEY (CPF_Usuario) REFERENCES Usuario(CPF)
);

INSERT INTO Categoria (Nome_Categoria) VALUES
("Familiar"),
("Esportivo"),
("Conversivel"),
("Off-Road"),
("Duas-Rodas"),
("Picape"),
("SUV"),
("Van"),
("Jipe");

INSERT INTO Cambio (Nome_Cambio) VALUES
("Manual"),
("Automatico"),
("Automatizado"),
("CVT");

INSERT INTO Direcao (Nome_Direcao) VALUES
("Hidralica"),
("Mecanica"),
("Eletrica"),
("Eletro-Hidraulica");

INSERT INTO Marca (Nome_Marca) VALUES
("Ford"),
("Fiat"),
("Volkswagen"),
("Tesla"),
("Mercedes-Benz"),
("Toyota"),
("BMW"),
("Porsche"),
("Hyundai"),
("Honda"),
("Audi"),
("Chevrolet");