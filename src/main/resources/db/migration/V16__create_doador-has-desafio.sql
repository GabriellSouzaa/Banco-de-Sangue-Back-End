CREATE TABLE doador_has_desafio (
                                    doador_id_doador INTEGER REFERENCES doador(id_doador),
                                    desafio_id_desafio INTEGER REFERENCES desafio(id_desafio),
                                    PRIMARY KEY (doador_id_doador, desafio_id_desafio)
);