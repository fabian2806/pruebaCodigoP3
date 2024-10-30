<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="SoftRhWeb.Login" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login - SoftRhWeb</title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="width: 300px; margin: auto; padding-top: 100px;">
            <h2>Iniciar Sesión</h2>
            <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
            <div>
                <asp:Label ID="lblUsername" runat="server" Text="Usuario:" AssociatedControlID="txtUsername"></asp:Label>
                <asp:TextBox ID="txtUsername" runat="server"></asp:TextBox>
            </div>
            <div style="margin-top: 10px;">
                <asp:Label ID="lblPassword" runat="server" Text="Contraseña:" AssociatedControlID="txtPassword"></asp:Label>
                <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
            </div>
            <div style="margin-top: 20px;">
                <asp:Button ID="btnLogin" runat="server" Text="Ingresar" OnClick="btnLogin_Click" />
            </div>
        </div>
    </form>
</body>
</html>