package practica;

/**
 * Es la clase que uso para empezar con Runnable
 *
 * @author Pablo
 * @version 0.1
 * @since 18/10/2025
 */
public class Consumidor implements Runnable {

    private final PilaLenta lapila;
    private int id;

    public Consumidor(PilaLenta p) {
        this.lapila = p;
    }

    public void Consumir() throws InterruptedException {

        for (int i = 0; i < 15; i++) {
            try {
                lapila.Desapila();
            } catch (Exception ex) {
                System.out.println("Error de tipo : " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        try {
            Consumir();

            lapila.setConsumidorFinalizado(true);
            System.out.println("EL CONSUMIDOR HA FINALIZADO !!!!");
        } catch (Exception ex) {

        }
    }
}
