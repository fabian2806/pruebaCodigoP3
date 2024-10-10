package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.AdministradorDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.AdministradorDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public class AdministradorBO {
	private AdministradorDAO administradorDAO;

	public AdministradorBO() {
		this.administradorDAO = new AdministradorDAOImp();
	}

	public Integer insertar(Administrador administrador) {
		return administradorDAO.insertar(administrador);
	}

	public Integer modificar(Administrador administrador) {
		return administradorDAO.modificar(administrador);
	}

	public Integer eliminar(Integer idAdministrador) {
		return administradorDAO.eliminar(idAdministrador);
	}

	public ArrayList<Administrador> listarTodos() {
		return administradorDAO.listarTodos();
	}

	public Administrador obtenerPorId(Integer idAdministrador) {
		return administradorDAO.obtenerPorId(idAdministrador);
	}
}
