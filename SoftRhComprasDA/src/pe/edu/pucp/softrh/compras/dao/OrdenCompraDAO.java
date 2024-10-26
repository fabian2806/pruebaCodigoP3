package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import java.util.ArrayList;

public interface OrdenCompraDAO {
    Integer insertar(OrdenCompra orden);

    Integer modificar(OrdenCompra orden);

    Integer eliminar(Integer idOrden);

    ArrayList<OrdenCompra> listarTodos();

    OrdenCompra obtenerPorId(Integer idOrden);
}
