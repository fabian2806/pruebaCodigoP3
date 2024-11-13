using RHStoreBaseBO.ServiciosWeb;
using RHStoreUsuariosBO;
using RHStoreComprasBO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using RHStorePrendasBO;

namespace RHStoreWS.Admin
{
    public partial class CrudOrdenes : System.Web.UI.Page
    {
        private ordenCompra _orden;
        private OrdenCompraBO ordenBO;
        private ClienteBO clienteBO;
        private bool estaModificando;

        public CrudOrdenes()
        {
            ordenBO = new OrdenCompraBO();
            clienteBO = new ClienteBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarClientes();
            }

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

            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                lblTitulo.Text = "Modificación de Orden de Venta";
                _orden = (ordenCompra)Session["orden"];
                cargarDatosDeLaBD();
                estaModificando = true;
            }
            else
            {
                lblTitulo.Text = "Registro de Orden de Venta";
                estaModificando = false;
            }
        }

        private void cargarClientes()
        {
            gvClientes.DataSource = clienteBO.listarTodos(); // Usa el método listarTodos() de ClienteBO
            gvClientes.DataBind();
        }

        protected void gvClientes_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "SeleccionarCliente")
            {
                // Obtén el índice de la fila seleccionada
                int index = Convert.ToInt32(e.CommandArgument);
                GridViewRow selectedRow = gvClientes.Rows[index];

                // Obtén el ID del cliente seleccionado
                string clienteId = selectedRow.Cells[0].Text; // ID del cliente
                txtIdCliente.Text = clienteId; // Mostrar el ID del cliente en txtIdCliente

                // Cierra el modal usando JavaScript (llamado desde el código del servidor)
                ScriptManager.RegisterStartupScript(this, GetType(), "cerrarModal", "$('#modalSeleccionCliente').modal('hide');", true);
            }
        }

        protected void cargarDatosDeLaBD()
        {
            txtIdOrden.Text = _orden.idOrden.ToString();
            txtIdOrden.Enabled = false;

            //Cliente
            txtIdCliente.Text = _orden.cliente.idUsuario.ToString();

            dtpFechaRegistro.Value = _orden.fechaRegistro != DateTime.MinValue ? _orden.fechaRegistro.ToString("yyyy-MM-dd") : "";
            dtpFechaProcesado.Value = _orden.fechaProcesado != DateTime.MinValue ? _orden.fechaProcesado.ToString("yyyy-MM-dd") : "";
            dtpFechaEntregado.Value = _orden.fechaEntregado != DateTime.MinValue ? _orden.fechaEntregado.ToString("yyyy-MM-dd") : "";
            dtpFechaAnulado.Value = _orden.fechaAnulado != DateTime.MinValue ? _orden.fechaAnulado.ToString("yyyy-MM-dd") : "";

            if (_orden.estado.ToString().Equals("Registrado"))
                rbRegistrado.Checked = true;
            else if (_orden.estado.ToString().Equals("Procesado"))
                rbProcesado.Checked = true;
            else if (_orden.estado.ToString().Equals("Entregado"))
                rbEntregado.Checked = true;
            else
                rbAnulado.Checked = true;

            txtDniNew.Text = _orden.dni.ToString();
            txtCorreoNew.Text = _orden.correo;
            txtSubtotalNew.Text = _orden.subtotal.ToString();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarOrdenes.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            int resultado;
            int idCliente = int.Parse(txtIdCliente.Text);
            cliente _cliente = clienteBO.obtenerPorId(idCliente);

            // Manejo de fechas con validación previa
            DateTime fechaRegistro = DateTime.MinValue;
            DateTime fechaProcesado = DateTime.MinValue;
            DateTime fechaEntregado = DateTime.MinValue;
            DateTime fechaAnulado = DateTime.MinValue;

            if (!string.IsNullOrEmpty(dtpFechaRegistro.Value))
                fechaRegistro = DateTime.Parse(dtpFechaRegistro.Value);

            if (!string.IsNullOrEmpty(dtpFechaProcesado.Value))
                fechaProcesado = DateTime.Parse(dtpFechaProcesado.Value);

            if (!string.IsNullOrEmpty(dtpFechaEntregado.Value))
                fechaEntregado = DateTime.Parse(dtpFechaEntregado.Value);

            if (!string.IsNullOrEmpty(dtpFechaAnulado.Value))
                fechaAnulado = DateTime.Parse(dtpFechaAnulado.Value);

            estado _estado;
            if (rbRegistrado.Checked)
                _estado = estado.Registrado;
            else if (rbProcesado.Checked)
                _estado = estado.Procesado;
            else if (rbEntregado.Checked)
                _estado = estado.Entregado;
            else
                _estado = estado.Anulado;

            string dni = txtDniNew.Text;
            string correo = txtCorreoNew.Text;
            double subtotal = double.Parse(txtSubtotalNew.Text);

            if (estaModificando)
            {
                int idOrden = int.Parse(txtIdOrden.Text);
                resultado = ordenBO.modificar(idOrden, fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, _estado, dni, correo, subtotal, _cliente);
                if (resultado != 0)
                    Response.Redirect("GestionarOrdenes.aspx");
            }
            else
            {
                resultado = ordenBO.insertar(fechaRegistro, fechaProcesado, fechaEntregado, fechaAnulado, _estado, dni, correo, subtotal, _cliente);
                if (resultado != 0)
                    Response.Redirect("GestionarOrdenes.aspx");               
            }
        }
    }
}