package pe.edu.pucp.softrh.database.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;

public abstract class DAOImp<T> {
    protected String tabla;
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;

    //Constructor
    public DAOImp(String tabla) {
        this.tabla = tabla;
    }

    //Metodos de interaccion con BD
    protected void iniciarTransaccion() throws SQLException {
        this.con = DBManager.obtenerInstancia().obtenerConexion();
        this.con.setAutoCommit(false);
    }

    protected void cerrarConexion() throws SQLException {
        if(this.con != null) {
            this.con.close();
        }
    }

    protected void comitarTransaccion() throws SQLException {
        this.con.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if(this.con != null) {
            this.con.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql, ArrayList<Object> valores) throws SQLException {
        ps = con.prepareStatement(sql);
        asignarValores(ps, valores);
        return ps.executeUpdate();
    }

    protected ResultSet ejecutarConsultaEnBD(String sql) throws SQLException {
        ps = con.prepareStatement(sql);
        return ps.executeQuery();
    }

	protected void asignarValores(PreparedStatement ps, ArrayList<Object> valores) throws SQLException {
        int i = 1;
        for(Object valor : valores) {
            if(valor instanceof String) {
                ps.setString(i, (String)valor);
            }
            else if(valor instanceof Integer) {
                ps.setInt(i, (Integer)valor);
            }
            else if(valor instanceof Double) {
                ps.setDouble(i, (Double)valor);
            }
            else if(valor instanceof Boolean) {
                ps.setBoolean(i, (Boolean)valor);
            } else if(valor instanceof Date) {
				ps.setDate(i, new java.sql.Date(((Date)valor).getTime()));
			} else if(valor instanceof LocalTime) {
				ps.setTime(i, java.sql.Time.valueOf((LocalTime)valor));
			}
            i++;
        }
    }

	protected abstract ArrayList<String> obtenerListaDeAtributosInsertar();
	protected abstract ArrayList<Object> obtenerListaDeValoresInsertar();

    public Integer insertar() {
        Integer resultado = 0;

        try {
            iniciarTransaccion();
            String sql = generarSQLParaInsertar();
            System.out.println(sql);
            resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresInsertar());
			Integer id = this.retornarUltimoIdGenerado();
			resultado = id;
            comitarTransaccion();
        } catch(SQLException ex) {
            try {
                rollbackTransaccion();
            }
            catch(SQLException ex1) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cerrarConexion();
            } catch(SQLException ex) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

	protected String generarSQLParaInsertar() {
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosInsertar();

        sql += "INSERT INTO " + tabla + " (";
        for(int i = 0; i < atributos.size(); i++) {
            sql += atributos.get(i);
            if(i + 1 < atributos.size())
                sql += ",";
        }
        sql += ") VALUES (";
        for (int i = 0; i < atributos.size(); i++) {
            sql += "?";
            if (i + 1 < atributos.size())
                sql += ",";
        }
        sql += ")";

        return sql;
    }

	protected Integer retornarUltimoIdGenerado() throws SQLException {
		Integer resultado = null;
		String sql = "select @@last_insert_id as id";
		rs = this.ejecutarConsultaEnBD(sql);
		if(rs.next())
			resultado = rs.getInt("id");
		return resultado;
	}

	protected abstract ArrayList<String> obtenerListaDeAtributosModificar();
	protected abstract ArrayList<Object> obtenerListaDeValoresModificar();

    public Integer modificar() {
        Integer resultado = 0;

        try {
            iniciarTransaccion();
            String sql = generarSQLParaModificar();
            System.out.println(sql);
            resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresModificar());
            comitarTransaccion();
        } catch(SQLException ex) {
            try {
                rollbackTransaccion();
            }
            catch(SQLException ex1) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cerrarConexion();
            } catch(SQLException ex) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    protected String generarSQLParaModificar() {
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosModificar();

        sql += "UPDATE " + tabla + " SET ";
        for (int i=0; i<atributos.size() - 1; i++) {
            sql += atributos.get(i) + " = ?";
            if (i + 1 < atributos.size() - 1)
                sql += ",";
        }
        sql += " WHERE " + atributos.get(atributos.size()-1) + " = ?";

        return sql;
    }

	protected abstract ArrayList<String> obtenerListaDeAtributosEliminar();
	//protected abstract ArrayList<Object> obtenerListaDeValoresEliminar();

    public Integer eliminar(Integer id) {
        Integer resultado = 0;

        try {
            iniciarTransaccion();
            String sql = generarSQLParaEliminar(id);
            System.out.println(sql);
            //resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresEliminar());
            ps = con.prepareStatement(sql);
			resultado = ps.executeUpdate();
			comitarTransaccion();
        } catch(SQLException ex) {
            try {
                rollbackTransaccion();
            }
            catch(SQLException ex1) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cerrarConexion();
            } catch(SQLException ex) {
                Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    protected String generarSQLParaEliminar(Integer id) {
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosEliminar();

        sql += "UPDATE " + tabla + " SET activo = 0 WHERE " + atributos.get(0) + " = " + id ;

        return sql;
    }

	protected abstract ArrayList<String> obtenerListaDeAtributosListarTodos();
    protected abstract ArrayList<T> obtenerListarTodos(ResultSet rs) throws SQLException;

    public ArrayList<T> listarTodos() {
        ArrayList<T> variable = null;
        try {
            this.con = DBManager.obtenerInstancia().obtenerConexion();
            String sql = generarSQLParaListarTodos();
            System.out.println(sql);
            rs = this.ejecutarConsultaEnBD(sql);
            variable = obtenerListarTodos(rs);
        } catch (SQLException ex){
            Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
			try {
				con.close();
			} catch(SQLException ex) {
				Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
        return variable;
    }

    protected String generarSQLParaListarTodos() {
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosListarTodos();

        sql += "SELECT ";
        for(int i = 0; i < atributos.size(); i++) {
            sql += atributos.get(i);
            if(i + 1 < atributos.size())
                sql += ",";
        }
        sql += " FROM " + tabla + " WHERE activo = 1" ;

        return sql;
    }

	protected abstract ArrayList<String> obtenerListaDeAtributosObtenerPorId();
    protected abstract T obtenerObtenerPorId(ResultSet rs) throws SQLException;

    public T obtenerPorId(Integer id) {
        T variable = null;
        try {
            this.con = DBManager.obtenerInstancia().obtenerConexion();
            String sql = generarSQLParaObtenerPorId(id);
            System.out.println(sql);
            rs = this.ejecutarConsultaEnBD(sql);
            variable = obtenerObtenerPorId(rs);
        } catch(SQLException ex) {
            Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
			try {
				con.close();
			} catch(SQLException ex) {
				Logger.getLogger(DAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
        return variable;
    }

    protected String generarSQLParaObtenerPorId(Integer id){
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosObtenerPorId();

        sql += "SELECT ";
        for (int i=0; i<atributos.size()-1; i++){
            sql += atributos.get(i);
            if (i+1 < atributos.size()-1)
                sql += ",";
        }
        sql += " FROM " + tabla + " WHERE " + atributos.get(atributos.size()-1) + " = " + id;
		sql += " AND activo = 1";

        return sql;
    }
}
