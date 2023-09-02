create database lg;
use lg;
create table login(username varchar(255),password varchar(255));
create table product(prodId int,prodName varchar(255),minSellQuantity int,price int,quantity int);
insert into login values('admin','Admin@123');
select * from login; 	
select * from product;

