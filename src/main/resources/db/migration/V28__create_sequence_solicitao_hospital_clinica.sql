ALTER TABLE solicitacao_hospital_clinica DROP CONSTRAINT solicitacao_hospital_clinica_pkey;

CREATE SEQUENCE solicitacao_hospital_clinica_id_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE solicitacao_hospital_clinica ADD COLUMN id INTEGER DEFAULT nextval('solicitacao_hospital_clinica_id_seq');

ALTER TABLE solicitacao_hospital_clinica ADD PRIMARY KEY (id);

SELECT setval('solicitacao_hospital_clinica_id_seq', COALESCE((SELECT MAX(id) FROM solicitacao_hospital_clinica), 1), false);
