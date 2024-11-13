package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.bo.CuponBO;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

@WebService(serviceName = "CuponWS", targetNamespace = "softrh.services")
public class CuponWS {

	private final CuponBO cuponBO;

	public CuponWS() {
		cuponBO = new CuponBO();
	}

	@WebMethod(operationName = "insertarCupon")
	public Integer insertarCupon(String codigo, String descripcion, Double valorDescuento, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
		return cuponBO.insertar(codigo, descripcion, valorDescuento, fechaInicio, fechaFin, trabajador);
	}

	@WebMethod(operationName = "modificarCupon")
	public Integer modificarCupon(Integer idCupon, String codigo, String descripcion, Double valorDescuento, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
		return cuponBO.modificar(idCupon, codigo, descripcion, valorDescuento, fechaInicio, fechaFin, trabajador);
	}

	@WebMethod(operationName = "eliminarCupon")
	public Integer eliminarCupon(Integer idCupon) {
		return cuponBO.eliminar(idCupon);
	}

	@WebMethod(operationName = "listarCuponesTodos")
	public ArrayList<Cupon> listarCuponesTodos() {
		return cuponBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerCuponPorId")
	public Cupon obtenerCuponPorId(Integer idCupon) {
		return cuponBO.obtenerPorId(idCupon);
	}

	@WebMethod(operationName = "listarCuponesPorCodigoDescripcion")
	public ArrayList<Cupon> listarCuponesPorCodigoDescripcion(String cadena) {
		return cuponBO.listarPorCodigoDescripcion(cadena);
	}
}
