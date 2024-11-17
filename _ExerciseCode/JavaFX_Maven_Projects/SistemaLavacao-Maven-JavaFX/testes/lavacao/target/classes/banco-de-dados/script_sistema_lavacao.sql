-- Aluno: Carlos Benedito Hayden de Albuquerque Junior
-- Turma CTDS 2023-2
SHOW DATABASES;

CREATE DATABASE projetoFinal;
USE projetoFinal;



-- Item01: Criar as tabelas necessárias, com seus campos e chaves;
-- Item02: Criar os relacionamentos respeitando a cardinalidade apresentada;

-- Tabelas de clientes TRUE indica cliente PJ
CREATE TABLE IF NOT EXISTS Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    celular VARCHAR(20),
    email VARCHAR(255) NOT NULL,
    data_cadastro DATE,
    cnpj BOOLEAN NOT NULL,
    num_registro VARCHAR(50) NOT NULL,
    inscricao_estadual VARCHAR(50),
    data_nascimento DATE,
    pontuacao INT
) ENGINE=InnoDB;

-- tabelas de categorias
CREATE TABLE IF NOT EXISTS Categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- tabelas de cores de veiculos
CREATE TABLE IF NOT EXISTS Cores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cor VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- tabelas de servicos disponiveis
CREATE TABLE IF NOT EXISTS Servicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    pontos INT
) ENGINE=InnoDB;

-- tabelas com os status das ordens de servico
CREATE TABLE IF NOT EXISTS Status (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estado INT UNIQUE
) ENGINE=InnoDB;

-- Tabela de marcas 
CREATE TABLE IF NOT EXISTS Marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- tabela de modelos de veiculos
CREATE TABLE IF NOT EXISTS Modelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL UNIQUE,
    id_categoria INT,
    id_marca INT,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id),
    FOREIGN KEY (id_marca) REFERENCES Marcas(id)
) ENGINE=InnoDB;

-- tabela de veiculos
CREATE TABLE IF NOT EXISTS Veiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(20) NOT NULL,
    observacoes TEXT,
    id_cor INT NOT NULL,
    id_modelo INT NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cor) REFERENCES Cores(id),
    FOREIGN KEY (id_modelo) REFERENCES Modelos(id),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
) ENGINE=InnoDB;

-- tabela ordens de servico
CREATE TABLE IF NOT EXISTS Ordens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero BIGINT NOT NULL,
    total DECIMAL(10, 2),
    agenda DATE NOT NULL,
    desconto DECIMAL(10, 2),
    id_veiculo INT NOT NULL,
    id_status INT NOT NULL,
    FOREIGN KEY (id_veiculo) REFERENCES Veiculos(id),
    FOREIGN KEY (id_status) REFERENCES Status(id)
) ENGINE=InnoDB;


-- taberlas relaciona os servicos com as ordens de servicos
CREATE TABLE IF NOT EXISTS Servicos_Ordens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_ordem INT,
    id_servico INT,
    FOREIGN KEY (id_servico) REFERENCES Servicos(id),
    FOREIGN KEY (id_ordem) REFERENCES Ordens(id)
) ENGINE=InnoDB;

-- Item03: Inserir dados de exemplo nas tabelas;

-- Clientes com CPF (PF)
INSERT INTO Clientes (nome, celular, email, data_cadastro, cnpj, num_registro, inscricao_estadual, data_nascimento, pontuacao)
VALUES 
    ('Ana Amalia', '99999-1111', 'ana@mail.com', '2022-01-10', FALSE, '123.456.111-01', NULL, '1980-05-15', 0),
    ('Bia Bernardes', '99999-2222', 'bia@mail.com', '2022-02-20', FALSE, '987.654.222-02', NULL, '1990-07-20', 200);

