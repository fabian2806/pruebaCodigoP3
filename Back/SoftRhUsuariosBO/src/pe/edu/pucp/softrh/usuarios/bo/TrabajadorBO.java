package pe.edu.pucp.softrh.usuarios.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.dao.TrabajadorDAO;
import pe.edu.pucp.softrh.usuarios.daoimp.TrabajadorDAOImp;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;
import pe.edu.pucp.softrh.usuarios.model.Usuario;

public class TrabajadorBO{
	private TrabajadorDAO trabajadorDAO;

	public TrabajadorBO() {
		this.trabajadorDAO = new TrabajadorDAOImp();
	}

	public Integer insertar(String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, String horarioInicio, String horarioFin) {
		Usuario trabajador = new Trabajador(dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
		return trabajadorDAO.insertar((Trabajador)trabajador);
	}

	public Integer modificar(Integer idUsuario, String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, String horarioInicio, String horarioFin) {
		Usuario trabajador = new Trabajador(dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
		trabajador.setIdUsuario(idUsuario);
		return trabajadorDAO.modificar((Trabajador)trabajador);
	}

	public Integer eliminar(Integer idtrabajador) {
		return trabajadorDAO.eliminar(idtrabajador);
	}

	public ArrayList<Trabajador> listarTodos() {
		return trabajadorDAO.listarTodos();
	}

	public Trabajador obtenerPorId(Integer idtrabajador) {
		return trabajadorDAO.obtenerPorId(idtrabajador);
	}

	public ArrayList<Trabajador> listarPorDniNombre(String cadena) {
		return trabajadorDAO.listarPorDniNombre(cadena);
	}
}
