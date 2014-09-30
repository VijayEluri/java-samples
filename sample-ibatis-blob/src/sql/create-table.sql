create table REPORT (
        id              varchar2(5) not null,
        name            varchar2(25),
        description     varchar2(1000),
        data            BLOB,
        primary key (id)
);
create table REPORT2 (
        id              varchar2(5) not null,
        name            varchar2(25),
        description     varchar2(1000),
        data            CLOB,
        primary key (id)
)