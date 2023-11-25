create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), 
dob varchar(20), gender varchar(20), email varchar(30), marital varchar(20), 
address varchar(50), city varchar(25),state varchar(20), pincode varchar(25));

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), 
income varchar(20), education varchar(20), occupation varchar(30), passport varchar(30), 
sin varchar(50), senior_citizen varchar(25),existing_account varchar(20));

create table signupthree(formno varchar(20), accounttype varchar(50), cardnumber varchar(30), 
pin varchar(20), facility varchar(100));

create table bank(pin varchar(20), date varchar(50), type varchar(20), amount varchar(20));

create table login(formno varchar(20), cardnumber varchar(50), pin varchar(20));

show tables;

select * from signuptwo;

select * from signup;

select * from signupthree;

select * from bank;

select * from login;
