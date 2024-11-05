<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="GestionarPrendas.aspx.cs" Inherits="RHStoreWS.Admin.GestionarPrendas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Gestión de Prendas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Gestión de Prendas</h2>
			</div>
			<div class="card-body">
				<div class="row align-items-center mb-3">
					<div class="col-12 col-md-auto me-2">
						<asp:Label ID="lblNombre" runat="server" Text="Nombre de la prenda: " CssClass="col-form-label"></asp:Label>
					</div>
					<div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
						<asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
					</div>
					<div class="col-12 col-md-auto me-2 mt-3 mt-md-0">
						<asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" OnClick="lbBuscar_Click"/>
					</div>
					<div class="col-12 col-md text-md-end mt-3 mt-md-0">
						<asp:LinkButton ID="lbRegistrar" runat="server" CssClass="btn btn-success" Text="<i class='fa-solid fa-plus'></i> Registrar Prenda" OnClick="lbRegistrar_Click" />
					</div>
				</div>
				<div class="row">
					<asp:GridView ID="dgvPrendas" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="dgvPrendas_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
						<Columns>
							<asp:BoundField HeaderText="ID" DataField="idPrenda" />
							<asp:BoundField HeaderText="Nombre" DataField="nombre" />
							<asp:BoundField HeaderText="Descripcion" DataField="descripcion" />
							<asp:BoundField HeaderText="Tipo" DataField="tipo" />
							<asp:BoundField HeaderText="Talla" DataField="talla" />
							<asp:BoundField HeaderText="Genero" DataField="genero" />
							<asp:BoundField HeaderText="Color" DataField="color" />
							<asp:BoundField HeaderText="Stock" DataField="stock" />
							<asp:BoundField HeaderText="PrecioOriginal" DataField="precioOriginal" />
							<asp:BoundField HeaderText="PrecioDescontado" DataField="precioDescontado" />
							<asp:TemplateField>
								<ItemTemplate>
									<div style="display: inline-flex; align-items: center;">
										<asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbModificar_Click" />
										<asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbEliminar_Click" />
									</div>
								</ItemTemplate>
							</asp:TemplateField>
						</Columns>
					</asp:GridView>
				</div>
			</div>
		</div>
	</div>
</asp:Content>
