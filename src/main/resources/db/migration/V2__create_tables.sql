create table answer_option
(
  id      bigserial primary key,
  content text
);

create table courses
(
  id            bigserial primary key,
  description   text,
  name          varchar(2048),
  prerequisites varchar(255),
  skills        varchar(255)
);

create table questions
(
  id                bigserial primary key,
  content           text,
  correct_answer_id bigint
    constraint questions__answer_option
      references answer_option
);

create table questions_answers
(
  question_id bigint not null
    constraint questions_answers__questions
      references questions,
  answers_id  bigint not null
    constraint questions_answers__answers_id__ux
      unique
    constraint questions_answers__answer_option
      references answer_option
);

create table step_data
(
  id              bigserial primary key,
  content         text,
  multiple_answer boolean,
  question_id     bigint
    constraint step_data__questions
      references questions
);

create table steps
(
  id                bigserial primary key,
  short_description varchar(255),
  title             varchar(255),
  step_type         varchar(255),
  course_id         bigint
    constraint steps__courses
      references courses,
  next_id           bigint
    constraint steps__steps_next
      references steps,
  prev_id           bigint
    constraint steps__steps_prev
      references steps,
  step_data_id      bigint
    constraint steps__step_data
      references step_data
);

create table user_course_step
(
  id        bigserial primary key,
  current   boolean,
  user_id   bigint not null,
  course_id bigint not null
    constraint user_course_step__courses
      references courses,
  step_id   bigint not null
    constraint user_course_step__steps
      references steps
);

