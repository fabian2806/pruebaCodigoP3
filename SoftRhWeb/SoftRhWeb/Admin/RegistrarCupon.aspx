﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="RegistrarCupon.aspx.cs" Inherits="SoftRhWeb.RegistrarCupon" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <link href="~/Content/Site.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <div class="container custom-container">
        <!-- Título de la página -->
        <h2 class="title">Registrar Cliente</h2>

        <!-- Formulario de registro -->
        <form class="register-form">
            <label for="codigo">CODIGO</label>
            <input type="text" id="codigo" name="codigo" placeholder="Ingrese el Codigo">

            <label for="descripcion">Descripción</label>
            <input type="text" id="descripcion" name="descripcion" placeholder="Ingrese la descripcion">

            <label for="fechaInicio">Fecha de Inicio</label>
            <input type="date" id="fechaInicio" name="fechaInicio" placeholder="Ingrese la Fecha de Inicio">

            <label for="fechaFin">Fecha de Fin</label>
            <input type="date" id="fechaFin" name="fechaFin" placeholder="Ingrese la Fecha de Fin">

            <!-- Botones de acción -->
            <div class="button-group">

                <button type="submit" class="btn-submit" onclick="redirectToGestionUsuarios(event)">
                    <i class="fas fa-save"></i> GUARDAR
                </button>
                <button type="button" class="btn-cancel" onclick="window.location.href='GestionCupones.aspx'">
                    <i class="fas fa-times"></i> CANCELAR
                </button>

                <script>
                    function redirectToGestionUsuarios(event) {
                        event.preventDefault(); // Evita el comportamiento de envío predeterminado
                        // Aquí puedes agregar código para guardar los datos si es necesario
                        window.location.href = 'GestionCupones.aspx'; // Redirige a GestionUsuarios.aspx
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
