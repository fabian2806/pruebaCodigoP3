<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionUsuarios.aspx.cs" Inherits="SoftRhWeb.GestionUsuarios" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Listado de Eventos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Listado de Eventos</h2>
            </div>
            <div class="card-body">
                <div class="row align-items-center mb-3">
                    <div class="col-12 col-md-auto me-2">
                        <asp:Label ID="lblNombre" runat="server" Text="Nombre: " CssClass="col-form-label"></asp:Label>
                    </div>
                     <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                    <div class="col-12 col-md-auto me-2 mt-3 mt-md-0">
                        <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" />
                    </div>
                    <div class="col-12 col-md text-md-end mt-3 mt-md-0">
                        <asp:LinkButton ID="lbRegistrar" runat="server" CssClass="btn btn-success" Text="<i class='fa-solid fa-plus'></i> Registrar Evento" OnClick="lbRegistrar_Click"/>
                    </div>
                </div>
                <div class="row">
                    <asp:GridView ID="gvEventos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                        <Columns>
                            <asp:BoundField HeaderText="Nombre del Evento" DataField="nombre" />
                            <asp:TemplateField HeaderText="Productora">
                                <ItemTemplate>
                                    <%# Eval("productora.nombre") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField HeaderText="Fecha de Realización" DataField="fechaRealizacion" DataFormatString="{0:dd-MM-yyyy}" HtmlEncode="false" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:LinkButton runat="server" Text="<i class='fa-solid fa-eye'></i>" OnClick="lbVisualizar_Click" CommandArgument='<%# Eval("IdEvento") %>' />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
