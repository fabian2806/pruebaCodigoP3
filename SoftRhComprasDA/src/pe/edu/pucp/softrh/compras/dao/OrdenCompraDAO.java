package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import java.util.ArrayList;

public interface OrdenCompraDAO {
    public Integer insertar(OrdenCompra documento);

    public Integer modificar(OrdenCompra documentoModificada);

    public Integer eliminar(OrdenCompra documento);

    public ArrayList<OrdenCompra> obtenerTodos();

    public OrdenCompra obtenerPorId(Integer idOrden);
}