-- Clientes com CNPJ (PJ)
INSERT INTO Clientes (nome, celular, email, data_cadastro, cnpj, num_registro, inscricao_estadual, data_nascimento, pontuacao)
VALUES 
    ('Empresa Zulu', '99999-9999', 'empresazulu@mail.com', '2022-03-30', TRUE, '12.345.678/0009-09', '1234999', NULL, 300),
    ('Empresa Xibiu', '99999-8888', 'empresxibiu@mail.com', '2022-04-15', TRUE, '87.654.321/0008-08', '7654888', NULL, 0);

-- Categorias
INSERT INTO Categorias (categoria) VALUES
    ('Pequeno'),
    ('Medio'),
    ('Grande');

-- Cores
INSERT INTO Cores (cor) VALUES
    ('Vermelho'),
    ('Verde'),
    ('Azul'),
    ('Prata'),
    ('Preto');

-- Serviços
INSERT INTO Servicos (descricao, valor, pontos) VALUES
    ('Aspiração', 50.00, 30),
    ('lavagem Externa', 40.00, 30),
    ('lavagem Motor', 40.00, 40),
    ('Cera Liquida', 25.00, 10),
    ('Cera Pastosa', 40.00, 30),
    ('Pretinho Pneu', 20.00, 10),
    ('Secagem', 15.00, 25);

   -- Marcas
INSERT INTO Marcas (nome) VALUES
    ('Honda'),
    ('Toyota'),
    ('Nissan'),
    ('Ford'),
    ('Volks');
   
-- Modelos
INSERT INTO Modelos (id_categoria, id_marca, descricao) VALUES
    (1, 1, 'City'),
    (2, 2, 'Corola'),
    (1, 4, 'ka'),
    (2, 5, 'Voyage'),
    (1, 5, 'Gol'),
    (3, 3, 'Frontier');

-- Veículos
INSERT INTO Veiculos (placa, observacoes, id_cor, id_modelo, id_cliente) VALUES
    ('ABC-1111', 'Observações ABC', 1, 1, 1),
    ('BCD-2002', 'Observações BCD 01', 4, 6, 2),
    ('BCD-2112', 'Observações BDC 02', 5, 1, 2),
    ('ZAB-9999', 'Observações ZAB 01', 4, 5, 3),
    ('ZAB-0099', 'Observações ZAB 02', 4, 4, 3),
    ('XYZ-8888', 'Observações XYZ', 2, 2, 4);

-- Status
-- 0 - Encerrado, 1 - Aberto, 2 - Agendado, 3 - Em Execucao, 4 - Paralisado, 5 - Finalizado 6 - Cancelado 
INSERT INTO Status (estado) VALUES
    (0),
    (1),
    (2),
    (3),
    (4),
    (5),
    (6);

-- Ordens de Serviço OBS: Entrou-se valor na coluna Total apenas para exemplificação
INSERT INTO Ordens (numero, total, agenda, desconto, id_veiculo, id_status) VALUES
    (1100000, 150.10, '2022-05-10', 10.00, 1, 1),
    (2200000, 200.20, '2022-05-15', 20.00, 2, 2),
    (3300000, 300.30, '2022-05-20', 30.00, 4, 4),
    (3300001, 200.40, '2022-05-20', 20.00, 5, 3),
    (4400000, 300.50, '2022-05-20', 30.00, 6, 5);

-- Serviços-Ordens
INSERT INTO Servicos_Ordens (id_ordem, id_servico) VALUES
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 5),
    (3, 1),
    (3, 2),
    (3, 4),
    (3, 5),
    (4, 2),
    (4, 7),
    (5, 1),
    (5, 2),
    (5, 3),
    (5, 4),
    (5, 5);
   
-- Item04: Criar consultas para os casos de uso:
   -- Listar todos os "Clientes";
   SELECT * FROM Clientes;
  
 -- OBS: Listar todos os "Clientes" apresentando se é PF ou PJ;
  
-- Criar a função para verificar o tipo de Cliente

CREATE FUNCTION fn_tipo_cliente (a BOOLEAN)
RETURNS VARCHAR(4)
DETERMINISTIC
    RETURN IF(a, 'PJ', 'PF');

