<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="Perfil.aspx.cs" Inherits="RHStoreWS.Admin.Perfil" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Perfil
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphNombreUsuario" runat="server">
	<asp:Label ID="lblNombreUsuario" runat="server" Text="Nombre de usuario" />
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container mt-4">
		<style>
			.form-group {
				margin-bottom: 1rem;
			}

			.bg-light {
				background-color: #f8f9fa !important;
			}

			.edit-button {
				width: 16px;
				height: 16px;
				margin-right: 5px;
				vertical-align: middle;
				cursor: pointer;
			}

			.edit-text {
				color: #007bff;
				cursor: pointer;
			}

			.edit-button img {
				width: 16px;
				height: 16px;
				margin-right: 5px;
			}

			.container {
				margin-bottom: 20px; /* Espacio entre contenedores */
			}

			.section {
				background-color: #f8f9fa; /* Color de fondo para visualización */
				border: 1px solid #ced4da; /* Borde alrededor de las secciones */
				border-radius: 0.25rem; /* Bordes redondeados */
				padding: 20px; /* Espaciado interno */
			}

			.full-width {
				width: 100%; /* Ancho completo para Datos Personales */
			}

			.half-width {
				flex: 1; /* Ocupa el mismo espacio */
				min-width: 300px; /* Ancho mínimo para cada sección */
			}

			.row {
				display: flex; /* Permitir alineación en fila */
				gap: 20px; /* Espacio entre las dos secciones inferiores */
			}

			.row {
				display: flex; /* Permitir alineación en fila */
				justify-content: space-between; /* Espaciado entre columnas */
				gap: 20px; /* Espacio entre columnas */
			}

			.form-group {
				flex: 1; /* Cada campo ocupará el mismo espacio */
				min-width: 200px; /* Ancho mínimo para evitar que se compacte demasiado */
			}

			.password-container {
				position: relative; /* Posición relativa para el ícono */
			}

			.password-container i {
				position: absolute; /* Posiciona el ícono dentro del contenedor */
				right: 10px;
				top: 35%; /* Ajusta según sea necesario para centrar verticalmente */
				cursor: pointer;
			}

			.text-end {
				margin-top: 10px; /* Adjust this value as needed to move the button up or down */
			}
		</style>


		<div class="container">
			<div class="card">
				<div class="card-header">
					<h3>Datos Personales</h3>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="form-group">
							<asp:Label ID="lblID" runat="server" Text="ID" />
							<asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" />
						</div>

						<div class="form-group">
							<asp:Label ID="lblDNI" runat="server" Text="DNI" />
							<asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" Enabled="false" />
						</div>

						<div class="form-group">
							<asp:Label ID="lblNombres" runat="server" Text="Nombres" />
							<asp:TextBox ID="txtNombres" runat="server" CssClass="form-control" Enabled="false" />
						</div>

						<div class="form-group">
							<asp:Label ID="lblApellidos" runat="server" Text="Apellidos" />
							<asp:TextBox ID="txtApellidos" runat="server" CssClass="form-control" Enabled="false" />
						</div>
					</div>
				</div>
				<div class="card-footer">
					<asp:LinkButton ID="lbEditar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i> Editar" CssClass="float-end btn btn-primary" OnClick="lbEditar_Click" />
					<asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary me-1" OnClick="lbGuardar_Click" Visible="false" />
				</div>
			</div>
		</div>

		<div class="container">
			<div class="card">
				<div class="card-header">
					<h3>Credenciales y Datos Laborales</h3>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-md-6 form-group">
							<div class="card">
								<div class="card-header">
									<h4>Credenciales</h4>
								</div>
								<div class="card-body mb-5">
									<div class="form-group">
										<asp:Label ID="lblCorreo" runat="server" Text="Correo electrónico" />
										<asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" Enabled="false" />
									</div>

									<div class="form-group">
										<asp:Label ID="lblContrasenha" runat="server" Text="Contraseña" />
										<asp:TextBox ID="txtContrasenha" runat="server" CssClass="form-control" Enabled="false" />
									</div>
								</div>
								<div class="card-footer">
									<asp:LinkButton ID="lbCambiarContrasenha" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i> Cambiar contraseña" CssClass="float-end btn btn-primary me-1" OnClick="lbCambiarContrasenha_Click" />
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h4>Datos Personales</h4>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-6 form-group">
											<asp:Label ID="lblFechaCreacion" runat="server" Text="Fecha de creación" />
											<asp:TextBox ID="txtFechaCreacion" runat="server" CssClass="form-control" Enabled="false" />
										</div>
										<div class="col-md-6 form-group">
											<asp:Label ID="lblFechaIngreso" runat="server" Text="Fecha de ingreso" />
											<asp:TextBox ID="txtFechaIngreso" runat="server" CssClass="form-control" Enabled="false" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 form-group">
											<asp:Label ID="lblPuesto" runat="server" Text="Puesto" />
											<asp:TextBox ID="txtPuesto" runat="server" CssClass="form-control" Enabled="false"/>
										</div>
										<div class="col-md-6 form-group">
											<asp:Label ID="lblSueldo" runat="server" Text="Sueldo" />
											<asp:TextBox ID="txtSueldo" runat="server" CssClass="form-control" Enabled="false"/>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 form-group">
											<asp:Label ID="lblHorarioInicio" runat="server" Text="Inicio de horario" />
											<asp:TextBox ID="txtHorarioInicio" runat="server" CssClass="form-control" Enabled="false" />
										</div>
										<div class="col-md-6 form-group">
											<asp:Label ID="lblHorarioFin" runat="server" Text="Fin de horario" />
											<asp:TextBox ID="txtHorarioFin" runat="server" CssClass="form-control" Enabled="false" />
										</div>
									</div>
								</div>
								<div class="card-footer mb-2">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer mb-2">
				</div>
			</div>
		</div>
	</div>
</asp:Content>
