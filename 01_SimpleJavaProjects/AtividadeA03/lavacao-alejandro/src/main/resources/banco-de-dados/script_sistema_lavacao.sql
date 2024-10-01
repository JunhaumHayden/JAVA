/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Sentinel
 * Created: 1 de set. de 2024
 */
CREATE DATABASE IF NOT EXISTS db_lavacao4;
USE db_lavacao4;

CREATE TABLE marca(
   id int NOT NULL auto_increment,
   nome  varchar(50) NOT NULL,
   CONSTRAINT pk_marca
      PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE cor(
   id int NOT NULL auto_increment,
   nome varchar(50) NOT NULL,
   CONSTRAINT pk_cor
	PRIMARY KEY(id)
)engine = InnoDB;

CREATE TABLE servico(
   id int NOT NULL auto_increment,
   descricao varchar(50) NOT NULL,
   valor decimal(10,2) NOT NULL,
   pontos int  NOT NULL,
   CONSTRAINT pk_servico
   PRIMARY KEY(id)
)engine = InnoDB;

CREATE TABLE modelo ( 
id INT NOT NULL AUTO_INCREMENT, 
descricao VARCHAR(50) NOT NULL, 
id_marca INT NOT NULL, 
CONSTRAINT pk_modelo PRIMARY KEY(id), 
CONSTRAINT fk_modelo_marca FOREIGN KEY (id_marca) REFERENCES marca(id)
 ) ENGINE = InnoDB;
    
CREATE TABLE Cliente ( 
 id INT AUTO_INCREMENT,
 nome VARCHAR(100) NOT NULL, 
 celular VARCHAR(20), 
 email VARCHAR(100), 
 data_cadastro DATE, 
 pontuacao INT, 
 CONSTRAINT pk_cliente PRIMARY KEY (id)
) ENGINE = InnoDB; 
 
CREATE TABLE ClientePessoaFisica ( 
 id INT PRIMARY KEY, 
 cpf VARCHAR(14) NOT NULL, 
 data_nascimento DATE, 
 FOREIGN KEY (id) REFERENCES Cliente(id) 
) ENGINE = InnoDB;  
 
CREATE TABLE ClientePessoaJuridica ( 
 id INT PRIMARY KEY, 
 cnpj VARCHAR(18) NOT NULL, 
 inscricao_estadual VARCHAR(20), 
 FOREIGN KEY (id) REFERENCES Cliente(id) 
) ENGINE = InnoDB;
 
CREATE TABLE Veiculo ( 
 id INT PRIMARY KEY AUTO_INCREMENT,
 placa VARCHAR(50) NOT NULL,
 observacoes VARCHAR(50),
 id_modelo INT NOT NULL,
 id_cor INT NOT NULL,
 id_cliente INT NOT NULL,
 FOREIGN KEY (id_modelo) REFERENCES modelo(id),
 FOREIGN KEY (id_cor) REFERENCES cor(id),
 FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
) ENGINE = InnoDB;

CREATE TABLE ordem_servico (
   id INT NOT NULL AUTO_INCREMENT,
   data DATE NOT NULL,
   status ENUM('ABERTA', 'FECHADA', 'CANCELADA') NOT NULL,
   id_veiculo INT NOT NULL,
   id_servico INT NOT NULL,
   valor_total DECIMAL(10,2) NOT NULL,
   CONSTRAINT pk_ordem_servico PRIMARY KEY(id),
   CONSTRAINT fk_ordem_servico_veiculo FOREIGN KEY (id_veiculo) REFERENCES veiculo(id),
   CONSTRAINT fk_ordem_servico_servico FOREIGN KEY (id_servico) REFERENCES servico(id)
) ENGINE = InnoDB;

INSERT INTO marca(nome) VALUES('Toyota');
INSERT INTO marca(nome) VALUES('Ford');
INSERT INTO marca(nome) VALUES('Chevrolet');


INSERT INTO cor(nome) VALUES('vermelho');
INSERT INTO cor(nome) VALUES('azul');
INSERT INTO cor(nome) VALUES('preto');

INSERT INTO servico(descricao, valor, pontos) VALUES('Lavacao completa', 50.00, 10);
INSERT INTO servico(descricao, valor, pontos) VALUES('Pintura', 100.00, 20);

INSERT INTO servico(descricao, valor, pontos) VALUES('Chapeação', 200.00, 10);

INSERT INTO modelo(descricao, id_marca) VALUES('Pickup',1);
INSERT INTO modelo(descricao, id_marca) VALUES('sedan',2);
INSERT INTO modelo(descricao, id_marca) VALUES('ratch',3);

INSERT INTO veiculo(placa, observacoes, id_modelo, id_cor, id_cliente) VALUES('abc123', 'Porta direita raspada',1,2,1);
INSERT INTO veiculo(placa, observacoes, id_modelo, id_cor, id_cliente) VALUES('def456', 'Não usar massa de polir', 2,1,2);
INSERT INTO veiculo(placa, observacoes, id_modelo, id_cor, id_cliente) VALUES('ghi', 'Banco rasgado',3,3,3);

INSERT INTO cliente (id, nome, celular, email, data_cadastro, pontuacao) VALUES (1, 'João Silva', '99988-9458', 'joao@email.com', CURDATE(), 10);
INSERT INTO cliente (id, nome, celular, email, data_cadastro, pontuacao) VALUES (2, 'Manu Vaz', '99921-5419', 'manu@email.com', CURDATE(), 10);
INSERT INTO cliente (id, nome, celular, email, data_cadastro, pontuacao) VALUES (3, 'Lili Perez', '99875-5412', 'lili@email.com', CURDATE(), 10);


