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
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Direccion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class SoftRhTest {

    public static void main(String[] args) throws ParseException {
        testConexionDB();

		testModuloUsuarios();

		testModuloPrendas();
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
//		resultado = administradorBO.insertar("12345678", "Alex Ismael", "Calero Revilla", "alex@gmail.com", "calerinho", new Date());

		// Insertar trabajador
//		resultado = trabajadorBO.insertar("23456789", "Mikler Jr", "Diaz Perez", "mikler@gmail.com", "tenis1234", "Cajero", 850.00, sdf.parse("2024-10-10"), LocalTime.of(8, 0), LocalTime.of(17,0));

		Trabajador trabajador1 = new Trabajador("23456789", "Mikler Jr", "Diaz Perez", "mikler@gmail.com", "tenis1234", "Cajero", 850.00, sdf.parse("2024-10-10"), LocalTime.of(8, 0), LocalTime.of(17,0));
		trabajador1.setIdUsuario(2);

		// Insertar cliente
//		resultado = clienteBO.insertar("32457612", "Jean Paul", "Tomasto Cordova", "jp@gmail.com", "lonchera", new Date(), true);
//		resultado = clienteBO.insertar("98765432", "Fabián", "Montenegro", "fmontenegro@gmail.com", "po123", sdf.parse("2024-09-22"), false);

		Cliente cliente1 = new Cliente("32457612", "Jean Paul", "Tomasto Cordova", "jp@gmail.com", "lonchera", new Date(), true);
		cliente1.setIdUsuario(3);
		Cliente cliente2 = new Cliente("98765432", "Fabián", "Montenegro", "fmontenegro@gmail.com", "po123", sdf.parse("2024-09-22"), false);
		cliente2.setIdUsuario(4);

		// Insertar direccion
//		resultado = direccionBO.insertar("Calle Las Rosas", "San Miguel", "Lima", "Lima", "Lima3", "Cruce de las avenidas La Marina con Universitaria", cliente1);
//		resultado = direccionBO.insertar("Calle Los Girasoles", "Bellavista", "Callao", "Callao", "Callao2", "Cerca a Metro", cliente1);
//		resultado = direccionBO.insertar("Calle Los Geranios", "Magdalena", "Lima", "Lima", "Lima6", "Por la Av. Sucre", cliente2);

		// Modificar direccion
//		resultado = direccionBO.modificar(1, "Calle Los Robles", "Miraflores", "Lima", "Lima", "Lima10", "Cerca al Kennedy", cliente1);

		// Eliminar direccion
//		resultado = direccionBO.eliminar(2);

		// Listar direcciones
//		ArrayList<Direccion> direcciones = direccionBO.listarTodos();
//		for(Direccion d : direcciones)
//			System.out.println(d.toString());

		// Obtener direccion por id
		Direccion direcBuscada = direccionBO.obtenerPorId(1);
		System.out.println(direcBuscada.toString());

		// Insertar cupon
//		resultado = cuponBO.insertar("COD001", "Cupon del 10% de dcto.", sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);
//		resultado = cuponBO.insertar("COD002", "Cupon del 15% de dcto.", sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);
//		resultado = cuponBO.insertar("COD003", "Cupon del 20% de dcto.", sdf.parse("2024-10-10"), sdf.parse("2024-12-31"), trabajador1);

		// Modificar cupon
//		resultado = cuponBO.modificar(1, "COD001", "Cupon del 5% de dcto.", sdf.parse("2024-10-10"), sdf.parse("2024-11-30"), trabajador1);

		// Eliminar cupon
//		resultado = cuponBO.eliminar(2);

		// Listar cupones
//		ArrayList<Cupon> cupones = cuponBO.listarTodos();
//		for(Cupon c : cupones)
//			System.out.println(c.toString());

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
//		resultado = prendaBO.insertar("Polo Never Surrender", "Polo manga corta con fit oversize", TipoPrenda.Polo, "imagenes/polos/polo-never-surrender", Talla.L, Genero.Mujer, "Negro", 40.99, 10);
//        resultado = prendaBO.insertar("Polo RH Team", "Polo con logo de la tienda", TipoPrenda.Polo, "imagenes/polos/polo-rh-team", Talla.L, Genero.Unisex, "Blanco", 90.99, 20);
//        resultado = prendaBO.insertar("Polera RH Team", "Polera con logo de la tienda", TipoPrenda.Polera, "imagenes/poleras/polera-rh-team", Talla.XL, Genero.Unisex, "Marron", 129.99, 15);
//        resultado = prendaBO.insertar("Casaca motera", "Casaca con estilo motera", TipoPrenda.Casaca, "imagenes/casacas/casaca-motera", Talla.XL, Genero.Hombre, "Negro", 60.99, 12);
//        resultado = prendaBO.insertar("Pantalon cammo", "Pantalon cargo", TipoPrenda.Pantalon, "imagenes/pantalon/pantalon-cammo", Talla.M, Genero.Hombre, "Verde", 80.99, 30);

		Prenda prenda1 = new Prenda("Polo 'Never Surrender'", "Polo manga corta, fit oversize", TipoPrenda.Polo, "imagenes/polos/polo-never-surrender", Talla.L, Genero.Mujer, "Negro", 40.99, 10);
		prenda1.setIdPrenda(1);

		// Modificar prenda
//		resultado = prendaBO.modificar(5, "Pantalon rasgado", "Pantalon con un estilo rasgado en las piernas", TipoPrenda.Pantalon, "imagenes/pantalon/pantalon-rasgado", Talla.S, Genero.Mujer, "Verdiblanco", 80.99, 0.0, 35, 0);

		// Eliminar prenda
//		resultado = prendaBO.eliminar(2);

		// Listar prendas
//		ArrayList<Prenda> prendas = prendaBO.listarTodos();
//        for (Prenda p : prendas){
//            System.out.println(p.toString());
//        }

		// Obtener prenda por id
		Prenda prendaBuscada = prendaBO.obtenerPorId(1);
        System.out.println(prendaBuscada.toString());

		// Insertar promocion
		Trabajador trabajador1 = new Trabajador("23456789", "Mikler Jr", "Diaz Perez", "mikler@gmail.com", "tenis1234", "Cajero", 850.00, sdf.parse("2024-10-10"), LocalTime.of(8, 0), LocalTime.of(17,0));
		trabajador1.setIdUsuario(2);

//		resultado = promocionBO.insertar("Dia del niño", "Promoción por el día del niño", 20.0, TipoPromocion.Porcentaje, sdf.parse("2024-03-1"), sdf.parse("2024-04-1"), trabajador1, prenda1);
//		resultado = promocionBO.insertar("Black Friday", "Promoción por black friday", 10.0, TipoPromocion.Porcentaje, sdf.parse("2024-11-20"), sdf.parse("2024-12-1"), trabajador1, prenda1);
//		resultado = promocionBO.insertar("Navidad", "Promoción por época de navidad", 10.0, TipoPromocion.MontoFijo, sdf.parse("2024-12-1"), sdf.parse("2025-01-1"), trabajador1, prenda1);

		// Modificar promocion
//		resultado = promocionBO.modificar(1, "Año Nuevo", "Promocion por año nuevo", 15.0, TipoPromocion.MontoFijo, sdf.parse("2024-12-20"), sdf.parse("2025-01-15"), trabajador1, prenda1);

		// Eliminar promocion
//		resultado = promocionBO.eliminar(2);

		// Listar promociones
//		ArrayList<Promocion> promociones = promocionBO.listarTodos();
//		for(Promocion p : promociones)
//			System.out.println(p.toString());

		// Obtener promocion por id
		Promocion promocionBuscada = promocionBO.obtenerPorId(1);
		System.out.println(promocionBuscada.toString());
	}
}
