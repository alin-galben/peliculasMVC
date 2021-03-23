<%-- 
    Document   : insert
    Created on : 23-mar-2021, 0:22:42
    Author     : alin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertar Peliculas</h1>
        <form action="ServletPeliculas?op=insert1" method="get">
        <p><label>Titulo: <input class="form-control" type="text" name="titulo" required > </label></p>
        <p><label>Genero: <input class="form-control" type="text" name="genero" required > </label></p>
        <p><label>Año de Lanzamiento: <input class="form-control" type="text" name="lanzamiento" required > </label></p>
        <input type="hidden" name="op" required value="insert2"> 
        <input type="submit" value="insertar" >       
        </form>
    </body>
</html>
