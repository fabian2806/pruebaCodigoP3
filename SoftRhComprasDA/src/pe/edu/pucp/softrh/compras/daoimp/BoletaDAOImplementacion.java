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
import pe.edu.pucp.softrh.compras.dao.BoletaDAO;
import pe.edu.pucp.softrh.compras.model.Boleta;

/**
 *
 * @author JP
 */
public class BoletaDAOImplementacion extends DAOImplementacion implements BoletaDAO{
    private Boleta documento;
    //Constructor
    public BoletaDAOImplementacion() {
        super("documento");
        this.documento = null;
    }
    //Especificacion de la tabla  
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("idComprobante");
        atributos.add("totalPagar");
        atributos.add("dni");
        atributos.add("nombres");
        atributos.add("apellidos");
        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeValoresInsertar() {
        ArrayList<String> valores = new ArrayList<>();
        
        valores.add(this.documento.getIdComprobante().toString());
        valores.add(this.documento.getTotalPagar().toString());
        valores.add(this.documento.getDni());
        valores.add(this.documento.getNombres());
        valores.add(this.documento.getApellidos());

        return valores;
    }   
    //Insetar sin retornar ID
    @Override
    public Integer insertar(Boleta documento) {
        this.documento = documento;
        return super.insertar();
    } 
    //Actualizar
    @Override
    public Integer modificar(Boleta documentoModificada) {
        this.documento = documentoModificada; 
        return super.actualizar();
    }
    //Eliminar
    @Override
    public Integer eliminar(Boleta documento) {
        this.documento = documento;
        return super.eliminar();
    }
    //Seleccionar todos
    @Override
    public ArrayList<Boleta> obtenerTodos() {
        Integer idComprobante;
        Double totalPagar;
        String nombre, dni, apellido;
        ArrayList<Boleta> documentos = new ArrayList<>();
        
        super.listarTodos();
        
        try {
            while (this.result_set.next()) {
                idComprobante = this.result_set.getInt("idComprobante");
                totalPagar = this.result_set.getDouble("totalPagar");
                dni = this.result_set.getString("dni");
                nombre = this.result_set.getString("nombres");
                apellido = this.result_set.getString("apellidos");
                
                System.out.println(idComprobante + totalPagar + dni);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                super.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(BoletaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return documentos;
    }
    //Seleccionar por Id
    @Override
    public Boleta obtenerPorId(String idComprobante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
