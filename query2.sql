insert into Tipo_empleado(nombre) values('Admin');
insert into Tipo_empleado(nombre) values('Gerente');
insert into Tipo_empleado(nombre) values('Vendedor');
insert into Tipo_empleado(nombre) values('JefeBodega');

alter table Usuarios
modify column userpass VARBINARY(100);

alter table Usuarios
drop foreign key fk_UsiarioTipo_usuario;
alter table Usuarios
drop column Tipo_usuario;
drop table Tipo_usuario;

alter table Repartidores
add column cedula VARCHAR(15);
alter table Repartidores
add column nombres VARCHAR(50);
alter table Repartidores
add column apellidos VARCHAR(50);
alter table Repartidores
add column telefono VARCHAR(15);
alter table Repartidores
add column salario FLOAT;
alter table Repartidores
add column direccion VARCHAR(100);
alter table Empleados
add column direccion VARCHAR(100);
alter table Repartidores
add column email VARCHAR(60);
alter table Empleados
add column email VARCHAR(60);

alter table Repartidores
drop foreign key fk_RepartidorEmpleado;

alter table Repartidores
drop column id_empleado;

insert into Usuarios (username, userpass) values('kennyCamba', aes_encrypt("admin11_10", "dksaljdskfh328dshjdh2uheiuhqdnmsbnvcad"));
insert into Empleados (cedula,nombres,apellidos,telefono,salario,tipo_empleado,id_usuario,direccion,email)
values("0952770386", "Kenny Ariel", "Camba Torres", "0968311103", 500, 1, 1, "Jose Mascote y Frc. Segura", "kacamba@espol.edu.ec");
 
insert into Usuarios (username, userpass) values('steven', aes_encrypt("stevenaraujo98", "dksaljdskfh328dshjdh2uheiuhqdnmsbnvcad"));
insert into Empleados (cedula,nombres,apellidos,telefono,salario,tipo_empleado,id_usuario,direccion,email)
values("0922663208", "Steven", "Araujo", "0968311103", 1000, 1, 2, "Coop. Puebo y su reino", "saraujo@espol.edu.ec");


DELIMITER //
CREATE procedure login(in user_name varchar(50), in user_pass varchar(50))
	begin
		select id_usuario, username, userpass from Usuarios
		where username = user_name and userpass = aes_encrypt(user_pass, "dksaljdskfh328dshjdh2uheiuhqdnmsbnvcad") and eliminado = false;
	end //
DELIMITER ;

DELIMITER //
CREATE procedure empleadoByID(in id varchar(15))
	begin
		select cedula, nombres, apellidos, direccion, email, telefono, salario, tipo_empelado from Empleados
        where cedula = id and eliminado = false;
	end //
DELIMITER ;

DELIMITER //
CREATE procedure empleadoByUserID(in user_id integer)
	begin
		select cedula, nombres, apellidos, direccion, email, telefono, salario, tipo_empleado from Empleados
        where id_usuario = user_id and eliminado = false;
	end //
DELIMITER ;

