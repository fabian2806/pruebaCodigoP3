package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Prenda;

public interface PrendaDAO {

    public Integer insertar(Prenda prenda);

    public Integer modificar(Prenda prendaModificada);

    public Integer eliminar(Prenda prenda);

    public ArrayList<Prenda> listarTodos();

    public Prenda obtenerPorId(String idPrenda);
}
