<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudPromociones.aspx.cs" Inherits="RHStoreWS.Admin.CrudPromociones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Registrar Promocion
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
					<div class="col-md-3">
						<asp:Label ID="lblIdPromocion" runat="server" Text="ID:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtIdPromocion" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblIdTrabajador" runat="server" Text="Trabajador:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtIdTrabajador" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblIdPrenda" runat="server" Text="Prenda:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtIdPrenda" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblNombrePromocion" runat="server" Text="Nombre:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtNombrePromocion" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblTipoPromocion" runat="server" Text="Tipo:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
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
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblValorDescuento" runat="server" Text="Valor de Descuento (S/.):" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtValorDescuento" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblFechaInicio" runat="server" Text="Fecha Inicio:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtFechaInicio" TextMode="DateTime" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblFechaFin" runat="server" Text="Fecha Fin:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
						<asp:TextBox ID="txtFechaFin" TextMode="DateTime" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-3">
						<asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold"></asp:Label>
					</div>
					<div class="col-md-9">
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
</asp:Content>
