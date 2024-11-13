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
	valorDescuento DECIMAL(10, 2),
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
	imagen LONGBLOB,
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
    PRIMARY KEY(idPrendaSeleccionada, fidCarrito),
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
DROP PROCEDURE IF EXISTS MODIFICAR_USUARIO;
DROP PROCEDURE IF EXISTS VERIFICAR_INGRESO_USUARIO;
DROP PROCEDURE IF EXISTS OBTENER_ROL_USUARIO;
DROP PROCEDURE IF EXISTS VERIFICAR_CONTRASENHA;
DROP PROCEDURE IF EXISTS CAMBIAR_CONTRASENHA;
DROP PROCEDURE IF EXISTS RESETEAR_CONTRASENHA;

DROP PROCEDURE IF EXISTS INSERTAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS MODIFICAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS ELIMINAR_ADMINISTRADOR;
DROP PROCEDURE IF EXISTS LISTAR_ADMINISTRADORES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_ADMINISTRADORES_X_DNI_O_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_ADMINISTRADOR_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS MODIFICAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS ELIMINAR_TRABAJADOR;
DROP PROCEDURE IF EXISTS LISTAR_TRABAJADORES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_TRABAJADORES_X_DNI_O_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_TRABAJADOR_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS MODIFICAR_CLIENTE;
DROP PROCEDURE IF EXISTS ELIMINAR_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_X_DNI_O_NOMBRE;
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
DROP PROCEDURE IF EXISTS LISTAR_CUPONES_X_CODIGO_O_DESCRIPCION;
DROP PROCEDURE IF EXISTS LISTAR_CUPON_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE_X_CUPON;

DROP PROCEDURE IF EXISTS INSERTAR_PRENDA;
DROP PROCEDURE IF EXISTS MODIFICAR_PRENDA;
DROP PROCEDURE IF EXISTS ELIMINAR_PRENDA;
DROP PROCEDURE IF EXISTS LISTAR_PRENDAS_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_PRENDAS_X_NOMBRE_O_DESCRIPCION;
DROP PROCEDURE IF EXISTS LISTAR_PRENDAS_FILTRADAS;
DROP PROCEDURE IF EXISTS LISTAR_PRENDA_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_PROMOCION;
DROP PROCEDURE IF EXISTS MODIFICAR_PROMOCION;
DROP PROCEDURE IF EXISTS ELIMINAR_PROMOCION;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCIONES_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCIONES_X_NOMBRE_O_DESCRIPCION;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCION_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_PRENDA_X_PROMOCION;
DROP PROCEDURE IF EXISTS LISTAR_PRENDAS_X_PROMOCION;

DROP PROCEDURE IF EXISTS INSERTAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS MODIFICAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS ELIMINAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS LISTAR_ORDENESCOMPRA_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_ORDENESCOMPRA_X_ESTADO;
DROP PROCEDURE IF EXISTS LISTAR_ORDENCOMPRA_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CARRITO;
DROP PROCEDURE IF EXISTS MODIFICAR_CARRITO;
DROP PROCEDURE IF EXISTS LISTAR_CARRITO_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_PRENDASELECCIONADA;
DROP PROCEDURE IF EXISTS MODIFICAR_PRENDASELECCIONADA;
DROP PROCEDURE IF EXISTS ELIMINAR_PRENDASELECCIONADA;
DROP PROCEDURE IF EXISTS LISTAR_PRENDASELECCIONADA_X_ID;


-- ------------------------------------------------------------------------------------------
-- Procedimientos almacenados del paquete Usuarios
DELIMITER $
CREATE PROCEDURE MODIFICAR_USUARIO(
	IN _idUsuario INT,
    IN _nombres VARCHAR(50),
    IN _apellidos VARCHAR(50)
)
BEGIN
	UPDATE usuario SET nombres = _nombres, apellidos = _apellidos WHERE idUsuario = _idUsuario;
