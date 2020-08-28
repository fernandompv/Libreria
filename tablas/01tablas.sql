CREATE TABLE roles(
id_roles bigint not null,
nombre varchar(255),
PRIMARY KEY (id_roles)
);

CREATE TABLE usuarios(
id_usuario bigint not null,
nombre varchar(255),
apellido varchar(255),
username varchar(255),
password varchar(255),
email varchar(255),
PRIMARY KEY (id_usuario)
);

CREATE TABLE boligrafos(
id_boligrafo bigint not null,
nombre varchar(255),
color varchar(255),
precio real,
stock varchar(255),
PRIMARY KEY (id_boligrafo)
);

CREATE TABLE carpetas(
id_carpetas bigint not null,
nombre varchar(255),
color varchar(255),
precio real,
stock varchar(255),
PRIMARY KEY (id_carpetas)
);

CREATE TABLE juegos_mesa(
id_juego_mesa bigint not null,
nombre varchar(255),
genero varchar(255),
marca varchar(255),
precio real,
stock varchar(255),
PRIMARY KEY (id_juego_mesa)
);

CREATE TABLE libretas(
id_libreta bigint not null,
nombre varchar(255),
color varchar(255),
precio real,
stock varchar(255),
PRIMARY KEY (id_libreta)
);

CREATE TABLE libros(
id_libro serial not null,
nombre varchar(255),
stock varchar(255),
precio real,
genero varchar(255),
PRIMARY KEY (id_libro)
);

CREATE TABLE puzzles(
id_puzzle bigint not null,
nombre varchar(255),
piezas varchar(255),
precio real,
stock varchar(255),
PRIMARY KEY (id_puzzle)
);

CREATE TABLE tipo_productos(
id_tipo_producto bigint not null,
nombre varchar(255),
PRIMARY KEY (id_tipo_producto)
);

CREATE TABLE pedidos(
id_pedido bigint not null,
id_usuario int,
date DATE,
total real,
FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
PRIMARY KEY (id_pedido)
);

CREATE TABLE linea_pedido(
id_linea bigint not null,
nombre varchar(255),
precioUnidad real,
cantidad int,
subtotal real,
id_pedido bigint not null,
FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
PRIMARY KEY (id_linea)
);

CREATE TABLE linea_pedido_tipo(
linea_pedido_id_linea bigint not null,
tipo varchar(255),
FOREIGN KEY (linea_pedido_id_linea) REFERENCES linea_pedido(id_linea)
);

CREATE TABLE usuarios_roles(
usuarios_id_usuario bigint not null,
roles varchar(255)
);

--DROP TABLE boligrafos,carpetas,juegos_mesa,libretas,libros,pedidos,puzzles,usuarios,usuarios_roles,linea_pedido,linea_pedido_tipo CASCADE;

INSERT INTO roles (id_roles,nombre) VALUES (1,'USER');
INSERT INTO roles (id_roles,nombre) VALUES (2,'ADMIN');

--Admin1
INSERT INTO usuarios (id_usuario,nombre,apellido,username,password,email) VALUES (1,'','','admin','$2a$10$Av8VdSn1YKlmc96GrGCUnuX1Uwx9tjk3YBahM1TSgY0pZuwygAkoO','');

--Marialopez1
INSERT INTO usuarios (id_usuario,nombre,apellido,username,password,email) VALUES (2,'Maria','Lopez','Marialo','$2a$10$J2GENlWdzdAte5FqgkNRyeRQcPDztKImxoxZtHR0LGe41FCbW/OvG','');

--Sarandonga
INSERT INTO usuarios (id_usuario,nombre,apellido,username,password,email) VALUES (3,'Roberto','Salazar','4R','$2a$10$VMtfLYXkrXLgIW6OFQmUE.NFtHZk5n.twfYGCNZucRlqWZ5lsyecq','');

INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (1,'Bic','Azul',2.95,'200');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (2,'Bic','Rojo',2.50,'400');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (3,'Bic','Negro',2.75,'300');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (4,'Pilot','Azul',3.95,'250');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (5,'Pilot','Negro',3.00,'100');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (6,'Parker','Azul',2.95,'300');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (7,'Parker','Negro',1.95,'200');
INSERT INTO boligrafos (id_boligrafo,nombre,color,precio,stock) VALUES (8,'Parker','Verde',2.00,'500');


