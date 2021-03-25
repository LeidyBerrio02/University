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

create table userUniversity(
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
desc userUniversity;
select * from userUniversity;
desc role;
select * from role;
desc user_has_subject;
select * from user_has_subject;

desc userUniversity;
insert into userUniversity values (1,456700,'Cristhen', 'James Bill','3208402029','Av 9c #d4','Cristhen@mail.com',25);
insert into userUniversity values (2,456312,'Jessica', 'Cameron Diaz','3219823377','Av Philadelphia 34c','JCameron@mail.com',20);
insert into userUniversity values (3,457624,'James', 'Wridel Jener','3140928821','Av Philadelphia 36d','JamesJener@mail.com',21);
insert into userUniversity values (4,230013,'Roberth Davinson', 'Huil','3167823411','Av Washinton 16a','RobertDH@mail.com',40);

insert into role values (1,'ROLE_ADMIN',3);
insert into role values (2,'ROLE_ADMIN',4);
insert into role values (3,'ROLE_USER',1);
insert into role values (4,'ROLE_USER',2);

desc user_has_subject;
select * from user_has_subject;

select * from subject;
select * from userUniversity;
insert into user_has_subject values(1,1);
insert into user_has_subject values(1,2);

desc user_has_subject;

select user_id_user,   r.role ,u.first_name as name , s.name as 'subject name'
from user_has_subject 
right join userUniversity u on u.id_user = user_id_user 
inner join subject s on s.id_subject = subject_id_subject
inner join role r on u.id_user = r.id_user;

select u.id_user as id ,first_name as nombre, r.role	as rol from userUniversity u inner join role r on u.id_user = r.id_user;

alter table user rename column DNI to username;
alter table user add column password varchar(225);

alter table user rename userUniversity;


select distinct role from role;

/*Encriptacion password
UPDATE `university`.`user` SET `password` = '$2a$10$9RK4HYyegV8kijLuSMHvq.eqNRZsaZ70wgMT12oHcTxLaVhxL9OJ.' WHERE (`id_user` = '1');
UPDATE `university`.`user` SET `password` = '$2a$10$papN4u.7HV4.c/NKn8FHueCMpwaSivaLqfXlZYd/m4kvYwusirOfy' WHERE (`id_user` = '2');
UPDATE `university`.`user` SET `password` = '$2a$10$m9W3nUc7p6qvQ9z1yytMROz0U6eIoGabhoV4cJzLLEZtw2IefzsUS' WHERE (`id_user` = '3');
UPDATE `university`.`user` SET `password` = '$2a$10$SFOmMxEzJWCRhlqaLtSMCOqiQYmqoR.S85MqmMZyQ/ufN.whcMykO' WHERE (`id_user` = '4');

*/