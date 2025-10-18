package practica;

import java.util.Random;

/**
 * Es la clase que uso para empezar con Thread
 *
 * @author Pablo
 * @version 0.1
 * @since 18/10/2025
 */
public class Productor extends Thread {

    private final PilaLenta lapila;
    private int id;
    private int numero = 0;

    public Productor(PilaLenta p, int id) {
        this.lapila = p;
        this.id = id;
    }

    /**
     * Añadir 15 numeros aleatorios a la pila
     */
    public void Producir() throws InterruptedException {
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            numero = r.nextInt(99);

            try {
                lapila.Apila(numero);
            } catch (Exception ex) {
                System.out.println("Error de tipo : " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        try {
            Producir();
        } catch (InterruptedException ex) {
        }
    }
}
