/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;


/**
 *
 * @author wonfix
 */
public class PilaLenta implements IPila{
    
    private int cima;   // Indice del ultimo elemento
    private int capacidad;
    private int numElemento; //Numero de elemento actual en la pila
    private Object datos[];
    
    
    public PilaLenta(int capacidad){
        this.capacidad = capacidad;
        numElemento = 0;
        cima = 0;
        datos = new Object[capacidad];
        
    }

    /**
     * Devuelve el numero de elementos que hay en la pila
     * @return 
     */
    @Override
    public int GetNum() {
        return numElemento;
    }
    
    /**
     * Añade el elemento a la pila si no esta llena
     * @param elemento
     * @throws Exception 
     */
    @Override
    public synchronized void Apila(Object elemento) throws Exception {
        //para comprobar si esta bien al desapila y apila le ponemos el syncronize
        if(!pilaLlena()){
            Thread.sleep(100);
            datos[cima] = elemento;
            Thread.sleep(100);
            cima++;
            Thread.sleep(100);
            numElemento++;
        } else {
            throw new Exception("La pila esta Vacia");
        }
    }
    /**
     *
     * @return
     * @throws Exception 
     */
    @Override
    public synchronized Object Desapila() throws Exception {
        Object elemento = 0;
        if(!pilaVacia()){
            Thread.sleep(100);
            numElemento--;
            Thread.sleep(100);
            cima--;
            Thread.sleep(100);
            elemento = datos[cima];
        } else {
            throw new Exception("La pila esta vacia");
        }
        return elemento;
    }
    /**
     * Devuelve el primer elemento de la pila sin extraelo 
     * Recuerda una LIFO el primero en salir es el ultimo es decir [A,B,C] el primero es C Es decir la cima
     * @return 
     */

    @Override
    public Object Primero() throws Exception{
        Object elemento = 0;
        if(!pilaVacia()){
            elemento = datos[cima-1];
        } else {
            throw new Exception("La pila esta vacia");
        }
        return elemento;
    }
    
    private boolean pilaLlena(){
        return numElemento == capacidad;
    }
    
    private boolean pilaVacia(){
        return numElemento == 0;
    }
    
}
