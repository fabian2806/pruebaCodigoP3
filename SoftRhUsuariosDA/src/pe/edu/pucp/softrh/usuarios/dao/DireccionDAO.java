package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public interface DireccionDAO {
	Integer insertar(Direccion direccion);

	Integer modificar(Direccion direccion);

	Integer eliminar(Integer idDireccion);

	ArrayList<Direccion> listarTodos();

	Direccion obtenerPorId(Integer idDireccion);
}
