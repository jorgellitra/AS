/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Especialidades;
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
public class HistorialMedico extends FrontCommand{

    HistorialFacade historialFacade = lookupHistorialFacadeBean();
    MedicosFacade medicosFacade = lookupMedicosFacadeBean();
    EspecialidadesFacade especialidadesFacade = lookupEspecialidadesFacadeBean();
    PacientemedicoFacade pacientemedicoFacade = lookupPacientemedicoFacadeBean();
    PacientesFacade pacientesFacade = lookupPacientesFacadeBean();
    
    @Override
    public void proccess() {
        HttpSession session = request.getSession();
        int idSession = (int) session.getAttribute("idPaciente");
        String idEspecialidad = request.getParameter("idEspecialidad");
        List<Pacientes> listaPacientes = pacientesFacade.findAll();
        List<Historial> Historial = historialFacade.findAll();
        List<Pacientemedico> listaPacientemedico = pacientemedicoFacade.findAll();
        List<Medicos> listaMedicos = medicosFacade.findAll();
        List<Especialidades> listaEspecialidades = especialidadesFacade.findAll();
        int idRelacion = comprobarRelacion(listaMedicos, listaEspecialidades, idSession, listaPacientemedico, idEspecialidad);
        try {
            request.setAttribute("idRelacion", idRelacion);
            request.setAttribute("Historial", Historial);
            request.setAttribute("listaPacientes", listaPacientes);
            forward("/HistorialMedico.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int comprobarRelacion(List<Medicos>lm, List<Especialidades> le, int id, List<Pacientemedico> pacmed, String idEspecialidad) {
        int relacionado = -1;
        for (Medicos m : lm){
            for (Especialidades e : le) {
                if(e.getId() == Integer.parseInt(idEspecialidad) && e.getId().equals(m.getEspecialidad().getId())){
                    for (Pacientemedico pm : pacmed) {
                        if(pm.getIdPaciente().getId() == id && pm.getIdMedico().getId().equals(m.getId())){
                            relacionado = pm.getId();
                        }
                    }
                }
            }
        }
        return relacionado;
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

    private PacientemedicoFacade lookupPacientemedicoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PacientemedicoFacade) c.lookup("java:global/AS/AS-ejb/PacientemedicoFacade!Controller.PacientemedicoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EspecialidadesFacade lookupEspecialidadesFacadeBean() {
        try {
            Context c = new InitialContext();
            return (EspecialidadesFacade) c.lookup("java:global/AS/AS-ejb/EspecialidadesFacade!Controller.EspecialidadesFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MedicosFacade lookupMedicosFacadeBean() {
        try {
            Context c = new InitialContext();
            return (MedicosFacade) c.lookup("java:global/AS/AS-ejb/MedicosFacade!Controller.MedicosFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
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
}
