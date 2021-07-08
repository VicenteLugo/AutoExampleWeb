<%-- 
    Document   : AutoC
    Created on : 21-ago-2014, 0:33:24
    Author     : LugoD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" id="tabla1" class="table table-responsive table-striped table-bordered">
                <!-- column headers -->
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Modelo</th>
                        <th>Marca</th>                        
                        <th>Actualizar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="datos" items="${auto}" >
                        <tr>
                            <td><c:out value="${datos.nombre}"/> </td>
                            <td><c:out value="${datos.modelo}"/> </td>
                            <td><c:out value="${datos.marca}"/> </td>                            
                            <td><a class="btn btn-primary" href="ActualizarAuto?codigo=${datos.clave}&op=enviar"  method="post">Modificar</a></td>
                            <td><a class="btn btn-primary" href="EliminarAuto?codigo=${datos.clave}"  method="post">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </body>
</html>

