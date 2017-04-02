/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Especialidades;
import Entity.Login;
import Entity.Medicos;
import Entity.Pacientes;
import java.io.IOException;
import java.util.ArrayList;
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
public class Log extends FrontCommand {

    MedicosFacade medicosFacade = lookupMedicosFacadeBean();
    LoginFacade loginFacade = lookupLoginFacadeBean();
    EspecialidadesFacade especialidadesFacade = lookupEspecialidadesFacadeBean();
    PacientesFacade pacientesFacade = lookupPacientesFacadeBean();
    
    @Override
    public void proccess() {
        
        List<Pacientes> pacientes = (List<Pacientes>) pacientesFacade.findAll();
        List<Especialidades> especialidades = (List<Especialidades>) especialidadesFacade.findAll();
        
        HttpSession session = request.getSession();
        String dni = request.getParameter("dni");
        String clave = request.getParameter("clave");
        String estado = loginFacade.validarUser(dni,clave);
        
        if(estado.equals("paciente")){
            int idPaciente = pacientesFacade.obtenerID(dni);
            session.setAttribute("idPaciente", idPaciente);
            request.setAttribute("especialidades", especialidades);
            try {
                forward("/LoggedPacientes.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            int idMedico = medicosFacade.obtenerID(dni);
            session.setAttribute("idMedico", idMedico);
            request.setAttribute("pacientes", pacientes);
            try {
                forward("/LoggedMedico.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private LoginFacade lookupLoginFacadeBean() {
        try {
            Context c = new InitialContext();
            return (LoginFacade) c.lookup("java:global/AS/AS-ejb/LoginFacade!Controller.LoginFacade");
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

    private PacientesFacade lookupPacientesFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PacientesFacade) c.lookup("java:global/AS/AS-ejb/PacientesFacade!Controller.PacientesFacade");
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