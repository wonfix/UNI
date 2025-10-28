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
public class VistaActividad {
    
    Scanner sc = new Scanner(System.in);
    
    public int menuActividad(){
        System.out.println("***********");
        System.out.println("Actividades");
        System.out.println("***********");
        System.out.println("1. Inscripciones");
        System.out.println("2. Salir");
        System.out.println("Seleccione una opcion: ");
        
        int opc = sc.nextInt();
        return opc;
    }
    
    public String pedirIdActividad(){
        System.out.println("IdActividad: ");
        String idActividad = sc.nextLine();
        
        return idActividad;
    }
    
    //Mostrar datos del socio si el idActividad existe
    public void mostrarIdActividad(List<Object[]> actividades){
        System.out.println("*********** \t ****** \t ******** \t ******");
        System.out.println("NumeroSocio \t Nombre \t Telefono \t correo");
        System.out.println("*********** \t ****** \t ******** \t ******");
        
        for(Object[] datos : actividades){
            String numeroSocio = (String) datos[0];
            String nombre = (String) datos[1];
            String telefono = (String) datos[2];
            String correo = (String) datos[3];
            System.out.println(numeroSocio + "\t" + nombre + "\t" + telefono + "\t" + correo);
        }
    }
    
    //Monstrar el nombre dia y hora que imparte un monitor SI EL DNI existe
    public void mostrarActividades(List<Object[]> actividades){
        System.out.println("****** \t *** \t ****");
        System.out.println("Nombre \t Dia \t Hora");
        System.out.println("****** \t *** \t ****");
        
        for(Object[] fila : actividades){
            String nombre = (String) fila[0];
            String dia = fila[1].toString(); //Entero a String
            String hora = fila[2].toString();
            System.out.println(nombre + "\t" + dia + "\t" + hora);
        }
    }
    
}
