create database coding_city;

use coding_city;

create table courses(
		id int not null primary key auto_increment,
        name varchar(75) not null unique,
        description TEXT not null,
        price decimal(10,2) not null
        );


create table users(
	id int not null primary key auto_increment,
    email varchar(75) not null unique,
    first_name varchar(75) not null,
    last_name varchar(100) not null,
    password varchar(30) not null,
    role varchar(50) not null,
    course_id int,
    money decimal(10,2) default 0,
    foreign key (course_id) references courses(id)
    );
    
create table tasks(
	id int not null primary key,
    programing_language int not null,
    number_of_day int not null,
    task text not null,
    links varchar(100),
    is_done boolean not null,
    foreign key(programing_language) references courses(id)
);

