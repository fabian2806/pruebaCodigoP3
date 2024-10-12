package pe.edu.pucp.softrh.prendas.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class PrendaDAOImp extends DAOImp<Prenda> implements PrendaDAO {
    private Prenda prenda;

    public PrendaDAOImp() {
        super("prenda");
        this.prenda = null;
    }

	// INSERTAR
	@Override
    public Integer insertar(Prenda prenda) {
        this.prenda = prenda;
        return super.insertar();
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precioOriginal");
        atributos.add("stock");

        return atributos;
    }

	@Override
    protected ArrayList<Object> obtenerListaDeValoresInsertar() {
        ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.prenda.getNombre());
        valores.add(this.prenda.getDescripcion());
        valores.add(this.prenda.getTipo().toString());
        valores.add(this.prenda.getImagen());
        valores.add(this.prenda.getTalla().toString());
        valores.add(this.prenda.getGenero().toString());
        valores.add(this.prenda.getColor());
        valores.add(this.prenda.getPrecioOriginal());
        valores.add(this.prenda.getStock());

        return valores;
    }

	// MODIFICAR
	@Override
    public Integer modificar(Prenda prenda) {
        this.prenda = prenda;
        return super.modificar();
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosModificar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precioOriginal");
		atributos.add("precioDescontado");
		atributos.add("stock");
		atributos.add("cantVendida");
        atributos.add("idPrenda");

        return atributos;
    }

	@Override
    protected ArrayList<Object> obtenerListaDeValoresModificar() {
        ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.prenda.getNombre());
        valores.add(this.prenda.getDescripcion());
        valores.add(this.prenda.getTipo().toString());
        valores.add(this.prenda.getImagen());
        valores.add(this.prenda.getTalla().toString());
        valores.add(this.prenda.getGenero().toString());
        valores.add(this.prenda.getColor());
        valores.add(this.prenda.getPrecioOriginal());
		valores.add(this.prenda.getPrecioDescontado());
		valores.add(this.prenda.getStock());
		valores.add(this.prenda.getCantVendida());
        valores.add(this.prenda.getIdPrenda());

        return valores;
    }

	// ELIMINAR
	@Override
    public Integer eliminar(Integer idPrenda) {
        return super.eliminar(idPrenda);
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosEliminar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPrenda");

        return atributos;
    }

	// LISTAR TODOS
	@Override
    public ArrayList<Prenda> listarTodos() {
        return super.listarTodos();
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPrenda");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precioOriginal");
		atributos.add("precioDescontado");
        atributos.add("stock");
        atributos.add("cantVendida");

        return atributos;
    }

	@Override
    public ArrayList<Prenda> obtenerListarTodos(ResultSet rs) throws SQLException {
        ArrayList<Prenda> prendas = new ArrayList<>();

		while(rs.next()) {
            Prenda prenda = new Prenda();

			prenda.setIdPrenda(rs.getInt("idPrenda"));
            prenda.setNombre(rs.getString("nombre"));
            prenda.setDescripcion(rs.getString("descripcion"));
            prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
            prenda.setImagen(rs.getString("imagen"));
            prenda.setTalla(Talla.valueOf(rs.getString("talla")));
            prenda.setGenero(Genero.valueOf(rs.getString("genero")));
            prenda.setColor(rs.getString("color"));
            prenda.setPrecioOriginal(rs.getDouble("precioOriginal"));
			prenda.setPrecioDescontado(rs.getDouble("precioDescontado"));
            prenda.setStock(rs.getInt("stock"));
            prenda.setCantVendida(rs.getInt("cantVendida"));
            prenda.setActivo(true);

			prendas.add(prenda);
        }

		return prendas;
    }

	// OBTENER POR ID
	@Override
    public Prenda obtenerPorId(Integer idPrenda) {
        return super.obtenerPorId(idPrenda);
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosObtenerPorId(){
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPrenda");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("tipo");
        atributos.add("imagen");
        atributos.add("talla");
        atributos.add("genero");
        atributos.add("color");
        atributos.add("precioOriginal");
		atributos.add("precioDescontado");
        atributos.add("stock");
        atributos.add("cantVendida");
        atributos.add("idPrenda");

        return atributos;
    }

    @Override
    public Prenda obtenerObtenerPorId(ResultSet rs) throws SQLException{
        Prenda prenda = new Prenda();

		if(rs.next()) {
            prenda.setIdPrenda(rs.getInt("idPrenda"));
            prenda.setNombre(rs.getString("nombre"));
            prenda.setDescripcion(rs.getString("descripcion"));
            prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
            prenda.setImagen(rs.getString("imagen"));
            prenda.setTalla(Talla.valueOf(rs.getString("talla")));
            prenda.setGenero(Genero.valueOf(rs.getString("genero")));
            prenda.setColor(rs.getString("color"));
            prenda.setPrecioOriginal(rs.getDouble("precioOriginal"));
			prenda.setPrecioDescontado(rs.getDouble("precioDescontado"));
            prenda.setStock(rs.getInt("stock"));
            prenda.setCantVendida(rs.getInt("cantVendida"));
            prenda.setActivo(true);
        }

		return prenda;
    }
}
