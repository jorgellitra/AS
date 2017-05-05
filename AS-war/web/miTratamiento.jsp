<%@page import="Entity.Medicinas"%>
<%@page import="Entity.Recetas"%>
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
            
            <div id="eo">
                <table class="table table-striped" style="border: solid lightgray">
                    <thead>
                        <tr>
                            <th>Fecha de Inicio</th>
                            <th>Fecha Final</th>
                            <th>Tratamiento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        List<Recetas> lista = (List<Recetas>) request.getAttribute("recetasFiltradas");
                        List<Medicinas> listaMedicinas = (List<Medicinas>) request.getAttribute("listaMedicinas");
                        int tomar = 0;
                        for(Recetas r : lista){
                            tomar = r.getTomas() - r.getTomadas();
                            for(Medicinas m : listaMedicinas){
                                for(int i = 0; i < tomar; i++){
                                    if(r.getIdMedicinas().getId() == m.getId()){%>
                                <tr>
                                    <td><%out.print(r.getInicio());%></td>
                                    <td><%out.print(r.getFin());%></td>
                                    <td><%out.print(r.getIdMedicinas().getNombre());%></td>
                                    <td><a href="FrontController?command=Tomada&idhistorial=<%out.print(r.getIdHistorial().getId());%>&idMedicina=<%out.print(m.getId());%>"><button>Tomar</button></a></td>
                                </tr>
                                <%}
                                }
                            }
                        }   
                        %>
                    </tbody>
                </table>
                <%if(String.valueOf(request.getAttribute("tomada")).equals("1")) out.print("Pastilla tomada");%>
                <a href="FrontController?command=HistorialMedico&idespecialidad=">Volver a mi historial médico</a>
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
