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
        test_obtenerPorId("1");
        
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
        if (i == 1){
            System.out.println("Operacion concluida correctamente.");
        }
    }

    private static void test_modificar() {
        int i;
        Prenda prendaMod = new Prenda("polo 1 mod", "polo manga larga", TipoPrenda.Polo, "nueva imagen", Talla.XL,
            Genero.Mujer, "negro y blanco", 30.99, 7);
        PrendaBO prendaBO = new PrendaBO();
        
        prendaMod.setId(1);
        
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
        
        Prenda prenda = prendaBO.obtenerPorId("1");
        
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
            System.out.println(pr.devolverDatos());
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_obtenerPorId(String id) {
        PrendaBO prendaBO = new PrendaBO();
        
        Prenda prenda = prendaBO.obtenerPorId(id);
            
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
