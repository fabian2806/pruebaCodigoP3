package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.CuponDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.CuponDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Cupon;

public class CuponBO {
	private CuponDAO cuponDAO;

	public CuponBO() {
		this.cuponDAO = new CuponDAOImp();
	}

	public Integer insertar(Cupon cupon) {
		return cuponDAO.insertar(cupon);
	}

	public Integer modificar(Cupon cupon) {
		return cuponDAO.modificar(cupon);
	}

	public Integer eliminar(Cupon cupon) {
		return cuponDAO.eliminar(cupon);
	}

	public ArrayList<Cupon> listarTodos() {
		return cuponDAO.listarTodos();
	}

	public Cupon obtenerPorId(String idCupon) {
		return cuponDAO.obtenerPorId(idCupon);
	}
}
