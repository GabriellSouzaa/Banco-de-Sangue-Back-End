CREATE SEQUENCE insignia_id_seq;
CREATE TABLE insignia (
                          id_insigna INTEGER DEFAULT nextval('insignia_id_seq') PRIMARY KEY,
                          nome_insigna VARCHAR(40),
                          descricao TEXT,
                          imagem TEXT,
                          pontos_necessarios NUMERIC,
                          data_conquista DATE
);