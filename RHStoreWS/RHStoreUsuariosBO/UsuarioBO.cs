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
    }
}
