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
public class Productor extends Thread {
    
    private PilaLenta lapila;
    private int num = 0;
    
    public Productor(PilaLenta p){
        this.lapila = p;
    }
    
    public void Producir(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            num = r.nextInt(99);
            System.out.println("El numero es: " + num + " , con identificador: " + getId());
            try{
                lapila.Apila(num);
            }catch(Exception ex){
                System.out.println("Error de tipo: " + ex.getMessage());
            }
        }
    }
    
    @Override
    public void run(){
        Producir();
    }
}
