package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.AdministradorDAO;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public class AdministradorDAOImp implements AdministradorDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Administrador administrador) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = administrador.getIdUsuario();
        parameters[1] = administrador.getDni();
        parameters[2] = administrador.getNombres();
        parameters[3] = administrador.getApellidos();
        parameters[4] = administrador.getCorreo();
        parameters[5] = administrador.getContrasenha();
        parameters[6] = administrador.getFechaCreacion();
        
        administrador.setIdUsuario(dbManager.EjecutarProcedimiento("INSERTAR_ADMINISTRADOR", parameters, true));
        resultado = administrador.getIdUsuario();
        
        return resultado;
    }

    @Override
    public int modificar(Administrador administrador) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = administrador.getIdUsuario();
        parameters[1] = administrador.getDni();
        parameters[2] = administrador.getNombres();
        parameters[3] = administrador.getApellidos();
        parameters[4] = administrador.getCorreo();
        parameters[5] = administrador.getContrasenha();
        parameters[6] = administrador.getFechaCreacion();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_ADMINISTRADOR", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idAdministrador) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idAdministrador;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_ADMINISTRADOR", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_ADMINISTRADORES_TODOS", null);
        try {
            while (rs.next()){
                Administrador administrador = new Administrador();
                administrador.setIdUsuario(rs.getInt("idUsuario"));
                administrador.setDni(rs.getString("dni"));
                administrador.setNombres(rs.getString("nombres"));
                administrador.setApellidos(rs.getString("apellidos"));
                administrador.setCorreo(rs.getString("correo"));
                administrador.setContrasenha(rs.getString("contrasenha"));
                administrador.setFechaCreacion(rs.getDate("fechaCreacion"));
                
                administradores.add(administrador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return administradores;
    }

    @Override
    public Administrador obtenerPorId(int idAdministrador) {
        Administrador administrador = new Administrador();
        Object[] parameters = new Object[1];
        parameters[0] = idAdministrador;
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_ADMINISTRADOR_X_ID", parameters);
        try {
            while (rs.next()){
                administrador.setIdUsuario(rs.getInt("idUsuario"));
                administrador.setDni(rs.getString("dni"));
                administrador.setNombres(rs.getString("nombres"));
                administrador.setApellidos(rs.getString("apellidos"));
                administrador.setCorreo(rs.getString("correo"));
                administrador.setContrasenha(rs.getString("contrasenha"));
                administrador.setFechaCreacion(rs.getDate("fechaCreacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return administrador;
    }
    
}
