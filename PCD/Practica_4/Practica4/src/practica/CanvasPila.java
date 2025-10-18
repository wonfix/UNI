/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Pablo
 */
public class CanvasPila extends Canvas {

    private int cima = 0;
    private int capacidad = 0;
    private int numelementos = 0;
    private Object[] datos = {0};
    private String mensaje = "";

    public CanvasPila(int ancho, int alto, int capacidad) {
        this.setSize(ancho, alto);
        this.setBackground(Color.WHITE);
        this.capacidad = capacidad;
    }

    public void representa(Object[] datos, int cima, int numelementos) {
        this.cima = cima;
        this.numelementos = numelementos;
        this.datos = datos;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Font f1 = new Font("Arial", Font.BOLD, 20);

        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics og = img.getGraphics();

        og.setFont(f1);

        og.setColor(Color.RED);
        og.drawString("CONTENIDO DE LA PILA", 320, 20);

        if (mensaje == "vacia") {
            og.setColor(Color.red);
            og.drawString("PILA VACÍA", 500, 550);
            og.setColor(Color.LIGHT_GRAY);
            og.drawString("PILA LLENA", 250, 550);
        } else if (mensaje == "llena") {
            og.setColor(Color.red);
            og.drawString("PILA LLENA", 250, 550);
            og.setColor(Color.LIGHT_GRAY);
            og.drawString("PILA VACÍA", 500, 550);
        } else {
            og.setColor(Color.LIGHT_GRAY);
            og.drawString("PILA VACÍA", 500, 550);
            og.drawString("PILA LLENA", 250, 550);
        }

        og.setColor(Color.black);
        og.fillRect(410, 470, 50, 50);
        og.fillRect(410, 410, 50, 50);
        og.fillRect(410, 350, 50, 50);
        og.fillRect(410, 290, 50, 50);
        og.fillRect(410, 230, 50, 50);
        og.fillRect(410, 170, 50, 50);
        og.fillRect(410, 110, 50, 50);

        int hNum = 503;
        int hOval = 485;
        for (int i = 0; i < numelementos; i++) {

            Object dato = datos[i];
            String str = String.valueOf(dato);

            og.setColor(Color.white);
            og.drawString(str, 425, hNum);

            og.setColor(Color.white);
            og.fillOval(360, hOval + 60, 20, 20);
            og.setColor(Color.red);
            og.fillOval(360, hOval, 20, 20);

            hNum = hNum - 60;
            hOval = hOval - 60;
        }

        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void avisa(String mensaje) {
        this.mensaje = mensaje;
        repaint();
    }
}
