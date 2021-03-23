create database University;
use University;

/*drop database University;*/

create table teacher(
id_teacher int not null primary key auto_increment,
first_name varchar(225),
last_name varchar(225),
DNI varchar(45),
activo boolean
);

create table User(
id_user int not null primary key auto_increment,
DNI varchar(45),
first_name varchar(225),
last_name varchar(225),
number_phone varchar(45),
address varchar(225),
mail varchar(225),
age int
);

/*
username varchar(225),
password varchar(225)
*/

create table Role(
id_role int not null primary key auto_increment,
role varchar(225),
id_user int,
constraint fk_user foreign key (id_user) references User(id_user)
);

create table Subject(
id_subject int not null primary key auto_increment,
name varchar(225),
description varchar(1000),
schedule varchar(225),
id_teacher int,
quota_max_students int,
constraint fk_teacher foreign key (id_teacher) references teacher(id_teacher)
);

show tables;
desc teacher;
insert into teacher values (1,'Julieth','Jolie Manhathan','142029023',1);
insert into teacher values (2,'Oscar','Bermudez Roberts','4890023',1);
insert into teacher values (3,'Julio','Brows Santillana','19029023',0);
insert into teacher values (4,'Julio','Brows Santillana','19029023',0);


desc subject;
insert into subject values (1,'English','Here will you learn more english for your life, you are the best. ¡Successes!','Monday-Tuesday-Friday 08:00 am - 10:00pm',1,40);
insert into subject values (2,'Programaming','Here will you learn more Programaming for you laboral life, you are the best. ¡Successes!','Monday-Wednesday-Friday 10:00 am - 12:00pm',2,20);
insert into subject values (3,'Theory','You will shoulder know all about programming ¡Successes!','Monday-Tuesday-Wednesday-Thursday-Friday 12:00 am - 3:00pm',2,20);

desc teacher;
select * from teacher;
desc subject;
select * from subject;
desc user;
select * from user;
desc role;
select * from role;
desc user_has_subject;
select * from user_has_subject;

desc user;
insert into user values (1,456700,'Cristhen', 'James Bill','3208402029','Av 9c #d4','Cristhen@mail.com',25);
insert into user values (2,456312,'Jessica', 'Cameron Diaz','3219823377','Av Philadelphia 34c','JCameron@mail.com',20);
insert into user values (3,457624,'James', 'Wridel Jener','3140928821','Av Philadelphia 36d','JamesJener@mail.com',21);
insert into user values (4,230013,'Roberth Davinson', 'Huil','3167823411','Av Washinton 16a','RobertDH@mail.com',40);

insert into role values (1,'ROLE_',1);
insert into rol values (2,'ROLE_',2);

desc user_has_subject;
select * from user_has_subject;

select * from subject;
select * from user;
insert into user_has_subject values(1,1);
insert into user_has_subject values(1,2);

desc user_has_subject;
select user_id_user, u.first_name , s.name
from user_has_subject 
right join user u on u.id_user = user_id_user 
inner join subject s on s.id_subject = subject_id_subject;