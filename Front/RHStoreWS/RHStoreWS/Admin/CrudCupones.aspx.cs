using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class CrudCupones : System.Web.UI.Page
	{
		private TrabajadorBO trabajadorBO;
		private CuponBO cuponBO;
		private trabajador _trabajadorSeleccionado;
		private cupon _cuponPorModificar;
		private BindingList<trabajador> listaTrabajadores;
		private bool estaModificando;

		public CrudCupones()
		{
			trabajadorBO = new TrabajadorBO();
			cuponBO = new CuponBO();
		}

		protected void Page_Init(object sender, EventArgs e)
		{
			if (Session["administradorLogueado"] != null)
			{
				administrador _administrador = (administrador)Session["administradorLogueado"];
				lblNombreUsuario.Text = _administrador.nombres + " " + _administrador.apellidos;
				lbBuscarTrabajador.Enabled = true;
				lbBuscarTrabajador.CssClass = "btn btn-primary col-sm-auto";
			}
			else if (Session["trabajadorLogueado"] != null)
			{
				trabajador _trabajador = (trabajador)Session["trabajadorLogueado"];
				lblNombreUsuario.Text = _trabajador.nombres + " " + _trabajador.apellidos;
				txtNombreTrabajador.Text = _trabajador.nombres + " " + _trabajador.apellidos;
				lbBuscarTrabajador.Enabled = false;
				lbBuscarTrabajador.CssClass = "btn btn-secondary col-sm-auto";
			}

			string accion = Request.QueryString["accion"];
			if (accion != null && accion == "modificar")
			{
				lblTitulo.Text = "Modificación de Cupón";
				_cuponPorModificar = (cupon)Session["cuponPorModificar"];
				estaModificando = true;
				cargarDatosDeLaBD();
			}
			else
			{
				lblTitulo.Text = "Registro de Cupón";
				estaModificando = false;
			}

			listaTrabajadores = trabajadorBO.listarTodos();
			modalSeleccionarTrabajador_gvTrabajadores.DataSource = listaTrabajadores;
			modalSeleccionarTrabajador_gvTrabajadores.DataBind();
		}

		protected void cargarDatosDeLaBD()
		{
			txtID.Text = _cuponPorModificar.idCupon.ToString();
			txtNombreTrabajador.Text = _cuponPorModificar.trabajador.nombres + " " + _cuponPorModificar.trabajador.apellidos;
			txtCodigo.Text = _cuponPorModificar.codigo;
			txtValorDescuento.Text = _cuponPorModificar.valorDescuento.ToString("N0");
			dtpFechaInicio.Value = _cuponPorModificar.fechaInicio.ToString("yyyy-MM-dd"); ;
			dtpFechaFin.Value = _cuponPorModificar.fechaFin.ToString("yyyy-MM-dd");
			txtDescripcion.Value = _cuponPorModificar.descripcion;
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarCupones.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
			int resultado;
			string codigo = txtCodigo.Text;
			string descripcion = txtDescripcion.Value;
			double valorDescuento = Double.Parse(txtValorDescuento.Text);
			DateTime fechaInicio = DateTime.Parse(dtpFechaInicio.Value);
			DateTime fechaFin = DateTime.Parse(dtpFechaFin.Value);
			
			if (estaModificando == true)
			{
				int idCupon = Int32.Parse(txtID.Text);
				resultado = cuponBO.modificar(idCupon, codigo, descripcion, valorDescuento, fechaInicio, fechaFin, _trabajadorSeleccionado);
				if (resultado != 0)
					Response.Redirect("GestionarCupones.aspx");
			}
			else
			{
				resultado = cuponBO.insertar(codigo, descripcion, valorDescuento, fechaInicio, fechaFin, _trabajadorSeleccionado);
				if (resultado != 0)
					Response.Redirect("GestionarCupones.aspx");
			}
		}

		protected void lbBuscarTrabajador_Click(object sender, EventArgs e)
		{
			string script = "window.onload = function() { showModalSeleccionarTrabajador() };";
			ClientScript.RegisterStartupScript(GetType(), "", script, true);
		}

		protected void modalSeleccionarTrabajador_lbBuscarTrabajador_Click(object sender, EventArgs e)
		{
			string cadena = modalSeleccionarTrabajador_txtDniNombre.Text;
			listaTrabajadores = trabajadorBO.listarPorDniNombre(cadena);
			modalSeleccionarTrabajador_gvTrabajadores.DataSource = listaTrabajadores;
			modalSeleccionarTrabajador_gvTrabajadores.DataBind();
		}

		protected void modalSeleccionarTrabajador_gvTrabajadores_RowDataBound(object sender, GridViewRowEventArgs e)
		{
			if (e.Row.RowType == DataControlRowType.DataRow)
			{
				e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idUsuario").ToString();
				e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "dni").ToString();
				e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "nombres").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "apellidos").ToString();
				e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "puesto").ToString();
			}
		}

		protected void modalSeleccionarTrabajador_lbSeleccionarTrabajador_Click(object sender, EventArgs e)
		{
			int idTrabajador = Int32.Parse(((LinkButton)sender).CommandArgument);
			_trabajadorSeleccionado = trabajadorBO.obtenerPorId(idTrabajador);
			txtNombreTrabajador.Text = _trabajadorSeleccionado.nombres + " " + _trabajadorSeleccionado.apellidos;
			ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
		}

		protected void modalSeleccionarTrabajador_gvTrabajadores_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			modalSeleccionarTrabajador_gvTrabajadores.PageIndex = e.NewPageIndex;
			modalSeleccionarTrabajador_gvTrabajadores.DataBind();
		}
	}
}
