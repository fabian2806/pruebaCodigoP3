package pe.edu.pucp.softrh.database.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;

public abstract class DAOImplementacion<T> {
    protected String tabla;
    protected Connection conexion;
    protected PreparedStatement statement;
    protected ResultSet result_set;

    //Constructor
    public DAOImplementacion(String tabla){
        this.tabla = tabla;
    }

    //Metodos de interaccion con BD
    protected void iniciarTransaccion() throws SQLException{
        this.conexion = DBManager.obtenerInstancia().obtenerConexion();
        this.conexion.setAutoCommit(false);
    }

    protected void cerrarConexion() throws SQLException{
        if (this.conexion != null){
            this.conexion.close();
        }
    }

    protected void comitarTransaccion() throws SQLException{
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException{
        if (this.conexion != null){
            this.conexion.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql, ArrayList<Object> valores) throws SQLException{
        statement = conexion.prepareStatement(sql);
        asignarValores(statement, valores);
        return statement.executeUpdate();
    }

    protected ResultSet ejecutarConsultaEnBD(String sql) throws SQLException{
        statement = conexion.prepareStatement(sql);
        return statement.executeQuery();
    }

    //Especificacion de la tabla
    protected abstract ArrayList<String> obtenerListaDeAtributosInsertar();
    protected abstract ArrayList<String> obtenerListaDeAtributosModificar();
    protected abstract ArrayList<String> obtenerListaDeAtributosEliminar();
    protected abstract ArrayList<String> obtenerListaDeAtributosListarTodos();
    protected abstract ArrayList<String> obtenerListaDeAtributosObtenerPorId();

    protected abstract ArrayList<Object> obtenerListaDeValoresInsertar();
    protected abstract ArrayList<Object> obtenerListaDeValoresModificar();
    protected abstract ArrayList<Object> obtenerListaDeValoresEliminar();

    //Insertar
    public Integer insertar(){
        Integer resultado = 0;

        try{
            iniciarTransaccion();
            String sql = generarSQLParaInsertar();
            System.out.println(sql);
            resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresInsertar());
            comitarTransaccion();
        } catch (SQLException ex){
            try {
                rollbackTransaccion();
            }
            catch (SQLException ex1){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                cerrarConexion();
            } catch (SQLException ex){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    protected void asignarValores(PreparedStatement ps, ArrayList<Object> valores) throws SQLException{
        int i=1;
        for (Object valor : valores){
            if (valor instanceof String){
                ps.setString(i, (String)valor);
            }
            else if (valor instanceof Integer){
                ps.setInt(i, (Integer)valor);
            }
            else if (valor instanceof Double){
                ps.setDouble(i, (Double)valor);
            }
            else if (valor instanceof Boolean){
                ps.setBoolean(i, (Boolean)valor);
            }
            i++;
        }
    }

    protected String generarSQLParaInsertar(){
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosInsertar();

        sql += "INSERT INTO " + tabla + " (";
        for (int i=0; i<atributos.size(); i++){
            sql += atributos.get(i);
            if (i+1 < atributos.size())
                sql += ",";
        }
        sql += ") VALUES (";
        for (int i=0; i<atributos.size(); i++){
            sql += "?";
            if (i+1 < atributos.size())
                sql += ",";
        }
        sql += ")";

        return sql;
    }

    //Actualizar
    public Integer modificar(){
        Integer resultado = 0;

        try{
            iniciarTransaccion();
            String sql = generarSQLParaModificar();
            System.out.println(sql);
            resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresModificar());
            comitarTransaccion();
        } catch (SQLException ex){
            try {
                rollbackTransaccion();
            }
            catch (SQLException ex1){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                cerrarConexion();
            } catch (SQLException ex){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    protected String generarSQLParaModificar(){
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosModificar();

        sql += "UPDATE " + tabla + " SET ";
        for (int i=0; i<atributos.size() - 1; i++){
            sql += atributos.get(i) + " = ?";
            if (i+1 < atributos.size() - 1)
                sql += ",";
        }
        sql += " WHERE " + atributos.get(atributos.size()-1) + " = ?";

        return sql;
    }

    //Eliminar
    public Integer eliminar()
    {
        Integer resultado = 0;

        try{
            iniciarTransaccion();
            String sql = generarSQLParaEliminar();
            System.out.println(sql);
            resultado = this.ejecutarModificacionesEnBD(sql, obtenerListaDeValoresEliminar());
            comitarTransaccion();
        } catch (SQLException ex){
            try {
                rollbackTransaccion();
            }
            catch (SQLException ex1){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                cerrarConexion();
            } catch (SQLException ex){
                Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    protected String generarSQLParaEliminar(){
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosEliminar();

        sql += "UPDATE " + tabla + " SET " + atributos.get(0) + " = 0 WHERE " + atributos.get(1) + " = ?" ;

        return sql;
    }

    public abstract ArrayList<T> obtenerListarTodos(ResultSet result_set) throws SQLException;

    //Seleccionar todos
    public ArrayList<T> listarTodos(){
        ArrayList<T> variable = null;
        try{
            this.conexion = DBManager.obtenerInstancia().obtenerConexion();
            String sql = generarSQLParaListarTodos();
            System.out.println(sql);
            result_set = this.ejecutarConsultaEnBD(sql);
            variable = obtenerListarTodos(result_set);
        } catch (SQLException ex){
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return variable;
    }

    protected String generarSQLParaListarTodos(){
        String sql = "";
        ArrayList<String> atributos;

        atributos = obtenerListaDeAtributosListarTodos();

        sql += "SELECT ";
        for (int i=0; i<atributos.size(); i++){
            sql += atributos.get(i);
            if (i+1 < atributos.size())
                sql += ",";
        }
        sql += " FROM " + tabla + " WHERE activo = 1" ;

        return sql;
    }

    public abstract T obtenerObtenerPorId(ResultSet result_set) throws SQLException;

    public T obtenerPorId(Integer id){
        T variable = null;
        try{
            this.conexion = DBManager.obtenerInstancia().obtenerConexion();
            String sql = generarSQLParaObtenerPorId(id);
            System.out.println(sql);
            result_set = this.ejecutarConsultaEnBD(sql);
            variable = obtenerObtenerPorId(result_set);
        } catch (SQLException ex){
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
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

        return sql;
    }

}
