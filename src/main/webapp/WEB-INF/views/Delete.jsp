<%@ page import="com.immune.tienda.entity.Producto" %>
<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tienda</title>
    </head>
    <body>
        <h1>Mi Boutique</h1>

       <form action="/EliminarPorId" method="get">
            <p>Id Producto: <input type="text" name="producto" size="20"></p>
            
            <input type="submit" value="Eliminar">

        </form>
    </body>

</html>