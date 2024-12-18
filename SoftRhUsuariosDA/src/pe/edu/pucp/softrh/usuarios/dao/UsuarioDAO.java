package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public interface UsuarioDAO {
    int insertar(Usuario usuario);

    int modificar(Usuario usuario);

    int eliminar(int idUsuario);

    ArrayList<Usuario> listarTodos();

    Usuario obtenerPorId(int idUsuario);
}
