using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Cliente
{
    public partial class Hombre : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void RedirectToPage(string pageName)
        {
            Response.Redirect(pageName);
        }
        protected void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            // Redirige a la página de inicio de sesión en Admin
            Response.Redirect("~/Admin/IniciarSesion.aspx");
        }

        protected void btnCarrito_Click(object sender, EventArgs e)
        {
            // Aquí se puede mostrar el resumen del carrito
            string message = "Resumen de tu carrito:\n\n";
            message += "LAVADORA SAMSUNG 19 KG CARGA SUPERIOR ECOBULTO\n";
            message += "Subtotal: S/ 1,399\n";
            message += "Total Tarjeta Ripley: S/ 1,299\n";

            // Mostrar un resumen simple en un popup o modal
            ScriptManager.RegisterStartupScript(this, GetType(), "showAlert", "alert('" + message + "');", true);
        }

    }
}