package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.dao.AdministradorDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.AdministradorDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Administrador;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class AdministradorBO{
	private AdministradorDAO administradorDAO;

	public AdministradorBO() {
		this.administradorDAO = new AdministradorDAOImp();
	}

	public Integer insertar(String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaCreacion) {
		Usuario administrador = new Administrador(dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
		return administradorDAO.insertar((Administrador)administrador);
	}

	public Integer modificar(Integer idUsuario, String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaCreacion) {
		Usuario administrador = new Administrador(dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
		administrador.setIdUsuario(idUsuario);
		return administradorDAO.modificar((Administrador)administrador);  // Para administrador solo modifico en la tabla padre
		//return administradorDAO.modificar(administrador);
	}

	public Integer eliminar(Integer idAdministrador) {
		return administradorDAO.eliminar(idAdministrador);
		//return administradorDAO.eliminar(idAdministrador);
	}

	public ArrayList<Administrador> listarTodos() {
		return administradorDAO.listarTodos();
	}

	public Administrador obtenerPorId(Integer idAdministrador) {
		return administradorDAO.obtenerPorId(idAdministrador);
	}
}
