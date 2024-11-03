package pe.edu.pucp.softrh.prendas.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.prendas.bo.PromocionBO;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

@WebService(serviceName = "PromocionWS", targetNamespace = "softrh.services")
public class PromocionWS {

	private final PromocionBO promocionBO;

	public PromocionWS(){
		this.promocionBO = new PromocionBO();
	}

	@WebMethod(operationName = "insertarPromocion")
	public Integer insertarPromocion(String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, Date fechaInicio, Date fechaFin, Trabajador trabajador, Prenda prenda) {
		return promocionBO.insertar(nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, trabajador, prenda);
	}

	@WebMethod(operationName = "modificarPromocion")
	public Integer modificarPromocion(Integer idPromocion, String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, Date fechaInicio, Date fechaFin, Trabajador trabajador, Prenda prenda) {
		return promocionBO.modificar(idPromocion, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, trabajador, prenda);
	}

	@WebMethod(operationName = "eliminarPromocion")
	public Integer eliminarPromocion(Integer idPromocion) {
		return promocionBO.eliminar(idPromocion);
	}

	@WebMethod(operationName = "listarPromocionesTodas")
	public ArrayList<Promocion> listarPromocionesTodas() {
		return promocionBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerPromocionPorId")
	public Promocion obtenerPromocionPorId(Integer idPromocion) {
		return promocionBO.obtenerPorId(idPromocion);
	}

	@WebMethod(operationName = "listarPromocionesPorNombre")
	public ArrayList<Promocion> listarPromocionesPorNombre(String nombre) {
		return promocionBO.listarPorNombre(nombre);
	}
}
