package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.PrendaSeleccionadaDAO;
import pe.edu.pucp.softrh.compras.daoimp.PrendaSeleccionadaDAOImp;
import pe.edu.pucp.softrh.compras.model.Carrito;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;

public class PrendaSeleccionadaBO {
    private PrendaSeleccionadaDAO prendaSeleccionadaDAO;

    public PrendaSeleccionadaBO(){
        this.prendaSeleccionadaDAO = new PrendaSeleccionadaDAOImp();
    }

    public Integer insertar(Integer cantidad, Double precio, Carrito carrito) {
        PrendaSeleccionada prenda = new PrendaSeleccionada(cantidad,precio,carrito);
        return this.prendaSeleccionadaDAO.insertar((PrendaSeleccionada)prenda);
    }

    public Integer modificar(PrendaSeleccionada prenda){
		return this.prendaSeleccionadaDAO.modificar(prenda);  //la prenda ya modificada
    }

    public Integer eliminar(Integer idPrenda){
        return this.prendaSeleccionadaDAO.eliminar(idPrenda);
    }

    public ArrayList<PrendaSeleccionada> listarTodos() {
        return this.prendaSeleccionadaDAO.listarTodos();
    }

    public PrendaSeleccionada obtenerPorId(Integer idPrenda) {
        return this.prendaSeleccionadaDAO.obtenerPorId(idPrenda);
    }
}
