package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public interface ClienteDAO {
    int insertar(Cliente cliente);

    int modificar(Cliente cliente);

    int eliminar(int idCliente);

    ArrayList<Cliente> listarTodos();

    Cliente obtenerPorId(int idCliente);
}
