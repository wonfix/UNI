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
public class Combustion implements Runnable {
    
    Parking p;
    int id = 0;
    
    public Combustion(Parking p, int id){
        this.p = p;
        this.id = id;
    }
    
    @Override
    public void run(){
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        Thread c = Thread.currentThread();
        
        try{
            System.out.println("Soy el coche combustion: " + id);
            //Entro
            p.entraCombustion(id);
            System.out.println("coche combustion: " + id + " Aparcado");
            Thread.sleep((r.nextInt(2)+5)*1000); //Intervalo de 5 a 6 seg
            System.out.println("coche combustion: " + id + " Me voy");
            //Salgo
            p.saleCombustion(id);
        } catch (InterruptedException ex){
            System.out.println("Ha habido algun error en Combustion....");
        } 
    }
    
}
