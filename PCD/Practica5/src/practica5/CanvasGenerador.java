package practica5;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;

public class CanvasGenerador extends Canvas {

    private Image cocheE, cocheC, parking, aparcamiento, carretera;
    private ArrayList<Integer> colaElectrico = new ArrayList<>();
    private ArrayList<Integer> colaCombustion = new ArrayList<>();
    private ArrayList<Coche> colaRecurso = new ArrayList<>();

    private class Coche {
        int id;
        char tipo; // 'E' o 'C'
        public Coche(int id, char tipo) {
            this.id = id;
            this.tipo = tipo;
        }
    }

    public CanvasGenerador(int ancho, int alto) throws InterruptedException {
        this.setSize(ancho, alto);
        this.setBackground(Color.WHITE);

        cocheE = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/cocheE.png"));
        cocheC = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/cocheC.png"));
        carretera = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/carretera.png"));
        parking = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/Parking.png"));
        aparcamiento = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/aparcamiento.png"));

        MediaTracker dibu = new MediaTracker(this);
        dibu.addImage(parking, 0);
        dibu.waitForID(0);
        dibu.addImage(aparcamiento, 1);
        dibu.waitForID(1);
        dibu.addImage(carretera, 2);
        dibu.waitForID(2);
        dibu.addImage(cocheE, 3);
        dibu.waitForID(3);
        dibu.addImage(cocheC, 4);
        dibu.waitForID(4);
    }

    @Override
    public void paint(Graphics g) {
        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();
        Font f1 = new Font("Arial", Font.BOLD, 20);
        og.setFont(f1);

        // Tienda
        og.drawString("Tienda", 50, 50);
        og.drawImage(parking, 50, 60, null);
        //Aparcamiento
        og.drawString("Aparcamiento", 50, 260);
        og.drawImage(aparcamiento, 50, 270, null);
        //Carretera Electrico
        og.drawString("Electricos", 400, 50);
        og.drawImage(carretera, 400, 60, null);
        //Carretera Combustion
        og.drawString("Combustion", 400, 300);
        og.drawImage(carretera, 400, 310, null);

        // Cola combustion
        for (int i = 0; i < colaCombustion.size(); i++) {
            og.drawImage(cocheC, 400 + i * 60, 310, null);
        }

        // Cola electrico
        for (int i = 0; i < colaElectrico.size(); i++) {
            og.drawImage(cocheE, 400 + i * 60, 60, null);
        }

        // Cola recurso
        for (int i = 0; i < colaRecurso.size(); i++) {
            Coche c = colaRecurso.get(i);
            if (c.tipo == 'C') {
                og.drawImage(cocheC, 50 + i * 60, 270, null);
            } else {
                og.drawImage(cocheE, 50 + i * 60, 270, null);
            }
        }

        // Contadores
        og.setColor(Color.BLACK);
        og.drawString("Electrico: " + colaElectrico.size(), 700, 500);
        og.drawString("Combustion: " + colaCombustion.size(), 700, 520);
        og.drawString("Recurso: " + colaRecurso.size(), 700, 540);

        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    // Representa un coche en el canvas
    public void representa(char estado, int id, char tipoOriginal) {
        // Eliminar de todas las colas
        colaElectrico.remove((Integer) id);
        colaCombustion.remove((Integer) id);
        colaRecurso.removeIf(c -> c.id == id);

        switch (estado) {
            case 'E' -> colaElectrico.add(id);
            case 'C' -> colaCombustion.add(id);
            case 'R' -> colaRecurso.add(new Coche(id, tipoOriginal));
        }
        repaint();
    }

    // Elimina un coche de cualquier cola
    public void eliminaDeColas(int id) {
        colaElectrico.remove((Integer) id);
        colaCombustion.remove((Integer) id);
        colaRecurso.removeIf(c -> c.id == id);
        repaint();
    }
}
