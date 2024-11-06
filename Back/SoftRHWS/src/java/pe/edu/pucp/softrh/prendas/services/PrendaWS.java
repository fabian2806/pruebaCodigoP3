package pe.edu.pucp.softrh.prendas.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.bo.PrendaBO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

@WebService(serviceName = "PrendaWS", targetNamespace = "softrh.services")
public class PrendaWS {

	private final PrendaBO prendaBO;

	public PrendaWS(){
		this.prendaBO = new PrendaBO();
	}

	@WebMethod(operationName = "insertarPrenda")
	public Integer insertarPrenda(String nombre, String descripcion, TipoPrenda tipo, byte[] imagen, Talla talla, Genero genero, String color, Double precioOriginal, Integer stock) {
		return prendaBO.insertar(nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, stock);
	}

	@WebMethod(operationName = "modificarPrenda")
	public Integer modificarPrenda(Integer idPrenda, String nombre, String descripcion, TipoPrenda tipo, byte[] imagen, Talla talla, Genero genero, String color, Double precioOriginal, Double precioDescontado, Integer stock, Integer cantVendida) {
		return prendaBO.modificar(idPrenda, nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, precioDescontado, stock, cantVendida);
	}

	@WebMethod(operationName = "eliminarPrenda")
	public Integer eliminarPrenda(Integer idPrenda) {
		return prendaBO.eliminar(idPrenda);
	}

	@WebMethod(operationName = "listarPrendasTodas")
	public ArrayList<Prenda> listarPrendasTodas() {
		return prendaBO.listarTodos();
	}

	@WebMethod(operationName = "obtenerPrendaPorId")
	public Prenda obtenerPrendaPorId(Integer idPrenda) {
		return prendaBO.obtenerPorId(idPrenda);
	}

	@WebMethod(operationName = "listarPrendasPorNombre")
	public ArrayList<Prenda> listarPrendasPorNombre(String nombre) {
		return prendaBO.listarPorNombre(nombre);
	}
        
        //Añadido por Percy
        @WebMethod(operationName = "obtenerImagenPorId")
        public byte[] obtenerImagenPorId(Integer idPrenda) {
            Prenda prenda = prendaBO.obtenerPorId(idPrenda);
            return prenda != null ? prenda.getImagen() : null; // Asegúrate de que el método getImagen() exista en tu modelo Prenda
        }
        @WebMethod(operationName = "listarPrendasFiltradas")
        public ArrayList<Prenda> listarPrendasFiltradas(Double minPrice, Double maxPrice, boolean filterHombre, boolean filterMujer, boolean filterUnisex, String tallas, String colores) {
            return prendaBO.listarPrendasFiltradas(minPrice, maxPrice, filterHombre, filterMujer, filterUnisex, tallas, colores);
        }


}
