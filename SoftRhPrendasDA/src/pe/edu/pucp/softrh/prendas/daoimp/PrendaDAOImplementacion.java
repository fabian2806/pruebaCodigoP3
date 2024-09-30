/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.daoimp;
//hola
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.DAOImplementacion;
import pe.edu.pucp.softrh.database.db.DAOImplementacion;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.modelo.Prenda;

public class PrendaDAOImplementacion extends DAOImplementacion implements PrendaDAO{
    private Prenda prenda;
    //Constructor
    public PrendaDAOImplementacion() {
        super("prenda");
        this.prenda = null;
    }
    //Especificacion de la tabla  
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("idPrenda");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precio");
        atributos.add("stock");
        atributos.add("cantVendida");
        atributos.add("activo");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosModificar(){
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precio");
        atributos.add("stock");
        atributos.add("cantVendida");
        atributos.add("activo");
        atributos.add("idPrenda");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosEliminar(){
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("activo");
        atributos.add("idPrenda");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosListarTodos(){
        return obtenerListaDeAtributosInsertar();
    }
    
    //////
    

    @Override
    protected ArrayList<Object> obtenerListaDeValoresInsertar() {
        ArrayList<Object> valores = new ArrayList<>();
        
        valores.add(this.prenda.getId());
        valores.add(this.prenda.getNombre());
        valores.add(this.prenda.getDescripcion());
        valores.add(this.prenda.getTipo());
        valores.add(this.prenda.getImagen());
        valores.add(this.prenda.getTalla());
        valores.add(this.prenda.getGenero());
        valores.add(this.prenda.getColor());
        valores.add(this.prenda.getPrecio());
        valores.add(this.prenda.getStock());
        valores.add(this.prenda.getCantVendida());
        valores.add(this.prenda.isActivo());

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresModificar(){
        ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.prenda.getNombre());
        valores.add(this.prenda.getDescripcion());
        valores.add(this.prenda.getTipo());
        valores.add(this.prenda.getImagen());
        valores.add(this.prenda.getTalla());
        valores.add(this.prenda.getGenero());
        valores.add(this.prenda.getColor());
        valores.add(this.prenda.getPrecio());
        valores.add(this.prenda.getStock());
        valores.add(this.prenda.getCantVendida());
        valores.add(this.prenda.isActivo());        
        valores.add(this.prenda.getId());

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresEliminar(){
        ArrayList<Object> valores = new ArrayList<>();
        
        valores.add(this.prenda.getId());

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresListarTodos(){
        return new ArrayList<>(); //vacio necesariamente
    }
    
    @Override
    public Integer insertar(Prenda prenda) {
        this.prenda = prenda;
        return super.insertar();
    } 
    
    @Override
    public Integer modificar(Prenda prendaModificada) {
        this.prenda = prendaModificada; 
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(Prenda prenda) {
        this.prenda = prenda;
        return super.eliminar();
    }
    
    @Override
    public ArrayList<Prenda> listarTodos() {
        return super.listarTodos();
    }
    
    @Override
    public Prenda obtenerPorId(String idPrenda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
