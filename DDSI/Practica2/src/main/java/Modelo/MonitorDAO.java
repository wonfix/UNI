/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author wonfix
 */
public class MonitorDAO {
        //Esto hay que pasarlo a MONITORDAO
    public boolean existeDni(Session sesion, String dni){
        Query query = sesion.createQuery("FROM Monitor a WHERE a.dni = :dni", Monitor.class);
        query.setParameter("dni", dni);
        List<Monitor> monitor = query.getResultList();
        if(!monitor.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
