package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public interface PrendaDAO {
    int insertar(Prenda prenda);

    int modificar(Prenda prendaModificada);

    int eliminar(int idPrenda);

    ArrayList<Prenda> listarTodos();

    Prenda obtenerPorId(int idPrenda);
    
    ArrayList<String> listarTipoPrenda();
    
    ArrayList<Prenda> listarPrendasPorTipo(String tipoSeleccionado);
}
