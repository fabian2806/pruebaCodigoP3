using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftRhWeb.Usuario
{
    public partial class WebMasterUsuario : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Usuario_Click(object sender, EventArgs e)
        {
            Session.Clear();
        }

        protected void IniciarSesion_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Admin/Login.aspx");
        }

    }
}