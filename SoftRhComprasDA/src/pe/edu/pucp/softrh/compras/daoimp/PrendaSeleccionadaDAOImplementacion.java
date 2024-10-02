package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.compras.dao.PrendaSeleccionadaDAO;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import pe.edu.pucp.softrh.database.db.DAOImplementacion;

public class PrendaSeleccionadaDAOImplementacion extends DAOImplementacion<PrendaSeleccionada> implements PrendaSeleccionadaDAO{
    private PrendaSeleccionada prenda;
    //Constructor
    public PrendaSeleccionadaDAOImplementacion() {
        super("prenda");
        this.prenda = null;
    }
    //Especificacion de la tabla
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

        valores.add(this.prenda.getCantidad().toString());
        valores.add(this.prenda.getPrecio().toString());

        return valores;
    }

    //Insetar sin retornar ID
    @Override
    public Integer insertar(PrendaSeleccionada prenda) {
        this.prenda = prenda;
        return super.insertar();
    }
    //Actualizar
    @Override
    public Integer modificar(PrendaSeleccionada prendaModificada) {
        this.prenda = prendaModificada;
        return super.modificar();
    }
    //Eliminar
    @Override
    public Integer eliminar(PrendaSeleccionada prenda) {
        this.prenda = prenda;
        return super.eliminar();
    }
    //Seleccionar todos
    @Override
    public ArrayList<PrendaSeleccionada> obtenerTodos() {
        Integer cantidad;
        Double precio;
        ArrayList<PrendaSeleccionada> prendas = new ArrayList<>();

        super.listarTodos();

        try {
            while (this.result_set.next()) {
                cantidad = this.result_set.getInt("cantidad");
                precio = this.result_set.getDouble("precio");

                System.out.println(cantidad + precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrendaSeleccionadaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                super.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaSeleccionadaDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return prendas;
    }

	@Override
	protected ArrayList<String> obtenerListaDeAtributosModificar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresModificar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ArrayList<PrendaSeleccionada> obtenerListarTodos(ResultSet result_set) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public PrendaSeleccionada obtenerObtenerPorId(ResultSet result_set) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
