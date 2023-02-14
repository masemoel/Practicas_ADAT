create database if not exists libros3_4;

use libros3_4;

create table if not exists autor(
	dni varchar(9),
    nombre varchar(20),
    apellidos varchar(35),
    fecha_nacimiento date,
    constraint pk_autor primary key(dni)
);

create table if not exists libro(
	isbn int,
    titulo varchar(30),
    editorial varchar(20),
    edicion int,
    dni_autor varchar(9),
    constraint pk_libro primary key(isbn),
    constraint fk_autores_en_libros foreign key (dni_autor) references autor(dni)
);

GRANT ALL PRIVILEGES ON libros3_4.* TO masemoel@localhost;

DROP TABLE libro;
DROP TABLE autor;

SELECT * FROM libro;
SELECT * FROM autor;