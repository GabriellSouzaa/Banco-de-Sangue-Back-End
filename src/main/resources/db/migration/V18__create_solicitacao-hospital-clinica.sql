CREATE TABLE solicitacao_hospital_clinica (
                                              id_solicitacao INTEGER REFERENCES solicitacao(id_solicitacao),
                                              hospital_clinica_id INTEGER REFERENCES hospital_clinica(id),
                                              data_solicitacao TIMESTAMP,
                                              tipo_sangue_solicitado VARCHAR(5),
                                              componente_sangue_solicitado VARCHAR(50),
                                              quantidade_solicitada INTEGER,
                                              data_de_necessidade DATE,
                                              status_solicitacao VARCHAR(15),
                                              observacao INTEGER,
                                              PRIMARY KEY (id_solicitacao, hospital_clinica_id)
);