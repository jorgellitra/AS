/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medicos;
import Entity.Pacientes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class PacientesFacade extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "AS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }

    public boolean comparaBusqueda(String buscador) {
        boolean estado = false;
        List<Pacientes> listaPacientes = findAll();
        for (Pacientes listaPaciente : listaPacientes) {
            if(buscador.equalsIgnoreCase(listaPaciente.getNombre())){
               estado = true;
            }
        }
        return estado;
    }
    
    public ArrayList<String> comparaBusquedaAvanzado(String buscador) {
        ArrayList<String> encontrados = new ArrayList();
        List<Pacientes> listaPacientes = (List<Pacientes>) findAll();
        for (Pacientes listaPaciente : listaPacientes) {
            if(buscador.equalsIgnoreCase(listaPaciente.getNombre())){
               encontrados.add(listaPaciente.getNombre());
            }
        }
        return encontrados;
    }

    public int obtenerID(String dni) {
        List<Pacientes> listaPacientes = (List<Pacientes>)findAll();
        for (Pacientes l : listaPacientes) {
            if (l.getDni() == (Integer.parseInt(dni))) {
                return l.getId();
            }
        }
        return -1;
    }

}
