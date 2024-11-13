package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public interface AdministradorDAO {
    int insertar(Administrador administrador);

    int modificar(Administrador administrador);

    int eliminar(int idAdministrador);

    ArrayList<Administrador> listarTodos();

    Administrador obtenerPorId(int idAdministrador);

	ArrayList<Administrador> listarPorDniNombre(String cadena);
}
