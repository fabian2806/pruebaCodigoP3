<%@ Page Title="ProductoDetalle" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="ProductoDetalle.aspx.cs" Inherits="RHStoreWS.Cliente.ProductoDetalle" %>

<asp:Content ID="headContent" ContentPlaceHolderID="head" runat="server">
    <title>Detalle Producto</title>
    <!-- Inclusión de Bootstrap CSS y Font Awesome -->
    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <link href="../Content/styles.css" rel="stylesheet" />
    <link href="../Content/Fonts/css/all.css" rel="stylesheet" />
    
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #e6e6e6;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-left: 200px;
        }
        h2 {
            color: #333;
        }
        .product-details img {
            width: 100%;
            max-width: 300px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
            margin-bottom: 20px;
        }
        .product-details {
            text-align: center;
        }
    </style>

    <!-- Inclusión de jQuery y Bootstrap JS -->
    <script src="../Scripts/jquery-3.7.1.js"></script>
    <script src="../Scripts/bootstrap.bundle.js"></script>
</asp:Content>

<asp:Content ID="bodyContent" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container">
        <h2>Detalle del Producto</h2>
        <div class="product-details">
            <asp:Label ID="lblNombre" runat="server" CssClass="product-name"></asp:Label><br />
            <asp:Image ID="imgProducto" runat="server" Width="300" Height="300" /><br />
            <asp:Label ID="lblDescripcion" runat="server" CssClass="product-description"></asp:Label><br />
            <asp:Label ID="lblPrecio" runat="server" CssClass="product-price"></asp:Label><br />
            <!-- Puedes añadir más detalles del producto aquí -->
        </div>
    </div>
</asp:Content>
