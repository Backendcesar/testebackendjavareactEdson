-- Inserir pautas iniciais
INSERT INTO pauta (titulo, descricao, status, tempo_sessao, data_criacao) VALUES
('Implementação de Home Office', 'Discussão sobre a implementação de trabalho remoto na empresa', 'ABERTA', 5, CURRENT_TIMESTAMP),
('Aumento de Salário', 'Proposta de reajuste salarial para o próximo trimestre', 'ABERTA', 10, CURRENT_TIMESTAMP),
('Novo Plano de Saúde', 'Avaliação de novas opções de plano de saúde para os funcionários', 'ABERTA', 15, CURRENT_TIMESTAMP),
('Horário Flexível', 'Implementação de horário flexível de entrada e saída', 'ABERTA', 20, CURRENT_TIMESTAMP),
('Reforma do Espaço de Trabalho', 'Proposta de reforma e modernização do ambiente de trabalho', 'ABERTA', 30, CURRENT_TIMESTAMP);

-- Inserir alguns votos para teste
INSERT INTO voto (pauta_id, cpf, voto, data_voto) VALUES
(1, '12345678901', 'SIM', CURRENT_TIMESTAMP),
(1, '23456789012', 'NAO', CURRENT_TIMESTAMP),
(1, '34567890123', 'SIM', CURRENT_TIMESTAMP),
(2, '45678901234', 'SIM', CURRENT_TIMESTAMP),
(2, '56789012345', 'SIM', CURRENT_TIMESTAMP),
(3, '67890123456', 'NAO', CURRENT_TIMESTAMP),
(3, '78901234567', 'NAO', CURRENT_TIMESTAMP),
(4, '89012345678', 'SIM', CURRENT_TIMESTAMP),
(5, '90123456789', 'NAO', CURRENT_TIMESTAMP); 