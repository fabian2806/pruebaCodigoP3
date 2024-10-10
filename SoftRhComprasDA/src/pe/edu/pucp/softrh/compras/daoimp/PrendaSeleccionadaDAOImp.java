package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.PrendaSeleccionadaDAO;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import pe.edu.pucp.softrh.database.db.DAOImp;

public class PrendaSeleccionadaDAOImp extends DAOImp<PrendaSeleccionada> implements PrendaSeleccionadaDAO {
    private PrendaSeleccionada prenda;

    public PrendaSeleccionadaDAOImp() {
        super("prendaseleccionada");
        this.prenda = null;
    }

	// INSERTAR
	@Override
	public Integer insertar(PrendaSeleccionada prenda) {
		this.prenda = prenda;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> atributos = new ArrayList<>();

        atributos.add("cantidad");
        atributos.add("precio");

        return atributos;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.prenda.getCantidad());
        valores.add(this.prenda.getPrecio());

        return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(PrendaSeleccionada prenda) {
		this.prenda = prenda;
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
	public Integer eliminar(Integer idPrenda) {
		return super.eliminar(idPrenda);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<PrendaSeleccionada> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<PrendaSeleccionada> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public PrendaSeleccionada obtenerPorId(Integer idPrenda) {
		return super.obtenerPorId(idPrenda);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected PrendaSeleccionada obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
//    //Seleccionar todos
//    @Override
//    public ArrayList<PrendaSeleccionada> obtenerTodos() {
//        Integer cantidad;
//        Double precio;
//        ArrayList<PrendaSeleccionada> prendas = new ArrayList<>();
//
//        super.listarTodos();
//
//        try {
//            while (this.result_set.next()) {
//                cantidad = this.result_set.getInt("cantidad");
//                precio = this.result_set.getDouble("precio");
//
//                System.out.println(cantidad + precio);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PrendaSeleccionadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                super.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(PrendaSeleccionadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return prendas;
//    }
}
