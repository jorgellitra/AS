/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Recetas;
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
public class RecetasFacade extends AbstractFacade<Recetas> {

    public List<Recetas> adquirirRecetasHistorial(String idHistorial) {
        List<Recetas> lista = (List<Recetas>)findAll();
        List<Recetas> lista2 = new ArrayList<>();
        for (Recetas r : lista) {
            if(r.getIdHistorial().getId() == Integer.parseInt(idHistorial)){
                lista2.add(r);
            }
        }
        return lista2;
    }

    @PersistenceContext(unitName = "AS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecetasFacade() {
        super(Recetas.class);
    }
    
}
