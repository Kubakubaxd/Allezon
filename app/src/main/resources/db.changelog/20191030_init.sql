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

CREATE TABLE section
(
    id BIGSERIAL NOT NULL,
    name VARCHAR (30),

    PRIMARY KEY (id)
);

CREATE TABLE auction
(
    id BIGSERIAL,
    description VARCHAR (250),
    section_id BIGINT REFERENCES section(id),
    price INT,

    PRIMARY KEY (id)
);

CREATE TABLE auction_photo
(
    auction_id INT REFERENCES auction(id),
    link VARCHAR (50)
);

CREATE TABLE parameter
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR (30),

    PRIMARY KEY (id)
);

CREATE TABLE action_parameter
(
    auction_id BIGINT REFERENCES auction(id),
    parameter_id BIGINT REFERENCES parameter(id),
    value VARCHAR (30)
);


