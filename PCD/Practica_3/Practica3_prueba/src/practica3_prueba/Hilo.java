/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_prueba;


/**
 *
 * @author usuario
 */
public class Hilo extends Thread{
    
    private int cual;
    Recurso r;
    
    public Hilo(Recurso r, int cual){
        this.r = r;
        this.cual = cual;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            r.incrementa(cual);
            try { sleep(100); } catch (InterruptedException ex) { }
            
        }
    }
}
