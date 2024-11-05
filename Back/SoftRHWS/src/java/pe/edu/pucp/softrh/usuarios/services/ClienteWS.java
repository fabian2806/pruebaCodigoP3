package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.bo.ClienteBO;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

@WebService(serviceName = "ClienteWS", targetNamespace = "softrh.services")
public class ClienteWS {

	private final ClienteBO clienteBO;

	public ClienteWS() {
		clienteBO = new ClienteBO();
	}

	@WebMethod(operationName = "insertarCliente")
	public Integer insertarCliente(String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaRegistro, Boolean recibePromociones) {
		return clienteBO.insertar(dni, nombres, apellidos, correo, contrasenha, fechaRegistro, recibePromociones);
	}

	@WebMethod(operationName = "modificarCliente")
	public Integer modificarCliente(Integer idUsuario, String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaRegistro, Boolean recibePromociones) {
		return clienteBO.modificar(idUsuario, dni, nombres, apellidos, correo, contrasenha, fechaRegistro, recibePromociones);
	}

	@WebMethod(operationName = "eliminarCliente")
	public Integer eliminarCliente(Integer idCliente) {
		return clienteBO.eliminar(idCliente);
	}

	@WebMethod(operationName = "listarClientesTodos")
	public ArrayList<Cliente> listarClientesTodos() {
		return clienteBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerClientePorId")
	public Cliente obtenerClientePorId(Integer idCliente) {
		return clienteBO.obtenerPorId(idCliente);
	}
}
