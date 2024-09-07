CREATE SEQUENCE bolsa_de_sangue_id_seq;
CREATE TABLE bolsa_de_sangue (
                                 id_bolsa_de_sangue INTEGER DEFAULT nextval('bolsa_de_sangue_id_seq') PRIMARY KEY,
                                 doacao_id_doacao INTEGER REFERENCES doacao(id_doacao),
                                 tipo_sanguineo VARCHAR(40),
                                 componente_sanguineo VARCHAR(40),
                                 volume_bolsa VARCHAR(40),
                                 data_coleta DATE NOT NULL,
                                 data_validade DATE,
                                 status_bolsa VARCHAR(40),
                                 resultado_teste VARCHAR(40),
                                 numero_freezer VARCHAR(20),
                                 cod_lote VARCHAR(30),
                                 status_conformidade VARCHAR(20),
                                 notas TEXT,
                                 data_processamento TIMESTAMP
);