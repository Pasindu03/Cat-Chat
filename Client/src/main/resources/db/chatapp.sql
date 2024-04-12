drop database if exists ;
create database chatapp;
use chatapp;
create table login(
    userID varchar(20),
    username varchar(20),
    password varchar(100)
);