<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudPrendas.aspx.cs" Inherits="RHStoreWS.Admin.CrudPrendas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registro o modificación de prenda
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphNombreUsuario" runat="server">
	<asp:Label ID="lblNombreUsuario" runat="server" Text="Nombre de usuario" />
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>
					<!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
					<asp:Label ID="lblTitulo" runat="server" Text="lblTitulo" />
				</h2>
			</div>
			<div class="card-body pb-2">
				<div class="row">
					<div class="col-md-6">
						<asp:Label ID="lblImagen" runat="server" Text="Agregue una imagen referencial:" CssClass="col-form-label fw-bold" />
						<asp:Image ID="imgImagen" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="../Images/PlaceHolder.jpg" Height="550" Width="675" />
						<asp:FileUpload ID="fileUploadImagen" CssClass="form-control mb-2" runat="server" onchange="this.form.submit()" ClientIDMode="Static" />
					</div>
					<div class="col-md-6">
						<div class="col-md-6 pb-md-3">
							<asp:Label ID="lblID" runat="server" Text="ID:" CssClass="col-form-label fw-bold" />
							<asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" />
						</div>
						<div class="col-md-12 pb-md-3">
							<asp:Label ID="lblNombre" runat="server" Text="Nombre:" CssClass="col-form-label fw-bold" />
							<asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" />
						</div>
						<div class="col-md-12 pb-md-3">
							<asp:Label ID="lblTalla" runat="server" Text="Talla:" CssClass="col-form-label fw-bold" />
							<asp:DropDownList ID="ddlTalla" runat="server" AutoPostBack="true" CssClass="form-select" />
						</div>
						<div class="col-md-12 pb-md-3">
							<asp:Label ID="lblTipo" runat="server" Text="Tipo:" CssClass="col-form-label fw-bold" />
							<div class="form-control">
								<div class="form-check form-check-inline">
									<input id="rbPolo" class="form-check-input" type="radio" runat="server" name="tipoPrenda" />
									<label id="lblPolo" class="form-check-label" for="cphContenido_rbPolo">Polo</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbPantalon" class="form-check-input" type="radio" runat="server" name="tipoPrenda" />
									<label id="lblPantalon" class="form-check-label" for="cphContenido_rbPantalon">Pantalón</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbPolera" class="form-check-input" type="radio" runat="server" name="tipoPrenda" />
									<label id="lblPolera" class="form-check-label" for="cphContenido_rbPolera">Polera</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbCamisa" class="form-check-input" type="radio" runat="server" name="tipoPrenda" />
									<label id="lblCamisa" class="form-check-label" for="cphContenido_rbCamisa">Camisa</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbCasaca" class="form-check-input" type="radio" runat="server" name="tipoPrenda" />
									<label id="lblCasaca" class="form-check-label" for="cphContenido_rbCasaca">Casaca</label>
								</div>
							</div>
						</div>
						<div class="col-md-12 pb-md-3">
							<asp:Label ID="lblGenero" runat="server" Text="Género:" CssClass="col-form-label fw-bold" />
							<div class="form-control">
								<div class="form-check form-check-inline">
									<input id="rbHombre" class="form-check-input" type="radio" runat="server" name="genero" />
									<label id="lblHombre" class="form-check-label" for="cphContenido_rbHombre">Hombre</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbMujer" class="form-check-input" type="radio" runat="server" name="genero" />
									<label id="lblMujer" class="form-check-label" for="cphContenido_rbMujer">Mujer</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="rbUnisex" class="form-check-input" type="radio" runat="server" name="genero" />
									<label id="lblUnisex" class="form-check-label" for="cphContenido_rbUnisex">Unisex</label>
								</div>
							</div>
						</div>
						<div class="col-md-12 pb-md-3">
							<asp:Label ID="lblColor" runat="server" Text="Color:" CssClass="col-form-label fw-bold" />
							<asp:TextBox ID="txtColor" runat="server" CssClass="form-control" />
						</div>
						<div class="row">
							<div class="col-md-6 pb-md-3">
								<asp:Label ID="lblPrecioOriginal" runat="server" Text="Precio Original (S/.):" CssClass="col-form-label fw-bold" />
								<asp:TextBox ID="txtPrecioOriginal" runat="server" CssClass="form-control" />
							</div>
							<div class="col-md-6 pb-md-3">
								<asp:Label ID="lblPrecioDescontado" runat="server" Text="Precio Descontado (S/.):" CssClass="col-form-label fw-bold" />
								<asp:TextBox ID="txtPrecioDescontado" runat="server" CssClass="form-control" Enabled="false">0.00</asp:TextBox>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 pb-md-3">
								<asp:Label ID="lblStock" runat="server" Text="Stock" CssClass="col-form-label fw-bold" />
								<asp:TextBox ID="txtStock" runat="server" CssClass="form-control" />
							</div>
							<div class="col-md-6 pb-md-3">
								<asp:Label ID="lblCantVendida" runat="server" Text="Cantidad Vendida:" CssClass="col-form-label fw-bold" />
								<asp:TextBox ID="txtCantVendida" runat="server" CssClass="form-control" Enabled="false">0</asp:TextBox>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold" />
						<textarea id="txtDescripcion" runat="server" class="form-control" cols="20" rows="3" />
					</div>
				</div>
			</div>
			<div class="card-footer clearfix">
				<asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click" />
				<asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click" />
			</div>
		</div>
	</div>
</asp:Content>
