package pe.edu.pucp.softrh.prendas.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.database.db.DAOImp;
import pe.edu.pucp.softrh.prendas.dao.PromocionDAO;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class PromocionDAOImp extends DAOImp<Promocion> implements PromocionDAO {
    private Promocion promocion;

    public PromocionDAOImp() {
        super("promocion");
        this.promocion = null;
    }

	// INSERTAR
	@Override
    public Integer insertar(Promocion promocion) {
        this.promocion = promocion;
        return super.insertar();
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosInsertar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("fidTrabajador");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("valorDescuento");
        atributos.add("tipo");
        atributos.add("fechaInicio");
        atributos.add("fechaFin");

        return atributos;
    }

	@Override
    protected ArrayList<Object> obtenerListaDeValoresInsertar() {
        ArrayList<Object> valores = new ArrayList<>();

        valores.add(this.promocion.getTrabajador().getIdUsuario());
        valores.add(this.promocion.getNombre());
        valores.add(this.promocion.getDescripcion());
        valores.add(this.promocion.getValorDescuento());
        valores.add(this.promocion.getTipo());
        valores.add(this.promocion.getFechaInicio());
        valores.add(this.promocion.getFechaFin());

        return valores;
    }

	// MODIFICAR
    @Override
    public Integer modificar(Promocion promocion) {
        this.promocion = promocion;
        return super.modificar();
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosModificar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos = obtenerListaDeAtributosInsertar();
        atributos.add("idPromocion");

        return atributos;
    }

	@Override
    protected ArrayList<Object> obtenerListaDeValoresModificar() {
        ArrayList<Object> valores = new ArrayList<>();

        valores = obtenerListaDeValoresInsertar();
        valores.add(this.promocion.getIdPromocion());

        return valores;
    }

	// ELIMINAR
    @Override
    public Integer eliminar(Integer idPromocion) {
        return super.eliminar(idPromocion);
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosEliminar() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPromocion");

        return atributos;
    }

//    @Override
//    protected ArrayList<Object> obtenerListaDeValoresEliminar() {
//        ArrayList<Object> valores = new ArrayList<>();
//
//        valores.add(this.promocion.getIdPromocion());
//
//        return valores;
//    }

	// LISTAR TODOS
    @Override
    public ArrayList<Promocion> listarTodos() {
        return super.listarTodos();
    }

	@Override
    protected ArrayList<String> obtenerListaDeAtributosListarTodos() {
        ArrayList<String> atributos = new ArrayList<>();

        atributos.add("idPromocion");
        atributos.add("fidTrabajador");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("valorDescuento");
        atributos.add("tipo");
        atributos.add("fechaInicio");
        atributos.add("fechaFin");

        return atributos;
    }

	@Override
    public ArrayList<Promocion> obtenerListarTodos(ResultSet rs) throws SQLException {
        ArrayList<Promocion> promociones = new ArrayList<>();

		while(rs.next()){
            Promocion promocion = new Promocion();
            promocion.setIdPromocion(rs.getInt("idPrenda"));
            promocion.getTrabajador().setIdUsuario(rs.getInt("fidTrabajador"));
            promocion.setNombre(rs.getString("nombre"));
            promocion.setDescripcion(rs.getString("descripcion"));
            promocion.setValorDescuento(rs.getDouble("valorDescuento"));
            promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
            promocion.setFechaInicio(rs.getDate("fechaInicio"));
            promocion.setFechaFin(rs.getDate("fechaFin"));
            promocion.setActivo(true);
            promociones.add(promocion);
        }

		return promociones;
    }

	// OBTENER POR ID
    @Override
    public Promocion obtenerPorId(Integer idPromocion){
        return super.obtenerPorId(idPromocion);
    }

    @Override
    protected ArrayList<String> obtenerListaDeAtributosObtenerPorId(){
        ArrayList<String> atributos = new ArrayList<>();

		atributos.add("idPromocion");
        atributos.add("fidTrabajador");
        atributos.add("nombre");
        atributos.add("descripcion");
        atributos.add("valorDescuento");
        atributos.add("tipo");
        atributos.add("fechaInicio");
        atributos.add("fechaFin");
        atributos.add("activo");
        atributos.add("idPromocion");

        return atributos;
    }

    @Override
    public Promocion obtenerObtenerPorId(ResultSet rs) throws SQLException{
        Promocion promocion = new Promocion();

		while (rs.next()){
            promocion.setIdPromocion(rs.getInt("idPromocion"));
            promocion.getTrabajador().setIdUsuario(rs.getInt("fidTrabajador"));
            promocion.setNombre(rs.getString("nombre"));
            promocion.setDescripcion(rs.getString("descripcion"));
            promocion.setValorDescuento(rs.getDouble("valorDescuento"));
            promocion.setTipo(TipoPromocion.valueOf(rs.getString("tipo")));
            promocion.setFechaInicio(rs.getDate("fechaInicio"));
            promocion.setFechaFin(rs.getDate("fechaFin"));
            promocion.setActivo(rs.getBoolean("activo"));
        }

		return promocion;
    }
}
