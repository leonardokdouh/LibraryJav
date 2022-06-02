
-- trying having with group by queries
SELECT books.id, books.name
FROM books
GROUP BY books.id, books.name
HAVING books.id>2;

SELECT shifts.id, shifts.turn, workers.name
FROM shifts, workers
GROUP BY workers.name, shifts.turn, shifts.id
HAVING shifts.id;

SELECT shifts.id, shifts.turn, workers.name
FROM shifts, workers
GROUP BY workers.name, shifts.turn, shifts.id
HAVING shifts.id<2;

SELECT shifts.turn, workers.name
FROM shifts, workers
GROUP BY workers.name, shifts.turn
HAVING turn = "Morning";

SELECT shifts.turn, workers.name
FROM shifts, workers
GROUP BY workers.name, shifts.turn
HAVING name = "Morty";

SELECT shifts.id, shifts.turn, workers.name
FROM shifts, workers
GROUP BY workers.name, shifts.turn, shifts.id
HAVING shifts.id<2;


-- INNER JOIN book's Names with id from cargoes.
SELECT books.name, cargoes.id
FROM books
INNER JOIN cargoes ON books.cargoesId = cargoes.id

