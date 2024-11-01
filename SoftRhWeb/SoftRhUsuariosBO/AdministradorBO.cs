using SoftRhBaseBO;
using SoftRhBaseBO.Servicios;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftRhUsuariosBO
{
	public class AdministradorBO : BaseBO
	{
		public int insertar(string dni, string nombres, string apellidos, string correo, string contrasenha, DateTime fechaCreacion)
		{
			return AdministradorWS.insetarAdministrador(dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
		}

		public int modificar(int idUsuario, string dni, string nombres, string apellidos, string correo, string contrasenha, DateTime fechaCreacion)
		{
			return AdministradorWS.modificarAdministrador(idUsuario, dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
		}

		public int eliminar(int idAdministrador)
		{
			return AdministradorWS.eliminarAdministrador(idAdministrador);
		}

		public BindingList<administrador> listarTodos()
		{
			return new BindingList<administrador>(AdministradorWS.listarAdministradoresTodos());
		}

		public administrador obtenerPorId(int idAdministrador)
		{
			return AdministradorWS.obtenerAdministradorPorId(idAdministrador);
		}
	}
}
