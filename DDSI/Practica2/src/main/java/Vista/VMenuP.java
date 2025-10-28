/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Socio;
import java.util.Scanner;

/**
 *
 * @author wonfix
 */
public class VMenuP {
    Scanner sc = new Scanner(System.in);
    
    public int menuP(){
        System.out.println("********************");
        System.out.println("Gestion del Gimnasio");
        System.out.println("********************");
        System.out.println("1. Socios");
        System.out.println("2. Monitores");
        System.out.println("3. Actividades");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opcion: ");
        
        int opc = sc.nextInt();
        return opc;
    }
    
    
}
