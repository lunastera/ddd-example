create table members (
  id serial not null primary key,
  name varchar(64),
  created_at timestamp not null
);

insert into members (name, created_at) values ('Alice', current_timestamp);
insert into members (name, created_at) values ('Bob', current_timestamp);
insert into members (name, created_at) values ('Chris', current_timestamp);