using System;
using System.Net.Mail;
using System.Web.UI;

namespace RHStoreWS.Admin
{
    public partial class RecuperarContrasenha : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRecuperarContrasenha_Click(object sender, EventArgs e)
        {
            string userEmail = txtCorreo.Text.Trim();

            if (IsValidEmail(userEmail))
            {
                // Generar un token único (puedes usar un GUID o una lógica propia)
                string token = Guid.NewGuid().ToString();

                // Guardar el token en la base de datos asociado al usuario para futuras validaciones (por seguridad)
                GuardarTokenRecuperacion(userEmail, token);

                // Enviar el correo de recuperación
                EnviarCorreoRecuperacion(userEmail, token);

                // Mensaje de confirmación
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Se ha enviado un enlace de recuperación a su correo electrónico.');", true);
            }
            else
            {
                // Mostrar un mensaje de error si el correo es inválido
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Ingrese un correo electrónico válido.');", true);
            }
        }

        private bool IsValidEmail(string email)
        {
            try
            {
                var addr = new System.Net.Mail.MailAddress(email);
                return addr.Address == email;
            }
            catch
            {
                return false;
            }
        }

        private void GuardarTokenRecuperacion(string email, string token)
        {
            // Aquí debes implementar la lógica para guardar el token en la base de datos asociado al usuario.
            // Por ejemplo, puedes tener una tabla "RecuperacionContraseña" con los campos: Email, Token, FechaExpiracion
            // Este token debería tener una fecha de expiración.
        }

        private void EnviarCorreoRecuperacion(string email, string token)
        {
            string linkRecuperacion = $"{Request.Url.GetLeftPart(UriPartial.Authority)}/Admin/ModificarContrasenha.aspx?token={token}";
            string cuerpoCorreo = $"<p>Para restablecer su contraseña, haga clic en el siguiente enlace:</p><p><a href='{linkRecuperacion}'>Restablecer contraseña</a></p>";

            MailMessage mail = new MailMessage();
            mail.To.Add(email);
            mail.From = new MailAddress("tu_correo@dominio.com"); // Cambia esto por tu dirección de correo
            mail.Subject = "Recuperación de contraseña";
            mail.Body = cuerpoCorreo;
            mail.IsBodyHtml = true;

            SmtpClient smtp = new SmtpClient();
            smtp.Host = "smtp.tuServidorSMTP.com"; // Cambia esto por tu servidor SMTP
            smtp.Port = 587; // Cambia esto al puerto correspondiente
            smtp.Credentials = new System.Net.NetworkCredential("tu_correo@dominio.com", "tu_contraseña"); // Cambia estas credenciales
            smtp.EnableSsl = true;

            try
            {
                smtp.Send(mail);
            }
            catch (Exception ex)
            {
                // Manejo de error en caso de que el envío falle
                ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error al enviar el correo: {ex.Message}');", true);
            }
        }
    }
}
