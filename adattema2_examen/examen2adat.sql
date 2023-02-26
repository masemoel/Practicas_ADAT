create database if not exists examen2adat;

use examen2adat;

grant all privileges on examen2adat.* to masemoel@localhost;

create table if not exists cursos (
  codigo int,
  curso int,
  nombre varchar(40),
  nivel varchar(15),
  fpdual bool,
  clase int,
  constraint pk_cursos primary key(codigo)
);

create table if not exists alumnos (
  dni varchar(9),
  nombre varchar(20),
  apellido1 varchar(20),
  apellido2 varchar(20),
  repetidor bool,
  edad int,
  cod_curso int,
  constraint pk_alumnos primary key(dni),
  constraint fk_cursos_en_alumnos foreign key(cod_curso) references cursos(codigo)
);

insert into cursos values
(0, 1, 'Desarrollo aplicaciones multiplataforma', 'Grado superior', false, 205),
(1, 2, 'Desarrollo aplicaciones multiplataforma', 'Grado superior', false, 207),
(2, 1, 'Desarrollo de aplicaciones web', 'Grado superior', true, 206),
(3, 2, 'Desarrollo de aplicaciones web', 'Grado superior', true, 208),
(4, 1, 'Administración de sistemas en red', 'Grado medio', false, 203),
(5, 2, 'Administración de sistemas en red', 'Grado medio', false, 204),
(6, 4, 'Enseñanza obligatoria', 'ESO', false, 202);

insert into alumnos values
('77691163S', 'Manuel José', 'Moral', 'Eliche', false, 19, 1),
('12345678A', 'Manolo', 'Galán', 'Martínez', true, 19, 3),
('88888888H', 'Sonia', 'Poveda', 'Gutiérrez', false, 16, 6),
('25974227M', 'Justo', 'Liébana', 'Martos', false, 17, 4),
('77421585X', 'José', 'Blanca', 'Chica', false, 52, 6),
('44259587N', 'Sofía', 'Infante', 'Huesa', false, 23, 0),
('62280676W', 'Ana', 'Moral', 'Torres', true, 21, 2),
('52416385Y', 'Sergio', 'Sánchez', 'Martos', false, 25, 5),
('36251485B', 'Sara', 'Pegalajar', 'Estrella', false, 29, 3);

ALTER TABLE alumnos ADD CONSTRAINT cursos_de_alumnos FOREIGN KEY (cod_curso) REFERENCES cursos(codigo) ON DELETE CASCADE;

select * from alumnos;
select * from cursos;