UPDATE doador SET insignia_id_insigna = NULL;

ALTER TABLE doador DROP CONSTRAINT doador_insignia_id_insigna_fkey;

ALTER TABLE doador DROP COLUMN insignia_id_insigna;
