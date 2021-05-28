package bran.java.elements.list;
import bran.java.customizewindow.Tile;
import bran.java.elements.ElementChain;
import bran.java.images.TileImage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class BlurOutTileImageElementChain extends ElementChain {

	public BlurOutTileImageElementChain(TileImage element, int timePixelatingOut) {
		super(element);
		BufferedImage symbolImage = null;
		try {
			symbolImage = ImageIO.read(element.getEmoticon().getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int smallerDimension = Math.min(symbolImage.getWidth(), symbolImage.getHeight());
		int size = (int) (Math.log(smallerDimension) / Math.log(2));
		ArrayList<ArrayList<Tile>> currentText = element.getText();
		for (int i = 0; i < size; i++) {
			TileImage t = new TileImage(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / size,
					element.getEnterTime() + (i + 1) * timePixelatingOut / size, element.getThickness(), element.getEmoticon());
			t.setText(t.blur(2, false, true, false, currentText));
			currentText = t.getText();
			elements.add(t);
		}
	}

	public BlurOutTileImageElementChain(TileImage element, int timePixelatingOut, int maxIntensity, boolean ignoreBackground, boolean edgesTransparent, boolean changeSize) {
		super(element);
		elements.add(new TileImage(element.getX(), element.getY(), element.getEnterTime(), element.getDieTime() - timePixelatingOut, element.getThickness(), element.getTransitionIn(), element.getTransitionOut(), element.getEmoticon()));
		for (int i = 0; i < maxIntensity; i++) {
			TileImage t = new TileImage(element.getX() - element.getThickness() * (i + 1), element.getY() - element.getThickness() * (i + 1), element.getDieTime() - timePixelatingOut + i * timePixelatingOut / maxIntensity,
					element.getDieTime() - timePixelatingOut + (i + 1) * timePixelatingOut / maxIntensity, element.getThickness(), element.getEmoticon());
			t.setText(t.blur(i + 1, ignoreBackground, edgesTransparent, changeSize, t.getText()));
			elements.add(t);
		}
	}
}
