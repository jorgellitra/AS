<%-- 
    Document   : Buscador
    Created on : 20-mar-2017, 9:26:01
    Author     : entrar
--%>
<%@page import="Entity.Pacientemedico"%>
<%@page import="Entity.Pacientes"%>
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
                <img alt="" src='images/hist.png'><form action="login.jsp" style="text-align: right"><input type="submit" name="Login" value="LogOut"></form>
            </div>
            <form action="FrontController" style="text-align: center">
                Búsqueda: <input type="text" name="Buscador"  placeholder="Ej: Ana Placido" value="">
                <input type="hidden" name="command" value="LoggedMedico">
                <input type="submit" value="Buscar">
            </form><br>
<div style="text-align: center">
    <h2> Mis Pacientes </h2>
    <%
                
                if(request.getAttribute("b") != null){
                    String idMedico = String.valueOf(session.getAttribute("idMedico"));
                    List<Pacientemedico> pm = (List<Pacientemedico>) request.getAttribute("listaPacMed");
                    List<Pacientes> pacienteBuscado = (List<Pacientes>) request.getAttribute("listaPacientesEncontrados");
                    for(Pacientemedico p : pm){
                        for (Pacientes pEncontrados : pacienteBuscado) {
                            if(pEncontrados.getNombre().equalsIgnoreCase(p.getIdPaciente().getNombre()) && String.valueOf(p.getIdMedico().getId()).equals(idMedico)){
                            %>
                            <table style="border: solid lightgray">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>Grupo sanguíneo</th>
                                        <th>Alergias</th>
                                        <th>Historial</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><% out.print(p.getIdPaciente().getNombre());%></td>
                                        <td><% out.print(p.getIdPaciente().getApellido()); %></td>
                                        <td><% out.print(p.getIdPaciente().getGSanguineo()); %></td>
                                        <td><% out.print(p.getIdPaciente().getAlergias()); %></td>
                                        <td><a href='FrontController?command=ModificarHistorial&idpaciente=<% out.print(p.getIdPaciente().getId()); %>'>Ver historial</a></td>
                                    </tr>
                                </tbody>
                            </table>
                    <%
                            }
                        }
                    }
                }else{
                    String idMedico = String.valueOf(session.getAttribute("idMedico"));
                    List<Pacientemedico> listaPacMed = (List<Pacientemedico>) request.getAttribute("pacientemedico");
                    for (Pacientemedico pm : listaPacMed) {
                        if(String.valueOf(pm.getIdMedico().getId()).equals(idMedico)){
                            out.print(pm.getIdPaciente().getNombre() + " " + pm.getIdPaciente().getApellido());%><br><%
                        }
                    }
            }

            %>
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
