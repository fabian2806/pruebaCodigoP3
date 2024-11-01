using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftRhWeb
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Código de carga inicial si es necesario
            }
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            string username = txtUsername.Text; // Obteniendo el usuario desde un campo de texto
            string password = txtPassword.Text; // Obteniendo la contraseña desde un campo de texto

            // Lógica de autenticación (ejemplo simple)
            if (ValidateUser(username, password, out string role, out string fullName))
            {
                // Asigna valores a la sesión basados en la autenticación
                Session["UserRole"] = role;
                Session["UserName"] = fullName;

                // Redirige al usuario a la página principal (Home.aspx)
                Response.Redirect("Home.aspx");
            }
            else
            {
                lblError.Text = "Usuario o contraseña incorrectos";
            }
        }

        private bool ValidateUser(string username, string password, out string role, out string fullName)
        {
            // Ejemplo de validación estática de usuarios
            // En producción, reemplaza esto con una validación en la base de datos
            if (username == "admin" && password == "admin123")
            {
                role = "Administrador";
                fullName = "Juan Perez";
                return true;
            }
            else if (username == "cliente" && password == "cliente123")
            {
                role = "Cliente";
                fullName = "Ana López";
                return true;
            }
            else if (username == "trabajador" && password == "trabajador123")
            {
                role = "Trabajador";
                fullName = "Carlos Ramirez";
                return true;
            }
            else
            {
                role = string.Empty;
                fullName = string.Empty;
                return false;
            }
        }
        
    }
}