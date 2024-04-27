-- Insert data into university_management.prof table
INSERT INTO prof (pfname, degree, office) VALUES
    ('John Doe', 'Ph.D.', 'Office A'),
    ('Jane Smith', 'M.Sc.', 'Office B'),
    ('Alice Johnson', 'MBA', 'Office C'),
    ('Bob Williams', 'Ph.D.', 'Office D'),
    ('Emily Brown', 'M.Sc.', 'Office E'),
    ('Michael Davis', 'Ph.D.', 'Office F'),
    ('Jessica Lee', 'MBA', 'Office G'),
    ('David Miller', 'M.Sc.', 'Office H'),
    ('Sarah Wilson', 'Ph.D.', 'Office I'),
    ('Chris Anderson', 'M.Sc.', 'Office J');

create table if not exists clg
(
    id   serial,
    clgname varchar,
    city varchar,
    primary key (id),
    prof_id int,
    constraint profclg_FK foreign key (prof_id) references prof(id)
);

-- Insert data into university_management.student table
INSERT INTO students (name, city, clg_id) VALUES
    ('Student 1', 'City 1', 1),
    ('Student 2', 'City 2', 1),
    ('Student 3', 'City 3', 3),
    ('Student 4', 'City 4', 4),
    ('Student 5', 'City 5', 5),
    ('Student 6', 'City 6', 2),
    ('Student 7', 'City 7', 7),
    ('Student 8', 'City 8', 3),
    ('Student 9', 'City 9', 9),
    ('Student 10', 'City 10', 10);

-- Insert data into university_management.course table
INSERT INTO course (coursename, unit, clg_id) VALUES
    ('Mathematics', 1, 1),
    ('Physics', 1, 2),
    ('Chemistry', 3, 3),
    ('Biology', 3, 4),
    ('Computer Science', 3, 5),
    ('History', 3, 6),
    ('Economics', 2, 7),
    ('Literature', 1, 8),
    ('Art', 2, 9),
    ('Music', 3, 10);

INSERT INTO selectunit (student_id, course_id, prof_id, term, score) VALUES
    (1, 1, 1, 'Spring', 85.5),
    (2, 2, 2, 'Spring', 90.0),
    (3, 3, 3, 'Spring', 78.2),
    (4, 4, 4, 'Spring', 92.7),
    (5, 5, 5, 'Spring', 87.1);