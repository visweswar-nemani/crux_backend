CREATE SCHEMA IF NOT EXISTS BANKING;

USE BANKING;

DROP TABLE IF EXISTS SignupInfo;

CREATE TABLE SignupInfo(

	id int(30) PRIMARY KEY auto_increment,
	firstName varchar(250) NOT NULL,
	lastName varchar(250) NOT NULL,
	email varchar(250) NOT NULL UNIQUE,
	city varchar(250) NOT NULL,
	state varchar(250) NOT NULL,
	mobileNumber int(10) UNIQUE NOT NULL,
	address_1 varchar(250) NOT NULL,
	address_2 varchar(250),
	zip int(7) NOT NULL
);

DROP TABLE IF EXISTS AuthenticationData;

CREATE TABLE AuthenticationData(
	email varchar(250) PRIMARY KEY,
	password varchar(250) NOT NULL,
	isPasswordTemporary BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS AccountType;

CREATE TABLE AccountType(
	c_id int(10) PRIMARY KEY,
	accountType varchar(250) UNIQUE NOT NULL
);



