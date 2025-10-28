/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wonfix
 */
public class VistaMonitores {
    Scanner sc = new Scanner(System.in);
    
    public int menuMonitor(){
        System.out.println("*********");
        System.out.println("Monitores");
        System.out.println("*********");
        System.out.println("1. Actividades de un monitor");
        System.out.println("2. Salir");
        System.out.println("Selecciones una opcion: ");
        
        int opc = sc.nextInt();
        return opc;
    }
    
    public String pedirDNIMonitor(){
        System.out.println("DNI: ");
        String DNI = sc.nextLine();
        
        return DNI;
    }  
    
}
