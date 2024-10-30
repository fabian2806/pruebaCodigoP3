using SoftRhBaseBO;
using SoftRhBaseBO.Servicios;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftRhPrendasBO
{
	public class PrendaBO : BaseBO
	{
		public int insertar(string nombre, string descripcion, tipoPrenda tipo, string imagen, talla _talla, genero _genero, string color, double precioOriginal, int stock)
		{
			return PrendaWS.insertarPrenda(nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, stock);
		}
		public int modificar(int idPrenda, string nombre, string descripcion, tipoPrenda tipo, string imagen, talla _talla, genero _genero, string color, double precioOriginal, double precioDescontado, int stock, int cantVendida)
		{
			return PrendaWS.modificarPrenda(idPrenda, nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, precioDescontado, stock, cantVendida);
		}
		public int eliminar(int idPrenda)
		{
			return PrendaWS.eliminarPrenda(idPrenda);
		}

		public BindingList<prenda> listarTodos()
		{
			return new BindingList<prenda>(PrendaWS.listarPrendasTodas());
		}

		public prenda obtenerPorId(int idPrenda)
		{
			return PrendaWS.obtenerPrendaPorId(idPrenda);
		}
	}
}
