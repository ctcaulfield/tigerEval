-- ISTE 500 Database Development Main Script
-- Written by Matthew Reed
-- Friday, February 3rd, 2017

drop database if exists cat_main;

create database cat_main;
use cat_main;

-- ROLES
create table ROLES(
Role_ID int,
Role_Name varchar(20),
Role_Description varchar(150)
PRIMARY KEY (Role_ID)
);

-- Users
create table USERS(
Employee_ID int,
First_Name varchar(35),
Last_Name varchar(30),
Email varchar(25),
Username varchar(25),
Password varchar(256), -- this WILL be in SHA-2 format
Role_ID int,
PRIMARY KEY (Employee_ID),
FOREIGN KEY (Role_ID) REFERENCES ROLES(Role_ID)
);

-- User Section
create table USER_SECTION(
Employee_ID int,
Section_ID int,
Is_Professor int, -- my guess as to why this is an int, is becuase 1 is yes and 0 is no?
);

-- Section


