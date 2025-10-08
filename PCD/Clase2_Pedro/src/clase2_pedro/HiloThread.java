/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2_pedro;

/**
 *
 * @author usuario
 */
public class HiloThread extends Thread {
    
    //private int id;
    
    /*public HiloThread(int id){
        this.id = id;
    }*/
    
    //lo que meta aqui dentro sera concurrente con los otros hilos, lo que hay dentro se ejecuta de forma secuencial
   /* @Override
    public void run() {
        
        //Voy a cambiar la prioridad del hilo
        setPriority(id);
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy el hilo "+ id + " con nombre: " + getName() + " prioridad: " + getPriority() + " estado: " + getState() + " Con ID: " + getId());
            try {
                //en java los sleep son de ms
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }*/
    
    private final Datos d;
    
    public HiloThread(Datos d){
        this.d = d;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            d.sumar(1);
        }
    }
    
}
