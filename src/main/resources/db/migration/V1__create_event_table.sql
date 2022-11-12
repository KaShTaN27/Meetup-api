CREATE TABLE IF NOT EXISTS event
(
    event_id    SERIAL NOT NULL PRIMARY KEY,
    topic       VARCHAR(100),
    description VARCHAR(255),
    date        TIMESTAMP,
    location    VARCHAR(255),
    organizer   VARCHAR(150)
);