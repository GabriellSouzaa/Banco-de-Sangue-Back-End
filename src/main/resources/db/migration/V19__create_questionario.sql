CREATE SEQUENCE questionario_id_seq;

CREATE TABLE questionario(
  id INTEGER DEFAULT nextval('questionario_id_seq') PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT
);
