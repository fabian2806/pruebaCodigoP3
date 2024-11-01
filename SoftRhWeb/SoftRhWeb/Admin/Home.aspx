<%@ Page Title="Home" Language="C#" MasterPageFile="~/Admin/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="SoftRhWeb.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <link href="~/Content/Site.css" rel="stylesheet" type="text/css" />
    
    <div class="container">
        <style>
        /* Estilos para la sección de bienvenida */
        .welcome-section {
            background-color: #fff6f8; /* Fondo suave */
            border-radius: 8px; /* Bordes redondeados */
            padding: 20px; /* Espaciado interno */
            margin-bottom: 20px; /* Espacio inferior */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Sombra */
            text-align: center; /* Centrar texto */
        }

        .welcome-message {
            font-size: 24px; /* Tamaño de fuente */
            color: #333; /* Color del texto */
            font-weight: bold; /* Texto en negrita */
        }

        .welcome-message span {
            color: #4a90e2; /* Color distintivo para el nombre del administrador */
        }
        </style>

        <!-- Welcome Message -->
        <div class="welcome-section">
            <asp:Label ID="lblWelcome" runat="server" CssClass="welcome-message" Text="Bienvenido, Administrador: <span>Jean Paul 7v7</span>"></asp:Label>
            <img src="/Images/Paw.gif" width="50" />
        </div>


        <!-- Navigation Panel -->
        <div class="navigation-section">
            <asp:Label ID="lblNavigation" runat="server" Text="Rutas Recientes:" CssClass="section-title"></asp:Label>
            <div class="navigation-links">
                <asp:HyperLink ID="lnkGestionPrendas" runat="server" NavigateUrl="~/GestionPrendas.aspx" CssClass="nav-link">Gestionar Prendas</asp:HyperLink>
                <asp:HyperLink ID="lnkGestionPromociones" runat="server" NavigateUrl="~/GestionPromociones.aspx" CssClass="nav-link">Gestionar Promociones</asp:HyperLink>
                <asp:HyperLink ID="lnkGestionDirecciones" runat="server" NavigateUrl="~/GestionDirecciones.aspx" CssClass="nav-link">Gestionar Direcciones</asp:HyperLink>
                <asp:HyperLink ID="lnkGestionCupones" runat="server" NavigateUrl="~/GestionCupones.aspx" CssClass="nav-link">Gestionar Cupones</asp:HyperLink>
                <asp:HyperLink ID="lnkGestionUsuarios" runat="server" NavigateUrl="~/GestionUsuarios.aspx" CssClass="nav-link">Gestionar Usuarios</asp:HyperLink>
            </div>
        </div>

        <!-- Information Panel -->
        <div class="info-section">
            <asp:Label ID="lblInfoPanel" runat="server" Text="Panel de Información:" CssClass="section-title"></asp:Label>
            <div class="info-stats">
                <ul class="stats-list">
                    <li><asp:Label ID="lblPrendas" runat="server" Text="Total Prendas: 0" CssClass="stat-item"></asp:Label></li>
                    <li><asp:Label ID="lblPromociones" runat="server" Text="Promociones Activas: 0" CssClass="stat-item"></asp:Label></li>
                    <li><asp:Label ID="lblCupones" runat="server" Text="Cupones Activos: 0" CssClass="stat-item"></asp:Label></li>
                </ul>
            </div>
        </div>

        <!-- Recent Activity Panel -->
        <div class="recent-activity-section">
            <asp:Label ID="lblRecentActivity" runat="server" Text="Actividad Reciente:" CssClass="section-title"></asp:Label>
            <div class="recent-activity-list">
                <asp:Repeater ID="rptActivity" runat="server">
                    <ItemTemplate>
                        <div class="activity-item">
                            <p><%# Eval("Description") %> - <%# Eval("Date") %></p>
                        </div>
                    </ItemTemplate>
                </asp:Repeater>
            </div>
        </div>
    </div>
</asp:Content>
