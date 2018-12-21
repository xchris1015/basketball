ALTER TABLE authorities DROP users_id;

ALTER TABLE authorities
ADD COLUMN user_id bigint not null;

ALTER TABLE authorities
ADD CONSTRAINT fk_users
FOREIGN KEY (user_id) REFERENCES users(id);