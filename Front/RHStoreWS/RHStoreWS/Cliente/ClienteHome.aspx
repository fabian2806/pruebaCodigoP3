<%@ Page Title="Inicio" Language="C#" MasterPageFile="~/Cliente/Cliente.master" AutoEventWireup="true" CodeBehind="ClienteHome.aspx.cs" Inherits="RHStoreWS.Cliente.ClienteHome" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-image: url('../Images/fondo.jpg');
            background-size: cover;
            background-position: center;
            height: 400px;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            justify-content: flex-start;
            color: white;
            position: relative;
        }

        .logo {
            position: absolute;
            left: 20px;
            top: 20px;
            width: 150px;
        }

        .nav-container {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-top: 100px;
            margin-left: 120px;
        }

        nav {
            display: flex;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            transition: color 0.3s;
        }

        nav a:hover {
            color: #538f95;
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
            color: white;
            text-decoration: none;
            margin-left: 20px;
        }

        .user-options a:hover {
            color: #538f95;
        }

        .products {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 40px 0;
            width: 100%;
        }

        .product-category {
            display: flex;
            justify-content: space-around;
            margin-bottom: 40px;
            width: 100%;
        }

        .product {
            position: relative;
            text-align: center;
        }

        .product img {
            width: 200px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        .add-to-cart {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: rgba(255, 255, 255, 0.8);
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
        <div class="nav-container">
            <nav>
                <ul>
                    <li><asp:LinkButton ID="btnInicio" runat="server" OnClick="btnInicio_Click">INICIO</asp:LinkButton></li>
                    <li><asp:LinkButton ID="btnHombre" runat="server" OnClick="btnHombre_Click">HOMBRE</asp:LinkButton></li>
                    <li><asp:LinkButton ID="btnMujer" runat="server" OnClick="btnMujer_Click">MUJER</asp:LinkButton></li>
                    <li><asp:LinkButton ID="btnUnisex" runat="server" OnClick="btnUnisex_Click">UNISEX</asp:LinkButton></li>
                </ul>
            </nav>
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

    <!-- Sección de Productos -->
    <div class="products">
        <div class="product-category">
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/CamisaHombre.jpg" alt="Camisa Hombre" />
                <p>Polo Regular Fit</p>
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
        </div>
        <div class="product-category">
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
        </div>
        <div class="product-category">
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/CamisaHombre.jpg" alt="Camisa Hombre" />
                <p>Camisa de Moda</p>
                <p>S/ 22.00 <s>S/ 24.95</s> -12%</p>
                <p>Colores disponibles: Rojo, Azul, Verde</p>
            </div>
            <div class="product">
                <div class="add-to-cart">
                    <i class="fas fa-plus"></i> <!-- Icono de agregar al carrito -->
                </div>
                <img src="../Images/PantalonMujer.jpg" alt="Pantalón Mujer" />
                <p>Pantalón Moderno</p>
                <p>S/ 45.00</p>
                <p>Colores disponibles: Negro, Caqui</p>
            </div>
        </div>
    </div>

    <!-- Pie de página -->
    <footer>
        <p>&copy; 2024 RH Store. Todos los derechos reservados.</p>
        <p>
            <a href="Privacy.aspx">Política de Privacidad</a>
            <a href="Terms.aspx">Términos de Servicio</a>
            <a href="Contact.aspx">Contáctanos</a>
        </p>
    </footer>
</asp:Content>
