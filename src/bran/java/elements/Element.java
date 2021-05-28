package bran.java.elements;
import bran.java.customizewindow.Tile;
import bran.java.elements.list.ListElement;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public abstract class Element extends ListElement implements DrawElement {

	private double x;
	private double y;
	private double enterTime;
	private double dieTime;

	public Element() {
		x = 0;
		y = 0;
	}

	public Element(double x, double y, double enterTime, double dieTime) {
		this.x = x;
		this.y = y;
		this.enterTime = enterTime;
		this.dieTime = dieTime;
	}

	@Override
	public abstract void draw(Graphics2D g, double time);

	@Override
	public abstract void draw(Graphics2D g, ArrayList<ArrayList<Tile>> text, double x, double y, int thickness, double time);

	public abstract void removeUnusedTiles(int width, int height);

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}

	public double getDieTime() {
		return dieTime;
	}

	public void setDieTime(int dieTime) {
		this.dieTime = dieTime;
	}

	public void addTo(DefaultListModel<ListElement> elem) {
		elem.addElement(this);
	}

	public void addTo(ArrayList<Element> elements) {
		elements.add(this);
	}

	public String toString() {
		return "Element";
	}

}
