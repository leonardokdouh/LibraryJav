
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
SELECT books.name, cargoes.id FROM books
INNER JOIN cargoes ON books.cargoesId = cargoes.id


SELECT * FROM ordersDetails LEFT JOIN payMethod
ON payMethod.id=ordersDetails.payMethodid;

SELECT * FROM ordersDetails LEFT JOIN payMethod
ON payMethod.id=1;

SELECT * FROM ordersDetails RIGHT JOIN orders ON orders.id=1;

SELECT * FROM ordersDetails RIGHT JOIN orders ON orders.customersId>1;

SELECT ordersDetails.id, orders.customersId FROM ordersDetails RIGHT JOIN orders ON orders.customersId>1;




