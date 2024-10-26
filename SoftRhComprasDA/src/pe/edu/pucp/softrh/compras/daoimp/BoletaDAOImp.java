package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.BoletaDAO;
import pe.edu.pucp.softrh.compras.model.Boleta;
import pe.edu.pucp.softrh.database.db.DAOImp;

public class BoletaDAOImp extends DAOImp<Boleta> implements BoletaDAO {
	private Boleta boleta;

	public BoletaDAOImp() {
		super("boleta");
		boleta = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Boleta boleta) {
		this.boleta = boleta;
        return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> atributos = new ArrayList<>();

        atributos.add("dni");
        atributos.add("nombres");
        atributos.add("apellidos");

        return atributos;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.boleta.getDni());
        valores.add(this.boleta.getNombres());
        valores.add(this.boleta.getApellidos());

        return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Boleta boleta) {
		this.boleta = boleta;
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
	public Integer eliminar(Integer idBoleta) {
        return super.eliminar(idBoleta);
    }

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Boleta> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Boleta> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public Boleta obtenerPorId(Integer idBoleta) {
        return super.obtenerPorId(idBoleta);
    }

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected Boleta obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

//    //Seleccionar todos
//    @Override
//    public ArrayList<Boleta> obtenerTodos() {
//        Integer idComprobante;
//        Double totalPagar;
//        String nombre, dni, apellido;
//        ArrayList<Boleta> documentos = new ArrayList<>();
//
//        super.listarTodos();
//
//        try {
//            while (this.result_set.next()) {
//                idComprobante = this.result_set.getInt("idComprobante");
//                totalPagar = this.result_set.getDouble("totalPagar");
//                dni = this.result_set.getString("dni");
//                nombre = this.result_set.getString("nombres");
//                apellido = this.result_set.getString("apellidos");
//
//                System.out.println(idComprobante + totalPagar + dni);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BoletaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                super.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(BoletaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return documentos;
//    }
}
