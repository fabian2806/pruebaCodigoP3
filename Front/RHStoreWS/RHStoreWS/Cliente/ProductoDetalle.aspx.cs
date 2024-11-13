using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
namespace RHStoreWS.Cliente
{
    public partial class ProductoDetalle : System.Web.UI.Page
    {
        private PrendaBO prendaBO = new PrendaBO();

        protected void Page_Load(object sender, EventArgs e)
        {
            ((Cliente)Master).ShowFullNav = false;
            if (!IsPostBack)
            {
                int idPrenda = Convert.ToInt32(Request.QueryString["idPrenda"]);
                if (idPrenda > 0)
                {
                    // Llamar al método para obtener la prenda por su ID y mostrarla
                    MostrarDetallePrenda(idPrenda);
                }
            }
        }

        private void MostrarDetallePrenda(int idPrenda)
        {
            prenda prenda = prendaBO.obtenerPorId(idPrenda);

            if (prenda != null)
            {
                lblNombre.Text = prenda.nombre;
                lblDescripcion.Text = prenda.descripcion;
                lblPrecio.Text = "S/ " + prenda.precioOriginal.ToString("F2");
                imgProducto.ImageUrl = "data:image/jpeg;base64," + Convert.ToBase64String(prenda.imagen);
                // Puedes agregar más información como talla, color, setc.
            }
        }
        protected void btnAgregarCarrito_Click(object sender, EventArgs e)
        {
            // Aquí puedes manejar la lógica para agregar el producto al carrito.
            string cantidad = txtCantidad.Text;

            // Lógica para agregar el producto al carrito
            // Ejemplo: Agregar el producto al carrito en la sesión o en la base de datos
            // ...

            // Redirigir a Carrito.aspx después de agregar el producto
            Response.Redirect("Carrito.aspx");
        }

    }
}