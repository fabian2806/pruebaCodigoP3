package pe.edu.pucp.softrh.compras.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.CarritoDAO;
import pe.edu.pucp.softrh.compras.daoimp.CarritoDAOImp;
import pe.edu.pucp.softrh.compras.model.Carrito;

public class CarritoBO {
	private CarritoDAO carritoDAO;

    public CarritoBO(){
        this.carritoDAO = new CarritoDAOImp();
    }

    public Integer insertar(Carrito carrito) {
        return this.carritoDAO.insertar(carrito);
    }

    public Integer modificar(Carrito carrito){
		return this.carritoDAO.modificar(carrito);  //la prenda ya modificada
    }

    public Integer eliminar(Integer idCarrito){
        return this.carritoDAO.eliminar(idCarrito);
    }

    public ArrayList<Carrito> listarTodos() {
        return this.carritoDAO.listarTodos();
    }

    public Carrito obtenerPorId(Integer idCarrito) {
        return this.carritoDAO.obtenerPorId(idCarrito);
    }
}
