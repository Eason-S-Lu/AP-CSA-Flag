/*
 * The code aims to draw a flag of USA
 *
 * By Yicheng Lu
 * And Melody Lyu
 * Line 77 and 78 is written by GitHub Copilot
 * Version control by Git
 * Online repo by GitHub
 * https://github.com/Eason-S-Lu/AP-CSA-Flag
 * IDE by Eclipse and VSCode
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Flag extends JApplet {
    // Finished setting numbers
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

    // You will need to set values for these in paint()
    private double flagWidth; // width of flag in pixels
    private double flagHeight; // height of flag in pixels
    private double stripeHeight; // height of an individual stripe in pixels

    // init() will automatically be called when an applet is run
    public void init() {
        // Choice of width = 1.9 * height to start off
        // 760 : 400 is the ratio of FLY : HOIST
        setSize(760, 400);
        repaint();
    }

    // paint() will be called every time a resizing of an applet occurs
    public void paint(Graphics g) {
        // Sets the width and height of the flag
        double windowWidth = getWidth();
        double windowHeight = getHeight();
        if (windowWidth == 1.9 * windowHeight) {
            flagWidth = windowWidth;
            flagHeight = windowHeight;
        } else if (windowWidth < 1.9 * windowHeight) {
            flagWidth = windowWidth;
            flagHeight = windowWidth / 1.9;
        } else {
            flagWidth = windowHeight * 1.9;
            flagHeight = windowHeight;
        }
        stripeHeight = flagHeight / STRIPES;
        drawBackground(g, windowWidth, windowHeight);
        drawStripes(g, flagWidth, flagHeight);
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
        // Fill the white stripe
        for (int i = 0; i < STRIPES; i++) {
            if (i % 2 == 1) {
                g2d.fillRect(0, (int) (i * stripeHeight), (int) x, (int) stripeHeight);
            }
        }
    }

    public void drawField(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(10, 49, 97));
        g2d.fillRect(0, 0, (int) (flagWidth * D / B), (int) (flagHeight * 7 * L));
    }

    public void drawStars(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        double fieldWidth = flagWidth * D / B;
        double fieldHeight = flagHeight * C;
        double gh = fieldWidth / 12;
        double ef = fieldHeight / 10;
        double diameter = flagWidth * K / B;
        double radius = diameter / 2;
        double radious = diameter / 2;
        double Radious = (Math.sin(Math.toRadians(18)) * radious) / Math.sin(Math.toRadians(54));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                int xCord[] = { (int) gh,
			            (int) (gh + (Radious * Math.cos(Math.toRadians(54)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(18)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(342)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(306)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(270)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(234)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(198)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(162)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(126)))) };
                int yCord[] = { (int) ((ef - radius)),
			            (int) (ef - (Radious * Math.sin(Math.toRadians(54)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(18)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(342)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(306)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(270)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(234)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(198)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(162)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(126)))) };
                g2d.fillPolygon(xCord, yCord, 10);
                gh = gh + 2 * (fieldWidth / 12);
            }
            gh = fieldWidth / 12;
            ef = ef + 2 * (fieldHeight / 10);
        }
        gh = 2 * (fieldWidth / 12);
        ef = 2 * (fieldHeight / 10);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int xCord[] = { (int) gh,
			(int) (gh + (Radious * Math.cos(Math.toRadians(54)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(18)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(342)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(306)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(270)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(234)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(198)))),
                        (int) (gh + (radius * Math.cos(Math.toRadians(162)))),
                        (int) (gh + (Radious * Math.cos(Math.toRadians(126)))) };
                int yCord[] = { (int) (ef - radius),
			(int) (ef - (Radious * Math.sin(Math.toRadians(54)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(18)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(342)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(306)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(270)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(234)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(198)))),
                        (int) (ef - (radius * Math.sin(Math.toRadians(162)))),
                        (int) (ef - (Radious * Math.sin(Math.toRadians(126)))) };
                g2d.fillPolygon(xCord, yCord, 10);
                gh = gh + 2 * (fieldWidth / 12);
            }
            gh = 2 * (fieldWidth / 12);
            ef = ef + 2 * (fieldHeight / 10);
        }
    }
}
