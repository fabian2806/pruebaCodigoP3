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

	public Integer modificar(Integer idUsuario, String nombres, String apellidos) {
		return usuarioDAO.modificar(idUsuario, nombres, apellidos);
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

	public Integer verificarContrasenha(Integer idUsuario, String contrasenha) {
		return usuarioDAO.verificarContrasenha(idUsuario, contrasenha);
	}

	public Integer cambiarContrasenha(Integer idUsuario, String contrasenhaNueva) {
		return usuarioDAO.cambiarContrasenha(idUsuario, contrasenhaNueva);
	}

	public Integer resetearContrasenha(Integer idUsuario) {
		return usuarioDAO.resetearContrasenha(idUsuario);
	}
}
