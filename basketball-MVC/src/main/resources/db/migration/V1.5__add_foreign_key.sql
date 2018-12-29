alter table PlayerStatistics
add column player_id bigint;
Alter table PlayerStatistics add constraint fk_PlayerStatistics_Player
foreign key (player_id) references Player(id);