/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
 * @author entrar
 */
public class LoggedMedico extends FrontCommand{
    
    PacientesFacade pacientesFacade = lookupPacientesFacadeBean();
    
    @Override
    public void proccess() {
        String b = request.getParameter("Buscador");
        boolean encontrado = pacientesFacade.comparaBusqueda(b);
        if(encontrado){
            List<Pacientes> listaPacientes = (List<Pacientes>) pacientesFacade.findAll();
            request.setAttribute("b", b);
            request.setAttribute("listaPacientes", listaPacientes);
            try {
                forward("/LoggedMedico.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoggedMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
}
