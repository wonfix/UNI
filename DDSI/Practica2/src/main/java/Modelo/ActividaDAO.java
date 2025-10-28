/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.NoResultException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author wonfix
 */
public class ActividaDAO {
    public ActividaDAO(){
        
    }
    
    public List<Object[]> obtenerDatosActividad(Session sesion, String dniMonitor) {
        Query<Object[]> query = sesion.createQuery(
            "SELECT a.nombre, a.dia, a.hora " +
            "FROM Actividad a " +
            "INNER JOIN a.monitorResponsable m " +
            "WHERE m.dni = :dni", Object[].class);
        query.setParameter("dni", dniMonitor);
        
        List<Object[]> resultados = query.getResultList();
        return resultados;
    }
    
    /* PREGUNTAR JACINTO XK NO FUNCIONA CON REALIZA
    public List<Object[]> obtenerIdActividad(Session sesion, String idActividad){
        Query query = sesion.createQuery("SELECT s.numeroSocio, s.nombre, s.telefono, s.correo "
                                       + "FROM Socio s "
                                       + "INNER JOIN Realiza r ON s.numeroSocio = r.numeroSocio "
                                       + "INNER JOIN Actividad a ON a.idActividad = r.idActividad "
                                       + "WHERE a.idActividad = :idActividad ", Object[].class);
        query.setParameter("idActividad", idActividad);
        List<Object[]> resultados = query.getResultList();
        return resultados;
    }*/
    
    public List<Object[]> obtenerIdActividad(Session sesion, String idActividad){
        Query query = sesion.createQuery("SELECT s.numeroSocio, s.nombre, s.telefono, s.correo "
                                       + "FROM Actividad a "
                                       + "JOIN socioSet s "
                                       + "WHERE a.idActividad = :idActividad ", Object[].class);
        query.setParameter("idActividad", idActividad);
        List<Object[]> resultados = query.getResultList();
        return resultados;
    }
    
    public boolean existeActividad(Session sesion, String idActividad){
        Query query = sesion.createQuery("From Actividad WHERE idActividad = :idActividad ", Actividad.class);
        query.setParameter("idActividad", idActividad);
        
        try{
            query.getSingleResult();
            return true; 
        } catch (NoResultException e){
            return false;
        }
        
    }
}
