CREATE SEQUENCE doacao_id_seq;
CREATE TABLE doacao (
                        id_doacao INTEGER
                            DEFAULT nextval('doacao_id_seq') PRIMARY KEY,
                        doador_id_doador INTEGER NOT NULL REFERENCES doador(id_doador),
                        data_doacao DATE NOT NULL,
                        tipo_doacao VARCHAR(10),
                        quantidade_coletada NUMERIC,
                        status_doacao VARCHAR(30),
                        observacao VARCHAR(30)
);