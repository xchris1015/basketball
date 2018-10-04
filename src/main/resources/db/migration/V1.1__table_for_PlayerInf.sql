create sequence player_inf_id_seq;
create table PlayerInf (
   id bigint not null DEFAULT NEXTVAL('player_inf_id_seq'),
   first_name varchar(255),
   last_name varchar(255) not NULL,
	 player_position varchar(255) not NULL unique,
	 born varchar(255) not NULL unique,
	 height varchar(255),
	 weight varchar(255),
   primary key (id)
);
alter SEQUENCE player_inf_id_seq OWNED BY PlayerInf.id;