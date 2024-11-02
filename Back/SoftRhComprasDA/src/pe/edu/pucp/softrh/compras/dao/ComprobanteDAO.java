package pe.edu.pucp.softrh.compras.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.model.Comprobante;

public interface ComprobanteDAO {
    int insertar(Comprobante comprobante);

    int modificar(Comprobante comprobante);

    int eliminar(Integer idComprobante);

    ArrayList<Comprobante> listarTodos();

    Comprobante obtenerPorId(int idComprobante);
}
