/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Login;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    @PersistenceContext(unitName = "AS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }
    public String validarUser(String dni, String clave){
        String estado = "";
        List<Login> login = (List<Login>) findAll();
        for (Login l : login) {
            if(l.getDni() == Integer.parseInt(dni) && clave.equals(l.getClave())){
                estado = l.getRol();
            }
        }
        return estado;
    }
}
