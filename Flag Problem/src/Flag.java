/*
 * By Eason Lu
 * And Meldoy Lyu
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Flag extends JApplet {
    private final int STRIPES = 13;
    private final double A = 1.0; // Hoist (width) of flag
    private final double B = 1.9; // Fly (length) of flag
    private final double C = 0.5385; // Hoist of Union
    private final double D = 0.76; // Fly of Union
    private final double E = 0.054; // See flag specification
    private final double F = 0.054; // See flag specification
    private final double G = 0.063; // See flag specification
    private final double H = 0.063; // See flag specification
    private final double K = 0.0616; // Diameter of star
    private final double L = 0.0769; // Width of stripe

	private double flag_width;
	private double flag_height;
	private double stripe_height;

	// init() will automatically be called when an applet is run
	public void init() {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

	public void paint(Graphics g) {
        double screenWidth = getWidth();
        double screenHeight = getHeight();
        if (screenWidth / screenHeight == B/A){
            flag_width = screenWidth;
            flag_height = screenHeight;
        }
        else if(screenWidth / screenHeight > B/A){
            flag_height = screenHeight;
            flag_width = screenHeight / A * B;
        }
        else{
            flag_width = screenWidth;
            flag_height = screenWidth / B * A;
        }
        stripe_height = flag_height / STRIPES;
        drawBackground(g, screenWidth, screenHeight);
        drawStripes(g, stripe_height);
        drawField(g);
        drawStars(g);
	}

	private void drawBackground(Graphics g, double screenWidth, double screenHeight) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, (int) Math.round(screenWidth), (int) Math.round(screenHeight));
	}
	
	public void drawStripes(Graphics g, double stripeHeight) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(179, 25, 66));
        g2d.fillRect(0, 0, (int) Math.round(flag_width), (int) Math.round(flag_height));
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < STRIPES; i++) {
            if (i % 2 == 1) {
                g2d.fillRect(0, (int) Math.round(i * stripeHeight), (int) Math.round(flag_width), (int) Math.round(stripeHeight));
            }
        }
	}

	public void drawField(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(10, 49, 97));
        g2d.fillRect(0, 0, (int) Math.round(flag_width / B * D), (int) Math.round(flag_height / A * C));
	}

	public void drawStars(Graphics g) {
        Star star = new Star();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        double fieldWidth = flag_width / B * D;
        double fieldHeight = flag_height / A * C;
        double absgh = fieldWidth / 12;
        double absef = fieldHeight / 10;
	}
}
 