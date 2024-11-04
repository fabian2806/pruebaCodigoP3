using RHStoreBaseBO.ServiciosWeb;
using RHStorePrendasBO;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class CrudPrendas : System.Web.UI.Page
	{
		private PrendaBO prendaBO;
		private prenda _prenda;
		private bool estaModificando;

		public CrudPrendas()
		{
			prendaBO = new PrendaBO();
		}

		protected void Page_Load(object sender, EventArgs e)
		{
			if (!IsPostBack)
			{
				ddlTalla.DataSource = Enum.GetValues(typeof(talla));
				ddlTalla.DataBind();
			}

			string accion = Request.QueryString["accion"];
			if (accion != null && accion == "modificar")
			{
				lblTitulo.Text = "Modificación de Prenda";
				_prenda = (prenda)Session["prenda"];
				cargarDatosDeLaBD();
				cargarFoto(sender, e);
				estaModificando = true;
			}
			else
			{
				lblTitulo.Text = "Registro de Prenda";
				cargarFoto(sender, e);
				estaModificando = false;
			}
		}

		protected void cargarDatosDeLaBD()
		{
			txtIdPrenda.Text = _prenda.idPrenda.ToString();
			txtIdPrenda.Enabled = false;
			txtNombrePrenda.Text = _prenda.nombre;
			ddlTalla.SelectedValue = _prenda.talla.ToString();

			if(_prenda.imagen != null)
			{
				Session["foto"] = _prenda.imagen;

				string base64String = Convert.ToBase64String(_prenda.imagen);
				string imageUrl = "data:image/jpeg;base64," + base64String;
				imgImagenPrenda.ImageUrl = imageUrl;
			}
			
			
			if (_prenda.tipo.ToString().Equals("Polo"))
				rbPolo.Checked = true;
			else if (_prenda.tipo.ToString().Equals("Pantalon"))
				rbPantalon.Checked = true;
			else if (_prenda.tipo.ToString().Equals("Polera"))
				rbPolera.Checked = true;
			else if (_prenda.tipo.ToString().Equals("Camisa"))
				rbCamisa.Checked = true;
			else
				rbCasaca.Checked = true;
			
			if (_prenda.genero.ToString().Equals("Hombre"))
				rbHombre.Checked = true;
			else if (_prenda.genero.ToString().Equals("Mujer"))
				rbMujer.Checked = true;
			else
				rbUnisex.Checked = true;

			txtColor.Text = _prenda.color;
			txtPrecioOriginal.Text = _prenda.precioOriginal.ToString();
			txtPrecioDescontado.Text = _prenda.precioDescontado.ToString();
			txtStock.Text = _prenda.stock.ToString();
			txtCantVendida.Text = _prenda.cantVendida.ToString();
			txtDescripcion.Value = _prenda.descripcion;
		}

		protected void cargarFoto(object sender, EventArgs e)
		{
			if (IsPostBack && fileUploadImagenPrenda.PostedFile != null && fileUploadImagenPrenda.HasFile)
			{
				string extension = System.IO.Path.GetExtension(fileUploadImagenPrenda.FileName);
				if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
				{
					string filename = Guid.NewGuid().ToString() + extension;
					string filePath = Server.MapPath("~/Uploads/") + filename;
					fileUploadImagenPrenda.SaveAs(Server.MapPath("~/Uploads/") + filename);
					imgImagenPrenda.ImageUrl = "~/Uploads/" + filename;
					imgImagenPrenda.Visible = true;
					FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
					BinaryReader br = new BinaryReader(fs);
					Session["foto"] = br.ReadBytes((int)fs.Length);
					fs.Close();
				}
				else
				{
					Response.Write("Por favor, selecciona un archivo de imagen válido.");
				}
			}
		}

		protected void lbRegresar_Click(object sender, EventArgs e)
        {
			Response.Redirect("GestionarPrendas.aspx");
		}

		protected void lbGuardar_Click(object sender, EventArgs e)
		{
			int resultado;
			string nombre = txtNombrePrenda.Text;
			string descripcion = txtDescripcion.Value;
			
			tipoPrenda tipo;
			if (rbPolo.Checked == true)
				tipo = tipoPrenda.Polo;
			else if (rbPantalon.Checked == true)
				tipo = tipoPrenda.Pantalon;
			else if (rbPolera.Checked == true)
				tipo = tipoPrenda.Polera;
			else if (rbCamisa.Checked == true)
				tipo = tipoPrenda.Camisa;
			else
				tipo = tipoPrenda.Casaca;

			byte[] imagen = (byte[])Session["foto"];

			talla _talla = (talla)Enum.Parse(typeof(talla), ddlTalla.SelectedValue.ToString());
			
			genero _genero;
			if (rbHombre.Checked == true)
				_genero = genero.Hombre;
			else if (rbMujer.Checked == true)
				_genero = genero.Mujer;
			else
				_genero = genero.Unisex;

			string color = txtColor.Text;
			double precioOriginal = Double.Parse(txtPrecioOriginal.Text);
			int stock = Int32.Parse(txtStock.Text);

			if (estaModificando == true)
			{
				int idPrenda = Int32.Parse(txtIdPrenda.Text);
				double precioDescontado = Double.Parse(txtPrecioDescontado.Text);
				int cantVendida = Int32.Parse(txtCantVendida.Text);
				resultado = prendaBO.modificar(idPrenda, nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, precioDescontado, stock, cantVendida);
				if (resultado != 0)
					Response.Redirect("GestionarPrendas.aspx");
			}
			else
			{
				resultado = prendaBO.insertar(nombre, descripcion, tipo, imagen, _talla, _genero, color, precioOriginal, stock);
				if (resultado != 0)
					Response.Redirect("GestionarPrendas.aspx");
			}
		}
	}
}
