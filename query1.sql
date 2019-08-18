CREATE DATABASE SistemaVentasBD;
USE SistemaVentasBD;

CREATE TABLE Tipo_usuario 
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                tipo VARCHAR(35),
                eliminado BOOL DEFAULT(false));

CREATE TABLE Usuarios
				(id_usuario INTEGER auto_increment PRIMARY KEY,
                username VARCHAR(30),
                userpass VARCHAR(35),
                tipo_usuario INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                constraint fk_UsiarioTipo_usuario
                foreign key (tipo_usuario)references Tipo_usuario(id_tipo));

CREATE TABLE Tipo_empleado
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                nombre 	VARCHAR(20),
                eliminado BOOL DEFAULT(false));
	
CREATE TABLE Empleados
				(cedula VARCHAR(15) PRIMARY KEY,
                nombres VARCHAR(50),
                apellidos VARCHAR(50),
                telefono VARCHAR(15),
                salario FLOAT,
                tipo_empleado INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_EmpleadoTipo_empleado
                FOREIGN KEY(tipo_empleado)REFERENCES Tipo_empleado(id_tipo),
                CONSTRAINT fk_EmpleadoUsario
				FOREIGN KEY(id_usuario)REFERENCES Usuarios(id_usuario));

CREATE TABLE Repartidores
				(id_repartidor INTEGER auto_increment PRIMARY KEY,
                disponible BOOL,
                id_empleado VARCHAR(15) NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_RepartidorEmpleado
                FOREIGN KEY (id_empleado)REFERENCES Empleados(cedula));

CREATE TABLE Tipo_local
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                nombre VARCHAR(30),
                eliminado BOOL DEFAULT(false));

CREATE TABLE Locales 
				(id_local INTEGER auto_increment PRIMARY KEY,
                nombre VARCHAR(40),
                direccion VARCHAR(100),
                encargado VARCHAR(15) NOT NULL,
                tipo_local INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_LocalEmpleado
                FOREIGN KEY (encargado)REFERENCES Empleados(cedula),
                CONSTRAINT fk_LocalTipo_local
                FOREIGN KEY (tipo_local) REFERENCES Tipo_local(id_tipo));

CREATE TABLE Articulos
				(id_articulo INTEGER auto_increment PRIMARY KEY,
                precio FLOAT,
                categoria VARCHAR(20),
                descripcion VARCHAR(150),
                eliminado BOOL DEFAULT(false));

CREATE TABLE LocalArticulo
				(id INTEGER auto_increment PRIMARY KEY,
                cantidad INTEGER,
                id_local INTEGER NOT NULL,
                id_articulo INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_la_local
                FOREIGN KEY (id_local)REFERENCES Locales(id_local),
                CONSTRAINT fk_la_articulo
                FOREIGN KEY (id_articulo) REFERENCES Articulos(id_articulo));

CREATE TABLE Clientes
				(cedula VARCHAR(15) PRIMARY KEY,
                nombres VARCHAR(50),
                apellidos VARCHAR(50),
                domicilio VARCHAR(100),
                telefono VARCHAR(15), 
                eliminado BOOL DEFAULT(false));

CREATE TABLE Tarjetas
				(id_tarjeta INTEGER auto_increment PRIMARY KEY,
                nombre VARCHAR(30),
                tipo VARCHAR(20),
                id_cliente VARCHAR(15) NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_TarjetaCliente
                FOREIGN KEY (id_cliente) REFERENCES Clientes(cedula));

CREATE TABLE Tipo_pago
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                tipo VARCHAR(30),
                eliminado BOOL DEFAULT(false));

CREATE TABLE Tipo_documento
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                nombre VARCHAR(30),
                eliminado BOOL DEFAULT(false)); 

CREATE TABLE Ventas	
				(id_venta INTEGER auto_increment PRIMARY KEY,
                fecha DATE,
                precio_total FLOAT,
                tipo_pago INTEGER NOT NULL,
                id_local INTEGER NOT NULL,
                id_empleado VARCHAR(15) NOT NULL,
                id_cliente VARCHAR(15) NOT NULL,
                tipo_documento INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_VentaPago
                FOREIGN KEY (tipo_pago)REFERENCES Tipo_pago(id_tipo),
                CONSTRAINT fk_VentaLocal
                FOREIGN KEY (id_local) REFERENCES Locales(id_local),
                CONSTRAINT fk_VentaEmpleado
                FOREIGN KEY (id_empleado)REFERENCES Empleados(cedula),
                CONSTRAINT fk_VentaCliente
                FOREIGN KEY (id_cliente) REFERENCES Clientes(cedula),
                CONSTRAINT fk_VentaDocumento
                FOREIGN KEY (tipo_documento) REFERENCES Tipo_documento(id_tipo));
                
