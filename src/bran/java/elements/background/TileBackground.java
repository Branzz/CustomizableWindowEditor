package bran.java.elements.background;

import bran.java.elements.TileElement;
import bran.java.elements.effects.transitions.TransitionIn;
import bran.java.elements.effects.transitions.TransitionOut;
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
