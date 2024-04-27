------------------------ Question 1
SELECT prof.pfname from course
join selectunit
on course.id = selectunit.course_id
join prof
on selectunit.prof_id = prof.id

where course.coursename = 'Mathematics'


----------------------- Question 2

SELECT c.* FROM course c
join clg  on c.clg_id = clg.id
where clg.name = 'computer';

----------------------- Question 3

select count(*) from course
inner join clg on clg.id = course.clg_id
where clg.clgname = 'computer' and course.unit = 3;

----------------------- Question 4

select students.name ,sum(unit) from students
inner join selectunit on students.id = selectunit.student_id
inner join course on selectunit.course_id = course.id
where score > 85
group by students.name
having sum(unit) > 4

----------------------- Question 5

select count(students.name) ,sum(course.unit)
from selectunit
join course on selectunit.course_id = course.id
join students on selectunit.student_id = students.id
where students.name = 'rezaie'
group by students.name;

----------------------- Question 6

SELECT c.* FROM course c
join clg  on c.clg_id = clg.id
where clg.name = 'computer';
select count(students.name)  ,sum(course.unit)
from selectunit join course on selectunit.course_id = course.id
join students on selectunit.student_id = students.id
where  students.name = 'rezaie'
group by students.name;

---------------------------- Question 7

select pfname from selectUnit
join prof p on p.id = selectUnit.prof_id
where p.pfname not in
(select prof.pfname from prof
join public.selectunit su on prof.id = su.prof_id
join public.course c on c.id = su.course_id
where c.unit = 2);

---------------------------- Question 8

select prof.* from clg
join prof on clg.prof_id = prof.id
WHERE prof.id NOT IN(
 select prof_id from selectunit WHERE score < 80
)

---------------------------- Question 9

select clg.* from clg
join students on clg.id = students.clg_id
group by clg.id having count(students.id)>1;

---------------------------- Question 10

select clg.clgname from clg
where clg.id
not in (
select course.clg_id from course
join public.selectunit s on course.id = s.course_id
where course.unit = 2);


---------------------------- Question 11

select s.*, count(*)
from selectunit
join students s on selectunit.student_id = s.id
join public.course c on c.id = selectunit.course_id
join public.clg c2 on c2.id = c.clg_id
where clgname = 'computer'
and score >= 80
group by s.id
having count(*) = (select count(course.id)
from course
join public.clg c on c.id = course.clg_id
where clgname = 'computer')