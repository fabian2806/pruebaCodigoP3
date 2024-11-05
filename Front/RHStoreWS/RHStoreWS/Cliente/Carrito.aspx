<%@ Page Title="Carrito" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="Carrito.aspx.cs" Inherits="RHStoreWS.Cliente.Carrito" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #ffffff;
        }
        .cart-summary {
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            width: 300px;
            margin: auto;
            text-align: center;
        }
        .cart-summary h2 {
            margin-bottom: 20px;
        }
        .cart-summary p {
            margin: 5px 0;
        }
        .cart-summary button {
            padding: 10px;
            background-color: #538f95;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .cart-summary button:hover {
            background-color: #4a7b7f;
        }
    </style>

    <div class="cart-summary">
        <h2>Resumen del Carrito</h2>
        <p>Polo Regular Fit</p>
        <p>Subtotal: S/ 1,399</p>
        <p>Total Tarjeta: S/ 1,299</p>
        <button onclick="location.href='Checkout.aspx';">Proceder al Pago</button>
    </div>
</asp:Content>
