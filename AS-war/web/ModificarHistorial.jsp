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
            <div class="header"><img alt="" src='images/hist.png'><form action="Login.jsp" style="text-align: right"><input type="submit" value="LogOut"></form></div>
            <form action="FrontController">
                <table class='table table-striped' style='border: solid lightgray'>
                    <tr>
                        <th><%
                            String nombreCompletoPaciente = "";
                            String idPaciente = (String) request.getAttribute("idPaciente");
                            List<Pacientes> listaPacientes = (List<Pacientes>) request.getAttribute("listaPacientes");
                            for(Pacientes p : listaPacientes){
                                if(String.valueOf(p.getId()).equals(idPaciente)){
                                    nombreCompletoPaciente = p.getNombre() + " " + p.getApellido();
                                }
                            }
                            List<Historial> historial = (List<Historial>) request.getAttribute("historial");
                            for(Historial h : historial){
                                if(String.valueOf(h.getIdPacientemedico().getIdPaciente().getId()).equals(idPaciente)){
                                %> Historia del paciente con id: <% out.print(nombreCompletoPaciente); %> realizada en <% out.print(h.getFecha()); %><a href='HistorialPacientes.jsp'>Volver a la vista anterior </a></th>
                                </tr>
                                    <tr>
                                        <th>Síntomas</th>
                                        <td><textarea name='sintomas' > <% out.print(h.getSintomas()); %> </textarea></td>
                                    </tr>
                                    <tr>
                                        <th colspan=2>
                                            <input type='submit' value='Guardar cambios'>
                                        </th>
                                    </tr>			
                                </table>
                            <% }
                            }
                            %>
                <input type="hidden" name="id" value="" />
                <input type="hidden" name="command" value="Modificado" />
            </form>
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
