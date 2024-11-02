package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public interface DireccionDAO {
    int insertar(Direccion direccion);

    int modificar(Direccion direccion);

    int eliminar(int idDireccion);

    ArrayList<Direccion> listarTodos();

    Direccion obtenerPorId(int idDireccion);
}
