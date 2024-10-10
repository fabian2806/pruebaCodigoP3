package pe.edu.pucp.softrh.compras.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.model.Comprobante;

public interface ComprobanteDAO {
	Integer insertar(Comprobante comprobante);

    Integer modificar(Comprobante comprobante);

    Integer eliminar(Integer idComprobante);

    ArrayList<Comprobante> listarTodos();

    Comprobante obtenerPorId(Integer idComprobante);
}
