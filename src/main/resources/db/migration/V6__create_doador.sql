CREATE SEQUENCE doador_id_seq;
CREATE TABLE doador (
                        id_doador INTEGER DEFAULT nextval('doador_id_seq') PRIMARY KEY,
                        pessoa_id_pessoa INTEGER NOT NULL REFERENCES pessoa(id_pessoa),
                        tipo_sanguineo VARCHAR(3),
                        data_registro DATE NOT NULL,
                        data_ultima_doacao DATE,
                        numero_doacoes INTEGER,
                        elegibilidade BOOLEAN,
                        notas_medicas TEXT,
                        saldo_bcoins INTEGER,
                        imagem TEXT,
                        insignia_id_insigna INTEGER REFERENCES insignia(id_insigna)
);