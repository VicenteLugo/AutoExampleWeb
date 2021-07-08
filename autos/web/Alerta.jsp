<%-- 
    Document   : AltaAutor
    Created on : Jul 8, 2014, 8:04:10 PM
    Author     : Rodrigo Sandoval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <%
            boolean TF = (boolean) request.getAttribute("TF");
            if (TF) {
        %>
        <h1>Agregado Correctamente</h1>
        <% } else { %>
        <h1>Error al agregar</h1>
        <% }%>       
        <a href="index.jsp">Inicio</a>
    </body>
</html>
