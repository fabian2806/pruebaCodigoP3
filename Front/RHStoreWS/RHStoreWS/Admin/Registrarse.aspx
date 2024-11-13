<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Registrarse.aspx.cs" Inherits="RHStoreWS.Admin.Registrarse" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <link href="../Content/styles.css" rel="stylesheet" />
    <link href="../Content/Fonts/css/all.css" rel="stylesheet" />
    <script src="../Scripts/bootstrap.js"></script>
    <script src="../Scripts/jquery-3.7.1.js"></script>

    <style>
        body {
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url('../Images/LoginFondo.png') no-repeat center center fixed;
            background-size: cover;
        }

        .container {
            width: 400px;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .form-group label {
            font-weight: bold;
            color: #555;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .btn-12,
        .btn-12 *,
        .btn-12 :after,
        .btn-12 :before,
        .btn-12:after,
        .btn-12:before {
            border: 0 solid;
            box-sizing: border-box;
        }

        .btn-12 {
            -webkit-tap-highlight-color: transparent;
            -webkit-appearance: button;
            background-color: #000;
            color: #fff;
            cursor: pointer;
            font-family: ui-sans-serif, system-ui, -apple-system, BlinkMacSystemFont,
                Segoe UI, Roboto, Helvetica Neue, Arial, Noto Sans, sans-serif,
                Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol, Noto Color Emoji;
            font-size: 100%;
            font-weight: 900;
            line-height: 1.5;
            margin: 0;
            -webkit-mask-image: -webkit-radial-gradient(#000, #fff);
            padding: 0;
            text-transform: uppercase;
        }

        .btn-12:disabled {
            cursor: default;
        }

        .btn-12:-moz-focusring {
            outline: auto;
        }

        .btn-12 svg {
            display: block;
            vertical-align: middle;
        }

        .btn-12 [hidden] {
            display: none;
        }

        .btn-12 {
            border-radius: 99rem;
            border-width: 2px;
            overflow: hidden;
            padding: 0.8rem 3rem;
            position: relative;
        }

        .btn-12 span {
            mix-blend-mode: difference;
        }

        .btn-12:after,
        .btn-12:before {
            background: linear-gradient(
                90deg,
                #fff 25%,
                transparent 0,
                transparent 50%,
                #fff 0,
                #fff 75%,
                transparent 0
            );
            content: "";
            inset: 0;
            position: absolute;
            transform: translateY(var(--progress, 100%));
            transition: transform 0.2s ease;
        }

        .btn-12:after {
            --progress: -100%;
            background: linear-gradient(
                90deg,
                transparent 0,
                transparent 25%,
                #fff 0,
                #fff 50%,
                transparent 0,
                transparent 75%,
                #fff 0
            );
            z-index: -1;
        }

        .btn-12:hover:after,
        .btn-12:hover:before {
            --progress: 0;
        }

        .btn-12:hover {
            background-color: #333;
        }

        .text-danger {
            color: red;
            font-weight: bold;
        }
    </style>

    <title>Registrarse</title>
</head>
<body>
    <div class="container">
        <h3>Registro de Cliente</h3>
        <form id="formRegistrarse" runat="server">
            <div class="form-group">
                <label for="txtDNI">DNI</label>
                <asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" placeholder="Ingrese su DNI" />
            </div>
            <div class="form-group">
                <label for="txtNombres">Nombres</label>
                <asp:TextBox ID="txtNombres" runat="server" CssClass="form-control" placeholder="Ingrese sus nombres" />
            </div>
            <div class="form-group">
                <label for="txtApellidos">Apellidos</label>
                <asp:TextBox ID="txtApellidos" runat="server" CssClass="form-control" placeholder="Ingrese sus apellidos" />
            </div>
            <div class="form-group">
                <label for="txtCorreo">Correo</label>
                <asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" placeholder="Ingrese su correo" />
                <asp:Label ID="lblErrorCorreo" runat="server" Text="El correo no tiene un formato válido" CssClass="text-danger" Visible="false" />
            </div>
            <div class="form-group">
                <label for="txtContrasenha">Contraseña</label>
                <asp:TextBox ID="txtContrasenha" runat="server" CssClass="form-control" TextMode="Password" placeholder="Ingrese su contraseña" />
            </div>
            <div class="form-group">
                <label for="txtConfirmarContrasenha">Confirmar Contraseña</label>
                <asp:TextBox ID="txtConfirmarContrasenha" runat="server" CssClass="form-control" TextMode="Password" placeholder="Confirme su contraseña" />
                <asp:Label ID="lblErrorContrasenhas" runat="server" Text="Las contraseñas no coinciden" CssClass="text-danger" Visible="false" />
            </div>
            <div class="form-group">
                <label for="txtTelefono">Teléfono</label>
                <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" placeholder="Ingrese su teléfono" />
            </div>
            <div class="form-group">
                <label>¿Recibe promociones?</label><br />
                <asp:RadioButton ID="rbSi" runat="server" GroupName="Promociones" Text="Sí" />
                <asp:RadioButton ID="rbNo" runat="server" GroupName="Promociones" Text="No" Checked="True" />
            </div>
            <div class="text-center mt-4">
                <!-- Botón HTML con la clase de animación -->
                <button type="button" class="btn-12" onclick="document.getElementById('<%= btnRegistrarse.ClientID %>').click();">
                    <span>Registrarse</span>
                </button>
                <!-- Botón de servidor ASP.NET oculto -->
                <asp:Button ID="btnRegistrarse" runat="server" CssClass="d-none" OnClick="btnRegistrarse_Click" />
            </div>
        </form>
    </div>
</body>
</html>
