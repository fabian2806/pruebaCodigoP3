<%@ Page Title="Home" Language="C#" MasterPageFile="~/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="SoftRhWeb.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <!-- Welcome Message -->
        <div class="welcome">
            <asp:Label ID="lblWelcome" runat="server" Font-Bold="True" Font-Size="Large"></asp:Label>
        </div>

        <!-- Navigation Panel -->
        <div class="navigation">
            <asp:Label ID="lblNavigation" runat="server" Text="Navegación Principal:" Font-Bold="True" Font-Size="Medium"></asp:Label>
            <br />
            <asp:HyperLink ID="lnkGestionPrendas" runat="server" NavigateUrl="~/GestionPrendas.aspx">Gestionar Prendas</asp:HyperLink>
            <asp:HyperLink ID="lnkGestionPromociones" runat="server" NavigateUrl="~/GestionPromociones.aspx">Gestionar Promociones</asp:HyperLink>
            <asp:HyperLink ID="lnkGestionDirecciones" runat="server" NavigateUrl="~/GestionDirecciones.aspx">Gestionar Direcciones</asp:HyperLink>
            <asp:HyperLink ID="lnkGestionCupones" runat="server" NavigateUrl="~/GestionCupones.aspx">Gestionar Cupones</asp:HyperLink>
            <asp:HyperLink ID="lnkGestionUsuarios" runat="server" NavigateUrl="~/GestionUsuarios.aspx">Gestionar Usuarios</asp:HyperLink>
            <asp:HyperLink ID="lnkAplicarCupon" runat="server" NavigateUrl="~/AplicarCupon.aspx">Aplicar Cupon en Orden</asp:HyperLink>
        </div>

        <!-- Information Panel -->
        <div class="infoPanel">
            <asp:Label ID="lblInfoPanel" runat="server" Text="Panel de Información:" Font-Bold="True" Font-Size="Medium"></asp:Label>
            <br />
            <asp:Label ID="lblStats" runat="server" Text="Estadísticas Rápidas"></asp:Label>
            <ul>
                <li><asp:Label ID="lblPrendas" runat="server" Text="Total Prendas: 0"></asp:Label></li>
                <li><asp:Label ID="lblPromociones" runat="server" Text="Promociones Activas: 0"></asp:Label></li>
                <li><asp:Label ID="lblCupones" runat="server" Text="Cupones Activos: 0"></asp:Label></li>
            </ul>
        </div>

        <!-- Recent Activity Panel -->
        <div class="recentActivity">
            <asp:Label ID="lblRecentActivity" runat="server" Text="Actividad Reciente:" Font-Bold="True" Font-Size="Medium"></asp:Label>
            <br />
            <asp:Repeater ID="rptActivity" runat="server">
                <ItemTemplate>
                    <p><%# Eval("Description") %> - <%# Eval("Date") %></p>
                </ItemTemplate>
            </asp:Repeater>
        </div>
    </div>
</asp:Content>
