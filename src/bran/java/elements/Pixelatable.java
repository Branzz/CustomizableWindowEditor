package bran.java.elements;
import bran.java.customizewindow.Tile;

import java.util.ArrayList;

public interface Pixelatable {

//	public void pixelate();

	default ArrayList<ArrayList<Tile>> pixelate(int widthStretch, int heightStretch, ArrayList<ArrayList<Tile>> text) {
		ArrayList<ArrayList<Tile>> pixelatedText = new ArrayList<ArrayList<Tile>>();
		for (int r = 0; r < text.size() / heightStretch; r++) {
			pixelatedText.add(new ArrayList<Tile>());
			for (int c = 0; c < text.get(r).size() / widthStretch; c++)
				pixelatedText.get(r).add(text.get(r * heightStretch).get(c * widthStretch));
		}
		return pixelatedText;
	}

}
