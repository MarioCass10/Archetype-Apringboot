<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tienda</title>
    </head>
    <body>
        <h1>Mi Boutique</h1>

       <form action="/NuevoUsuario" method="get">
            <p>nombre:<input type="text" name="nombre"></p>
            <p>password:<input type="password" name="contrasena"></p>
            <p>rol<input type="text" name="id_Rol"></p>
            <p>correo<input type="email" name="correo"></p>

            <input type="submit" value="Enviar">

        </form>
    </body>

</html>