package bran.java.elements;
import bran.java.customizewindow.Tile;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public interface DrawElement {

	public void draw(Graphics2D g, ArrayList<ArrayList<Tile>> text, double x, double y, int thickness, double time);

	default void draw(Graphics2D g, double time) {
		
	}

	default void defaultDraw(Graphics2D g, ArrayList<ArrayList<Tile>> text, double x, double y, int thickness) {
		Rectangle2D rectangle;
		for (int r = 0; r < text.size(); r++)
			for (int c = 0; c < text.get(r).size(); c++)
				if (text.get(r).get(c).isActive()) { // && x + c * thickness < 512 && y + r * thickness < 512
					g.setColor(text.get(r).get(c).getColor());
//					System.out.println(g.getColor().toString() + " " + text.get(r).get(c).isActive() + " ");
                    rectangle = new Rectangle2D.Double(x + thickness * c, y + thickness * r, thickness, thickness);
                    g.fill(rectangle);
//					g.drawRect((int) (x + thickness * r), (int) (y + thickness * c), thickness, thickness);
				}
	}
	
}
