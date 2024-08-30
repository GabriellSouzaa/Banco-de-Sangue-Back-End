CREATE SEQUENCE paciente_id_seq;
CREATE TABLE paciente (
                          id_paciente INTEGER DEFAULT nextval('paciente_id_seq') PRIMARY KEY,
                          pessoa_id_pessoa INTEGER NOT NULL REFERENCES pessoa(id_pessoa),
                          tipo_sanguineo VARCHAR(10),
                          numero_prado_saude VARCHAR(20),
                          observacoes TEXT
);