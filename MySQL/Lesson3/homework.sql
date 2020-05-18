USE library;

#витягнути всі книжки
SELECT * FROM book;

#обновити прізвище автора в 2х книжках
UPDATE book SET authorLastName = 'Мурата' WHERE id = 42;
UPDATE book SET authorLastName = 'Андрухович' WHERE id = 27;

#підрахувати кількість книжок, в яких автори мають нагороди
SELECT count(id) FROM book WHERE authorAwards IS NOT NULL;

#вивести інформацію про книжку з найменшою кількістю сторінок
SELECT * FROM book WHERE numberOfPages = (SELECT min(numberOfPages) FROM book);

#вивести максимальну кількість сторінок
SELECT max(numberOfPages) FROM book;

#вивести середню ціну між всіма книжками
SELECT avg(Price) FROM book;

#порахувати суму книжок за категорією
SELECT sum(Price) FROM book WHERE category = 'Нехудожня література';

#вивести мінімальну ціну книжки
SELECT min(Price) FROM book;

#вивести інформацію про книжку з найменшою ціною
SELECT * FROM book WHERE Price = (SELECT min(Price) FROM book);

#вивести книжки, де ціна матиме 4 знаки після коми, відсортовано за назвою книги
SELECT nameOfBook, numberOfPages, round(Price,4) AS price FROM book ORDER BY nameOfBook;

#вивести книжки за limit (5, 5), (10, 6) та відсортувати за датою публікації.
SELECT * FROM book ORDER BY dateOfPublication limit 5, 5 ;
SELECT * FROM book ORDER BY dateOfPublication limit 10, 6;

# написати 3 запити, використавши різні види пошуку за співпадіннями(like)
SELECT * FROM book WHERE authorFirstName LIKE 'Д%';
SELECT * FROM book WHERE nameOfBook LIKE '%від%';
SELECT * FROM book WHERE authorLastName LIKE '%ер';

#вивести книжки де ціна на проміжку: 1. 50-120, 2. не включаючи проміжок 200-600.
#1
SELECT * FROM book WHERE Price BETWEEN 50 AND 120;
#2
SELECT * FROM book WHERE Price NOT BETWEEN 200 AND 600;

#3 запити на видалення книжки(за id, name, isbn)
DELETE FROM book WHERE id = 26;
DELETE FROM book WHERE nameOfBook = 'Проект Розі';
DELETE FROM book WHERE isbn = '9789669421166';