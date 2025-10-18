/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2;

import practica2.PilaLenta;
import java.util.Random;

/**
 *
 * @author wonfix
 */
public class UsaPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PilaLenta p = new PilaLenta(10);

        Productor h1 = new Productor(p);
        Productor h2 = new Productor(p);

        Consumidor c1 = new Consumidor(p);
        Thread h3 = new Thread(c1);
        Consumidor c2 = new Consumidor(p);
        Thread h4 = new Thread(c2);

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();

        System.out.println(" ");
        System.out.println("Numero de elementos de la Pila : " + p.GetNum());
        System.out.println("");
        System.out.println("Contenido de la Pila : ");
        PilaLenta aux = new PilaLenta(10);

        //Cargo los datos de la pila en una pila auxiliar y elimino los datos de la pila para mostrarlo
        while (p.GetNum() != 0) {
            try {
                System.out.println(p.Primero());
                aux.Apila(p.Primero());
                p.Desapila();
            } catch (Exception ex) {
                System.out.println("Error de tipo : " + ex.getMessage());
            }
        }
        p = aux;
        aux = null;

    }
}
