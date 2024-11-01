using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
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
        UsuarioBO usuarioBO;

        protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void btnIniciarSesion_Click(object sender, EventArgs e)
        {
			usuarioBO = new UsuarioBO();
            int resultado = usuarioBO.verificarIngresoUsuario(txtCorreo.Text, txtContrasenha.Text);
            if(resultado != 0)
            {
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
                    strRedirect = "Home.aspx";
                Response.Redirect(strRedirect, true);
            } else
            {
                Response.Redirect("IniciarSesion.aspx");
            }
        }
    }
}