/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.database.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level; 
import java.util.logging.Logger;
import pe.edu.pucp.softrh.database.config.DBManager;

public abstract class DAOImplementacion {
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
        statement = conexion.preparedStatement(sql);
        //System.out.println("FLAKO ES: " + sql);
        asignarValores(statement, valores);
        return statement.executeUpdate(sql);
    }
    
    protected ResultSet ejecutarConsultaEnBD(String sql, ArrayList<Object> valores) throws SQLException{
        statement = conexion.preparedStatement(sql);
        //System.out.println("FLAKO ES: " + sql);
        asignarValores(statement, valores);
        return statement.executeQuery(sql);
    }
    //Especificacion de la tabla    
    protected abstract ArrayList<String> obtenerListaDeAtributosInsertar();
    protected abstract ArrayList<String> obtenerListaDeAtributosModificar();
    protected abstract ArrayList<String> obtenerListaDeAtributosEliminar();
    protected abstract ArrayList<String> obtenerListaDeAtributosListarTodos();
    
    protected abstract ArrayList<String> obtenerListaDeValoresInsertar();
    protected abstract ArrayList<String> obtenerListaDeValoresModificar();
    protected abstract ArrayList<String> obtenerListaDeValoresEliminar();
    protected abstract ArrayList<String> obtenerListaDeValoresListarTodos();
    //Insertar
    public Integer insertar(){
        Integer resultado = 0;
        
        try{
            iniciarTransaccion();
            String sql = generarSQLParaInsertar();
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
    
    protected void asignarValores(PreparedStatement ps, ArrayList<Object> valores){
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
        /*
        switch(operacion){
            case "INSERTAR":
                sql += "INSERT INTO " + tabla + " (" + 
                break;
            case "MODIFICAR":
                break;
            case "ELIMINAR":
                break;
            case "LSITAR_TODOS":
                break;
            case "OBTENER_POR_ID":
                break;
        }*/
        
    }
    /*
    private String generarSQLParaInsercion(){
        String sql = "insert into " + tabla + "(";
        ArrayList<String> atributos, valores;
        
        atributos = obtenerListaDeAtributos();
        valores = obtenerListaDeValores();
                 
        for(int i = 0; i < atributos.size(); i++){
            sql += atributos.get(i);

            if(i + 1 < atributos.size()){
                sql += ",";
            } 
        }

        sql += ") values (";

        for(int i = 0; i < valores.size(); i++){
            sql += "'" + valores.get(i) + "'";

            if(i + 1 < atributos.size()){
                sql += ",";
            }
        }

        sql += ")";
        
        return sql;
    }*/
    
    //Actualizar
    public Integer modificar(){
        Integer resultado = 0;
        
        try{
            iniciarTransaccion();
            String sql = generarSQLParaModificar();
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
        for (int i=0; i<atributos.size(); i++){
            sql += atributos.get(i) + " = ?";
            if (i+1 < atributos.size())
                sql += ",";
        }
        sql += "WHERE " + atributos.get(0) + " = ?";
        
        return sql;
    }
    
    //Eliminar
    public Integer eliminar(String whereClausula)
    {
        Integer resultado = 0;
        
        try{
            iniciarTransaccion();
            String sql = generarSQLParaEliminar();
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
        
        sql += "DELETE FROM " + tabla + " WHERE " + atributos.get(0) + " = ?";
        
        return sql;
    }
    
    //Seleccionar todos
    public void listarTodos(){
        try{
            iniciarTransaccion();
            String sql = generarSQLParaListarTodos();
            result_set = this.ejecutarConsultaEnBD(sql, obtenerListaDeValoresListarTodos());
        } catch (SQLException ex){
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        sql = " FROM " + tabla;
        
        return sql;
    }
    
    public Integer obtenerPorId()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected String generarSQLParaObtenerPorId(){
        throw new UnsupportedOperationException("Not supported yet.");
    
}
