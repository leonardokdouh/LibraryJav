-- -----------------------------------------------------
-- QUERIES TEST's
-- -----------------------------------------------------
INSERT INTO `mydb`.`books`
VALUES (null,"Once upon a time","Hardcover",2);

INSERT INTO `mydb`.`cargoes`
(`id`,`country`,`items`,`weight`,`date`)
VALUES (null, "Portugal", 100, 400, "2022-05-05");



-- SELECTING stuff
-- select all from books table
SELECT *
from books

-- select name from books table
SELECT name
FROM books

-- select id and name from books table, but only whose id is greater than 3
SELECT  id, name
FROM books
WHERE id>3

-- finding a particular book using name column
SELECT  id, name
FROM books
WHERE name="Venom"

-- finding a particular book using id
SELECT  id, name
FROM books
WHERE id=4


--DELETING stuff

DELETE FROM `mydb`.`cargoes`
WHERE id=5;

DELETE FROM users WHERE id=1;
DELETE FROM users WHERE name = "Morty";


