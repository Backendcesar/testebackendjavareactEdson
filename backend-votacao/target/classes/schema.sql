-- Criar tabela de usuários
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Criar tabela de pautas
CREATE TABLE IF NOT EXISTS pauta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(20) NOT NULL,
    tempo_sessao INT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_encerramento TIMESTAMP
);

-- Criar tabela de votos
CREATE TABLE IF NOT EXISTS voto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pauta_id BIGINT NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    voto VARCHAR(3) NOT NULL,
    data_voto TIMESTAMP NOT NULL,
    FOREIGN KEY (pauta_id) REFERENCES pauta(id)
);

-- Criar índices
CREATE INDEX IF NOT EXISTS idx_voto_cpf ON voto(cpf);
CREATE INDEX IF NOT EXISTS idx_voto_pauta_id ON voto(pauta_id);
CREATE INDEX IF NOT EXISTS idx_usuario_cpf ON usuario(cpf); 