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
import javax.persistence.Query;

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
    
    public int updateTomadas(int idReceta){
        try {
            Integer id = (Integer) idReceta;
            Query query = em.createQuery("UPDATE APP.RECETAS x SET x.TOMADAS = x.TOMADAS + 1 WHERE x.ID = 1");
            int tomada = query.executeUpdate();
            return tomada;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int aumentarTomadas(int idReceta) {
        int aumentado = 0;
        List<Recetas> listaRecetas = (List<Recetas>) findAll();    
        Integer i;
        for(Recetas r : listaRecetas){
            if(r.getId() == idReceta){
                i = r.getTomadas() + 1;
                r.setTomadas(i);
                aumentado = 1;
            }
        }
        return aumentado;
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