INSERT INTO carpetas (id_carpetas,nombre,color,precio,stock) VALUES (1,'Gallery','Naranja',1.00,'400');
INSERT INTO carpetas (id_carpetas,nombre,color,precio,stock) VALUES (2,'Gallery','Azul',1.00,'500');
INSERT INTO carpetas (id_carpetas,nombre,color,precio,stock) VALUES (3,'Gallery','Verde',1.00,'150');


INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (1,'Cluedo','Estrategia','Hassbro',25.00,'50');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (2,'Catán','Estrategia','Devir',40.00,'50');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (3,'Quien es quien','Estrategia','Hassbro',25.00,'50');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (4,'Tabú','Trivia','Hassbro',20.00,'50');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (5,'Pictionary','Trivia','Mattel',29.00,'50');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (6,'Twister','Creativo','Hassbro',15.00,'05');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (7,'Monopoly','Estrategia','Hassbro',28.00,'10');
INSERT INTO juegos_mesa (id_juego_mesa,nombre,genero,marca,precio,stock) VALUES (8,'Dixit','Creativo','Libellud',30.00,'20');


INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (1,'Oxfor','Verde',3.00,'200');
INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (2,'Oxford','Naranja',3.00,'155');
INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (3,'Oxford','Azul',3.00,'100');
INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (4,'Oxford','Rojo',3.00,'250');
INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (5,'Oxford','Negro',3.00,'50');
INSERT INTO libretas (id_libreta,nombre,color,precio,stock) VALUES (6,'Oxford','Marron',3.00,'300');


INSERT INTO puzzles (id_puzzle,nombre,piezas,precio,stock) VALUES (1,'Gallery','500',10.00,'10');
INSERT INTO puzzles (id_puzzle,nombre,piezas,precio,stock) VALUES (2,'Gallery','1000',15.00,'5');
INSERT INTO puzzles (id_puzzle,nombre,piezas,precio,stock) VALUES (3,'Gallery','1500',20.00,'10');


INSERT INTO libros (id_libro,nombre,stock,precio,genero) VALUES (1,'En el nombre del viento','30',10.00,'Fantasia');
INSERT INTO libros (id_libro,nombre,stock,precio,genero) VALUES (2,'Etica a nicómaco','8',7.00,'Ensayo');
INSERT INTO libros (id_libro,nombre,stock,precio,genero) VALUES (3,'La trampa de la inteligencia','5',15.00,'Ensayo');
INSERT INTO libros (id_libro,nombre,stock,precio,genero) VALUES (4,'It','10',20.00,'Terror');
INSERT INTO libros (id_libro,nombre,stock,precio,genero) VALUES (5,'El viaje de Nietzsche a sorrento','3',10.00,'Biografia');

INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (1,'Libro');
INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (2,'Puzzle');
INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (3,'Libreta');
INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (4,'Juego de mesa');
INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (5,'Carpeta');
INSERT INTO tipo_productos (id_tipo_producto,nombre) VALUES (6,'Boligrafo');

INSERT INTO usuarios_roles(usuarios_id_usuario,roles) VALUES(1,'ADMIN');
INSERT INTO usuarios_roles(usuarios_id_usuario,roles) VALUES(2,'USUARIO');
INSERT INTO usuarios_roles(usuarios_id_usuario,roles) VALUES(3,'USUARIO');

INSERT INTO pedidos(id_pedido,date,total,id_usuario) VALUES(1,'04/08/2020',50,2);

INSERT INTO linea_pedido(id_linea,nombre,precioUnidad,cantidad,subtotal,id_pedido) VALUES (1,'En el nombre del viento',10.00,4,40.00,1);
INSERT INTO linea_pedido(id_linea,nombre,precioUnidad,cantidad,subtotal,id_pedido) VALUES (2,'Puzzle 500 piezas',10.00,1,10.00,1);

INSERT INTO linea_pedido_tipo(linea_pedido_id_linea,tipo) VALUES (1,'LIBRO');
INSERT INTO linea_pedido_tipo(linea_pedido_id_linea,tipo) VALUES (2,'PUZZLE');

