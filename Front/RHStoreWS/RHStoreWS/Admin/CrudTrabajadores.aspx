<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudTrabajadores.aspx.cs" Inherits="RHStoreWS.Admin.CrudTrabajadores" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registro o modificación de trabajador
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
					<asp:Label ID="lblTitulo" runat="server" Text="lblTitulo"></asp:Label>
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
						<asp:LinkButton ID="lbResetear" runat="server" Text="<i class='fa-solid fa-rotate'></i> Restablecer" CssClass="btn btn-danger" OnClick="lbResetear_Click" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblPuesto" runat="server" Text="Puesto:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtPuesto" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblSueldo" runat="server" Text="Sueldo:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtSueldo" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaIngreso" runat="server" Text="Fecha de ingreso:" CssClass="col-form-label fw-bold"/>
					</div>
					<div class="col-md-4">
						<input id="dtpFechaIngreso" class="form-control" type="date" runat="server" text="Fecha de ingreso:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblHorarioInicio" runat="server" Text="Inicio de horario:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<input id="tpHorarioInicio" class="form-control" type="time" runat="server" text="Inicio de horario:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblHorarioFin" runat="server" Text="Fin de horario:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<input id="tpHorarioFin" class="form-control" type="time" runat="server" text="Fin de horario:" />
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
