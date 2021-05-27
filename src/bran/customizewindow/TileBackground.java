package bran.customizewindow;

public class TileBackground extends TileElement {

	public TileBackground(int enterTime, int dieTime, int thickness) {
		super(0, 0, enterTime, dieTime, thickness);
	}

	public TileBackground(double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut) {
		super(0, 0, enterTime, dieTime, thickness, transitionIn, transitionOut);
	}

	public String toString() {
		return "Background";
	}

}
