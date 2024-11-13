package pe.edu.pucp.softrh.prendas.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class PrendaDAOImp implements PrendaDAO {

    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();

    @Override
    public int insertar(Prenda prenda) {
        int resultado = 0;
        Object[] parameters = new Object[10];
        parameters[0] = prenda.getIdPrenda();
        parameters[1] = prenda.getNombre();
        parameters[2] = prenda.getDescripcion();
        parameters[3] = prenda.getTipo().name();
        parameters[4] = prenda.getImagen();
        parameters[5] = prenda.getTalla().name();
        parameters[6] = prenda.getGenero().name();
        parameters[7] = prenda.getColor();
        parameters[8] = prenda.getPrecioOriginal();
        parameters[9] = prenda.getStock();

        prenda.setIdPrenda(dbManager.EjecutarProcedimiento("INSERTAR_PRENDA", parameters, true));
        resultado = prenda.getIdPrenda();

        return resultado;
    }

    @Override
    public int modificar(Prenda prenda) {
        int resultado = 0;
        Object[] parameters = new Object[10];
        parameters[0] = prenda.getIdPrenda();
        parameters[1] = prenda.getNombre();
        parameters[2] = prenda.getDescripcion();
        parameters[3] = prenda.getTipo().name();
        parameters[4] = prenda.getImagen();
        parameters[5] = prenda.getTalla().name();
        parameters[6] = prenda.getGenero().name();
        parameters[7] = prenda.getColor();
        parameters[8] = prenda.getPrecioOriginal();
        parameters[9] = prenda.getStock();

        resultado = dbManager.EjecutarProcedimiento("MODIFICAR_PRENDA", parameters, false);

        return resultado;
    }

    @Override
    public int eliminar(int idPrenda) {
        int resultado = 0;
        Object[] parameters = new Object[1];
        parameters[0] = idPrenda;
        resultado = dbManager.EjecutarProcedimiento("ELIMINAR_PRENDA", parameters, false);
        return resultado;
    }

    @Override
    public ArrayList<Prenda> listarTodos() {
        ArrayList<Prenda> prendas = new ArrayList<Prenda>();
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PRENDAS_TODAS", null);
        try{
            while(rs.next()){
            Prenda prenda = new Prenda();
            prenda.setIdPrenda(rs.getInt("idPrenda"));
            prenda.setNombre(rs.getString("nombre"));
            prenda.setDescripcion(rs.getString("descripcion"));
            prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
            prenda.setImagen(rs.getBytes("imagen"));
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
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return prendas;
    }

    @Override
    public Prenda obtenerPorId(int idPrenda) {
        Prenda prenda = new Prenda();
        Object[] parameters = new Object[1];
        parameters[0] = idPrenda;
        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PRENDA_X_ID", parameters);
        try{
            while(rs.next()){
            prenda.setIdPrenda(rs.getInt("idPrenda"));
            prenda.setNombre(rs.getString("nombre"));
            prenda.setDescripcion(rs.getString("descripcion"));
            prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
            prenda.setImagen(rs.getBytes("imagen"));
            prenda.setTalla(Talla.valueOf(rs.getString("talla")));
            prenda.setGenero(Genero.valueOf(rs.getString("genero")));
            prenda.setColor(rs.getString("color"));
            prenda.setPrecioOriginal(rs.getDouble("precioOriginal"));
            prenda.setPrecioDescontado(rs.getDouble("precioDescontado"));
            prenda.setStock(rs.getInt("stock"));
            prenda.setCantVendida(rs.getInt("cantVendida"));
            prenda.setActivo(true);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return prenda;
    }

	@Override
	public ArrayList<Prenda> listarPorNombreDescripcion(String cadena) {
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();

		Object[] parameters = new Object[1];
        parameters[0] = cadena;

        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PRENDAS_X_NOMBRE_O_DESCRIPCION", parameters);
        try{
            while(rs.next()){
				Prenda prenda = new Prenda();

				prenda.setIdPrenda(rs.getInt("idPrenda"));
				prenda.setNombre(rs.getString("nombre"));
				prenda.setDescripcion(rs.getString("descripcion"));
				prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
				prenda.setImagen(rs.getBytes("imagen"));
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
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return prendas;
	}

    @Override
    public ArrayList<Prenda> listarPrendasFiltradas(Double minPrice, Double maxPrice, Boolean filterHombre, Boolean filterMujer, Boolean filterUnisex, String tallas, String colores) {
        ArrayList<Prenda> prendas = new ArrayList<>();
        Object[] parameters = new Object[7];
        parameters[0] = minPrice;
        parameters[1] = maxPrice;
        parameters[2] = filterHombre;
        parameters[3] = filterMujer;
        parameters[4] = filterUnisex;
        parameters[5] = tallas;
        parameters[6] = colores;

        rs = dbManager.EjecutarProcedimientoLectura("LISTAR_PRENDAS_FILTRADAS", parameters);
        try {
            if (rs != null) { // Verifica si rs no es null
                while (rs.next()) { // Recorre todos los resultados
                    Prenda prenda = new Prenda();
                    prenda.setIdPrenda(rs.getInt("idPrenda"));
                    prenda.setNombre(rs.getString("nombre"));
                    prenda.setDescripcion(rs.getString("descripcion"));
                    prenda.setTipo(TipoPrenda.valueOf(rs.getString("tipo")));
                    prenda.setImagen(rs.getBytes("imagen"));
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
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                dbManager.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PrendaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Siempre devuelve la lista, aunque esté vacía
        return prendas;
    }
}
