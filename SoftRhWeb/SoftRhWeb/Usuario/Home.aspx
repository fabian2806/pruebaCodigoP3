<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario/WebMasterUsuario.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="SoftRhWeb.Usuario.Home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container mt-5">
        <div class="text-center">
            <asp:DropDownList ID="ddlTiposPrenda" CssClass="form-select" runat="server"></asp:DropDownList>
        </div>

        <div class="mt-4">
            <asp:GridView ID="gvPrendas" runat="server" AutoGenerateColumns="true" CssClass="table table-striped"/>
        </div>


    </div>
</asp:Content>
