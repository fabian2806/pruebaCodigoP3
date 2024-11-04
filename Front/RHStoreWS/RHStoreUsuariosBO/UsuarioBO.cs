using RHStoreBaseBO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RHStoreUsuariosBO
{
	public class UsuarioBO : BaseBO
	{
        public int verificarIngresoUsuario(string correo, string contrasenha)
        {
            return UsuarioWS.verificarIngresoUsuario(correo, contrasenha);
        }

		public string obtenerRolUsuario(string correo, string contrasenha)
		{
			return UsuarioWS.obtenerRolUsuario(correo, contrasenha);
		}

		public int verificarContrasenha(int idUsuario, string contrasenha)
		{
			return UsuarioWS.verificarContrasenha(idUsuario, contrasenha);
		}

		public int cambiarContrasenha(int idUsuario, string contrasenhaNueva)
		{
			return UsuarioWS.cambiarContrasenha(idUsuario, contrasenhaNueva);
		}
	}
}