END$
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
        SELECT u.idUsuario FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE t.idTrabajador = _idUsuario AND u.activo = 1;

    -- Verificar si el idUsuario está en la tabla administrador
    ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM administrador WHERE idAdministrador = _idUsuario) THEN
        SELECT u.idUsuario FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE a.idAdministrador = _idUsuario AND u.activo = 1;

    -- En caso de que sea cliente 
    ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM cliente WHERE idCliente = _idUsuario) THEN
        SELECT u.idUsuario FROM usuario u INNER JOIN cliente c ON u.idUsuario = c.idCliente WHERE c.idCliente = _idUsuario AND u.activo = 1;
    
    -- En caso hayan puesto mal sus credenciales
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
        SELECT 'trabajador' as rol FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE t.idTrabajador = _idUsuario AND u.activo = 1;

    -- Verificar si el idUsuario está en la tabla administrador
    ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM administrador WHERE idAdministrador = _idUsuario) THEN
        SELECT 'administrador' as rol FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE a.idAdministrador = _idUsuario AND u.activo = 1;

    -- En caso de que sea cliente
	ELSEIF _idUsuario IS NOT NULL AND EXISTS (SELECT 1 FROM cliente WHERE idCliente = _idUsuario) THEN
        SELECT 'cliente' as rol FROM usuario u INNER JOIN cliente c ON u.idUsuario = c.idCliente WHERE c.idCliente = _idUsuario AND u.activo = 1;
	
	-- En caso el usuario no se encuentre
    ELSE
        SELECT 'denegado' AS rol;
    END IF;
END$
CREATE PROCEDURE VERIFICAR_CONTRASENHA(
	IN _idUsuario INT,
    IN _contrasenha VARCHAR(50)
)
BEGIN
	SELECT 1 AS resultado FROM usuario WHERE idUsuario = _idUsuario AND contrasenha = MD5(_contrasenha) AND activo = 1;
END$
CREATE PROCEDURE CAMBIAR_CONTRASENHA(
	IN _idUsuario INT,
    IN _contrasenhaNueva VARCHAR(50)
)
BEGIN
	UPDATE usuario SET contrasenha = MD5(_contrasenhaNueva) WHERE idUsuario = _idUsuario AND activo = 1;
END$
CREATE PROCEDURE RESETEAR_CONTRASENHA(
	IN _idUsuario INT
)
BEGIN
	UPDATE usuario SET contrasenha = MD5('RHStore2024') WHERE idUsuario = _idUsuario;
END$

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
    IN _fechaCreacion DATE
)
BEGIN
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo WHERE idUsuario = _idAdministrador;
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
CREATE PROCEDURE LISTAR_ADMINISTRADORES_X_DNI_O_NOMBRE(
	IN _nombre VARCHAR(50)
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, a.fechaCreacion FROM usuario u INNER JOIN administrador a ON u.idUsuario = a.idAdministrador WHERE u.activo = 1 AND (CONCAT(u.nombres, ' ', u.apellidos) LIKE CONCAT('%', _nombre, '%') OR u.dni LIKE CONCAT('%', _nombre, '%'));
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
    IN _puesto VARCHAR(50),
    IN _sueldo DECIMAL(10, 2),
    IN _fechaIngreso DATE,
    IN _horarioInicio TIME,
    IN _horarioFin TIME
)
BEGIN
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo WHERE idUsuario = _idTrabajador;
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
CREATE PROCEDURE LISTAR_TRABAJADORES_X_DNI_O_NOMBRE(
	IN _nombre VARCHAR(50)
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, t.puesto, t.sueldo, t.fechaIngreso, t.horarioInicio, t.horarioFin FROM usuario u INNER JOIN trabajador t ON u.idUsuario = t.idTrabajador WHERE u.activo = 1 AND (CONCAT(u.nombres, ' ', u.apellidos) LIKE CONCAT('%', _nombre, '%') OR u.dni LIKE CONCAT('%', _nombre, '%'));
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
	UPDATE usuario SET dni = _dni, nombres = _nombres, apellidos = _apellidos, correo = _correo WHERE idUsuario = _idCliente;
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
CREATE PROCEDURE LISTAR_CLIENTES_X_DNI_O_NOMBRE(
	IN _nombre VARCHAR(50)
)
BEGIN
	SELECT u.idUsuario, u.dni, u.nombres, u.apellidos, u.correo, u.contrasenha, c.telefono, c.fechaRegistro, c.recibePromociones FROM usuario u INNER JOIN cliente c ON u.idUsuario = c.idCliente WHERE u.activo = 1 AND (CONCAT(u.nombres, ' ', u.apellidos) LIKE CONCAT('%', _nombre, '%') OR u.dni LIKE CONCAT('%', _nombre, '%'));
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
	IN _valorDescuento DECIMAL(10, 2),
    IN _fechaInicio DATE,
    IN _fechaFin DATE
)
BEGIN
    INSERT INTO cupon(fidTrabajador, codigo, descripcion, valorDescuento, fechaInicio, fechaFin, activo) VALUES (_fidTrabajador, _codigo, _descripcion, _valorDescuento, _fechaInicio, _fechaFin, 1);
    SET _idCupon = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_CUPON(
	IN _idCupon INT,
    IN _codigo VARCHAR(10),
    IN _descripcion VARCHAR(150),
	IN _valorDescuento DECIMAL(10, 2),
    IN _fechaInicio DATE,
    IN _fechaFin DATE
)
BEGIN
	UPDATE cupon SET codigo = _codigo, descripcion = _descripcion, valorDescuento = _valorDescuento, fechaInicio = _fechaInicio, fechaFin = _fechaFin WHERE idCupon = _idCupon;
