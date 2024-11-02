using RHStoreBaseBO;
using RHStoreBaseBO.ServiciosWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RHStoreUsuariosBO
{
	public class TrabajadorBO : BaseBO
	{
        public int insertar(string dni, string nombres, string apellidos, string correo, string contrasenha, string puesto, double sueldo, DateTime fechaIngreso, localTime horarioInicio, localTime horarioFin)
        {
            return TrabajadorWS.insertarTrabajador(dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
        }

        public int modificar(int idUsuario, string dni, string nombres, string apellidos, string correo, string contrasenha, string puesto, double sueldo, DateTime fechaIngreso, localTime horarioInicio, localTime horarioFin)
        {
            return TrabajadorWS.modificarTrabajador(idUsuario, dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
        }

        public int eliminar(int idTrabajador)
        {
            return TrabajadorWS.eliminarTrabajador(idTrabajador);
        }

        public BindingList<trabajador> listarTodos()
        {
            return new BindingList<trabajador>(TrabajadorWS.listarTrabajadoresTodos());
        }

        public trabajador obtenerPorId(int idTrabajador)
        {
            return TrabajadorWS.obtenerTrabajadorPorId(idTrabajador);
        }
    }
}
