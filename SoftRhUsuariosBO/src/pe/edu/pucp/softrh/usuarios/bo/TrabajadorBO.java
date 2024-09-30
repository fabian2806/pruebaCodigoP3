package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.TrabajadorDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class TrabajadorBO {
	private TrabajadorDAO trabajadorDAO;

	public TrabajadorBO() {
		this.trabajadorDAO = new TrabajadorDAOImp();
	}

	public Integer insertar(Trabajador trabajador) {
		return trabajadorDAO.insertar(trabajador);
	}

	public Integer modificar(Trabajador trabajador) {
		return trabajadorDAO.modificar(trabajador);
	}

	public Integer eliminar(Trabajador trabajador) {
		return trabajadorDAO.eliminar(trabajador);
	}

	public ArrayList<Trabajador> listarTodos() {
		return trabajadorDAO.listarTodos();
	}

	public Trabajador obtenerPorId(String idtrabajador) {
		return trabajadorDAO.obtenerPorId(idtrabajador);
	}
}
