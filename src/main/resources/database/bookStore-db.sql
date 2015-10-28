drop table if exists ORDERS_BOOK;
drop table if exists ORDERS;
drop table if exists CUSTOMER_SHIPPING;
drop table if exists SHIPPING_ADDRESS;
drop table if exists CUSTOMER;
drop table if exists BOOK_AUTHOR
drop table if exists ADMIN;
drop table if exists AUTHOR;
drop table if exists BOOK;
drop table if exists CATEGORY;

create table CATEGORY(category_id integer primary key identity, name varchar(45));

create table BOOK(book_id integer primary key identity, title varchar(45), year integer, publisher varchar(45), category_id integer, price float, quantity integer, description varchar(400), foreign key(category_id) references CATEGORY(category_id));

create table AUTHOR(authorId integer primary key identity, name varchar(45));

create table ADMIN(userId varchar(10) primary key, password varchar(45));

create table BOOK_AUTHOR(book_id integer, authorId integer, primary key(book_id,authorId),foreign key(book_id) references BOOK(book_id),foreign key(authorId) references AUTHOR(authorId));

create table CUSTOMER(customerId varchar(15) primary key, password varchar(45), name varchar(45), last_name varchar(45),email varchar(45),phone varchar(15));

create table SHIPPING_ADDRESS(shipping_addressId integer primary key identity, address_line_1 varchar(45),address_line_2 varchar(45),city varchar(20),state varchar(20),zip integer,country varchar(25));

create table CUSTOMER_SHIPPING(customerId varchar(15), shipping_addressId integer, primary key(customerId, shipping_addressId), foreign key(customerId) references CUSTOMER(customerId), foreign key(shipping_addressId) references SHIPPING_ADDRESS(shipping_addressId));

create table ORDERS(orderId integer primary key identity, order_date date, total float, customerId varchar(15), foreign key(customerId) references CUSTOMER(customerId));

create table ORDERS_BOOK(orderId integer, book_id integer, quantity integer, amount float, primary key(orderId, book_id), foreign key(orderId) references ORDERS(orderId), foreign key(book_id) references BOOK(book_id));

insert into CATEGORY(name) values('Drama');
insert into CATEGORY(name) values('Science');
insert into CATEGORY(name) values('Education');
insert into CATEGORY(name) values('Techonolgy');
insert into CATEGORY(name) values('Fiction');
insert into BOOK(title, year, publisher, category_id, price, quantity, description) values ('Harry Potter', 1998, 'Scholastic', 4, 6.76, 20,'By J.K. Rowling');