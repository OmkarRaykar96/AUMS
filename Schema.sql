create database AUMS;

use AUMS;

create table employee (
emp_id bigint primary key auto_increment,
emp_email_id varchar(100),
emp_name varchar(50) not null,
emp_designation varchar(30) not null,
emp_location varchar(30) not null,
emp_img longblob,
last_modifier_id bigint,
last_modified_tm timestamp,
UNIQUE (emp_email_id)
);

create table system_admin (
admin_id bigint primary key references employee(emp_id),
last_modifier_id int null,
last_modified_tm timestamp
);

create table trainer (
trainer_id bigint primary key references employee(emp_id),
active_flag varchar(1),
last_modifier_id int null,
last_modified_tm timestamp
);

create table course (
course_id bigint primary key auto_increment,
course_description varchar(100),
course_location varchar(100),
course_name varchar(100),
course_prerequisites varchar(100),
couse_skills varchar(100),
course_admin_id bigint references system_admin(admin_id),
last_modifier_id int null,
last_modified_tm timestamp
);

create table training (
training_id bigint primary key,
course_id bigint references course(course_id),
trainer_id bigint references trainer(trainer_id),
training_feedback text(500) null,
last_modifier_id int null,
last_modified_tm timestamp
);

create table training_material (
material_id bigint references training(training_id),
material_file longblob not null,
material_file_name varchar(100),
material_file_type varchar(10),
active_flag varchar(1),
last_modifier_id int null,
last_modified_tm timestamp
);

create table course_trainer_mapping (
course_id bigint references course(course_id),
trainer_id bigint references trainer(trainer_id),
last_modifier_id int null,
last_modified_tm timestamp
);
