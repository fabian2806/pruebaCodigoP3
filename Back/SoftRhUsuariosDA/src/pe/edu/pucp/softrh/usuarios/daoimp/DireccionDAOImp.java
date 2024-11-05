package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.dao.DireccionDAO;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public class DireccionDAOImp implements DireccionDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Direccion direccion) {
        int resultado = 0;
        Object[] parameters = new Object[8];
        parameters[0] = direccion.getIdDireccion();
        parameters[1] = direccion.getCliente().getIdUsuario();
        parameters[2] = direccion.getDireccion();
        parameters[3] = direccion.getDistrito();
        parameters[4] = direccion.getProvincia();
        parameters[5] = direccion.getDepartamento();
        parameters[6] = direccion.getCodigoPostal();
        parameters[7] = direccion.getReferencia();
        
        direccion.setIdDireccion(dbManager.EjecutarProcedimiento("INSERTAR_DIRECCION", parameters, true));
        resultado = direccion.getIdDireccion();
        
        return resultado;
    }

    @Override
    public int modificar(Direccion direccion) {
        int resultado = 0;
        Object[] parameters = new Object[7];
        parameters[0] = direccion.getIdDireccion();
        parameters[1] = direccion.getDireccion();
        parameters[2] = direccion.getDistrito();
        parameters[3] = direccion.getProvincia();
        parameters[4] = direccion.getDepartamento();
        parameters[5] = direccion.getCodigoPostal();
        parameters[6] = direccion.getReferencia();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_DIRECCION", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idDireccion) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idDireccion;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_DIRECCION", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Direccion> listarTodos() {
        ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_DIRECCIONES_TODAS", null);
        try{
            while(rs.next()){
            Direccion direccion = new Direccion();
            direccion.setIdDireccion(rs.getInt("idDireccion"));
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(rs.getInt("fidCliente"));
            direccion.setCliente(cliente);
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(rs.getString("distrito"));
            direccion.setProvincia(rs.getString("provincia"));
            direccion.setDepartamento(rs.getString("departamento"));
            direccion.setCodigoPostal(rs.getString("codigoPostal"));
            direccion.setReferencia(rs.getString("referencia"));
            
            direcciones.add(direccion);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DireccionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return direcciones;
    }

    @Override
    public Direccion obtenerPorId(int idDireccion) {
        Direccion direccion = new Direccion();
        Object[] parameters = new Object[1];
        parameters[0] = idDireccion;
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_DIRECCION_X_ID", parameters);
        try{
            while(rs.next()){
            direccion.setIdDireccion(rs.getInt("idDireccion"));
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(rs.getInt("fidCliente"));
            direccion.setCliente(cliente);
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(rs.getString("distrito"));
            direccion.setProvincia(rs.getString("provincia"));
            direccion.setDepartamento(rs.getString("departamento"));
            direccion.setCodigoPostal(rs.getString("codigoPostal"));
            direccion.setReferencia(rs.getString("referencia"));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DireccionDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return direccion;
    }
}
