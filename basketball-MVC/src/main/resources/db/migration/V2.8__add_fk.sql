alter table player_statistics
add column player_id bigint;
Alter table player_statistics add constraint fk_player_statistics_player
foreign key (player_id) references players(id);