CREATE SEQUENCE opcao_pergunta_id_seq;

CREATE TABLE opcao_pergunta (
                                id INTEGER DEFAULT nextval('opcao_pergunta_id_seq')PRIMARY KEY,
                                pergunta_id INTEGER NOT NULL,
                                texto VARCHAR(255) NOT NULL,
                                FOREIGN KEY (pergunta_id) REFERENCES pergunta(id) ON DELETE CASCADE
);