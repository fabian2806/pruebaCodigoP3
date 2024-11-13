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
	public class PrendaBO : BaseBO
	{
        public int insertar(string nombre, string descripcion, tipoPrenda tipo, byte[] imagen, talla _talla, genero _genero, string color, double precioOriginal, int stock)
        {
            return PrendaWS.insertarPrenda(nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, stock);
        }
        public int modificar(int idPrenda, string nombre, string descripcion, tipoPrenda tipo, byte[] imagen, talla _talla, genero _genero, string color, double precioOriginal, int stock)
        {
            return PrendaWS.modificarPrenda(idPrenda, nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, stock);
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

        public BindingList<prenda> listarPorNombreDescripcion(string cadena)
        {
			return new BindingList<prenda>(PrendaWS.listarPrendasPorNombreDescripcion(cadena));
		}

		public BindingList<prenda> listarPrendasFiltradas(double minPrice, double maxPrice, bool filterHombre, bool filterMujer, bool filterUnisex, string tallas, string colores)
		{
			// Llama al método del servicio web que corresponde al procedimiento almacenado
			return new BindingList<prenda>(PrendaWS.listarPrendasFiltradas(minPrice, maxPrice, filterHombre, filterMujer, filterUnisex, tallas, colores));
		}

		public byte[] ObtenerImagen(int idPrenda)
		{
			return PrendaWS.obtenerImagenPorId(idPrenda);
		}
	}
}
