CREATE SEQUENCE hibernate_sequence;

CREATE TABLE userspsqla
(
    username VARCHAR(30)   NOT NULL,
    password VARCHAR(100)  NOT NULL,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    email VARCHAR(30),
    birthdate VARCHAR (30),
    admin BOOLEAN,

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
    id BIGSERIAL NOT NULL,
    description VARCHAR (250),
    section_id BIGINT REFERENCES section(id),
    price INT,
    owner VARCHAR(30),

    PRIMARY KEY (id)
);

CREATE TABLE photo
(
    id BIGINT,
    auction_id BIGINT REFERENCES auction(id),
    link VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE parameter
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR (30),

    PRIMARY KEY (id)
);

CREATE TABLE auction_parameter
(
    auction_id BIGINT REFERENCES auction(id),
    parameter_id BIGINT REFERENCES parameter(id),
    value VARCHAR (30)
);