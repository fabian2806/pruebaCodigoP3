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
	public partial class CrudClientes : System.Web.UI.Page
	{
		private UsuarioBO usuarioBO;
		private ClienteBO clienteBO;
		private cliente _clientePorModificar;
		private bool estaModificando;

		public CrudClientes()
		{
			usuarioBO = new UsuarioBO();
			clienteBO = new ClienteBO();
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
				lblTitulo.Text = "Modificación de Cliente";
				_clientePorModificar = (cliente)Session["clientePorModificar"];
				lbRegresar.Visible = true;
				estaModificando = true;
				cargarDatosDeLaBD();
			}
			else
			{
				lblTitulo.Text = "Registro de Cliente";
				lbResetear.Visible = false;
				estaModificando = false;
			}
		}

		protected void cargarDatosDeLaBD()
		{
			txtID.Text = _clientePorModificar.idUsuario.ToString();
			txtDNI.Text = _clientePorModificar.dni;
			txtNombres.Text = _clientePorModificar.nombres;
			txtApellidos.Text = _clientePorModificar.apellidos;
			txtCorreo.Text = _clientePorModificar.correo;
			txtContrasenha.Enabled = false;
			txtTelefono.Text = _clientePorModificar.telefono;
			dtpFechaRegistro.Value = _clientePorModificar.fechaRegistro.ToString("yyyy-MM-dd");
			dtpFechaRegistro.Disabled = true;
			if (_clientePorModificar.recibePromociones == true)
				rbSi.Checked = true;
			else
				rbNo.Checked = true;
		}

		protected void lbResetear_Click(object sender, EventArgs e)
		{
			int resultado = usuarioBO.resetearContrasenha(_clientePorModificar.idUsuario);
			Response.Redirect("GestionarClientes.aspx");
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
		{
			Response.Redirect("GestionarClientes.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			int resultado;
			string dni = txtDNI.Text;
			string nombres = txtNombres.Text;
			string apellidos = txtApellidos.Text;
			string correo = txtCorreo.Text;
			string telefono = txtTelefono.Text;

			DateTime fechaRegistro = DateTime.Parse(dtpFechaRegistro.Value);

			bool recibePromociones;
			if (rbSi.Checked == true)
				recibePromociones = true;
			else
				recibePromociones = false;

			if (estaModificando == true)
			{
				int idUsuario = Int32.Parse(txtID.Text);
				resultado = clienteBO.modificar(idUsuario, dni, nombres, apellidos, correo, null, telefono, fechaRegistro, recibePromociones);
				if (resultado != 0)
					Response.Redirect("GestionarClientes.aspx");
			}
			else
			{
				string contrasenha = txtContrasenha.Text;
				resultado = clienteBO.insertar(dni, nombres, apellidos, correo, contrasenha, telefono, fechaRegistro, recibePromociones);
				if (resultado != 0)
					Response.Redirect("GestionarClientes.aspx");
			}
		}
	}
}
