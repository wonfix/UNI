package practica;

import java.util.Random;

/**
 * Es la clase que uso para empezar con Thread
 *
 * @author Iván
 * @version 0.1
 * @since 21/10/2021
 */
public class Productor extends Thread {

    private final PilaLenta lapila;
    private int numero = 0;

    public Productor(PilaLenta p) {
        this.lapila = p;
    }

    /**
     * Añadir 10 numeros aleatorios a la pila
     */
    public void Producir() {
        Random r = new Random();
        //r.setSeed(System.currentTimeMillis());

        for (int i = 0; i < 10; i++) {
            numero = r.nextInt(99);
            //System.out.println("El numero es :  " + numero + ", con identificador " + getId());
            try {
                lapila.Apila(numero);
            } catch (Exception ex) {
                System.out.println("Error de tipo : " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        Producir();
    }
}
