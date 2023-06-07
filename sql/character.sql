DROP TABLE IF EXISTS anime;

CREATE TABLE anime (
  id int unsigned AUTO_INCREMENT,
  characterName VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO anime (id, characterName) VALUES (1,'アーニャ');
INSERT INTO anime (id, characterName) VALUES (2,'錦木千束');
INSERT INTO anime (id, characterName) VALUES (3,'マーム');