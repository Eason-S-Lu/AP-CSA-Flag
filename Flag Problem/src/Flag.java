/*
 *The code aims to draw a flag of USA
 *
 *By Yicheng Lu
 *And Melody Lyu
 *Line 77 and 78 is written by github copilot
 *Version control by git
 *Online repo by github
 *https://github.com/Eason-S-Lu/AP-CSA-Flag
 *IDE by eclipse and VSCode
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
		g2d.setColor(Color.WHITE);
		//fill the white stripe
		for (int i = 0; i < STRIPES; i++) {
			if (i % 2 == 1) {
				g2d.fillRect(0, (int) (i * stripe_height), (int) x, (int) stripe_height);
			}
		}
	}
	public void drawField(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(10, 49, 97));
		g2d.fillRect(0, 0, (int) (flag_width*D/B), (int) (flag_height*7*L));
	}

	public void drawStars(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		double field_width = flag_width*D/B;
		double field_height = flag_height*C;
		double gh=field_width/12;
		double ef=field_height/10;
		double diameter=flag_width*K/B;
		double radious=diameter/2;
		double Radious=(Math.sin(Math.toRadians(18))*radious)/Math.sin(Math.toRadians(54));
		for (int i = 0 ;i<5;i++){
			for (int j = 0 ;j<6;j++){
				int Xcord[]= {(int)gh,(int)(gh+(Radious*Math.cos(Math.toRadians(54)))),(int)(gh+(radious*Math.cos(Math.toRadians(18)))),(int)(gh+(Radious*Math.cos(Math.toRadians(342)))),(int)(gh+(radious*Math.cos(Math.toRadians(306)))),(int)(gh+(Radious*Math.cos(Math.toRadians(270)))),(int)(gh+(radious*Math.cos(Math.toRadians(234)))),(int)(gh+(Radious*Math.cos(Math.toRadians(198)))),(int)(gh+(radious*Math.cos(Math.toRadians(162)))),(int)(gh+(Radious*Math.cos(Math.toRadians(126))))};
				int Ycord[]={(int)((ef-radious)),(int)(ef-(Radious*Math.sin(Math.toRadians(54)))),(int)(ef-(radious*Math.sin(Math.toRadians(18)))),(int)(ef-(Radious*Math.sin(Math.toRadians(342)))),(int)(ef-(radious*Math.sin(Math.toRadians(306)))),(int)(ef-(Radious*Math.sin(Math.toRadians(270)))),(int)(ef-(radious*Math.sin(Math.toRadians(234)))),(int)(ef-(Radious*Math.sin(Math.toRadians(198)))),(int)(ef-(radious*Math.sin(Math.toRadians(162)))),(int)(ef-(Radious*Math.sin(Math.toRadians(126))))};
				g2d.fillPolygon(Xcord, Ycord, 10);
				gh=gh+2*(field_width/12);
			}
			gh=field_width/12;
			ef=ef+2*(field_height/10);
		}
		gh = 2*(field_width/12);
		ef = 2*(field_height/10);
		for (int i = 0 ;i<4;i++){
			for (int j = 0 ;j<5;j++){
				int Xcord[]= {(int)gh,(int)(gh+(Radious*Math.cos(Math.toRadians(54)))),(int)(gh+(radious*Math.cos(Math.toRadians(18)))),(int)(gh+(Radious*Math.cos(Math.toRadians(342)))),(int)(gh+(radious*Math.cos(Math.toRadians(306)))),(int)(gh+(Radious*Math.cos(Math.toRadians(270)))),(int)(gh+(radious*Math.cos(Math.toRadians(234)))),(int)(gh+(Radious*Math.cos(Math.toRadians(198)))),(int)(gh+(radious*Math.cos(Math.toRadians(162)))),(int)(gh+(Radious*Math.cos(Math.toRadians(126))))};
				int Ycord[]={(int)(ef-radious),(int)(ef-(Radious*Math.sin(Math.toRadians(54)))),(int)(ef-(radious*Math.sin(Math.toRadians(18)))),(int)(ef-(Radious*Math.sin(Math.toRadians(342)))),(int)(ef-(radious*Math.sin(Math.toRadians(306)))),(int)(ef-(Radious*Math.sin(Math.toRadians(270)))),(int)(ef-(radious*Math.sin(Math.toRadians(234)))),(int)(ef-(Radious*Math.sin(Math.toRadians(198)))),(int)(ef-(radious*Math.sin(Math.toRadians(162)))),(int)(ef-(Radious*Math.sin(Math.toRadians(126))))};
				g2d.fillPolygon(Xcord, Ycord, 10);
				gh=gh+2*(field_width/12);
			}
			gh=2*(field_width/12);
			ef=ef+2*(field_height/10);
		}
	}
}