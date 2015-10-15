<%@ Page Language="C#" AutoEventWireup="true" CodeFile="MapGenerator.aspx.cs" Inherits="MapGenerator" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="frmMapGenerator" runat="server">
    <div>
        
        <asp:Label ID="lblHeading" runat="server" style="z-index: 1; left: 217px; top: 15px; position: absolute; height: 17px; width: 99px" Text="Map Generator"></asp:Label>
        
    </div>
        <asp:Label ID="lblAddress" runat="server" style="z-index: 1; left: 15px; top: 57px; position: absolute; height: 21px; width: 60px" Text="Address: "></asp:Label>
        <asp:TextBox ID="txtAddress" runat="server" style="z-index: 1; left: 83px; top: 56px; position: absolute; width: 347px; height: 15px"></asp:TextBox>
        <asp:Button ID="btnGetMap" runat="server" OnClick="btnGetMap_Click" style="z-index: 1; left: 228px; top: 102px; position: absolute" Text="Get Map" />
        <asp:ImageMap ID="imgMap" runat="server" Height="320px" style="z-index: 1; left: 20px; top: 146px; position: absolute" Width="540px">
        </asp:ImageMap>
        <asp:Label ID="lblURL" runat="server" style="z-index: 1; left: 23px; top: 485px; position: absolute"></asp:Label>
    </form>
</body>
</html>
