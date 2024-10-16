CREATE SEQUENCE paciente_id_seq;
CREATE TABLE paciente (
                          id_paciente INTEGER DEFAULT nextval('paciente_id_seq') PRIMARY KEY,
                          pessoa_id_pessoa INTEGER NOT NULL REFERENCES pessoa(id_pessoa),
                          cpf VARCHAR(14) NOT NULL,
                          telefone VARCHAR(20),
                          tipo_sanguineo VARCHAR,
                          historico_medico TEXT,
                          numero_plano_saude VARCHAR,
                          observacoes TEXT
);