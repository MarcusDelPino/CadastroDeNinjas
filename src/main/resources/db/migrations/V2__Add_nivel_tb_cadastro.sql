-- Migrations para add a coluna de NIVEL na tabela de cadastro


ALTER TABLE tb_cadastro
ADD COLUMN nivel VARCHAR(255);