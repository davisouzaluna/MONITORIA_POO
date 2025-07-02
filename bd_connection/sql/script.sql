create database prontuario;
use prontuario;

CREATE TABLE PACIENTES (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
);
