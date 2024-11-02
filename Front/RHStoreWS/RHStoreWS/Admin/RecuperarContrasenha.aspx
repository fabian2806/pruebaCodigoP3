<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecuperarContrasenha.aspx.cs" Inherits="RHStoreWS.Admin.RecuperarContrasenha" %>

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
		Recuperación de contraseña
	</title>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
		<div class="card p-4" style="width: 100%; max-width: 500px;">
			<h3 class="card-title text-center mb-4">Recuperación de Contraseña</h3>
			<form id="formRecuperarContrasenha" runat="server">
				<div class="form-group">
					<label for="txtCorreo">Correo electrónico</label>
					<asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" placeholder="Ingrese su correo electrónico"></asp:TextBox>
				</div>
				<div class="text-center mt-3">
					<asp:Button ID="btnRecuperarContrasenha" runat="server" Text="Recuperar" CssClass="btn btn-primary w-100" OnClick="btnRecuperarContrasenha_Click" />
				</div>
			</form>
			<div class="text-center mt-3">
				<small><a href="IniciarSesion.aspx">Volver al inicio de sesión</a></small>
			</div>
		</div>
	</div>
</body>
</html>
