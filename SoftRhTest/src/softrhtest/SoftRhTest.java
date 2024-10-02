/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package softrhtest;

import pe.edu.pucp.softrh.database.config.DBManager;
import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.bo.PrendaBO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class SoftRhTest {

    public static void main(String[] args) {

        //ANTES DE HACER PRUEBA: DROP

        //1. Prueba de Conexión a BD
        test_DB();

        //2. Prueba de Insert (Tabla Prenda)
        test_insertar();

        //3. Prueba de Modificar (Tabla Prenda)
        test_modificar();

        //4. Prueba de Eliminar (Tabla Prenda)
        test_eliminar();

        //5. Prueba de listarTodos (Tabla Prenda)
        test_listarTodos();

        //6. Prueba de obtenerPorId (Tabla Prenda)
        test_obtenerPorId(3);

    }

    private static void test_DB() {
        DBManager dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);
        dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);
        dbManager = DBManager.obtenerInstancia();
        System.out.println(dbManager);

        Connection conexion = dbManager.obtenerConexion();
    }

    private static void test_insertar() {
        int i;
        PrendaBO prendaBO = new PrendaBO();
        i = prendaBO.insertar("polo 1", "polo manga larga bonito", TipoPrenda.Polo, "imagen", Talla.L,
                Genero.Mujer, "negro", 40.99, 10);
        i = prendaBO.insertar("polo 2", "polo messi", TipoPrenda.Polo, "imagen2", Talla.L,
                Genero.Hombre, "celeste", 90.99, 20);
        i = prendaBO.insertar("polera 1", "polera oversize", TipoPrenda.Polera, "imagen3", Talla.XXL,
                Genero.Unisex, "blanco", 129.99, 15);
        i = prendaBO.insertar("polo 3", "polo oversize", TipoPrenda.Polo, "imagen4", Talla.XL,
                Genero.Mujer, "azul", 60.99, 12);
        i = prendaBO.insertar("pantalon 1", "pantalon razgado", TipoPrenda.Pantalon, "imagen5", Talla.M,
                Genero.Hombre, "beige", 80.99, 30);
        if (i == 1){
            System.out.println("Operacion concluida correctamente.");
        }
    }

    private static void test_modificar() {
        int i;
        Prenda prendaMod = new Prenda("polo 1 mod", "polo manga larga", TipoPrenda.Polo, "nueva imagen", Talla.XL,
            Genero.Mujer, "negro y blanco", 30.99, 7);
        PrendaBO prendaBO = new PrendaBO();

        prendaMod.setId(3);

        i = prendaBO.modificar(prendaMod);
        if (i == 1){
            System.out.println("Operacion concluida correctamente.");
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_eliminar() {
        //NECESITAMOS IMPLEMENTAR obtenerPorId
        int i;
        PrendaBO prendaBO = new PrendaBO();

//        Prenda prenda = prendaBO.obtenerPorId("1");

		// Para poder probar la eliminacion
		Prenda prenda = new Prenda();
		prenda.setId(7);

        i = prendaBO.eliminar(prenda);
        if (i == 1){
            System.out.println("Operacion concluida correctamente.");
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_listarTodos() {
        PrendaBO prendaBO = new PrendaBO();

        ArrayList<Prenda> listaPrendas = prendaBO.listarTodos();

        for (Prenda pr : listaPrendas){
            System.out.println("messi");
            System.out.println(pr.devolverDatos());
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_obtenerPorId(Integer id) {

        PrendaBO prendaBO = new PrendaBO();

        Prenda prenda = prendaBO.obtenerPorId(id.toString());

        System.out.println(prenda.devolverDatos());

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
