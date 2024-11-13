<%@ Page Title="ProductoDetalle" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="ProductoDetalle.aspx.cs" Inherits="RHStoreWS.Cliente.ProductoDetalle" %>

<asp:Content ID="headContent" ContentPlaceHolderID="head" runat="server">
    <title>Detalle Producto</title>
    <!-- Inclusión de Bootstrap CSS y Font Awesome -->
    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <link href="../Content/styles.css" rel="stylesheet" />
    <link href="../Content/Fonts/css/all.css" rel="stylesheet" />
    
    <style>
        .product-container {
            display: flex;
            max-width: 1300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-top: 180px;
            margin-left: 30px;
            margin-right: 30px;
        }

        .product-image {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .product-image img {
            width: 100%;
            max-width: 400px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        .product-details {
            flex: 1;
            padding: 0 20px;
        }

        .product-title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        .product-sku {
            color: #888;
            font-size: 14px;
            margin-bottom: 20px;
        }

        .product-description {
            margin: 10px 0;
            font-size: 16px;
            color: #555;
        }

        .product-price {
            font-size: 24px;
            color: #e60000;
            font-weight: bold;
            margin-top: 10px;
            margin-bottom: 20px;
        }

        .product-discount {
            color: #888;
            text-decoration: line-through;
            font-size: 16px;
        }

        .color-options, .size-options {
            margin-top: 20px;
        }

        .color-options label, .size-options label {
            font-size: 16px;
            color: #333;
            display: block;
            margin-bottom: 5px;
        }

        .color-options .color-box, .size-options .size-box {
            display: inline-block;
            margin: 5px;
            width: 30px;
            height: 30px;
            border-radius: 5px;
            border: 1px solid #ccc;
            cursor: pointer;
        }

        .quantity-section {
            display: flex;
            align-items: center;
            margin-top: 20px;
        }

        .quantity-section input {
            width: 50px;
            text-align: center;
            font-size: 18px;
            margin: 0 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .add-to-cart-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #b8ccce;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
        }

        .add-to-cart-button:hover {
            background-color: #538f95;
        }
    </style>

    <!-- Inclusión de jQuery y Bootstrap JS -->
    <script src="../Scripts/jquery-3.7.1.js"></script>
    <script src="../Scripts/bootstrap.bundle.js"></script>
</asp:Content>

<asp:Content ID="bodyContent" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="product-container">
        <div class="product-image">
            <asp:Image ID="imgProducto" runat="server" Width="300" Height="300" />
        </div>
        
        <div class="product-details">
            <div class="product-title">
                <asp:Label ID="lblNombre" runat="server"></asp:Label>
            </div>
            <div class="product-description">
                <asp:Label ID="lblDescripcion" runat="server"></asp:Label>
            </div>
            <div class="product-price">
                <asp:Label ID="lblPrecio" runat="server"></asp:Label>
                <span class="product-discount"><asp:Label ID="lblPrecioOriginal" runat="server"></asp:Label></span>
            </div>
            <div class="color-options">
                <label>COLOR:</label>
                <div class="color-box" style="background-color: #000;"></div>
                <div class="color-box" style="background-color: #555;"></div>
                <div class="color-box" style="background-color: #8ca9c3;"></div>
            </div>
            <div class="size-options">
                <label>TALLA:</label>
                <div class="size-box">S</div>
                <div class="size-box">M</div>
                <div class="size-box">L</div>
                <div class="size-box">XL</div>
            </div>
            <div class="quantity-section">
                <asp:Button ID="btnDecrease" runat="server" Text="-" />
                <asp:TextBox ID="txtCantidad" runat="server" Width="50" Text="1" />
                <asp:Button ID="btnIncrease" runat="server" Text="+" />
            </div>
            <asp:Button ID="btnAgregarCarrito" runat="server" CssClass="add-to-cart-button" Text="Agregar al carrito" OnClick="btnAgregarCarrito_Click" />
        </div>
    </div>
</asp:Content>
