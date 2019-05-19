insert into courses values
        (1, 'Разработчик приложений Spring',
         'Вы будете разрабатывать полноценное клиент-серверное приложение с нуля. Изучите
часто применяемые инструменты, подходы, фреймворки и архитектурные принципы
на базовом уровне. Поймете как рабоатет экосистема Spring. Как очень просто создавать
с помощью Spring веб приложения. В ходе выполнения курса вы создадите - онлнайн-магазин
в качестве примера.',
         'Spring;Spring Boot;Spring MVC;Spring Data Jpa;SQL;Hibernate',
         'Java; Database understanding'),

        (2, 'SQL course', 'Learn sql interactive course', 'Spring;SQL;JAVA;GIT', '5 years of Java experience; 1 years of' ||
                                                                                 'sql experience');



insert into questions (id, content) values

(1, 'К какому типу систем контроля версий относится Git?'),
(2, 'Какая команда позволит добавить в коммит все измененные документы в текущем локальном репозитории?'),
(3, 'Что такое "merge conflict"?'),
(4, 'Какую из этих команд следует выполнить перед тем, как залить свои изменения?'),
(5, 'Как изменить последний коммит?'),
(6, 'Что такое - .gitignore?'),
(7, 'Как создать пустой файл Program.java в командной строке GitBash?');

insert into step_data (id, content, multiple_answer, question_id)
values
(1, 'Система контроля версий Git обеспечивает возможность нескольким программистам работать над одним проектом. Все изменения, внесенные каждым из разработчиковв, фиксируются и становятся доступными для других.

Помимо этого системы контроля версий позволяют поддерживать разные версии кода. Вы всегда можете вернуться к более старой версии. Это необходимо в тех случаях, когда новые изменения привели проект в неработоспособное состояние.

Одной из реализаций механизма Git является известный сервис GitHub.

Имея аккаунт GitHub, у вас есть возможность создать удаленный (remote) репозиторий - хранилища вашего кода. В данном репозитории находится вся история проекта.',
 null, null),
(2, null, false, 1),
(3, null, false, 2);

insert into answer_option (id, content)
values
(1, 'Централизованная'),
(2, 'Распределенная'),
(3, 'git checkout -b dev'),
(4, 'git clone'),
(5, 'git add .'),
(6, 'git pull'),
(7, 'Отправка коммитов не в тот репозиторий'),
(8, 'Нарушение корпоративной этики в IT-компании'),
(9, 'Ситуация, при которой ваши коммиты отменяют изменения, сделанные другим разработчиком'),
(10, 'Нарушение принципов GitFlow'),
(11, 'git pull'),
(12, 'git diff'),
(13, 'git add .gitignore'),
(14, 'git commit -m ''message');

insert into questions_answers (question_id, answers_id)
values
(1, 1), (1, 2),
(2, 3), (2, 4), (2, 5), (2, 6),
(3, 7), (3, 8), (3, 9), (3, 10);

update questions set correct_answer_id = 2 where id = 1;
update questions set correct_answer_id = 5 where id = 2;
update questions set correct_answer_id = 9 where id = 3;
update questions set correct_answer_id = 11 where id = 4;
-- update questions set correct_answer_id = 2 where id = 5;
-- update questions set correct_answer_id = 2 where id = 6;
-- update questions set correct_answer_id = 2 where id = 7;

insert into steps (id, title, short_description, course_id, next_id, prev_id, step_type, step_data_id) values
(1, 'Git. База.', 'Базовое введение в Git', 1, null, null, 'THEORY', 1),
(2, 'Title Java Spring Project #2', 'learn java together', 1, null,null, 'SELECT_ANSWER', 2),
(3, 'Title Java Spring Project #3', 'learn java together', 1, null,null, 'SELECT_ANSWER', 3),
(4, 'Title Java Spring Project #4', 'learn java together', 1, null,null, 'THEORY', null),
(5, 'Title Java Spring Project #5', 'learn java together', 1, null,null, 'THEORY', null),
(6, 'Title SQL #1', 'learn SQL together', 2, null,null, 'THEORY', null),
(7, 'Title SQL #2', 'learn SQL together', 2, null,null, 'THEORY', null),
(8, 'Title SQL #3', 'learn SQL together', 2, null,null, 'THEORY', null);

update steps set next_id = 2 where id = 1;
update steps set next_id = 3, prev_id = 1 where id = 2;
update steps set next_id = 4, prev_id = 2 where id = 3;
update steps set next_id = 5, prev_id = 3 where id = 4;
update steps set prev_id = 4 where id = 5;

update steps set next_id = 7 where id = 6;
update steps set next_id = 8, prev_id = 6 where id = 7;
update steps set prev_id = 7 where id = 8;


insert into user_course_step (id, user_id, course_id, step_id)
values ( 1, 1, 1, 1 );



select *
from courses where id = 1;

select *
from steps s where s.course_id = 1;

select *
from step_data sd where sd.id = 1;