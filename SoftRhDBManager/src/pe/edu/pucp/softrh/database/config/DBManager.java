package pe.edu.pucp.softrh.database.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import static pe.edu.pucp.softrh.database.seg.Cifrado.decipher_MD5;

public class DBManager {
    private static final String ARCHIVO_CONFIGURACION = "datosConexion.txt";
    private Connection conexion;
    private String driver;
    private String driver_type;
    private String database;
    private String host_name;
    private String port;
    private String user;
    private String password;
	private String url;
    private static DBManager db_manager = null;

    private DBManager() {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            leerArchivoYCrearCadena();
        }catch(ClassNotFoundException ex){
            System.out.println("Error registrando el driver: " + ex.getMessage());
        }
	}

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
        try{
            conexion = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conexion;
    }

    private String getURL(){
        String cad = "";
		cad = cad.concat(this.driver_type.concat("://"));
        cad = cad.concat(this.host_name);
        cad = cad.concat(":");
        cad = cad.concat(this.port);
        cad = cad.concat("/");
        cad = cad.concat(this.database);
		cad = cad.concat("?useSSL=false");
        return cad;
    }

    private void leerArchivoYCrearCadena(){
        Map<String, String> config = new HashMap<>();
        String rutaArchivo = "";
        try{
            URL resourceUrl = DBManager.class.getResource("/pe/edu/pucp/softrh/config/");
            String decodedPath = URLDecoder.decode(resourceUrl.getPath(), "UTF-8");
            rutaArchivo = decodedPath + ARCHIVO_CONFIGURACION;
        }catch(UnsupportedEncodingException ex){
            System.out.println(ex.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    config.put(partes[0].trim(), partes[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo de conexion: " + e.getMessage());
        }

        user = config.get("user");
        password = decipher_MD5(config.get("password"));
		driver_type = config.get("driver_type");
		database = config.get("database");
		host_name = config.get("host_name");
		port = config.get("port");

        url = getURL();

		//"jdbc:mysql://" + config.get("hostname") + ":" + config.get("port") + "/" + config.get("database") + "?useSSL=false";
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