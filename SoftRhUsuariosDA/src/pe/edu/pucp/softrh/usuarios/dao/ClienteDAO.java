package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public interface ClienteDAO {
	public Integer insertar(Cliente cliente);

	public Integer modificar(Cliente cliente);

	public Integer eliminar(Cliente cliente);

	public ArrayList<Cliente> listarTodos();

	public Cliente obtenerPorId(String idCliente);
}
