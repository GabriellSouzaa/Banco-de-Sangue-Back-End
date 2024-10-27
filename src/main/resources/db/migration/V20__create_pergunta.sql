CREATE SEQUENCE pergunta_id_seq;
CREATE TYPE tipo_pergunta AS ENUM ('MULTIPLA_ESCOLHA', 'DISSERTATIVA');

CREATE TABLE pergunta (
                          id INTEGER DEFAULT nextval('pergunta_id_seq') PRIMARY KEY,
                          questionario_id INTEGER NOT NULL,
                          texto VARCHAR(255) NOT NULL,
                          resposta_obrigatoria BOOLEAN NOT NULL,
                          tipo tipo_pergunta NOT NULL,
                          FOREIGN KEY (questionario_id) REFERENCES questionario(id) ON DELETE CASCADE
);