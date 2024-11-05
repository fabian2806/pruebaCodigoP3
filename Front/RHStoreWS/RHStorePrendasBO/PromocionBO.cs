using RHStoreBaseBO;
using RHStoreBaseBO.ServiciosWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RHStorePrendasBO
{
	public class PromocionBO : BaseBO
	{
        public int insertar(string nombre, string descripcion, double valorDescuento, tipoPromocion tipo, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador, prenda _prenda)
        {
            return PromocionWS.insertarPromocion(nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, _trabajador, _prenda);
        }
        public int modificar(int idPromocion, string nombre, string descripcion, double valorDescuento, tipoPromocion tipo, DateTime fechaInicio, DateTime fechaFin, trabajador _trabajador, prenda _prenda)
        {
            return PromocionWS.modificarPromocion(idPromocion, nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, _trabajador, _prenda);
        }
        public int eliminar(int idPromocion)
        {
            return PromocionWS.eliminarPromocion(idPromocion);
        }

        public BindingList<promocion> listarTodos()
        {
            return new BindingList<promocion>(PromocionWS.listarPromocionesTodas());
        }

        public promocion obtenerPorId(int idPromocion)
        {
            return PromocionWS.obtenerPromocionPorId(idPromocion);
        }

		public BindingList<promocion> listarPorNombre(string nombre)
		{
			return new BindingList<promocion>(PromocionWS.listarPromocionesPorNombre(nombre));
		}
	}
}
