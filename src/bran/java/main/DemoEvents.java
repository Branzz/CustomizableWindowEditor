package bran.java.main;

import bran.java.customizewindow.Window;
import bran.java.elements.Element;
import bran.java.elements.TypingTextElementChain;
import bran.java.elements.background.NoiseTileBackground;
import bran.java.elements.background.SolidTileBackground;
import bran.java.elements.effects.transitions.FadeTransitionIn;
import bran.java.elements.effects.transitions.FadeTransitionOut;
import bran.java.elements.effects.transitions.TransitionOut;
import bran.java.elements.list.*;
import bran.java.elements.text.Text;
import bran.java.images.Emoticon;
import bran.java.images.TileImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DemoEvents {

	public static void main(String[] args) {
		ArrayList<Element> elements = new ArrayList<>();

		int width = 512;
		int height = 512;

		elements.add(new SolidTileBackground(0, 100, 512, new Color(200, 200, 255)));
		//		elements.add(new SolidTileBackground(120, 200, 512, new Color(255, 200, 200)));
		elements.add(new SolidTileBackground(100, 200, 512, new Color(255, 200, 255)));

		elements.add(new SolidTileBackground(200, 300, 512, new Color(255, 80, 80)));
		elements.add(new SolidTileBackground(300, 400, 512, new FadeTransitionIn(.01), new TransitionOut(), new Color(0, 0, 0)));
		elements.add(new SolidTileBackground(400, 1200, 512, new Color(50, 255, 80)));

		elements.add(new Text(130, 110, 5, 100, 3, new FadeTransitionIn(.02), new FadeTransitionOut(.05), "HEY", 13));

		Color pink = new Color(180, 20, 30);
		elements.addAll(new TypingTextElementChain(new Text(20, 410, 100, 200, 2, "TYPING EFFECT\nI'M TYPING", 14, pink), 45).getElements());

		elements.addAll(new FractalElementChain(new Fractal(200, 200, 300, 400, 2, "11", 7), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(100, 150, 315, 400, 2, "11\n01", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(300, 400, 320, 400, 2, "1\n1", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(10, 10, 330, 400, 2, "10\n01\n10", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(50, 10, 335, 400, 2, "01\n01\n11", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(40, 400, 340, 400, 2, "1101", 5), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(300, 20, 350, 400, 2, "1\n1", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(300, 20, 350, 400, 2, "1\n1", 6), 150).getElements());
		elements.addAll(new FractalElementChain(new Fractal(400, 400, 350, 400, 2, "1\n0\n1\n1", 6), 150).getElements());

		elements.addAll(new BlurOutTileImageElementChain(new TileImage(70, 70, 1000, 1200, 2, new FadeTransitionIn(.5), new TransitionOut(), Emoticon.brush), 130, 18, true, true, true).getElements());

		elements.add(new NoiseTileBackground(1200, 1220, 4, 8, 129557, width, height));
		elements.add(new NoiseTileBackground(1220, 1240, 4, 9, 229557, width, height));
		elements.add(new NoiseTileBackground(1240, 1260, 4, 10, 329557, width, height));
		elements.add(new NoiseTileBackground(1260, 1280, 4, 11, 429557, width, height));

		elements.add(new Text(10, 310, 20, 100, 2, "REWIND/REPLAY WITH\nTHIS SLIDER\nOR THE ARROW\nKEYS/SPACEBAR!", 10));

		//    	elements.addAll(new BlurOutTileImageElementChain(new TileImage(70, 70, 1280, 1480, 2, Emoticon.heart), 150, 30, true, true, true).getElements());
		for (Element e : elements)
			e.removeUnusedTiles(width, height);

		JFrame frame = new JFrame("Your sample editor");
		bran.java.customizewindow.Window message = new Window(elements, 1280, frame, width, height);
		frame.setContentPane(message);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Emoticon.icon.getImage());
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Insets insets = frame.getInsets();
		frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
		//        frame.setResizable(false); //TODO
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setBackground(Color.WHITE);
		message.init();
		message.start();
	}

}
