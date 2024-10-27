CREATE SEQUENCE resposta_id_seq;


CREATE TABLE resposta (
                          id INTEGER DEFAULT nextval('resposta_id_seq') PRIMARY KEY,
                          doador_id INTEGER NOT NULL,
                          pergunta_id INTEGER NOT NULL,
                          resposta TEXT,
                          opcao_id BIGINT,
                          FOREIGN KEY (doador_id) REFERENCES doador(id_doador) ON DELETE CASCADE,
                          FOREIGN KEY (pergunta_id) REFERENCES pergunta(id) ON DELETE CASCADE,
                          FOREIGN KEY (opcao_id) REFERENCES opcao_pergunta(id) ON DELETE SET NULL
);