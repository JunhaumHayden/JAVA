CREATE DATABASE IF NOT EXISTS db_lava_jato;

USE db_lava_jato;

-- Tabela de marcas
CREATE TABLE IF NOT EXISTS marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE
    ) ENGINE=InnoDB;


-- Tabela de motor
CREATE TABLE IF NOT EXISTS motor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    potencia INT NOT NULL,
    tipo_combustivel ENUM('GASOLINA', 'ETANOL', 'FLEX', 'DIESEL', 'GNV', 'OUTRO') NOT NULL
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS modelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    id_marca INT NOT NULL,
    id_motor INT NOT NULL,
    categoria ENUM('PEQUENO', 'MEDIO', 'GRANDE', 'MOTO', 'PADRAO') NOT NULL,
    FOREIGN KEY (id_marca) REFERENCES marcas(id),
    FOREIGN KEY (id_motor) REFERENCES motor(id) ON DELETE CASCADE
    )ENGINE=InnoDB;

-- Tabela de cores
CREATE TABLE IF NOT EXISTS cores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE
    ) ENGINE=InnoDB;

-- Tabelas de clientes
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255)
    ) ENGINE=InnoDB;

-- tabela de veiculos
CREATE TABLE IF NOT EXISTS veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(20) NOT NULL,
    observacoes TEXT,
    id_cor INT NOT NULL,
    id_modelo INT NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cor) REFERENCES cor(id),
    FOREIGN KEY (id_modelo) REFERENCES modelo(id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
    ) ENGINE=InnoDB;

-- Inserçao de valores
-- Marcas
INSERT INTO marcas (nome) VALUES
                              ('Honda'),
                              ('Toyota'),
                              ('Nissan'),
                              ('Ford'),
                              ('Volks');
-- Motor
INSERT INTO motor (potencia, tipo_combustivel) VALUES (100, 'GASOLINA');
INSERT INTO motor (potencia, tipo_combustivel) VALUES (120, 'ETANOL');
INSERT INTO motor (potencia, tipo_combustivel) VALUES (140, 'FLEX');
INSERT INTO motor (potencia, tipo_combustivel) VALUES (180, 'DIESEL');
INSERT INTO motor (potencia, tipo_combustivel) VALUES (90, 'GNV');

-- Inserir dados na tabela modelo
INSERT INTO modelos (descricao, id_marca, id_motor, categoria)
VALUES ('GOL', 5, 1, 'PEQUENO');
INSERT INTO modelos (descricao, id_marca, id_motor, categoria)
VALUES ('CIVIC', 1, 3, 'MEDIO');
INSERT INTO modelos (descricao, id_marca, id_motor, categoria)
VALUES ('FRONTIER', 3, 4, 'GRANDE');

-- Cores
INSERT INTO cores (nome) VALUES
                             ('Azul'),
                             ('Preto'),
                             ('Vermelho'),
                             ('Prata'),
                             ('Branco');