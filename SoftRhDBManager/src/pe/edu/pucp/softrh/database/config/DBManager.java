package pe.edu.pucp.softrh.database.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import static pe.edu.pucp.softrh.database.seg.Cifrado.decipher_MD5;

public class DBManager {
    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
    private Connection conexion;
    private String driver;
    private String driver_type;
    private String database;
    private String host_name;
    private String port;
    private String user;
    private String password;
    private static DBManager db_manager = null;

    private DBManager() {}

    public static DBManager obtenerInstancia() {
        if(DBManager.db_manager == null)
            crearInstancia();
        return DBManager.db_manager;
    }

    private static void crearInstancia() {
        if(DBManager.db_manager == null)
            DBManager.db_manager = new DBManager();
    }

    public Connection obtenerConexion(){
        leerConfiguracion();

        try {
            Class.forName(this.driver);
            this.conexion = DriverManager.getConnection(getURL(), this.user, decipher_MD5(this.password));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.conexion;
    }

    private String getURL(){
        String url = this.driver_type.concat("://");
        url = url.concat(this.host_name);
        url = url.concat(":");
        url = url.concat(this.port);
        url = url.concat("/");
        url = url.concat(this.database);
        return url;
    }

    private void leerConfiguracion(){
        Properties propiedades = new Properties();
        String archivo_configuracion_path = "resources/" + ARCHIVO_CONFIGURACION;

        try {
            propiedades.load(new FileInputStream(
                    new File(archivo_configuracion_path)));
            this.driver = propiedades.getProperty("driver");
            this.driver_type = propiedades.getProperty("driver_type");
            this.database = propiedades.getProperty("database");
            this.host_name = propiedades.getProperty("host_name");
            this.port = propiedades.getProperty("port");
            this.user = propiedades.getProperty("user");
            this.password = propiedades.getProperty("password");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.obtenerInstancia().obtenerConexion();
        this.conexion.setAutoCommit(false);
    }
    
    public void cerrarConexion() throws SQLException {
        if(this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if(this.conexion != null) {
            this.conexion.rollback();
        }
    }

    public int EjecutarProcedimiento(String nombreProcedimiento, Object[] parameters, Boolean nombreParametroSalida){
        int resultado = -1;
        CallableStatement cs = null;
        
        try{
            iniciarTransaccion();
            String procedimiento = obtenerCadenaProcedimiento(nombreProcedimiento, parameters, nombreParametroSalida);
            cs = conexion.prepareCall(procedimiento);
            if (parameters != null){
                for (int i=0; i<parameters.length; i++){
                    cs.setObject(i+1, parameters[i]);
                }
            }
            
            if (nombreParametroSalida == true){
                cs.registerOutParameter((parameters != null ? 1: 1), Types.INTEGER);
            }
            
            resultado = cs.executeUpdate();
            
            if (nombreParametroSalida == true){
                resultado = cs.getInt((parameters != null ? 1: 1));
            }
            
            this.conexion.commit();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return resultado;
    }
    
    public ResultSet EjecutarProcedimientoLectura(String nombreProcedimiento, Object[] parameters){
        ResultSet rs = null;
        CallableStatement cs = null;
        
        try{
            iniciarTransaccion();
            String procedimiento = obtenerCadenaProcedimiento(nombreProcedimiento, parameters, null);
            cs = conexion.prepareCall(procedimiento);
            if (parameters != null){
                for (int i=0; i<parameters.length; i++){
                    cs.setObject(i+1, parameters[i]);
                }
            }
            
            rs = cs.executeQuery();
        }
        catch (SQLException ex){
            ex.printStackTrace();;
        }
        
        return rs;
    }
    
    protected String obtenerCadenaProcedimiento(String nombreProcedimiento, Object[] parameters, Boolean nombreParametroSalida){
        String cadena = "";
        cadena += "{call " + nombreProcedimiento + "(";
        if (parameters != null){
            for (int i=0; i< parameters.length; i++){
                cadena += "?";
                if (i < parameters.length - 1){
                    cadena += ",";
                }
            }
        }
        /*
        if (nombreParametroSalida == true){
            cadena += ", ?";
        }*/
        
        cadena += ") }";
        return cadena;
    }
    
    
}
