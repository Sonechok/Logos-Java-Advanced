USE library;

ALTER TABLE `library`.`category` 
ADD COLUMN `id` INT NOT NULL AUTO_INCREMENT AFTER `category_name`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE;


ALTER TABLE library.book
  DROP COLUMN authorEmail;
  
CREATE TABLE book_author(
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    author_email VARCHAR(50)
);

ALTER TABLE library.book_author  ADD FOREIGN KEY  (book_id) REFERENCES  library.book(id);
ALTER TABLE library.book_author  ADD FOREIGN KEY  (author_email) REFERENCES  library.author(author_email);

INSERT INTO library.book_author(book_id, author_email) VALUES
(26, 'harari@gmail.com'),
(26, 'harari@gmail.com'),
(30, 'orvel@gmail.com'),
(34, 'orvel@gmail.com'),
(40, 'obama@gmail.com'),
(41, 'pol@gmail.com'),
(45, 'kim_s@gmail.com'),
(48, 'luko@ukr.net'),
(48, 'luko@ukr.net');


SELECT book.nameOfBook, book.description,
 author.author_first_name AS name, author.author_last_name AS surname 
 FROM author INNER JOIN (book  INNER JOIN book_author)
 ON author.author_email = book_author.author_email
 AND book.id = book_author.book_id;
 
 SELECT book.nameOfBook, book.description,
 author.author_first_name AS name, author.author_last_name AS surname, 
 category.category_name AS categoru
 FROM author LEFT JOIN (book_author INNER JOIN (book INNER JOIN category ))
 ON author.author_email = book_author.author_email
 AND book.id = book_author.book_id
 AND book.category = category.category_name;
 
 

