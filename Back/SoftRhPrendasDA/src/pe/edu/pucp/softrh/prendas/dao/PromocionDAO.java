package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Promocion;

public interface PromocionDAO {
    int insertar(Promocion promocion);

    int modificar(Promocion promocionModificada);

    int eliminar(int idPromocion);

    ArrayList<Promocion> listarTodos();

    Promocion obtenerPorId(int idPromocion);

	ArrayList<Promocion> listarPorNombre(String nombre);
}
