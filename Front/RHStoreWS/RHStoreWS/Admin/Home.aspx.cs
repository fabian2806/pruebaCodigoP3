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
		private trabajador _trabajador;
		private administrador _administrador;

		protected void Page_Init(object sender, EventArgs e)
		{
			string rol = Request.QueryString["rol"];
            if(rol == "administrador" && Session["administrador"] != null)
			{
				_administrador = new administrador();
				_administrador = (administrador)Session["administrador"];
				lblRol.Text = "Perfil de Administrador";
				lblNombre.Text = _administrador.nombres;
				
			} else if(rol == "trabajador" && Session["trabajador"] != null)
			{
				_trabajador = new trabajador();
				_trabajador = (trabajador)Session["trabajador"];                                          
				lblRol.Text = "Perfil de Trabajador";
				lblNombre.Text = _trabajador.nombres;
			}
        }
	}
}