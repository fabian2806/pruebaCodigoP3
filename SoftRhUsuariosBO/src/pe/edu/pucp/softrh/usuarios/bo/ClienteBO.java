package pe.edu.pucp.softrh.usuarios.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.dao.ClienteDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.ClienteDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class ClienteBO {
	private ClienteDAO clienteDAO;

	public ClienteBO() {
		this.clienteDAO = new ClienteDAOImp();
	}

	public Integer insertar(Cliente cliente) {
		return clienteDAO.insertar(cliente);
	}

	public Integer modificar(Cliente cliente) {
		return clienteDAO.modificar(cliente);
	}

	public Integer eliminar(Cliente cliente) {
		return clienteDAO.eliminar(cliente);
	}

	public ArrayList<Cliente> listarTodos() {
		return clienteDAO.listarTodos();
	}

	public Cliente obtenerPorId(String idCliente) {
		return clienteDAO.obtenerPorId(idCliente);
	}
}