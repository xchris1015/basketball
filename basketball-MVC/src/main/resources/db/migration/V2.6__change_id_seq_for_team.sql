drop table team;
create sequence team_id_seq;
create table team (
   id bigint not null DEFAULT NEXTVAL('team_id_seq'),
   conference varchar(255),
   division varchar(255) not NULL,
	 found_year TIMESTAMP,
	 history varchar(255) not NULL unique,
	 arena varchar(255),
	 location varchar(255),
   primary key (id)
);
alter SEQUENCE team_id_seq OWNED BY team.id;