create database crudopdb;
use crudopdb;

create table student(
	student_no varchar(3) not null,
    student_name text(10),
    student_dob date,
    student_doj date,
    primary key(student_no)
    );

create table project(
	prj_no varchar(3),
    prj_name text(15),
    prj_dur numeric(2),
    prj_platform text(10),
    primary key(prj_no)
	);

create table student_project(
	student_no varchar(3),
    prj_no varchar(3),
    designation varchar(10),
    primary key(student_no,prj_no, designation ),
    foreign key(student_no) references student(student_no),
    foreign key(prj_no) references project(prj_no)
	);
