<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="CrudCupones.aspx.cs" Inherits="RHStoreWS.Admin.CrudCupones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Registrar Cupón
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                    <asp:Label ID="lblTitulo" runat="server" Text="lblTitulo"></asp:Label>
                </h2>
            </div>
            <div class="card-body pb-2">
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblIdCupon" runat="server" Text="ID:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-2">
                        <asp:TextBox ID="txtIdCupon" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblIdTrabajador" runat="server" Text="Trabajador:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-4">
                        <asp:TextBox ID="txtIdTrabajador" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                    </div>
                    <asp:LinkButton ID="lbBuscarTrabajador" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" CssClass="btn btn-primary col-sm-auto" />
                </div>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblCodigo" runat="server" Text="Código:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-4">
                        <asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblFechaInicio" runat="server" Text="Fecha Inicio:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-4">
                        <input id="dtpFechaInicio" class="form-control" type="date" runat="server" text="Fecha Inicio:" />
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblFechaFin" runat="server" Text="Fecha Fin:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-4">
                        <input id="dtpFechaFin" class="form-control" type="date" runat="server" text="Fecha Fin:" />
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-2">
                        <asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>
                    <div class="col-md-4">
                        <textarea id="txtDescripcion" runat="server" class="form-control" cols="20" rows="3"></textarea>
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click" />
                <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click" />
            </div>
        </div>
    </div>
</asp:Content>
