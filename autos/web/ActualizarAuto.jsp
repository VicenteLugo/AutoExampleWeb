<%-- 
    Document   : ActualizarAuto
    Created on : 21-ago-2014, 0:27:28
    Author     : LugoD
--%>

<%@page import="Bean.AutoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        AutoBean bean = (AutoBean) request.getAttribute("auto");
        %>
        <%=bean.getNombre() %>
         <form action="ActualizarAuto" method="get" accept-charset="ISO-8859-1">
            <div class="container">
                <div class="row col-lg-4">
                    <input hidden="" name="id" value="<%=bean.getClave()%>" />
                    <input hidden="" name="op" value="Modificar" />
                    <div class="form-group">
                        <label for="NombreA">Nombre:</label>
                        <input type="text" required="" class="form-control" value="<%=bean.getNombre() %>" name="Nombre">
                    </div>
                    <div class="form-group">
                        <label for="Modelo">Modelo:</label>
                        <input type="text" class="form-control" value="<%=bean.getModelo()%>" id="Modelo" name="Modelo">
                    </div>
                    <div class="form-group">
                        <label for="Marca">Marca:</label>
                        <input type="text" class="form-control" value="<%=bean.getMarca() %>" id="marca" name="Marca">
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
        </form>
    </body>
</html>

