using RHStoreBaseBO.ServiciosWeb;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class Home : System.Web.UI.Page
	{
		private administrador _administrador;
		private trabajador _trabajador;

		protected void Page_Load(object sender, EventArgs e)
		{
            if(Session["administrador"] != null)
			{
				_administrador = (administrador)Session["administrador"];
				lblRol.Text = "Perfil de Administrador: ";
				lblNombre.Text = _administrador.nombres + " " + _administrador.apellidos;
				
			} else if(Session["trabajador"] != null)
			{
				_trabajador = (trabajador)Session["trabajador"];                           
				lblRol.Text = "Perfil de Trabajador: ";
				lblNombre.Text = _trabajador.nombres + " " + _trabajador.apellidos;
			}
        }
	}
}
