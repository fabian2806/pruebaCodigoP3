package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public interface TrabajadorDAO {
	public Integer insertar(Trabajador trabajador);

	public Integer modificar(Trabajador trabajador);

	public Integer eliminar(Trabajador trabajador);

	public ArrayList<Trabajador> listarTodos();

	public Trabajador obtenerPorId(String idTrabajador);
}
