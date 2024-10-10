package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public interface TrabajadorDAO {
	Integer insertar(Trabajador trabajador);

	Integer modificar(Trabajador trabajador);

	Integer eliminar(Integer idTrabajador);

	ArrayList<Trabajador> listarTodos();

	Trabajador obtenerPorId(Integer idTrabajador);
}
