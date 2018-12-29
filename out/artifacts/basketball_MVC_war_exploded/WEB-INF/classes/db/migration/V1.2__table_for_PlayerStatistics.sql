create sequence player_statistics_id_seq;
create table PlayerStatistics (
   id bigint not null DEFAULT NEXTVAL('player_statistics_id_seq'),
   first_name varchar(255),
   last_name varchar(255) not NULL,
	 player_position varchar(255) not NULL unique,
	 score varchar(255) not NULL unique,
	 rebound varchar(255),
	 assistant varchar(255),
   primary key (id)
);
alter SEQUENCE player_statistics_id_seq OWNED BY PlayerStatistics.id;