END$
CREATE PROCEDURE ELIMINAR_CUPON(
	IN _idCupon INT
)
BEGIN
	UPDATE cupon SET activo = 0 WHERE idCupon = _idCupon;
END$
CREATE PROCEDURE LISTAR_CUPONES_TODOS()
BEGIN
	SELECT idCupon, fidTrabajador, codigo, descripcion, valorDescuento, fechaInicio, fechaFin FROM cupon WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_CUPONES_X_CODIGO_O_DESCRIPCION(
	IN _codigo VARCHAR(50)
)
BEGIN
	SELECT idCupon, fidTrabajador, codigo, descripcion, valorDescuento, fechaInicio, fechaFin FROM cupon WHERE activo = 1 AND (codigo LIKE CONCAT('%', _codigo, '%') OR descripcion LIKE CONCAT('%', _codigo, '%'));
END$
CREATE PROCEDURE LISTAR_CUPON_X_ID(
	IN _idCupon INT
)
BEGIN
	SELECT idCupon, fidTrabajador, codigo, descripcion, valorDescuento, fechaInicio, fechaFin FROM cupon WHERE idCupon = _idCupon AND activo = 1;
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
	IN _imagen LONGBLOB,
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
	IN _imagen LONGBLOB,
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
CREATE PROCEDURE LISTAR_PRENDAS_X_NOMBRE_O_DESCRIPCION(
	IN _nombre VARCHAR(50)
)
BEGIN
	SELECT idPrenda, nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, precioDescontado, stock, cantVendida FROM prenda WHERE activo = 1 AND (nombre LIKE CONCAT('%', _nombre, '%') OR descripcion LIKE CONCAT('%', _nombre, '%'));
