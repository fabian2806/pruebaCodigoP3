-- USUARIOS
CREATE TABLE usuario(
	idUsuario INT AUTO_INCREMENT,
    dni VARCHAR(8),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    correo VARCHAR(50),
    contrasenha VARCHAR(50),
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idUsuario)
)ENGINE = innodb;

CREATE TABLE administrador(
	idAdministrador INT,
    PRIMARY KEY(idAdministrador),
    FOREIGN KEY(idAdministrador) REFERENCES usuario(idUsuario)
)ENGINE = innodb;

CREATE TABLE trabajador(
	idTrabajador INT,
    puesto VARCHAR(50),
    salario DECIMAL(10, 2),
    fechaIngreso DATE,
    horarioInicio TIME,
    horarioFin TIME,
    PRIMARY KEY(idTrabajador),
    FOREIGN KEY(idTrabajador) REFERENCES usuario(idUsuario)
)ENGINE = innodb;

CREATE TABLE cliente(
	idCliente INT,
    PRIMARY KEY(idCliente),
    FOREIGN KEY(idCliente) REFERENCES usuario(idUsuario)
)ENGINE = innodb;

CREATE TABLE direccion(
	idDireccion INT AUTO_INCREMENT,
    fidCliente INT,
    direccion VARCHAR(50),
    distrito VARCHAR(50),
    provincia VARCHAR(50),
    departamento VARCHAR(50),
    codigoPostal VARCHAR(50),
    referencia VARCHAR(50),
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idDireccion),
    FOREIGN KEY(fidCliente) REFERENCES cliente(idCliente)
)ENGINE = innodb;

CREATE TABLE cupon(
	idCupon INT AUTO_INCREMENT,
    fidTrabajador INT,
    codigo VARCHAR(10),
    descripcion VARCHAR(50),
    fechaInicio DATE,
    fechaFin DATE,
    usado BOOLEAN DEFAULT 0,
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idCupon),
    FOREIGN KEY(fidTrabajador) REFERENCES trabajador(idTrabajador)
)ENGINE = innodb;

