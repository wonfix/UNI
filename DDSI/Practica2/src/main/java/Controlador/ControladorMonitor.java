/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Actividad;
import Modelo.ActividaDAO;
import Modelo.MonitorDAO;
import Vista.VistaActividad;
import Vista.VistaMonitores;
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
public class ControladorMonitor {
    
    Scanner sc = new Scanner(System.in);
    private final SessionFactory sessionFactory;

   
    public ControladorMonitor(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        menuM();
    }
    
    public void menuM(){
        VistaMonitores vistaMenu = new VistaMonitores();
        int opc = 0;
        
        while(opc != 2){
            opc = vistaMenu.menuMonitor();
            
            switch (opc){
                case 1:
                    System.out.println("Llamamos a actividad Monitor");
                    actividadMonitor();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void actividadMonitor(){ 
        VistaMonitores vistaMenu = new VistaMonitores();
        VistaActividad actividad = new VistaActividad();
        String DNI = vistaMenu.pedirDNIMonitor();
        
        Session sesion = null;
        Transaction tr = null;
        
        try {
            sesion = sessionFactory.openSession();
            tr = sesion.beginTransaction();
            
            ActividaDAO actividadDAO = new ActividaDAO();
            MonitorDAO monitorDAO = new MonitorDAO();
            if(monitorDAO.existeDni(sesion, DNI)){
                List<Object[]> resultados = actividadDAO.obtenerDatosActividad(sesion, DNI);
                tr.commit();
                
                actividad.mostrarActividades(resultados);
            } else {
                System.out.println("No existe monitor con ese dni");
                tr.rollback();
            }
            
            
        } catch(HibernateException e){
            if(tr != null && tr.isActive()){
                tr.rollback();
            }
        }finally {
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
}
