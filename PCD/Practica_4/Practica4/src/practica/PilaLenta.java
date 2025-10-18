package practica;

import java.util.Random;

/**
 * Es la clase que uso para empezar la practica
 *
 * @author Pablo
 * @version 0.1
 * @since 18/10/2025
 */
public class PilaLenta implements IPila {

    private int cima;
    private int numelementos;
    private final int capacidad;

    private final Object[] datos;
    private final CanvasPila canvas;

    private boolean consumidorFinalizado = false;

    /**
     * Constructor de la clase. Inicializa la pila y los atributos de la clase
     *
     * @param capacidad que será la cantidad de elementos con que se inicializa
     * el vector.
     */
    public PilaLenta(int capacidad, CanvasPila canvas) {
        this.capacidad = capacidad;
        this.canvas = canvas;
        cima = 0;
        numelementos = 0;
        datos = new Object[capacidad];
    }

    /**
     * @return Devuelve el número de elementos que hay en la pila
     */
    @Override
    public int GetNum() {
        return numelementos;
    }

    /**
     * Añade el elemento a la pila si no está llena
     *
     * @param elemento que se apila
     * @throws Exception si la pila está llena
     */
    @Override
    public synchronized void Apila(Object elemento) throws Exception {
        Random r = new Random();
        int intentos = 0;

        while (pilallena()) {
            if (isConsumidorFinalizado()) {
                throw new Exception("Has intentado apilar el elemento : " + elemento + ""
                        + " pero debido a que el hilo consumidor ha finalizado, tú también finalizarás");
            }

            if (intentos == 3) {
                throw new Exception("Nº de Intentos : 3 has llegado al límite permitido !!");
            }

            intentos++;
            System.out.println("Esperando para poder Apilar, el elemento : " + elemento + " nº de intentos " + intentos);
            canvas.avisa("llena");
            wait();
        }
        Thread.sleep((r.nextInt(3 - 1) + 1) * 1000);
        datos[cima] = elemento;
        cima++;
        numelementos++;

        if (numelementos == capacidad) {
            canvas.avisa("llena");
        } else {
            canvas.avisa("");
        }

        canvas.representa(datos, cima, numelementos);
        System.out.println("Apilado Correctamente el elemento :" + elemento);
        notifyAll();
    }

    /**
     * Extrae el primer elemento de la pila, si existe
     *
     * @return elemento que se extrae
     * @throws Exception si la pila está vacía
     */
    @Override
    public synchronized Object Desapila() throws Exception {
        Random r = new Random();
        Object elemento = null;
        int intentos = 0;

        while (pilavacia()) {
            if (intentos == 3) {
                throw new Exception("Nº de Intentos :" + intentos + 1 + " has llegado al límite permitido !!");
            }
            intentos++;
            System.out.println("Esperando para poder Desapilar, nº de intentos " + intentos);
            canvas.avisa("vacia");
            wait();
        }
        Thread.sleep((r.nextInt(3 - 1) + 1) * 1000);
        cima--;
        numelementos--;
        elemento = datos[cima];

        if (numelementos == 0) {
            canvas.avisa("vacia");
        } else {
            canvas.avisa("");
        }

        canvas.representa(datos, cima, numelementos);
        System.out.println("Desapilado correctamente el elemento " + elemento);
        notifyAll();
        return elemento;
    }

    /**
     * Devuelve el primer elemento de la pila sin extraerlo
     *
     * @return elemento que está el primero en la pila
     * @throws Exception si la pila está vacía
     */
    @Override
    public Object Primero() throws Exception {
        Object elemento = 0;

        if (!pilavacia()) {
            elemento = datos[cima - 1];
        } else {
            throw new Exception("La pila está vacía");
        }

        return elemento;
    }

    /**
     *
     * @return true si la pila esta vacia
     */
    private boolean pilavacia() {
        return numelementos == 0;
    }

    /**
     *
     * @return true si la pila esta llena
     */
    private boolean pilallena() {
        return numelementos == capacidad;
    }

    public boolean isConsumidorFinalizado() {
        return consumidorFinalizado;
    }

    public void setConsumidorFinalizado(boolean consumidorFinalizado) {
        this.consumidorFinalizado = consumidorFinalizado;
    }
}
