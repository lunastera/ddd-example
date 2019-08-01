create table users (
  id varchar(64) not null primary key,
  name varchar(255),
  password varchar(255)
);

insert into users (id, name, password) values ('uno', 'Ara', 'era');
insert into users (id, name, password) values ('zenno', 'maeno', 'hoge');
insert into users (id, name, password) values ('sakapon', 'sakamoto', 'fuga');