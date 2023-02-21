CREATE DATABASE IF NOT EXISTS adattema3_examen;

USE adattema3_examen;

GRANT ALL PRIVILEGES ON masemoel.* TO masemoel@localhost;

CREATE TABLE IF NOT EXISTS ventas(
	n_venta int,
    n_emple int,
    fecha date,
    n_cliente int,
    constraint pk_ventas primary key(n_venta)
);

CREATE TABLE IF NOT EXISTS productos(
	n_producto int,
    descripcion varchar(30),
    precio_unidad double,
    n_proveedor int,
    stock int,
    constraint pk_productos primary key(n_producto)
);

CREATE TABLE IF NOT EXISTS lineas_ventas(
	n_venta int,
    n_producto int,
    cantidad int,
    constraint pk_lineas_ventas primary key(n_venta, n_producto)
);

DROP TABLE ventas;
DROP TABLE productos;
DROP TABLE lineas_ventas;

SELECT * FROM ventas;
SELECT * FROM productos;
SELECT * FROM lineas_ventas;