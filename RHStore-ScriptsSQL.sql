-- Drop de tablas
DROP TABLE IF EXISTS clientexcupon;
DROP TABLE IF EXISTS prendaseleccionadaxorden;
DROP TABLE IF EXISTS prendaxpromocion;
DROP TABLE IF EXISTS prendaseleccionada;
DROP TABLE IF EXISTS prenda;
DROP TABLE IF EXISTS promocion;
DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS boleta;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS comprobante;
DROP TABLE IF EXISTS ordencompra;
DROP TABLE IF EXISTS carrito;
DROP TABLE IF EXISTS administrador;
DROP TABLE IF EXISTS cupon;
DROP TABLE IF EXISTS trabajador;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS usuario;

-- ------------------------------------------------------------------------------------------
-- Paquete Usuarios
CREATE TABLE usuario(
	idUsuario INT AUTO_INCREMENT,
    dni VARCHAR(8),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    correo VARCHAR(50),
    contrasenha VARCHAR(50),
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE administrador(
	idAdministrador INT,
    fechaCreacion DATE,
    PRIMARY KEY(idAdministrador),
    FOREIGN KEY(idAdministrador) REFERENCES usuario(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE trabajador(
	idTrabajador INT,
    puesto VARCHAR(50),
    sueldo DECIMAL(10, 2),
    fechaIngreso DATE,
    horarioInicio TIME,
    horarioFin TIME,
    PRIMARY KEY(idTrabajador),
    FOREIGN KEY(idTrabajador) REFERENCES usuario(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE cliente(
	idCliente INT,
    telefono VARCHAR(20),
    fechaRegistro DATE,
    recibePromociones BOOLEAN,
    PRIMARY KEY(idCliente),
    FOREIGN KEY(idCliente) REFERENCES usuario(idUsuario)
)ENGINE = InnoDB;

CREATE TABLE direccion(
	idDireccion INT AUTO_INCREMENT,
    fidCliente INT,
    direccion VARCHAR(50),
    distrito VARCHAR(50),
    provincia VARCHAR(50),
    departamento VARCHAR(50),
    codigoPostal VARCHAR(50),
    referencia VARCHAR(150),
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idDireccion),
    FOREIGN KEY(fidCliente) REFERENCES cliente(idCliente)
)ENGINE = InnoDB;

CREATE TABLE cupon(
	idCupon INT AUTO_INCREMENT,
    fidTrabajador INT,
    codigo VARCHAR(10),
    descripcion VARCHAR(150),
    fechaInicio DATE,
    fechaFin DATE,
    activo BOOLEAN DEFAULT 1,
    PRIMARY KEY(idCupon),
    FOREIGN KEY(fidTrabajador) REFERENCES trabajador(idTrabajador)
)ENGINE = InnoDB;

CREATE TABLE clientexcupon(
	idCliente INT,
    idCupon INT,
    fechaAsignada DATE,
    usado BOOLEAN DEFAULT 0,
    PRIMARY KEY(idCliente, idCupon),
    FOREIGN KEY(idCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY(idCupon) REFERENCES cupon(idCupon)
)ENGINE = InnoDB;

-- ------------------------------------------------------------------------------------------
-- Paquete Prendas
CREATE TABLE prenda(
	idPrenda INT AUTO_INCREMENT,
	nombre VARCHAR(50),
	descripcion VARCHAR(150),
	tipo ENUM('Polo', 'Pantalon', 'Polera', 'Camisa', 'Casaca'),
	imagen VARCHAR(255),
	talla ENUM('XS', 'S', 'M', 'L', 'XL', 'XXL'),
	genero ENUM('Hombre', 'Mujer', 'Unisex'),
	color VARCHAR(50),
	precioOriginal DECIMAL(10, 2),
    precioDescontado DECIMAL(10, 2) DEFAULT 0.00,
	stock INT,
	cantVendida INT DEFAULT 0,
	activo BOOLEAN DEFAULT 1,
	PRIMARY KEY(idPrenda)
)ENGINE = InnoDB;

CREATE TABLE promocion(
	idPromocion INT AUTO_INCREMENT,
    fidTrabajador INT,
	nombre VARCHAR(50),
	descripcion VARCHAR(150),
    valorDescuento DECIMAL(10, 2),
    tipo ENUM('Porcentaje', 'MontoFijo'),
	fechaInicio DATE,
	fechaFin DATE,
	activo BOOLEAN DEFAULT 1,
	PRIMARY KEY(idPromocion),
    FOREIGN KEY(fidTrabajador) REFERENCES trabajador(idTrabajador)
)ENGINE = InnoDB;

CREATE TABLE prendaxpromocion(
	idPrenda INT,
    idPromocion INT,
    fechaAsignada DATE,
    activo BOOLEAN,
    PRIMARY KEY(idPrenda, idPromocion),
    FOREIGN KEY(idPrenda) REFERENCES prenda(idPrenda),
    FOREIGN KEY(idPromocion) REFERENCES promocion(idPromocion)
)ENGINE = InnoDB;

-- ------------------------------------------------------------------------------------------
-- Paquete Compras
CREATE TABLE carrito(
	idCarrito INT AUTO_INCREMENT,
    fidCliente INT,
    cantidadTotal INT DEFAULT 0,
    precioTotal DECIMAL(10, 2) DEFAULT 0.00,
    PRIMARY KEY(idCarrito),
    FOREIGN KEY(fidCliente) REFERENCES cliente(idCliente)
)ENGINE = InnoDB;

CREATE TABLE prendaseleccionada(
	idPrendaSeleccionada INT,
    fidCarrito INT,
	cantidad INT,
    precio DECIMAL(10, 2),
    PRIMARY KEY(idPrendaSeleccionada),
    FOREIGN KEY(idPrendaSeleccionada) REFERENCES prenda(idPrenda),
    FOREIGN KEY(fidCarrito) REFERENCES carrito(idCarrito)
)ENGINE = InnoDB;

CREATE TABLE ordencompra(
	idOrden INT AUTO_INCREMENT,
    fidCliente INT,
    fidCupon INT,
    fidCarrito INT,
    fechaRegistro DATE,
    fechaProcesado DATE DEFAULT NULL,
    fechaEntregado DATE,
    fechaAnulado DATE,
    estado ENUM('Registrado', 'Procesado', 'Entregado', 'Anulado') DEFAULT 'Registrado',
    dni VARCHAR(8),
    correo VARCHAR(50),
    subtotal DECIMAL(10, 2),
    PRIMARY KEY(idOrden),
    FOREIGN KEY(fidCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY(fidCupon) REFERENCES cupon(idCupon),
    FOREIGN KEY(fidCarrito) REFERENCES carrito(idCarrito)
)ENGINE = InnoDB;

CREATE TABLE prendaseleccionadaxorden(
	idPrendaSeleccionada INT,
    idOrden INT,
    PRIMARY KEY(idPrendaSeleccionada, idOrden),
    FOREIGN KEY(idPrendaSeleccionada) REFERENCES prendaseleccionada(idPrendaSeleccionada),
    FOREIGN KEY(idOrden) REFERENCES ordencompra(idOrden)
)ENGINE = InnoDB;

CREATE TABLE comprobante(
	idComprobante INT AUTO_INCREMENT,
    fidOrden INT,
    totalPagar DECIMAL(10, 2),
    PRIMARY KEY(idComprobante),
    FOREIGN KEY(fidOrden) REFERENCES ordencompra(idOrden)
)ENGINE = InnoDB;

CREATE TABLE boleta(
	idBoleta INT,
    dni VARCHAR(8),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    PRIMARY KEY(idBoleta),
    FOREIGN KEY(idBoleta) REFERENCES comprobante(idComprobante)
)ENGINE = InnoDB;

CREATE TABLE factura(
	idFactura INT,
    ruc VARCHAR(11),
    razonSocial VARCHAR(50),
    repreLegal VARCHAR(50),
    PRIMARY KEY(idFactura),
    FOREIGN KEY(idFactura) REFERENCES comprobante(idComprobante)
)ENGINE = InnoDB;


-- ------------------------------------------------------------------------------------------
-- Drop de procedimientos almacenados
DROP PROCEDURE IF EXISTS INSERTAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS MODIFICAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS ELIMINAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS LISTAR_ADMINISTRADORES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_ADMINISTRADOR_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS MODIFICAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS ELIMINAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS LISTAR_TRABAJADORES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_TRABAJADOR_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS MODIFICAR_CLIENTE;
DROP PROCEDURE IF EXISTS ELIMINAR_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTE_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_DIRECCION;
DROP PROCEDURE IF EXISTS MODIFICAR_DIRECCION;
DROP PROCEDURE IF EXISTS ELIMINAR_DIRECCION;
DROP PROCEDURE IF EXISTS LISTAR_DIRECCIONES_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_DIRECCION_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CUPON;
DROP PROCEDURE IF EXISTS MODIFICAR_CUPON;
DROP PROCEDURE IF EXISTS ELIMINAR_CUPON;
DROP PROCEDURE IF EXISTS LISTAR_CUPONES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_CUPON_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE_X_CUPON;

DROP PROCEDURE IF EXISTS INSERTAR_PRENDA;
DROP PROCEDURE IF EXISTS MODIFICAR_PRENDA;
DROP PROCEDURE IF EXISTS ELIMINAR_PRENDA;
DROP PROCEDURE IF EXISTS LISTAR_PRENDAS_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_PRENDA_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_PROMOCION;
DROP PROCEDURE IF EXISTS MODIFICAR_PROMOCION;
DROP PROCEDURE IF EXISTS ELIMINAR_PROMOCION;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCIONES_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCION_X_ID;

DROP PROCEDURE IF EXISTS VERIFICAR_INGRESO_USUARIO;
DROP PROCEDURE IF EXISTS OBTENER_ROL_USUARIO;
-- ------------------------------------------------------------------------------------------
-- Procedimientos almacenados del paquete Usuarios
DELIMITER $
CREATE PROCEDURE INSERTAR_ADMINISTRADOR(
    OUT _idAdministrador INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _fechaCreacion DATE
)
BEGIN
    INSERT INTO usuario(dni, nombres, apellidos, correo, contrasenha, activo) VALUES (_dni, _nombres, _apellidos, _correo, MD5(_contrasenha), 1);
    SET _idAdministrador = @@last_insert_id;
    INSERT INTO administrador(idAdministrador, fechaCreacion) VALUES (_idAdministrador, _fechaCreacion);
END$
CREATE PROCEDURE MODIFICAR_ADMINISTRADOR(
	IN _idAdministrador INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _fechaCreacion DATE
)
BEGIN
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo, contrasenha = MD5(_contrasenha) WHERE idUsuario = _idAdministrador;
    UPDATE administrador SET fechaCreacion = _fechaCreacion WHERE idAdministrador = _idAdministrador;
END$
CREATE PROCEDURE ELIMINAR_ADMINISTRADOR(
	IN _idAdministrador INT
)
BEGIN
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idAdministrador;
END$
CREATE PROCEDURE LISTAR_ADMINISTRADORES_TODOS()
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, a.fechaCreacion FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE u.activo = 1;
END$
CREATE PROCEDURE LISTAR_ADMINISTRADOR_X_ID(
	IN _idAdministrador INT
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, a.fechaCreacion FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE a.idAdministrador = _idAdministrador AND u.activo = 1;
END$


CREATE PROCEDURE INSERTAR_TRABAJADOR(
    OUT _idTrabajador INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _puesto VARCHAR(50),
    IN _sueldo DECIMAL(10, 2),
    IN _fechaIngreso DATE,
    IN _horarioInicio TIME,
    IN _horarioFin TIME
)
BEGIN
    INSERT INTO usuario(dni, nombres, apellidos, correo, contrasenha, activo) VALUES (_dni, _nombres, _apellidos, _correo, MD5(_contrasenha), 1);
    SET _idTrabajador = @@last_insert_id;
    INSERT INTO trabajador(idTrabajador, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin) VALUES (_idTrabajador, _puesto, _sueldo, _fechaIngreso, _horarioInicio, _horarioFin);
END$
CREATE PROCEDURE MODIFICAR_TRABAJADOR(
	IN _idTrabajador INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _puesto VARCHAR(50),
    IN _sueldo DECIMAL(10, 2),
    IN _fechaIngreso DATE,
    IN _horarioInicio TIME,
    IN _horarioFin TIME
)
BEGIN
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo, contrasenha = MD5(_contrasenha) WHERE idUsuario = _idTrabajador;
    UPDATE trabajador SET puesto = _puesto, sueldo = _sueldo, fechaIngreso = _fechaIngreso, horarioInicio = _horarioInicio, horarioFin = _horarioFin WHERE idTrabajador = _idTrabajador;
END$
CREATE PROCEDURE ELIMINAR_TRABAJADOR(
	IN _idTrabajador INT
)
BEGIN
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idTrabajador;
END$
CREATE PROCEDURE LISTAR_TRABAJADORES_TODOS()
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, t.puesto, t.sueldo, t.fechaIngreso, t.horarioInicio, t.horarioFin FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE u.activo = 1;
END$
CREATE PROCEDURE LISTAR_TRABAJADOR_X_ID(
	IN _idTrabajador INT
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, t.puesto, t.sueldo, t.fechaIngreso, t.horarioInicio, t.horarioFin FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE t.idTrabajador = _idTrabajador AND u.activo = 1;
END$


CREATE PROCEDURE INSERTAR_CLIENTE(
    OUT _idCliente INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _telefono VARCHAR(20),
    IN _fechaRegistro DATE,
    IN _recibePromociones BOOLEAN
)
BEGIN
    INSERT INTO usuario(dni, nombres, apellidos, correo, contrasenha, activo) VALUES (_dni, _nombres, _apellidos, _correo, MD5(_contrasenha), 1);
    SET _idCliente = @@last_insert_id;
    INSERT INTO cliente(idCliente, telefono, fechaRegistro, recibePromociones) VALUES (_idCliente, _telefono, _fechaRegistro, _recibePromociones);
    
    INSERT INTO carrito(fidCliente, cantidadTotal, precioTotal) VALUES (_idCliente, 0, 0.00);
END$
CREATE PROCEDURE MODIFICAR_CLIENTE(
	IN _idCliente INT,
    IN _dni VARCHAR(8),
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50),
    IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50),
    IN _telefono VARCHAR(20),
    IN _fechaRegistro DATE,
    IN _recibePromociones BOOLEAN
)
BEGIN
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo, contrasenha = MD5(_contrasenha) WHERE idUsuario = _idCliente;
    UPDATE cliente SET telefono = _telefono, fechaRegistro = _fechaRegistro, recibePromociones = _recibePromociones WHERE idCliente = _idCliente;
END$
CREATE PROCEDURE ELIMINAR_CLIENTE(
	IN _idCliente INT
)
BEGIN
	UPDATE usuario SET activo = 0 WHERE idUsuario = _idCliente;
END$
CREATE PROCEDURE LISTAR_CLIENTES_TODOS()
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, c.telefono, c.fechaRegistro, c.recibePromociones FROM usuario u INNER JOIN cliente c ON u.idUsuario = c.idCliente WHERE u.activo = 1;
END$
CREATE PROCEDURE LISTAR_CLIENTE_X_ID(
	IN _idCliente INT
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, c.telefono, c.fechaRegistro, c.recibePromociones FROM usuario u INNER JOIN cliente c ON u.idUsuario = c.idCliente WHERE c.idCliente = _idCliente AND u.activo = 1;
END$


CREATE PROCEDURE INSERTAR_DIRECCION(
    OUT _idDireccion INT,
    IN _fidCliente INT,
    IN _direccion VARCHAR(50),
    IN _distrito VARCHAR(50),
    IN _provincia VARCHAR(50),
    IN _departamento VARCHAR(50),
    IN _codigoPostal VARCHAR(50),
    IN _referencia VARCHAR(150)
)
BEGIN
    INSERT INTO direccion(fidCliente, direccion, distrito, provincia, departamento, codigoPostal, referencia, activo) VALUES (_fidCliente, _direccion, _distrito, _provincia, _departamento, _codigoPostal, _referencia, 1);
    SET _idDireccion = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_DIRECCION(
	IN _idDireccion INT,
    IN _direccion VARCHAR(50),
    IN _distrito VARCHAR(50),
    IN _provincia VARCHAR(50),
    IN _departamento VARCHAR(50),
    IN _codigoPostal VARCHAR(50),
    IN _referencia VARCHAR(150)
)
BEGIN
	UPDATE direccion SET direccion = _direccion, distrito = _distrito, provincia = _provincia, departamento = _departamento, codigoPostal = _codigoPostal, referencia = _referencia WHERE idDireccion = _idDireccion;
END$
CREATE PROCEDURE ELIMINAR_DIRECCION(
	IN _idDireccion INT
)
BEGIN
	UPDATE direccion SET activo = 0 WHERE idDireccion = _idDireccion;
END$
CREATE PROCEDURE LISTAR_DIRECCIONES_TODAS()
BEGIN
	SELECT idDireccion, fidCliente, direccion, distrito, provincia, departamento, codigoPostal, referencia FROM direccion WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_DIRECCION_X_ID(
	IN _idDireccion INT
)
BEGIN
	SELECT idDireccion, fidCliente, direccion, distrito, provincia, departamento, codigoPostal, referencia FROM direccion WHERE idDireccion = _idDireccion AND activo = 1;
END$


CREATE PROCEDURE INSERTAR_CUPON(
    OUT _idCupon INT,
    IN _fidTrabajador INT,
    IN _codigo VARCHAR(10),
    IN _descripcion VARCHAR(150),
    IN _fechaInicio DATE,
    IN _fechaFin DATE
)
BEGIN
    INSERT INTO cupon(fidTrabajador, codigo, descripcion, fechaInicio, fechaFin, activo) VALUES (_fidTrabajador, _codigo, _descripcion, _fechaInicio, _fechaFin, 1);
    SET _idCupon = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_CUPON(
	IN _idCupon INT,
    IN _codigo VARCHAR(10),
    IN _descripcion VARCHAR(150),
    IN _fechaInicio DATE,
    IN _fechaFin DATE
)
BEGIN
	UPDATE cupon SET codigo = _codigo, descripcion = _descripcion, fechaInicio = _fechaInicio, fechaFin = _fechaFin WHERE idCupon = _idCupon;
END$
CREATE PROCEDURE ELIMINAR_CUPON(
	IN _idCupon INT
)
BEGIN
	UPDATE cupon SET activo = 0 WHERE idCupon = _idCupon;
END$
CREATE PROCEDURE LISTAR_CUPONES_TODOS()
BEGIN
	SELECT idCupon, fidTrabajador, codigo, descripcion, fechaInicio, fechaFin FROM cupon WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_CUPON_X_ID(
	IN _idCupon INT
)
BEGIN
	SELECT idCupon, fidTrabajador, codigo, descripcion, fechaInicio, fechaFin FROM cupon WHERE idCupon = _idCupon AND activo = 1;
END$


CREATE PROCEDURE INSERTAR_CLIENTE_X_CUPON(
    IN _idCliente INT,
    IN _idCupon INT,
    IN _fechaAsignada DATE
)
BEGIN
    INSERT INTO clientexcupon(idCliente, idCupon, fechaAsignada, usado) VALUES (_idCliente, _idCupon, _fechaAsignada, 0);
END$

-- ------------------------------------------------------------------------------------------
-- Procedimientos almacenados del paquete Prendas
CREATE PROCEDURE INSERTAR_PRENDA(
	OUT _idPrenda INT,
    IN _nombre VARCHAR(50),
	IN _descripcion VARCHAR(150),
	IN _tipo ENUM('Polo', 'Pantalon', 'Polera', 'Camisa', 'Casaca'),
	IN _imagen VARCHAR(255),
	IN _talla ENUM('XS', 'S', 'M', 'L', 'XL', 'XXL'),
	IN _genero ENUM('Hombre', 'Mujer', 'Unisex'),
	IN _color VARCHAR(50),
	IN _precioOriginal DECIMAL(10, 2),
	IN _stock INT
)
BEGIN
    INSERT INTO prenda(nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, precioDescontado, stock, cantVendida, activo) VALUES (_nombre, _descripcion, _tipo, _imagen, _talla, _genero, _color, _precioOriginal, 0.00, _stock, 0, 1);
    SET _idPrenda = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_PRENDA(
	IN _idPrenda INT,
    IN _nombre VARCHAR(50),
	IN _descripcion VARCHAR(150),
	IN _tipo ENUM('Polo', 'Pantalon', 'Polera', 'Camisa', 'Casaca'),
	IN _imagen VARCHAR(255),
	IN _talla ENUM('XS', 'S', 'M', 'L', 'XL', 'XXL'),
	IN _genero ENUM('Hombre', 'Mujer', 'Unisex'),
	IN _color VARCHAR(50),
	IN _precioOriginal DECIMAL(10, 2),
	IN _stock INT
)
BEGIN
	UPDATE prenda SET nombre = _nombre, descripcion = _descripcion, tipo = _tipo, imagen = _imagen, talla = _talla, genero = _genero, color = _color, precioOriginal = _precioOriginal, stock = _stock WHERE idPrenda = _idPrenda;
END$
CREATE PROCEDURE ELIMINAR_PRENDA(
	IN _idPrenda INT
)
BEGIN
	UPDATE prenda SET activo = 0 WHERE idPrenda = _idPrenda;
END$
CREATE PROCEDURE LISTAR_PRENDAS_TODAS()
BEGIN
	SELECT idPrenda, nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, precioDescontado, stock, cantVendida FROM prenda WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_PRENDA_X_ID(
	IN _idPrenda INT
)
BEGIN
	SELECT idPrenda, nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, precioDescontado, stock, cantVendida FROM prenda WHERE idPrenda = _idPrenda AND activo = 1;
END$


CREATE PROCEDURE INSERTAR_PROMOCION(
    OUT _idPromocion INT,
    IN _fidTrabajador INT,
    IN _idPrenda INT,
	IN _nombre VARCHAR(50),
	IN _descripcion VARCHAR(150),
    IN _valorDescuento DECIMAL(10, 2),
    IN _tipo ENUM('Porcentaje', 'MontoFijo'),
	IN _fechaInicio DATE,
	IN _fechaFin DATE
)
BEGIN
	DECLARE _precioOriginal DECIMAL(10, 2);
    DECLARE _precioDescontado DECIMAL(10, 2);

    INSERT INTO promocion(fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, activo) VALUES (_fidTrabajador, _nombre, _descripcion, _valorDescuento, _tipo, _fechaInicio, _fechaFin, 1);
    SET _idPromocion = @@last_insert_id;
    INSERT INTO prendaxpromocion(idPrenda, idPromocion, fechaAsignada, activo) VALUES (_idPrenda, _idPromocion, _fechaInicio, 1);
    
    SELECT precioOriginal INTO _precioOriginal FROM prenda WHERE idPrenda = _idPrenda;
    
    IF _tipo = 'Porcentaje' THEN
        SET _precioDescontado = _precioOriginal - (_precioOriginal * _valorDescuento / 100);
    ELSEIF _tipo = 'MontoFijo' THEN
        SET _precioDescontado = _precioOriginal - _valorDescuento;
    END IF;
    
    UPDATE prenda SET precioDescontado = _precioDescontado WHERE idPrenda = _idPrenda;
END$
CREATE PROCEDURE MODIFICAR_PROMOCION(
	IN _idPromocion INT,
	IN _nombre VARCHAR(50),
	IN _descripcion VARCHAR(150),
    IN _valorDescuento DECIMAL(10, 2),
    IN _tipo ENUM('Porcentaje', 'MontoFijo'),
	IN _fechaInicio DATE,
	IN _fechaFin DATE
)
BEGIN
	UPDATE promocion SET nombre = _nombre, descripcion = _descripcion, valorDescuento = _valorDescuento, tipo = _tipo, fechaInicio = _fechaInicio, fechaFin = _fechaFin WHERE idPromocion = _idPromocion;
END$
CREATE PROCEDURE ELIMINAR_PROMOCION(
	IN _idPromocion INT
)
BEGIN
	UPDATE promocion SET activo = 0 WHERE idPromocion = _idPromocion;
END$
CREATE PROCEDURE LISTAR_PROMOCIONES_TODAS()
BEGIN
	SELECT idPromocion, fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin FROM promocion WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_PROMOCION_X_ID(
	IN _idPromocion INT
)
BEGIN
	SELECT idPromocion, fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin FROM promocion WHERE idPromocion = _idPromocion AND activo = 1;
END$

DELIMITER $
CREATE PROCEDURE VERIFICAR_INGRESO_USUARIO(
	IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50)
)
BEGIN
	DECLARE _idUsuario INT;

    -- Obtener idUsuario si cumple con las credenciales y está activo
    SELECT idUsuario INTO _idUsuario FROM usuario WHERE correo = _correo AND contrasenha = MD5(_contrasenha) AND activo = 1;
    
    -- Verificar si el idUsuario está en la tabla trabajador
    IF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM trabajador WHERE idTrabajador = _idUsuario) THEN
        SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, t.puesto, t.sueldo, t.fechaIngreso, t.horarioInicio, t.horarioFin FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE t.idTrabajador = _idUsuario AND u.activo = 1;

    -- Verificar si el idUsuario está en la tabla administrador
    ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM administrador WHERE idAdministrador = _idUsuario) THEN
        SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, a.fechaCreacion FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE a.idAdministrador = _idUsuario AND u.activo = 1;

    -- En caso de que sea cliente o usuario no encontrado
    ELSE
        SELECT 0 AS idUsuario;
    END IF;
END$

CREATE PROCEDURE OBTENER_ROL_USUARIO(
	IN _correo VARCHAR(50),
    IN _contrasenha VARCHAR(50)
)
BEGIN
	DECLARE _idUsuario INT;

    -- Obtener idUsuario si cumple con las credenciales y está activo
    SELECT idUsuario INTO _idUsuario FROM usuario WHERE correo = _correo AND contrasenha = MD5(_contrasenha) AND activo = 1;
    
    -- Verificar si el idUsuario está en la tabla trabajador
    IF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM trabajador WHERE idTrabajador = _idUsuario) THEN
        SELECT 'Trabajador' as rol FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE t.idTrabajador = _idUsuario AND u.activo = 1;

    -- Verificar si el idUsuario está en la tabla administrador
    ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM administrador WHERE idAdministrador = _idUsuario) THEN
        SELECT 'Administrador' as rol FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE a.idAdministrador = _idUsuario AND u.activo = 1;

    -- En caso de que sea cliente o usuario no encontrado
    ELSE
        SELECT 'Denegado' AS rol;
    END IF;
END$