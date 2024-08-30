CREATE SEQUENCE pessoa_id_seq;
CREATE TABLE pessoa (
                        id_pessoa INTEGER DEFAULT nextval('pessoa_id_seq') PRIMARY KEY,
                        nome_completo VARCHAR(120) NOT NULL,
                        data_nascimento DATE NOT NULL,
                        genero VARCHAR(30),
                        email VARCHAR(50)
);