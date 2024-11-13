package softrhtest;

import pe.edu.pucp.softrh.database.config.DBManager;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.prendas.bo.PrendaBO;
import pe.edu.pucp.softrh.prendas.bo.PromocionBO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;
import pe.edu.pucp.softrh.usuarios.bo.AdministradorBO;
import pe.edu.pucp.softrh.usuarios.bo.ClienteBO;
import pe.edu.pucp.softrh.usuarios.bo.CuponBO;
import pe.edu.pucp.softrh.usuarios.bo.DireccionBO;
import pe.edu.pucp.softrh.usuarios.bo.TrabajadorBO;
import pe.edu.pucp.softrh.usuarios.bo.UsuarioBO;
import pe.edu.pucp.softrh.usuarios.model.Administrador;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Direccion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class SoftRhTest {

    public static void main(String[] args) throws ParseException {
        testConexionDB();

        System.out.println("Prueba 1: Usuarios\n");
        testModuloUsuarios();
//
//        System.out.print("Prueba 2: Prendas\n");
//        testModuloPrendas();

//        System.out.println("Prueba 3: Verificacion de ingreso y roles\n");
//		testModuloVerificacionIngresoConRol();
//
//		System.out.println("Prueba 4: Listar por nombres\n");
//		testModuloListarPrendaPorNombre();
    }

    private static void testConexionDB() {
        DBManager dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);
        dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);
        dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);

        Connection conexion = dbManager.obtenerConexion();
    }

    private static void testModuloUsuarios() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int resultado;
        AdministradorBO administradorBO = new AdministradorBO();
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        ClienteBO clienteBO = new ClienteBO();
        DireccionBO direccionBO = new DireccionBO();
        CuponBO cuponBO = new CuponBO();

        // Insertar administrador
        resultado = administradorBO.insertar("12345678", "Alex Ismael", "Calero Revilla", "alex@gmail.com", "calerinho", sdf.parse("2024-10-10"));
        System.out.println(resultado);
        resultado = administradorBO.insertar("23291023", "Percy", "Marca Rojas", "percymr@gmail.com", "osorizado", sdf.parse("2024-10-11"));
        System.out.println(resultado);
        resultado = administradorBO.insertar("23281102", "Axel Edu", "Huaripata", "axeleduh@gmail.com", "imthelex", sdf.parse("2024-10-21"));
        System.out.println(resultado);

        // Modificar administrador
        resultado = administradorBO.modificar(2, "12345678", "Lionel", "Messi", "hola2022@gmail.com", "ydaleU", sdf.parse("2024-11-11"));
        System.out.println(resultado);

        //Eliminar administrador
        resultado = administradorBO.eliminar(3);
        System.out.println(resultado);

        // Listar administradores
        ArrayList<Administrador> administradores = administradorBO.listarTodos();
        for (Administrador a : administradores) {
            System.out.println(a.toString());
        }

        // Obtener direccion por id
        Administrador adminBuscado = administradorBO.obtenerPorId(1);
        System.out.println(adminBuscado.toString());


        // Insertar trabajador
        resultado = trabajadorBO.insertar("23456789", "Mikler Jr", "Diaz Perez", "mikler@gmail.com", "tenis1234", "Cajero", 850.00, sdf.parse("2024-10-10"), "08:00", "17:00");
        System.out.println(resultado);
        Trabajador trabajador1 = trabajadorBO.obtenerPorId(resultado);

        // Insertar cliente
        resultado = clienteBO.insertar("32457612", "Jean Paul", "Tomasto Cordova", "jp@gmail.com", "lonchera", "999999999", new Date(), true);
        System.out.println(resultado);
        Cliente cliente1 = clienteBO.obtenerPorId(resultado);
        resultado = clienteBO.insertar("98765432", "Fabián", "Montenegro", "fmontenegro@gmail.com", "po123", "987654321", sdf.parse("2024-09-22"), false);
        System.out.println(resultado);
        Cliente cliente2 = clienteBO.obtenerPorId(resultado);

        // Insertar direccion
        resultado = direccionBO.insertar("Calle Las Rosas", "San Miguel", "Lima", "Lima", "Lima3", "Cruce de las avenidas La Marina con Universitaria", cliente1);
        System.out.println(resultado);
        resultado = direccionBO.insertar("Calle Los Girasoles", "Bellavista", "Callao", "Callao", "Callao2", "Cerca a Metro", cliente1);
        System.out.println(resultado);
        resultado = direccionBO.insertar("Calle Los Geranios", "Magdalena", "Lima", "Lima", "Lima6", "Por la Av. Sucre", cliente2);
        System.out.println(resultado);

        // Modificar direccion
        resultado = direccionBO.modificar(1, "Calle Los Robles", "Miraflores", "Lima", "Lima", "Lima10", "Cerca al Kennedy", cliente1);
        System.out.println(resultado);

        // Eliminar direccion
        resultado = direccionBO.eliminar(2);
        System.out.println(resultado);

        // Listar direcciones
        ArrayList<Direccion> direcciones = direccionBO.listarTodos();
        for (Direccion d : direcciones) {
            System.out.println(d.toString());
        }

        // Obtener direccion por id
        Direccion direcBuscada = direccionBO.obtenerPorId(1);
        System.out.println(direcBuscada.toString());


        // Insertar cupon
        resultado = cuponBO.insertar("COD001", "Cupon del 10% de dcto.", 30.0, sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);
        System.out.println(resultado);
        resultado = cuponBO.insertar("COD002", "Cupon del 15% de dcto.", 30.0, sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);
        System.out.println(resultado);
        resultado = cuponBO.insertar("COD003", "Cupon del 20% de dcto.", 30.0, sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);
        System.out.println(resultado);

        // Modificar cupon
        resultado = cuponBO.modificar(1, "COD001", "Cupon del 5% de dcto.", 30.0, sdf.parse("2024-10-10"), sdf.parse("2024-11-30"), trabajador1);
        System.out.println(resultado);

        // Eliminar cupon
        resultado = cuponBO.eliminar(2);
        System.out.println(resultado);

        // Listar cupones
        ArrayList<Cupon> cupones = cuponBO.listarTodos();
        for (Cupon c : cupones) {
            System.out.println(c.toString());
        }

        // Obtener cupon por id
        Cupon cuponBuscado = cuponBO.obtenerPorId(1);
        System.out.println(cuponBuscado.toString());

    }

    private static void testModuloPrendas() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int resultado;
        PrendaBO prendaBO = new PrendaBO();
        PromocionBO promocionBO = new PromocionBO();

        // Insertar prenda
        resultado = prendaBO.insertar("Polo Never Surrender", "Polo manga corta con fit oversize", TipoPrenda.Polo, null, Talla.L, Genero.Mujer, "Negro", 40.99, 10);
        System.out.println(resultado);
        resultado = prendaBO.insertar("Polo RH Team", "Polo con logo de la tienda", TipoPrenda.Polo, null, Talla.L, Genero.Unisex, "Blanco", 90.99, 20);
        System.out.println(resultado);
        resultado = prendaBO.insertar("Polera RH Team", "Polera con logo de la tienda", TipoPrenda.Polera, null, Talla.XL, Genero.Unisex, "Marron", 129.99, 15);
        System.out.println(resultado);
        resultado = prendaBO.insertar("Casaca motera", "Casaca con estilo motera", TipoPrenda.Casaca, null, Talla.XL, Genero.Hombre, "Negro", 60.99, 12);
        System.out.println(resultado);
        resultado = prendaBO.insertar("Pantalon cammo", "Pantalon cargo", TipoPrenda.Pantalon, null, Talla.M, Genero.Hombre, "Verde", 80.99, 30);
        System.out.println(resultado);

        Prenda prenda1 = new Prenda("Polo 'Never Surrender'", "Polo manga corta, fit oversize", TipoPrenda.Polo, null, Talla.L, Genero.Mujer, "Negro", 40.99, 10);
        prenda1.setIdPrenda(1);

        // Modificar prenda
        resultado = prendaBO.modificar(5, "Pantalon rasgado", "Pantalon con un estilo rasgado en las piernas", TipoPrenda.Pantalon, null, Talla.S, Genero.Mujer, "Verdiblanco", 80.99, 35);
        System.out.println(resultado);

        // Eliminar prenda
        resultado = prendaBO.eliminar(2);
        System.out.println(resultado);

