/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Especialidades;
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
public class LoggedPacientes extends FrontCommand{

    EspecialidadesFacade especialidadesFacade = lookupEspecialidadesFacadeBean();
    
    @Override
    public void proccess() {
        
        List<Especialidades> especialidades = (List<Especialidades>) especialidadesFacade.findAll();
        request.setAttribute("especialidades", especialidades);
        try {
            forward("/LoggedPacientes.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
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

}
