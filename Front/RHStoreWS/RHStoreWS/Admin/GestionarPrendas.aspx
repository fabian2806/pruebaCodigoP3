<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="GestionarPrendas.aspx.cs" Inherits="RHStoreWS.Admin.GestionarPrendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Gestión de Prendas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container">
        <h2>Gestión de Prendas</h2>
        <div class="container row">
            <asp:GridView ID="dgvPrendas" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="ID" DataField="idPrenda"/>
                    <asp:BoundField HeaderText="Nombre" DataField="nombre"/>
                    <asp:BoundField HeaderText="Descripcion" DataField="descripcion"/>
                    <asp:BoundField HeaderText="Tipo" DataField="tipo"/>
                    <asp:BoundField HeaderText="Talla" DataField="talla"/>
                    <asp:BoundField HeaderText="Genero" DataField="genero"/>
                    <asp:BoundField HeaderText="Color" DataField="color"/>
                    <asp:BoundField HeaderText="Stock" DataField="stock"/>
                    <asp:BoundField HeaderText="PrecioOriginal" DataField="precioOriginal"/>
                    <asp:BoundField HeaderText="PrecioDescontado" DataField="precioDescontado"/>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>"  CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbModificar_Click"/>
                            <asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbEliminar_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="container row">
            <div class="text-end">
                <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Crear Prenda" OnClick="btnInsertar_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