//      Listar prendas
		ArrayList<Prenda> prendas = prendaBO.listarTodos();
        for (Prenda p : prendas){
            System.out.println(p.toString());
        }

        // Obtener prenda por id
        Prenda prendaBuscada = prendaBO.obtenerPorId(1);
        System.out.println(prendaBuscada.toString());


        // Insertar promocion
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        Trabajador trabajador1 = trabajadorBO.obtenerPorId(4);

        resultado = promocionBO.insertar("Dia del niño", "Promoción por el día del niño", 20.0, TipoPromocion.Porcentaje, sdf.parse("2024-03-1"), sdf.parse("2024-04-1"), trabajador1);
        System.out.println(resultado);
        resultado = promocionBO.insertar("Black Friday", "Promoción por black friday", 10.0, TipoPromocion.Porcentaje, sdf.parse("2024-11-20"), sdf.parse("2024-12-1"), trabajador1);
        System.out.println(resultado);
        resultado = promocionBO.insertar("Navidad", "Promoción por época de navidad", 10.0, TipoPromocion.MontoFijo, sdf.parse("2024-12-1"), sdf.parse("2025-01-1"), trabajador1);
        System.out.println(resultado);

        // Modificar promocion
        resultado = promocionBO.modificar(1, "Año Nuevo", "Promocion por año nuevo", 15.0, TipoPromocion.MontoFijo, sdf.parse("2024-12-20"), sdf.parse("2025-01-15"), trabajador1);
        System.out.println(resultado);

        // Eliminar promocion
        resultado = promocionBO.eliminar(2);
        System.out.println(resultado);

        // Listar promociones
        ArrayList<Promocion> promociones = promocionBO.listarTodos();
        for (Promocion p : promociones) {
            System.out.println(p.toString());
        }

        // Obtener promocion por id
        Promocion promocionBuscada = promocionBO.obtenerPorId(1);
        System.out.println(promocionBuscada.toString());

    }

    private static void testModuloVerificacionIngresoConRol() {
		int resultado;
		String rol;

		UsuarioBO usuarioBO = new UsuarioBO();

		resultado = usuarioBO.verificarIngresoUsuario("alex@gmail.com", "calerinho");
		rol = usuarioBO.obtenerRolUsuario("mikler@gmail.com", "tenis1234");
		System.out.println(resultado);
		System.out.println(rol);
	}

	private static void testModuloListarPrendaPorNombre() {
		PrendaBO prendaBO = new PrendaBO();
		ArrayList<Prenda> prendasCoincidentes = prendaBO.listarPorNombreDescripcion("polo");
		for(Prenda p : prendasCoincidentes)
			System.out.println(p.toString());
	}
}
