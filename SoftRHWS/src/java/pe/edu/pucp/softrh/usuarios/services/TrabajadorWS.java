package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.bo.TrabajadorBO;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

@WebService(serviceName = "TrabajadorWS", targetNamespace = "softrh.services")
public class TrabajadorWS {

	private TrabajadorBO trabajadorBO;

	public TrabajadorWS() {
		trabajadorBO = new TrabajadorBO();
	}

	@WebMethod(operationName = "insertarTrabajador")
	public Integer insertarTrabajador(String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, LocalTime horarioInicio, LocalTime horarioFin) {
		return trabajadorBO.insertar(dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
	}

	@WebMethod(operationName = "modificarTrabajador")
	public Integer modificarTrabajador(Integer idUsuario, String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, LocalTime horarioInicio, LocalTime horarioFin) {
		return trabajadorBO.modificar(idUsuario, dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
	}

	@WebMethod(operationName = "eliminarTrabajador")
	public Integer eliminarTrabajador(Integer idTrabajador) {
		return trabajadorBO.eliminar(idTrabajador);
	}

	@WebMethod(operationName = "listarTrabajadoresTodos")
	public ArrayList<Trabajador> listarTrabajadoresTodos() {
		return trabajadorBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerTrabajadorPorId")
	public Trabajador obtenerTrabajadorPorId(Integer idTrabajador) {
		return trabajadorBO.obtenerPorId(idTrabajador);
	}
}
