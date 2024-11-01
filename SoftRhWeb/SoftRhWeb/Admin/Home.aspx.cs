using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftRhWeb
{
    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                SetWelcomeMessage();
                LoadStatistics();
                LoadRecentActivity();
            }
        }
        /* private void SetWelcomeMessage()
         {
             // Simulación de obtener el rol y nombre del usuario.
             string userRole = "Administrador"; // Esto debería obtenerse de la sesión o autenticación.
             string userName = "Juan Perez"; // Este nombre debería obtenerse de la sesión o autenticación.

             lblWelcome.Text = $"Bienvenido, {userName}. Rol: {userRole}";
         }*/
        private void SetWelcomeMessage()
        {
            // Ejemplo de obtención del rol y nombre desde la sesión (ajústalo a tu sistema de autenticación).
            string userRole = Session["UserRole"] as string ?? "Administrador"; // Ejemplo: Cliente como valor predeterminado.
            string userName = Session["UserName"] as string ?? "Invitado";

            lblWelcome.Text = $"Bienvenido, {userName}. Rol: {userRole}";

            // Configura la visibilidad de opciones según el rol
            ConfigureNavigationForRole(userRole);
        }

        private void ConfigureNavigationForRole(string userRole)
        {
            // Mostrar solo opciones relevantes según el rol
            if (userRole == "Cliente")
            {
                lnkGestionPrendas.Visible = false;
                lnkGestionPromociones.Visible = false;
                lnkGestionUsuarios.Visible = false;
            }
            else if (userRole == "Trabajador")
            {
                lnkGestionUsuarios.Visible = false;
            }
            // No se ocultan elementos para el rol de "Administrador"
        }

        private void LoadStatistics()
        {
            // Simulación de estadísticas; en un escenario real, estos valores vendrían de la base de datos.
            lblPrendas.Text = "Total Prendas: 120";
            lblPromociones.Text = "Promociones Activas: 5";
            lblCupones.Text = "Cupones Activos: 8";
        }

        private void LoadRecentActivity()
        {
            // Simulación de actividad reciente; en un escenario real, estos datos vendrían de la base de datos.
            var activities = new[]
            {
                new { Description = "Prenda 'Polo Azul' registrada.", Date = DateTime.Now.AddDays(-1).ToShortDateString() },
                new { Description = "Promoción 'Descuento 10%' creada.", Date = DateTime.Now.AddDays(-2).ToShortDateString() },
                new { Description = "Cupon 'VERANO2024' agregado.", Date = DateTime.Now.AddDays(-3).ToShortDateString() }
            };

            rptActivity.DataSource = activities;
            rptActivity.DataBind();
        }
    }
}