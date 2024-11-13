<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudCupones.aspx.cs" Inherits="RHStoreWS.Admin.CrudCupones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registro o modificación de cupón
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
	<script src="../Scripts/RHStore/CrudPromociones.js"></script>
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
					<div class="col-md-1">
						<asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblTrabajador" runat="server" Text="Trabajador:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-3">
						<asp:TextBox ID="txtNombreTrabajador" runat="server" CssClass="form-control" Enabled="false" />
					</div>
					<asp:LinkButton ID="lbBuscarTrabajador" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" OnClick="lbBuscarTrabajador_Click" />
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblCodigo" runat="server" Text="Código:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblValorDescuento" runat="server" Text="Descuento:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtValorDescuento" runat="server" CssClass="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaInicio" runat="server" Text="Fecha de inicio:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<input id="dtpFechaInicio" class="form-control" type="date" runat="server" text="Fecha de inicio:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaFin" runat="server" Text="Fecha de fin:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
						<input id="dtpFechaFin" class="form-control" type="date" runat="server" text="Fecha de fin:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold" />
					</div>
					<div class="col-md-4">
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

	<!-- Modal para seleccionar al trabajador -->
	<asp:ScriptManager runat="server"></asp:ScriptManager>
	<div class="modal" id="modalSeleccionarTrabajador">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Búsqueda de Trabajador</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" />
				</div>
				<div class="modal-body">
					<asp:UpdatePanel runat="server">
						<ContentTemplate>
							<div class="container row pb-3 pt-3">
								<div class="row align-items-center">
									<div class="col-auto">
										<asp:Label CssClass="form-label" runat="server" Text="DNI o nombre del trabajador:" />
									</div>
									<div class="col-sm-3">
										<asp:TextBox CssClass="form-control" ID="modalSeleccionarTrabajador_txtDniNombre" runat="server" />
									</div>
									<div class="col-sm-2">
										<asp:LinkButton ID="modalSeleccionarTrabajador_lbBuscarTrabajador" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="modalSeleccionarTrabajador_lbBuscarTrabajador_Click" />
									</div>
								</div>
							</div>
							<div class="container row">
								<asp:GridView ID="modalSeleccionarTrabajador_gvTrabajadores" runat="server" AllowPaging="true" PageSize="5" OnRowDataBound="modalSeleccionarTrabajador_gvTrabajadores_RowDataBound" OnPageIndexChanging="modalSeleccionarTrabajador_gvTrabajadores_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
									<Columns>
										<asp:BoundField HeaderText="ID" />
										<asp:BoundField HeaderText="DNI" />
										<asp:BoundField HeaderText="Nombre completo" />
										<asp:BoundField HeaderText="Puesto" />
										<asp:TemplateField>
											<ItemTemplate>
												<div style="display: inline-flex; align-items: center;">
													<asp:LinkButton ID="modalSeleccionarTrabajador_lbSeleccionarTrabajador" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" CommandArgument='<%# Eval("idUsuario") %>' OnClick="modalSeleccionarTrabajador_lbSeleccionarTrabajador_Click" />
												</div>
											</ItemTemplate>
										</asp:TemplateField>
									</Columns>
								</asp:GridView>
							</div>
						</ContentTemplate>
					</asp:UpdatePanel>
				</div>
			</div>
		</div>
	</div>
</asp:Content>
