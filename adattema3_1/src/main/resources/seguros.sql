CREATE DATABASE IF NOT EXISTS seguros;

USE seguros;

CREATE TABLE IF NOT EXISTS seguro(
	IdSeguro int,
    nif varchar(9),
    nombre varchar(15),
    ape1 varchar(15),
    ape2 varchar(15),
    edad int,
    numHijos int,
    fechaCreacion date,
    constraint pk_seguro primary key(IdSeguro)
);

CREATE USER masemoel@localhost IDENTIFIED BY "0201";
GRANT ALL PRIVILEGES ON seguros.* TO masemoel@localhost;