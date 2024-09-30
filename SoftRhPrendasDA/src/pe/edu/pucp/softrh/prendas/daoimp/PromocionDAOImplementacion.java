/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.daoimp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.DAOImplementacion;
import pe.edu.pucp.softrh.database.db.DAOImplementacion;
import pe.edu.pucp.softrh.prendas.dao.PromocionDAO;
import pe.edu.pucp.softrh.prendas.model.Promocion;

public class PromocionDAOImplementacion extends DAOImplementacion implements PromocionDAO{
    private Promocion promocion;
    
    public PromocionDAOImplementacion(){
        super("promocion");
        this.promocion = null;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar(){
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("idPromocion");
        atributos.add("fidTrabajador");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("valorDescuento");
        atributos.add("tipo");
        atributos.add("fechaInicio");
        atributos.add("fechaFin");
        atributos.add("activo");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosModificar(){
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("fidTrabajador");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("valorDescuento");
        atributos.add("tipo");
        atributos.add("fechaInicio");
        atributos.add("fechaFin");
        atributos.add("activo");
        atributos.add("idPromocion");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosEliminar(){
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("activo");
        atributos.add("idPromocion");
        
        return atributos;
    }
    
    @Override
    protected ArrayList<String> obtenerListaDeAtributosListarTodos(){
        return obtenerListaDeAtributosInsertar();
    }
    
    //////
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresInsertar(){
        ArrayList<Object> valores = new ArrayList<>();
        
        valores.add(this.promocion.getIdPromocion());
        valores.add(this.promocion.getIdTrabajador());
        valores.add(this.promocion.getNombre());
        valores.add(this.promocion.getDescripcion());
        valores.add(this.promocion.getValorDescuento());
        valores.add(this.promocion.getTipo());
        valores.add(this.promocion.getFechaInicio());
        valores.add(this.promocion.getFechaFin());
        valores.add(this.promocion.isActivo);

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresModificar(){
        ArrayList<Object> valores = new ArrayList<>();
        
        valores.add(this.promocion.getIdTrabajador());
        valores.add(this.promocion.getNombre());
        valores.add(this.promocion.getDescripcion());
        valores.add(this.promocion.getValorDescuento());
        valores.add(this.promocion.getTipo());
        valores.add(this.promocion.getFechaInicio());
        valores.add(this.promocion.getFechaFin());
        valores.add(this.promocion.isActivo);
        valores.add(this.promocion.getIdPromocion());

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresEliminar(){
        ArrayList<Object> valores = new ArrayList<>();
        
        valores.add(this.promocion.getIdPromocion());

        return valores;
    }
    
    @Override
    protected ArrayList<Object> obtenerListaDeValoresListarTodos(){
        return new ArrayList<>(); //vacio necesariamente
    }
    
    @Override
    public Integer insertar(Promocion promocion){
        this.promocion = promocion;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(Promocion promocionModificada){
        this.promocion = promocionModificada;
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(Promocion promocion){
        this.promocion = promocion;
        return super.eliminar();
    }
    
    @Override
    public ArrayList<Promocion> listarTodos(){
        return super.listarTodos();
    }
    
    public Promocion obtenerPorId(String idPromocion){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