CREATE TABLE Detalle
				(id_detalle INTEGER auto_increment PRIMARY KEY,
                cantidad INTEGER,
                id_articulo INTEGER NOT NULL,
                precio_parcial FLOAT,
                id_venta INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_DetalleArticulo
                FOREIGN KEY (id_articulo)REFERENCES Articulos(id_articulo),
                CONSTRAINT fk_DetalleVenta
                FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta));
                

CREATE TABLE Cotizaciones
				(id_cotizacion INTEGER auto_increment PRIMARY KEY,
                fecha DATE,
                precio_total FLOAT,
                id_local INTEGER NOT NULL,
                id_empleado VARCHAR(15) NOT NULL,
                id_cliente VARCHAR(15) NOT NULL,
                eliminado BOOL DEFAULT(false),
				CONSTRAINT fk_CotizacionLocal
                FOREIGN KEY (id_local)REFERENCES Locales(id_local),
                CONSTRAINT fk_CotizacionEmpleado
                FOREIGN KEY (id_empleado) REFERENCES Empleados(cedula),
                CONSTRAINT fk_CotizacionCliente
                FOREIGN KEY (id_cliente)REFERENCES Clientes(cedula));

CREATE TABLE DetalleCotizacion
				(id_detalle INTEGER auto_increment PRIMARY KEY,
                cantidad INTEGER,
                id_articulo INTEGER NOT NULL,
                precio_parcial FLOAT,
                id_cotizacion INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_dc_Articulo
                FOREIGN KEY (id_articulo)REFERENCES Articulos(id_articulo),
                CONSTRAINT fk_dc_Cotizacion
                FOREIGN KEY (id_cotizacion) REFERENCES Cotizaciones(id_cotizacion));

CREATE TABLE Tipo_entrega
				(id_tipo INTEGER auto_increment PRIMARY KEY,
                tipo VARCHAR(25),
                eliminado BOOL DEFAULT(false));

CREATE TABLE Observaciones
				(id_obs INTEGER auto_increment PRIMARY KEY,
                descripcion VARCHAR(100),
                eliminado BOOL DEFAULT(false));
                
CREATE TABLE EntregaDomicilio
				(id_entrega INTEGER auto_increment PRIMARY KEY,
                id_venta INTEGER NOT NULL,
                fecha DATE,
                id_repartidor INTEGER,
                exitosa BOOL,
                CONSTRAINT fk_ed_Venta
                FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta),
                CONSTRAINT fk_ed_Repartidor
                FOREIGN KEY (id_repartidor)REFERENCES Repartidores(id_repartidor));
                

CREATE TABLE Envios
				(id_ruta INTEGER auto_increment PRIMARY KEY,
                direccion VARCHAR(100),
                id_repartidor INTEGER NOT NULL,
                tipo_entrega INTEGER NOT NULL,
                id_observacion INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_EnvioRepartidor
                FOREIGN KEY (id_repartidor)REFERENCES Repartidores(id_repartidor),
                CONSTRAINT fk_EnvioEntrega
                FOREIGN KEY (tipo_entrega) REFERENCES Tipo_entrega(id_tipo),
                CONSTRAINT fk_EnvioObservacion
                FOREIGN KEY (id_observacion)REFERENCES Observaciones(id_obs));

CREATE TABLE Abastecimientos
				(id_abastecimiento INTEGER auto_increment PRIMARY KEY,
                fecha DATE,
                id_repartidor INTEGER,
                eliminado BOOL DEFAULT(false),
				CONSTRAINT fk_AbastecimientoRepartidor
                FOREIGN KEY (id_repartidor)REFERENCES Repartidores(id_repartidor));

CREATE TABLE DetalleAbastecimiento
				(id_detalle INTEGER auto_increment PRIMARY KEY,
                cantidad INTEGER,
                id_articulo INTEGER NOT NULL,
                id_abastecimiento INTEGER NOT NULL,
                eliminado BOOL DEFAULT(false),
                CONSTRAINT fk_da_Articulo
                FOREIGN KEY (id_articulo)REFERENCES Articulos(id_articulo),
                CONSTRAINT fk_da_Abastecimiento
                FOREIGN KEY (id_abastecimiento) REFERENCES Abastecimientos(id_abastecimiento));
