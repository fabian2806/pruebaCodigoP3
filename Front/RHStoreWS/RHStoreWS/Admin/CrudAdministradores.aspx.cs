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
	public partial class CrudAdministradores : System.Web.UI.Page
	{
		private UsuarioBO usuarioBO;
		private AdministradorBO administradorBO;
		private administrador _administradorPorModificar;
		private bool estaModificando;

		public CrudAdministradores()
		{
			usuarioBO = new UsuarioBO();
			administradorBO = new AdministradorBO();
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
				lblTitulo.Text = "Modificación de Administrador";
				_administradorPorModificar = (administrador)Session["administradorPorModificar"];
				lbResetear.Visible = true;
				estaModificando = true;
				cargarDatosDeLaBD();
			}
			else
			{
				lblTitulo.Text = "Registro de Administrador";
				lbResetear.Visible = false;
				estaModificando = false;
			}
		}

		protected void cargarDatosDeLaBD()
		{
			txtID.Text = _administradorPorModificar.idUsuario.ToString();
			txtDNI.Text = _administradorPorModificar.dni;
			txtNombres.Text = _administradorPorModificar.nombres;
			txtApellidos.Text = _administradorPorModificar.apellidos;
			txtCorreo.Text = _administradorPorModificar.correo;
			txtContrasenha.Enabled = false;
			dtpFechaCreacion.Value = _administradorPorModificar.fechaCreacion.ToString("yyyy-MM-dd");
			dtpFechaCreacion.Disabled = true;
		}

		protected void lbResetear_Click(object sender, EventArgs e)
		{
			int resultado = usuarioBO.resetearContrasenha(_administradorPorModificar.idUsuario);
			Response.Redirect("GestionarAdministradores.aspx");
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
		{
			Response.Redirect("GestionarAdministradores.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			int resultado;
			string dni = txtDNI.Text;
			string nombres = txtNombres.Text;
			string apellidos = txtApellidos.Text;
			string correo = txtCorreo.Text;

			DateTime fechaCreacion = DateTime.Parse(dtpFechaCreacion.Value);

			if (estaModificando == true)
			{
				int idUsuario = Int32.Parse(txtID.Text);
				resultado = administradorBO.modificar(idUsuario, dni, nombres, apellidos, correo, null, fechaCreacion);
				if (resultado != 0)
					Response.Redirect("GestionarAdministradores.aspx");
			}
			else
			{
				string contrasenha = txtContrasenha.Text;
				resultado = administradorBO.insertar(dni, nombres, apellidos, correo, contrasenha, fechaCreacion);
				if (resultado != 0)
					Response.Redirect("GestionarAdministradores.aspx");
			}
		}
	}
}
