package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.FacturaDAO;
import pe.edu.pucp.softrh.compras.model.Factura;
import pe.edu.pucp.softrh.database.db.DAOImp;

public class FacturaDAOImp extends DAOImp<Factura> implements FacturaDAO {
    private Factura factura;

    public FacturaDAOImp() {
        super("factura");
        this.factura = null;
    }

	// INSERTAR
	@Override
	public Integer insertar(Factura factura) {
		this.factura = factura;
        return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> atributos = new ArrayList<>();

        atributos.add("ruc");
        atributos.add("razonSocial");
        atributos.add("repreLegal");

        return atributos;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.factura.getRuc());
        valores.add(this.factura.getRazonSocial());
        valores.add(this.factura.getRepreLegal());

        return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Factura factura) {
		this.factura = factura;
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
	public Integer eliminar(Integer idFactura) {
        return super.eliminar(idFactura);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Factura> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Factura> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public Factura obtenerPorId(Integer idFactura) {
        return super.obtenerPorId(idFactura);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected Factura obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

//    //Seleccionar todos
//    @Override
//    public ArrayList<Factura> obtenerTodos() {
//        Integer idComprobante;
//        Double totalPagar;
//        String razonSocial, ruc, repreLegal;
//        ArrayList<Factura> documentos = new ArrayList<>();
//
//        super.listarTodos();
//
//        try {
//            while (this.result_set.next()) {
//                idComprobante = this.result_set.getInt("idComprobante");
//                totalPagar = this.result_set.getDouble("totalPagar");
//                ruc = this.result_set.getString("ruc");
//                razonSocial = this.result_set.getString("razonSocial");
//                repreLegal = this.result_set.getString("repreLegal");
//
//                System.out.println(idComprobante + totalPagar + ruc);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FacturaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                super.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(FacturaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return documentos;
//    }
}
