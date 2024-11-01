package pe.edu.pucp.softrh.usuarios.daoimp;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.ClienteDAO;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class ClienteDAOImp implements ClienteDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Cliente cliente) {
        int resultado = 0;
        Object[] parameters = new Object[9];
        parameters[0] = cliente.getIdUsuario();
        parameters[1] = cliente.getDni();
        parameters[2] = cliente.getNombres();
        parameters[3] = cliente.getApellidos();
        parameters[4] = cliente.getCorreo();
        parameters[5] = cliente.getContrasenha();
        parameters[6] = cliente.getTelefono();
        parameters[7] = cliente.getFechaRegistro();
        parameters[8] = cliente.getRecibePromociones();
        
        cliente.setIdUsuario(dbManager.EjecutarProcedimiento("INSERTAR_CLIENTE", parameters, true));
        resultado = cliente.getIdUsuario();
        
        return resultado;
    }

    @Override
    public int modificar(Cliente cliente) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = cliente.getIdUsuario();
        parameters[1] = cliente.getDni();
        parameters[2] = cliente.getNombres();
        parameters[3] = cliente.getApellidos();
        parameters[4] = cliente.getCorreo();
        parameters[5] = cliente.getContrasenha();
        parameters[6] = cliente.getTelefono();
        parameters[7] = cliente.getFechaRegistro();
        parameters[8] = cliente.getRecibePromociones();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_CLIENTE", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idCliente) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idCliente;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_CLIENTE", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CLIENTES_TODOS", null);
        
        try {
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("idUsuario"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContrasenha(rs.getString("contrasenha"));
                cliente.setTelefono(rs.getString(""));
                cliente.setFechaRegistro(rs.getDate("fechaRegistro"));
                cliente.setRecibePromociones(rs.getBoolean("recibePromociones"));
                clientes.add(cliente);
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
   
        
        return clientes;
    }

    @Override
    public Cliente obtenerPorId(int idCliente) {
        
        Cliente cliente = new Cliente();
        Object[] parameters = new Object[1];
        
        parameters[0] = idCliente;
        
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CLIENTE_X_ID", parameters);
        
        try {
            while (rs.next()){
                cliente.setIdUsuario(rs.getInt("idUsuario"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContrasenha(rs.getString("contrasenha"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFechaRegistro(rs.getDate("fechaRegistro"));
                cliente.setRecibePromociones(rs.getBoolean("recibePromociones"));
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
        
        return cliente;
    }
}
