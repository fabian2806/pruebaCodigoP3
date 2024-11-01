using SoftRhBaseBO.Servicios;
using SoftRhPrendasBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftRhWeb.Usuario
{
    public partial class Home : System.Web.UI.Page
    {
        PrendaBO prendaBO;

        public Home() { 
            prendaBO = new PrendaBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                BindingList<String> tiposPrenda = prendaBO.listarTipoPrenda();

                ddlTiposPrenda.DataSource = tiposPrenda;
                ddlTiposPrenda.DataBind();
            }
        }
        protected void ddlTiposPrenda_SelectedIndexChanged(object sender, EventArgs e)
        {
            string tipoSeleccionado = ddlTiposPrenda.SelectedValue;
            BindingList<prenda> prendas = prendaBO.listarPrendasPorTipo(tipoSeleccionado);

            gvPrendas.DataSource = prendas;
            gvPrendas.DataBind();
        }

    }
}