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
public class Ordenador {
    private int turno = 0;
    
    public synchronized void cogeTurno(int id){
        while(turno != id){
            try {
                wait();
            } catch (InterruptedException ex) {  }
        }
    }
    
    public synchronized void pasaTurno(){
        turno=(turno+1)%5;
        notifyAll();
    }
}
