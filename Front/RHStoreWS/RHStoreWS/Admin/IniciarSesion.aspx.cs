using RHStoreBaseBO.ServiciosWeb;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class IniciarSesion : System.Web.UI.Page
	{
		private UsuarioBO usuarioBO;
		private AdministradorBO administradorBO;
		private TrabajadorBO trabajadorBO;
		private ClienteBO clienteBO;

		public IniciarSesion()
		{
			usuarioBO = new UsuarioBO();
			administradorBO = new AdministradorBO();
			trabajadorBO = new TrabajadorBO();
			clienteBO = new ClienteBO();
		}

		protected void Page_Load(object sender, EventArgs e)
		{

		}

		protected void btnIniciarSesion_Click(object sender, EventArgs e)
		{
			int idUsuario = usuarioBO.verificarIngresoUsuario(txtCorreo.Text, txtContrasenha.Text);
			if (idUsuario != 0)
			{
				string rol = usuarioBO.obtenerRolUsuario(txtCorreo.Text, txtContrasenha.Text);
				if (rol == "administrador")
				{
					administrador _administrador = administradorBO.obtenerPorId(idUsuario);
					Session["administradorLogueado"] = _administrador;
				}
				else if (rol == "trabajador")
				{
					trabajador _trabajador = trabajadorBO.obtenerPorId(idUsuario);
					Session["trabajadorLogueado"] = _trabajador;
				}
				else
				{
					cliente _cliente = clienteBO.obtenerPorId(idUsuario);
					Session["clienteLogueado"] = _cliente;
				}

				FormsAuthenticationTicket tkt;
				string cookiestr;
				HttpCookie ck;
				tkt = new FormsAuthenticationTicket(1, txtCorreo.Text, DateTime.Now,
				DateTime.Now.AddMinutes(30), true, "datos adicionales del usuario");
				cookiestr = FormsAuthentication.Encrypt(tkt);
				ck = new HttpCookie(FormsAuthentication.FormsCookieName, cookiestr);
				ck.Expires = tkt.Expiration; //esto genera que la cookie se quede guardada
				ck.Path = FormsAuthentication.FormsCookiePath;
				Response.Cookies.Add(ck);

				string strRedirect;
				strRedirect = Request["ReturnUrl"];
				if (strRedirect == null)
				{
					if (rol == "administrador" || rol == "trabajador")
						strRedirect = "Home.aspx";  // Flujo hacia el panel de administracion
					else
						strRedirect = "../Cliente/ClienteHome.aspx"; // Flujo hacia el ecommerce
				}

				Response.Redirect(strRedirect, true);
			}
			else
			{
				lblError.Visible = true;
			}
		}
	}
}
