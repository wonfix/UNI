/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3_pedro;

/**
 *
 * @author usuario
 */
public class Datos {
    
    int[] contadores={0,0};
    private final MiCanvas cv;

    Datos(MiCanvas cv) {
        this.cv = cv;
    }
    
    public synchronized  void incrementa(int cual){
        contadores[cual]++;
        cv.representa(contadores);
    }
    
    public int[] getContadores(){
        return contadores;
    }
    
}
