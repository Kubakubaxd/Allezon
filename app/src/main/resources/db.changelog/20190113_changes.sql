CREATE TABLE section
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR(30),

    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id         BIGSERIAL NOT NULL,
    name       VARCHAR(30),
    section_id BIGINT references section (id),

    PRIMARY KEY (id)
);

CREATE TABLE auction
(
    id          BIGSERIAL NOT NULL,
    description VARCHAR(250),
    category_id BIGINT REFERENCES category (id),
    price       INT,
    owner       VARCHAR(30),

    PRIMARY KEY (id)
);

CREATE TABLE photo
(
    id         BIGINT,
    auction_id BIGINT REFERENCES auction (id),
    link       VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE parameter
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR(30),

    PRIMARY KEY (id)
);

CREATE TABLE auction_parameter
(
    auction_id   BIGINT REFERENCES auction (id),
    parameter_id BIGINT REFERENCES parameter (id),
    value        VARCHAR(30)
);