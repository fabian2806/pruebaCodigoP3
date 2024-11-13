package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import java.util.ArrayList;

public interface OrdenCompraDAO {
    int insertar(OrdenCompra orden);

    int modificar(OrdenCompra orden);

    int eliminar(int idOrden);

    ArrayList<OrdenCompra> listarTodos();
    
    OrdenCompra obtenerPorId(int idOrden);

    ArrayList<OrdenCompra> listarPorEstado(String cadena);
}
