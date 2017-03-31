/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class Modificado extends FrontCommand {
    @Override
    public void proccess() {
        /*HistorialFacade historialFacade = lookupHistorialFacadeBean();
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String sintomas = request.getParameter("sintomas");
        boolean cambiado = historialFacade.update(Integer.parseInt(id),sintomas);
        if(cambiado){
            session.setAttribute("id", id);
            session.setAttribute("sintomas", sintomas);*/
            try {
                forward("/ModificarHistorial.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
    }

    private HistorialFacade lookupHistorialFacadeBean() {
        try {
            Context c = new InitialContext();
            return (HistorialFacade) c.lookup("java:global/AS/AS-ejb/HistorialFacade!Controller.HistorialFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}