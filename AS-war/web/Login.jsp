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
        
        <div class="header"><img alt="" src='images/hist.png'></div>
        <div style="text-align: center">
            <form action="FrontController">
                DNI: <input type="text" placeholder="DNI" name="dni" value="" /><br>
                Contraseña: <input type="password" placeholder="Contraseña" name="clave" value="" /><br>
                <input type="hidden" name="command" value="Log" />
                <input type="submit" value="Conectarse" />
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
