drop table players;
create sequence player_id_seq;
create table players (
   id bigint not null DEFAULT NEXTVAL('player_id_seq'),
   first_name varchar(255),
   last_name varchar(255) not NULL,
	 player_position varchar(255) not NULL,
	 born TIMESTAMP ,
	 height FLOAT ,
	 weight FLOAT,
   primary key (id)
);
alter SEQUENCE player_id_seq OWNED BY players.id;


ALTER TABLE player_statistics DROP score;
Alter Table player_statistics add score FLOAT;
ALTER TABLE player_statistics DROP rebound;
Alter Table player_statistics add rebound FLOAT;
ALTER TABLE player_statistics DROP assistant;
Alter Table player_statistics add assistant FLOAT;