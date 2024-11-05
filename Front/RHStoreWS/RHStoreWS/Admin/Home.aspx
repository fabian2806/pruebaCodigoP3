<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="RHStoreWS.Admin.Home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Home
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
	<asp:Label ID="lblRol" runat="server" Text="Label"></asp:Label>
	Bienvenido a la gestión de la página de RH Store
	<asp:Label ID="lblNombre" runat="server" Text="Label"></asp:Label>
</asp:Content>
