DROP table IF EXISTS todo;

CREATE TABLE todo (
id INTEGER NOT NULL AUTO_INCREMENT,
  title VARCHAR(20),
  status VARCHAR(20),
  details VARCHAR(100),
  PRIMARY KEY(id)
);

INSERT INTO todo(
	id, title, status, details
)
VALUES(
	1, "風呂掃除", "未着手", "サンプルです"
);
INSERT INTO todo(
	id, title, status, details
)
VALUES(
	2, "買い物", "未着手", "サンプルです"
);