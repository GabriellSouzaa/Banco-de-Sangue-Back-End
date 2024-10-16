CREATE SEQUENCE funcionario_id_seq;
CREATE TABLE funcionario (
                             id_funcionario INTEGER DEFAULT nextval('funcionario_id_seq') PRIMARY KEY,
                             pessoa_id_pessoa INTEGER NOT NULL REFERENCES pessoa(id_pessoa),
                             endereco_id_endereco INTEGER REFERENCES endereco(id_endereco),
                             cpf VARCHAR(14) NOT NULL,
                             data_contratacao DATE NOT NULL,
                             cargo VARCHAR NOT NULL,
                             departamento VARCHAR NOT NULL,
                             salario NUMERIC NOT NULL,
                             numero_registro_profissional VARCHAR(30),
                             foto text
);