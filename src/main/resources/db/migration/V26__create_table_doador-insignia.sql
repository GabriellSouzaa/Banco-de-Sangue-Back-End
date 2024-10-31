CREATE TABLE doador_insignia(
    doador_id INTEGER NOT NULL,
    insignia_id INTEGER NOT NULL,
    data_conquista DATE,
    PRIMARY KEY (doador_id, insignia_id),
    FOREIGN KEY (doador_id) REFERENCES doador(id_doador),
    FOREIGN KEY (insignia_id) REFERENCES insignia(id_insigna)
)