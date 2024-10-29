package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.CarritoDAO;
import pe.edu.pucp.softrh.compras.model.Carrito;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.database.config.DBManager;

public class CarritoDAOImp implements CarritoDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();
    
    @Override
    public int insertar(Carrito carrito) {
        int resultado = 0;
        Object[] parameters = new Object[4];
        parameters[0] = carrito.getIdCarrito();
        parameters[1] = carrito.getCliente().getIdUsuario();
        parameters[2] = carrito.getCantidadTotal();
        parameters[3] = carrito.getPrecioTotal();
        
        carrito.setIdCarrito(dbManager.EjecutarProcedimiento("INSERTAR_CARRITO", parameters, true));
        resultado = carrito.getIdCarrito();
        
        return resultado;
    }

    @Override
    public int modificar(Carrito carrito) {
        int resultado = 0;
        Object[] parameters = new Object[3];
        parameters[0] = carrito.getIdCarrito();
        parameters[1] = carrito.getCantidadTotal();
        parameters[2] = carrito.getPrecioTotal();
        
        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_CARRITO", parameters, false);
        
        return resultado;
    }

    @Override
    public int eliminar(int idCarrito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Carrito> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carrito obtenerPorId(int idCarrito) {
        Carrito carrito = new Carrito();
        Object[] parameters = new Object[1];
        
        parameters[0] = idCarrito;
        
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_CARRITO_X_ID", parameters);
        
        try {
            while (rs.next()){
                carrito.setIdCarrito(rs.getInt("idCarrito"));
                ///
                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("fidCliente"));
                carrito.setCliente(cliente);
                //
                carrito.setCantidadTotal(rs.getInt("cantidadTotal"));
                carrito.setPrecioTotal(rs.getDouble("precioTotal"));;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CarritoDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CarritoDAOImp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
        return carrito;
    }

}
