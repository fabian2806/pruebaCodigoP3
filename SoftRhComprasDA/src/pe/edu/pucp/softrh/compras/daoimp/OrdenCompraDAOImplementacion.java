/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.daoimp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import pe.edu.pucp.softrh.database.DAOImplementacion;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.compras.model.Estado;

/**
 *
 * @author JP
 */
public class OrdenCompraDAOImplementacion extends DAOImplementacion implements OrdenCompraDAO{
    private OrdenCompra documento;
    //Constructor
    public OrdenCompraDAOImplementacion() {
        super("documento");
        this.documento = null;
    }
    //Especificacion de la tabla  
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("idOrden");
        atributos.add("fechaPedido");
        atributos.add("fechaPago");
        atributos.add("estado");
        atributos.add("dni");
        atributos.add("correo");
        atributos.add("subtotal");
        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeValoresInsertar() {
        ArrayList<String> valores = new ArrayList<>();
        
        valores.add(this.documento.getIdOrden().toString());
        valores.add(this.documento.getFechaPedido().toString());
        valores.add(this.documento.getFechaPago().toString());
        valores.add(this.documento.getEstado().toString());
        valores.add(this.documento.getDni());
        valores.add(this.documento.getCorreo());
        valores.add(this.documento.getSubtotal().toString());

        return valores;
    }   
    //Insetar sin retornar ID
    @Override
    public Integer insertar(OrdenCompra documento) {
        this.documento = documento;
        return super.insertar();
    } 
    //Actualizar
    @Override
    public Integer modificar(OrdenCompra documentoModificada) {
        this.documento = documentoModificada; 
        return super.actualizar();
    }
    //Eliminar
    @Override
    public Integer eliminar(OrdenCompra documento) {
        this.documento = documento;
        return super.eliminar();
    }
    //Seleccionar todos
    @Override
    public ArrayList<OrdenCompra> obtenerTodos() {
        Integer idOrden;
        Date fechaPedido,fechaPago;
        Double subtotal;
        Estado estado;
        String dni, correo;
        ArrayList<OrdenCompra> documentos = new ArrayList<>();
        
        super.listarTodos();
        
        try {
            while (this.result_set.next()) {
                idOrden = this.result_set.getInt("idOrden");
                fechaPedido = this.result_set.getDate("fechaPedido");
                fechaPago = this.result_set.getDate("fechaPago");
                estado = this.result_set.getString("totalPagar");
                dni = this.result_set.getString("dni");
                correo = this.result_set.getString("correo");
                subtotal = this.result_set.getDouble("subtotal");
                
                System.out.println(idOrden + subtotal + dni);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompraDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                super.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OrdenCompraDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return documentos;
    }
    //Seleccionar por Id
    @Override
    public OrdenCompra obtenerPorId(String idOrden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
