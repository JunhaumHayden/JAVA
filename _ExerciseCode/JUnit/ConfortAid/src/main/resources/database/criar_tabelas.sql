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

-- Inserindo usuários que são clientes
INSERT INTO USUARIOS (nome, email, senha, tipo) VALUES 
('Alice Silva', 'alice.silva@gmail.com', 'senha123', 'CLIENTE'),
('Bruno Pereira', 'bruno.pereira@gmail.com', 'senha123', 'CLIENTE'),
('Carlos Santos', 'carlos.santos@gmail.com', 'senha123', 'CLIENTE'),
('Daniela Oliveira', 'daniela.oliveira@gmail.com', 'senha123', 'CLIENTE'),
('Eduardo Souza', 'eduardo.souza@gmail.com', 'senha123', 'CLIENTE'),
('Fernanda Lima', 'fernanda.lima@gmail.com', 'senha123', 'CLIENTE'),
('Gustavo Rocha', 'gustavo.rocha@gmail.com', 'senha123', 'CLIENTE'),
('Helena Ramos', 'helena.ramos@gmail.com', 'senha123', 'CLIENTE'),
('Isabel Martins', 'isabel.martins@gmail.com', 'senha123', 'CLIENTE'),
('João Alves', 'joao.alves@gmail.com', 'senha123', 'CLIENTE');

-- Inserindo registros na tabela CLIENTES com referencia aos usuários
INSERT INTO CLIENTES (usuario_id, endereco, telefone) VALUES 
(1, 'Rua A, 123', '11987654321'),
(2, 'Rua B, 456', '11987654322'),
(3, 'Rua C, 789', '11987654323'),
(4, 'Rua D, 101', '11987654324'),
(5, 'Rua E, 202', '11987654325'),
(6, 'Rua F, 303', '11987654326'),
(7, 'Rua G, 404', '11987654327'),
(8, 'Rua H, 505', '11987654328'),
(9, 'Rua I, 606', '11987654329'),
(10, 'Rua J, 707', '11987654330');

-- Inserindo usuários que são profissionais
INSERT INTO USUARIOS (nome, email, senha, tipo) VALUES 
('Patrícia Lima', 'patricia.lima@gmail.com', 'senha123', 'PROFISSIONAL'),
('Rafael Costa', 'rafael.costa@gmail.com', 'senha123', 'PROFISSIONAL'),
('Simone Teixeira', 'simone.teixeira@gmail.com', 'senha123', 'PROFISSIONAL'),
('Thiago Almeida', 'thiago.almeida@gmail.com', 'senha123', 'PROFISSIONAL'),
('Vanessa Silva', 'vanessa.silva@gmail.com', 'senha123', 'PROFISSIONAL');

-- Inserindo registros na tabela PROFISSIONAIS com referência aos usuários
INSERT INTO PROFISSIONAIS (usuario_id, especialidade, avaliacao, total_atendimentos) VALUES 
(11, 'Massoterapia', 4.7, 120),
(12, 'Acupuntura', 4.8, 80),
(13, 'Reflexologia', 4.6, 100),
(14, 'Shiatsu', 4.9, 150),
(15, 'Estética Facial', 4.5, 90);

-- Inserindo alguns agendamentos de exemplo
INSERT INTO AGENDAMENTOS (cliente_id, profissional_id, data_hora, status) VALUES 
(1, 11, '2024-11-07 10:00:00', 'Confirmado'),
(2, 12, '2024-11-08 14:00:00', 'Pendente'),
(3, 13, '2024-11-09 16:30:00', 'Confirmado'),
(4, 14, '2024-11-10 09:00:00', 'Cancelado'),
(5, 15, '2024-11-11 11:00:00', 'Pendente'),
(6, 11, '2024-11-12 13:00:00', 'Reagendado'),
(7, 12, '2024-11-13 15:00:00', 'Confirmado'),
(8, 13, '2024-11-14 08:30:00', 'Confirmado'),
(9, 14, '2024-11-15 17:00:00', 'Pendente'),
(10, 15, '2024-11-16 10:00:00', 'Confirmado'),
(1, 14, '2024-11-17 12:00:00', 'Pendente'),
(3, 15, '2024-11-18 13:00:00', 'Confirmado');
