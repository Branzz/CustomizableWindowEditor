package bran.customizewindow;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class BackgroundImage extends Background {

	private Emoticon image;

	public BackgroundImage(int enterTime, int dieTime, Emoticon image) {
		super(enterTime, dieTime);
		this.image = image;
	}

	public void draw(Graphics2D g, int time) {
		g.drawImage(image, 0, 0, new ImageObserver());
	}

}
