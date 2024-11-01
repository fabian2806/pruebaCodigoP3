<%@ Page Title="Registro Prendas" Language="C#" MasterPageFile="~/SoftRhWeb.Master" AutoEventWireup="true" CodeBehind="RegistroPrendas.aspx.cs" Inherits="SoftRhWeb.RegistroPrendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Registro Prendas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">

    <form runat="server">


            <div class="container">
            <div class="card">
                <div class="card-header">
                    <h2>
                        <asp:Label ID="lblTitulo" runat="server" Text="Registro de Prenda"></asp:Label>
                    </h2>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label id="lblNombre" runat="server" CssClass="col-sm-2 col-form-label" Text="Nombre de la Prenda: "></asp:Label>
                        <div class="col-sm-4">
                            <asp:TextBox id="txtNombrePrenda" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>

                    <!-- BOTONERIAS -->

                  <div class="mb-3 row">
                    <div class="col-sm-2">
                        <asp:Label id="Label1" runat="server" Text="Tipo de Prenda: " CssClass="col-form-label"></asp:Label>
                    </div>
                    <div class="col-sm-5 row"> <!-- Se agrega una fila para las columnas internas -->
                        <div class="col-6 col-md-4 centered-option"> <!-- Dividimos en columnas para alinearlos -->
                            <asp:RadioButton ID="Radio1" runat="server" GroupName="Tipo" CssClass="form-check-input" Text="" />
                            <label class="form-check-label" for="Radio1">Polo</label>
                        </div>
                        <div class="col-6 col-md-4 centered-option">
                            <asp:RadioButton ID="Radio2" runat="server" GroupName="Tipo" CssClass="form-check-input" Text="" />
                            <label class="form-check-label" for="Radio2">Pantalon</label>
                        </div>
                        <div class="col-6 col-md-4 centered-option">
                            <asp:RadioButton ID="Radio3" runat="server" GroupName="Tipo" CssClass="form-check-input" Text="" />
                            <label class="form-check-label" for="Radio3">Polera</label>
                        </div>
                        <div class="col-6 col-md-4 centered-option">
                            <asp:RadioButton ID="Radio4" runat="server" GroupName="Tipo" CssClass="form-check-input" Text="" />
                            <label class="form-check-label" for="Radio4">Camisa</label>
                        </div>
                        <div class="col-6 col-md-4 centered-option">
                            <asp:RadioButton ID="Radio5" runat="server" GroupName="Tipo" CssClass="form-check-input" Text="" />
                            <label class="form-check-label" for="Radio5">Casaca</label>
                        </div>
                    </div>
                </div>

                    <style>
                        .centered-option {
                            display: flex;
                            align-items: center;
                        }
                        .form-check-input {
                            margin-right: 8px;
                            margin-top: -5px; /* Ajuste para elevar el botón ligeramente */
                            margin-left: 0;
                            border: none;
                            outline: none;
                            box-shadow: none;
                        }
                        .form-check {
                            margin-bottom: 10px;
                            text-align: center;
                        }
                        .form-check-label {
                            margin-bottom: 0;
                        }
                    </style>


                   <div class="mb-3 row">
                        <div class="col-sm-2">
                            <asp:Label id="Label2" runat="server" Text="Talla: " CssClass="col-form-label"></asp:Label>
                        </div>
                        <div class="col-sm-6 row"> <!-- Se agrega una fila para las columnas internas -->
                            <div class="col-4 col-md-2 centered-option"> <!-- Cada opción en su propia columna -->
                                <asp:RadioButton ID="Radio6" runat="server" GroupName="Talla" CssClass="form-check-input" Text="" />
                                <label class="form-check-label" for="Radio6">XS</label>
                            </div>
                            <div class="col-4 col-md-2 centered-option">
                                <asp:RadioButton ID="Radio7" runat="server" GroupName="Talla" CssClass="form-check-input" Text="" />
                                <label class="form-check-label" for="Radio7">S</label>
                            </div>
                            <div class="col-4 col-md-2 centered-option">
                                <asp:RadioButton ID="Radio8" runat="server" GroupName="Talla" CssClass="form-check-input" Text="" />
                                <label class="form-check-label" for="Radio8">M</label>
                            </div>
                            <div class="col-4 col-md-2 centered-option">
                                <asp:RadioButton ID="Radio9" runat="server" GroupName="Talla" CssClass="form-check-input" Text="" />
                                <label class="form-check-label" for="Radio9">L</label>
                            </div>
                            <div class="col-4 col-md-2 centered-option">
                                <asp:RadioButton ID="Radio10" runat="server" GroupName="Talla" CssClass="form-check-input" Text="" />
                                <label class="form-check-label" for="Radio10">XL</label>
                            </div>
                        </div>
                </div>

                    <div class="mb-3 row">
                        <div class="col-sm-2">
                            <asp:Label id="Label3" runat="server" Text="Genero: " CssClass="col-form-label"></asp:Label>
                        </div>
                        <div class="col-sm-6 row"> <!-- Se agrega una fila para organizar las columnas internas -->
                            <div class="col-4 centered-option"> <!-- Columna para cada opción -->
                                <asp:RadioButton ID="Radio11" runat="server" GroupName="Genero" CssClass="form-check-input" />
                                <label class="form-check-label" for="Radio11">Masculino</label>
                            </div>
                            <div class="col-4 centered-option">
                                <asp:RadioButton ID="Radio12" runat="server" GroupName="Genero" CssClass="form-check-input" />
                                <label class="form-check-label" for="Radio12">Femenino</label>
                            </div>
                            <div class="col-4 centered-option">
                                <asp:RadioButton ID="Radio13" runat="server" GroupName="Genero" CssClass="form-check-input" />
                                <label class="form-check-label" for="Radio13">Unisex</label>
                            </div>
                        </div>
                    </div>



                    <div class="mb-3 row">
                        <asp:Label id="lblColor" runat="server" Text="Color: " CssClass="col-sm-2 col-form-label"></asp:Label>
                        <div class="col-sm-4">
                            <asp:TextBox id="txtColor" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
          
                    <div class="mb-3 row">
                        <asp:Label id="lblPrecio" runat="server" Text="Precio: " CssClass="col-sm-2 col-form-label"></asp:Label>
                        <div class="col-sm-4">
                            <asp:TextBox id="txtPrecio" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label id="lblStock" runat="server" Text="Stock: " CssClass="col-sm-2 col-form-label"></asp:Label>
                        <div class="col-sm-4">
                            <asp:TextBox id="txtStock" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <asp:Button id="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click"/>
                </div>
            </div>
        </div>
    </form>
</asp:Content>
