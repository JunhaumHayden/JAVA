-- Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS db_comfortaid;
USE db_comfortaid;

-- Tabela USUARIOS para armazenar os dados de login e informações básicas
CREATE TABLE USUARIOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('CLIENTE', 'PROFISSIONAL') NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB;

-- Tabela CLIENTES para armazenar informações específicas dos clientes
CREATE TABLE CLIENTES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    FOREIGN KEY (usuario_id) REFERENCES USUARIOS(id) ON DELETE CASCADE
)engine=InnoDB;

-- Tabela PROFISSIONAIS para armazenar informações específicas dos profissionais
CREATE TABLE PROFISSIONAIS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    especialidade VARCHAR(100),
    avaliacao DECIMAL(2,1) DEFAULT 0,
    total_atendimentos INT DEFAULT 0,
    FOREIGN KEY (usuario_id) REFERENCES USUARIOS(id) ON DELETE CASCADE
)engine=InnoDB;

-- Tabela AGENDAMENTOS para armazenar informações de agendamentos entre clientes e profissionais
CREATE TABLE AGENDAMENTOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    profissional_id INT NOT NULL,
    data_hora DATETIME NOT NULL,
    status ENUM('Pendente', 'Confirmado', 'Cancelado', 'Reagendado') DEFAULT 'Pendente',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES CLIENTES(id) ON DELETE CASCADE,
    FOREIGN KEY (profissional_id) REFERENCES PROFISSIONAIS(id) ON DELETE CASCADE
)engine=InnoDB;
