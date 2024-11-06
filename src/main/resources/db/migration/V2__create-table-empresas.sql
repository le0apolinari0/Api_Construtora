create table empresas (
    id bigint not null auto_increment,
    nome varchar(200) not null,
    cnpj varchar(30) not null unique,
    email varchar(50) not null unique,
    telefone varchar(15) not null,
    primary key(id)
);