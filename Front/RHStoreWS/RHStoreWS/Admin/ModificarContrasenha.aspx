<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ModificarContrasenha.aspx.cs" Inherits="RHStoreWS.Admin.ModificarContrasenha" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Modificar Contraseña</title>

    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <link href="../Content/styles.css" rel="stylesheet" />
    <link href="../Content/Fonts/css/all.css" rel="stylesheet" />

    <script src="../Scripts/bootstrap.js"></script>
    <script src="../Scripts/bootstrap.bundle.js"></script>
    <script src="../Scripts/jquery-3.7.1.js"></script>

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

        .container {
            width: 350px;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            position: relative;
        }

        .container h3 {
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            position: relative;
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
            font-size: 14px;
            box-sizing: border-box;
        }

        .btn-primary {
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

        .btn-primary:hover {
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
    <div class="container">
        <h3>Modificar Contraseña</h3>
        <form id="formModificarContrasenha" action="ModificarContrasenhaHandler" method="post">
            <div class="form-group">
                <label for="txtNuevaContrasenha">Nueva Contraseña</label>
                <input type="password" id="txtNuevaContrasenha" name="nuevaContrasenha" class="form-control" placeholder="Ingrese su nueva contraseña" />
            </div>
            <div class="form-group">
                <label for="txtConfirmarContrasenha">Confirmar Contraseña</label>
                <input type="password" id="txtConfirmarContrasenha" name="confirmarContrasenha" class="form-control" placeholder="Confirme su nueva contraseña" />
            </div>
            <!-- Mostrar contraseña -->
            <div class="show-password">
                <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()" />
                <label for="showPassword">Mostrar contraseña</label>
            </div>
            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary">Cambiar Contraseña</button>
            </div>
        </form>
    </div>

    <script>
        function togglePasswordVisibility() {
            var passwordFields = [document.getElementById('txtNuevaContrasenha'), document.getElementById('txtConfirmarContrasenha')];
            passwordFields.forEach(function (field) {
                field.type = field.type === 'password' ? 'text' : 'password';
            });
        }
    </script>
</body>
</html>
