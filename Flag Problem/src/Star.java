/*
 * By Eason Lu
 * And Meldoy Lyu
 */
import java.awt.Graphics;
public class Star{
	int xcord[] = new int[10];
	int ycord[] = new int[10];
	public void draw(double xoffset, double yoffset, double outerRadius, double innerRadius, Graphics g){
		int i = 0;
		for (int deg = 18 ; deg <=360 ; deg += 36){
			if (i%2 == 0){
				xcord[i] = (int) Math.round(xoffset + (outerRadius * Math.cos(Math.toRadians(deg))));
				ycord[i] = (int) Math.round(yoffset - (outerRadius * Math.sin(Math.toRadians(deg))));
			}
			else{
				xcord[i] = (int) Math.round(xoffset + (innerRadius * Math.cos(Math.toRadians(deg))));
				ycord[i] = (int) Math.round(yoffset - (innerRadius * Math.sin(Math.toRadians(deg))));
			}
			i++;
		}
		g.fillPolygon(xcord, ycord, 10);
	}
}