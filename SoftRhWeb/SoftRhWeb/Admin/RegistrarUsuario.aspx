<%@ Page Language="C#" MasterPageFile="~/Admin/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="RegistrarUsuario.aspx.cs" Inherits="SoftRhWeb.RegistrarUsuario" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <link href="~/Content/Site.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <div class="container custom-container">
        <!-- Título de la página -->
        <h2 class="title">Registrar Cliente</h2>

        <!-- Formulario de registro -->
        <form class="register-form" runat="server">
            <label for="dni">DNI</label>
        <asp:TextBox ID="txtDNI" runat="server" CssClass="input-text" Placeholder="Ingrese el DNI"></asp:TextBox>

        <label for="nombres">Nombres</label>
        <asp:TextBox ID="txtNombres" runat="server" CssClass="input-text" Placeholder="Ingrese los nombres"></asp:TextBox>

        <label for="apellidos">Apellidos</label>
        <asp:TextBox ID="txtApellidos" runat="server" CssClass="input-text" Placeholder="Ingrese los apellidos"></asp:TextBox>

        <label for="correo">Correo</label>
        <asp:TextBox ID="txtCorreo" runat="server" CssClass="input-text" TextMode="Email" Placeholder="Ingrese el correo electrónico"></asp:TextBox>

        <label for="contrasena">Contraseña</label>
        <asp:TextBox ID="txtContrasena" runat="server" CssClass="input-text" TextMode="Password" Placeholder="Ingrese la contraseña"></asp:TextBox>

            <!-- Botones de acción -->
            <div class="button-group">
                <asp:LinkButton ID="lbGuardar" class="btn-submit" runat="server" OnClick="lbGuardar_Click"><i class="fas fa-save"></i>GUARDAR</asp:LinkButton>
                <button type="button" class="btn-cancel" onclick="window.location.href='GestionUsuarios.aspx'">
                    <i class="fas fa-times"></i> CANCELAR
                </button>

                <script>
                    function redirectToGestionUsuarios(event) {
                        event.preventDefault(); // Evita el comportamiento de envío predeterminado
                        // Aquí puedes agregar código para guardar los datos si es necesario
                        window.location.href = 'GestionUsuarios.aspx'; // Redirige a GestionUsuarios.aspx
                    }
                </script>
            </div>
        </form>
    </div>

    <!-- Estilos adicionales -->
    <style>
        .custom-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .title {
            font-size: 24px;
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
            color: #333;
        }

        .register-form label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #555;
        }

        .register-form input[type="text"],
        .register-form input[type="email"],
        .register-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .btn-submit, .btn-cancel {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 10px 15px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 48%;
        }

        .btn-submit {
            background-color: #28a745;
            color: white;
        }

        .btn-submit:hover {
            background-color: #218838;
        }

        .btn-cancel {
            background-color: #dc3545;
            color: white;
        }

        .btn-cancel:hover {
            background-color: #c82333;
        }

        .btn-submit i, .btn-cancel i {
            margin-right: 5px;
        }
    </style>
</asp:Content>

