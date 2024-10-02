package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Promocion;

public interface PromocionDAO {

    public Integer insertar(Promocion promocion);

    public Integer modificar(Promocion promocionModificada);

    public Integer eliminar(Promocion promocion);

    public ArrayList<Promocion> listarTodos();

    public Promocion obtenerPorId(String idPromocion);
}
