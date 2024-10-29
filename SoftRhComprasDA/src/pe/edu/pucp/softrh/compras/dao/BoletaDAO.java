package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Boleta;
import java.util.ArrayList;

public interface BoletaDAO {
    int insertar(Boleta boleta);

    int modificar(Boleta boleta);

    int eliminar(int idBoleta);

    ArrayList<Boleta> listarTodos();

    Boleta obtenerPorId(int idBoleta);
}
