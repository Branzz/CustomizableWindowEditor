package bran.customizewindow;
import java.awt.Color;
import java.util.ArrayList;

public class TileImage extends TileElement implements Pixelatable, Blurable {

	private Emoticon symbol;

	public TileImage(double x, double y, double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut, Emoticon symbol) {
		super(x, y, enterTime, dieTime, thickness, transitionIn, transitionOut);
		this.symbol = symbol;
		calculateText();
	}

	public TileImage(double x, double y, double enterTime, double dieTime, int thickness, Emoticon symbol) {
		super(x, y, enterTime, dieTime, thickness);
		this.symbol = symbol;
		calculateText();
	}

	public void calculateText() {
		ArrayList<ArrayList<Tile>> text = new ArrayList<ArrayList<Tile>>();
		for (int r = 0; r < symbol.getImage().getHeight(); r++) {
			text.add(new ArrayList<Tile>());
			for (int c = 0; c < symbol.getImage().getWidth(); c++)
			    text.get(r).add(new Tile(new Color(symbol.getImage().getRGB(c, r), true)));
		}
		setText(text);
	}

	public Emoticon getEmoticon() {
		return symbol;
	}

	public String toString() {
		return "Image " + symbol.name();
	}

}
