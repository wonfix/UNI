package practica;

/**
 * Es la clase que uso para empezar la practica
 *
 * @author Iván
 * @version 0.1
 * @since 21/10/2021
 */
public class PilaLenta implements IPila {

    private int cima;
    private final int capacidad;
    private int numelementos;
    private final Object[] datos;
    private final CanvasPila canvas;

    /**
     * Constructor de la clase. Inicializa la pila y los atributos de la clase
     *
     * @param capacidad que será la cantidad de elementos con que se inicializa
     * el vector.
     */
    public PilaLenta(int capacidad, CanvasPila canvas) {
        cima = 0;
        this.capacidad = capacidad;
        numelementos = 0;
        datos = new Object[capacidad];
        this.canvas = canvas;
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
    public synchronized void Apila(Object elemento) throws Exception{
        //para comprobar si esta bien al desapila y apila le ponemos el syncronize
        if (!pilallena()) {
            Thread.sleep(300);
            datos[cima] = elemento;
            Thread.sleep(300);
            cima++;
            Thread.sleep(300);
            numelementos++;
            if(numelementos==capacidad){ canvas.avisa("llena");
            }else{ canvas.avisa(""); }
            canvas.representa(datos, cima, numelementos);
        } else {
            canvas.avisa("llena");
            throw new Exception("Error la pila ya está llena!");
        }
    }

    /**
     * Extrae el primer elemento de la pila, si existe
     *
     * @return elemento que se extrae
     * @throws Exception si la pila está vacía
     */
    @Override
    public synchronized Object Desapila() throws Exception {
        Object elemento = 0;
        if (!pilavacia()) {
            Thread.sleep(300);
            cima--;
            Thread.sleep(300);
            numelementos--;
            Thread.sleep(300);
            elemento = datos[cima];
            if(numelementos==0){ canvas.avisa("vacia");
            }else{ canvas.avisa("novacia"); }
            canvas.representa(datos, cima, numelementos);
        } else {
            canvas.avisa("vacia");
            throw new Exception("La pila está vacía");
        }
        
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
            elemento = datos[cima-1];
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
        return numelementos==0;
    }
    
    /**
     * 
     * @return true si la pila esta llena
     */
    private boolean pilallena() {
        return numelementos==capacidad;
    }
}
