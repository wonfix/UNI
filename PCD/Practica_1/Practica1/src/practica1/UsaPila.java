/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

import practica1.Pila;

import java.util.Random;

/**
 *
 * @author wonfix
 */
public class UsaPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Pila p = new Pila(10);
        Random r = new Random();
        Object valorDesapilado;
        int valor;

        for (int i = 0; i < 10; i++) {
            valor = r.nextInt(100);
            System.out.println("Valor generado es: " + valor);
            if (valor % 2 == 0) {
                //PAR
                try {
                    System.out.println("[Es par] Apilamos en la pila el valor: " + valor);
                    p.Apila(valor);
                } catch (Exception e) {
                    System.out.println("No se pudo apilar");
                }
            } else {
                //Impar
                if (p.GetNum() > 0) { //Si hay elemento en la pila desapilamos
                    valorDesapilado = p.Desacola();
                    System.out.println("[Es Impar] Desapilamos el valor: " + valorDesapilado);
                } else {
                    System.out.println("[Es Impar] La pila esta vacia. NO SE PUEDE DESAPILAR!!!");
                }
            }
        }
    }
}
