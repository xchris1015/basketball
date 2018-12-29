create sequence team_inf_id_seq;
create table TeamInf (
   id bigint not null DEFAULT NEXTVAL('team_inf_id_seq'),
   conference varchar(255),
   division varchar(255) not NULL,
	 found_year varchar(255) not NULL unique,
	 history varchar(255) not NULL unique,
	 arena varchar(255),
	 location varchar(255),
   primary key (id)
);
alter SEQUENCE team_inf_id_seq OWNED BY TeamInf.id;