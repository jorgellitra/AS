<%@page import="Entity.Especialidades"%>
<%@page import="java.util.List"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
            <div class="header"><img alt="" src='images/hist.png'><a href="Login.jsp"><button>Log out</button></a>
            </div>
            <h2> CONECTADO </h2>

            <div style="center">
                <div style="text-align: left"><h3>Especialidades</h3>
                    <form>
                        <%
                            List<Especialidades> list = (List<Especialidades>) request.getAttribute("especialidades");
                            for(Especialidades e : list){
                                %><a href="FrontController?command=HistorialMedico&especialidad=<% out.print(e.getNombre()); %>"><% out.print(e.getNombre()); %></a><br><%
                            }
                        %>
                    </form>
                </div>
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