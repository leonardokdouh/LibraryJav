-- -----------------------------------------------------
-- INSERTION QUERIES
-- -----------------------------------------------------
INSERT INTO books VALUES (null,"Once upon a time","Hardcover",2);
INSERT INTO books VALUES (null, "My Friend", "Paperback",2);
INSERT INTO books VALUES (null, "Narnia 3", "Paperback",2);

INSERT INTO cargoes VALUES (null, "Portugal", 100, 400, "2022-05-05");

INSERT INTO lends VALUES (null, 10, "2022-10-10 11:12:11");

INSERT INTO users(`id`,`name`,`email`,`address`,`age`) VALUES (null, "Peter Grifin", "pet@gmail.com", "Road Island 123", 23);
INSERT INTO users VALUES (null, "Louis Grifin", "louis@gmail.com", "Road Island 123", 24);



--DELETING stuff

DELETE FROM cargoes WHERE id=5;
DELETE FROM users WHERE id=1;
DELETE FROM users WHERE name = "Morty";
DELETE FROM workers WHERE id= 2;
DELETE FROM workers WHERE name="Gloria";




