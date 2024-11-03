using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class CrudPromociones : System.Web.UI.Page
	{
		private PromocionBO promocionBO;

		public CrudPromociones()
		{
			promocionBO = new PromocionBO();
		}
		protected void Page_Load(object sender, EventArgs e)
		{
			string accion = Request.QueryString["accion"];
			if (accion != null && accion == "modificar")
			{
				lblTitulo.Text = "Modificación de Promoción";
				promocion _promocion = (promocion)Session["promocion"];
				cargarDatosDeLaBD(_promocion);
			}
			else
			{
				lblTitulo.Text = "Registro de Promoción";
			}
		}

		protected void cargarDatosDeLaBD(promocion _promocion)
		{

		}

		protected void lbRegresar_Click(object sender, EventArgs e)
		{
			Response.Redirect("GestionarPromociones.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{

		}
	}
}