CREATE TABLE clientexcupon(
	idCliente INT,
    idCupon INT,
    fechaAsignada DATE,
    PRIMARY KEY(idCliente, idCupon),
    FOREIGN KEY(idCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY(idCupon) REFERENCES cupon(idCupon)
)ENGINE = innodb;

-- --------------------------------------------------------------------------------

-- PRENDAS
CREATE TABLE prenda(
	idPrenda INT AUTO_INCREMENT,
	nombre VARCHAR(50),
	descripcion VARCHAR(50),
	tipo ENUM('Polo', 'Pantalon', 'Polera', 'Camisa', 'Casaca'),
	imagen VARCHAR(255),
	talla ENUM('XS', 'S', 'M', 'L', 'XL', 'XXL'),
	genero ENUM('Hombre', 'Mujer', 'Unisex'),
	color VARCHAR(50),
	precio DECIMAL(10, 2),
	stock INT,
	cantVendida INT DEFAULT 0,
	activo BOOLEAN DEFAULT 1,
	PRIMARY KEY(idPrenda)
)ENGINE = innodb;

CREATE TABLE promocion(
	idPromocion INT AUTO_INCREMENT,
    fidTrabajador INT,
	nombre VARCHAR(50),
	descripcion TEXT,
	fechaInicio DATE,
	fechaFin DATE,
	activo BOOLEAN DEFAULT 1,
	PRIMARY KEY(idPromocion),
    FOREIGN KEY(fidTrabajador) REFERENCES trabajador(idTrabajador)
)ENGINE = innodb;

CREATE TABLE prendaxpromocion(
	idPrenda INT,
    idPromocion INT,
    fechaAsignada DATE,
    PRIMARY KEY(idPrenda, idPromocion),
    FOREIGN KEY(idPrenda) REFERENCES prenda(idPrenda),
    FOREIGN KEY(idPromocion) REFERENCES promocion(idPromocion)
)ENGINE = innodb;

-- --------------------------------------------------------------------------------

-- COMPRAS
CREATE TABLE carrito(
	idCarrito INT AUTO_INCREMENT,
    cantidadTotal INT,
    precioTotal DECIMAL(10, 2),
    PRIMARY KEY(idCarrito)
)ENGINE = innodb;

CREATE TABLE prendaseleccionada(
	idPrendaSeleccionada INT,
    fidCarrito INT,
	cantidad INT,
    precio DECIMAL(10, 2),
    PRIMARY KEY(idPrendaSeleccionada),
    FOREIGN KEY(idPrendaSeleccionada) REFERENCES prenda(idPrenda),
    FOREIGN KEY(fidCarrito) REFERENCES carrito(idCarrito)
)ENGINE = innodb;

CREATE TABLE ordencompra(
	idOrden INT AUTO_INCREMENT,
    fidCliente INT,
    fidCupon INT,
    fidCarrito INT,
    fechaPedida DATE,
    fechaPago DATE,
    estado ENUM('Registrado', 'Procesado', 'Anulado', 'Entregado'),
    dni VARCHAR(8),
    correo VARCHAR(50),
    PRIMARY KEY(idOrden),
    FOREIGN KEY(fidCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY(fidCupon) REFERENCES cupon(idCupon),
    FOREIGN KEY(fidCarrito) REFERENCES carrito(idCarrito)
)ENGINE = innodb;

CREATE TABLE prendaseleccionadaxorden(
	idPrenda INT,
    idOrden INT,
    PRIMARY KEY(idPrenda, idOrden),
    FOREIGN KEY(idPrenda) REFERENCES prenda(idPrenda),
    FOREIGN KEY(idOrden) REFERENCES ordencompra(idOrden)
)ENGINE = innodb;

CREATE TABLE comprobante(
	idComprobante INT AUTO_INCREMENT,
    fidOrden INT,
    totalPagar DECIMAL(10, 2),
    PRIMARY KEY(idComprobante),
    FOREIGN KEY(fidOrden) REFERENCES ordencompra(idOrden)
)ENGINE = innodb;

CREATE TABLE boleta(
	idBoleta INT,
    dni VARCHAR(8),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    PRIMARY KEY(idBoleta),
    FOREIGN KEY(idBoleta) REFERENCES comprobante(idComprobante)
)ENGINE = innodb;

CREATE TABLE factura(
	idFactura INT,
    ruc VARCHAR(11),
    razonSocial VARCHAR(50),
    repreLegal VARCHAR(50),
    PRIMARY KEY(idFactura),
    FOREIGN KEY(idFactura) REFERENCES comprobante(idComprobante)
)ENGINE = innodb;

-- -------------------------------------------------------------

DELIMITER //
CREATE PROCEDURE INSERTAR_TRABAJADOR(
    OUT _idTrabajador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT,

    IN  _fechaContrato DATE
)
BEGIN 

    INSERT INTO usuario(dni,nombres,apellidos,correo,contrasenha,activo) 
    VALUES (_dni,_nombres,_apellidos,_correo,_contrasenha,_activo);

    SET _idTrabajador = @@last_insert_id;

    INSERT INTO trabajador(idTrabajador,fechaContrato)
    VALUES (_idTrabajador,_fechaContrato);

END//

CREATE PROCEDURE MODIFICAR_TRABAJADOR(
    IN _idTrabajador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT,
    IN _fechaContrato DATE
)
BEGIN 
    UPDATE usuario SET 
        idUsuario = _idTrabajador, -- ya que estamos modificando a la clase padre desde la hija
        dni = _dni,
        nombres = _nombres,
        apellidos = _apellidos,
        correo = _correo,
        contrasenha = _contrasenha,
        activo = _activo
    WHERE  idUsuario = _idTrabajador; -- ya que estamos modificando a la clase padre desde la hija

    UPDATE trabajador SET
    fechaContrato = _fechaContrato
    WHERE idTrabajador = _idTrabajador;

END//

CREATE PROCEDURE ELIMINAR_TRABAJADOR(IN _idTrabajador INT)
BEGIN 
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idTrabajador; 
END//

CREATE PROCEDURE ELIMINAR_DIRECCION (
	IN _idDireccion INT
)
BEGIN 
	UPDATE direccion 
    SET activo = 0 
    WHERE idDireccion = _idDireccion;
END//

CREATE PROCEDURE LISTAR_DIRECCION_TODOS()
BEGIN 
	SELECT idDireccion, calle, numero, distrito, provincia, departamento, codigoPostal, referencia, activo 
    FROM direccion;
END//


CREATE PROCEDURE LISTAR_DIRECCION_X_ID(
	IN _idDireccion INT
)
BEGIN 
	SELECT idDireccion,calle,numero,distrito,provincia,departamento,codigoPostal,referencia,activo 
    FROM direccion 
    WHERE idDireccion = _idDireccion;
END//


-- PROCEDIMIENTOS PARA CLIENTE


CREATE PROCEDURE INSERTAR_CLIENTE(
	OUT _idCliente INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT,
    IN _fidCarrito INT
)
BEGIN 
	INSERT INTO usuario(dni,nombres,apellidos,correo,contrasenha,activo) 
    VALUES (_dni,_nombres,_apellidos,_correo,_contrasenha,_activo);
    
    SET _idCliente = @@last_insert_id;
    INSERT INTO cliente(idCliente,fidCarrito) VALUES (_idCliente,_fidCarrito);
END//


CREATE PROCEDURE MODIFICAR_CLIENTE(
	IN _idCliente INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT
)
BEGIN 
	UPDATE usuario SET 

		dni = _dni,
		nombres = _nombres,
		apellidos = _apellidos,
		correo = _correo,
		contrasenha = _contrasenha,
		activo = _activo
    WHERE  idUsuario = _idCliente; -- ya que estamos modificando a la clase padre desde la hija
END//

CREATE PROCEDURE ELIMINAR_CLIENTE (
	IN _idCliente INT
)
BEGIN 
	UPDATE usuario 
    SET activo = 0 
    WHERE idUsuario = _idCliente;
END//

CREATE PROCEDURE LISTAR_CLIENTE_TODOS()
BEGIN 
	SELECT idUsuario,dni,nombres,apellidos,correo,contrasenha,activo,c.fidCarrito
    FROM usuario,cliente;
END//


CREATE PROCEDURE LISTAR_CLIENTE_X_ID(
	IN _idCliente INT
)
BEGIN 
	SELECT idUsuario,dni,nombres,apellidos,correo,contrasenha,activo,c.fidCarrito
    FROM usuario,cliente c
    WHERE idUsuario = _idCliente;
END//

-- PROCEDIMIENTOS PARA TRABAJADOR

select * from trabajador;

CREATE PROCEDURE INSERTAR_TRABAJADOR(
	OUT _idTrabajador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT,
    
    IN  _fechaContrato DATE,
    IN  _horario 	DATETIME
)
BEGIN 
	
	INSERT INTO usuario(dni,nombres,apellidos,correo,contrasenha,activo) 
    VALUES (_dni,_nombres,_apellidos,_correo,_contrasenha,_activo);
    
     SET _idTrabajador = @@last_insert_id;
     
     INSERT INTO trabajador(idTrabajador,fechaContrato,horario) 
     VALUES (_idTrabajador,_fechaContrato,_horario);
    
END//

CREATE PROCEDURE MODIFICAR_TRABAJADOR(
	IN _idTrabajador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT,
    IN  _fechaContrato DATE
)
BEGIN 
	UPDATE usuario SET 
		dni = _dni,
		nombres = _nombres,
		apellidos = _apellidos,
		correo = _correo,
		contrasenha = _contrasenha,
		activo = _activo
    WHERE  idUsuario = _idTrabajador; -- ya que estamos modificando a la clase padre desde la hija
    
    UPDATE trabajador SET
    fechaContrato = _fechaContrato
    WHERE idTrabajador = _idTrabajador;
    
END//


CREATE PROCEDURE ELIMINAR_TRABAJADOR(IN _idTrabajador INT)
BEGIN 
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idTrabajador; 
END//

CREATE PROCEDURE LISTAR_TRABAJADOR_X_ID(IN _idTrabajador INT)
BEGIN 

	SELECT t.idTrabajador,u.dni,u.nombres,u.apellidos,u.correo,u.contrasenha,u.activo,t.fechaContrato,t.horario FROM trabajador t, usuario u WHERE idUsuario = _idTrabajador and idTrabajador = _idTrabajador;  

END//

CREATE PROCEDURE LISTAR_TRABAJADOR_TODOS()
BEGIN 
	SELECT t.idTrabajador,u.dni,u.nombres,u.apellidos,u.correo,u.contrasenha,u.activo,t.fechaContrato,t.horario FROM trabajador t, usuario u WHERE  t.idTrabajador = u.idUsuario;  
END//

-- PROCEDIMIENTOS PARA ADMINISTRADOR

CREATE PROCEDURE INSERTAR_ADMINISTRADOR(
	OUT _idAdministrador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT
)
BEGIN 
	
	INSERT INTO usuario(dni,nombres,apellidos,correo,contrasenha,activo) 
    VALUES (_dni,_nombres,_apellidos,_correo,_contrasenha,_activo);
    
     SET _idAdministrador = @@last_insert_id;
     
     INSERT INTO administrador (idAdministrador) 
     VALUES (_idAdministrador);
    
END//

CREATE PROCEDURE MODIFICAR_ADMINISTRADOR(
	IN _idAdministrador INT,
    IN _dni VARCHAR(100),
    IN _nombres VARCHAR(100),
    IN _apellidos VARCHAR(100),
    IN _correo VARCHAR(100),
    IN _contrasenha VARCHAR(100),
    IN _activo TINYINT
)
BEGIN 
	UPDATE usuario SET 
		
		dni = _dni,
		nombres = _nombres,
		apellidos = _apellidos,
		correo = _correo,
		contrasenha = _contrasenha,
		activo = _activo
    WHERE  idUsuario = _idAdministrador; -- ya que estamos modificando a la clase padre desde la hija
END//


CREATE PROCEDURE ELIMINAR_ADMINISTRADOR(IN _idAdministrador INT)
BEGIN 
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idAdministrador; 
END//

CREATE PROCEDURE LISTAR_ADMINISTRADOR_TODOS()
BEGIN 
	SELECT a.idAdministrador,u.dni,u.nombres,u.apellidos,u.correo,u.contrasenha,u.activo FROM administrador a, usuario u WHERE  a.idTrabajador = u.idUsuario;
END//

CREATE PROCEDURE LISTAR_ADMINISTRADOR_X_ID(IN _idAdministrador INT)
BEGIN 

	SELECT dni,nombres,apellidos,correo,contrasenha,activo FROM usuario WHERE idUsuario = _idAdministrador;  

END//



-- PROCEDIMIENTOS PARA CUPON

CREATE PROCEDURE INSERTAR_CUPON(
    IN _fidTrabajador INT,
    IN _codigo VARCHAR(100),
    IN _descripcion TEXT,
    IN _fechaInicio DATE,
    IN _fechaFin DATE,
    IN _usado TINYINT(1),
    IN _activo TINYINT(1)
)
BEGIN 
	INSERT INTO cupon(fidTrabajador,codigo,descripcion,fechaInicio,fechaFin,usado,activo) 
    VALUES (_fidTrabajador,_codigo,_descripcion,_fechaInicio,_fechaFin,_usado,_activo);
END//

CREATE PROCEDURE MODIFICAR_CUPON(
	IN _idCupon INT,
    IN _fidTrabajador INT,
    IN _codigo VARCHAR(100),
    IN _descripcion TEXT,
    IN _fechaInicio DATE,
    IN _fechaFin DATE,
    IN _usado TINYINT(1),
    IN _activo TINYINT(1)
)
BEGIN 
	UPDATE cupon SET 
		fidTrabajador = _fidTrabajador,
		codigo = _codigo,
		descripcion = _descripcion,
		fechaInicio = _fechaInicio,
		fechaFin = _fechaFin,
        usado = _usado,
        activo = _activo
    WHERE  idCupon = _idCupon;
END//

CREATE PROCEDURE ELIMINAR_CUPON (
	IN _idCupon INT
)
BEGIN 
	UPDATE cupon 
    SET activo = 0 
    WHERE idCupon = _idCupon;
END//

CREATE PROCEDURE LISTAR_CUPON_TODOS()
BEGIN 
	SELECT idCupon,fidTrabajador,codigo,descripcion,fechaInicio,fechaFin,usado,activo 
    FROM cupon;
END//


CREATE PROCEDURE LISTAR_CUPON_X_ID(
	IN idCupon INT
)
BEGIN 
	SELECT idCupon,fidTrabajador,codigo,descripcion,fechaInicio,fechaFin,usado,activo 
    FROM cupon
    WHERE idCupon = _idCupon;
END//
