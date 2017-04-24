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
                        <%--echo "<tr>";
                        echo "<td>".$row['inicio']."</td>";
                        echo "<td>".$row['fin']."</td>";
                        $id_medicinas= $row['id_medicinas'];
                        $sqltxt="SELECT * FROM medicinas WHERE id=".$id_medicinas."";
                        $result2 = pg_query ($dbconn, $sqltxt ) or die("Error en la consulta SQL");
                        $row2 = pg_fetch_array ( $result2,0 );

                        echo "<td>".$row2['nombre']."</td>";
                        echo "CHeckBOXUS";
                        echo "<td><a href='historialMedicos.php?idespecialidad=".$_GET['idespecialidad']."'>Volver <img src='img/back.png'></a></td>";
                        echo "</tr>";--%>
                    </tbody>
                </table>
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
