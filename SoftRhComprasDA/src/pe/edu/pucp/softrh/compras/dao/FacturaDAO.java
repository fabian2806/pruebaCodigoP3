package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Factura;
import java.util.ArrayList;

public interface FacturaDAO {
    public Integer insertar(Factura documento);

    public Integer modificar(Factura documentoModificada);

    public Integer eliminar(Factura documento);

    public ArrayList<Factura> obtenerTodos();

    public Factura obtenerPorId(Integer idComprobante);
}
