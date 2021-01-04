use test;
show tables;
create table dept(
id int primary key auto_increment,
name varchar(20)
);
create table employee (
id int primary key auto_increment,
name varchar(10),
gender char(1),   -- 性别
salary double,   -- 工资
join_date date,  -- 入职日期
dept_id int,
foreign key (dept_id) references dept(id) -- 外键，关联部门表(部门表的主键)
);

insert into dept (name) values ('develop_dpt'),('marketing_dpt'),('finance_dpt');
insert into employee(name,gender,salary,join_date,dept_id) values('Wukong','M',7200,'2013-02-24',1);
insert into employee(name,gender,salary,join_date,dept_id) values('Bajie','M',3600,'2010-12-02',2);
insert into employee(name,gender,salary,join_date,dept_id) values('Tangseng','M',9000,'2008-08-08',2);
insert into employee(name,gender,salary,join_date,dept_id) values('Baigujing','F',5000,'2015-10-07',3);
insert into employee(name,gender,salary,join_date,dept_id) values('Zhizhujing','F',4500,'2011-03-14',1);
select * from dept;
select * from employee;
-- answer
select * from employee where salary = (select max(salary) from employee);
select * from employee where salary <= (select avg(salary) from employee);
select e.name as employee_name,d.name as dept_name from employee e join dept d on e.dept_id = d.id where salary >= 5000;
select e.name as employee_name,d.name as dept_name from employee e join dept d on e.dept_id = d.id where d.name in ('develop_dpt','finance_dpt');
select e.name as employee_name,gender,salary,join_date,d.name as dept_name from employee e join dept d on e.dept_id = d.id where join_date >= '2011-01-01';

-- ------------------------------------------------------------------------------------------

-- 讲师表
create table teacher (
    id int auto_increment, -- 讲师ID
    name varchar(10), -- 讲师姓名
    bio varchar(255), -- 讲师简介
    level char(4), -- 讲师级别
    primary key (id),
    key `idx_id` (name) using btree
);
select * from teacher;
-- 课程分类表
create table subject (
    id int auto_increment, -- 课程分类ID
    name varchar(10), -- 课程分类名称
    description varchar(255), -- 课程分类描述
    create_time datetime, -- 创建时间
    update_time datetime, -- 更新时间
    primary key (id)
);

-- 课程表
create table course (
    id int auto_increment, -- 课程ID
    teacher_id int, -- 课程讲师ID 外键 用于描述课程的授课老师
    subject_id int, -- 课程分类ID 外键 用于描述课程所属的分类
    course_title varchar(10), -- 课程标题
    course_number int, -- 总课时
    read_cnt bigint, -- 浏览数量
    course_status char(1), -- 课程状态
    primary key (id),
    key `idx_id` (course_title) using btree,
    foreign key (teacher_id) references teacher(id),
    foreign key (subject_id) references subject(id)
);
select * from subject;
select * from course;
select * from teacher;

show variables like 'character_set_%';
show full columns from subject;
alter table subject change description description varchar(255)
character set utf8 collate utf8_unicode_ci not null default '';

INSERT INTO teacher VALUES (1, '刘德华', '毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱','高级讲师');
INSERT INTO teacher VALUES (2, '郭富城', '毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富','首席讲师');
INSERT INTO subject VALUES (1, '后端开发', '后端课程包括 Java PHP Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04');
INSERT INTO subject VALUES (2, '前端开发', '前端课程包括 JQuery VUE angularJS', '2020-02-27 10:00:04', '2020-02-27 18:44:04');
INSERT INTO course VALUES (1,1,1 ,'Java', 300,250000, '1');
INSERT INTO course VALUES (2,2,2, 'VUE', 400,200000,'1');

select t.name as teacher_name, c.course_title, s.name as subject_group from teacher t join course c on t.id = c.teacher_id join subject s on c.subject_id = s.id
where t.name = '刘德华';



