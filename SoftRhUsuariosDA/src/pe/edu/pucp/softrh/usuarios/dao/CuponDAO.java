package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cupon;

public interface CuponDAO {
	Integer insertar(Cupon cupon);

	Integer modificar(Cupon cupon);

	Integer eliminar(Integer idCupon);

	ArrayList<Cupon> listarTodos();

	Cupon obtenerPorId(Integer idCupon);
}
