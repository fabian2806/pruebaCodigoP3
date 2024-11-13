using RHStoreUsuariosBO;
using System;
using System.Text.RegularExpressions;
using System.Web.UI;

namespace RHStoreWS.Admin
{
    public partial class Registrarse : Page
    {
        private ClienteBO clienteBO;

        public Registrarse()
        {
            clienteBO = new ClienteBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Opcional: inicialización adicional si es necesario
            }
        }

        protected void btnRegistrarse_Click(object sender, EventArgs e)
        {
            string dni = txtDNI.Text;
            string nombres = txtNombres.Text;
            string apellidos = txtApellidos.Text;
            string correo = txtCorreo.Text;
            string contrasenha = txtContrasenha.Text;
            string confirmarContrasenha = txtConfirmarContrasenha.Text;
            string telefono = txtTelefono.Text;
            DateTime fechaRegistro = DateTime.Now;
            bool recibePromociones = rbSi.Checked;

            // Validar formato de correo electrónico
            if (!Regex.IsMatch(correo, @"^[^@\s]+@[^@\s]+\.[^@\s]+$"))
            {
                lblErrorCorreo.Visible = true;
                return;
            }
            else
            {
                lblErrorCorreo.Visible = false;
            }

            // Validar que las contraseñas coincidan
            if (contrasenha != confirmarContrasenha)
            {
                lblErrorContrasenhas.Visible = true;
                return;
            }
            else
            {
                lblErrorContrasenhas.Visible = false;
            }

            // Registrar el cliente
            int resultado = clienteBO.insertar(dni, nombres, apellidos, correo, contrasenha, telefono, fechaRegistro, recibePromociones);
            if (resultado != 0)
            {
                // Registro exitoso
                Response.Redirect("~/Cliente/ClienteHome.aspx");
            }
            else
            {
                // Manejo del error
            }
        }
    }
}
