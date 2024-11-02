package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class TrabajadorDAOImp implements TrabajadorDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Trabajador trabajador) {
        int resultado = 0;
        Object[] parameters = new Object[11];
        parameters[0] = trabajador.getIdUsuario();
        parameters[1] = trabajador.getDni();
        parameters[2] = trabajador.getNombres();
        parameters[3] = trabajador.getApellidos();
        parameters[4] = trabajador.getCorreo();
        parameters[5] = trabajador.getContrasenha();
        parameters[6] = trabajador.getPuesto();
        parameters[7] = trabajador.getSueldo();
        parameters[8] = trabajador.getFechaIngreso();
        parameters[9] = trabajador.getHorarioInicio();
        parameters[10] = trabajador.getHorarioFin();
        
        trabajador.setIdUsuario(dbManager.EjecutarProcedimiento("INSERTAR_TRABAJADOR", parameters, true));
        resultado = trabajador.getIdUsuario();
        
        return resultado;
    }

    @Override
    public int modificar(Trabajador trabajador) {
        int resultado = 0;
        Object[] parameters = new Object[10];
        parameters[0] = trabajador.getIdUsuario();
        parameters[1] = trabajador.getDni();
        parameters[2] = trabajador.getNombres();
        parameters[3] = trabajador.getApellidos();
        parameters[4] = trabajador.getCorreo();
        parameters[5] = trabajador.getContrasenha();
        parameters[6] = trabajador.getPuesto();
        parameters[7] = trabajador.getSueldo();
        parameters[8] = trabajador.getFechaIngreso();
        parameters[9] = trabajador.getHorarioInicio();
        parameters[10] = trabajador.getHorarioFin();
        
        resultado = dbManager.EjecutarProcedimiento("INSERTAR_TRABAJADOR", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idTrabajador) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idTrabajador;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_TRABAJADOR", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Trabajador> listarTodos() {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_TRABAJADORES_TODOS", null);
        try {
            while (rs.next()){
                Trabajador trabajador = new Trabajador();
                trabajador.setIdUsuario(rs.getInt("idUsuario"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setNombres(rs.getString("nombres"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setCorreo(rs.getString("correo"));
                trabajador.setContrasenha(rs.getString("contrasenha"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSueldo(rs.getDouble("sueldo"));
                trabajador.setFechaIngreso(rs.getDate("fechaIngreso"));
                trabajador.setHorarioInicio(rs.getTime("horarioInicio").toLocalTime());
                trabajador.setHorarioFin(rs.getTime("horarioFin").toLocalTime());
                trabajadores.add(trabajador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return trabajadores;
    }

    @Override
    public Trabajador obtenerPorId(int idTrabajador) {
        Trabajador trabajador = new Trabajador();
        Object[] parameters = new Object[1];
        
        parameters[0] = idTrabajador;
        
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_TRABAJADOR_X_ID", parameters);
        try {
            while (rs.next()){
                trabajador.setIdUsuario(rs.getInt("idUsuario"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setNombres(rs.getString("nombres"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setCorreo(rs.getString("correo"));
                trabajador.setContrasenha(rs.getString("contrasenha"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSueldo(rs.getDouble("sueldo"));
                trabajador.setFechaIngreso(rs.getDate("fechaIngreso"));
                trabajador.setHorarioInicio(rs.getTime("horarioInicio").toLocalTime());
                trabajador.setHorarioFin(rs.getTime("horarioFin").toLocalTime());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return trabajador;
    }
}
