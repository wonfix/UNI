package practica;

/**
 * Es la clase que uso para empezar con Runnable
 *
 * @author Iván
 * @version 0.1
 * @since 21/10/2021
 */
public class Consumidor implements Runnable{
    private final PilaLenta lapila;
    
    public Consumidor(PilaLenta p){
        this.lapila = p;
    }
    
    public void Consumir() {
        Thread m = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            try {
                //System.out.println("Soy el Consumidor   " + ", con identificador " + m.getId());
                lapila.Desapila();
            } catch (Exception ex) {
                System.out.println("Error de tipo : " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        Consumir();
    }
}
