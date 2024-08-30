CREATE SEQUENCE desafio_id_seq;
CREATE TABLE desafio (
                         id_desafio INTEGER DEFAULT nextval('desafio_id_seq') PRIMARY KEY,
                         nome_desafio VARCHAR(50),
                         criticos TEXT,
                         data_inicio DATE,
                         data_termino DATE
);