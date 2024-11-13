package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public interface UsuarioDAO {
    int insertar(Usuario usuario);

    int modificar(Integer idUsuario, String nombres, String apellidos);

    int eliminar(int idUsuario);

    ArrayList<Usuario> listarTodos();

    Usuario obtenerPorId(int idUsuario);

    int verificarIngresoUsuario(String correo, String contrasenha);

	String obtenerRolUsuario(String correo, String contrasenha);

	int verificarContrasenha(Integer idUsuario, String contrasenha);

	int cambiarContrasenha(Integer idUsuario, String nuevaContrasenha);

	int resetearContrasenha(Integer idUsuario);
}
