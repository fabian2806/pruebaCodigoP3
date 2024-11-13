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
    public partial class GestionarClientes : System.Web.UI.Page
    {
        private ClienteBO clienteBO;
        private BindingList<cliente> listaClientes;

        public GestionarClientes()
        {
            clienteBO = new ClienteBO();
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

            listaClientes = clienteBO.listarTodos();
            gvClientes.DataSource = listaClientes;
            gvClientes.DataBind();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            string cadena = txtDniNombre.Text;
            listaClientes = clienteBO.listarPorDniNombre(cadena);
            gvClientes.DataSource = listaClientes;
            gvClientes.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CrudClientes.aspx");
        }

        protected void gvClientes_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idUsuario").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "dni").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "nombres").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "apellidos").ToString();
                e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "correo").ToString();
                e.Row.Cells[4].Text = DataBinder.Eval(e.Row.DataItem, "telefono").ToString();
                e.Row.Cells[5].Text = DateTime.Parse(DataBinder.Eval(e.Row.DataItem, "fechaRegistro").ToString()).ToString("dd-MM-yyyy");
                e.Row.Cells[6].Text = (bool)DataBinder.Eval(e.Row.DataItem, "recibePromociones") == true ? "Sí" : "No";
            }
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idCliente = Int32.Parse(((LinkButton)sender).CommandArgument);
            cliente _clientePorModificar = clienteBO.obtenerPorId(idCliente);
            Session["clientePorModificar"] = _clientePorModificar;
            Response.Redirect("CrudClientes.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idCliente = Int32.Parse(((LinkButton)sender).CommandArgument);
            clienteBO.eliminar(idCliente);
            Response.Redirect("GestionarClientes.aspx");
        }

        protected void gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvClientes.PageIndex = e.NewPageIndex;
            gvClientes.DataBind();
        }
    }
}
