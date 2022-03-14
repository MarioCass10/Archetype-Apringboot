<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tienda</title>
    </head>
    <body>
        <h1>Mi Boutique</h1>

       <form action="/EditarUsuario" method="get">
            <p>Id:<input type="text" name="usuarioId"></p>
            <p>Nombre:<input type="text" name="nombre"></p>
            <p>Contraseña:<input type="text" name="password"></p>
            <p>Correo:<input type="text" name="correo"></p>
            
            <input type="submit" value="Actualizar">

        </form>
    </body>

</html>