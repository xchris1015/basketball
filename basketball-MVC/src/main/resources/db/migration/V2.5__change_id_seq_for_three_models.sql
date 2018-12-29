drop table player_statistics;
create sequence player_statistics_id_seq;
create table player_statistics (
   id bigint not null DEFAULT NEXTVAL('player_statistics_id_seq'),
	 score varchar(255) not NULL unique,
	 rebound varchar(255),
	 assistant varchar(255),
   primary key (id)
);
alter SEQUENCE player_statistics_id_seq OWNED BY player_statistics.id;