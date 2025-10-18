/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_prueba;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class Lienzo extends Canvas{
    
    private int contadores []={0,0};
    
    public Lienzo(int ancho, int alto){
        this.setSize(ancho, alto);
        this.setBackground(Color.PINK);
    }
    
    
    public void actualiza(int[] contadores){
        this.contadores = contadores;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        Font f1 = new Font("Arial", Font.BOLD, 20);
        Font f2 = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20);
        
        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics og = img.getGraphics();
        
        og.setFont(f1);
        og.setColor(Color.red); 
        og.fillRect(50, 30, 30, 20);
        og.drawString("Contador 0 = " + contadores[0], 100, 50);
        
        og.setFont(f2);
        og.setColor(Color.blue);
        og.fillOval(50, 80, 30, 20);
        og.drawString("Contador 1 = " + contadores[1], 100, 100);
        
        g.drawImage(img, 0, 0, null);
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
}
