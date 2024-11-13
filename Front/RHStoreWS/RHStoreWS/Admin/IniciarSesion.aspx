<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="IniciarSesion.aspx.cs" Inherits="RHStoreWS.Admin.IniciarSesion" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!-- Importación de la fuente Roboto -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">

    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <link href="../Content/styles.css" rel="stylesheet" />
    <link href="../Content/Fonts/css/all.css" rel="stylesheet" />

    <script src="../Scripts/bootstrap.js"></script>
    <script src="../Scripts/bootstrap.bundle.js"></script>
    <script src="../Scripts/jquery-3.7.1.js"></script>

    <style>
        body {
            font-family: 'Roboto', sans-serif; /* Fuente principal */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url('../Images/LoginFondo.png') no-repeat center center fixed;
            background-size: cover;
        }

        .login-container {
            width: 350px;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            position: relative;
        }

        .login-container h2,
        .login-container label,
        .login-container small {
            color: #333;
            margin-bottom: 15px;
            font-weight: 500;
            letter-spacing: 0.5px;
        }

        .character-container {
            position: relative;
            width: 120px;
            height: 120px;
            margin: 0 auto 20px;
        }

        .character-container img {
            width: 100%;
            height: auto;
            display: block;
            margin: 0 auto;
        }

        .eye {
            position: absolute;
            width: 8px;
            height: 8px;
            background-color: #333;
            border-radius: 50%;
            top: 48px;
        }

        .eye.left {
            left: 44px;
        }

        .eye.right {
            right: 44px;
        }

        .input-group {
            position: relative;
            margin-bottom: 20px;
            text-align: left;
        }

        .input-group label {
            font-weight: 400; /* Reducción del grosor */
            color: #555;
            font-size: 14px;
        }

        .input-group input[type="text"], .input-group input[type="password"] {
            width: 100%;
            padding: 10px;
            padding-left: 35px;
            margin-top: 5px;
            border: 1px solid #555;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif; /* Aplica la fuente */
        }

        .input-group input[type="text"]:focus, .input-group input[type="password"]:focus {
            border-color: #888;
            outline: none;
            box-shadow: 0 0 5px rgba(136, 136, 136, 0.5);
        }

        .input-group i {
            position: absolute;
            left: 10px;
            top: 37px;
            font-size: 18px;
            color: #999;
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

        .show-password {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            margin-top: 10px;
            color: #555;
            font-size: 14px;
            font-weight: 400;
        }

        .show-password input {
            margin-right: 5px;
        }
    </style>

    <title>
        Inicio de sesión
    </title>
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="card p-4" style="width: 100%; max-width: 400px;">
            <h3 class="card-title text-center mb-4">Inicio de Sesión</h3>
            <form id="formIniciarSesion" runat="server">
                <div class="character-container">
                    <img src="../Images/pengui.png" alt="Penguin Image" />
                    <div class="eye left"></div>
                    <div class="eye right"></div>
                </div>
                <div class="form-group">
                    <label for="txtCorreo">Correo electrónico</label>
                    <asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" placeholder="Ingrese su correo electrónico" />
                </div>
                <div class="form-group mt-3">
                    <label for="txtContrasenha">Contraseña</label>
                    <asp:TextBox ID="txtContrasenha" runat="server" TextMode="Password" CssClass="form-control" placeholder="Ingrese su contraseña" />
                </div>

                <!-- Mostrar contraseña -->
                <div class="show-password">
                    <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()" />
                    <label for="showPassword">Mostrar contraseña</label>
                </div>

                <!-- Mensaje de error -->
                <asp:Label ID="lblError" runat="server" Text="Correo electrónico o contraseña inválidos" CssClass="text-danger" Visible="false" Style="color: red; font-weight: bold;" />

                <div class="text-center mt-3">
                    <!-- Botón HTML con la clase de animación -->
                    <button type="button" class="btn-12" onclick="document.getElementById('<%= btnIniciarSesion.ClientID %>').click();">
                        <span>Ingresar</span>
                    </button>
                    <!-- Botón de servidor ASP.NET oculto -->
                    <asp:Button ID="btnIniciarSesion" runat="server" CssClass="d-none" OnClick="btnIniciarSesion_Click" />
                </div>

            </form>
            <div class="text-center mt-3">
                <small><a href="Registrarse.aspx">Regístrate</a></small>
            </div>
            <div class="text-center mt-3">
                <small>¿Olvidaste tu contraseña? <a href="RecuperarContrasenha.aspx">Recuperar</a></small>
            </div>
        </div>
    </div>

    <script>
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById("<%= txtContrasenha.ClientID %>");
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
            } else {
                passwordInput.type = "password";
            }
        }

        const eyes = document.querySelectorAll('.eye');
        document.querySelector("#<%= txtCorreo.ClientID %>").addEventListener('focus', moveEyes);
        document.querySelector("#<%= txtContrasenha.ClientID %>").addEventListener('focus', moveEyes);

        function moveEyes() {
            document.addEventListener('mousemove', (event) => {
                const rect = document.querySelector('.character-container').getBoundingClientRect();
                const x = event.clientX - rect.left - rect.width / 2;
                const y = event.clientY - rect.top - rect.height / 2;

                const angle = Math.atan2(y, x);
                const eyeMoveDistance = 6;

                eyes.forEach(eye => {
                    eye.style.transform = `translate(${Math.cos(angle) * eyeMoveDistance}px, ${Math.sin(angle) * eyeMoveDistance}px)`;
                });
            });
        }

        document.querySelector("#<%= txtCorreo.ClientID %>").addEventListener('blur', resetEyes);
        document.querySelector("#<%= txtContrasenha.ClientID %>").addEventListener('blur', resetEyes);

        function resetEyes() {
            eyes.forEach(eye => {
                eye.style.transform = 'translate(0, 0)';
            });
        }
    </script>
</body>
</html>
