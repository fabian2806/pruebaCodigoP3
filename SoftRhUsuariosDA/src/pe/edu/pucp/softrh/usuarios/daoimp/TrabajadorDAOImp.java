package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class TrabajadorDAOImp extends DAOImp<Trabajador> implements TrabajadorDAO {
	private Trabajador trabajador;

	public TrabajadorDAOImp() {
		super("trabajador");
		this.trabajador = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Trabajador trabajador) {
		this.trabajador = trabajador;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idTrabajador");
		valores.add("puesto");
		valores.add("sueldo");
		valores.add("fechaIngreso");
		valores.add("horarioInicio");
		valores.add("horarioFin");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(trabajador.getIdUsuario());
		valores.add(trabajador.getPuesto());
		valores.add(trabajador.getSueldo());
		valores.add(trabajador.getFechaIngreso());
		valores.add(trabajador.getHorarioInicio());
		valores.add(trabajador.getHorarioFin());

		return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Trabajador trabajador) {
		this.trabajador = trabajador;
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
	public Integer eliminar(Integer idTrabajador) {
		return super.eliminar(idTrabajador);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Trabajador> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ArrayList<Trabajador> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public Trabajador obtenerPorId(Integer idTrabajador) {
		return super.obtenerPorId(idTrabajador);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Trabajador obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
