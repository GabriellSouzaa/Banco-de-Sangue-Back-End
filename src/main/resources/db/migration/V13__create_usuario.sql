CREATE SEQUENCE usuario_id_seq;
CREATE TABLE usuario (
                         id INTEGER DEFAULT nextval('usuario_id_seq') PRIMARY KEY,
                         login VARCHAR NOT NULL,
                         password VARCHAR NOT NULL,
                         role VARCHAR
);