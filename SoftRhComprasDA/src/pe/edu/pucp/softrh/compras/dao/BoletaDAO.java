package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Boleta;
import java.util.ArrayList;

public interface BoletaDAO {
    Integer insertar(Boleta boleta);

    Integer modificar(Boleta boleta);

    Integer eliminar(Integer idBoleta);

    ArrayList<Boleta> listarTodos();

    Boleta obtenerPorId(Integer idBoleta);
}
