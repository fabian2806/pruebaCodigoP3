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
    public partial class GestionarPromociones : System.Web.UI.Page
    {
        private PromocionBO promocionBO;
        private TrabajadorBO trabajadorBO;
        private BindingList<promocion> listaPromociones;

        public GestionarPromociones()
        {
            promocionBO = new PromocionBO();
            trabajadorBO = new TrabajadorBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["administradorLogueado"] != null)
            {
                administrador _administrador = (administrador)Session["administradorLogueado"];
                lblNombreUsuario.Text = _administrador.nombres + " " + _administrador.apellidos;
            }
            else if (Session["trabajadorLogueado"] != null)
            {
                trabajador _trabajador = (trabajador)Session["trabajadorLogueado"];
                lblNombreUsuario.Text = _trabajador.nombres + " " + _trabajador.apellidos;
            }

            listaPromociones = promocionBO.listarTodos();
            gvPromociones.DataSource = listaPromociones;
            gvPromociones.DataBind();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            string cadena = txtNombreDescripcion.Text;
            listaPromociones = promocionBO.listarPorNombreDescripcion(cadena);
            gvPromociones.DataSource = listaPromociones;
            gvPromociones.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CrudPromociones.aspx");
        }

        protected void gvPromociones_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "descripcion").ToString();
                e.Row.Cells[2].Text = ((trabajador)DataBinder.Eval(e.Row.DataItem, "trabajador")).nombres + " " + ((trabajador)DataBinder.Eval(e.Row.DataItem, "trabajador")).apellidos;
                e.Row.Cells[3].Text = ((double)DataBinder.Eval(e.Row.DataItem, "valorDescuento")).ToString("N2");
                e.Row.Cells[4].Text = (tipoPromocion)DataBinder.Eval(e.Row.DataItem, "tipo") == tipoPromocion.Porcentaje ? "Porcentaje" : "Monto Fijo";
                e.Row.Cells[5].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaInicio").ToString()).ToString("dd-MM-yyyy");
                e.Row.Cells[6].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaFin").ToString()).ToString("dd-MM-yyyy");
            }
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idPromocion = Int32.Parse(((LinkButton)sender).CommandArgument);
            promocion _promocion = promocionBO.obtenerPorId(idPromocion);
            Session["promocion"] = _promocion;
            Response.Redirect("CrudPromociones.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idPromocion = Int32.Parse(((LinkButton)sender).CommandArgument);
            this.promocionBO.eliminar(idPromocion);
            Response.Redirect("GestionarPromociones.aspx");
        }

        protected void gvPromociones_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvPromociones.PageIndex = e.NewPageIndex;
            gvPromociones.DataBind();
        }
    }
}
