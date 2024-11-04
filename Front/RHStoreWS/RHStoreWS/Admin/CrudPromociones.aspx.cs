using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class CrudPromociones : System.Web.UI.Page
	{
		private PromocionBO promocionBO;
		private TrabajadorBO trabajadorBO;
		private BindingList<trabajador> listaTrabajadores;
		private BindingList<prenda> prendasAgregadas;

		public CrudPromociones()
		{
			promocionBO = new PromocionBO();
			trabajadorBO = new TrabajadorBO();
			listaTrabajadores = trabajadorBO.listarTodos();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if (prendasAgregadas == null)
				prendasAgregadas = new BindingList<prenda>();
			else
				prendasAgregadas = (BindingList<prenda>)Session["prendasAgregadas"];

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
				ModalTrabajador_gvTrabajadores.DataSource = listaTrabajadores;
				ModalTrabajador_gvTrabajadores.DataBind();
			}
		}

		protected void cargarDatosDeLaBD(promocion _promocion)
		{
			txtIdPromocion.Text = _promocion.idPromocion.ToString();
			
			// Trabajador

			// Prenda


			txtNombrePromocion.Text = _promocion.nombre;

			if (_promocion.tipo == tipoPromocion.Porcentaje)
				rbPorcentaje.Checked = true;
			else if (_promocion.tipo == tipoPromocion.MontoFijo)
				rbMontoFijo.Checked = true;

			//txtValorDescuento.Text = _promocion.valorDescuento.ToString();
			dtpFechaInicio.Value = _promocion.fechaInicio.ToString();
            dtpFechaFin.Value = _promocion.fechaFin.ToString();
			txtDescripcion.Value = _promocion.descripcion;
        }

		protected void lbBuscarTrabajador_Click(object sender, EventArgs e)
		{
			string script = "window.onload = function() { showModalFormTrabajador() };";
			ClientScript.RegisterStartupScript(GetType(), "", script, true);
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
		{
			Response.Redirect("GestionarPromociones.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			string nombre = txtNombrePromocion.Text;
			string descripcion = txtDescripcion.Value;
			double valorDescuento = Double.Parse(txtValorDescuento.Text);

			tipoPromocion tipo;
			if (rbPorcentaje.Checked == true)
				tipo = tipoPromocion.Porcentaje;
			else
				tipo = tipoPromocion.MontoFijo;

			DateTime fechaInicio = DateTime.Parse(dtpFechaInicio.Value);
			DateTime fechaFin = DateTime.Parse(dtpFechaFin.Value);

			int idTrabajador = (int)Session["idTrabajador"];
			trabajador _trabajador = trabajadorBO.obtenerPorId(idTrabajador);

			prenda _prenda = new prenda();
			_prenda.idPrenda = 12;

			int resultado = promocionBO.insertar(nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, _trabajador, _prenda);

			if(resultado != 0)
			{
				Response.Redirect("GestionarPromociones.aspx");
			}
		}

        protected void ModalTrabajador_lbBuscarTrabajador_Click(object sender, EventArgs e)
        {
			string nombre = ModalTrabajador_txtNombreDniTrabajador.Text;
			//listaTrabajadores = trabajadorBO.listarPorNombreDni(nombre);
			ModalTrabajador_gvTrabajadores.DataSource = listaTrabajadores;
			ModalTrabajador_gvTrabajadores.DataBind();
		}

		protected void ModalTrabajador_gvTrabajadores_PageIndexChanging(object sender, GridViewPageEventArgs e)
		{
			ModalTrabajador_gvTrabajadores.PageIndex = e.NewPageIndex;
			ModalTrabajador_gvTrabajadores.DataBind();
		}

		protected void ModalTrabajador_lbSeleccionar_Click(object sender, EventArgs e)
		{
			int idTrabajador = Int32.Parse(((LinkButton)sender).CommandArgument);
			Session["idTrabajador"] = idTrabajador;
			trabajador _trabajador = trabajadorBO.obtenerPorId(idTrabajador);
			string nombreCompleto = _trabajador.nombres + " " + _trabajador.apellidos;
			txtIdTrabajador.Text = nombreCompleto;
			ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
		}
	}
}
