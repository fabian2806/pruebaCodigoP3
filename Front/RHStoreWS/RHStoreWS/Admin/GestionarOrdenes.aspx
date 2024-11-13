<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="GestionarOrdenes.aspx.cs" Inherits="RHStoreWS.Admin.GestionarOrdenes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Ordenes de Venta
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
                <h2>Gestión de Ordenes de Venta</h2>
            </div>
            <div class="card-body">
                <div class="row align-items-center mb-3">
                    <div class="col-12 col-md-auto me-2">
                        <asp:Label ID="lblNombreDescripcion" runat="server" Text="Estado de la orden:" CssClass="col-form-label"></asp:Label>
                    </div>
                    <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                        <asp:TextBox ID="txtNombreDescripcion" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                    <div class="col-12 col-md-auto me-2 mt-3 mt-md-0">
                        <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" OnClick="lbBuscar_Click"/>
                    </div>                   
                </div>
                <div class="row">
                    <asp:GridView ID="dgvOrdenCompra" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="dgvOrdenCompra_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                        <Columns>
                            <asp:BoundField HeaderText="Cliente" DataField="cliente.idUsuario" />
                            
                            <asp:TemplateField HeaderText="Fecha Registro">
                                <ItemTemplate>
                                    <%# Convert.ToDateTime(Eval("fechaRegistro")) == DateTime.MinValue || Convert.ToDateTime(Eval("fechaRegistro")).ToString("yyyy-MM-dd") == "0001-01-01" ? "---" : Convert.ToDateTime(Eval("fechaRegistro")).ToString("dd-MM-yyyy") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            
                            <asp:TemplateField HeaderText="Fecha Procesado">
                                <ItemTemplate>
                                    <%# Convert.ToDateTime(Eval("fechaProcesado")) == DateTime.MinValue || Convert.ToDateTime(Eval("fechaProcesado")).ToString("yyyy-MM-dd") == "0001-01-01" ? "---" : Convert.ToDateTime(Eval("fechaProcesado")).ToString("dd-MM-yyyy") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            
                            <asp:TemplateField HeaderText="Fecha Entregado">
                                <ItemTemplate>
                                    <%# Convert.ToDateTime(Eval("fechaEntregado")) == DateTime.MinValue || Convert.ToDateTime(Eval("fechaEntregado")).ToString("yyyy-MM-dd") == "0001-01-01" ? "---" : Convert.ToDateTime(Eval("fechaEntregado")).ToString("dd-MM-yyyy") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            
                            <asp:TemplateField HeaderText="Fecha Anulado">
                                <ItemTemplate>
                                    <%# Convert.ToDateTime(Eval("fechaAnulado")) == DateTime.MinValue || Convert.ToDateTime(Eval("fechaAnulado")).ToString("yyyy-MM-dd") == "0001-01-01" ? "---" : Convert.ToDateTime(Eval("fechaAnulado")).ToString("dd-MM-yyyy") %>
                                </ItemTemplate>
                            </asp:TemplateField>

                            <asp:BoundField HeaderText="Estado" DataField="estado" />
                            <asp:BoundField HeaderText="DNI" DataField="dni" />
                            <asp:BoundField HeaderText="Correo" DataField="correo" />
                            <asp:BoundField HeaderText="Subtotal" DataField="subtotal" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <div style="display: inline-flex; align-items: center;">
                                        <asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("idOrden") %>' OnClick="lbModificar_Click" />
                                        <asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-xmark ps-2'></i>" CommandArgument='<%# Eval("idOrden") %>' OnClick="lbEliminar_Click" />
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
