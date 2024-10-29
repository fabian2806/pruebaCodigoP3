package pe.edu.pucp.softrh.compras.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.model.Carrito;

public interface CarritoDAO {
    int insertar(Carrito carrito);

    int modificar(Carrito carrito);

    int eliminar(int idCarrito);

    ArrayList<Carrito> listarTodos();

    Carrito obtenerPorId(int idCarrito);
}
