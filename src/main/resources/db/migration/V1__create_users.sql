CREATE TABLE if not exists users
(
  id       bigserial PRIMARY KEY,
  username VARCHAR,
  password VARCHAR
);


-- password = password
INSERT INTO users (ID, USERNAME, PASSWORD)
VALUES (1, 'usmanovbf@yandex.ru', '$2a$10$h7DZlXJUVHXsl.Uwl/03PORIM0KGZQEt13DXmrBijimTK52msBley');
-- password = password

INSERT INTO users (ID, USERNAME, PASSWORD)
VALUES (2, 'user@gmail.com', '$2a$10$h7DZlXJUVHXsl.Uwl/03PORIM0KGZQEt13DXmrBijimTK52msBley');