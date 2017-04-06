-- ISTE 500 Database Development Main Script
-- Written by Matthew Reed
-- Friday, February 3rd, 2017

drop database if exists cat_main;

create database cat_main;
use cat_main;

-- Department
create table DEPARTMENT(
	Department_ID int PRIMARY KEY,
	Department_Name varchar(20), -- field "name" in ERD
	Department_Description varchar(150)-- field "description" in ERD
);

-- Program
create table PROGRAM(
	Program_ID int PRIMARY KEY,
	Department_ID int,
	Program_Name varchar(55),
	Program_Description varchar(500), -- changed from varchar(100)
	Program_Outcome varchar(500),
	Program_Recommendations varchar(500),
	Program_Reflections varchar(500),
	Program_Deadline datetime,
	Program_Submitted int,
	Program_Confirmed int,
	FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)
);

-- Course
create table COURSE(
	Course_ID int PRIMARY KEY,
	Course_Name varchar(25),
	Course_Description varchar(500),
	Couse_Outcome varchar(50),
	Course_Instrument varchar(150),
	Course_Benchmark float,
	Start_Date datetime,
	End_Date datetime,
	Course_Deadline datetime,
	Course_Submitted int,
	Course_Confirmed int,
	Program_ID int,
        term char(4),
	FOREIGN KEY (Program_ID) REFERENCES PROGRAM(Program_ID)
);

-- Section
create table SECTION(
	Section_ID int PRIMARY KEY,
	Course_ID int,
	Section_Number char(2),
	Start_Time time,
	End_Time time,
	Day_of_Week varchar(10),
	Section_Submitted int, -- assuming 0 is no, 1 is yes
	FOREIGN KEY (Course_ID) REFERENCES COURSE(Course_ID)
);

-- ROLES
create table ROLES(
	Role_ID int PRIMARY KEY,
	Role_Name varchar(20),
	Role_Description varchar(150)
);

-- Users
create table USERS(
	Employee_ID int PRIMARY KEY,
	First_Name varchar(35),
	Last_Name varchar(30),
	Email varchar(25),
	Username varchar(25),
	Password varchar(256), -- this WILL be in SHA-2 format
	Role_ID int,
	FOREIGN KEY (Role_ID) REFERENCES ROLES(Role_ID)
);

-- User Section
create table USER_SECTION(
	Employee_ID int,
	Section_ID int,
	Is_Professor int, -- my guess as to why this is an int, is becuase 1 is yes and 0 is no?
	FOREIGN KEY (Employee_ID) REFERENCES Users(Employee_ID),
	FOREIGN KEY (Section_ID) REFERENCES Section(Section_ID)
);
