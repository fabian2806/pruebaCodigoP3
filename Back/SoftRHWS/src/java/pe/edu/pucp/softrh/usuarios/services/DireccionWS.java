package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.bo.DireccionBO;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

@WebService(serviceName = "DireccionWS", targetNamespace = "softrh.services")
public class DireccionWS {

	private final DireccionBO direccionBO;

	public DireccionWS() {
		direccionBO = new DireccionBO();
	}

	@WebMethod(operationName = "insetarDireccion")
	public Integer insetarDireccion(String direc, String distrito, String provincia, String departamento, String codigoPostal, String referencia, Cliente cliente) {
		return direccionBO.insertar(direc, distrito, provincia, departamento, codigoPostal, referencia, cliente);
	}

	@WebMethod(operationName = "modificarDireccion")
	public Integer modificarDireccion(Integer idDireccion, String direc, String distrito, String provincia, String departamento, String codigoPostal, String referencia, Cliente cliente) {
		return direccionBO.modificar(idDireccion, direc, distrito, provincia, departamento, codigoPostal, referencia, cliente);
	}

	@WebMethod(operationName = "eliminarDireccion")
	public Integer eliminarDireccion(Integer idDireccion) {
		return direccionBO.eliminar(idDireccion);
	}

	@WebMethod(operationName = "listarDireccionesTodas")
	public ArrayList<Direccion> listarDireccionesTodas() {
		return direccionBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerDireccionPorId")
	public Direccion obtenerDireccionPorId(Integer idDireccion) {
		return direccionBO.obtenerPorId(idDireccion);
	}
}
