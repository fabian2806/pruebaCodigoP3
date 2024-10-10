package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public interface AdministradorDAO {
	Integer insertar(Administrador administrador);

	Integer modificar(Administrador administrador);

	Integer eliminar(Integer idAdministrador);

	ArrayList<Administrador> listarTodos();

	Administrador obtenerPorId(Integer idAdministrador);
}
