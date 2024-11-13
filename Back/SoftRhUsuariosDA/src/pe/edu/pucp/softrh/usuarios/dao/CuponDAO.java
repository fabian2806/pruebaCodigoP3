package pe.edu.pucp.softrh.usuarios.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cupon;

public interface CuponDAO {
    int insertar(Cupon cupon);

    int modificar(Cupon cupon);

    int eliminar(int idCupon);

    ArrayList<Cupon> listarTodos();

    Cupon obtenerPorId(int idCupon);

	ArrayList<Cupon> listarPorCodigoDescripcion(String cadena);
}
