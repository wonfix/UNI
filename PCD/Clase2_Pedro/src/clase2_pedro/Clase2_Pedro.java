/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2_pedro;

/**
 *
 * @author usuario
 */
public class Clase2_Pedro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
       /* 
        //Hilo con extends Thread
        HiloThread h1 = new HiloThread(1);
        HiloThread h2 = new HiloThread(2);
        
        //Hilo con implements Runnable
        HiloRunnable r1 = new HiloRunnable(3);
        Thread h3 = new Thread(r1);
        
        HiloRunnable r2 = new HiloRunnable(4);
        Thread h4 = new Thread(r2);

        System.out.println("Soy la main");
        //Lanzo los hilos de forma concurrente
        //puedo invocar al hilo de forma secuencial con h1.run() !!IMPORTANTE no se utiliza en PCD
        /*h1.start();
        h2.start();
        h3.start();
        h4.start();
        

        //El hilo de la Main espera a que el hilo h1 , h2, h3 y h4  termine
        /*h1.join();
        h2.join();
        h3.join();
        h4.join();
        
        //IMPORTANTE!! no puedo poner h3 ya que el metodo esta implementado en Runnable no en Thread y yo h3 y h4 es un Thread h3 = new Thread(r1), es decir es un 
        // Thread por lo que tenemos que llamar a r1 que es un hilo Runnable
        r1.verContador();
        r2.verContador();
        
        System.out.println("Fin de la main");
        */
       
        System.out.println("Soy la main");
        
        Datos d = new Datos(0);
        d.sumar(5);
        
        HiloThread h1 = new HiloThread(d);
        HiloThread h2 = new HiloThread(d);
        
        h1.start();
        h2.start();
        h2.join();
        h1.join();
        
        System.out.println("El contador vale: " + d.getContador());
        
        System.out.println("Fin de la main");
    }

}
