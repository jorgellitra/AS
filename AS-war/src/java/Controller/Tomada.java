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
 * @author Usuario
 */
public class Tomada extends FrontCommand{

    MedicinasFacade medicinasFacade = lookupMedicinasFacadeBean();
    
    RecetasFacade recetasFacade = lookupRecetasFacadeBean();
    
    @Override
    public void proccess() {
        
        String idhistorial = request.getParameter("idhistorial");
        String idMedicina = request.getParameter("idMedicina");
        List<Medicinas> listaMedicinas = (List<Medicinas>) medicinasFacade.findAll();
        List<Recetas> listaRecetas = (List<Recetas>) recetasFacade.adquirirRecetasHistorial(idhistorial);
        int tomada = 0;
        for(Recetas r : listaRecetas){
            for(Medicinas m : listaMedicinas){
                if(r.getIdMedicinas().getId().equals(m.getId()) && m.getId() == Integer.parseInt(idMedicina)){
                    tomada = recetasFacade.aumentarTomadas(r.getId());
                    //tomada = recetasFacade.updateTomadas(r.getId());
                }
            }
        }
        List<Recetas> listaRecetas2 = (List<Recetas>) recetasFacade.adquirirRecetasHistorial(idhistorial);
        try {
            request.setAttribute("tomada", tomada);
            request.setAttribute("recetasFiltradas", listaRecetas2);
            request.setAttribute("listaMedicinas", listaMedicinas);
            forward("/miTratamiento.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, ex);
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

    private MedicinasFacade lookupMedicinasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (MedicinasFacade) c.lookup("java:global/AS/AS-ejb/MedicinasFacade!Controller.MedicinasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
