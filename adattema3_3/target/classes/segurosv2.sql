CREATE DATABASE IF NOT EXISTS segurosv2;

USE segurosv2;

CREATE TABLE IF NOT EXISTS seguro(
	idSeguro int,
    nif varchar(9),
    nombre varchar(15),
    ape1 varchar(15),
    ape2 varchar(15),
    edad int,
    numHijos int,
    fechaCreacion date,
    constraint pk_seguro primary key(idSeguro)
);

CREATE TABLE IF NOT EXISTS asistenciamedica(
	idAsistenciaMedica int,
    breveDescripcion varchar(50),
    lugar varchar(20),
    idSeguroAsistencia int,
    constraint pk_asistenciamedica primary key(idAsistenciaMedica),
    constraint fk_seguros_en_asistenciamedica foreign key (idSeguroAsistencia) references seguro(idSeguro)
);

GRANT ALL PRIVILEGES ON segurosv2.* TO masemoel@localhost;