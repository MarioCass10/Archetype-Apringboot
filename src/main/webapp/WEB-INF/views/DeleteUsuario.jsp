<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tienda</title>
    </head>
    <body>
        <h1>Mi Boutique</h1>

       <form action="/EliminarUsuarioPorId" method="get">
            <p>Id Usuario: <input type="text" name="usuario" size="20"></p>
            
            <input type="submit" value="Eliminar">

        </form>
    </body>

</html>