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
	public partial class CrudTrabajadores : System.Web.UI.Page
	{
		private UsuarioBO usuarioBO;
		private TrabajadorBO trabajadorBO;
		private trabajador _trabajadorPorModificar;
		private bool estaModificando;

		public CrudTrabajadores()
		{
			usuarioBO = new UsuarioBO();
			trabajadorBO = new TrabajadorBO();
		}

		protected void Page_Init(object sender, EventArgs e)
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

			string accion = Request.QueryString["accion"];
			if (accion != null && accion == "modificar")
			{
				lblTitulo.Text = "Modificación de Trabajador";
				_trabajadorPorModificar = (trabajador)Session["trabajadorPorModificar"];
				lbResetear.Visible = true;
				estaModificando = true;
				cargarDatosDeLaBD();
			}
			else
			{
				lblTitulo.Text = "Registro de Trabajador";
				lbResetear.Visible = false;
				estaModificando = false;
			}
		}

		protected void cargarDatosDeLaBD()
		{
			txtID.Text = _trabajadorPorModificar.idUsuario.ToString();
			txtDNI.Text = _trabajadorPorModificar.dni;
			txtNombres.Text = _trabajadorPorModificar.nombres;
			txtApellidos.Text = _trabajadorPorModificar.apellidos;
			txtCorreo.Text = _trabajadorPorModificar.correo;
			txtContrasenha.Enabled = false;
			txtPuesto.Text = _trabajadorPorModificar.puesto;
			txtSueldo.Text = ((double)_trabajadorPorModificar.sueldo).ToString("N2");
			dtpFechaIngreso.Value = _trabajadorPorModificar.fechaIngreso.ToString("yyyy-MM-dd");
			dtpFechaIngreso.Disabled = true;
			tpHorarioInicio.Value = _trabajadorPorModificar.horarioInicio;
			tpHorarioFin.Value = _trabajadorPorModificar.horarioFin;
		}

		protected void lbResetear_Click(object sender, EventArgs e)
		{
			int resultado = usuarioBO.resetearContrasenha(_trabajadorPorModificar.idUsuario);
			Response.Redirect("GestionarTrabajadores.aspx");
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
		{
			Response.Redirect("GestionarTrabajadores.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			int resultado;
			string dni = txtDNI.Text;
			string nombres = txtNombres.Text;
			string apellidos = txtApellidos.Text;
			string correo = txtCorreo.Text;
			string puesto = txtPuesto.Text;
			double sueldo = Double.Parse(txtSueldo.Text);

			DateTime fechaIngreso = DateTime.Parse(dtpFechaIngreso.Value);

			string horarioInicio = tpHorarioInicio.Value.ToString();
			string horarioFin = tpHorarioFin.Value.ToString();

			if (estaModificando == true)
			{
				int idUsuario = Int32.Parse(txtID.Text);
				resultado = trabajadorBO.modificar(idUsuario, dni, nombres, apellidos, correo, null, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
				if (resultado != 0)
					Response.Redirect("GestionarTrabajadores.aspx");
			}
			else
			{
				string contrasenha = txtContrasenha.Text;
				resultado = trabajadorBO.insertar(dni, nombres, apellidos, correo, contrasenha, puesto, sueldo, fechaIngreso, horarioInicio, horarioFin);
				if (resultado != 0)
					Response.Redirect("GestionarTrabajadores.aspx");
			}
		}
	}
}
