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
public class Recurso {
    private int[] contadores = {0,0};
    private Lienzo cv;
    
    public Recurso(Lienzo cv){
        this.cv = cv;
    }
    public synchronized void incrementa(int cual){
        contadores[cual]++;
        cv.actualiza(contadores);
        //System.out.println("Contadores : "+ contadores[0] + " y " + contadores[1]);
    }
    
    public void verContadores(){
        System.out.println("Los contadores valen : "+ contadores[0] + " y " + contadores[1]);
    }
}
