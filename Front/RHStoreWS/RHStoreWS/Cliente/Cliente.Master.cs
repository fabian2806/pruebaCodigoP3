using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Cliente
{
    public partial class Cliente : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Aquí puedes cargar datos necesarios solo la primera vez que se carga la página
                CargarDatosUsuario();
            }
        }

        private void CargarDatosUsuario()
        {
            // Implementa la lógica para cargar datos del usuario
            // Por ejemplo, mostrar el nombre del usuario si ha iniciado sesión
            if (Session["Usuario"] != null)
            {
                string nombreUsuario = Session["Usuario"].ToString();
                // Aquí puedes actualizar el encabezado o cualquier otro control con el nombre del usuario
            }
        }

    }
}