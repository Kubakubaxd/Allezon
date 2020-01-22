CREATE TABLE basket
(
    id           BIGSERIAL NOT NULL,
    userpsqla    VARCHAR(30) REFERENCES userspsqla (username) UNIQUE,
    creationdate VARCHAR(10),

    primary key (id)
);

CREATE TABLE basketbucket
(
    basket_id  BIGINT REFERENCES basket (id),
    auction_id BIGINT REFERENCES auction (id),
    quantity   INT
);