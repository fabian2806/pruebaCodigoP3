package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.bo.AdministradorBO;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

@WebService(serviceName = "AdministradorWS", targetNamespace = "softrh.services")
public class AdministradorWS {

	private final AdministradorBO administradorBO;

	public AdministradorWS() {
		administradorBO = new AdministradorBO();
	}

	@WebMethod(operationName = "insetarAdministrador")
	public Integer insetarAdministrador(String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaCreacion) {
		return administradorBO.insertar(dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
	}

	@WebMethod(operationName = "modificarAdministrador")
	public Integer modificarAdministrador(Integer idUsuario, String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaCreacion) {
		return administradorBO.modificar(idUsuario, dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
	}

	@WebMethod(operationName = "eliminarAdministrador")
	public Integer eliminarAdministrador(Integer idAdministrador) {
		return administradorBO.eliminar(idAdministrador);
	}

	@WebMethod(operationName = "listarAdministradoresTodos")
	public ArrayList<Administrador> listarAdministradoresTodos() {
		return administradorBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerAdministradorPorId")
	public Administrador obtenerAdministradorPorId(Integer idAdministrador) {
		return administradorBO.obtenerPorId(idAdministrador);
	}
}
