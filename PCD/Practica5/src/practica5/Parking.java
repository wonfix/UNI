/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5;

/**
 *
 * @author wonfix
 */
public class Parking {

    private int pLibre = 6, esperaE = 0, cocheC = 0;
    private CanvasGenerador cv;

    public Parking(CanvasGenerador cv) {
        this.cv = cv;
    }

    public synchronized void entraElectrico(int id) throws InterruptedException {
        cv.representa('E', id, 'E');
        esperaE++;
        while (pLibre == 0) {
            wait();
        }
        esperaE--;
        pLibre--;
        cv.representa('R', id, 'E');
    }

    public synchronized void entraCombustion(int id) throws InterruptedException {

        cv.representa('C', id, 'C');
        while (pLibre == 0 || (esperaE > 0 && cocheC >= 2)) {
            wait();
        }
        cocheC++;
        pLibre--;
        cv.representa('R', id, 'C');
    }

    public synchronized void saleElectrico(int id) throws InterruptedException {
        pLibre++;
        cv.eliminaDeColas(id);
        notifyAll();
    }

    public synchronized void saleCombustion(int id) throws InterruptedException {
        cocheC--;
        pLibre++;
        cv.eliminaDeColas(id);
        notifyAll();
    }
}