END$
CREATE PROCEDURE LISTAR_PRENDAS_FILTRADAS (
    IN _minPrice DECIMAL(10, 2),
    IN _maxPrice DECIMAL(10, 2),
    IN _filterHombre BOOLEAN,
    IN _filterMujer BOOLEAN,
    IN _filterUnisex BOOLEAN,
    IN _tallas VARCHAR(255),
    IN _colores VARCHAR(255)
)
BEGIN
    SET @sql = CONCAT('SELECT * FROM prenda WHERE precioOriginal BETWEEN ', _minPrice, ' AND ', _maxPrice, ' AND activo = 1');

    IF _filterHombre THEN
        SET @sql = CONCAT(@sql, ' AND genero = ''Hombre''');
    END IF;

    IF _filterMujer THEN
        SET @sql = CONCAT(@sql, ' AND genero = ''Mujer''');
    END IF;

    IF _filterUnisex THEN
        SET @sql = CONCAT(@sql, ' AND genero = ''Unisex''');
    END IF;

    IF _tallas <> '' THEN
        SET @sql = CONCAT(@sql, ' AND FIND_IN_SET(talla, ''', _tallas, ''') > 0');
    END IF;

    IF _colores <> '' THEN
        SET @sql = CONCAT(@sql, ' AND FIND_IN_SET(color, ''', _colores, ''') > 0');
    END IF;

    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
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
	IN _nombre VARCHAR(50),
	IN _descripcion VARCHAR(150),
    IN _valorDescuento DECIMAL(10, 2),
    IN _tipo ENUM('Porcentaje', 'MontoFijo'),
	IN _fechaInicio DATE,
	IN _fechaFin DATE
)
BEGIN
    INSERT INTO promocion(fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, activo) VALUES (_fidTrabajador, _nombre, _descripcion, _valorDescuento, _tipo, _fechaInicio, _fechaFin, 1);
    SET _idPromocion = @@last_insert_id;
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
CREATE PROCEDURE LISTAR_PROMOCIONES_X_NOMBRE_O_DESCRIPCION(
	IN _nombre VARCHAR(50)
)
BEGIN
	SELECT idPromocion, fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin FROM promocion WHERE activo = 1 AND (nombre LIKE CONCAT('%', _nombre, '%') OR descripcion LIKE CONCAT('%', _nombre, '%'));
END$
CREATE PROCEDURE LISTAR_PROMOCION_X_ID(
	IN _idPromocion INT
)
BEGIN
	SELECT idPromocion, fidTrabajador, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin FROM promocion WHERE idPromocion = _idPromocion AND activo = 1;
END$

CREATE PROCEDURE INSERTAR_PRENDA_X_PROMOCION(
    IN _idPrenda INT,
    IN _idPromocion INT,
    IN _fechaAsignada DATE
)
BEGIN
	DECLARE _precioOriginal DECIMAL(10, 2);
    DECLARE _precioDescontado DECIMAL(10, 2);
    DECLARE _tipo ENUM('Porcentaje', 'MontoFijo');
    
    INSERT INTO prendaxpromocion(idPrenda, idPromocion, fechaAsignada, activo) VALUES (_idPrenda, _idPromocion, _fechaAsignada, 0);
    
    SELECT precioOriginal INTO _precioOriginal FROM prenda WHERE idPrenda = _idPrenda;
    SELECT tipo INTO _tipo FROM promocion WHERE idPromocion = _idPromocion;
    
    IF _tipo = 'Porcentaje' THEN
        SET _precioDescontado = _precioOriginal - (_precioOriginal * _valorDescuento / 100);
    ELSEIF _tipo = 'MontoFijo' THEN
        SET _precioDescontado = _precioOriginal - _valorDescuento;
    END IF;
    
    UPDATE prenda SET precioDescontado = _precioDescontado WHERE idPrenda = _idPrenda;
END$
CREATE PROCEDURE LISTAR_PRENDAS_X_PROMOCION(
	IN _idPromocion INT
)
BEGIN
	SELECT idPrenda, fechaAsignada FROM prendaxpromocion WHERE idPromocion = _idPromocion AND activo = 1;
END$

-- ------------------------------------------------------------------------------------------
-- Procedimientos almacenados del paquete Compras
CREATE PROCEDURE INSERTAR_ORDENCOMPRA(
    OUT _idOrden INT,
    IN _fidCliente INT,
    IN _fechaRegistro DATE,
    IN _fechaProcesado DATE,
    IN _fechaEntregado DATE,
    IN _fechaAnulado DATE,
    IN _estado ENUM('Registrado', 'Procesado', 'Entregado', 'Anulado'),
    IN _dni VARCHAR(8),
    IN _correo VARCHAR(50),
    IN _subtotal DECIMAL(10, 2)
)
BEGIN
    INSERT INTO ordencompra(fidCliente,fechaRegistro,fechaProcesado,fechaEntregado,fechaAnulado,estado,dni,correo,subtotal) VALUES (_fidCliente_fechaRegistro,_fechaProcesado,_fechaEntregado,_fechaAnulado,_estado,_dni,_correo,_subtotal);
    SET _idOrden = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_ORDENCOMPRA(
	IN _idOrden INT,
    IN _fechaRegistro DATE,
    IN _fechaProcesado DATE,
    IN _fechaEntregado DATE,
    IN _fechaAnulado DATE,
    IN _estado ENUM('Registrado', 'Procesado', 'Entregado', 'Anulado'),
    IN _dni VARCHAR(8),
    IN _correo VARCHAR(50),
    IN _subtotal DECIMAL(10, 2)
)
BEGIN
	UPDATE ordencompra SET fechaRegistro = _fechaRegistro, fechaProcesado = _fechaProcesado, fechaEntregado = _fechaEntregado, fechaAnulado = _fechaAnulado, estado = _estado, dni = _dni , correo = _correo, subtotal = _subtotal WHERE idOrden = _idOrden;
END$
CREATE PROCEDURE ELIMINAR_ORDENCOMPRA(
    IN _idOrden INT
)
BEGIN
    UPDATE ordencompra 
    SET estado = 'Anulado', fechaAnulado = CONVERT_TZ(NOW(), '+00:00', '-05:00') WHERE idOrden = _idOrden;
END$
CREATE PROCEDURE LISTAR_ORDENESCOMPRA_TODAS()
BEGIN
	SELECT idOrden,fidCliente,fechaRegistro,fechaProcesado,fechaEntregado,fechaAnulado,estado,dni,correo,subtotal FROM ordencompra;
END$
CREATE PROCEDURE LISTAR_ORDENESCOMPRA_X_ESTADO(
    IN _estado ENUM('Registrado', 'Procesado', 'Entregado', 'Anulado')
)
BEGIN
    SELECT idOrden, fidCliente, fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, estado, dni, correo, subtotal FROM ordencompra WHERE estado = _estado;
END$
CREATE PROCEDURE LISTAR_ORDENCOMPRA_X_ID(
	IN _idOrden INT
)
BEGIN
	SELECT idOrden,fidCliente,fechaRegistro,fechaProcesado,fechaEntregado,fechaAnulado,estado,dni,correo,subtotal FROM ordencompra WHERE idOrden = _idOrden;
END$

CREATE PROCEDURE INSERTAR_CARRITO(
    OUT _idCarrito INT,
    IN _fidCliente INT,
    IN _cantidadTotal INT,
    IN _precioTotal DECIMAL(10, 2)
)
BEGIN
    INSERT INTO carrito(fidCliente, cantidadTotal, precioTotal) VALUES (_fidCliente, 0, 0.00);
    SET _idCarrito = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_CARRITO(
	IN _idCarrito INT,
    IN _fidCliente INT,
    IN _cantidadTotal INT,
    IN _precioTotal DECIMAL(10, 2)
)
BEGIN
	UPDATE carrito SET cantidadTotal = _cantidadTotal, precioTotal = _precioTotal WHERE idCarrito = _idCarrito AND fidCliente = _fidCliente;
END$
CREATE PROCEDURE LISTAR_CARRITO_X_ID(
	IN _idCliente INT
)
BEGIN
	SELECT idCarrito, fidCliente, cantidadTotal, precioTotal FROM carrito WHERE fidCliente = _idCliente;
END$

CREATE PROCEDURE INSERTAR_PRENDASELECCIONADA(
    IN _idPrendaSeleccionada INT,
    IN _fidCarrito INT,
	IN _cantidad INT,
    IN _precio DECIMAL(10, 2)
)
BEGIN
	DECLARE _cantActual INT;
    DECLARE _precioActual DECIMAL(10, 2);
    
    INSERT INTO prendaseleccionada(idPrendaSeleccionada, fidCarrito, cantidad, precio) VALUES (_idPrendaSeleccionada, _fidCarrito, _cantidad, _precio);
END$
CREATE PROCEDURE MODIFICAR_PRENDASELECCIONADA(
	IN _idPrendaSeleccionada INT,
    IN _fidCarrito INT,
	IN _cantidad INT,
    IN _precio DECIMAL(10, 2)
)
BEGIN
	UPDATE prendaseleccionada SET cantidad = _cantidad, precio = _precio WHERE idPrendaSeleccionada = _idPrendaSeleccionada AND fidCarrito = _fidCarrito;
END$
CREATE PROCEDURE ELIMINAR_PRENDASELECCIONADA(
	IN _idPrendaSeleccionada INT,
    IN _fidCarrito INT
)
BEGIN
	DELETE FROM prendaseleccionada WHERE idPrendaSeleccionada = _idPrendaSeleccionada AND fidCarrito = _fidCarrito;
END$
CREATE PROCEDURE LISTAR_PRENDASELECCIONADA_X_ID(
    IN _fidCarrito INT
)
BEGIN
	SELECT idPrendaSeleccionada, fidCarrito, cantidad, precio FROM prendaseleccionada WHERE fidCarrito = _fidCarrito;
END$


-- ------------------------------------------------------------------------------------------
-- Inserts
INSERT INTO ordencompra(fidCliente, fidCupon, fidCarrito, fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, estado, dni, correo, subtotal) 
VALUES
(5, NULL, NULL, '2024-01-10', NULL, NULL, NULL, 'Registrado', '32457612', 'jp@gmail.com', 150.00),
(6, NULL, NULL, '2024-01-08', '2024-01-09', NULL, NULL, 'Procesado', '98765432', 'fmontenegro@gmail.com', 250.50),
(5, NULL, NULL, '2024-01-05', '2024-01-06', '2024-01-07', NULL, 'Entregado', '32457612', 'jp@gmail.com', 320.75),
(6, NULL, NULL, '2024-01-12', NULL, NULL, '2024-02-12', 'Anulado', '98765432', 'fmontenegro@gmail.com', 100.00),
(5, NULL, NULL, '2024-01-15', '2024-01-16', NULL, NULL, 'Procesado', '32457612', 'jp@gmail.com', 210.00);

-------------------------------------------------------------------------------------------------
-- Totales y modificaciones
DELIMITER $
CREATE PROCEDURE MODIFICAR_ORDENCOMPRA(
    IN _idOrden INT,
    IN _fechaRegistro DATE,
    IN _fechaProcesado DATE,
    IN _fechaEntregado DATE,
    IN _fechaAnulado DATE,
    IN _estado ENUM('Registrado', 'Procesado', 'Entregado', 'Anulado'),
    IN _dni VARCHAR(8),
    IN _correo VARCHAR(50),
    IN _subtotal DECIMAL(10, 2)
)
BEGIN
    UPDATE ordencompra 
    SET 
        fechaRegistro = CASE WHEN _fechaRegistro IS NOT NULL THEN _fechaRegistro ELSE fechaRegistro END,
        fechaProcesado = CASE WHEN _fechaProcesado IS NOT NULL THEN _fechaProcesado ELSE fechaProcesado END,
        fechaEntregado = CASE WHEN _fechaEntregado IS NOT NULL THEN _fechaEntregado ELSE fechaEntregado END,
        fechaAnulado = CASE WHEN _fechaAnulado IS NOT NULL THEN _fechaAnulado ELSE fechaAnulado END,
        estado = _estado,
        dni = _dni,
        correo = _correo,
        subtotal = _subtotal
    WHERE idOrden = _idOrden;
END;

CREATE TABLE totales(
    idTotal INT AUTO_INCREMENT PRIMARY KEY,
    totalPrendas INT DEFAULT 0,
    promocionesActivas INT DEFAULT 0,
    cuponesActivos INT DEFAULT 0,
    clientesActivos INT DEFAULT 0,
    fechaRegistro DATE
) ENGINE = InnoDB;


INSERT INTO totales (totalPrendas, promocionesActivas, cuponesActivos, clientesActivos, fechaRegistro)
VALUES (117, 1, 4, 8, CURDATE());
//////////////////////////////////////////////////////////////////////////////////////////
CREATE TRIGGER actualizar_total_prendas
AFTER INSERT ON prenda
FOR EACH ROW
BEGIN
    UPDATE totales
    SET totalPrendas = (SELECT SUM(stock) FROM prenda)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_total_prendas_update
AFTER UPDATE ON prenda
FOR EACH ROW
BEGIN
    UPDATE totales
    SET totalPrendas = (SELECT SUM(stock) FROM prenda)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_total_prendas_delete
AFTER DELETE ON prenda
FOR EACH ROW
BEGIN
    UPDATE totales
    SET totalPrendas = (SELECT SUM(stock) FROM prenda)
    WHERE idTotal = 1;
END;
///////////////////////////////////////////////////////////////////////////////////////
CREATE TRIGGER actualizar_promociones_activas
AFTER INSERT ON promocion
FOR EACH ROW
BEGIN
    UPDATE totales
    SET promocionesActivas = (SELECT COUNT(*) FROM promocion WHERE activo = 1)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_promociones_activas_update
AFTER UPDATE ON promocion
FOR EACH ROW
BEGIN
    UPDATE totales
    SET promocionesActivas = (SELECT COUNT(*) FROM promocion WHERE activo = 1)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_promociones_activas_delete
AFTER DELETE ON promocion
FOR EACH ROW
BEGIN
    UPDATE totales
    SET promocionesActivas = (SELECT COUNT(*) FROM promocion WHERE activo = 1)
    WHERE idTotal = 1;
END;
//////////////////////////////////////////////////////////////////////////////////////////
CREATE TRIGGER actualizar_cupones_activos
AFTER INSERT ON cupon
FOR EACH ROW
BEGIN
    UPDATE totales
    SET cuponesActivos = (SELECT COUNT(*) FROM cupon WHERE activo = 1)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_cupones_activos_update
AFTER UPDATE ON cupon
FOR EACH ROW
BEGIN
    UPDATE totales
    SET cuponesActivos = (SELECT COUNT(*) FROM cupon WHERE activo = 1)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_cupones_activos_delete
AFTER DELETE ON cupon
FOR EACH ROW
BEGIN
    UPDATE totales
    SET cuponesActivos = (SELECT COUNT(*) FROM cupon WHERE activo = 1)
    WHERE idTotal = 1;
END;
//////////////////////////////////////////////////////////////////////////////////////////
CREATE TRIGGER actualizar_clientes_activos
AFTER INSERT ON cliente
FOR EACH ROW
BEGIN
    UPDATE totales
    SET clientesActivos = (SELECT COUNT(*) FROM cliente)
    WHERE idTotal = 1;
END;
-------------------------------------------------------------
CREATE TRIGGER actualizar_clientes_activos_delete
AFTER DELETE ON cliente
FOR EACH ROW
BEGIN
    UPDATE totales
    SET clientesActivos = (SELECT COUNT(*) FROM cliente)
    WHERE idTotal = 1;
END;
//////////////////////////////////////////////////////////////////////////////////////////
DELIMITER $
CREATE PROCEDURE obtener_valores_actuales()
BEGIN
    SELECT * FROM totales WHERE idTotal = 1;
END $


DELIMITER $
CREATE PROCEDURE obtener_valores_por_mes(IN anho INT, IN mes INT)
BEGIN
    SELECT * FROM totales
    WHERE YEAR(fechaRegistro) = anho AND MONTH(fechaRegistro) = mes;
END $


-- Creamos el evento
CREATE EVENT IF NOT EXISTS agregar_totales_mensuales
ON SCHEDULE EVERY 1 MONTH
STARTS '2024-12-01 00:00:00'
DO
BEGIN
    INSERT INTO totales (totalPrendas, promocionesActivas, cuponesActivos, clientesActivos, fechaRegistro)
    SELECT totalPrendas, promocionesActivas, cuponesActivos, clientesActivos, CURDATE()
    FROM totales
    WHERE idTotal = 1;  -- Suponiendo que la primera fila es la que contiene los datos actuales
    
    -- Esto insertará una copia de los valores de la fila 1 con la fecha actual.
END;



