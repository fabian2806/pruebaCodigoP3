package pe.edu.pucp.softrh.prendas.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.prendas.dao.PromocionDAO;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class PromocionDAOImp implements PromocionDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Promocion promocion) {
        int resultado = 0;
        Object[] parameters = new Object[9];
        parameters[0] = promocion.getIdPromocion();
        parameters[1] = promocion.getTrabajador().getIdUsuario();
        parameters[2] = promocion.getPrenda(0).getIdPrenda();
        parameters[3] = promocion.getNombre();
        parameters[4] = promocion.getDescripcion();
        parameters[5] = promocion.getValorDescuento();
        parameters[6] = promocion.getTipo().name();
        parameters[7] = promocion.getFechaInicio();
        parameters[8] = promocion.getFechaFin();
        
        promocion.setIdPromocion(dbManager.EjecutarProcedimiento("INSERTAR_PROMOCION", parameters, true));
        resultado = promocion.getIdPromocion();
        
        return resultado;
    }

    @Override
    public int modificar(Promocion promocion) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = promocion.getIdPromocion();
        parameters[1] = promocion.getNombre();
        parameters[2] = promocion.getDescripcion();
        parameters[3] = promocion.getValorDescuento();
        parameters[4] = promocion.getTipo().name();
        parameters[5] = promocion.getFechaInicio();
        parameters[6] = promocion.getFechaFin();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_PROMOCION", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idPromocion) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idPromocion;
        
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_PROMOCION", parameters, false);
        
        return resultado;
        
    }

    @Override
    public ArrayList<Promocion> listarTodos() {
        ArrayList<Promocion> promociones = new ArrayList<Promocion>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PROMOCIONES_TODAS", null);
        try {
            while (rs.next()){
                Promocion promocion = new Promocion();
                promocion.setIdPromocion(rs.getInt("idPromocion"));
                Trabajador trabajador = new Trabajador();
                trabajador.setIdUsuario(rs.getInt("fidTrabajador"));
                promocion.setTrabajador(trabajador);
                promocion.setNombre(rs.getString("nombre"));
                promocion.setDescripcion(rs.getString("descripcion"));
                promocion.setValorDescuento(rs.getDouble("valorDescuento"));
                promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
                promocion.setFechaInicio(rs.getDate("fechaInicio"));
                promocion.setFechaFin(rs.getDate("fechaFin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PromocionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return promociones;
    }

    @Override
    public Promocion obtenerPorId(int idPromocion) {
        Promocion promocion = new Promocion();
        Object[] parameters = new Object[1];
        parameters[0] = idPromocion;
        
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PROMOCION_X_ID", parameters);
        try {
            while (rs.next()){
                promocion.setIdPromocion(rs.getInt("idPromocion"));
                Trabajador trabajador = new Trabajador();
                trabajador.setIdUsuario(rs.getInt("fidTrabajador"));
                promocion.setTrabajador(trabajador);
                promocion.setNombre(rs.getString("nombre"));
                promocion.setDescripcion(rs.getString("descripcion"));
                promocion.setValorDescuento(rs.getDouble("valorDescuento"));
                promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
                promocion.setFechaInicio(rs.getDate("fechaInicio"));
                promocion.setFechaFin(rs.getDate("fechaFin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PromocionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return promocion;
    }
    
    
}
