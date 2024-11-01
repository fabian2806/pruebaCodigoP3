<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="IniciarSesion.aspx.cs" Inherits="RHStoreWS.Admin.IniciarSesion" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head runat="server">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="../Content/bootstrap.css" rel="stylesheet" />
	<link href="../Content/styles.css" rel="stylesheet" />
	<link href="../Content/Fonts/css/all.css" rel="stylesheet" />

	<script src="../Scripts/bootstrap.js"></script>
	<script src="../Scripts/bootstrap.bundle.js"></script>
	<script src="../Scripts/jquery-3.7.1.js"></script>

	<title>
		Inicio de sesión
	</title>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
		<div class="card p-4" style="width: 100%; max-width: 400px;">
			<h3 class="card-title text-center mb-4">Inicio de Sesión</h3>
			<form id="formIniciarSesion" runat="server">
				<div class="form-group">
					<label for="txtCorreo">Correo electrónico</label>
					<asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" placeholder="Ingrese su correo electrónico"></asp:TextBox>
				</div>
				<div class="form-group mt-3">
					<label for="txtContrasenha">Contraseña</label>
					<asp:TextBox ID="txtContrasenha" runat="server" TextMode="Password" CssClass="form-control" placeholder="Ingrese su contraseña"></asp:TextBox>
				</div>
				<div class="text-center mt-3">
					<asp:Button ID="btnIniciarSesion" runat="server" Text="Ingresar" CssClass="btn btn-primary w-100" OnClick="btnIniciarSesion_Click" />
				</div>
			</form>
			<div class="text-center mt-3">
				<small>¿Olvidaste tu contraseña? <a href="RecuperarContrasenha.aspx">Recuperar</a></small>
			</div>
		</div>
	</div>
</body>
</html>
