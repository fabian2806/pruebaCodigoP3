package pe.edu.pucp.softrh.prendas.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImplementacion;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class PrendaDAOImplementacion extends DAOImplementacion<Prenda> implements PrendaDAO{
    private Prenda prenda;
    //Constructor
    public PrendaDAOImplementacion() {
        super("prenda");
        this.prenda = null;
    }
    //Especificacion de la tabla
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
		atributos.add("precioDescontado");
        atributos.add("stock");

        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosModificar(){
        ArrayList<String> atributos = new ArrayList<>();

        atributos = obtenerListaDeAtributosInsertar();
        atributos.add("idPrenda");

        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosEliminar(){
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("activo");
        atributos.add("idPrenda");

        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosListarTodos(){
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPrenda");
        //atributos.add("fidPromocion");
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
        atributos.add("activo");

        return atributos;
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosObtenerPorId(){
        ArrayList<String> atributos = new ArrayList<>();

        //atributos.add("fidPromocion");
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
        atributos.add("activo");
        atributos.add("idPrenda");

        return atributos;
    }


    //////


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
		valores.add(this.prenda.getPrecioDescontado());
        valores.add(this.prenda.getStock());

        return valores;
    }

    @Override
    protected ArrayList<Object> obtenerListaDeValoresModificar(){
        ArrayList<Object> valores = new ArrayList<>();

        valores = obtenerListaDeValoresInsertar();
        valores.add(this.prenda.getId());

        return valores;
    }

    @Override
    protected ArrayList<Object> obtenerListaDeValoresEliminar(){
        ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.prenda.getId());

        return valores;
    }

    @Override
    public ArrayList<Prenda> obtenerListarTodos(ResultSet rs) throws SQLException{
        ArrayList<Prenda> prendas = new ArrayList<Prenda>();
        while (rs.next()){
            Prenda prenda = new Prenda();
            prenda.setId(rs.getInt("idPrenda"));
            //falta el de fidprenda
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
            prenda.setActivo(rs.getBoolean("activo"));
            prendas.add(prenda);
        }
        return prendas;
    }

    @Override
    public Prenda obtenerObtenerPorId(ResultSet rs) throws SQLException{
        Prenda prenda = new Prenda();
        while (rs.next()){
            prenda.setId(rs.getInt("idPrenda"));
            //falta el de fidprenda
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
            prenda.setActivo(rs.getBoolean("activo"));
        }
        return prenda;
    }

    @Override
    public Integer insertar(Prenda prenda) {
        this.prenda = prenda;
        return super.insertar();
    }

    @Override
    public Integer modificar(Prenda prendaModificada) {
        this.prenda = prendaModificada;
        return super.modificar();
    }

    @Override
    public Integer eliminar(Integer idPrenda) {
        this.prenda = prenda;
        return super.eliminar();
    }

    @Override
    public ArrayList<Prenda> listarTodos() {
        return super.listarTodos();
    }

    @Override
    public Prenda obtenerPorId(Integer idPrenda) {
        return super.obtenerPorId(idPrenda);
    }
}
