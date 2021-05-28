package bran.java.elements;
import bran.java.customizewindow.Tile;

import java.awt.Color;
import java.util.ArrayList;

public interface Blurable {

	default ArrayList<ArrayList<Tile>> blur(int intensity, boolean ignoreBackground, boolean edgesTransparent, boolean changeSize, ArrayList<ArrayList<Tile>> text) {
		ArrayList<ArrayList<Tile>> text0;
		ArrayList<ArrayList<Tile>> blurredText = new ArrayList<ArrayList<Tile>>();
		if (changeSize) {
			text0 = (ArrayList<ArrayList<Tile>>) text.clone();
			for (int i = 0; i < intensity; i++) {
				text0.add(0, new ArrayList<Tile>());
				text0.add(new ArrayList<Tile>());
				for (int j = 0; j < text0.get(1).size(); j++)
					text0.get(0).add(new Tile(false));
				for (int j = 0; j < text0.get(text0.size() - 2).size(); j++)
					text0.get(text0.size() - 1).add(new Tile(false));
			}
			for (int i = 0; i < text0.size(); i++) {
				for (int j = 0; j < intensity; j++) {
					text0.get(i).add(0, new Tile(false));
					text0.get(i).add(new Tile(false));
				}
			}
		}
		else
			text0 = text;
		Color color;
		for (int r = 0; r < text0.size(); r++) {
			blurredText.add(new ArrayList<Tile>());
			for (int c = 0; c < text0.get(r).size(); c++) {
				int tileRange = 0;
				int rTotal = 0;
				int gTotal = 0;
				int bTotal = 0;
				for (int hor = - intensity; hor <= intensity; hor++)
					for (int ver = - intensity; ver <= intensity; ver++)
						if (r + ver >= 0 && r + ver < text0.size() && c + hor >= 0 && c + hor < text0.get(r + ver).size() && !(ignoreBackground && !text0.get(r + ver).get(c + hor).isActive())) {
							color = text0.get(r + ver).get(c + hor).getColor();
							rTotal += color.getRed();
							gTotal += color.getGreen();
							bTotal += color.getBlue();
							tileRange++;
						}
						else if (edgesTransparent) {
							rTotal += 255;
							gTotal += 255;
							bTotal += 255;
							tileRange++;
						}
				if (!text0.get(r).get(c).isActive() && tileRange == 0)
					blurredText.get(r).add(new Tile(false));
				else
					blurredText.get(r).add(new Tile(new Color(rTotal / tileRange, gTotal / tileRange, bTotal / tileRange)));
			}
		}
		return blurredText;
	}

}
