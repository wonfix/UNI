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
public class SocioDAO {

    public SocioDAO(){
        
    }
    
    public void insertaSocio(Session sesion, Socio socio) throws Exception{
        sesion.persist(socio);
    }
    
    public boolean existeDniSocio(Session sesion, String dni){
        Query query = sesion.createQuery("FROM Socio s WHERE s.dni = :dni", Socio.class);
        query.setParameter("dni", dni);
        List<Socio> socio = query.getResultList();
        if(!socio.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean existeNSocio(Session sesion, String nSocio){
        Query query = sesion.createQuery("FROM Socio s WHERE s.numeroSocio = :nSocio", Socio.class);
        query.setParameter("nSocio", nSocio);
        List<Socio> socio = query.getResultList();
        if(!socio.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
}
