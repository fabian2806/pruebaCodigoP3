package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cupon;

public interface CuponDAO {
	public Integer insertar(Cupon cupon);

	public Integer modificar(Cupon cupon);

	public Integer eliminar(Cupon cupon);

	public ArrayList<Cupon> listarTodos();

	public Cupon obtenerPorId(String idCupon);
}
