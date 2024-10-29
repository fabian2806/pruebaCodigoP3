package pe.edu.pucp.softrh.compras.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softrh.compras.dao.BoletaDAO;
import pe.edu.pucp.softrh.database.config.DBManager;
import pe.edu.pucp.softrh.compras.model.Boleta;

public class BoletaDAOImp implements BoletaDAO {
    
    private ResultSet rs;
    private DBManager dbManager = DBManager.obtenerInstancia();
    
    @Override
    public int insertar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int modificar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boleta obtenerPorId(int idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
