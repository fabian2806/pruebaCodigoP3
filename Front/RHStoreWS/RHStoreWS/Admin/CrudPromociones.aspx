<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudPromociones.aspx.cs" Inherits="RHStoreWS.Admin.CrudPromociones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registro o modificación de promoción
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
				<div class="row">
					<div class="col-md-6 d-flex flex-column w-70">
						<div class="row mb-3">
							<div class="col-md-3 ">
								<asp:Label ID="lblID" runat="server" Text="ID:" CssClass="col-form-label fw-bold" />
							</div>
							<div class="col-md-2">
								<asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" />
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblTrabajador" runat="server" Text="Trabajador:" CssClass="col-form-label fw-bold" />
							</div>
							<div class="col-md-9">
								<div class="row">
									<div class="col-lg-auto pe-1">
										<asp:TextBox ID="txtNombreTrabajador" runat="server" CssClass="form-control" Enabled="false" />
									</div>
									<div class="col-md-auto pe-0 ps-1">
										<asp:LinkButton ID="lbBuscarTrabajador" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" CssClass="btn btn-primary col-sm-auto" OnClick="lbBuscarTrabajador_Click" />
									</div>
								</div>
							</div>
						</div>


						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblIdPrenda" runat="server" Text="Prenda:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-9">

								<div class="row w-100">
									<div class="col-lg-auto pe-1">
										<asp:TextBox ID="txtIdPrenda" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
									</div>
									<div class="col-md-auto pe-0 ps-1">
										<asp:LinkButton ID="lbBuscarPrenda" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" CssClass="btn btn-primary col-sm-auto" OnClick="lbBuscarPrenda_Click" />
									</div>

								</div>
							</div>
						</div>


						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblNombrePromocion" runat="server" Text="Nombre:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
								<asp:TextBox ID="txtNombrePromocion" runat="server" CssClass="form-control"></asp:TextBox>
							</div>
						</div>


						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblTipoPromocion" runat="server" Text="Tipo:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
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
							<div class="col-md-3">
								<asp:Label ID="lblValorDescuento" runat="server" Text="Descuento (S/.):" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
								<asp:TextBox ID="txtValorDescuento" runat="server" CssClass="form-control"></asp:TextBox>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblFechaInicio" runat="server" Text="Fecha Inicio:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
								<input id="dtpFechaInicio" class="form-control" type="date" runat="server" text="Fecha Inicio:" />
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblFechaFin" runat="server" Text="Fecha Fin:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
								<input id="dtpFechaFin" class="form-control" type="date" runat="server" text="Fecha Fin:" />
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-3">
								<asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold"></asp:Label>
							</div>
							<div class="col-md-7" style="padding-right: 30px">
								<textarea id="txtDescripcion" runat="server" class="form-control" cols="20" rows="3"></textarea>
							</div>
						</div>
					</div>

					<div class="col-md-6 d-flex flex-column w-70">
						<div class="card h-100 w-100">
							<!-- Asegúrate de que el GridView use toda la altura -->
							<div class="card-header text-center">
								<h4>Prendas Seleccionadas</h4>
							</div>
							<div class="card-body p-2 flex-grow-1">
								<!-- Flex-grow para llenar el espacio disponible -->
								<asp:GridView ID="gvPrendasSeleccionadas" runat="server" AllowPaging="true" PageSize="5" OnRowDataBound="gvPrendasSeleccionadas_RowDataBound" OnPageIndexChanging="gvPrendasSeleccionadas_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
									<Columns>
										<asp:BoundField HeaderText="Nombre" />
										<asp:BoundField HeaderText="Talla" />
										<asp:BoundField HeaderText="Género" />
										<asp:BoundField HeaderText="Precio original" />
										<asp:TemplateField>
											<ItemTemplate>
												<asp:LinkButton ID="gvPrendasSeleccionadas_lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="gvPrendasSeleccionadas_lbEliminar_Click" />
											</ItemTemplate>
										</asp:TemplateField>

									</Columns>
								</asp:GridView>
							</div>
						</div>
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

	<!-- Modal para elegir las prendas -->
	<div class="modal" id="modalSeleccionarPrendas">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Búsqueda de Prendas</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" />
				</div>
				<div class="modal-body">
					<asp:UpdatePanel runat="server">
						<ContentTemplate>
							<div class="container row pb-3 pt-3">
								<div class="row align-items-center">
									<div class="col-auto">
										<asp:Label CssClass="form-label" runat="server" Text="Nombre o descripción de la prenda:" />
									</div>
									<div class="col-sm-3">
										<asp:TextBox CssClass="form-control" ID="modalSeleccionarPrendas_txtNombreDescripcionPrenda" runat="server" />
									</div>
									<div class="col-sm-2">
										<asp:LinkButton ID="modalSeleccionarPrendas_lbBuscarPrenda" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="modalSeleccionarPrendas_lbBuscarPrenda_Click" />
									</div>
								</div>
							</div>
							<div class="container row">
								<asp:GridView ID="modalSeleccionarPrendas_gvPrendas" runat="server" AllowPaging="true" PageSize="5" OnRowDataBound="modalSeleccionarPrendas_gvPrendas_RowDataBound" OnPageIndexChanging="modalSeleccionarPrendas_gvPrendas_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
									<Columns>
										<asp:BoundField HeaderText="Nombre" />
										<asp:BoundField HeaderText="Talla" />
										<asp:BoundField HeaderText="Género" />
										<asp:BoundField HeaderText="Precio original" />
										<asp:TemplateField>
											<ItemTemplate>
												<asp:LinkButton ID="modalSeleccionarPrendas_lbSeleccionarPrenda" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" CommandArgument='<%# Eval("idPrenda") %>' OnClick="modalSeleccionarPrendas_lbSeleccionarPrenda_Click" />
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
