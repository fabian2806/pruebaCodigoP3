package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrador obtenerPorId(int idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
