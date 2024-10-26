package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public interface UsuarioDAO {
	Integer insertar(Usuario usuario);

	Integer modificar(Usuario usuario);

	Integer eliminar(Integer idUsuario);

	ArrayList<Usuario> listarTodos();

	Usuario obtenerPorId(Integer idUsuario);
}
