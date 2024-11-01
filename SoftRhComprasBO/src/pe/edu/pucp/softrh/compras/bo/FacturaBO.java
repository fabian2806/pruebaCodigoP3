package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.FacturaDAO;
import pe.edu.pucp.softrh.compras.daoimp.FacturaDAOImp;
import pe.edu.pucp.softrh.compras.model.Factura;

public class FacturaBO {
	private FacturaDAO facturaDAO;

    public FacturaBO(){
        this.facturaDAO = new FacturaDAOImp();
    }

    public Integer insertar(Factura factura) {
        return this.facturaDAO.insertar(factura);
    }

    public Integer modificar(Factura factura){
		return this.facturaDAO.modificar(factura);  //la prenda ya modificada
    }

    public Integer eliminar(Integer idFactura){
        return this.facturaDAO.eliminar(idFactura);
    }

    public ArrayList<Factura> listarTodos() {
        return this.facturaDAO.listarTodos();
    }

    public Factura obtenerPorId(Integer idFactura) {
        return this.facturaDAO.obtenerPorId(idFactura);
    }
}
