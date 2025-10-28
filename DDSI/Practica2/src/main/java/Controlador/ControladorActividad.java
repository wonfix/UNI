/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ActividaDAO;
import Vista.VistaActividad;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author wonfix
 */
public class ControladorActividad {
    
    Scanner sc = new Scanner(System.in);
    private final SessionFactory sessionFactory;
   
   
    public ControladorActividad(SessionFactory sessionFactory) throws Exception{
        
        this.sessionFactory = sessionFactory;
        menuA();
        
    }
    
    public void inscripciones(){
        VistaActividad actividad = new VistaActividad();
        String idActividad = actividad.pedirIdActividad();
        
        Session sesion = null;
        Transaction tr = null;
        
        try{
            sesion = sessionFactory.openSession();
            tr = sesion.beginTransaction();
            
            ActividaDAO actividadDAO = new ActividaDAO();
            if(actividadDAO.existeActividad(sesion, idActividad)){
                List<Object[]> resultados = actividadDAO.obtenerIdActividad(sesion, idActividad);
                tr.commit();
                actividad.mostrarIdActividad(resultados);
            } else {
                System.out.println("No existe actividad con ese idActivida");
                tr.rollback();
            }
            
            
        } catch(HibernateException e){
            if(tr != null && tr.isActive()){
                tr.rollback();
            }
        } finally {
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public void menuA() throws Exception{
        
        VistaActividad vistaMenu = new VistaActividad();
        int opc = 0;
        
        while(opc != 2){
            
            opc = vistaMenu.menuActividad();
            
            switch (opc){
                case 1:
                    inscripciones();
                    break;

                case 2:
                    System.out.println("Saliendo...");
                    break;

                default:
                    throw new AssertionError();
            }
        }
    }
    
}
