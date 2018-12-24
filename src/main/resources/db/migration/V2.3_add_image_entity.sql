create sequence image_id_seq;
create table images(
   id bigint not null DEFAULT NEXTVAL('images_id_seq'),
   UUID varchar (255) not NULL,
   file_name varchar (255) not NULL,
   primary key (id)
);
alter SEQUENCE images_id_seq OWNED BY images.id;