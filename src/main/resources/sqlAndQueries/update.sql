-- -----------------------------------------------------
-- UPDATE QUERIES
-- -----------------------------------------------------

UPDATE workers SET name="Jasmine" WHERE id=2;
UPDATE workers SET gender="Male" WHERE id=2;
UPDATE workers SET shifts=3 WHERE id=2;

UPDATE users SET email="asdasd@gmail.com" WHERE id=2;
UPDATE users SET name="Jon Wik" WHERE id=2;
UPDATE users SET name="Jonatar", email= "jony@gmail.com" WHERE id=2;
UPDATE users SET name="Liliana", email= "liliana@gmail.com", age= 41
 WHERE id=2;

UPDATE users SET name="Lilis",age= 33 WHERE email= "liliana@gmail.com";

