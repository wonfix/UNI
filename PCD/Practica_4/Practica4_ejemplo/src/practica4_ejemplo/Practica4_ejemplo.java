/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_ejemplo;

/**
 *
 * @author usuario
 */
public class Practica4_ejemplo {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, Exception {
        // TODO code application logic here
        Thread[] h = new Thread[5];
        Ordenador o = new Ordenador();
        
        for (int i = 0; i < 5; i++) {
            h[i] = new Hilo(i,o);  
        }
        
        for (int i = 0; i < 5; i++) {
            h[i].start(); 
            
        }
        
       /* for (int i = 0; i < 5; i++) {
            h[i].join();   
        }*/
        
         h[0].join();
         h[1].join(); 
         h[3].join();
         h[4].join();
         
         System.out.println("Ya solo falta el hilo 2");
         synchronized(o){
             //o.notifyAll();  
             o.pasaTurno();
         }
         Thread.sleep(1000);
         synchronized(o){
             //o.notifyAll();  
             o.pasaTurno();
         } 
                 
          
    }
    
}
