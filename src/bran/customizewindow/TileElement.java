package bran.customizewindow;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileElement extends Element {

	private int thickness;
	private ArrayList<ArrayList<Tile>> text;
	private TransitionIn transitionIn;
	private TransitionOut transitionOut;

	public TileElement(double x, double y, double enterTime, double dieTime, int thickness, ArrayList<ArrayList<Tile>> text, TransitionIn transitionIn, TransitionOut transitionOut) {
		super(x, y, enterTime, dieTime);
		this.thickness = thickness;
		this.text = text;
		this.transitionIn = transitionIn;
		this.transitionOut = transitionOut;
	}

	public TileElement(double x, double y, double enterTime, double dieTime, int thickness, ArrayList<ArrayList<Tile>> text) {
		super(x, y, enterTime, dieTime);
		this.thickness = thickness;
		this.text = text;
		this.transitionIn = new TransitionIn();
		this.transitionOut = new TransitionOut();
	}

	public TileElement(double x, double y, double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut) {
		super(x, y, enterTime, dieTime);
		this.thickness = thickness;
//		this.text = calculateText();
		this.transitionIn = transitionIn;
		this.transitionOut = transitionOut;
	}
	
	public TileElement(double x, double y, double enterTime, double dieTime, int thickness) {
		super(x, y, enterTime, dieTime);
		this.thickness = thickness;
//		this.text = calculateText();
		this.transitionIn = new TransitionIn();
		this.transitionOut = new TransitionOut();
	}

	public void calculateText() {
		setText(null);
	}

	@Override
	public void draw(Graphics2D g, double time) {
		if (transitionIn.getClass().equals(TransitionIn.class) && transitionOut.getClass().equals(TransitionOut.class) || time <= transitionIn.getTimeActive() + getEnterTime() && time >= getEnterTime() && getDieTime() - transitionOut.getTimeActive() < time)
			defaultDraw(g, text, super.getX(), super.getY(), thickness);
		else if (time <= transitionIn.getTimeActive() + getEnterTime() && time >= getEnterTime())
			transitionIn.draw(g, text, getX(), getY(), thickness, time - getEnterTime());
		else if (getDieTime() - transitionOut.getTimeActive() < time)
			transitionOut.draw(g, text, getX(), getY(), thickness, time - getDieTime() + transitionOut.getTimeActive());
		else
			defaultDraw(g, text, super.getX(), super.getY(), thickness);
	}

	public void removeUnusedTiles(int width, int height) { // && x + c * thickness < 512 && y + r * thickness < 512
		for (int r = getTextRows() - 1; r >= 0 ; r--)
			if (getY() + thickness * r >= height)
				text.remove(r);
		for (int r = 0; r < getTextRows(); r++)
			for (int c = text.get(r).size() - 1; c >= 0; c--)
				if (getX() + thickness * c >= width)
					text.get(r).remove(c);
	}

	public int getTextRows() {
		return text.size();
	}

	public int getTextColumns() {
		int max = text.get(0).size();
		for (int i = 1; i < getTextRows(); i++)
			max = Math.max(max, text.get(i).size());
		return max;
	}

	public TileElement inverse() {
		ArrayList<ArrayList<Tile>> textInverse = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < getTextRows(); i++) {
			textInverse.add(new ArrayList<Tile>());
			for (Tile t : getText().get(i)) {
				Color normal = t.getColor();
				textInverse.get(i).add(new Tile(new Color(255 - normal.getRed(), 255 - normal.getGreen(), 255 - normal.getBlue())));
			}
		}
		setText(textInverse);
		return this;
	}

	public TileElement inverseIgnoreTransparent() {
		ArrayList<ArrayList<Tile>> textInverse = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < getTextRows(); i++) {
			textInverse.add(new ArrayList<Tile>());
			for (Tile t : getText().get(i)) {
				Color normal = t.getColor();
				textInverse.get(i).add(new Tile(true, new Color(255 - normal.getRed(), 255 - normal.getGreen(), 255 - normal.getBlue())));
			}
		}
		setText(textInverse);
		return this;
	}

	public TileElement inverseTransparent() {
		ArrayList<ArrayList<Tile>> textInverse = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < getTextRows(); i++) {
			textInverse.add(new ArrayList<Tile>());
			for (Tile t : getText().get(i)) {
				if (!t.isActive())
					textInverse.get(i).add(new Tile(false));
				else {
					Color normal = t.getColor();
					textInverse.get(i).add(new Tile(true, new Color(255 - normal.getRed(), 255 - normal.getGreen(), 255 - normal.getBlue())));
				}
			}
		}
		setText(textInverse);
		return this;
//		return new TileImage(getX(), getY(), getEnterTime(), getDieTime(), getThickness());
	}

//	 private TileImage(double x, double y, double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut) {
//		super(x, y, enterTime, dieTime, thickness, transitionIn, transitionOut);
//		this.symbol = symbol;
//		calculateText();
//	}
//
//	 private TileImage(double x, double y, double enterTime, double dieTime, int thickness) {

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public ArrayList<ArrayList<Tile>> getText() {
		return text;
	}

	public void setText(ArrayList<ArrayList<Tile>> text) {
		this.text = text;
	}

	public TransitionIn getTransitionIn() {
		return transitionIn;
	}

	public void setTransitionIn(TransitionIn transitionIn) {
		this.transitionIn = transitionIn;
	}

	public TransitionOut getTransitionOut() {
		return transitionOut;
	}

	public void setTransitionOut(TransitionOut transitionOut) {
		this.transitionOut = transitionOut;
	}

	public String toString() {
		return "TileElement";
	}

}
