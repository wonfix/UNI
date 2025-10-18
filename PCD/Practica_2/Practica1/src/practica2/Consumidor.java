/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

import java.util.Random;

/**
 *
 * @author wonfix
 */
public class Consumidor implements Runnable{


    private PilaLenta lapila;
    private int num = 0;
    
    public  Consumidor(PilaLenta p){
        this.lapila = p;
    }
    
    public void consumir(){
        Thread m = Thread.currentThread();
        
        for (int i = 0; i < 10; i++) {
            try{
                System.out.println("Soy el consumido con identificador: " + m.getId());
                lapila.Desapila();
            } catch(Exception ex){
                System.out.println("Error de tipo: " + ex.getMessage());
            }
        }
    }
    
    @Override
    public void run() {
        consumir();
    }
    
}
