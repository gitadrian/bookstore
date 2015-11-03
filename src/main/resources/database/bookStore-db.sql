drop table if exists ORDERS_BOOK;
drop table if exists ORDERS;
drop table if exists authorities;
drop table if exists users;
drop table if exists BOOK;
drop table if exists CATEGORY;

create table CATEGORY(category_id integer primary key identity, name varchar(45));

create table BOOK(book_id integer primary key identity, title varchar(45), year integer, publisher varchar(45), category_id integer, price float, quantity integer, description varchar(400), foreign key(category_id) references CATEGORY(category_id));


create table users(username varchar(10) primary key, password varchar(45), enabled boolean);

insert into users(username,password,enabled) values ('admin','123',true);
insert into users(username,password,enabled) values ('user','123',true);

create table authorities(username varchar(10), authority varchar(15));

insert into authorities(username, authority) values('admin','ROLE_ADMIN');
insert into authorities(username, authority) values('admin','ROLE_USER');
insert into authorities(username, authority) values('user','ROLE_USER');


create table ORDERS(orderId integer primary key identity, total float, username varchar(10), foreign key(username) references users(username));

create table ORDERS_BOOK(orderId integer, book_id integer, quantity integer, amount float, primary key(orderId, book_id), foreign key(orderId) references ORDERS(orderId), foreign key(book_id) references BOOK(book_id));

insert into CATEGORY(name) values('Drama');
insert into CATEGORY(name) values('Science');
insert into CATEGORY(name) values('Education');
insert into CATEGORY(name) values('Techonolgy');
insert into CATEGORY(name) values('Fiction');
insert into CATEGORY(name) values('Novel');

insert into BOOK(title, year, publisher, category_id, price, quantity, description) values ('Harry Potter', 1998, 'Scholastic', 4, 6.76, 20,'By J.K. Rowling');
