
-- SELECTING stuff
-- select all from different table
SELECT * FROM books
SELECT * FROM booksForLend
SELECT * FROM cargoes
SELECT * FROM lends
SELECT * FROM orders
SELECT * FROM ordersDetails
SELECT * FROM shifts
SELECT * FROM users

-- select name from different tables
SELECT name FROM books
SELECT type FROM books
SELECT editorial FROM booksForLend
SELECT items FROM cargoes
SELECT name FROM workers
SELECT id FROM orders
SELECT * FROM ordersDetails
SELECT turns FROM shifts
SELECT email FROM users

-- select id and name from books table, but only whose id is greater than 3
SELECT  id, name FROM books WHERE id>3

-- finding a particular book using name column
SELECT  id, name FROM books WHERE name="Venom"

-- finding a particular book using id
SELECT  id, name FROM books WHERE id=4
