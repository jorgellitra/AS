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
public class ModificarHistorial extends FrontCommand{

    MedicosFacade medicosFacade = lookupMedicosFacadeBean();
    EspecialidadesFacade especialidadesFacade = lookupEspecialidadesFacadeBean();
    PacientesFacade pacientesFacade = lookupPacientesFacadeBean();
    HistorialFacade historialFacade = lookupHistorialFacadeBean();
    PacientemedicoFacade pacientemedicoFacade = lookupPacientemedicoFacadeBean();
    
    @Override
    public void proccess() {
        List<Historial> historial = (List<Historial>) historialFacade.findAll();
        List<Pacientemedico> pacmed = (List<Pacientemedico>) pacientemedicoFacade.findAll();
        List<Medicos> listaMedicos = (List<Medicos>) medicosFacade.findAll();
        List<Especialidades> listaEspecialidades = (List<Especialidades>) especialidadesFacade.findAll();
        
        HttpSession session = request.getSession();
        int idMedico = (int) session.getAttribute("idMedico");
        String idPaciente = request.getParameter("idpaciente");
        String relacionado = String.valueOf(comprobarRelacion(listaMedicos,listaEspecialidades,idPaciente,pacmed,idMedico));
        try {
            request.setAttribute("historial", historial);
            request.setAttribute("relacionado", relacionado);
            forward("/ModificarHistorial.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
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

    private int comprobarRelacion(List<Medicos>lm, List<Especialidades> le, String idPaciente, List<Pacientemedico> pacmed, int idMedico) {
        int relacionado = -1;
        for (Pacientemedico pm : pacmed) {
            if(pm.getIdPaciente().getId() == Integer.parseInt(idPaciente) && pm.getIdMedico().getId() == idMedico ){
                relacionado = pm.getId();
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

}