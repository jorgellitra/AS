/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medicinas;
import Entity.Recetas;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/**
 *
 * @author Jorge daniel
 */
public class miTratamiento extends FrontCommand{
    
    RecetasFacade recetasFacade = lookupRecetasFacadeBean();
    MedicinasFacade medicinasFacade = lookupMedicinasFacadeBean();
    
    @Override
    public void proccess() {
        String idHistorial = request.getParameter("idhistorial");
        List<Recetas> recetasFiltradas = recetasFacade.adquirirRecetasHistorial(idHistorial);    
        List<Medicinas> listaMedicinas = (List<Medicinas>) medicinasFacade.findAll();
        request.setAttribute("recetasFiltradas", recetasFiltradas);
        request.setAttribute("listaMedicinas", listaMedicinas);
        try {
            forward("/miTratamiento.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MedicinasFacade lookupMedicinasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (MedicinasFacade) c.lookup("java:global/AS/AS-ejb/MedicinasFacade!Controller.MedicinasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private RecetasFacade lookupRecetasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (RecetasFacade) c.lookup("java:global/AS/AS-ejb/RecetasFacade!Controller.RecetasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
