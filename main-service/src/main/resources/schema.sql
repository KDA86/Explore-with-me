truncate table events restart identity CASCADE;
truncate table category restart identity CASCADE;
truncate table users restart identity CASCADE;
truncate table location restart identity CASCADE;
truncate table participation_request restart identity CASCADE;
truncate table compilation_events restart identity;
truncate table compilations restart identity;

create table IF NOT EXISTS category
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL
        constraint category_pk
            primary key,
    name varchar not null,
    CONSTRAINT UQ_NAME UNIQUE (name)
);

create table IF NOT EXISTS users
(
    id integer GENERATED BY DEFAULT AS IDENTITY NOT NULL
        constraint users_pk
            primary key,
    email varchar not null,
    CONSTRAINT UQ_EMAIL UNIQUE (email),
    name varchar not null
);

create table IF NOT EXISTS location
(
    id  integer generated by default as identity NOT NULL
        constraint location_pk
            primary key,
    lat double precision not null,
    lon double precision not null
);

create table IF NOT EXISTS events
(
    id integer GENERATED BY DEFAULT AS IDENTITY NOT NULL,

        CONSTRAINT PK_event_id PRIMARY KEY (id),
    annotation          varchar   not null,
    category            integer   not null
    constraint events_category_null_fk
        references category,
    confirmedRequests   integer,
    createdOn           timestamp not null,
    description         varchar   not null,
    eventDate           timestamp not null,
    initiator           integer   not null
        constraint events_users_null_fk
            references users,
    location            integer   not null
        constraint events_location_null_fk
            references location,
    paid                boolean   not null,
    participantLimit    integer   not null,
    publishedOn         timestamp,
    requestModeration   varchar   not null,
    state               varchar   not null,
    title               varchar   not null,
    views               integer   not null
);

create table IF NOT EXISTS participation_request
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL
        constraint participation_request_pk
            primary key,
    created   varchar not null,
    event     integer,
    requester integer    not null,
    status    varchar   not null
);

create table IF NOT EXISTS compilation_events
(
    compilation_id     integer not null,
    event_id integer    not null,
        CONSTRAINT FK_compilation_id FOREIGN KEY (compilation_id)
        REFERENCES compilations (id),
    CONSTRAINT FK_event_id FOREIGN KEY (event_id)
        REFERENCES events (id)
);

create table IF NOT EXISTS compilations
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
        CONSTRAINT PK_compilation_id PRIMARY KEY (id),
    pinned   boolean   not null,
    title    varchar   not null
);