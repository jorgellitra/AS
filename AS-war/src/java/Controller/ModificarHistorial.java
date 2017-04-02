/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Historial;
import Entity.Medicos;
import Entity.Pacientemedico;
import Entity.Pacientes;
import java.io.IOException;
import java.util.List;
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
public class ModificarHistorial extends FrontCommand{
    
    PacientesFacade pacientesFacade = lookupPacientesFacadeBean();
    HistorialFacade historialFacade = lookupHistorialFacadeBean();
    PacientemedicoFacade pacientemedicoFacade = lookupPacientemedicoFacadeBean();
    
    @Override
    public void proccess() {
        List<Historial> historial = (List<Historial>) historialFacade.findAll();
        List<Pacientemedico> pacmed = (List<Pacientemedico>) pacientemedicoFacade.findAll();
        List<Pacientes> listaPacientes = (List<Pacientes>) pacientesFacade.findAll();
        
        HttpSession session = request.getSession();
        String idPaciente = request.getParameter("idpaciente");
        int idMedico = (int) session.getAttribute("idMedico");
        boolean relacionado = comprobarRelacion(idPaciente,pacmed,idMedico);
        if(relacionado){
            try {
                request.setAttribute("idPaciente", idPaciente);
                request.setAttribute("listaPacientes", listaPacientes);
                request.setAttribute("historial", historial);
                forward("/ModificarHistorial.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    private PacientesFacade lookupPacientesFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PacientesFacade) c.lookup("java:global/AS/AS-ejb/PacientesFacade!Controller.PacientesFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private boolean comprobarRelacion(String id, List<Pacientemedico> pacmed, int idMedico) {
        boolean relacionado = false;
        for (Pacientemedico pm : pacmed) {
            if(pm.getIdPaciente().getId() == Integer.parseInt(id) && pm.getIdMedico().getId() == idMedico){
                relacionado = true;
            }
        }
        return relacionado;
    }

    private PacientemedicoFacade lookupPacientemedicoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PacientemedicoFacade) c.lookup("java:global/AS/AS-ejb/PacientemedicoFacade!Controller.PacientemedicoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}