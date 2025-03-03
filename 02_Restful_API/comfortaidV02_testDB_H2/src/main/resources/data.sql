-- -- Inserir dados na tabela Usuario
-- INSERT INTO cliente (nome, email, senha, telefone, cep, numero_endereco, complemento_endereco, cpf)
-- VALUES
--     ('Ana Amalia', 'ana@mail.com', 'senha1111', '(11) 99999-0001', '88111-111', '001', 'Apto 101', '11111111111'),
--     ('Bia Bernardes', 'Bia@mail.com', 'senha2222', '(21) 98888-0002', '88222-222', '002', 'Casa', '22222222222');
--
--
-- -- Inserir dados na tabela Profissional
-- INSERT INTO profissional (nome, email, senha, telefone, cep, numero_endereco, complemento_endereco, especialidade, registro_profissional)
-- VALUES
--     ('Dany Damaris', 'dany@mail.com', 'senha3333', '(31) 97777-0003', '88333-333', '003', 'Sala 3', 'Massoterapia', 'REG33333'),
--     ('Emy Esteves', 'emy@mail.com', 'senha4444', '(41) 96666-0004', '88333-444', '004', 'casa', 'Parteira', 'REG44444');;

-- Inserir dados na tabela Usuario
INSERT INTO usuario (nome, email, senha, telefone, cep, numero_endereco, complemento_endereco)
VALUES
    ('Ana Amalia', 'ana@mail.com', 'senha', '(11) 99999-0001', '88111-111', '001', 'Apto 101'),
    ('Bia Bernardes', 'Bia@mail.com', 'senha', '(21) 98888-0002', '88222-222', '002', 'Casa'),
    ('Dany Damaris', 'dany@mail.com', 'senha', '(31) 97777-0003', '88333-333', '003', 'Sala 3'),
    ('Emy Esteves', 'emy@mail.com', 'senha', '(41) 96666-0004', '88333-444', '004', 'casa');

-- Inserir dados na tabela Cliente
INSERT INTO cliente (id_usuario, cpf)
VALUES
    (1, '11111111111'),
    (2, '22222222222');

-- Inserir dados na tabela Profissional
INSERT INTO profissional (id_usuario, especialidade, registro_profissional)
VALUES
    (3, 'Massoterapia', 'REG33333'),
    (4, 'Parteira', 'REG44444');

-- Inserir dados na tabela Servico
INSERT INTO servico (nome, descricao, preco, duracao, situacao, profissional_id, data_disponivel)
VALUES
    ('Massagem Relaxante', 'Sessão de massagem para aliviar o estresse e tensões', 120.00, 60, 'ATIVO', 3, '2025-01-12'),
    ('Massagem Terapêutica', 'Sessão terapêutica para tratar dores específicas', 150.00, 90, 'INATIVO', 3, '2024-01-12'),
    ('Parto Humanizado', 'Acompanhamento do parto com respeito e cuidado', 2000.00, 180, 'ATIVO', 4, '2024-02-22'),
    ('Acolhimento Primeiros Dias', 'Acompanhamento dos primeiros dias em sua jornada nesse maravilhoso universo da maternidade.', 300.00, 180, 'ATIVO', 4, '2024-02-22'),
    ('Massagem Relaxante', 'Sessão de massagem para aliviar o estresse e tensões', 120.00, 60, 'ATIVO', 3,'2025-01-12');

-- Inserir dados na tabela Agendamento
INSERT INTO agendamento (cliente_id, servico_id, data_hora)
VALUES
    (1, 1, '2024-01-12 10:00:00'),
    (2, 2, '2024-01-13 14:00:00'),
    (1, 3, '2024-01-14 09:00:00'),
    (2, 1, '2024-01-15 11:00:00');

-- Inserir dados na tabela Avaliação
INSERT INTO avaliacao (cliente_id, servico_id, data_hora, comentario, nota)
VALUES
    (1, 1, '2024-01-12 10:00:00', 'Ótimo serviço, muito profissional!', 5),
    (2, 2, '2024-01-13 14:00:00', 'Bom atendimento, mas atrasou um pouco.', 4),
    (1, 3, '2024-01-14 09:00:00','Atendimento excelente, recomendo!', 5 ),
    (2, 1, '2024-01-15 11:00:00', 'Não gostei muito, esperava algo melhor.', 2);

INSERT INTO login (id_usuario, login, senha)
VALUES
    (1,'ana@mail.com', 'senha1111'),
    (2,'Bia@mail.com', 'senha2222'),
    (3,'dany@mail.com', 'senha3333'),
    (4,'emy@mail.com', 'senha4444');



