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
	public class CuponBO : BaseBO
	{
		public int insertar(string codigo, string descripcion, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador)
		{
			return CuponWS.insertarCupon(codigo, descripcion, fechaInicio, fechaFin, _trabajador);
		}

		public int modificar(int idCupon, string codigo, string descripcion, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador)
		{
			return CuponWS.modificarCupon(idCupon, codigo, descripcion, fechaInicio, fechaFin, _trabajador);
		}

		public int eliminar(int idCupon)
		{
			return CuponWS.eliminarCupon(idCupon);
		}

		public BindingList<cupon> listarTodos()
		{
			return new BindingList<cupon>(CuponWS.listarCuponesTodos());
		}

		public cupon obtenerPorId(int idCupon)
		{
			return CuponWS.obtenerCuponPorId(idCupon);
		}
	}
}
