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
	<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background: linear-gradient(135deg, #6dd5ed, #2193b0);
    }

    .login-container {
        width: 350px;
        background-color: #ffffff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        text-align: center;
        position: relative;
    }

    /* Contenedor del personaje */
    .character-container {
        position: relative;
        width: 80px;
        height: 80px;
        margin: 0 auto 20px;
    }

    .character-container img {
        width: 100%;
    }

    /* Ojos del personaje */
    .eye {
        position: absolute;
        width: 8px;
        height: 8px;
        background-color: #333;
        border-radius: 50%;
        top: 28px;
    }

    .eye.left {
        left: 20px;
    }

    .eye.right {
        right: 20px;
    }

    .login-container h2 {
        color: #333;
        margin-bottom: 20px;
    }

    .input-group {
        position: relative;
        margin-bottom: 20px;
        text-align: left;
    }

    .input-group label {
        font-weight: bold;
        color: #555;
    }

    .input-group input[type="text"], .input-group input[type="password"] {
        width: 100%;
        padding: 10px;
        padding-left: 35px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
    }

    .input-group i {
        position: absolute;
        left: 10px;
        top: 37px;
        font-size: 18px;
        color: #999;
    }

    .login-container button {
        width: 100%;
        padding: 10px;
        background-color: #2193b0;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .login-container button:hover {
        background-color: #1e87a5;
    }

    .show-password {
        display: flex;
        align-items: center;
        justify-content: flex-start;
        margin-top: 10px;
        color: #555;
    }
    .show-password input {
        margin-right: 5px;
    }
</style>
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
