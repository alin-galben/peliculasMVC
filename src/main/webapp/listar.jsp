<%-- 
    Document   : listar
    Created on : 23-mar-2021, 0:26:53
    Author     : alin1
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Peliculas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h1>Listado de Peliculas</h1>
        <% List<Peliculas> misPeliculas = (List<Peliculas>) request.getAttribute("misPeliculas");
        %>
        <table class="table table-hover">
            <tr><th>id</th><th>Titulo</th><td>Genero</td><td>Fecha de Lanzamiento</td><td>Borrar</td><td>Actualizar</td></tr>
            <% for( Peliculas p: misPeliculas) { 
            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletPeliculas?op=borrar&id="+p.getId()+"'><i class='far fa-trash-alt'></i></a>";
            String cadenaActualizar = "<a href='ServletPeliculas?op=update1&id="+p.getId()+"'><i class='far fa-edit'></i></a>";
             %>
            <tr>
                <td><%=p.getId()%></td><td><%=p.getTitulo() %></td><td><%=p.getGenero() %></td>
                <td><%=p.getGenero() %></td><td><%=p.getFecha() %></td><td><%=cadenaBorrar%></td><td><%=cadenaActualizar%></td>
        
            </tr>    
            
            <% } %>
        </table>
    
</html>
