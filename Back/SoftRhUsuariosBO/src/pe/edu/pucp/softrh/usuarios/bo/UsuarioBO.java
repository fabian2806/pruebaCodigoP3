package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.UsuarioDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.UsuarioDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class UsuarioBO {
	private UsuarioDAO usuarioDAO;

	public UsuarioBO() {
		this.usuarioDAO = new UsuarioDAOImp();
	}

	public Integer insertar(Usuario usuario) {
		return usuarioDAO.insertar(usuario);
	}

	public Integer modificar(Usuario usuario) {
		return usuarioDAO.modificar(usuario);
	}

	public Integer eliminar(Integer idUsuario) {
		return usuarioDAO.eliminar(idUsuario);
	}

	public ArrayList<Usuario> listarTodos() {
		return usuarioDAO.listarTodos();
	}

	public Usuario obtenerPorId(Integer idUsuario) {
		return usuarioDAO.obtenerPorId(idUsuario);
	}

	public Integer verificarIngresoUsuario(String correo, String contrasenha) {
		return usuarioDAO.verificarIngresoUsuario(correo, contrasenha);
	}

	public String obtenerRolUsuario(String correo, String contrasenha) {
		return usuarioDAO.obtenerRolUsuario(correo, contrasenha);
	}
}
