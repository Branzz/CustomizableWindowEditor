package bran.java.customizewindow;

import bran.java.elements.Element;
import bran.java.images.TileImage;
import bran.java.elements.text.Text;
import bran.java.elements.effects.transitions.FadeTransitionIn;
import bran.java.elements.effects.transitions.TransitionOut;
import bran.java.images.Emoticon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Events2 {

    public static void main(String[] args) throws IOException {
    	ArrayList<Element> elements = new ArrayList<Element>();

    	int width = 512;
    	int height = 512;

//		elements.add(new NoiseTileBackground(0, 200, 1, 12, 123456, width, height));


//		elements.add(new Text(130, 110, 0, 100, 3, new FadeTransitionIn(.02), new FadeTransitionOut(.05), "HAPPY", 13));
		for (int i = 0; i < 25; i++)
			elements.add(new Text(0, 0, i * 5, (i + 1) * 5, 3, "ABCDEF", i));
//		elements.add(new Text(30, 200, 15, 100, 3, new FadeTransitionIn(.02), new FadeTransitionOut(.05), "DAY OF MOTHER,", 9));
//		elements.add(new Text(100, 280, 30, 100, 4, new FadeTransitionIn(.05), new FadeTransitionOut(.05), "MOM!", 15));

    	elements.add(new TileImage(90, 200, 120, 200, 2, new FadeTransitionIn(.1), new TransitionOut(), Emoticon.lasagna));
    	
//    	elements.add(new Fractal(0, 0, 0, 200, 3, "11\n01", 6));
//    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 200, 300, 2, "I'VE TAKEN\nOVER! AHAHA!", 14), 45).getElements());

    	JFrame frame = new JFrame("A message");
    	Window message = new Window(elements, 199, frame, width, height);
        frame.setContentPane(message);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(ImageIO.read(new File("res/rose.png")));
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = frame.getInsets();
        frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setBackground(Color.WHITE);
        message.init();
        message.start();
    }
 
}
