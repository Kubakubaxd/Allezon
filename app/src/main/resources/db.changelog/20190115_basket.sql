CREATE TABLE basket
(
    userpsqla VARCHAR(30) REFERENCES userspsqla (username),
    auction   BIGINT REFERENCES auction (id),

    primary key (userpsqla)
);