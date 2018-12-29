create sequence authorities_id_seq;
create table authorities (
   id bigint not null DEFAULT NEXTVAL('authorities_id_seq'),
   authority varchar(255),
   primary key (id)
);
alter SEQUENCE authorities_id_seq OWNED BY authorities.id;

ALTER TABLE authorities
ADD COLUMN users_id bigint not null;


ALTER TABLE authorities
ADD CONSTRAINT fk_users
FOREIGN KEY (users_id) REFERENCES users(id);