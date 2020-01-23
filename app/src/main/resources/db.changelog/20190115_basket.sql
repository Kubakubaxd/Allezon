CREATE TABLE basket
(
    owner        VARCHAR(30),
    creationdate VARCHAR(10),

    primary key (owner)
);

CREATE TABLE basketbucket
(
    basket_owner VARCHAR(30) REFERENCES basket (owner),
    auction_id   BIGINT REFERENCES auction (id),
    quantity     INT
);