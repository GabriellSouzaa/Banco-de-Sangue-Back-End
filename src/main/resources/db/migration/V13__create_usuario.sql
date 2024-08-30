CREATE SEQUENCE usuario_id_seq;
CREATE TABLE usuario (
                         id_usuario INTEGER DEFAULT nextval('usuario_id_seq') PRIMARY KEY,
                         login VARCHAR(50) NOT NULL,
                         senha VARCHAR(50) NOT NULL,
                         role VARCHAR(10)
);