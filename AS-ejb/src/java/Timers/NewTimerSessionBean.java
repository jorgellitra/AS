/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timers;

import Controller.RecetasFacade;
import Entity.Recetas;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author entrar
 */
@Singleton
@LocalBean
public class NewTimerSessionBean {
    @EJB
    private RecetasFacade recetasFacade;
  /*  @EJB
    private RecetasFacade recetasFacade;
*/
    String notificacion;
    @Schedule(minute = "*", second = "*", hour = "*")
    
    public void myTimer() {
        Date today = new Date();
        List<Recetas> listaRecetas = (List<Recetas>) recetasFacade.findAll();
        for (Recetas r : listaRecetas) {
            if(r.getInicio().before(today) && r.getFin().after(today)){
                notificacion = "Debe tomarse las pastillas: " + r.getIdMedicinas().getNombre();
                System.out.println("Debe tomarse las pastillas: " + r.getIdMedicinas().getNombre());
            }
        }
    }
    public String getNotificacion(){
        return notificacion;
    }

    /*public String myTimer() {
        Date today = new Date();
        List<Recetas> listaRecetas = (List<Recetas>) recetasFacade.findAll();
        for (Recetas r : listaRecetas) {
            if(r.getInicio().after(today) && r.getFin().before(today)){
                return "Debe tomarse las pastillas: " + r.getIdMedicinas().getNombre(); 
            }
        }
        return "Hoy no tiene que tomarse ninguna pastilla.";
    }*/
}
