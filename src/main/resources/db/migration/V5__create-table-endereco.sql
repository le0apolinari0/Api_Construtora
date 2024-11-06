CREATE TABLE endereco (
    id bigint not null auto_increment,
    empresas_id bigint not null,
    colaboradores_id bigint not null,
    uf varchar(2) not null,
    cidade varchar(100) not null,
    endereco varchar(100) not null,
    cep varchar(9) not null,
    bairro varchar(100) not null,
    numero varchar(10),
    complemento varchar(50),
    logradouro varchar (50),
    foreign key (empresas_id) references empresas(id),
    foreign key (colaboradores_id) references colaboradores(id),

     primary key (id)
);
