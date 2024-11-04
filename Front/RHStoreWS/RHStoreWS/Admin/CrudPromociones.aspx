<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudPromociones.aspx.cs" Inherits="RHStoreWS.Admin.CrudPromociones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registrar Promocion
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
	<script src="../Scripts/AdminModals/CrudPromociones.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
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
						<asp:Label ID="lblIdPromocion" runat="server" Text="ID:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-2">
						<asp:TextBox ID="txtIdPromocion" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblIdTrabajador" runat="server" Text="Trabajador:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtIdTrabajador" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
					</div>
					<asp:LinkButton ID="lbBuscarTrabajador" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" CssClass="btn btn-primary col-sm-auto" OnClick="lbBuscarTrabajador_Click"/>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblIdPrenda" runat="server" Text="Prenda:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtIdPrenda" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
					</div>
					<asp:LinkButton ID="lbBuscarPrenda" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" CssClass="btn btn-primary col-sm-auto" />
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblNombrePromocion" runat="server" Text="Nombre:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtNombrePromocion" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblTipoPromocion" runat="server" Text="Tipo:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<div class="form-control">
							<div class="form-check form-check-inline">
								<input id="rbPorcentaje" class="form-check-input" type="radio" runat="server" name="tipoPromocion" />
								<label id="lblPorcentaje" class="form-check-label" for="rbPorcentaje">Porcentaje</label>
							</div>
							<div class="form-check form-check-inline">
								<input id="rbMontoFijo" class="form-check-input" type="radio" runat="server" name="tipoPromocion" />
								<label id="lblMontoFijo" class="form-check-label" for="rbMontoFijo">Monto Fijo</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblValorDescuento" runat="server" Text="Descuento (S/.):" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<asp:TextBox ID="txtValorDescuento" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaInicio" runat="server" Text="Fecha Inicio:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<input id="dtpFechaInicio" class="form-control" type="date" runat="server" text="Fecha Inicio:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblFechaFin" runat="server" Text="Fecha Fin:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<input id="dtpFechaFin" class="form-control" type="date" runat="server" text="Fecha Fin:" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-2">
						<asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-4">
						<textarea id="txtDescripcion" runat="server" class="form-control" cols="20" rows="3"></textarea>
					</div>
				</div>
			</div>
			<div class="card-footer clearfix">
				<asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click" />
				<asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click" />
			</div>
		</div>
	</div>

	<!-- Modal -->
	<asp:ScriptManager runat="server"></asp:ScriptManager>
	<div class="modal" id="form-modal-trabajador">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Búsqueda de Trabajador</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<asp:UpdatePanel runat="server">
						<ContentTemplate>
							<div class="container row pb-3 pt-3">
								<div class="row align-items-center">
									<div class="col-auto">
										<asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
									</div>
									<div class="col-sm-3">
										<asp:TextBox CssClass="form-control" ID="ModalTrabajador_txtNombreDniTrabajador" runat="server"></asp:TextBox>
									</div>
									<div class="col-sm-2">
										<asp:LinkButton ID="ModalTrabajador_lbBuscarTrabajador" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalTrabajador_lbBuscarTrabajador_Click" />
									</div>
								</div>
							</div>
							<div class="container row">
								<asp:GridView ID="ModalTrabajador_gvTrabajadores" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="true" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalTrabajador_gvTrabajadores_PageIndexChanging">
									<Columns>
										<asp:TemplateField>
											<ItemTemplate>
												<asp:LinkButton ID="ModalTrabajador_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" CommandArgument='<%# Eval("idUsuario") %>' OnClick="ModalTrabajador_lbSeleccionar_Click"/>
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
