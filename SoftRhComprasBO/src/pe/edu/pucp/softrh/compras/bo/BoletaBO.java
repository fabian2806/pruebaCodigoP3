package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.BoletaDAO;
import pe.edu.pucp.softrh.compras.daoimp.BoletaDAOImp;
import pe.edu.pucp.softrh.compras.model.Boleta;
import pe.edu.pucp.softrh.compras.model.Comprobante;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;

public class BoletaBO {
	private BoletaDAO boletaDAO;

    public BoletaBO(){
        this.boletaDAO = new BoletaDAOImp();
    }

    public Integer insertar(Double totalPagar, OrdenCompra orden, String dni, String nombres, String apellidos) {
        Comprobante boleta = new Boleta(totalPagar,orden,dni,nombres,apellidos);
        return this.boletaDAO.insertar((Boleta)boleta);
    }

    public Integer modificar(Boleta boleta){
        return this.boletaDAO.modificar(boleta);  //la prenda ya modificada
    }

    public Integer eliminar(Integer idBoleta){
        return this.boletaDAO.eliminar(idBoleta);
    }

    public ArrayList<Boleta> listarTodos() {
        return this.boletaDAO.listarTodos();
    }

    public Boleta obtenerPorId(Integer idBoleta) {
        return this.boletaDAO.obtenerPorId(idBoleta);
    }
}
