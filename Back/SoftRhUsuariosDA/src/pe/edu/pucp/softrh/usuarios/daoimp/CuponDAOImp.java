package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.CuponDAO;
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class CuponDAOImp implements CuponDAO {

	private TrabajadorDAO trabajadorDAO = new TrabajadorDAOImp();
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Cupon cupon) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = cupon.getIdCupon();
        parameters[1] = cupon.getTrabajador().getIdUsuario();
        parameters[2] = cupon.getCodigo();
        parameters[3] = cupon.getDescripcion();
		parameters[4] = cupon.getValorDescuento();
        parameters[5] = cupon.getFechaInicio();
        parameters[6] = cupon.getFechaFin();

        cupon.setIdCupon(dbManager.EjecutarProcedimiento("INSERTAR_CUPON", parameters, true));
        resultado = cupon.getIdCupon();

        return resultado;
    }

    @Override
    public int modificar(Cupon cupon) {
        int resultado = 0;
        Object[] parameters = new Object[6];
        parameters[0] = cupon.getIdCupon();
        parameters[1] = cupon.getCodigo();
        parameters[2] = cupon.getDescripcion();
		parameters[3] = cupon.getValorDescuento();
        parameters[4] = cupon.getFechaInicio();
        parameters[5] = cupon.getFechaFin();

        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_CUPON", parameters, false);

        return resultado;
    }

    @Override
    public int eliminar(int idCupon) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idCupon;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_CUPON", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Cupon> listarTodos() {
        ArrayList<Cupon> cupones = new ArrayList<Cupon>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CUPONES_TODOS", null);

        try {
            while (rs.next()){
                Cupon cupon = new Cupon();
                cupon.setIdCupon(rs.getInt("idCupon"));
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
                cupon.setTrabajador(trabajador);
                cupon.setCodigo(rs.getString("codigo"));
                cupon.setDescripcion(rs.getString("descripcion"));
				cupon.setValorDescuento(rs.getDouble("valorDescuento"));
                cupon.setFechaInicio(rs.getDate("fechaInicio"));
                cupon.setFechaFin(rs.getDate("fechaFin"));
				cupon.setActivo(true);
                cupones.add(cupon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cupones;
    }

    @Override
    public Cupon obtenerPorId(int idCupon) {
        Cupon cupon = new Cupon();
        Object[] parameters = new Object[1];
        parameters[0] = idCupon;
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CUPON_X_ID", parameters);

        try {
            while (rs.next()){
                cupon.setIdCupon(rs.getInt("idCupon"));
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
                cupon.setTrabajador(trabajador);
                cupon.setCodigo(rs.getString("codigo"));
                cupon.setDescripcion(rs.getString("descripcion"));
				cupon.setValorDescuento(rs.getDouble("valorDescuento"));
                cupon.setFechaInicio(rs.getDate("fechaInicio"));
                cupon.setFechaFin(rs.getDate("fechaFin"));
				cupon.setActivo(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cupon;
    }

	@Override
	public ArrayList<Cupon> listarPorCodigoDescripcion(String cadena) {
		ArrayList<Cupon> cupones = new ArrayList<Cupon>();

		Object[] parameters = new Object[1];
        parameters[0] = cadena;

        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CUPONES_X_CODIGO_O_DESCRIPCION", parameters);

        try {
            while (rs.next()){
                Cupon cupon = new Cupon();

                cupon.setIdCupon(rs.getInt("idCupon"));
                Trabajador trabajador = trabajadorDAO.obtenerPorId(rs.getInt("fidTrabajador"));
                cupon.setTrabajador(trabajador);
                cupon.setCodigo(rs.getString("codigo"));
                cupon.setDescripcion(rs.getString("descripcion"));
				cupon.setValorDescuento(rs.getDouble("valorDescuento"));
                cupon.setFechaInicio(rs.getDate("fechaInicio"));
                cupon.setFechaFin(rs.getDate("fechaFin"));
				cupon.setActivo(true);
                cupones.add(cupon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(CuponDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cupones;
	}
}
