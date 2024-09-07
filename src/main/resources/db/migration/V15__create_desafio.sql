CREATE SEQUENCE desafio_id_seq;
CREATE TABLE desafio (
                         id_desafio INTEGER DEFAULT nextval('desafio_id_seq') PRIMARY KEY,
                         recompensa_id_recompensa INTEGER UNIQUE REFERENCES recompensa(id_recompensa),
                         nome_desafio VARCHAR(50),
                         descricao TEXT,
                         criterios TEXT,
                         data_inicio DATE,
                         data_termino DATE

);