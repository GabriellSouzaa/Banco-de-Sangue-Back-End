CREATE TABLE doador_has_recompensa (
                                       doador_id_doador INTEGER REFERENCES doador(id_doador),
                                       recompensa_id_recompensa INTEGER REFERENCES recompensa(id_recompensa),
                                       PRIMARY KEY (doador_id_doador, recompensa_id_recompensa)
)