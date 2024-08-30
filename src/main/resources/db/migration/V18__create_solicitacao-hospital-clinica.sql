CREATE TABLE solicitacao_hospital_clinica (
                                              id_solicitacao INTEGER REFERENCES solicitacao(id_solicitacao),
                                              hospital_clinica_id INTEGER REFERENCES hospital_clinica(id),
                                              PRIMARY KEY (id_solicitacao, hospital_clinica_id)
);