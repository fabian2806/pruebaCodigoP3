<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudAdministradores.aspx.cs" Inherits="RHStoreWS.Admin.CrudAdministradores" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registro o modificación de administrador
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
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblID" runat="server" Text="ID:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-2">
						<asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblDNI" runat="server" Text="DNI:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblNombres" runat="server" Text="Nombres:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtNombres" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblApellidos" runat="server" Text="Apellidos:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtApellidos" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblCorreo" runat="server" Text="Correo:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblContrasenha" runat="server" Text="Contraseña:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtContrasenha" runat="server" CssClass="form-control" />
					</div>
					<div class="col-md-4">
						<asp:LinkButton ID="lbResetear" runat="server" Text="<i class='fa-solid fa-rotate'></i> Restablecer" CssClass="btn btn-danger" OnClick="lbResetear_Click"/>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaCreacion" runat="server" Text="Fecha de creación:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<input id="dtpFechaCreacion" class="form-control" type="date" runat="server" text="Fecha de creación:"/>
					</div>
				</div>
				<div class="card-footer clearfix">
					<asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click" />
					<asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click" />
				</div>
			</div>
		</div>
	</div>
</asp:Content>
