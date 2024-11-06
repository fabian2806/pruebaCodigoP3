<%@ Page Title="Unisex" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="Unisex.aspx.cs" Inherits="RHStoreWS.Cliente.Unisex" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- Contenedor de filtros y productos -->
    <div class="container">
        <div class="filters">
            <h4>Filters</h4>
            <h5>PRECIO</h5>
            <label>Desde:</label>
            <input type="number" id="minPrice" placeholder="Precio mínimo" style="width: 100%; margin-bottom: 10px;">
            <label>Hasta:</label>
            <input type="number" id="maxPrice" placeholder="Precio máximo" style="width: 100%;"><br><br>
            <h5>CATEGORY</h5>
            <label><input type="checkbox"> HOMBRE</label>
            <label><input type="checkbox"> MUJER</label>
            <label><input type="checkbox"> UNISEX</label>
            <h5>SIZE</h5>
            <label><input type="checkbox"> Extra Small</label>
            <label><input type="checkbox"> Small</label>
            <label><input type="checkbox"> Medium</label>
            <label><input type="checkbox" checked> x Large</label>
            <h5>COLOR</h5>
            <label><input type="checkbox"> White</label>
            <label><input type="checkbox"> Blue</label>
            <label><input type="checkbox"> Cyan</label>
            <label><input type="checkbox"> Red</label>
            <label><input type="checkbox"> Yellow</label>
            <label><input type="checkbox"> Black</label>
            <label><input type="checkbox"> Purple</label>
            <label><input type="checkbox"> Pink</label>
            <label><input type="checkbox"> Orange</label>
            <label><input type="checkbox"> Green</label>
        </div>  

        <!-- Para la forma de visualizacion-->
        <div class="view-options">
            <button id="gridView" onclick="changeView('grid')">Vista Cuadrícula</button>
            <button id="detailView" onclick="changeView('detail')">Vista Detalle</button>
            <button id="mosaicView" onclick="changeView('mosaic')">Vista Mosaico</button>
        </div>
    </div>
</asp:Content>
