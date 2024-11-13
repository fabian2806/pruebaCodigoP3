package pe.edu.pucp.softrh.compras.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.compras.bo.OrdenCompraBO;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.compras.model.Estado;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

@WebService(serviceName = "OrdenCompraWS", targetNamespace = "softrh.services")
public class OrdenCompraWS {
    private final OrdenCompraBO ordenBO;

    public OrdenCompraWS() {
        ordenBO = new OrdenCompraBO();
    }

    @WebMethod(operationName = "insertarOrdenCompra")
    public Integer insertarOrdenCompra(Date fechaRegistro, Date fechaProcesado,
		Date fechaEntregado,Date fechaAnulado, Estado estado,String dni,
		String correo, Double subtotal, Cliente cliente) {

		return ordenBO.insertar(fechaRegistro,fechaProcesado,fechaEntregado,
			fechaAnulado, estado, dni, correo, subtotal, cliente);
    }

    @WebMethod(operationName = "modificarOrdenCompra")
    public Integer modificarOrdenCompra(Integer IdOrdenCompra, Date fechaRegistro,
		Date fechaProcesado,Date fechaEntregado,Date fechaAnulado, Estado estado,
		String dni, String correo, Double subtotal, Cliente cliente) {

        return ordenBO.modificar(IdOrdenCompra, fechaRegistro,fechaProcesado,
                fechaEntregado,fechaAnulado, estado, dni, correo, subtotal, cliente);
    }

    @WebMethod(operationName = "eliminarOrdenCompra")
    public Integer eliminarOrdenCompra(Integer idOrdenCompra) {
		return ordenBO.eliminar(idOrdenCompra);
    }

    @WebMethod(operationName = "listarOrdenCompraTodos")
    public ArrayList<OrdenCompra> listarOrdenCompraTodos() {
        return ordenBO.listarTodos();
    }

    @WebMethod(operationName = "obtenerOrdenCompraPorId")
    public OrdenCompra obtenerOrdenCompraPorId(Integer idOrdenCompra) {
        return ordenBO.obtenerPorId(idOrdenCompra);
    }

    @WebMethod(operationName = "listarOrdenPorEstado")
    public ArrayList<OrdenCompra> listarOrdenPorEstado(String cadena) {
        return ordenBO.listarPorEstado(cadena);
    }
}
