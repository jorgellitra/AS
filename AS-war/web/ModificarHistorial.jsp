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
                <form action="Login.jsp" style="text-align: right">
                    <input type="submit" value="LogOut">
                </form>
            </div>
            <%String relacion = String.valueOf(request.getAttribute("relacionado"));
            List<Historial> historial = (List<Historial>) request.getAttribute("historial");
            Historial hist = null;
            for(Historial h : historial){
                if(String.valueOf(h.getIdPacientemedico().getId()).equals(relacion)){
                    hist = h;
                }
            }%>
            <div>
                <form action="FrontController">
                    <table class='table table-striped' style='border: solid lightgray'>
                        <tr>Historial del paciente <% out.print(hist.getIdPacientes().getNombre() + " " + hist.getIdPacientes().getApellido()); %>realizada el <% out.print(hist.getFecha());%>
                        </tr>
                        <tr>
                            <td>Síntomas</td>
                            <td><textarea rows="4" cols="50" name='sintomas' > <% out.print(hist.getSintomas()); %> </textarea></td>
                        </tr>
                        <tr>
                            <th colspan=2>
                                <input type='submit' value='Guardar cambios'>
                                <input type="hidden" name="command" value="Modificado" />
                                <input type="hidden" name="id" value="<% out.print(hist.getId()); %>"/>
                            </th>
                        </tr>
                    </table><a href="FrontController?command=LoggedMedico&Buscador="> Volver a la vista anterior </a>
                </form>
            </div>
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
