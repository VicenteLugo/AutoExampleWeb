<%-- 
    Document   : AltaAuto
    Created on : 21-ago-2014, 0:35:51
    Author     : LugoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AltaAuto" method="get" accept-charset="ISO-8859-1">
            <div class="container">
                <div class="row col-lg-4">
                    <div class="form-group">
                        <label for="NombreA">Nombre:</label>
                        <input type="text" required="" class="form-control" placeholder="Ingresa Nombre" id="NombreA" name="Nombre">
                    </div>
                    <div class="form-group">
                        <label for="Modelo">Modelo:</label>
                        <input type="text" class="form-control" placeholder="Ingresa Modelo " id="Modelo" name="Modelo">
                    </div>
                    <div class="form-group">
                        <label for="Marca">Marca:</label>
                        <input type="text" class="form-control" placeholder="Ingresa Marca" id="marca" name="Marca">
                    </div>
                </div>                
            </div>
            <button type="submit" class="btn btn-primary">Insertar</button>
        </form>
    </body>
</html>

