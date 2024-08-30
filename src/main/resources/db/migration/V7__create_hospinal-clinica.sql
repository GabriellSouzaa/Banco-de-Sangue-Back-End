CREATE SEQUENCE hospital_clinica_id_seq;
CREATE TABLE hospital_clinica (
                                  id INTEGER DEFAULT nextval('hospital_clinica_id_seq') PRIMARY KEY,
                                  endereco_id_endereco INTEGER REFERENCES endereco(id_endereco),
                                  nome VARCHAR(120) NOT NULL,
                                  telefone VARCHAR(20),
                                  email VARCHAR(30)
);