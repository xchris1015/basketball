create sequence users_id_seq;
create table users (
   id bigint not null DEFAULT NEXTVAL('users_id_seq'),
   first_name varchar(255),
   last_name varchar(255) not NULL,
	 username varchar(255) not NULL unique,
	 email varchar(255) not NULL unique,
	 passwords varchar(255),
   primary key (id)
);
alter SEQUENCE users_id_seq OWNED BY Users.id;