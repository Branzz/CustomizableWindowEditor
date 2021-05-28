package bran.java.elements.background;

import bran.java.images.Emoticon;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BackgroundImage extends TileBackground {

	private Emoticon image;

	public BackgroundImage(int enterTime, int dieTime, Emoticon image) {
		super(enterTime, dieTime, 1);
		this.image = image;
	}

	public void draw(Graphics2D g, int time) { // TODO ?
		g.drawImage(image.getImage(), 0, 0, (img, infoflags, x, y, width, height) -> true);
	}

}
