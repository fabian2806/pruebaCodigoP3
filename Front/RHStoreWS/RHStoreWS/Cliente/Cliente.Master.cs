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
            if (!IsPostBack)
            {
                string genero = GetGenderFromPage(); // Obtener género desde la página actual
                CargarPrendas(genero);
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

        public void CargarPrendas(string genero)
        {
            if (string.IsNullOrEmpty(genero))
            {
                listaDePrendas = new BindingList<prenda>(prendaBO.listarTodos());
            }
            else
            {
                bool filterHombre = genero.Equals("Hombre", StringComparison.OrdinalIgnoreCase);
                bool filterMujer = genero.Equals("Mujer", StringComparison.OrdinalIgnoreCase);
                bool filterUnisex = genero.Equals("Unisex", StringComparison.OrdinalIgnoreCase);

                // Cambiar los valores de tallas y colores a cadenas vacías si son nulos
                string tallasSeleccionadas = "";
                string coloresSeleccionados = "";

                listaDePrendas = new BindingList<prenda>(prendaBO.listarPrendasFiltradas(0, double.MaxValue, filterHombre, filterMujer, filterUnisex, tallasSeleccionadas, coloresSeleccionados));
            }

            RepeaterPrendas.DataSource = listaDePrendas;
            RepeaterPrendas.DataBind();
        }

        private string GetGenderFromPage()
        {
            // Obtener el tipo de página actual
            if (this is Hombre) return "Hombre";
            if (this is Mujer) return "Mujer";
            if (this is Unisex) return "Unisex";
            return null;
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
                CargarPrendas(null);
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

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            double minPrice = double.TryParse(minPriceTextBox.Text, out double min) ? min : 0;
            double maxPrice = double.TryParse(maxPriceTextBox.Text, out double max) ? max : double.MaxValue;

            bool filterHombre = hombreCheckBox.Checked;
            bool filterMujer = mujerCheckBox.Checked;
            bool filterUnisex = unisexCheckBox.Checked;

            // Verificar tallas seleccionadas
            string tallasSeleccionadas = string.IsNullOrEmpty(string.Join(",", GetSelectedTallas())) ? "" : string.Join(",", GetSelectedTallas());
            // Verificar colores seleccionados
            string coloresSeleccionados = string.IsNullOrEmpty(string.Join(",", GetSelectedColores())) ? "" : string.Join(",", GetSelectedColores());

            // Llamar al método para obtener prendas filtradas
            BindingList<prenda> prendasFiltradas = prendaBO.listarPrendasFiltradas(minPrice, maxPrice, filterHombre, filterMujer, filterUnisex, tallasSeleccionadas, coloresSeleccionados);

            // Asegúrate de que RepeaterPrendas no sea null
            if (RepeaterPrendas != null)
            {
                RepeaterPrendas.DataSource = prendasFiltradas;
                RepeaterPrendas.DataBind();
            }
            else
            {
                throw new Exception("El RepeaterPrendas no está inicializado en el Master.");
            }
        }


        private List<string> GetSelectedTallas()
        {
            List<string> tallas = new List<string>();
            if (tallaXS.Checked) tallas.Add("XS");
            if (tallaS.Checked) tallas.Add("S");
            if (tallaM.Checked) tallas.Add("M");
            if (tallaL.Checked) tallas.Add("L");
            if (tallaXL.Checked) tallas.Add("XL");
            if (tallaXXL.Checked) tallas.Add("XXL");
            return tallas;
        }

        private List<string> GetSelectedColores()
        {
            List<string> colores = new List<string>();
            if (colorBlanco.Checked) colores.Add("Blanco");
            if (colorAzul.Checked) colores.Add("Azul");
            if (colorCian.Checked) colores.Add("Cian");
            if (colorRojo.Checked) colores.Add("Rojo");
            if (colorAmarillo.Checked) colores.Add("Amarillo");
            if (colorNegro.Checked) colores.Add("Negro");
            if (colorMorado.Checked) colores.Add("Morado");
            if (colorRosa.Checked) colores.Add("Rosa");
            if (colorNaranja.Checked) colores.Add("Naranja");
            if (colorVerde.Checked) colores.Add("Verde");
            return colores;
        }
    }
}