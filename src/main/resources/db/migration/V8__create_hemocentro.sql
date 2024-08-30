CREATE SEQUENCE hemocentro_id_seq;
CREATE TABLE hemocentro (
                            id_hemocentro INTEGER DEFAULT nextval('hemocentro_id_seq') PRIMARY KEY,
                            endereco_id_endereco INTEGER REFERENCES endereco(id_endereco),
                            nome_hemocentro VARCHAR(120) NOT NULL
);