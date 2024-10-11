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

-- --------------------------------------------------------------------------------

-- PRENDAS
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

-- --------------------------------------------------------------------------------

-- COMPRAS
CREATE TABLE carrito(
	idCarrito INT AUTO_INCREMENT,
    fidCliente INT,
    cantidadTotal INT,
    precioTotal DECIMAL(10, 2),
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
