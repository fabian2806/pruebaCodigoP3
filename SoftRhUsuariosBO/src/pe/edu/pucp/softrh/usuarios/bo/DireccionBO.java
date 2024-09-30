package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.DireccionDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.DireccionDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public class DireccionBO {
	private DireccionDAO direccionDAO;

	public DireccionBO() {
		this.direccionDAO = new DireccionDAOImp();
	}

	public Integer insertar(Direccion direccion) {
		return direccionDAO.insertar(direccion);
	}

	public Integer modificar(Direccion direccion) {
		return direccionDAO.modificar(direccion);
	}

	public Integer eliminar(Direccion direccion) {
		return direccionDAO.eliminar(direccion);
	}

	public ArrayList<Direccion> listarTodos() {
		return direccionDAO.listarTodos();
	}

	public Direccion obtenerPorId(String idDireccion) {
		return direccionDAO.obtenerPorId(idDireccion);
	}
}
