create table if not exists prof
(
    id   serial,
    pfname varchar,
    degree varchar,
    office varchar,
    primary key (id)
);

create table if not exists clg
(
    id   serial,
    clgname varchar,
    city varchar,
    primary key (id),
    prof_id int,
    constraint profclg_FK foreign key (prof_id) references prof(id)
);

create table if not exists studens
(
    id   serial,
    name varchar,
    city varchar,
    clg_id int,
    primary key (id),
    constraint studentsclg_FK foreign key (clg_id) references clg(id)
);

create table if not exists course
(
    id   serial,
    courseName varchar,
    unit int,
    primary key (id),
    clg_id int,
    constraint courseclg_FK foreign key (clg_id) references clg(id)
);

create table if not exists selectUnit
(
    student_id int,
    course_id int,
    prof_id int,
    term varchar(10),
    score float,
    constraint secstudents_FK foreign key (student_id) references students(id),
    constraint seccourse_FK foreign key (course_id) references course(id),
    constraint secprof_FK foreign key (prof_id) references prof(id)
);