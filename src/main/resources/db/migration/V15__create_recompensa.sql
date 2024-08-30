CREATE SEQUENCE recompensa_id_seq;
CREATE TABLE recompensa (
                            id_recompensa INTEGER DEFAULT nextval('recompensa_id_seq') PRIMARY KEY,
                            nome_recompensa VARCHAR(50),
                            descricao_recompensa VARCHAR(1000),
                            valor_em_pontos VARCHAR(30)
);