package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.usuarios.dao.DireccionDAO;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Direccion;

public class DireccionDAOImp extends DAOImp<Direccion> implements DireccionDAO {
	private Direccion direccion;

	public DireccionDAOImp() {
		super("direccion");
		this.direccion = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Direccion direccion) {
		this.direccion = direccion;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("fidCliente");
		valores.add("direccion");
		valores.add("distrito");
		valores.add("provincia");
		valores.add("departamento");
		valores.add("codigoPostal");
		valores.add("referencia");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(direccion.getCliente().getIdUsuario());
		valores.add(direccion.getDireccion());
		valores.add(direccion.getDistrito());
		valores.add(direccion.getProvincia());
		valores.add(direccion.getDepartamento());
		valores.add(direccion.getCodigoPostal());
		valores.add(direccion.getReferencia());

		return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Direccion direccion) {
		this.direccion = direccion;
		return super.modificar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosModificar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("direccion");
		valores.add("distrito");
		valores.add("provincia");
		valores.add("departamento");
		valores.add("codigoPostal");
		valores.add("referencia");
		valores.add("idDireccion");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresModificar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(direccion.getDireccion());
		valores.add(direccion.getDistrito());
		valores.add(direccion.getProvincia());
		valores.add(direccion.getDepartamento());
		valores.add(direccion.getCodigoPostal());
		valores.add(direccion.getReferencia());
		valores.add(direccion.getIdDireccion());

		return valores;
	}

	// ELIMINAR
	@Override
	public Integer eliminar(Integer idDireccion) {
		return super.eliminar(idDireccion);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idDireccion");

		return valores;
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Direccion> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idDireccion");
		valores.add("fidCliente");
		valores.add("direccion");
		valores.add("distrito");
		valores.add("provincia");
		valores.add("departamento");
		valores.add("codigoPostal");
		valores.add("referencia");

		return valores;
	}

	@Override
	public ArrayList<Direccion> obtenerListarTodos(ResultSet rs) throws SQLException {
		ArrayList<Direccion> direcciones = new ArrayList<>();

		while(rs.next()) {
			Direccion direccion = new Direccion();
			Cliente cliente = new Cliente();
			cliente.setIdUsuario(rs.getInt("fidCliente"));

			direccion.setIdDireccion(rs.getInt("idDireccion"));
			direccion.setCliente(cliente);
			direccion.setDireccion(rs.getString("direccion"));
			direccion.setDistrito(rs.getString("distrito"));
			direccion.setProvincia(rs.getString("provincia"));
			direccion.setDepartamento(rs.getString("departamento"));
			direccion.setCodigoPostal(rs.getString("codigoPostal"));
			direccion.setReferencia(rs.getString("referencia"));
			direccion.setActivo(true);

			direcciones.add(direccion);
		}

		return direcciones;
	}

	// OBTENER POR ID
	@Override
	public Direccion obtenerPorId(Integer idDireccion) {
		return super.obtenerPorId(idDireccion);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idDireccion");
		valores.add("fidCliente");
		valores.add("direccion");
		valores.add("distrito");
		valores.add("provincia");
		valores.add("departamento");
		valores.add("codigoPostal");
		valores.add("referencia");
		valores.add("idDireccion");
		
		return valores;
	}

	@Override
	public Direccion obtenerObtenerPorId(ResultSet rs) throws SQLException {
		Direccion direccion = new Direccion();

		if(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdUsuario(rs.getInt("fidCliente"));

			direccion.setIdDireccion(rs.getInt("idDireccion"));
			direccion.setCliente(cliente);
			direccion.setDireccion(rs.getString("direccion"));
			direccion.setDistrito(rs.getString("distrito"));
			direccion.setProvincia(rs.getString("provincia"));
			direccion.setDepartamento(rs.getString("departamento"));
			direccion.setCodigoPostal(rs.getString("codigoPostal"));
			direccion.setReferencia(rs.getString("referencia"));
			direccion.setActivo(true);
		}

		return direccion;
	}
}
