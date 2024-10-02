<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Tienda.aspx.cs" Inherits="SoftRhWeb.Tienda" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Tienda Online - Moda</title>

    <!-- Vinculación del archivo CSS -->
    <link rel="stylesheet" type="text/css" href="Content/styles.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <!-- Contenido de la página web -->
            <header>
                <div class="logo">
                    <h1>Tienda de Ropa</h1>
                </div>
                <nav>
                    <ul>
                        <li><a href="#">Inicio</a></li>
                        <li><a href="#">Mujer</a></li>
                        <li><a href="#">Hombre</a></li>
                        <li><a href="#">Niños</a></li>
                        <li><a href="#">Accesorios</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>
                </nav>
                <div class="search-bar">
                    <input type="text" placeholder="Buscar..." />
                </div>
            </header>

            <main>
                <!-- Sección hero con la imagen otono.jpg -->
                <section class="hero">
                    <img src="Images/otono.jpg" alt="Colección Otoño/Invierno" />
                    <h2>Nueva Colección Otoño/Invierno</h2>
                    <button>Comprar ahora</button>
                </section>

                <section class="products">
                    <h2>Productos Destacados</h2>
                    <div class="product-grid">
                        <!-- Producto: Camisa -->
                        <div class="product">
                            <img src="Images/camisa.jpg" alt="Camisa Básica" />
                            <h3>Camisa Básica</h3>
                            <p>$29.99</p>
                            <button>Añadir al carrito</button>
                        </div>
                        <!-- Producto: Pantalón -->
                        <div class="product">
                            <img src="Images/pantalon.jpg" alt="Pantalón Skinny" />
                            <h3>Pantalón Skinny</h3>
                            <p>$49.99</p>
                            <button>Añadir al carrito</button>
                        </div>
                    </div>
                </section>
            </main>

            <footer>
                <p>&copy; 2024 Tienda de Ropa. Todos los derechos reservados.</p>
                <ul>
                    <li><a href="#">Términos y Condiciones</a></li>
                    <li><a href="#">Política de Privacidad</a></li>
                </ul>
            </footer>
        </div>
    </form>

    <!-- Vinculación del archivo JavaScript -->
    <script src="Content/scripts.js"></script>
</body>
</html>
