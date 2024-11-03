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
	public partial class GestionarPrendas : System.Web.UI.Page
	{
		private PrendaBO prendaBO;
		private BindingList<prenda> listaDePrendas;

		public GestionarPrendas()
		{
			prendaBO = new PrendaBO();
			listaDePrendas = prendaBO.listarTodos();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if (!IsPostBack)
			{
				dgvPrendas.DataSource = listaDePrendas;
				dgvPrendas.DataBind();
			}
		}

		protected void lbRegistrar_Click(object sender, EventArgs e)
		{
			Response.Redirect("CrudPrendas.aspx");
		}

		protected void lbModificar_Click(object sender, EventArgs e)
		{
			int idPrenda = Int32.Parse(((LinkButton)sender).CommandArgument);
			prenda _prenda = prendaBO.obtenerPorId(idPrenda);
			Session["prenda"] = _prenda;
			Response.Redirect("CrudPrendas.aspx?accion=modificar");
		}

		protected void lbEliminar_Click(object sender, EventArgs e)
        {
			int idPrenda = Int32.Parse(((LinkButton)sender).CommandArgument);
			this.prendaBO.eliminar(idPrenda);
			Response.Redirect("GestionarPrendas.aspx");
		}

		protected void dgvPrendas_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			dgvPrendas.PageIndex = e.NewPageIndex;
			dgvPrendas.DataSource = listaDePrendas;
			dgvPrendas.DataBind();
		}

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
			string nombre = txtNombre.Text;
			listaDePrendas = prendaBO.listarPorNombre(nombre);
			dgvPrendas.DataSource = listaDePrendas;
			dgvPrendas.DataBind();
        }
    }
}
