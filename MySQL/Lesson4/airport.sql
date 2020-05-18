CREATE DATABASE Airport;
USE Airport;
CREATE TABLE Airport_City
(
	Назва VARCHAR(50) UNIQUE PRIMARY KEY,
    Місце_Розташування VARCHAR(40),
    Кількість_Смуг INT,
    Кількість_Терміналів INT
);
CREATE TABLE Crew
(
    Код_Персоналу VARCHAR(30) ,
    Код_Рейсу VARCHAR(25),
    Дата DATE,
    Код_Персонал_Рейс INTEGER AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE Company
(
    ID_Компанії VARCHAR(25) PRIMARY KEY UNIQUE,
    Назва_Компанії VARCHAR(50),
    Кількість_Літаків INT
);
CREATE TABLE Plane
(
    Номер_Літака VARCHAR(35) PRIMARY KEY UNIQUE,
    Дата_Випуску DATE,
    Кількість_Пасажирів INT,
    Кількість_Персоналу INT,
    Назва VARCHAR(40)
);
CREATE TABLE Airplane_Flight
(
    Код_Рейсу VARCHAR(25),
    Номер_Літака VARCHAR(30),
    Дата DATE,
    Код_Рейс_Літак INTEGER AUTO_INCREMENT PRIMARY KEY
);
create table Personnel
(
	Досвід_Роботи INT,
    Імя VARCHAR(25),
    Посада VARCHAR(25),
    Прізвище VARCHAR(25),
    Код_Рейсу VARCHAR(30) ,
    Код_Персоналу VARCHAR(30) PRIMARY KEY UNIQUE
);
create table Ticket_Sales
(
    Код_Продажу VARCHAR(25) PRIMARY KEY,
    Код_Рейсу VARCHAR(25),
    Дата DATE,
    Прізвище VARCHAR(30) ,
    Імя VARCHAR(30),
    Ціна INT
);
create table Flight
(
	Місце_Вильоту VARCHAR(50),
	Місце_Посадки VARCHAR(50),
    Код_Рейсу VARCHAR(25) PRIMARY KEY UNIQUE,
    ID_Компанії VARCHAR(30)
);

ALTER TABLE Crew ADD FOREIGN KEY(Код_Рейсу) REFERENCES Flight (Код_Рейсу);
ALTER TABLE Crew ADD FOREIGN KEY(Код_Персоналу) REFERENCES Personnel (Код_Персоналу);
ALTER TABLE Flight ADD FOREIGN KEY(ID_Компанії) REFERENCES Company (ID_Компанії);
ALTER TABLE Flight ADD FOREIGN KEY(Місце_Вильоту) REFERENCES Airport_City (Назва);
ALTER TABLE Flight ADD FOREIGN KEY(Місце_Посадки) REFERENCES Airport_City (Назва);
ALTER TABLE Airplane_Flight ADD FOREIGN KEY(Номер_Літака) REFERENCES Plane (Номер_Літака);
ALTER TABLE Airplane_Flight ADD FOREIGN KEY(Код_Рейсу) REFERENCES Flight (Код_Рейсу);
ALTER TABLE Ticket_Sales ADD FOREIGN KEY(Код_Рейсу) REFERENCES Flight (Код_Рейсу);

