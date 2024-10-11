package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.usuarios.dao.AdministradorDAO;
import pe.edu.pucp.softrh.usuarios.model.Administrador;

public class AdministradorDAOImp extends DAOImp<Administrador> implements AdministradorDAO {
	private Administrador administrador;

	public AdministradorDAOImp() {
		super("administrador");
		this.administrador = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Administrador administrador) {
		this.administrador = administrador;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idAdministrador");
		valores.add("fechaCreacion");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(administrador.getIdUsuario());
		valores.add(administrador.getFechaCreacion());

		return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Administrador administrador) {
		this.administrador = administrador;
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
	public Integer eliminar(Integer idAdministrador) {
		return super.eliminar(idAdministrador);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Administrador> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected ArrayList<Administrador> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public Administrador obtenerPorId(Integer idAdministrador) {
		return super.obtenerPorId(idAdministrador);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	protected Administrador obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
