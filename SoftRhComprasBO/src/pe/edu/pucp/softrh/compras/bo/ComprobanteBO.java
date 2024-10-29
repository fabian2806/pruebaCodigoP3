package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.ComprobanteDAO;
import pe.edu.pucp.softrh.compras.daoimp.ComprobanteDAOImp;
import pe.edu.pucp.softrh.compras.model.Comprobante;

public class ComprobanteBO {
	private ComprobanteDAO comprobanteDAO;//

    public ComprobanteBO(){
        this.comprobanteDAO = new ComprobanteDAOImp();
    }

    public Integer insertar(Comprobante comprobante) {
        return this.comprobanteDAO.insertar(comprobante);
    }

    public Integer modificar(Comprobante comprobante){
		return this.comprobanteDAO.modificar(comprobante);  //la prenda ya modificada
    }

    public Integer eliminar(Integer idComprobante){
        return this.comprobanteDAO.eliminar(idComprobante);
    }

    public ArrayList<Comprobante> listarTodos() {
        return this.comprobanteDAO.listarTodos();
    }

    public Comprobante obtenerPorId(Integer idComprobante) {
        return this.comprobanteDAO.obtenerPorId(idComprobante);
    }
}
