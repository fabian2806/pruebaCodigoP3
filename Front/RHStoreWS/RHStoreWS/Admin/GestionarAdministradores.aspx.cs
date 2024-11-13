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
    public partial class GestionarAdministradores : System.Web.UI.Page
    {
        private AdministradorBO administradorBO;
        private BindingList<administrador> listaAdministradores;

        public GestionarAdministradores()
        {
            administradorBO = new AdministradorBO();
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

			listaAdministradores = administradorBO.listarTodos();
            gvAdministradores.DataSource = listaAdministradores;
            gvAdministradores.DataBind();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            string cadena = txtDniNombre.Text;
			listaAdministradores = administradorBO.listarPorDniNombre(cadena);
            gvAdministradores.DataSource = listaAdministradores;
            gvAdministradores.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CrudAdministradores.aspx");
        }

        protected void gvAdministradores_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idUsuario").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "dni").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "nombres").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "apellidos").ToString();
                e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "correo").ToString();
                e.Row.Cells[4].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaCreacion").ToString()).ToString("dd-MM-yyyy");
            }
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idAdministrador = Int32.Parse(((LinkButton)sender).CommandArgument);
            administrador _administradorPorModificar = administradorBO.obtenerPorId(idAdministrador);
            Session["administradorPorModificar"] = _administradorPorModificar;
            Response.Redirect("CrudAdministradores.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idAdministrador = Int32.Parse(((LinkButton)sender).CommandArgument);
            administradorBO.eliminar(idAdministrador);
            Response.Redirect("GestionarAdministradores.aspx");
        }

        protected void gvAdministradores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
			gvAdministradores.PageIndex = e.NewPageIndex;
			gvAdministradores.DataBind();
        }
    }
}