using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using RHStoreUsuariosBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class GestionarCupones : System.Web.UI.Page
	{
        private CuponBO cuponBO;
        private BindingList<cupon> listaDeCupones;

        public GestionarCupones()
        {
            cuponBO = new CuponBO();
            listaDeCupones = cuponBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
		{
            if (!IsPostBack)
            {
                dgvCupon.DataSource = listaDeCupones;
                dgvCupon.DataBind();
            }
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            //string nombre = txtCodigoBuscado.Text;
            //listaDeCupones = cuponBO.listarPorNombre(nombre);
            //dgvCupon.DataSource = listaDeCupones;
            //dgvCupon.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CrudCupones.aspx");
        }

        protected void dgvCupon_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvCupon.PageIndex = e.NewPageIndex;
            dgvCupon.DataSource = listaDeCupones;
            dgvCupon.DataBind();
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idCupon = Int32.Parse(((LinkButton)sender).CommandArgument);
            cupon _cupon = cuponBO.obtenerPorId(idCupon);
            Session["cupon"] = _cupon;
            Response.Redirect("CrudCupones.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idCupon = Int32.Parse(((LinkButton)sender).CommandArgument);
            this.cuponBO.eliminar(idCupon);
            Response.Redirect("GestionarCupones.aspx");
        }
    }
}