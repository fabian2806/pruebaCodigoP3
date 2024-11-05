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
                CargarDatosUsuario();
            }
        }

        private void CargarDatosUsuario()
        {
            // Lógica para cargar datos del usuario
            if (Session["Usuario"] != null)
            {
                string nombreUsuario = Session["Usuario"].ToString();
                // Aquí puedes actualizar el encabezado o cualquier otro control con el nombre del usuario
            }
        }


    }
}