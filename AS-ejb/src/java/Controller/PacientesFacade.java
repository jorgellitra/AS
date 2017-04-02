/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medicos;
import Entity.Pacientemedico;
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
    public List<Pacientes> buscarPorNombre(String nombre){
        try {
            return em.createQuery("SELECT x FROM Pacientes x WHERE x.nombre = :nombre", Pacientes.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    /*public List<Pacientes> comparaBusquedaAvanzado(String buscador, int idMedico, List<Pacientemedico> listaPacMed) {
        List<Pacientes> l = null;
        String algo = buscador;
        for (Pacientemedico p : listaPacMed) {
            if(buscador.equalsIgnoreCase(p.getIdPaciente().getNombre()) && p.getIdMedico().getId() == idMedico){
                String a = p.getIdPaciente().getNombre();
               l.add(new Pacientes(p.getIdPaciente().getId(),p.getIdPaciente().getNombre(),p.getIdPaciente().getApellido(),p.getIdPaciente().getGSanguineo(),p.getIdPaciente().getAlergias(),p.getIdPaciente().getDni())); 
            }
        }
        return l;
    }*/

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
