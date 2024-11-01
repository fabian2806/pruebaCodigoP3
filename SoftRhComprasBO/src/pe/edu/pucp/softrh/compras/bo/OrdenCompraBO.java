package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.daoimp.OrdenCompraDAOImp;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;

public class OrdenCompraBO {
	private OrdenCompraDAO ordenCompraDAO;

    public OrdenCompraBO(){
        this.ordenCompraDAO = new OrdenCompraDAOImp();
    }

    public Integer insertar(OrdenCompra orden) {
        return this.ordenCompraDAO.insertar(orden);
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
