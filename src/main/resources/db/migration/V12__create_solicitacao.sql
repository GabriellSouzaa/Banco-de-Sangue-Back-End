CREATE SEQUENCE solicitacao_id_seq;
CREATE TABLE solicitacao (
                             id_solicitacao INTEGER DEFAULT nextval('solicitacao_id_seq') PRIMARY KEY,
                             paciente_id_paciente INTEGER REFERENCES paciente(id_paciente),
                             solicitante_id_solicitante INTEGER REFERENCES solicitante(id_solicitante),
                             funcionario_id_funcionario INTEGER REFERENCES funcionario(id_funcionario),
                             data_solicitacao TIMESTAMP NOT NULL,
                             tipo_solicitado VARCHAR,
                             componente_solicitado VARCHAR(30),
                             quantidade_solicitada NUMERIC,
                             data_necessidade DATE,
                             data_atendimento TIMESTAMP
);