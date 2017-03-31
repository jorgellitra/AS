<%-- 
    Document   : Buscador
    Created on : 20-mar-2017, 9:26:01
    Author     : entrar
--%>
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
            <% if(request.getAttribute("b") != null){
                List<Pacientes> listaPacientes = (List<Pacientes>) request.getAttribute("listaPacientes"); 
                String pacienteBuscado = (String) request.getAttribute("b");
                for(Pacientes p : listaPacientes){
                    if(pacienteBuscado.equalsIgnoreCase(p.getNombre())){
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
                                    <td><% out.print(p.getNombre());%></td>
                                    <td><% out.print(p.getApellido()); %></td>
                                    <td><% out.print(p.getGSanguineo()); %></td>
                                    <td><% out.print(p.getAlergias()); %></td>
                                    <td><a href='FrontController?command=ModificarHistorial&idpaciente=<% out.print(p.getId()); %>'>Ver historial</a></td>
                                </tr>
                            </tbody>
                        </table>
                    <%}
                }
            }
            // busqueda avanzada para nombre iguales
            /*
            if(request.getParameter("buscador") != null){
                List<Pacientes> listaPacientes = (List<Pacientes>) request.getAttribute("listaPacientes");
                ArrayList<String> encontrados = (ArrayList<String>) request.getAttribute("encontrados");
                for(Pacientes p : listaPacientes){
                    for(int i = 0; i < encontrados.size(); i++){
                        if(encontrados.get(i).equalsIgnoreCase(p.getNombre())){
                            out.print("El paciente buscado es: " + p.getNombre());
                        }
                    }
                }
            }
            */
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
