/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VMenuP;
import java.util.Scanner;
import org.hibernate.SessionFactory;

/**
 *
 * @author wonfix
 */
public class ControladorPrincipal {

    private final SessionFactory sessionFactory;
    Scanner sc = new Scanner(System.in);

    public ControladorPrincipal(SessionFactory sessionFactory) throws Exception {
        this.sessionFactory = sessionFactory;
        menu();
    }

    private void menu() throws Exception{
        VMenuP vistaMenu = new VMenuP();
        int opc = 0;
        
        while(opc != 4){
            opc = vistaMenu.menuP();
            
            switch (opc) {
                case 1:
                    new ControladorSocio(sessionFactory);
                    break;
        
                case 2:
                    new ControladorMonitor(sessionFactory);
                    break;

                case 3:
                    new ControladorActividad(sessionFactory);
                    break;
                    
                case 4:
                    System.out.println("saliendo");
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
