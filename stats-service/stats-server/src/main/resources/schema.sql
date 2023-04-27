truncate table endpointhit restart identity;

create table IF NOT EXISTS endpointhit
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL
        constraint endpointhit_pk
            primary key,
    app  varchar not null,
    uri  varchar not null,
    ip  varchar not null,
    timestamp timestamp
);