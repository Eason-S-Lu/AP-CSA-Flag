/*
 *By Yicheng Lu
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Flag extends JApplet {
  //Finished setting numbers
	private final int STRIPES = 13;
	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 0.5385;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double L = 0.0769;  // Width of stripe

	// You will need to set values for these in paint()
	private double flag_width;   // width of flag in pixels
	private double flag_height;  // height of flag in pixels
	private double stripe_height; // height of an individual stripe in pixels

	// init() will automatically be called when an applet is run
	public void init() {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

	// paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {
        // Sets the width and height of the flag
        double window_width = getWidth();
        double window_height = getHeight();
        if (window_width == 1.9*window_height){
            flag_width = window_width;
            flag_height = window_height;
        }
        else if (window_width < 1.9*window_height){
            flag_width = window_width;
            flag_height = window_width / 1.9;
        }
        else{
            flag_width = window_height * 1.9;
            flag_height = window_height;
        }
        stripe_height = flag_height / STRIPES;
        drawBackground(g, window_width, window_height);
        drawStripes(g, flag_width, flag_height);
        drawField(g);
        drawStars(g);
	}

	private void drawBackground(Graphics g, double x, double y) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, (int) x, (int) y);
	}
	
	public void drawStripes(Graphics g, double x, double y) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(179, 25, 66));
		g2d.fillRect(0, 0, (int) x, (int) y);
	}

	public void drawField(Graphics g) {
	}

	public void drawStars(Graphics g) {
	}
}