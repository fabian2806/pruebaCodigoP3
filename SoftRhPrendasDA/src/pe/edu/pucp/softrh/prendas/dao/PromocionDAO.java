package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Promocion;

public interface PromocionDAO {
    Integer insertar(Promocion promocion);

    Integer modificar(Promocion promocionModificada);

    Integer eliminar(Integer idPromocion);

    ArrayList<Promocion> listarTodos();

    Promocion obtenerPorId(Integer idPromocion);
}
