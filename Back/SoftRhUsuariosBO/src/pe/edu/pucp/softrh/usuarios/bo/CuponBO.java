package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.dao.CuponDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.CuponDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class CuponBO {
	private CuponDAO cuponDAO;

	public CuponBO() {
		this.cuponDAO = new CuponDAOImp();
	}

	public Integer insertar(String codigo, String descripcion, Double valorDescuento, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
		Cupon cupon = new Cupon(codigo, descripcion, valorDescuento, fechaInicio, fechaFin, trabajador);
		cupon.setIdCupon(cuponDAO.insertar(cupon));
		return cupon.getIdCupon();
	}

	public Integer modificar(Integer idCupon, String codigo, String descripcion, Double valorDescuento, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
		Cupon cupon = new Cupon(codigo, descripcion, valorDescuento, fechaInicio, fechaFin, trabajador);
		cupon.setIdCupon(idCupon);
		return cuponDAO.modificar(cupon);
	}

	public Integer eliminar(Integer idCupon) {
		return cuponDAO.eliminar(idCupon);
	}

	public ArrayList<Cupon> listarTodos() {
		return cuponDAO.listarTodos();
	}

	public Cupon obtenerPorId(Integer idCupon) {
		return cuponDAO.obtenerPorId(idCupon);
	}

	public ArrayList<Cupon> listarPorCodigoDescripcion(String cadena) {
		return cuponDAO.listarPorCodigoDescripcion(cadena);
	}
}
