package bran.customizewindow;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public enum Emoticon { // a(new File("res/a.png")),

	arrow, bran, brush, cake, editoricon, heart, hug, icon, lasagna, questionpig, rose, selecticon, sleep;

	private InputStream file;
	private BufferedImage image;

	private Emoticon() {

		InputStream input = Emoticon.class.getResourceAsStream(name() + ".png");
		image = null;
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public InputStream getFile() {
		return file;
	}

	public BufferedImage getImage() {
		return image;
	}

}
