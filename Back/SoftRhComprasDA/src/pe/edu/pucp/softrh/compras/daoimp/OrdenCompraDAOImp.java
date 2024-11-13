package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.compras.model.Estado;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class OrdenCompraDAOImp  implements OrdenCompraDAO {

    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(OrdenCompra orden) {
        int resultado = 0;
        Object[] parameters = new Object[10];
        parameters[0] = orden.getIdOrden();
        parameters[1] = orden.getCliente().getIdUsuario();
        parameters[2] = orden.getFechaRegistro();
        parameters[3] = orden.getFechaProcesado();
        parameters[4] = orden.getFechaEntregado();
        parameters[5] = orden.getFechaAnulado();
        parameters[6] = orden.getEstado().name();
        parameters[7] = orden.getDni();
        parameters[8] = orden.getCorreo();
        parameters[9] = orden.getSubtotal();

        orden.setIdOrden(dbManager.EjecutarProcedimiento("INSERTAR_ORDENCOMPRA",
                parameters, true));
        resultado = orden.getIdOrden();

        return resultado;
    }

    @Override
    public int modificar(OrdenCompra orden) {
        int resultado = 0;
        Object[] parameters = new Object[9];
        parameters[0] = orden.getIdOrden();
        parameters[1] = orden.getFechaRegistro();
        parameters[2] = orden.getFechaProcesado();
        parameters[3] = orden.getFechaEntregado();
        parameters[4] = orden.getFechaAnulado();
        parameters[5] = orden.getEstado().name();
        parameters[6] = orden.getDni();
        parameters[7] = orden.getCorreo();
        parameters[8] = orden.getSubtotal();

        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_ORDENCOMPRA",
                parameters, false);

        return resultado;
    }

    @Override
    public int eliminar(int idOrden) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idOrden;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_ORDENCOMPRA",
                parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<OrdenCompra> listarTodos() {
        ArrayList<OrdenCompra> ordenes = new ArrayList<OrdenCompra>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_ORDENESCOMPRA_TODAS", null);

        try {
            while (rs.next()){
                OrdenCompra orden = new OrdenCompra();

                orden.setIdOrden(rs.getInt("idOrden"));

                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("fidCliente"));
                orden.setCliente(cliente);

                orden.setFechaRegistro(rs.getDate("fechaRegistro"));
                orden.setFechaProcesado(rs.getDate("fechaProcesado"));
                orden.setFechaEntregado(rs.getDate("fechaEntregado"));
                orden.setFechaAnulado(rs.getDate("fechaAnulado"));

                orden.setEstado(Estado.valueOf(rs.getString("estado")));
                orden.setDni(rs.getString("dni"));
                orden.setCorreo(rs.getString("correo"));
                orden.setSubtotal(rs.getDouble("subtotal"));

                ordenes.add(orden);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ordenes;
    }

    @Override
    public OrdenCompra obtenerPorId(int idOrden) {
        OrdenCompra orden = new OrdenCompra();
        Object[] parameters = new Object[1];
        parameters[0] = idOrden;
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_ORDENCOMPRA_X_ID", parameters);

        try {
            while (rs.next()){
                orden.setIdOrden(rs.getInt("idOrden"));

                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("fidCliente"));
                orden.setCliente(cliente);

                orden.setFechaRegistro(rs.getDate("fechaRegistro"));
                orden.setFechaProcesado(rs.getDate("fechaProcesado"));
                orden.setFechaEntregado(rs.getDate("fechaEntregado"));
                orden.setFechaAnulado(rs.getDate("fechaAnulado"));

                orden.setEstado(Estado.valueOf(rs.getString("estado")));
                orden.setDni(rs.getString("dni"));
                orden.setCorreo(rs.getString("correo"));
                orden.setSubtotal(rs.getDouble("subtotal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return orden;
    }

	@Override
    public  ArrayList<OrdenCompra> listarPorEstado(String cadena) {

        ArrayList<OrdenCompra> ordenes = new ArrayList<OrdenCompra>();

        Object[] parameters = new Object[1];
        parameters[0] = cadena;

        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_ORDENESCOMPRA_X_ESTADO", parameters);
        try{
            while(rs.next()){
                OrdenCompra orden = new OrdenCompra();

                orden.setIdOrden(rs.getInt("idOrden"));

                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("fidCliente"));
                orden.setCliente(cliente);

                orden.setFechaRegistro(rs.getDate("fechaRegistro"));
                orden.setFechaProcesado(rs.getDate("fechaProcesado"));
                orden.setFechaEntregado(rs.getDate("fechaEntregado"));
                orden.setFechaAnulado(rs.getDate("fechaAnulado"));

                orden.setEstado(Estado.valueOf(rs.getString("estado")));
                orden.setDni(rs.getString("dni"));
                orden.setCorreo(rs.getString("correo"));
                orden.setSubtotal(rs.getDouble("subtotal"));

                ordenes.add(orden);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ordenes;
    }
}
