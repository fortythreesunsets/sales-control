/*Populate tabla clientes*/
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2017-08-28', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Juan', 'Domínguez', 'jdom@gmail.com', '2017-08-28', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2017-08-06', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2017-08-07', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2017-08-08', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-11', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '2017-08-12', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('John', 'Roe', 'john.roe@gmail.com', '2017-08-13', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Jane', 'Roe', 'jane.roe@gmail.com', '2017-08-14', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-15', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-16', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Phillip', 'Webb', 'phillip.webb@gmail.com', '2017-08-17', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Stephane', 'Nicoll', 'stephane.nicoll@gmail.com', '2017-08-18', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-19', '');  
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Juergen', 'Hoeller', 'juergen.Hoeller@gmail.com', '2017-08-20', ''); 
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('John', 'Smith', 'john.smith@gmail.com', '2017-08-22', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-23', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-24', '');
INSERT INTO clientes (nombre, apellido, email, creado_en, foto) VALUES('Richard', 'Roe', 'stiles.roe@gmail.com', '2017-08-25', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, creado_en) VALUES('Panasonic Pantalla LCD', 25999, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Sony Camara digital DSC-W320B', 12349, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Apple iPod shuffle', 1499, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Hewlett Packard Multifuncional F2280', 1699, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Bianchi Bicicleta Aro 26', 6999, NOW());
INSERT INTO productos (nombre, precio, creado_en) VALUES('Mica Comoda 5 Cajones', 2999, NOW());

/* Crear algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, creado_en) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, creado_en) VALUES('Factura Bicicleta', 'Alguna nota importante', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/*Crear algunos usuarios con sus roles */
INSERT into users (username, password, enabled) VALUES ('admin', '$2a$10$8ar1ksz69xs9v8m3dv/s7OW4wnJryh2v1k82Jv8UJwuSeRQMmp1t.', 1);
INSERT into users (username, password, enabled) VALUES ('silvia', '$2a$10$5b9NEwmFkXAbRvqLhh89/u2q1v5FK6m9uc0zcdCod8IF58RknJV/O', 1);

INSERT into authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT into authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT into authorities (user_id, authority) VALUES (2, 'ROLE_USER');