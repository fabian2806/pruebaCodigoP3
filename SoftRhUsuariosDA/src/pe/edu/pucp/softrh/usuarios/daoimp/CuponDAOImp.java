package pe.edu.pucp.softrh.usuarios.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.usuarios.dao.CuponDAO;
import pe.edu.pucp.softrh.usuarios.model.Cupon;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class CuponDAOImp extends DAOImp<Cupon> implements CuponDAO {
	private Cupon cupon;

	public CuponDAOImp() {
		super("cupon");
		this.cupon = null;
	}

	// INSERTAR
	@Override
	public Integer insertar(Cupon cupon) {
		this.cupon = cupon;
		return super.insertar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosInsertar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("fidTrabajador");
		valores.add("codigo");
		valores.add("descripcion");
		valores.add("fechaInicio");
		valores.add("fechaFin");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresInsertar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(cupon.getTrabajador().getIdUsuario());
		valores.add(cupon.getCodigo());
		valores.add(cupon.getDescripcion());
		valores.add(cupon.getFechaInicio());
		valores.add(cupon.getFechaFin());

		return valores;
	}

	// MODIFICAR
	@Override
	public Integer modificar(Cupon cupon) {
		this.cupon = cupon;
		return super.modificar();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosModificar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("codigo");
		valores.add("descripcion");
		valores.add("fechaInicio");
		valores.add("fechaFin");
		valores.add("idCupon");

		return valores;
	}

	@Override
	protected ArrayList<Object> obtenerListaDeValoresModificar() {
		ArrayList<Object> valores = new ArrayList<>();

		valores.add(cupon.getCodigo());
		valores.add(cupon.getDescripcion());
		valores.add(cupon.getFechaInicio());
		valores.add(cupon.getFechaFin());
		valores.add(cupon.getIdCupon());

		return valores;
	}

	// ELIMINAR
	@Override
	public Integer eliminar(Integer idCupon) {
		return super.eliminar(idCupon);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosEliminar() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idCupon");

		return valores;
	}

	// LISTAR TODOS
	@Override
	public ArrayList<Cupon> listarTodos() {
		return super.listarTodos();
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idCupon");
		valores.add("fidTrabajador");
		valores.add("codigo");
		valores.add("descripcion");
		valores.add("fechaInicio");
		valores.add("fechaFin");

		return valores;
	}

	@Override
	protected ArrayList<Cupon> obtenerListarTodos(ResultSet rs) throws SQLException {
		ArrayList<Cupon> cupones = new ArrayList<>();

		while(rs.next()) {
			Cupon cupon = new Cupon();
			Trabajador trabajador = new Trabajador();
			trabajador.setIdUsuario(rs.getInt("fidTrabajador"));

			cupon.setIdCupon(rs.getInt("idCupon"));
			cupon.setTrabajador(trabajador);
			cupon.setCodigo(rs.getString("codigo"));
			cupon.setDescripcion(rs.getString("descripcion"));
			cupon.setFechaInicio(rs.getDate("fechaInicio"));
			cupon.setFechaFin(rs.getDate("fechaFin"));
			cupon.setActivo(true);

			cupones.add(cupon);
		}

		return cupones;
	}

	// OBTENER POR ID
	@Override
	public Cupon obtenerPorId(Integer idCupon) {
		return super.obtenerPorId(idCupon);
	}

	@Override
	protected ArrayList<String> obtenerListaDeAtributosObtenerPorId() {
		ArrayList<String> valores = new ArrayList<>();

		valores.add("idCupon");
		valores.add("fidTrabajador");
		valores.add("codigo");
		valores.add("descripcion");
		valores.add("fechaInicio");
		valores.add("fechaFin");
		valores.add("idCupon");
		
		return valores;
	}

	@Override
	protected Cupon obtenerObtenerPorId(ResultSet rs) throws SQLException {
		Cupon cupon = new Cupon();

		if(rs.next()) {
			Trabajador trabajador = new Trabajador();
			trabajador.setIdUsuario(rs.getInt("fidTrabajador"));

			cupon.setIdCupon(rs.getInt("idCupon"));
			cupon.setTrabajador(trabajador);
			cupon.setCodigo(rs.getString("codigo"));
			cupon.setDescripcion(rs.getString("descripcion"));
			cupon.setFechaInicio(rs.getDate("fechaInicio"));
			cupon.setFechaFin(rs.getDate("fechaFin"));
			cupon.setActivo(true);
		}

		return cupon;
	}
}
