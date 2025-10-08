/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase1_pedro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Clase1_Pedro {
 // /** comentario JAVADOC empieza por / y doble *
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Saluda s = new Saluda(6);
        try {
            s.saludar("Pablo");
        } catch (Exception ex) {
            //Logger.getLogger(Clase1_Pedro.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[ERROR] No se puede saludar. Por: " + ex.getMessage());
        }
        
        s.despida();
    }

}
