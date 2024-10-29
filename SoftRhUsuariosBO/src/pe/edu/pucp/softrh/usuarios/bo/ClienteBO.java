package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.dao.ClienteDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.ClienteDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class ClienteBO{
	private ClienteDAO clienteDAO;

	public ClienteBO() {
		this.clienteDAO = new ClienteDAOImp();
	}

	public Integer insertar(String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaRegistro, Boolean recibePromociones) {
		Usuario cliente = new Cliente(dni, nombres, apellidos, correo, contrasenha, fechaRegistro, recibePromociones);
		return clienteDAO.insertar((Cliente)cliente);
	}

	public Integer modificar(Cliente cliente) {
		return clienteDAO.modificar(cliente);
	}

	public Integer eliminar(Integer idCliente) {
		return clienteDAO.eliminar(idCliente);
	}

//	public ArrayList<Cliente> listarTodos() {
//		return clienteDAO.listarTodos();
//	}

	public Cliente obtenerPorId(Integer idCliente) {
		return clienteDAO.obtenerPorId(idCliente);
	}
}
