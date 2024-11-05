<%@ Page Title="Unisex" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="Unisex.aspx.cs" Inherits="RHStoreWS.Cliente.Unisex" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* Fondo blanco */
        }
        .logo {
            position: absolute;
            left: 20px;
            top: 20px;
            width: 150px;
        }
        .header-content {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            width: 100%;
            position: absolute;
            right: 20px;
            top: 20px;
        }
        .search-container {
            margin-right: 20px;
            display: flex;
            align-items: center;
            margin-top: 40px; /* Espacio debajo del logo */
        }
        .search-container input {
            padding: 10px;
            border: none;
            border-radius: 5px;
            margin-right: 5px;
        }

        .search-container button {
            padding: 10px;
            background-color: #b8ccce;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .search-container button:hover {
            background-color: #538f95;
        }
        .user-options {
            display: flex;
            align-items: center;
        }

        .user-options a {
            margin-top: 40px;
            color: #b8ccce;
            text-decoration: none;
            margin-left: 20px;
        }

        .user-options a:hover {
            color: #538f95;
        }
        .container {
            display: flex; /* Flexbox para organizar filtros y productos */
        }

        .filters {
            margin-top: 200px;
            width: 250px; /* Ancho fijo para los filtros */
            padding: 20px; /* Espacio interior */
            border-right: 1px solid #ddd; /* Línea divisoria */
        }

        .filters h4 {
            margin-bottom: 15px; /* Espacio debajo del título */
        }

        .filters label {
            display: block; /* Cada etiqueta en una línea nueva */
            margin: 5px 0; /* Espacio arriba y abajo de las etiquetas */
        }

        .filters input[type="checkbox"] {
            margin-right: 5px; /* Espacio a la derecha del checkbox */
        }

        .products {
            margin-top: 200px;
            flex-grow: 1; /* Toma el resto del espacio disponible */
            display: flex;
            flex-wrap: wrap; /* Permite que los productos se envuelvan */
            padding: 20px; /* Espacio interior */
        }

        .product {
            position: relative; /* Permite que el ícono se posicione relativo a este contenedor */
            text-align: center; /* Centra el texto debajo de la imagen */
            margin: 15px; /* Espacio alrededor de cada producto */
            width: calc(33.33% - 30px); /* 3 productos por fila */
        }


        .product img {
            width: 100%; /* Ajusta la imagen al contenedor */
            border-radius: 10px; /* Bordes redondeados */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3); /* Sombra de imagen */
        }

        .product p {
            margin: 5px 0; /* Espacio entre las líneas de texto */
        }
        .add-to-cart {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: #b8ccce;
            border-radius: 50%;
            padding: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .add-to-cart:hover {
            background-color: #538f95;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 20px;
        }

        footer p {
            margin: 10px 0;
        }

        footer a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
        }

        footer a:hover {
            color: #538f95;
        }
    </style>

    <header>
        <div class="logo">
            <a href="ClienteHome.aspx"><img src="../Images/logo.jpg" alt="Logo" class="logo" /></a>
        </div>
        <div class="header-content">
            <div class="search-container">
                <input type="text" placeholder="Buscar productos..." />
                <button type="submit">Buscar</button>
            </div>
                <div class="user-options">
                    <asp:LinkButton ID="btnIniciarSesion" runat="server" OnClick="btnIniciarSesion_Click">INICIAR SESIÓN</asp:LinkButton>
                    <asp:LinkButton ID="btnCarrito" runat="server" OnClick="btnCarrito_Click">CARRITO</asp:LinkButton>
                </div>
        </div>
    </header>

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

        <div class="products">
            <!-- Ejemplo de productos -->
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/CamisaHombre.jpg" alt="Camisa Hombre" />
                <p>Polo Regular Fit</p>
                <p>S/ 22.00 <s>S/ 24.95</s> -12%</p>
                <p>S/ 22.00 <s>S/ 24.95</s> -12%</p>
                <p>Colores disponibles: Rojo, Azul, Verde</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/PantalonHombre.jpg" alt="Pantalón Hombre" />
                <p>Pantalón Clásico</p>
                <p>S/ 40.00</p>
                <p>Colores disponibles: Negro, Caqui</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/CamisaHombre.jpg" alt="Camisa Hombre" />
                <p>Camisa de Moda</p>
                <p>S/ 22.00 <s>S/ 24.95</s> -12%</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/CardiganMujer.jpg" alt="Cardigan Mujer" />
                <p>Cardigan Suave</p>
                <p>S/ 35.00</p>
                <p>Colores disponibles: Gris, Rosa</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/PantalonMujer.jpg" alt="Pantalón Mujer" />
                <p>Pantalón Elegante</p>
                <p>S/ 45.00</p>
                <p>Colores disponibles: Azul, Negro</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/PantalonMujer.jpg" alt="Pantalón Mujer" />
                <p>Pantalón Elegante</p>
                <p>S/ 45.00</p>
                <p>Colores disponibles: Azul, Negro</p>
            </div>
            <!-- Más productos -->
        </div>
    </div>

    <footer>
        <p>&copy; 2024 RH Store. Todos los derechos reservados.</p>
        <p>
            <a href="Privacy.aspx">Política de Privacidad</a>
            <a href="Terms.aspx">Términos de Servicio</a>
            <a href="Contact.aspx">Contáctanos</a>
        </p>
    </footer>
</asp:Content>
