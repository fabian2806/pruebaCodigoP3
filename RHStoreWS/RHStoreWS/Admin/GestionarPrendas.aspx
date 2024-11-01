<%@ Page Title="Gestionar Prendas" Language="C#" MasterPageFile="~/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="GestionarPrendas.aspx.cs" Inherits="SoftRhWeb.GestionarPrendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Prendas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <form runat="server">


                <ItemTemplate>
                    <div class="container row">
                        <div class="row align-items-center">
                            <div class="col-auto">
                                <asp:Label ID="lblNombre" CssClass="form-label" runat="server" Text="Ingrese el nombre de la prenda:"></asp:Label>
                            </div>
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtNombre" CssClass="form-control" runat="server"></asp:TextBox>
                            </div>
                            <div class="col-sm-2">
                                <asp:LinkButton ID="lbBuscar" CssClass="btn btn-info" runat="server" OnClick="lbBuscar_Click" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" />
                            </div>
                            <div class="col text-end p-3">
                                <asp:LinkButton ID="lbRegistrar" CssClass="btn btn-success" runat="server" OnClick="lbRegistrar_Click" Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Prenda" />
                            </div>
                        </div>
                    </div>
                </ItemTemplate>
   


            <div class="container row">
                <asp:GridView ID="gvPrendas" runat="server" AutoGenerateColumns="false"
                    CssClass="table table-hover table-responsive table-striped"
                    PageSize="5" AllowPaging="true" OnPageIndexChanging="gvPrendas_PageIndexChanging">
                    <Columns>
                        <asp:BoundField HeaderText="Id de la Prenda" DataField="IdPrenda" />
                        <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                        <asp:BoundField HeaderText="Tipo" DataField="Tipo" />
                        <asp:BoundField HeaderText="Talla" DataField="Prenda" />
                        <asp:BoundField HeaderText="Genero" DataField="Genero" />
                        <asp:BoundField HeaderText="Color" DataField="Color" />
                        <asp:BoundField HeaderText="Precio" DataField="Precio" />
                        <asp:BoundField HeaderText="Stock" DataField="stock" />
                        
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit'></i>" CssClass="btn" OnClick="lbModificarPrenda_Click" CommandArgument='<%# Eval("IdArea") %>' />
                                <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash'></i>" CssClass="btn" OnClick="lbEliminarPrenda_Click" CommandArgument='<%# Eval("IdArea") %>' />
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </div>


        </form>
    </div>
</asp:Content>