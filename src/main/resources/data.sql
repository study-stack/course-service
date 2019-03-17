insert into courses values
        (1, 'Spring development', 'Learn how to create spring web applications', 'Spring;java;git', 'Java experience; ' ||
                                                                                                    'java core development'),
        (2, 'SQL course', 'Learn sql interactive course', 'Spring;SQL;JAVA;GIT', '5 years of Java experience; 1 years of' ||
                                                                                 'sql experience');

insert into steps (id, title, short_description, course_id, next_id, prev_id) values
(1, 'Title Java Spring Project #1', 'learn java together', 1, null,null),
(2, 'Title Java Spring Project #2', 'learn java together', 1, null,null),
(3, 'Title Java Spring Project #3', 'learn java together', 1, null,null),
(4, 'Title Java Spring Project #4', 'learn java together', 1, null,null),
(5, 'Title Java Spring Project #5', 'learn java together', 1, null,null),
(6, 'Title SQL #1', 'learn SQL together', 2, null,null),
(7, 'Title SQL #2', 'learn SQL together', 2, null,null),
(8, 'Title SQL #3', 'learn SQL together', 2, null,null);

update steps set next_id = 2 where id = 1;
update steps set next_id = 3, prev_id = 1 where id = 2;
update steps set next_id = 4, prev_id = 2 where id = 3;
update steps set next_id = 5, prev_id = 3 where id = 4;
update steps set next_id = 6, prev_id = 4 where id = 5;

update steps set next_id = 7 where id = 6;
update steps set next_id = 8, prev_id = 6 where id = 7;
update steps set prev_id = 7 where id = 8;


insert into user_course_step (id, user_id, course_id, step_id)
values ( 1, 1, 1, 1 );