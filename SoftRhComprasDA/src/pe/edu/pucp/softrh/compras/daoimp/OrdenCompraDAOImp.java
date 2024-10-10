package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.OrdenCompraDAO;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import pe.edu.pucp.softrh.database.db.DAOImp;

public class OrdenCompraDAOImp extends DAOImp<OrdenCompra> implements OrdenCompraDAO {
    private OrdenCompra orden;

    public OrdenCompraDAOImp() {
        super("ordencompra");
        this.orden = null;
    }

	// INSERTAR
	@Override
	public Integer insertar(OrdenCompra orden) {
		this.orden = orden;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> atributos = new ArrayList<>();

        atributos.add("fidCliente");
		atributos.add("fidCarrito");
		atributos.add("fechaRegistro");
        atributos.add("estado");
        atributos.add("dni");
        atributos.add("correo");
        atributos.add("subtotal");

        return atributos;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.orden.getCliente().getIdUsuario());
        valores.add(this.orden.getCarrito().getIdCarrito());
		valores.add(this.orden.getFechaRegistro());
        valores.add(this.orden.getEstado().toString());
        valores.add(this.orden.getDni());
        valores.add(this.orden.getCorreo());
        valores.add(this.orden.getSubtotal());

        return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(OrdenCompra orden) {
		this.orden = orden;
		return super.modificar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosModificar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresModificar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// ELIMINAR
	@Override
	public Integer eliminar(Integer idOrden) {
		return super.eliminar(idOrden);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<OrdenCompra> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<OrdenCompra> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public OrdenCompra obtenerPorId(Integer idOrden) {
		return super.obtenerPorId(idOrden);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected OrdenCompra obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

//    //Seleccionar todos
//    @Override
//    public ArrayList<OrdenCompra> obtenerTodos() {
//        Integer idOrden;
//        Date fechaPedido,fechaPago;
//        Double subtotal;
//        Estado estado;
//        String dni, correo;
//        ArrayList<OrdenCompra> documentos = new ArrayList<>();
//
//        super.listarTodos();
//
//        try {
//            while (this.result_set.next()) {
//                idOrden = this.result_set.getInt("idOrden");
//                fechaPedido = this.result_set.getDate("fechaPedido");
//                fechaPago = this.result_set.getDate("fechaPago");
//                estado = Estado.valueOf(this.result_set.getString("totalPagar"));
//                dni = this.result_set.getString("dni");
//                correo = this.result_set.getString("correo");
//                subtotal = this.result_set.getDouble("subtotal");
//
//                System.out.println(idOrden + subtotal + dni);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                super.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(OrdenCompraDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return documentos;
//    }
}
