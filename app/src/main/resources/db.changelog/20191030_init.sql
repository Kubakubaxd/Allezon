CREATE SEQUENCE hibernate_sequence;


CREATE TABLE userspsqla
(
    username VARCHAR(30)   NOT NULL,
    password VARCHAR(100)  NOT NULL,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    email VARCHAR(30),
    birthdate VARCHAR (30),

    PRIMARY KEY (username)
);
