/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Historial;
import Entity.Pacientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class HistorialFacade extends AbstractFacade<Historial> {

    @PersistenceContext(unitName = "AS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialFacade() {
        super(Historial.class);
    }

    boolean update(int id,String sintomas) {
        boolean cambiado = false;
        List<Historial> historial = findAll();
        for (Historial h : historial) {
            if (h.getId() == id){
                h.setSintomas(sintomas);
                cambiado = true;
            }
        }
        return cambiado;
    }
    
}
