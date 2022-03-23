USE PGR112;

CREATE TABLE IF NOT EXISTS users (
    id int not null auto_increment,
    username VARCHAR(64) UNIQUE,
    password VARCHAR(128),
    primary key(id)
);