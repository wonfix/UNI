/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase1_pedro;

/**
 * Esta clase se usa de ejemplo de PCD en la Practica 1
 * @author Pablo
 * @version 1.0
 */
public class Saluda implements Saludarable {

    private int tipo;

    Saluda(int i) {
        this.tipo = i;
    }

    /**
     * Saluda al usuario que envia el mensaje 
     * @param usuario que es el nombre del que invova 
     * @throws Exception si el objeto no esta definido del tipo 0 ni 1
     */
    @Override
    public void saludar(String usuario) throws Exception {
        switch (tipo) {
            case 0:
                System.out.println("Hola mundo");
                break;

            case 1:
                System.out.println(usuario + ": Hola mundo!!");
                break;
            default:
                throw new Exception("Tipo no definido");
        }
    }

    @Override
    public int despida() {
        System.out.println("FIN!!!");
        return 0;
    }

}
