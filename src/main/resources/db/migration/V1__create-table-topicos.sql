create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(255) not null unique,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id)

);