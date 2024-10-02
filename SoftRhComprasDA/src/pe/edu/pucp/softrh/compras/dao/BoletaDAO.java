package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.Boleta;
import java.util.ArrayList;

public interface BoletaDAO {
    public Integer insertar(Boleta documento);

    public Integer modificar(Boleta documentoModificada);

    public Integer eliminar(Boleta documento);

    public ArrayList<Boleta> obtenerTodos();

    public Boleta obtenerPorId(Integer idComprobante);
}
