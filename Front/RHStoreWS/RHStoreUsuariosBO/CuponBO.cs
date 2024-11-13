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
	public class CuponBO : BaseBO
	{
        public int insertar(string codigo, string descripcion, double valorDescuento, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador)
        {
            return CuponWS.insertarCupon(codigo, descripcion, valorDescuento, fechaInicio, fechaFin, _trabajador);
        }

        public int modificar(int idCupon, string codigo, string descripcion, double valorDescuento, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador)
        {
            return CuponWS.modificarCupon(idCupon, codigo, descripcion, valorDescuento, fechaInicio, fechaFin, _trabajador);
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

		public BindingList<cupon> listarPorCodigoDescripcion(string cadena)
		{
			return new BindingList<cupon>(CuponWS.listarCuponesPorCodigoDescripcion(cadena));
		}
	}
}
