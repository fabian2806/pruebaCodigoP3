package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public interface AdministradorDAO {
	public Integer insertar(Administrador administrador);

	public Integer modificar(Administrador administrador);

	public Integer eliminar(Administrador administrador);

	public ArrayList<Administrador> listarTodos();

	public Administrador obtenerPorId(String idAdministrador);
}
