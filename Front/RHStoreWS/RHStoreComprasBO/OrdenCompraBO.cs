using RHStoreBaseBO.ServiciosWeb;
using RHStoreBaseBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RHStoreComprasBO
{
	public class OrdenCompraBO : BaseBO
	{
		public int insertar(DateTime fechaRegistro, DateTime fechaProcesado, DateTime fechaEntregado, DateTime fechaAnulado,
			estado _estado, string dni, string correo, double subtotal, cliente _cliente)
		{
			return OrdencompraWS.insertarOrdenCompra(fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, _estado, dni, correo, subtotal, _cliente);
		}

		public int modificar(int IdOrdenCompra, DateTime fechaRegistro, DateTime fechaProcesado, DateTime fechaEntregado, DateTime fechaAnulado,
			estado _estado, string dni, string correo, double subtotal, cliente _cliente)
		{
			return OrdencompraWS.modificarOrdenCompra(IdOrdenCompra, fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, _estado, dni, correo, subtotal, _cliente);
		}

		public int eliminar(int idOrdenCompra)
		{
			return OrdencompraWS.eliminarOrdenCompra(idOrdenCompra);
		}

		public BindingList<ordenCompra> listarOrdenCompraTodos()
		{
			return new BindingList<ordenCompra>(OrdencompraWS.listarOrdenCompraTodos());
		}

		public ordenCompra obtenerPorId(int idOrdenCompra)
		{
			return OrdencompraWS.obtenerOrdenCompraPorId(idOrdenCompra);
		}

		public BindingList<ordenCompra> listarOrdenCompraPorEstado(string estado)
		{
			return new BindingList<ordenCompra>(OrdencompraWS.listarOrdenPorEstado(estado));
		}
	}
}
