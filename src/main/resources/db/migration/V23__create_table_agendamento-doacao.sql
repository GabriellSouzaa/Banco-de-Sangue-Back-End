CREATE SEQUENCE agendamento_id_seq;

CREATE TABLE agendamento_doacao (
                                    id INTEGER DEFAULT nextval('agendamento_id_seq') PRIMARY KEY,
                                    doador_id INTEGER NOT NULL,
                                    data_hora_agendamento TIMESTAMP NOT NULL,
                                    status VARCHAR(100) NOT NULL,
                                    observacoes TEXT,
                                    cancelado BOOLEAN,
                                    FOREIGN KEY (doador_id) REFERENCES doador(id_doador) ON DELETE CASCADE
);
