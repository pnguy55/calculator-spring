DROP TABLE IF EXISTS equations;
CREATE TABLE equations(id serial PRIMARY KEY, equation VARCHAR(255), result VARCHAR(255));

INSERT INTO equations(equation, result) VALUES('', '');