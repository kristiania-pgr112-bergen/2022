USE equipmentBallsDb;

CREATE TABLE lockers(
    id INT NOT NULL AUTO_INCREMENT,
    location VARCHAR(45),
    address VARCHAR(45),
    primary key (id)
);

CREATE TABLE equipmentBall(
    id INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(45) NOT NULL ,
    needsAir BOOLEAN,
    location INT NULL,
    primary key(id),
    CONSTRAINT fk_location
        FOREIGN KEY (location)
        REFERENCES lockers(id)
);


