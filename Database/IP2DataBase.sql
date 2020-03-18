drop table if EXISTS usertable;
create table usertable (
userId int(3) not null auto_increment,
firstName VARCHAR(50) not null,
lastName VARCHAR(50) not null,
email VARCHAR(50) not null,
password varchar(50) not null,
admin bool default '0',
constraint usertable_pk PRIMARY KEY (userId));

alter table usertable add constraint user_uk1 unique (userId,email,password);

drop table if exists category;
create table category (
categoryId int(3) not null auto_increment,
categoryName varchar(50),
constraint categorytable_pk primary key (categoryId));

alter table category add constraint category_uk1 unique (categoryName);

drop table if exists questions;
create table questions(
questionId int(3) not null auto_increment,
questionDesc varchar(50) not null,
categoryId int(3),
constraint questiontable_pk primary key (questionId));

drop table if exists answers ;
create table answers (
answerId int(3 ) not null auto_increment,
answerdesc varchar(50) not null,
questionId int(3),
correct bool not null,
constraint answerstable_pk primary key (answerId));

drop table if exists scores;
create table scores (
scoreId int (3) not null auto_increment,
userId int(3),
scoreDate date,
score int(3),
constraint scorestable_pk primary key (scoreId));

drop table if exists userchoice;
create table userchoice(

userId int(3) not null,
questionId int(3) not null,
answerId int(3) not null
);

alter table userchoice add 
foreign key (userId) references usertable (userId);

alter table userchoice add 
foreign key (questionId) references questions (questionId);

alter table userchoice add 
foreign key (answerId) references answers (answerId);

alter table questions add 
foreign key (categoryId) references category (categoryId);

alter table answers add 
foreign key (questionId) references questions (questionId);

alter table scores add 
foreign key (userId) references usertable (userId);














