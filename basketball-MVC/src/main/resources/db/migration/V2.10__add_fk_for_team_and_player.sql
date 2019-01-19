alter table players
add column team_id bigint;
Alter table players add constraint fk_player_team
foreign key (team_id) references team(id);