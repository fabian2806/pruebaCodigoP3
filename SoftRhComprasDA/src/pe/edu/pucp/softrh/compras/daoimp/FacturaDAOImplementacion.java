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
import pe.edu.pucp.softrh.compras.dao.FacturaDAO;
import pe.edu.pucp.softrh.compras.model.Factura;
/*
 *
 * @author JP
 */
public class FacturaDAOImplementacion extends DAOImplementacion implements FacturaDAO{
    private Factura documento;
    //Constructor
    public FacturaDAOImplementacion() {
        super("documento");
        this.documento = null;
    }
    //Especificacion de la tabla  
    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();
        
        atributos.add("idComprobante");
        atributos.add("totalPagar");
        atributos.add("ruc");
        atributos.add("razonSocial");
        atributos.add("repreLegal");
        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeValoresInsertar() {
        ArrayList<String> valores = new ArrayList<>();
        
        valores.add(this.documento.getIdComprobante().toString());
        valores.add(this.documento.getTotalPagar().toString());
        valores.add(this.documento.getRuc());
        valores.add(this.documento.getRazonSocial());
        valores.add(this.documento.getRepreLegal());

        return valores;
    }   
    //Insetar sin retornar ID
    @Override
    public Integer insertar(Factura documento) {
        this.documento = documento;
        return super.insertar();
    } 
    //Actualizar
    @Override
    public Integer modificar(Factura documentoModificada) {
        this.documento = documentoModificada; 
        return super.actualizar();
    }
    //Eliminar
    @Override
    public Integer eliminar(Factura documento) {
        this.documento = documento;
        return super.eliminar();
    }
    //Seleccionar todos
    @Override
    public ArrayList<Factura> obtenerTodos() {
        Integer idComprobante;
        Double totalPagar;
        String razonSocial, ruc, repreLegal;
        ArrayList<Factura> documentos = new ArrayList<>();
        
        super.listarTodos();
        
        try {
            while (this.result_set.next()) {
                idComprobante = this.result_set.getInt("idComprobante");
                totalPagar = this.result_set.getDouble("totalPagar");
                ruc = this.result_set.getString("ruc");
                razonSocial = this.result_set.getString("razonSocial");
                repreLegal = this.result_set.getString("repreLegal");
                
                System.out.println(idComprobante + totalPagar + ruc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                super.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return documentos;
    }
    //Seleccionar por Id
    @Override
    public Factura obtenerPorId(String idComprobante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}