alter table Clientes
add column email varchar(80);

INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("0923414561", "Juan Antonio", "Rodriguez Catro", "domicilio1", "0912345112", "juroca@outlook.com");
INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("0863444321", "Maria Fernanda", "Suarez Espinoza", "domicilio2", "0914543191", "mafesu@outlook.com");
INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("1934113571", "Jordan Israle", "Castro Diaz", "domicilio3", "0931239249", "jordicas@espol.edu.ec");
INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("1932348434", "Ney Taffarel", "Canales Olaya", "babahoyo", "0981243543", "ncanales@espol.edu.ec");
INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("092334551", "Alejandro", "Briones Romero", "domicilio4", "0911466511", "alejobri@espol.edu.ec");
INSERT into Clientes(cedula,nombres,apellidos,domicilio,telefono,email)
values("0943043660", "Liliana", "Franco Chilan", "domicilio5", "0918324561", "lifran@espol.edu.ec");

create table Categorias
				(id_categoria INTEGER auto_increment PRIMARY KEY,
                nombre varchar(50),
                descripcion varchar(150));
                
alter table Articulos
drop column categoria;

alter table Articulos
add column categoria INTEGER NOT NULL;

alter table Articulos
add constraint fk_articuloCategoria 
foreign key(categoria) references Categorias(id_categoria);

insert into Categorias(nombre,descripcion)values("SmartPhones", "Teléfonos con S.O. Android y IOS");
insert into Categorias(nombre,descripcion)values("Laptops y Notebooks", "Computadoras personales");
insert into Categorias(nombre,descripcion)values("Tablets", "Tablets android y IPads");
insert into Categorias(nombre,descripcion)values("PC", "Computadoras de escritorio");
insert into Categorias(nombre,descripcion)values("Parlantes", "Reproductores de sonido");
insert into Categorias(nombre,descripcion)values("SmartTV", "Televisores inteligentes");

alter table Articulos
add column nombre varchar(60);

insert into Articulos(precio,descripcion,categoria,nombre)values(165.99, "Ranura híbrida Dual SIM 4G Azul 4000 mAh", 1, "Xiaomi Redmi Note 7");
insert into Articulos(precio,descripcion,categoria,nombre)values(168.87, "Smartphones de 6.3'' pantalla completa, 4GB RAM + 64GB ROM", 1, "Xiaomi Redmi Note 7");
insert into Articulos(precio,descripcion,categoria,nombre)values(39.99, "Altavoz inteligente con Alexa, tela de color antracita", 5, "Echo Dot (3.ª generación)");
insert into Articulos(precio,descripcion,categoria,nombre)values(370.00, "Smart TV OLED 4K UHD de 55\" (Inteligencia Artificial, procesador Inteligente Alpha 7 Gen. 2", 6, "LG OLED55B9ALEXA ");
insert into Articulos(precio,descripcion,categoria,nombre)values(157.47, "Smartphone DE 5.9\" (Qualcomm Snapdragon 660 a 2.2 GHz, RAM de 4 GB", 1, "Xiaomi MI A2");
insert into Articulos(precio,descripcion,categoria,nombre)values(299.00, "Televisor Led 50 Pulgadas Ultra HD 4K Smart, resolución 3840", 1, "TD Systems K50DLH8US ");
insert into Articulos(precio,descripcion,categoria,nombre)values(1289.00, "La 2 en 1 de 13 pulgadas con pantalla InfinityEdge más pequeña del mundo", 2, "XPS 13");
insert into Articulos(precio,descripcion,categoria,nombre)values(549.00, "Laptop de 14 pulgadas con portabilidad y estilo pulido.", 2, "Serie 5000");
insert into Articulos(precio,descripcion,categoria,nombre)values(1379.00, "Laptop para juegos de 17 pulgadas con un diseño delgado y elegante, procesador Intel® Core™ de 9.ª generación", 2, "G7");
insert into Articulos(precio,descripcion,categoria,nombre)values(439.00, "Procesador Intel® Core™ i3-8100 de 8.ª generación (6MB de memoria caché, de hasta 3.6 GHz)", 4, "Inspiron 3470");
insert into Articulos(precio,descripcion,categoria,nombre)values(459.00, "La computadora de escritorio todo-en-uno de 22 pulgadas ofrece una transmisión sin problemas para ver videos", 4, "Inspiron 22\" 3275");
insert into Articulos(precio,descripcion,categoria,nombre)values(569.95, "Mucho más tableta con un marco más delgado", 3, "Galaxy Tab S5e");

insert into Usuarios (username, userpass) values('jordi', aes_encrypt("jefeb1", "dksaljdskfh328dshjdh2uheiuhqdnmsbnvcad"));

insert into Empleados (cedula,nombres,apellidos,telefono,salario,tipo_empleado,id_usuario,direccion,email)
values("0952214550", "Jordi", "Villao", "0934905040", 440, 4, 3, "direccion1", "jvillao@espol.edu.ec");
insert into Usuarios (username, userpass) values('saraujo', aes_encrypt("vededor1", "dksaljdskfh328dshjdh2uheiuhqdnmsbnvcad"));
insert into Empleados (cedula,nombres,apellidos,telefono,salario,tipo_empleado,id_usuario,direccion,email)
values("0942230367", "Steven", "Araujo Moran", "0975431414", 440, 3, 3, "direccion2", "saraujo@espol.edu.ec");

insert into Repartidores (cedula,disponible,nombres,apellidos,telefono,salario,direccion,email)
values("0945567245", true, "Cesar", "Vera", "0930061021", 300, "direccion3", "cssvera@espol.edu.ec");

insert into Repartidores (cedula,disponible,nombres,apellidos,telefono,salario,direccion,email)
values("1435472342", true, "Andres", "Tenempaguay", "0923151140", 300, "direccion4", "andtmp@espol.edu.ec");

insert into Repartidores (cedula,disponible,nombres,apellidos,telefono,salario,direccion,email)
values("0934425391", true, "Miguel", "Herrera", "0954424681", 300, "direccion5", "mpherrera@espol.edu.ec");

insert into Tipo_local(nombre) values("Matriz");
insert into Tipo_local(nombre) values("Sucursal");
insert into Tipo_local(nombre) values("Bodega");

insert into Locales(nombre,direccion,encargado,tipo_local) values("Tecno Import S.A.", "Campus Gustavo Galindo, Av Perimetral", "0952770386", 1); 
insert into Locales(nombre,direccion,encargado,tipo_local) values("Tecno Import S.A - Sucursal 1", "Campus Las Peñas", "0942230367", 2); 
insert into Locales(nombre,direccion,encargado,tipo_local) values("Tecno Import S.A. - Bodega 1", "Adminsiones ESPOL", "0952214550", 3); 

insert into Tipo_documento (nombre) values("Factura");
insert into Tipo_documento (nombre) values("Nota de Crédito");

insert into Tipo_entrega(tipo) values("Domicilio");
insert into Tipo_entrega(tipo) values("Repartir");

insert into Tipo_pago(tipo) values("Efectivo");
insert into Tipo_pago(tipo) values("VISA");
insert into Tipo_pago(tipo) values("PayPal");
