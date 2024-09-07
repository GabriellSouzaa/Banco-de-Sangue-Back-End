CREATE SEQUENCE solicitante_id_seq;
CREATE TABLE solicitante (
                             id_solicitante INTEGER DEFAULT nextval('solicitante_id_seq') PRIMARY KEY,
                             pessoa_id_pessoa INTEGER NOT NULL REFERENCES pessoa(id_pessoa)
);