using RHStoreBaseBO.ServiciosWeb;
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
    public partial class GestionarTrabajadores : System.Web.UI.Page
    {
        private TrabajadorBO trabajadorBO;
        private BindingList<trabajador> listaTrabajadores;

        public GestionarTrabajadores()
        {
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

            listaTrabajadores = trabajadorBO.listarTodos();
            gvTrabajadores.DataSource = listaTrabajadores;
            gvTrabajadores.DataBind();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            string cadena = txtDniNombre.Text;
            listaTrabajadores = trabajadorBO.listarPorDniNombre(cadena);
            gvTrabajadores.DataSource = listaTrabajadores;
            gvTrabajadores.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CrudTrabajadores.aspx");
        }

        protected void gvTrabajadores_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idUsuario").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "dni").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "nombres").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "apellidos").ToString();
                e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "correo").ToString();
                e.Row.Cells[4].Text = DataBinder.Eval(e.Row.DataItem, "puesto").ToString();
                e.Row.Cells[5].Text = ((double)DataBinder.Eval(e.Row.DataItem, "sueldo")).ToString("N2");
                e.Row.Cells[6].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaIngreso").ToString()).ToString("dd-MM-yyyy");
                e.Row.Cells[7].Text = DataBinder.Eval(e.Row.DataItem, "horarioInicio").ToString();
                e.Row.Cells[8].Text = DataBinder.Eval(e.Row.DataItem, "horarioFin").ToString();
			}
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idTrabajador = Int32.Parse(((LinkButton)sender).CommandArgument);
            trabajador _trabajadorPorModificar = trabajadorBO.obtenerPorId(idTrabajador);
            Session["trabajadorPorModificar"] = _trabajadorPorModificar;
            Response.Redirect("CrudTrabajadores.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idTrabajador = Int32.Parse(((LinkButton)sender).CommandArgument);
            trabajadorBO.eliminar(idTrabajador);
            Response.Redirect("GestionarTrabajadores.aspx");
        }

        protected void gvTrabajadores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvTrabajadores.PageIndex = e.NewPageIndex;
            gvTrabajadores.DataBind();
        }
    }
}
