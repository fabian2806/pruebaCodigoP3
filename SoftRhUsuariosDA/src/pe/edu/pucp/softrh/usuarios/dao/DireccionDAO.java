package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public interface DireccionDAO {
	public Integer insertar(Direccion direccion);

	public Integer modificar(Direccion direccion);

	public Integer eliminar(Direccion direccion);

	public ArrayList<Direccion> listarTodos();

	public Direccion obtenerPorId(String idDireccion);
}
