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
public class Hilo extends Thread{
    
    private int id;
    private Ordenador ordenador;
    
    public Hilo(int id, Ordenador ordenador){
     this.id = id;
     this.ordenador = ordenador;
    }
    
    @Override
    public void run(){
        
        for (int i = 0; i < 5; i++) {
            ordenador.cogeTurno(id);
            System.out.println("Soy el Hilo "+ id); 
            ordenador.pasaTurno();
        } 
        
        if(id==2){
            ordenador.cogeTurno(id);
            System.out.println("Soy el Hilo "+ id); 
            ordenador.pasaTurno();
        }
       
    }
}
