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
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Usuario
 */
@Stateless
@LocalBean
public class Timer {

    /*@EJB
    private RecetasFacade recetasFacade;

    @Schedule(minute = "10", second = "5", dayOfMonth = "*", month = "*", year = "*", hour = "*", dayOfWeek = "Mon-Sun")
    
    public String myTimer() {
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
