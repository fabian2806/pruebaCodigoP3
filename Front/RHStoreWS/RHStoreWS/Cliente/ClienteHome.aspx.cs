using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Cliente
{
    public partial class ClienteHome : System.Web.UI.Page
    {
        private PrendaBO prendaBO;
        private BindingList<prenda> listaDePrendas;

        public ClienteHome()
        {
            prendaBO = new PrendaBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            /*if (!IsPostBack)
            {
                CargarPrendas();
            }*/
        }

        protected string ObtenerImagen(int idPrenda)
        {
            // Obtener la imagen como bytes desde la base de datos
            byte[] imagenBytes = prendaBO.ObtenerImagen(idPrenda); // Implementa este método en PrendaBO
            if (imagenBytes != null)
            {
                // Convertir a Base64 para poder usar en src
                return "data:image/jpeg;base64," + Convert.ToBase64String(imagenBytes);
            }
            return string.Empty; // Devuelve una cadena vacía si no hay imagen
        }


        protected void RedirectToPage(string pageName)
        {
            Response.Redirect(pageName);
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            RedirectToPage("ClienteHome.aspx");
        }

        protected void btnHombre_Click(object sender, EventArgs e)
        {
            RedirectToPage("Hombre.aspx");
        }

        protected void btnMujer_Click(object sender, EventArgs e)
        {
            RedirectToPage("Mujer.aspx");
        }

        protected void btnUnisex_Click(object sender, EventArgs e)
        {
            RedirectToPage("Unisex.aspx");
        }
        
        protected void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            // Redirige a la página de inicio de sesión en Admin
            Response.Redirect("~/Admin/IniciarSesion.aspx");
        }

        protected void btnCarrito_Click(object sender, EventArgs e)
        {
            RedirectToPage("Carrito.aspx");
        }
    }
}