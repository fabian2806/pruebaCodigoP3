<%@ Page Language="C#" MasterPageFile="~/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="GestionCupones.aspx.cs" Inherits="SoftRhWeb.GestionCupones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <link href="~/Content/Site.css" rel="stylesheet" type="text/css" />

    <div class="container custom-container">
        <style>
            /* Contenedor principal */
            .custom-container {
                max-width: 900px;
                margin: 0 auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            /* Estilos para el título */
            .title {
                font-size: 28px;
                text-align: center;
                font-weight: bold;
                margin-bottom: 20px;
            }

            /* Estilos para los botones de acción */
            .action-icons {
                display: flex;
                justify-content: center;
                gap: 15px;
                margin-bottom: 10px;
            }

            .action-icons i {
                font-size: 1.5em;
                cursor: pointer;
            }

            /* Estilos para la tabla */
            .custom-table {
                width: 100%;
                border-collapse: collapse;
            }

            .custom-table th, .custom-table td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: center;
            }

            .custom-table th {
                background-color: #f0f0f0;
                font-weight: bold;
            }

            .custom-table tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            /* Estilos para el área de historial de compras y botón de generar */
            .footer-section {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-top: 20px;
                padding-top: 15px;
                border-top: 1px solid #ddd;
            }

            .footer-section .history-label {
                font-size: 14px;
                color: #555;
            }

            .footer-section button {
                padding: 8px 15px;
                font-size: 16px;
                background-color: #4a90e2;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>

        <!-- Título -->
        <div class="title">Cupones</div>

        <!-- Iconos de acción -->
        <div class="action-icons">
            <a href="RegistrarCupon.aspx">
                <i class="fa-solid fa-file"></i>
            </a>
            <a href="RegistrarCupon.aspx">
                <i class="fa-solid fa-pen"></i>
            </a>
            <i class="fa-solid fa-trash"></i>
            <i class="fa-solid fa-print " onclick="window.print();"></i>
        </div>

        <!-- Tabla de clientes -->
        <table class="custom-table">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>idCupon</th>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>fechaInicio</th>
                    <th>fechaFin</th>
                    <th>Usado</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>1</td>
                    <td>COD001</td>
                    <td>Cupon del 5% de dcto.</td>
                    <td>2024-10-10</td>
                    <td>2024-11-30</td>
                    <td>Activo</td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2</td>
                    <td>COD002</td>
                    <td>Cupon del 15% de dcto.</td>
                    <td>2024-10-10</td>
                    <td>2024-12-31</td>
                    <td>Activo</td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>3</td>
                    <td>COD003</td>
                    <td>Cupon del 20% de dcto.</td>
                    <td>2024-10-10</td>
                    <td>2024-12-31</td>
                    <td>Activo</td>
                </tr>
                <!-- Agregar más filas según sea necesario -->
            </tbody>
        </table>
    </div>
</asp:Content>
