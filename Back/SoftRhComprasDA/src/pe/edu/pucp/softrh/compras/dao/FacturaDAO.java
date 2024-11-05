package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Factura;
import java.util.ArrayList;

public interface FacturaDAO {
    int insertar(Factura factura);

    int modificar(Factura factura);

    int eliminar(int idFactura);

    ArrayList<Factura> listarTodos();

    Factura obtenerPorId(int idFactura);
}
