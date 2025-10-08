/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3_pedro;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class MiCanvas extends Canvas{

    private int[] cont;
    
    public MiCanvas(int ancho, int alto){
        this.setSize(ancho, alto);
        this.setBackground(Color.CYAN);
    }
    
    @Override
    //Si esto esta puesto bien te va a pedir el override si no esta mal
    public void paint(Graphics G){
        //Cambiar la fuente de la letra
        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();
        Font F1 = new Font("Papyrus", Font.ITALIC, 30);
        og.setFont(F1);
        og.setColor(Color.red);
        og.fillOval(50, 70, 40, 30);
        og.drawString("El valor del contador 0 es -> " + cont[0], 100, 100);
        
        Font F2 = new Font("Arial", Font.ITALIC | Font.BOLD, 30);
        og.setFont(F2);
        og.setColor(Color.blue);
        og.fillRect(50, 170, 40, 30);
        og.drawString("El valor del contador 1 es -> " + cont[1], 100, 200);
        
        //Creamos la imagen y la copiamos en el canva 
        G.drawImage(img, 0, 0, null);
    }
    
    @Override
    public void update(Graphics G){
        paint(G);
    }

    public void representa(int[] contadores) {
        this.cont = contadores;
        repaint();
    }
}
