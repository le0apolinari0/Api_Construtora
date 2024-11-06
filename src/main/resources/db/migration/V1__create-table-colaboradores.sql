create table colaboradores(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade varchar(3) not null,
    dataNascimento varchar (10),
    cpf varchar(15) not null unique,
    email varchar(100) not null unique,
    telefone varchar(13) not null,
    especialidade varchar(100) not null,
    primary key(id)

);