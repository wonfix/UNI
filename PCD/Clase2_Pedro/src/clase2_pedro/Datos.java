/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2_pedro;

/**
 *
 * @author usuario
 */
public class Datos {
    private int contador;
    
    public Datos(int vini){
        contador = vini;
    }
    
    //La palabra reservada synchronized dice que los hilos se tienen que ordenar para sumar ORDENADAMENTE, es decir, no puede sumar los 2 hilos a la vez
    //Primero suma 1 y luego sumo otro
    public synchronized void sumar(int cuanto){
        contador=contador+cuanto;
    }
    
    public int getContador(){
        return contador;
    }
    
}
