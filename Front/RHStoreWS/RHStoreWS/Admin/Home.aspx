<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="RHStoreWS.Admin.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Inicio
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphNombreUsuario" runat="server">
	<asp:Label ID="lblNombreUsuario" runat="server" Text="Nombre de usuario" />
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container">
		<style>
			/* Estilos para la sección de bienvenida */
			.welcome-section {
				background-color: #fff6f8;
				border-radius: 12px;
				padding: 20px;
				margin-bottom: 20px;
				box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
				display: flex;
				align-items: center;
				justify-content: center;
				font-family: Arial, sans-serif;
			}

			.welcome-text h1 {
				font-size: 28px;
				color: #333;
				font-weight: bold;
				margin: 0;
			}

			.welcome-text span {
				color: #4a90e2;
			}

			.welcome-image {
				width: 80px;
				height: auto;
				margin-left: 20px;
			}

			/* Contenedor principal para organizar las secciones en columnas */
			.main-content {
				display: flex;
				gap: 20px;
				margin-top: 20px;
			}

			/* Contenedor de los recuadros de información (izquierda) */
			.info-sections {
				display: flex;
				flex-direction: column;
				gap: 20px;
				flex: 1;
			}

			/* Contenedor del gráfico (derecha) */
			.chart-section {
				flex: 2;
			}

			/* Estilos para cada recuadro */
			.content-box {
				background-color: #fff;
				border-radius: 8px;
				padding: 20px;
				box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
				font-family: Arial, sans-serif;
			}

			.content-box h3 {
				font-size: 22px;
				color: #4a90e2;
				margin-bottom: 15px;
			}

			/* Lista de estadísticas dentro de los recuadros */
			.stats-list {
				list-style-type: none;
				padding-left: 0;
				margin: 0;
			}

			.stat-item {
				font-size: 16px;
				color: #333;
			}
		</style>

		<!-- Mensaje de bienvenida -->
		<div class="welcome-section">
			<div class="welcome-text">
				<h1>
					Bienvenido al sistema de administración de RH Store
				</h1>
			</div>
			<img src="../Images/Paw.gif" class="welcome-image" alt="Imagen de bienvenida" />
		</div>

		<!-- Contenedor principal con dos columnas -->
		<div class="main-content">
			<!-- Columna izquierda: Recuadros de información -->
			<div class="info-sections">
				<!-- Primer recuadro: Accesos Recientes -->
				<div class="content-box">
					<h3>Accesos Rápidos</h3>
					<ul style="list-style: none; padding: 0;">
						<li><a href="CrudPrendas.aspx">Registrar Prendas</a></li>
						<li><a href="CrudPromociones.aspx">Registrar Promociones</a></li>
						<li><a href="CrudCupones.aspx">Registrar Cupones</a></li>
						<li><a href="CrudClientes.aspx">Registrar Clientes</a></li>
						<li><a href="CrudTrabajadores.aspx">Registrar Trabajadores</a></li>
						<li><a href="GestionarOrdenes.aspx">Visualizar Ordenes de Venta</a></li>
					</ul>
				</div>

				<!-- Segundo recuadro: Estadísticas de Accesos Recientes -->
				<div class="content-box">
					<h3>Valores Actuales</h3>
					<ul class="stats-list">
						<li>
							<asp:Label ID="lblPrendas" runat="server" Text="Total Prendas: 72" CssClass="stat-item" />
						</li>
						<li>
							<asp:Label ID="lblPromociones" runat="server" Text="Promociones Activas: 2" CssClass="stat-item" />
						</li>
						<li>
							<asp:Label ID="lblCupones" runat="server" Text="Cupones Activos: 2" CssClass="stat-item" />
						</li>
					</ul>
				</div>

				<!-- Tercer recuadro: Stock de Productos -->
				<div class="content-box">
					<h3>Stock de Productos</h3>
					<ul class="stats-list">
						<li>
							<asp:Label ID="Label1" runat="server" Text="Polo Never Surrender: 10" CssClass="stat-item" />
						</li>
						<li>
							<asp:Label ID="Label2" runat="server" Text="Polera RH Team: 15" CssClass="stat-item" />
						</li>
						<li>
							<asp:Label ID="Label3" runat="server" Text="Casaca motera: 12" CssClass="stat-item" />
						</li>
						<li>
							<asp:Label ID="Label4" runat="server" Text="Pantalon rasgado: 35" CssClass="stat-item" />
						</li>
					</ul>
				</div>
			</div>

			<!-- Columna derecha: Gráfico estadístico -->
			<div class="chart-section">
				<div class="content-box">
					<h3>Gráfico Estadístico</h3>
					<img src="../Images/grafica.jpg" alt="Gráfico de ejemplo" class="chart-image">
				</div>
			</div>
		</div>

		<style>
			/* Estilo para la imagen del gráfico */
			.chart-image {
				width: 100%;
				max-width: 500px; /* Ajusta el tamaño máximo según sea necesario */
				height: auto;
				display: block;
				margin: 0 auto; /* Centra la imagen en su contenedor */
			}
		</style>
	</div>
</asp:Content>
