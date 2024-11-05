using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class GestionarPromociones : System.Web.UI.Page
	{
		private PromocionBO promocionBO;
		private BindingList<promocion> listaDePromociones;

		public GestionarPromociones()
		{
			promocionBO = new PromocionBO();
			listaDePromociones = promocionBO.listarTodos();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if (!IsPostBack)
			{
				dgvPromociones.DataSource = listaDePromociones;
				dgvPromociones.DataBind();
			}
		}

		protected void lbRegistrar_Click(object sender, EventArgs e)
		{
			Response.Redirect("CrudPromociones.aspx");
		}

		protected void lbModificar_Click(object sender, EventArgs e)
		{
			int idPromocion = Int32.Parse(((LinkButton)sender).CommandArgument);
			promocion _promocion = promocionBO.obtenerPorId(idPromocion);
			Session["promocion"] = _promocion;
			Response.Redirect("CrudPromociones.aspx?accion=modificar");
		}

		protected void lbEliminar_Click(object sender, EventArgs e)
		{
			int idPromocion = Int32.Parse(((LinkButton)sender).CommandArgument);
			this.promocionBO.eliminar(idPromocion);
			Response.Redirect("GestionarPromociones.aspx");
		}

		protected void dgvPromociones_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			dgvPromociones.PageIndex = e.NewPageIndex;
			dgvPromociones.DataSource = listaDePromociones;
			dgvPromociones.DataBind();
		}

		protected void lbBuscar_Click(object sender, EventArgs e)
		{
			string nombre = txtNombre.Text;
			listaDePromociones = promocionBO.listarPorNombre(nombre);
			dgvPromociones.DataSource = listaDePromociones;
			dgvPromociones.DataBind();
		}
	}
}
