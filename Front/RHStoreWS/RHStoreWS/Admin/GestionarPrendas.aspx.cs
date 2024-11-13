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
		private BindingList<prenda> listaPrendas;

		public GestionarPrendas()
		{
			prendaBO = new PrendaBO();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if (Session["administradorLogueado"] != null)
			{
				administrador _administrador = (administrador)Session["administradorLogueado"];
				lblNombreUsuario.Text = _administrador.nombres + " " + _administrador.apellidos;
			}
			else if (Session["trabajadorLogueado"] != null)
			{
				trabajador _trabajador = (trabajador)Session["trabajadorLogueado"];
				lblNombreUsuario.Text = _trabajador.nombres + " " + _trabajador.apellidos;
			}

			listaPrendas = prendaBO.listarTodos();
			gvPrendas.DataSource = listaPrendas;
			gvPrendas.DataBind();
		}

		protected void lbBuscar_Click(object sender, EventArgs e)
		{
			string cadena = txtNombreDescripcion.Text;
			listaPrendas = prendaBO.listarPorNombreDescripcion(cadena);
			gvPrendas.DataSource = listaPrendas;
			gvPrendas.DataBind();
		}

		protected void lbRegistrar_Click(object sender, EventArgs e)
		{
			Response.Redirect("CrudPrendas.aspx");
		}

		protected void gvPrendas_RowDataBound(object sender, GridViewRowEventArgs e)
		{
			if (e.Row.RowType == DataControlRowType.DataRow)
			{
				e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString();
				e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "descripcion").ToString();
				e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "talla").ToString();
				e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "genero").ToString();
				e.Row.Cells[4].Text = DataBinder.Eval(e.Row.DataItem, "color").ToString();
				e.Row.Cells[5].Text = DataBinder.Eval(e.Row.DataItem, "stock").ToString();
				e.Row.Cells[6].Text = DataBinder.Eval(e.Row.DataItem, "cantVendida").ToString();
				e.Row.Cells[7].Text = ((double)DataBinder.Eval(e.Row.DataItem, "precioOriginal")).ToString("N2");
				e.Row.Cells[8].Text = ((double)DataBinder.Eval(e.Row.DataItem, "precioDescontado")).ToString("N2");
			}
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

		protected void gvPrendas_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			gvPrendas.PageIndex = e.NewPageIndex;
			gvPrendas.DataBind();
		}
	}
}
