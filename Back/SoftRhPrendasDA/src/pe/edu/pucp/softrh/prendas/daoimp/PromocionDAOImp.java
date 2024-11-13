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
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.TrabajadorDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class PromocionDAOImp implements PromocionDAO {

	private TrabajadorDAO trabajadorDAO = new TrabajadorDAOImp();
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Promocion promocion) {
        int resultado = 0;
        Object[] parameters = new Object[8];
        parameters[0] = promocion.getIdPromocion();
        parameters[1] = promocion.getTrabajador().getIdUsuario();
        parameters[2] = promocion.getNombre();
        parameters[3] = promocion.getDescripcion();
        parameters[4] = promocion.getValorDescuento();
        parameters[5] = promocion.getTipo().name();
        parameters[6] = promocion.getFechaInicio();
        parameters[7] = promocion.getFechaFin();

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
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
                promocion.setTrabajador(trabajador);
                promocion.setNombre(rs.getString("nombre"));
                promocion.setDescripcion(rs.getString("descripcion"));
                promocion.setValorDescuento(rs.getDouble("valorDescuento"));
                promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
                promocion.setFechaInicio(rs.getDate("fechaInicio"));
                promocion.setFechaFin(rs.getDate("fechaFin"));
				promociones.add(promocion);
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
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
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

	@Override
	public ArrayList<Promocion> listarPorNombreDescripcion(String cadena) {
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		Object[] parameters = new Object[1];
        parameters[0] = cadena;

        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PROMOCIONES_X_NOMBRE_O_DESCRIPCION", parameters);
        try{
            while(rs.next()){
				Promocion promocion = new Promocion();

                promocion.setIdPromocion(rs.getInt("idPromocion"));
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
                promocion.setTrabajador(trabajador);
                promocion.setNombre(rs.getString("nombre"));
                promocion.setDescripcion(rs.getString("descripcion"));
                promocion.setValorDescuento(rs.getDouble("valorDescuento"));
                promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
                promocion.setFechaInicio(rs.getDate("fechaInicio"));
                promocion.setFechaFin(rs.getDate("fechaFin"));
				promocion.setActivo(true);

				promociones.add(promocion);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

		return promociones;
	}
}
