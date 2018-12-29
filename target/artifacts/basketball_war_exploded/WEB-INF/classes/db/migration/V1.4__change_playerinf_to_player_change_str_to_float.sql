ALTER TABLE PlayerInf
RENAME TO Player;

ALTER TABLE Player DROP born;
Alter Table Player add born TIMESTAMP;
ALTER TABLE Player DROP height;
Alter Table Player add height FLOAT;
ALTER TABLE Player DROP weight;
Alter Table Player add weight FLOAT;

ALTER TABLE PlayerStatistics DROP score;
Alter Table PlayerStatistics add score FLOAT;
ALTER TABLE PlayerStatistics DROP rebound;
Alter Table PlayerStatistics add rebound FLOAT;
ALTER TABLE PlayerStatistics DROP assistant;
Alter Table PlayerStatistics add assistant FLOAT;