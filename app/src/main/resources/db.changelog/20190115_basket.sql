CREATE TABLE basket
(
    userpsqla    VARCHAR(30) REFERENCES userspsqla (username),
    creationdate VARCHAR(10),

    primary key (userpsqla)
);

CREATE TABLE basketbucket
(
    basket   varchar(30) REFERENCES basket (userpsqla),
    auction  BIGINT REFERENCES auction (id),
    quantity INT
);