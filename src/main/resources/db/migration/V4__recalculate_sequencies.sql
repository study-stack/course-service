begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table courses in exclusive mode;

select setval('courses_id_seq', COALESCE((select MAX(id) + 1
                                                          from courses), 1), false);
commit;

begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table questions in exclusive mode;

select setval('questions_id_seq', COALESCE((select MAX(id) + 1
                                                          from questions), 1), false);
commit;

begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table step_data in exclusive mode;

select setval('step_data_id_seq', COALESCE((select MAX(id) + 1
                                                          from step_data), 1), false);
commit;

begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table answer_option in exclusive mode;

select setval('answer_option_id_seq', COALESCE((select MAX(id) + 1
                                                          from answer_option), 1), false);
commit;

begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table steps in exclusive mode;

select setval('steps_id_seq', COALESCE((select MAX(id) + 1
                                                          from steps), 1), false);
commit;

begin;
-- Защита от параллельных вставок при обновлении счетчика
lock table user_course_step in exclusive mode;

select setval('user_course_step_id_seq', COALESCE((select MAX(id) + 1
                                                          from user_course_step), 1), false);
commit;


