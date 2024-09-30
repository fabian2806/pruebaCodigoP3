/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.daoimp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.DAOImplementacion;
import pe.edu.pucp.softrh.compras.dao.PrendaSeleccionadaDAO;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
/**
 *
 * @author JP
 */
public class PrendaSeleccionadaDAOImplementacion extends DAOImplementacion implements PrendaSeleccionadaDAO{
    private PrendaSeleccionada prenda;
    //Constructor
    public PrendaSeleccionadaDAOImplementacion() {
        super("prenda");
        this.prenda = null;
    }
    //Especificacion de la tabla  
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("cantidad");
        atributos.add("precio");
        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeValoresInsertar() {
        ArrayList<String> valores = new ArrayList<>();
        
        valores.add(this.prenda.getCantidad().toString());
        valores.add(this.prenda.getPrecio().toString());

        return valores;
    }   
    //Insetar sin retornar ID
    @Override
    public Integer insertar(PrendaSeleccionada prenda) {
        this.prenda = prenda;
        return super.insertar();
    } 
    //Actualizar
    @Override
    public Integer modificar(PrendaSeleccionada prendaModificada) {
        this.prenda = prendaModificada; 
        return super.actualizar();
    }
    //Eliminar
    @Override
    public Integer eliminar(PrendaSeleccionada prenda) {
        this.prenda = prenda;
        return super.eliminar();
    }
    //Seleccionar todos
    @Override
    public ArrayList<PrendaSeleccionada> obtenerTodos() {
        Integer cantidad;
        Double precio;
        ArrayList<PrendaSeleccionada> prendas = new ArrayList<>();
        
        super.listarTodos();
        
        try {
            while (this.result_set.next()) {
                cantidad = this.result_set.getInt("cantidad");
                precio = this.result_set.getDouble("precio");
                
                System.out.println(cantidad + precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrendaSeleccionadaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                super.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaSeleccionadaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return prendas;
    }
//Seleccionar por Id
//    @Override
//    public PrendaSeleccionada obtenerPorId(String idOrden) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
