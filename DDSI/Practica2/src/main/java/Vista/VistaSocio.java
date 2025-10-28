/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.Scanner;

/**
 *
 * @author wonfix
 */
public class VistaSocio {
    
    Scanner sc = new Scanner(System.in);
    
    public int menuSocio(){
        System.out.println("***********");
        System.out.println("Socios");
        System.out.println("***********");
        System.out.println("1. Alta de un socio");
        System.out.println("2. Salir");
        System.out.println("Seleccione una opcion: ");
        
        int opc = sc.nextInt();
        return opc;

    }
    
    public String[] pedirDatosSocio(){
        
        System.out.println("*************");
        System.out.println("Alta de Socio");
        System.out.println("*************");
        
        System.out.println("Numero de socio: ");
        String nSocio = sc.nextLine();
        
        
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("DNI: ");
        String DNI = sc.nextLine();
        
        System.out.println("Fecha de entrada: ");
        String fechaEntrada = sc.nextLine();
        
        System.out.println("Categoria: ");
        Character categoria = sc.nextLine().charAt(0);
                
        System.out.println("Estos campos son opcionales...");
        System.out.println("Fecha de nacimiento: ");
        String fechaNac = sc.nextLine();
        
        
        System.out.println("Telefono: ");
        String telefono = sc.nextLine();
        
        System.out.println("Correo: ");
        String correo = sc.nextLine();     
        
        return new String[]{nSocio, nombre, DNI, fechaEntrada, categoria.toString(), fechaNac, telefono, correo};
    }
}
