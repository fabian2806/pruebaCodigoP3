package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Factura;
import java.util.ArrayList;

public interface FacturaDAO {
    Integer insertar(Factura factura);

    Integer modificar(Factura factura);

    Integer eliminar(Integer idFactura);

    ArrayList<Factura> listarTodos();

    Factura obtenerPorId(Integer idFactura);
}
