USE library;

CREATE TABLE author(
    author_first_name VARCHAR(45) NOT NULL,
	author_last_name VARCHAR(45) NOT NULL,
	author_email VARCHAR(50) UNIQUE NOT NULL PRIMARY KEY,
	author_address VARCHAR(50),
	authorDateOfBirthday DATE NOT NULL
);

CREATE TABLE category(
	category_name VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY
);

INSERT INTO library.author(author_first_name, author_last_name, author_email, author_address, authorDateOfBirthday) VALUES
('Ювал Ной', 'Харарі', 'harari@gmail.com', NULL, '1976-02-24'),
('Софія', 'Андрухович', 'sofia@gmail.com', 'Україна', '1982-11-17'),
('Деніел', 'Ґоулман', 'deniel@gmail.com', NULL, '1946-03-07'),
('Джордж', 'Орвелл', 'orvel@gmail.com', NULL, '1903-06-25'),
('Меґан', 'МакДоналд', 'megan@gmail.com', NULL, '1959-02-28'),
('Галина', 'Вдовиченко', 'galia@gmail.com', 'Україна', '1959-06-21'),
('Джон', 'Стрелекі', 'john@gmail.com', 'Америка', '1969-09-13'),
('Розі', 'Волш', 'rousi@gmail.com', NULL, '1943-09-10'),
('Розанна', 'Каспер', 'rous@gmail.com', 'Америка', '1980-09-10'),
('Марк', 'Менсон', 'mark@gmail.com', NULL, '1984-03-09'),
('Гел', 'Елрод', 'gel@gmail.com', NULL, '1979-05-30'),
('Люсі', 'Ґутьєррес', 'lusi@gmail.com', NULL, '1974-09-10'),
('Мішель', 'Обама', 'obama@gmail.com', 'Америка', '1964-01-17'),
('Пол', 'Гелліко', 'pol@gmail.com', NULL, '1897-07-26'),
('Саяка', 'Мурата', 'murata@gmail.com', 'Японія', '1979-08-14'),
('Марк', 'Лівін', 'livin@gmail.com', NULL, '1988-01-14'),
('Том', 'Флетчер', 'tom_f@gmail.com', NULL, '1985-07-17'),
('Кім', 'Слейтер', 'kim_s@gmail.com', NULL, '1980-09-10'),
('Медлін', 'Міллер', 'miller_m@gmail.com', 'Америка', '1978-07-24'),
('Люко', 'Дашвар', 'luko@ukr.net', 'Україна', '1957-10-03'),
('Андрій', 'Валамов', 'andrew_v@ukr.net', 'Україна', '1954-04-25'),
('Пол', 'Остер', 'levi_m@gmail.com', NULL, '1986-02-24'),
('Ґрем', 'Сімсіон', 'grem@gmail.com', 'Нова Зеландія', '1956-12-27');

INSERT INTO library.category(category_name) VALUES
('Дитяча література'),
('Проза'),
('Підручники'),
('Роман'),
('Фентезі'),
('Нехудожня література');

ALTER TABLE library.book
  DROP COLUMN dateOfPublication,
  DROP COLUMN numberOfPages,
  DROP COLUMN authorFirstName,
  DROP COLUMN authorLastName,
  DROP COLUMN authorAge,
  DROP COLUMN authorDateOfBirthday,
  DROP COLUMN authorAwards;
  
ALTER TABLE library.book  ADD FOREIGN KEY  (category) REFERENCES  library.category(category_name);
ALTER TABLE library.book  ADD FOREIGN KEY  (authorEmail) REFERENCES  library.author(author_email);

