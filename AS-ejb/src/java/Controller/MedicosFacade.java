/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medicos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class MedicosFacade extends AbstractFacade<Medicos> {

    @PersistenceContext(unitName = "AS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicosFacade() {
        super(Medicos.class);
    }

    public int obtenerID(String dni) {
        List<Medicos> listaMedicos = (List<Medicos>)findAll();
        for (Medicos l : listaMedicos) {
            if (l.getDni() == (Integer.parseInt(dni))) {
                return l.getDni();
            }
        }
        return -1;
    }
    
}
