<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudOrdenes.aspx.cs" Inherits="RHStoreWS.Admin.CrudOrdenes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Registro o Modificación de Orden de Venta
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <!-- Scripts de Bootstrap para el modal -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphNombreUsuario" runat="server">
	<asp:Label ID="lblNombreUsuario" runat="server" Text="Nombre de usuario" />
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <asp:Label ID="lblTitulo" runat="server" Text="lblTitulo"></asp:Label>
                </h2>
            </div>
            <div class="card-body pb-2">
                <div class="row">
                    <!-- Primera columna -->
                    <div class="col-md-6">
                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblIdOrden" runat="server" Text="ID:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <asp:TextBox ID="txtIdOrden" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblIdCliente" runat="server" Text="Cliente:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8 d-flex">
                                <asp:TextBox ID="txtIdCliente" runat="server" CssClass="form-control flex-grow-1 me-2" Enabled="false"></asp:TextBox>
                                <asp:LinkButton ID="lbBuscarCliente" runat="server" CssClass="btn btn-primary d-flex align-items-center" data-bs-toggle="modal" data-bs-target="#modalSeleccionCliente">
                                    <i class="fa-solid fa-magnifying-glass me-1"></i>Buscar
                                </asp:LinkButton>
                            </div>
                        </div>
                        
                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblFechaRegistro" runat="server" Text="Fecha Registro:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <input id="dtpFechaRegistro" class="form-control" type="date" runat="server" text="Fecha Registro:" />
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblFechaProcesado" runat="server" Text="Fecha Procesado:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <input id="dtpFechaProcesado" class="form-control" type="date" runat="server" text="Fecha Procesado:" />
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblFechaEntregado" runat="server" Text="Fecha Entregado:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <input id="dtpFechaEntregado" class="form-control" type="date" runat="server" text="Fecha Entregado:" />
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblFechaAnulado" runat="server" Text="Fecha Anulado:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <input id="dtpFechaAnulado" class="form-control" type="date" runat="server" text="Fecha Anulado:" />
                            </div>
                        </div>
                    </div>

                    <!-- Segunda columna -->
                    <div class="col-md-6">
                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblEstado" runat="server" Text="Estado:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <div class="form-control">
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input id="rbRegistrado" class="form-check-input" type="radio" runat="server" name="estado" />
                                                <label id="lblRegistrado" class="form-check-label" for="cphContenido_rbRegistrado">Registrado</label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input id="rbProcesado" class="form-check-input" type="radio" runat="server" name="estado" />
                                                <label id="lblProcesado" class="form-check-label" for="cphContenido_rbProcesado">Procesado</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input id="rbEntregado" class="form-check-input" type="radio" runat="server" name="estado" />
                                                <label id="lblEntregado" class="form-check-label" for="cphContenido_rbEntregado">Entregado</label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input id="rbAnulado" class="form-check-input" type="radio" runat="server" name="estado" />
                                                <label id="lblAnulado" class="form-check-label" for="cphContenido_rbAnulado">Anulado</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblDni" runat="server" Text="DNI:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <asp:TextBox ID="txtDniNew" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblCorreo" runat="server" Text="Correo:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <asp:TextBox ID="txtCorreoNew" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <asp:Label ID="lblSubtotal" runat="server" Text="Subtotal:" CssClass="col-form-label fw-bold"></asp:Label>
                            </div>
                            <div class="col-md-8">
                                <asp:TextBox ID="txtSubtotalNew" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click" />
                <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click" />
            </div>
        </div>
    </div>

    <!-- Modal para selección de cliente -->
    <div class="modal fade" id="modalSeleccionCliente" tabindex="-1" aria-labelledby="modalSeleccionClienteLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalSeleccionClienteLabel">Seleccionar Cliente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:GridView ID="gvClientes" runat="server" CssClass="table table-striped" AutoGenerateColumns="false" OnRowCommand="gvClientes_RowCommand">
                        <Columns>
                            <asp:BoundField DataField="idUsuario" HeaderText="ID" />
                            <asp:BoundField DataField="dni" HeaderText="DNI" />
                            <asp:BoundField DataField="nombres" HeaderText="Nombre" />
                            <asp:BoundField DataField="apellidos" HeaderText="Apellido" />
                            <asp:ButtonField Text="Seleccionar" ButtonType="Button" CommandName="SeleccionarCliente" />
                        </Columns>
                    </asp:GridView>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
