package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.UsuarioDAO;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class UsuarioDAOImp implements UsuarioDAO{

	private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerPorId(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
	public int verificarIngresoUsuario(String correo, String contrasenha) {
		Integer resultado = 0;

		Object[] parameters = new Object[2];
        parameters[0] = correo;
		parameters[1] = contrasenha;

        rs = dbManager.EjecutarProcedimientoLectura("VERIFICAR_INGRESO_USUARIO", parameters);

        try {
            if(rs.next()) {
                resultado = rs.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        return resultado;
	}

	@Override
	public String obtenerRolUsuario(String correo, String contrasenha) {
		String rol = "";

		Object[] parameters = new Object[2];
        parameters[0] = correo;
		parameters[1] = contrasenha;

        rs = dbManager.EjecutarProcedimientoLectura("OBTENER_ROL_USUARIO", parameters);

        try {
            if(rs.next()) {
                rol = rs.getString("rol");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

		return rol;
	}

	@Override
	public int verificarContrasenha(Integer idUsuario, String contrasenha) {
		Integer resultado = 0;

		Object[] parameters = new Object[2];
        parameters[0] = idUsuario;
		parameters[1] = contrasenha;

        rs = dbManager.EjecutarProcedimientoLectura("VERIFICAR_CONTRASENHA", parameters);

        try {
            if(rs.next()) {
                resultado = rs.getInt("resultado");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClienteDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        return resultado;
	}

	@Override
	public int cambiarContrasenha(Integer idUsuario, String nuevaContrasenha) {
		int resultado = 0;

		Object[] parameters = new Object[2];
        parameters[0] = idUsuario;
        parameters[1] = nuevaContrasenha;

        resultado = dbManager.EjecutarProcedimiento("CAMBIAR_CONTRASENHA", parameters, false);

        return resultado;
	}
}
