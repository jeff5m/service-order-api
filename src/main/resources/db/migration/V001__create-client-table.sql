create table client
(
    id    bigint not null auto_increment,
    name  text   not null,
    email text   not null,
    phone text   not null,

    primary key (id)
);