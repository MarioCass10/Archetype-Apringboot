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

       <form action="/EditarProducto" method="get">
            <p>Id:<input type="text" name="productoId"></p>
            <p>Producto:<input type="text" name="productoNombre"></p>
            <p>Precio:<input type="number" name="productoPrecio"></p>
            
            <input type="submit" value="Actualizar">

        </form>
    </body>

</html>