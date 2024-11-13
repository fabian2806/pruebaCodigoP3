using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class GestionarCupones : System.Web.UI.Page
	{
		private CuponBO cuponBO;
		private BindingList<cupon> listaCupones;

		public GestionarCupones()
		{
			cuponBO = new CuponBO();
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

			listaCupones = cuponBO.listarTodos();
			gvCupon.DataSource = listaCupones;
			gvCupon.DataBind();
		}

		protected void lbBuscar_Click(object sender, EventArgs e)
		{
			string cadena = txtCodigoBuscado.Text;
			listaCupones = cuponBO.listarPorCodigoDescripcion(cadena);
			gvCupon.DataSource = listaCupones;
			gvCupon.DataBind();
		}

		protected void lbRegistrar_Click(object sender, EventArgs e)
		{
			Response.Redirect("CrudCupones.aspx");
		}

		protected void gvCupon_RowDataBound(object sender, GridViewRowEventArgs e)
		{
			if (e.Row.RowType == DataControlRowType.DataRow)
			{
				e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "codigo").ToString();
				e.Row.Cells[1].Text = ((trabajador)DataBinder.Eval(e.Row.DataItem, "trabajador")).nombres + " " + ((trabajador)DataBinder.Eval(e.Row.DataItem, "trabajador")).apellidos;
				e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "descripcion").ToString();
				e.Row.Cells[3].Text = ((double)DataBinder.Eval(e.Row.DataItem, "valorDescuento")).ToString() + "%";
				e.Row.Cells[4].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaInicio").ToString()).ToString("dd-MM-yyyy");
				e.Row.Cells[5].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaFin").ToString()).ToString("dd-MM-yyyy");
			}
		}

		protected void lbModificar_Click(object sender, EventArgs e)
		{
			int idCupon = Int32.Parse(((LinkButton)sender).CommandArgument);
			cupon _cuponPorModificar = cuponBO.obtenerPorId(idCupon);
			Session["cuponPorModificar"] = _cuponPorModificar;
			Response.Redirect("CrudCupones.aspx?accion=modificar");
		}

		protected void lbEliminar_Click(object sender, EventArgs e)
		{
			int idCupon = Int32.Parse(((LinkButton)sender).CommandArgument);
			this.cuponBO.eliminar(idCupon);
			Response.Redirect("GestionarCupones.aspx");
		}

		protected void gvCupon_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			gvCupon.PageIndex = e.NewPageIndex;
			gvCupon.DataBind();
		}
	}
}
