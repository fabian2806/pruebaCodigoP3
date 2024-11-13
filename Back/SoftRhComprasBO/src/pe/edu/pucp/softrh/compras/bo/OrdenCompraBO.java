package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.daoimp.OrdenCompraDAOImp;
import pe.edu.pucp.softrh.compras.model.Estado;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class OrdenCompraBO {
    private OrdenCompraDAO ordenCompraDAO;

    public OrdenCompraBO(){
        this.ordenCompraDAO = new OrdenCompraDAOImp();
    }

    public Integer insertar(Date fechaRegistro, Date fechaProcesado,
            Date fechaEntregado,Date fechaAnulado, Estado estado,String dni,
            String correo, Double subtotal, Cliente cliente) {
        OrdenCompra orden = new OrdenCompra(fechaRegistro,fechaProcesado,fechaEntregado,
                fechaAnulado, estado, dni, correo, subtotal, cliente);
        orden.setIdOrden(ordenCompraDAO.insertar(orden));
        return orden.getIdOrden();
    }

    public Integer modificar(Integer IdOrdenCompra, Date fechaRegistro, Date fechaProcesado,
            Date fechaEntregado,Date fechaAnulado, Estado estado,String dni,
            String correo, Double subtotal, Cliente cliente){
        OrdenCompra orden = new OrdenCompra(fechaRegistro,fechaProcesado,fechaEntregado,
                fechaAnulado, estado, dni, correo, subtotal, cliente);
        orden.setIdOrden(IdOrdenCompra);
        return ordenCompraDAO.modificar(orden);
    }

    public Integer eliminar(Integer idOrden){
        return this.ordenCompraDAO.eliminar(idOrden);
    }

    public ArrayList<OrdenCompra> listarTodos() {
        return this.ordenCompraDAO.listarTodos();
    }
    
    public OrdenCompra obtenerPorId(Integer idOrden) {
        return this.ordenCompraDAO.obtenerPorId(idOrden);
    }
    
    public ArrayList<OrdenCompra> listarPorEstado(String cadena) {
        return this.ordenCompraDAO.listarPorEstado(cadena);
    }
}
