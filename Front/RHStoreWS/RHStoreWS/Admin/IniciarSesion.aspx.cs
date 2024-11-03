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

        protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            usuarioBO = new UsuarioBO();
            int resultado = usuarioBO.verificarIngresoUsuario(txtCorreo.Text, txtContrasenha.Text);
            if (resultado != 0)
            {
                string rol = usuarioBO.obtenerRolUsuario(txtCorreo.Text, txtContrasenha.Text);
                if (rol == "administrador")
                {
                    administradorBO = new AdministradorBO();
                    administrador _administrador = administradorBO.obtenerPorId(resultado);
                    Session["administrador"] = _administrador;
                }
                else if (rol == "trabajador")
                {
                    trabajadorBO = new TrabajadorBO();
                    trabajador _trabajador = trabajadorBO.obtenerPorId(resultado);
                    Session["trabajador"] = _trabajador;
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
                    strRedirect = "Home.aspx?rol=" + rol;
                Response.Redirect(strRedirect, true);
            }
            else
            {
                lblError.Visible = true; // Muestra el mensaje de error
            }
        }

    }
}