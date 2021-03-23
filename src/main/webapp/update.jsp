<%-- 
    Document   : update
    Created on : 23-mar-2021, 0:30:49
    Author     : alin1
--%>

<%@page import="modelo.Peliculas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualiza Pelicula</h1>
        <% 
        Peliculas miPelicula = ( Peliculas ) request.getAttribute("miPelicula");
        String mensaje = ( String ) request.getAttribute("mensaje");
        String cadena="";
        if ( mensaje!=null ) {
           cadena="<h2 id='mensaje' class='alert alert-success'>Pelicula actualizada</h2>";
        }
        %>
        <%=cadena%>
        <form action="ServletProductos" method="get">
         <p><label>Titulo: <input  oninput="borraMensaje()" class="form-control" value="<%=miPelicula.getTitulo()%>" type="text" name="titulo" required > </label></p>
        <p><label>Genero: <input  oninput="borraMensaje()" class="form-control" value="${miPelicula.genero}" type="text" name="genero" required > </label></p>
        <p><label>Año de lanzamiento: <input   oninput="borraMensaje()"  class="form-control"  value="${miPelicula.lanzamiento}" type="text" name="lanzamiento" required > </label></p>
        <input type="hidden" name="op" required value="update2"> 
        <input type="submit" value="Actualizar" >       
        </form>
        <script>
            function borraMensaje(){
                document.getElementById("mensaje").style.display ="none";
            }
            
        </script>
    </body>
</html>
