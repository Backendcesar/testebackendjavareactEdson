-- Inserindo pautas iniciais
INSERT INTO pauta (titulo, descricao, status, tempo_sessao, data_criacao) VALUES
('Implementação de Home Office', 'Discussão sobre a implementação do regime de trabalho remoto para todos os funcionários', 'ABERTA', 5, CURRENT_TIMESTAMP),
('Aumento de Salário', 'Proposta de reajuste salarial para o próximo ano', 'ABERTA', 3, CURRENT_TIMESTAMP),
('Novo Plano de Saúde', 'Avaliação de novas opções de plano de saúde para os colaboradores', 'FECHADA', 1, TIMESTAMPADD(MINUTE, -10, CURRENT_TIMESTAMP)),
('Reforma da Sede', 'Projeto de reforma da sede da empresa', 'ABERTA', 10, CURRENT_TIMESTAMP),
('Novo Horário de Trabalho', 'Proposta de alteração do horário de trabalho para 7h às 16h', 'ABERTA', 2, CURRENT_TIMESTAMP);

-- Inserindo alguns votos para teste
INSERT INTO voto (pauta_id, cpf, voto, data_voto) VALUES
(1, '12345678901', 'SIM', CURRENT_TIMESTAMP),
(1, '98765432109', 'NAO', CURRENT_TIMESTAMP),
(2, '12345678901', 'SIM', CURRENT_TIMESTAMP),
(3, '98765432109', 'NAO', CURRENT_TIMESTAMP); 