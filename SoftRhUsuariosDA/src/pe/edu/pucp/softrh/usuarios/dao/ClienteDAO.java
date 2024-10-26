package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public interface ClienteDAO {
	Integer insertar(Cliente cliente);

	Integer modificar(Cliente cliente);

	Integer eliminar(Integer idCliente);

	ArrayList<Cliente> listarTodos();

	Cliente obtenerPorId(Integer idCliente);
}
