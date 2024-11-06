using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Cliente
{

    public partial class Cliente : System.Web.UI.MasterPage
    {
        private PrendaBO prendaBO;
        private BindingList<prenda> listaDePrendas;
        public Cliente()
        {
            prendaBO = new PrendaBO();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            /*if (!IsPostBack)
            {
                CargarDatosUsuario();
            }*/
            if (!IsPostBack)
            {
                CargarPrendas();
            }
        }

        private void CargarDatosUsuario()
        {
            // Lógica para cargar datos del usuario
            if (Session["Usuario"] != null)
            {
                string nombreUsuario = Session["Usuario"].ToString();
                // Aquí puedes actualizar el encabezado o cualquier otro control con el nombre del usuario
            }
        }
        private void CargarPrendas()
        {
            // Cargar todas las prendas usando el procedimiento almacenado
            listaDePrendas = new BindingList<prenda>(prendaBO.listarTodos());

            // Enlazar los datos al control de visualización, como un Repeater o un GridView
            RepeaterPrendas.DataSource = listaDePrendas;
            RepeaterPrendas.DataBind();
        }
        protected string ObtenerImagen(int idPrenda)
        {
            // Obtener la imagen como bytes desde la base de datos
            byte[] imagenBytes = prendaBO.ObtenerImagen(idPrenda); // Implementa este método en PrendaBO
            if (imagenBytes != null)
            {
                // Convertir a Base64 para poder usar en src
                return "data:image/jpeg;base64," + Convert.ToBase64String(imagenBytes);
            }
            return string.Empty; // Devuelve una cadena vacía si no hay imagen
        }
        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            string nombreBuscado = txtBuscar.Text.Trim();
            if (!string.IsNullOrEmpty(nombreBuscado))
            {
                // Llamar al procedimiento almacenado para buscar prendas
                listaDePrendas = new BindingList<prenda>(prendaBO.listarPorNombre(nombreBuscado)); // Cambia por tu método
                RepeaterPrendas.DataSource = listaDePrendas;
                RepeaterPrendas.DataBind();
            }
            else
            {
                // Si no hay texto, cargar todas las prendas
                CargarPrendas();
            }
        }
        protected void RedirectToPage(string pageName)
        {
            Response.Redirect(pageName);
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            RedirectToPage("ClienteHome.aspx");
        }

        protected void btnHombre_Click(object sender, EventArgs e)
        {
            RedirectToPage("Hombre.aspx");
        }

        protected void btnMujer_Click(object sender, EventArgs e)
        {
            RedirectToPage("Mujer.aspx");
        }

        protected void btnUnisex_Click(object sender, EventArgs e)
        {
            RedirectToPage("Unisex.aspx");
        }

        protected void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            // Redirige a la página de inicio de sesión en Admin
            Response.Redirect("~/Admin/IniciarSesion.aspx");
        }

        protected void btnCarrito_Click(object sender, EventArgs e)
        {
            RedirectToPage("Carrito.aspx");
        }

    }
}