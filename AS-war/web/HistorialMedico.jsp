<%-- 
    Document   : Seleccionado
    Created on : 20-mar-2017, 9:36:54
    Author     : entrar
--%>

<%@page import="Entity.Pacientes"%>
<%@page import="Entity.Historial"%>
<%@page import="java.util.List"%>
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
            <div class="header">
                <img alt="" src='images/hist.png'>
                <form action="login.jsp" style="text-align: right">
                    <input type="submit" value="LogOut">
                </form>
            </div>
            <%String relacion = String.valueOf(request.getAttribute("idRelacion"));
            List<Historial> historial = (List<Historial>) request.getAttribute("Historial");
            for(Historial h : historial){
                if(String.valueOf(h.getIdPacientemedico().getId()).equals(relacion)){%>
                <table class='table table-striped' style='border: solid lightgray'>
                    <tr style="text-align: center">
                        <td>Historial con el medico <%out.print(h.getIdPacientemedico().getIdMedico().getNombre() + " " + h.getIdPacientemedico().getIdMedico().getApellidos()); %> realizada el <%out.print(h.getFecha());%></td>
                    </tr>
                    <tr>
                        <td>Síntomas</td>
                        <td><%out.print(h.getSintomas()); %></td>
                        <td><a href="FrontController?command=miTratamiento&idhistorial=<%out.print(h.getId());%>"> Ver mi tratamiento </a></td>
                    </tr>
                </table>
                <%}
            }%>
        </div><a href="FrontController?command=LoggedPacientes"> Volver a la vista anterior </a>  
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
