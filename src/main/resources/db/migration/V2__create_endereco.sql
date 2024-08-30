CREATE SEQUENCE endereco_id_seq;
CREATE TABLE endereco (
                          id_endereco INTEGER DEFAULT nextval('endereco_id_seq') PRIMARY KEY,
                          logradouro VARCHAR(120) NOT NULL,
                          numero VARCHAR(20) NOT NULL,
                          bairro VARCHAR(40) NOT NULL,
                          cidade VARCHAR(50) NOT NULL,
                          estado VARCHAR(30) NOT NULL,
                          cep VARCHAR(15) NOT NULL
);