/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2_pedro;

import static java.lang.Thread.sleep;

/**
 *
 * @author usuario
 */
public class HiloRunnable implements Runnable {

    private int id;
    private int contador = 0;
    
    public HiloRunnable(int id){
        this.id = id;
    }
    
    @Override
    public void run() {
        //Como estoy con Runnable no sabe lo que es los metodos del Thread por lo creo un objeto de la clase Thread con Thread.currentThread();
        Thread yo = Thread.currentThread();
        //Voy a cambiar la prioridad del hilo
        yo.setPriority(id);
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy el hilo "+ id + " con nombre: " + yo.getName() + " prioridad: " + yo.getPriority() + " estado: " + yo.getState() + " Con ID: " + yo.getId());
            contador++;
            try {
                //en java los sleep son de ms
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public void verContador(){
        System.out.println("El contador vale: " + contador);
    }
}
