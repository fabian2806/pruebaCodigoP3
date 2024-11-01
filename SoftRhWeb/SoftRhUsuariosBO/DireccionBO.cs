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
	public class DireccionBO : BaseBO
	{
		public int insertar(string direc, string distrito, string provincia, string departamento, string codigoPostal, string referencia, cliente _cliente)
		{
			return DireccionWS.insetarDireccion(direc, distrito, provincia, departamento, codigoPostal, referencia, _cliente);
		}

		public int modificar(int idDireccion, string direc, string distrito, string provincia, string departamento, string codigoPostal, string referencia, cliente _cliente)
		{
			return DireccionWS.modificarDireccion(idDireccion, direc, distrito, provincia, departamento, codigoPostal, referencia, _cliente);
		}

		public int eliminar(int idDireccion)
		{
			return DireccionWS.eliminarDireccion(idDireccion);
		}

		public BindingList<direccion> listarTodos()
		{
			return new BindingList<direccion>(DireccionWS.listarDireccionesTodas());
		}

		public direccion obtenerPorId(int idDireccion)
		{
			return DireccionWS.obtenerDireccionPorId(idDireccion);
		}
	}
}
