/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3_pedro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Sumador extends Thread{

    private final Datos d;
    private final int cual;

    Sumador(Datos d, int i) {
        this.d=d;
        this.cual=i;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            try {
                d.incrementa(cual);
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }      
    }
}
