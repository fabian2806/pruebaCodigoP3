using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Cliente
{
    public partial class ClienteHome : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Cualquier lógica de inicialización que necesites
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