package pe.edu.pucp.softrh.compras.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.model.Carrito;

public interface CarritoDAO {
	Integer insertar(Carrito carrito);

    Integer modificar(Carrito carrito);

    Integer eliminar(Integer idCarrito);

    ArrayList<Carrito> listarTodos();

    Carrito obtenerPorId(Integer idCarrito);
}
