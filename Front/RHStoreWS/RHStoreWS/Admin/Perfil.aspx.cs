using RHStoreBaseBO.ServiciosWeb;
using RHStoreUsuariosBO;
using System;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class Perfil : System.Web.UI.Page
	{
		private UsuarioBO usuarioBO;
		private AdministradorBO administradorBO;
		private TrabajadorBO trabajadorBO;
		private administrador _administrador;
		private trabajador _trabajador;
		string rol;

		public Perfil()
		{
			usuarioBO = new UsuarioBO();
			administradorBO = new AdministradorBO();
			trabajadorBO = new TrabajadorBO();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if(!IsPostBack)
			{
				if (Session["administradorLogueado"] != null)
				{
					_administrador = (administrador)Session["administradorLogueado"];
					lblNombreUsuario.Text = _administrador.nombres + " " + _administrador.apellidos;
					rol = "administrador";
				}
				else if (Session["trabajadorLogueado"] != null)
				{
					_trabajador = (trabajador)Session["trabajadorLogueado"];
					lblNombreUsuario.Text = _trabajador.nombres + " " + _trabajador.apellidos;
					rol = "trabajador";
				}
				cargarDatosDeLaBD();
			}
		}

		private void cargarDatosDeLaBD()
		{
			if(rol == "administrador")
			{
				txtID.Text = _administrador.idUsuario.ToString();
				txtDNI.Text = _administrador.dni;
				txtNombres.Text = _administrador.nombres;
				txtApellidos.Text = _administrador.apellidos;
				txtCorreo.Text = _administrador.correo;
				txtFechaCreacion.Text = _administrador.fechaCreacion.ToString("dd-MM-yyyy");
			} else
			{
				txtID.Text = _trabajador.idUsuario.ToString();
				txtDNI.Text = _trabajador.dni;
				txtNombres.Text = _trabajador.nombres;
				txtApellidos.Text = _trabajador.apellidos;
				txtCorreo.Text = _trabajador.correo;
				txtFechaIngreso.Text = _trabajador.fechaIngreso.ToString("dd-MM-yyyy");
				txtPuesto.Text = _trabajador.puesto;
				txtSueldo.Text = ((double)_trabajador.sueldo).ToString("N2");
				txtHorarioInicio.Text = _trabajador.horarioInicio;
				txtHorarioFin.Text = _trabajador.horarioFin;
			}
		}

		protected void lbEditar_Click(object sender, EventArgs e)
		{
			txtNombres.Enabled = true;
			txtApellidos.Enabled = true;
			lbGuardar.Visible = true;
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			int idUsuario = Int32.Parse(txtID.Text);
			string nuevoNombre = txtNombres.Text;
			string nuevoApellido = txtApellidos.Text;

			int resultado = usuarioBO.modificarUsuario(idUsuario, nuevoNombre, nuevoApellido);
			
			txtNombres.Enabled = false;
			txtApellidos.Enabled = false;
			lbGuardar.Visible = false;
		}

		protected void lbCambiarContrasenha_Click(object sender, EventArgs e)
		{
			Response.Redirect("ModificarContrasenha.aspx");
		}
	}
}
