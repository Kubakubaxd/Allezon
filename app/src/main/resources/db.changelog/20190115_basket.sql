CREATE TABLE basket
(
    id           VARCHAR(30) REFERENCES userspsqla (username),
    creationdate VARCHAR(10),

    primary key (owner)
);

CREATE TABLE basketbucket
(
    basket_id  varchar(30) REFERENCES basket (id),
    auction_id BIGINT REFERENCES auction (id),
    quantity   INT
);