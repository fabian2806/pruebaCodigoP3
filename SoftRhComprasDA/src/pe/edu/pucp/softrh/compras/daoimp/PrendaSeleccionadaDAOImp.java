package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.PrendaSeleccionadaDAO;
import pe.edu.pucp.softrh.compras.model.Carrito;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import pe.edu.pucp.softrh.database.config.DBManager;

public class PrendaSeleccionadaDAOImp implements PrendaSeleccionadaDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();
    
    @Override
    public int insertar(PrendaSeleccionada prenda) {
        int resultado = 0;
        Object[] parameters = new Object[4];
        parameters[0] = prenda.getIdPrendaSeleccionada();
        parameters[1] = prenda.getCarrito().getIdCarrito();
        parameters[2] = prenda.getCantidad();
        parameters[3] = prenda.getPrecio();
        
        prenda.setIdPrendaSeleccionada(dbManager.EjecutarProcedimiento("INSERTAR_PRENDASELECCIONADA", parameters, true));
        resultado = prenda.getIdPrendaSeleccionada();
        
        return resultado;
    }

    @Override
    public int modificar(PrendaSeleccionada prenda) {
        int resultado = 0;
        Object[] parameters = new Object[3];
        parameters[0] = prenda.getIdPrendaSeleccionada();
        parameters[1] = prenda.getCantidad();
        parameters[2] = prenda.getPrecio();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_PRENDASELECCIONADA", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idPrenda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PrendaSeleccionada> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PrendaSeleccionada obtenerPorId(int idPrenda) {
        PrendaSeleccionada prenda = new PrendaSeleccionada();
        Object[] parameters = new Object[1];
        
        parameters[0] = idPrenda;
        
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PRENDASELECCIONADA_X_ID", parameters);
        
        try {
            while (rs.next()){
                prenda.setIdPrendaSeleccionada(rs.getInt("idPrendaSeleccionada"));
                ///
                Carrito carrito = new Carrito();
                carrito.setIdCarrito(rs.getInt("fidCarrito"));
                prenda.setCarrito(carrito);
                ///
                prenda.setCantidad(rs.getInt("cantidad"));
                prenda.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PrendaSeleccionadaDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PrendaSeleccionadaDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
        return prenda;
    }   
}
