CREATE DATABASE LIMNV;

USE LIMNV;

CREATE TABLE CLIENTES
(
	ID INT PRIMARY KEY IDENTITY,
	NOME VARCHAR(50),
	CPF CHAR(14),
	SENHA VARCHAR(64)
);

CREATE TABLE CONTAS
(
	ID INT PRIMARY KEY IDENTITY,
	DESCRICAO VARCHAR(50),
	CLIENTEID INT FOREIGN KEY REFERENCES CLIENTES(ID),
	SALDO DECIMAL(18,2),
	TIPO CHAR(1),
	ATIVO CHAR(1) DEFAULT 'S'
);

CREATE TABLE DEPOSITOS
(
	ID INT PRIMARY KEY IDENTITY,
	CONTAID INT FOREIGN KEY REFERENCES CONTAS(ID),
	DATAOPERACAO DATETIME,
	VALOROPERACAO DECIMAL(18,2),
	VALORFINAL DECIMAL(18,2),
	TIPO CHAR(1)
);

CREATE TABLE SAQUES
(
	ID INT PRIMARY KEY IDENTITY,
	CONTAID INT FOREIGN KEY REFERENCES CONTAS(ID),
	DATAOPERACAO DATETIME,
	VALOROPERACAO DECIMAL(18,2),
	VALORFINAL DECIMAL(18,2)
);

CREATE TABLE TRANSFERENCIAS
(
	ID INT PRIMARY KEY IDENTITY,
	CONTAID INT FOREIGN KEY REFERENCES CONTAS(ID),
	DATAOPERACAO DATETIME,
	VALOROPERACAO DECIMAL(18,2),
	VALORFINAL DECIMAL(18,2)
);

CREATE TABLE PAGAMENTOS
(
	ID INT PRIMARY KEY IDENTITY,
	CONTAID INT FOREIGN KEY REFERENCES CONTAS(ID),
	DESCRICAO VARCHAR(50),
	DATAOPERACAO DATETIME,
	VALOROPERACAO DECIMAL(18,2),
	VALORFINAL DECIMAL(18,2)
);

CREATE TABLE CEDULAS
(
	ID INT PRIMARY KEY IDENTITY,
	CEDULA VARCHAR(10),
	QUANTIDADE INT
);
