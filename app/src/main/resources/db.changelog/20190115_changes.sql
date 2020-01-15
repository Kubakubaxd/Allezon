CREATE TABLE nadsection
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR(30),

    PRIMARY KEY (id)
);

ALTER TABLE section
    ADD nadsection_id BIGINT REFERENCES nadsection (id);

ALTER TABLE auction
    ADD title VARCHAR(50);

ALTER TABLE userspsqla
    ADD admin BOOLEAN;