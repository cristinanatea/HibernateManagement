drop database Management_angajati;
create database Management_angajati;
use Management_angajati;

CREATE TABLE User (
    userID TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    phonenumber VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email varchar(50) not null unique key,
    acces TINYINT NOT NULL
);

select*from user;
CREATE TABLE Project (
    projectID TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    managerID TINYINT NOT NULL,
    name VARCHAR(50) NOT NULL,
	foreign key (managerID) references User(userID)
 );

select* from Project;
CREATE TABLE Organisation (
    userID TINYINT NOT NULL,
    projectID TINYINT NOT NULL,
	foreign key (userID) references User(userID),
	foreign key (projectID) references Project(projectID)
);
select* from Organisation;


select* from Project;

--signup
 insert into User (name, phonenumber, password, email) values('cristina','0987654321','Ausy', 'cristina.natea4@gmail.com');
 insert into User (name, phonenumber, password, email) values('adina','0987654322','Ausy', 'cristina.natea4@gmail.com');
--login
  select* from User where email= 'cristina.natea4@gmail.com' and password='Ausy';
  
--creare echipe
----creare proiect :
    insert into Project(managerID,name)values(1,'BMW');
	-----asignarea unui utilizator angajat pe proiect
	insert into Organisation(userID, projectID) values(1,1);


   
