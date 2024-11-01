<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="SoftRhWeb.Login" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login - SoftRhWeb</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
            margin-top: -10px;
            color: #555;
        }

        .show-password input {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="login-container">
            <!-- Contenedor del personaje con ojos -->
            <div class="character-container">
                <img src="/Images/penguin.jpg"/>
                <div class="eye left"></div>
                <div class="eye right"></div>
            </div>

            <h2>Iniciar Sesión</h2>
            <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>

            <!-- Campo de usuario -->
            <div class="input-group">
                <label for="txtUsername">Correo Electrónico</label>
                <i class="fas fa-user"></i>
                <asp:TextBox ID="txtUsername" runat="server" placeholder="email@dominio.com"></asp:TextBox>
            </div>

            <!-- Campo de contraseña -->
            <div class="input-group">
                <label for="txtPassword">Contraseña</label>
                <i class="fas fa-lock"></i>
                <asp:TextBox ID="txtPassword" runat="server" TextMode="Password" placeholder="Contraseña"></asp:TextBox>
            </div>

            <!-- Mostrar contraseña -->
            <div class="show-password">
                <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()" />
                <label for="showPassword">Mostrar contraseña</label>
            </div>

            <!-- Botón de iniciar sesión -->
            <button type="button" onclick="window.location.href='Home.aspx';">Log in</button>
        </div>
    </form>

    <script>
        // Función para mostrar/ocultar la contraseña
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById("<%= txtPassword.ClientID %>");
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
            } else {
                passwordInput.type = "password";
            }
        }

        // Movimiento de los ojos
        const eyes = document.querySelectorAll('.eye');
        document.querySelector("#<%= txtUsername.ClientID %>").addEventListener('focus', moveEyes);
        document.querySelector("#<%= txtPassword.ClientID %>").addEventListener('focus', moveEyes);
        
        function moveEyes() {
            document.addEventListener('mousemove', (event) => {
                const rect = document.querySelector('.character-container').getBoundingClientRect();
                const x = event.clientX - rect.left - rect.width / 2;
                const y = event.clientY - rect.top - rect.height / 2;

                const angle = Math.atan2(y, x);
                const eyeMoveDistance = 6; // Controla la distancia del movimiento de los ojos

                eyes.forEach(eye => {
                    eye.style.transform = `translate(${Math.cos(angle) * eyeMoveDistance}px, ${Math.sin(angle) * eyeMoveDistance}px)`;
                });
            });
        }

        // Detener el movimiento de ojos al perder el foco
        document.querySelector("#<%= txtUsername.ClientID %>").addEventListener('blur', resetEyes);
        document.querySelector("#<%= txtPassword.ClientID %>").addEventListener('blur', resetEyes);

        function resetEyes() {
            eyes.forEach(eye => {
                eye.style.transform = 'translate(0, 0)';
            });
        }
    </script>
</body>
</html>
