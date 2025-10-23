/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5;

import java.util.Random;

/**
 *
 * @author wonfix
 */
public class Electrico extends Thread {
    
    Parking p;
    int id = 0;
    
    public Electrico(Parking p, int id){
        this.p = p;
        this.id  = id;
    }
    
    @Override
    public void run(){
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        try{
            System.out.println("Soy el coche electrico: " + id);
            //Entro
            p.entraElectrico(id);
            System.out.println("coche electrico: " + id + " Aparcado");
            Thread.sleep((r.nextInt(2)+5)*1000); //Intervalo de 5 a 6 seg
            System.out.println("coche electrico: " + id + " Me voy");
            //Salgo
            p.saleElectrico(id);
        } catch (InterruptedException ex){
            System.out.println("Ha habido algun error en Electrico....");
        }    
    }
}
