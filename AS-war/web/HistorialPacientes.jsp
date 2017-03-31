<%-- 
    Document   : Seleccionado
    Created on : 20-mar-2017, 9:36:54
    Author     : entrar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Historial Médico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/style.css" type="text/css">

    </head>
    <body>
        <div class="contenido-body">
            <div class="header"><img alt="" src='images/hist.png'><form action="login.jsp" style="text-align: right"><input type="submit" value="LogOut"></form></div>
        <p>Datos:</p>
        <p>     Nombre: Ana García</p>
        <p>     Teléfono: 989 93 49 49</p>
        <p>     Fecha de nacimiento: 10/10/2010</p>
        <p>Historial:</p>
        <p>10/10/1998</p>
        <textarea id="Historial">El paciente sufre de colicos renales y blablabla</textarea>
        <p>Tratamiento:</p>
        <form action="FrontController">
            Modificar tratamiento: <input type="submit" name="Modificar" value="">
            <input type="hidden" name="command" value="ModificarHistorial" />
        </form>
        <p>Ibuprofeno</p><input type="checkbox" name="Ibuprofeno" value="Ibuprofeno"><br>
        <p>Paracetamol</p><input type="checkbox" name="Paracetamol" value="Paracetamol"><br>
        <p>Diazepan</p><input type="checkbox" name="Diazepan" value="Diazepan"><br>
        </div>
        
        <div class="footer">
            <ul class="footer-ul">
                <li>Aviso Legal</li>
                <li>Cookies</li>
                <li>Política de privacidad</li>
                <li>Contacto</li>
            </ul>
        </div>
    </body>
</html>
