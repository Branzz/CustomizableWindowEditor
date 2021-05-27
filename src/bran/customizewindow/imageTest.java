package bran.customizewindow;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class imageTest {

	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("res/cake.png"));
		int[][] pixels = new int[img.getWidth()][img.getHeight()];
		for (int r = 0; r < pixels.length; r++)
			for (int c = 0; c < pixels[r].length; c++)
				pixels[r][c] = img.getRGB(r, c);

//	    Color c = new Color(r, g, b, a);
		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < pixels[r].length; c++) {
			    //get pixel value
			    int p = pixels[r][c];

			    //get alpha
			    int a = (p>>24) & 0xff;

			    //get red
			    int R = (p>>16) & 0xff;

			    //get green
			    int g = (p>>8) & 0xff;

			    //get blue
			    int b = p & 0xff;

				System.out.print(R + " " + g + " " + b + ", ");
			}
			System.out.println();
		}
//	    ImageIO.write(img, "jpg", new File("res/cake.png"));

	}
}