-- Consulta utilizando a função
SELECT 
    id, 
    nome, 
    celular, 
    email, 
    data_cadastro, 
    fn_tipo_cliente(cnpj) AS tipo_documento,
    num_registro, 
    inscricao_estadual, 
    data_nascimento, 
    pontuacao 
FROM 
    Clientes;
   
   -- Consulta utilizando CASE
SELECT 
    id, 
    nome, 
    celular, 
    email, 
    data_cadastro, 
    CASE 
        WHEN cnpj = 1 THEN 'PJ' 
        ELSE 'PF' 
    END AS tipo_documento,
    num_registro, 
    inscricao_estadual, 
    data_nascimento, 
    pontuacao 
FROM 
    Clientes;


   -- Listar todos os "Veículos" incluindo seus "Modelos" e "Cores" e "Marcas":
  
  SELECT 
    v.id AS id_veiculo, 
    v.placa, 
    v.observacoes, 
    c.cor, 
    m.descricao AS modelo, 
    ma.nome AS marca
FROM 
    Veiculos v
		JOIN 
		    Modelos m 
		    	ON v.id_modelo = m.id
		JOIN 
		    Cores c 
		    	ON v.id_cor = c.id
		JOIN 
		    Marcas ma 
		   		ON m.id_marca = ma.id;
   	
-- Listar todas as placas dos "Veículos" juntamente com o nome do "Cliente" proprietário:

  SELECT
	v.placa AS Placa,
	cl.nome AS Proprietario
FROM
	Veiculos v 
		JOIN
			Clientes cl on id_cliente = cl.id;

-- Listar as "Ordens de Serviço" e todos os "Serviços" relacionados a cada ordem:

SELECT  
	o.id as ID_Ordem,
	o.numero,
	o.total,
	o.agenda,
	o.desconto,
	s.descricao,
	s.valor,
	s.pontos
FROM
	Ordens o 
		JOIN 
			Servicos_Ordens so 
				ON o.id = so.id_ordem 
		JOIN 
			Servicos s 
				ON so.id_servico = s.id ;
			
-- Listar as "Ordens de Serviço" e todos os "Serviços" relacionados a cada ordem 
-- OBS: apresentando o status das ordens:
			
-- função para mapear os valores do id_status para os seus respectivos estados.			
DELIMITER $$

CREATE FUNCTION fn_status_ordem(id_status INT) 
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE status VARCHAR(20);
    
    CASE id_status
        WHEN 0 THEN SET status = 'Encerrado';
        WHEN 1 THEN SET status = 'Aberto';
        WHEN 2 THEN SET status = 'Agendado';
        WHEN 3 THEN SET status = 'Em Execução';
        WHEN 4 THEN SET status = 'Paralisado';
        WHEN 5 THEN SET status = 'Finalizado';
        WHEN 6 THEN SET status = 'Cancelado';
        ELSE SET status = 'Desconhecido';
    END CASE;
    
    RETURN status;
END$$

DELIMITER ;

-- Listar o status das ordens:
SELECT  
    o.id as ID_Ordem,
    o.numero,
    status_ordem(o.id_status) as Status,
    o.total,
    o.agenda,
    o.desconto,
    s.descricao,
    s.valor,
    s.pontos
FROM
    Ordens o 
        JOIN 
            Servicos_Ordens so 
                ON o.id = so.id_ordem 
        JOIN 
            Servicos s 
                ON so.id_servico = s.id ;


	
-- Obter o valor total de cada "Ordem de Serviço" somando o valor de cada "Serviço" realizado:
	
SELECT 
 o.id AS ID_Ordem,
 o.numero,
 status_ordem(o.id_status) as Status,
 SUM(s.valor) AS Total_Servicos
FROM
	Ordens o 
		JOIN
			Servicos_Ordens so 
				ON o.id = so.id_ordem 
		JOIN 
			Servicos s 
				ON so.id_servico = s.id
GROUP BY 
	o.id,
	o.numero;


	






