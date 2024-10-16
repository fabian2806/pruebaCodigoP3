package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.usuarios.dao.UsuarioDAO;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class UsuarioDAOImp extends DAOImp<Usuario> implements UsuarioDAO{
	private Usuario usuario;

	public UsuarioDAOImp() {
		super("usuario");
		this.usuario = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Usuario usuario) {
		this.usuario = usuario;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("dni");
		valores.add("nombres");
		valores.add("apellidos");
		valores.add("correo");
		valores.add("contrasenha");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(usuario.getDni());
		valores.add(usuario.getNombres());
		valores.add(usuario.getApellidos());
		valores.add(usuario.getCorreo());
		valores.add(usuario.getContrasenha());

		return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Usuario usuario) {
		this.usuario = usuario;
		return super.modificar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosModificar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("dni");
		valores.add("nombres");
		valores.add("apellidos");
		valores.add("correo");
		valores.add("contrasenha");
		valores.add("idUsuario");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresModificar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(usuario.getDni());
		valores.add(usuario.getNombres());
		valores.add(usuario.getApellidos());
		valores.add(usuario.getCorreo());
		valores.add(usuario.getContrasenha());
		valores.add(usuario.getIdUsuario());

		return valores;
	}

	// ELIMINAR
	@Override
	public Integer eliminar(Integer idUsuario) {
		return super.eliminar(idUsuario);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Usuario> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ArrayList<Usuario> obtenerListarTodos(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// OBTENER POR ID
	@Override
	public Usuario obtenerPorId(Integer idUsuario) {
		return super.obtenerPorId(idUsuario);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Usuario obtenerObtenerPorId(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
