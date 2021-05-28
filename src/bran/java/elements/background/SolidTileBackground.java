package bran.java.elements.background;
import bran.java.customizewindow.Tile;
import bran.java.elements.effects.transitions.TransitionIn;
import bran.java.elements.effects.transitions.TransitionOut;

import java.awt.Color;
import java.util.ArrayList;

public class SolidTileBackground extends TileBackground {

	private String color;

	public SolidTileBackground(int enterTime, int dieTime, int thickness, Color color) {
		super(enterTime, dieTime, thickness);
		this.color = color.getRed() + ", " + color.getGreen() + ", " + color.getBlue();
		ArrayList<ArrayList<Tile>> bg = new ArrayList<ArrayList<Tile>>();
		bg.add(new ArrayList<Tile>());
		bg.get(0).add(new Tile(color));
		setText(bg);
	}

	public SolidTileBackground(double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut, Color color) {
		super(enterTime, dieTime, thickness, transitionIn, transitionOut);
		this.color = color.getRed() + " " + color.getGreen() + " " + color.getBlue();
		ArrayList<ArrayList<Tile>> bg = new ArrayList<ArrayList<Tile>>();
		bg.add(new ArrayList<Tile>());
		bg.get(0).add(new Tile(color));
		setText(bg);
	}

//	public void draw(Graphics2D g, double time) {
//		defaultDraw(g, getText(), super.getX(), super.getY(), getThickness());
//	}

	public String toString() {
		return "Background " + color;
	}

}
