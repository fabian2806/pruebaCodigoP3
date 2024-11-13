package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public interface TrabajadorDAO {
    int insertar(Trabajador trabajador);

    int modificar(Trabajador trabajador);

    int eliminar(int idTrabajador);

    ArrayList<Trabajador> listarTodos();

    Trabajador obtenerPorId(int idTrabajador);

	ArrayList<Trabajador> listarPorDniNombre(String cadena);
}
