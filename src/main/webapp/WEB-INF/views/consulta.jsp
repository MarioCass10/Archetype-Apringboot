<%@ page import="com.immune.tienda.entity.Usuario" %>
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
        
                <%
                    Integer intUsuarios = (Integer) request.getAttribute("intUsuarios");
                    String stringBienvenida = (String) request.getAttribute("stringBienvenida");
                    String nombre = (String) request.getAttribute("nombre");
                    Usuario usuario = (Usuario) request.getAttribute("usuario");
                    Iterable<Usuario> usuarios = (Iterable<Usuario>) request.getAttribute("usuarios");

                    Iterable<Producto> productos = (Iterable<Producto>) request.getAttribute("productos");
                %>

                

        <p><%=stringBienvenida%></p>

        <table class="tabla">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
            </tr>
            
            <%
                for (Usuario usuarioo : usuarios){
                    %>
                    <tr>
                    <th><p><%=usuarioo.getId()%></p></th> 
                    <th><p><%=usuarioo.getNombre()%></p></th>
                    <th><p><%=usuarioo.getCorreo()%></p></th> 
                    <th><p><%=usuarioo.getId_rol()%></p></th> 
                    </tr>
                <%
                }
                %> 
        </table>

        <h2>Productos</h2>

        <table class="tabla">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
            
            <%
                for (Producto pro : productos){
                    %>
                    <tr>
                    <th><p><%=pro.getId()%></p></th> 
                    <th><p><%=pro.getNombre()%></p></th>
                    <th><p><%=pro.getPrecio()%></p></th> 
                    </tr>
                <%
                }
                %> 
        </table>

        <h2> CRUD Productos </h2>
        <a href = "/CrearProducto">Crear Producto</a>
        <a href = "/Eliminar">Eliminar producto</a>
        <a href = "/Actualizar">Actualizar producto</a> 

        <h2> CRUD Usuarios </h2>
        <a href = "/CrearUsuario">Crear Usuario</a>
        <a href = "/EliminarUsuario">Eliminar Usuario</a>
        <a href = "/ActualizarUsuario">Actualizar Usuario</a> 
    </body>

</html>