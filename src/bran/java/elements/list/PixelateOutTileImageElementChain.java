package bran.java.elements.list;
import bran.java.customizewindow.Tile;
import bran.java.elements.ElementChain;
import bran.java.images.TileImage;

import java.util.ArrayList;

public class PixelateOutTileImageElementChain extends ElementChain {

	public PixelateOutTileImageElementChain(TileImage element, int timePixelatingOut) {
		super(element);
		elements.add(new TileImage(element.getX(), element.getY(), element.getEnterTime(), element.getDieTime() - timePixelatingOut, element.getThickness(), element.getTransitionIn(), element.getTransitionOut(), element.getEmoticon()));
		int smallerDimension = Math.min(element.getEmoticon().getImage().getWidth(), element.getEmoticon().getImage().getHeight());
		int size = (int) (Math.log(smallerDimension) / Math.log(2));
		ArrayList<ArrayList<Tile>> currentText = element.getText();
		for (int i = 0; i < size; i++) {
			TileImage t = new TileImage(element.getX(), element.getY(), element.getDieTime() - timePixelatingOut + i * timePixelatingOut / size,
					element.getDieTime() - timePixelatingOut + (i + 1) * timePixelatingOut / size, element.getThickness() * (int) Math.pow(2, i + 1), element.getEmoticon());
			t.setText(currentText = t.pixelate(2, 2, currentText));
//			currentText = t.getText();
			elements.add(t);
			}
	}

//	public String toString() {
//		return "Pixelating Out " + element.toString();
//	}

	//	public String toString() {
//		return element.toString();
//	}



//	public PixelateOutTileImageElementChain(TileImage element, int timePixelatingOut) {
//		super();
//		BufferedImage symbolImage = null;
//		try {
//			symbolImage = ImageIO.read(element.getEmoticon().getFile());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		int smallerDimension = Math.min(symbolImage.getWidth(), symbolImage.getHeight());
//		int size = (int) (Math.log(smallerDimension) / Math.log(2));
//		for (int i = 0; i < size; i++) {
//			TileImage t = new TileImage(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / size,
//					element.getEnterTime() + (i + 1) * timePixelatingOut / size, (int) Math.pow(2, i), element.getEmoticon());
//			t.setText(t.pixelate((int) Math.pow(2, i), (int) Math.pow(2, i), t.getText()));
//			elements.add(t);
//		}
//	}

//	public PixelateOutTileImageElementChain(int widthStretch, int heightStretch, TileImage element, int timePixelatingOut) {
//		super();
//		BufferedImage symbolImage = null;
//		try {
//			symbolImage = ImageIO.read(element.getEmoticon().getFile());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		int size = (int) Math.min(symbolImage.getWidth(), symbolImage.getHeight());
//		for (int i = 0; Math.pow(2, i) < size; i++) {
//			TileImage t = new TileImage(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / size,
//					element.getEnterTime() + (i + 1) * timePixelatingOut / size, i + 2, element.getEmoticon());
//			t.pixelate((int) Math.pow(2, widthStretch), (int) Math.pow(2, heightStretch), null);
//			elements.add(t);
//			}
//	}

}
