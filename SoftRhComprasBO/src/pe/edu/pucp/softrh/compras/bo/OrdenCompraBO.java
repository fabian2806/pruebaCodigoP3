package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.daoimp.OrdenCompraDAOImp;
import pe.edu.pucp.softrh.compras.model.Carrito;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class OrdenCompraBO {
	private OrdenCompraDAO ordenCompraDAO;

    public OrdenCompraBO(){
        this.ordenCompraDAO = new OrdenCompraDAOImp();
    }

    public Integer insertar(Date fechaRegistro, String dni, String correo, Double subtotal, 
            Cliente cliente, Carrito carrito) {
        OrdenCompra orden = new OrdenCompra(fechaRegistro,dni,correo,subtotal,cliente,carrito);
        return this.ordenCompraDAO.insertar((OrdenCompra)orden);
    }

    public Integer modificar(OrdenCompra orden){
		return this.ordenCompraDAO.modificar(orden);  //la prenda ya modificada
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
}
