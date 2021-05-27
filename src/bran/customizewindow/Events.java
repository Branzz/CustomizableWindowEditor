package bran.customizewindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Events {

    public static void main(String[] args) { //TODO limiters to drawing off the edges of width/height AND/OR? making it impossible to change the window size
    	ArrayList<Element> elements = new ArrayList<Element>();

    	int width = 512;
    	int height = 512;

    	elements.add(new SolidTileBackground(0, 200, 512, new Color(200, 200, 255)));
//		elements.add(new SolidTileBackground(120, 200, 512, new Color(255, 200, 200)));
		elements.add(new SolidTileBackground(200, 550, 512, new Color(255, 200, 255)));

		elements.add(new SolidTileBackground(550, 800, 512, new Color(255, 80, 80)));
		elements.add(new SolidTileBackground(700, 1000, 512, new FadeTransitionIn(.01), new TransitionOut(), new Color(0, 0, 0)));
		
		elements.add(new Text(130, 110, 5, 100, 3, new FadeTransitionIn(.02), new FadeTransitionOut(.05), "HAPPY", 13));
		elements.add(new Text(60, 190, 20, 100, 3, new FadeTransitionIn(.02), new FadeTransitionOut(.05), "BIRTHDAY,", 13));
		elements.add(new Text(62, 280, 40, 100, 4, new FadeTransitionIn(.05), new FadeTransitionOut(.05), "MADI!", 15));

    	elements.add(new TileImage(107, 130, 120, 200, 6, new FadeTransitionIn(.15), new TransitionOut(), Emoticon.cake));
    	
//    	elements.add(new TileImage(25, 80, 200, 800, 1, new FadeTransitionIn(.1), new FadeTransitionOut(.005), Emoticon.questionpig));
//    	elements.add(new TileImage(25, 80, 200, 650, 1, new FadeTransitionIn(.1), new TransitionOut(), Emoticon.questionpig));
    	elements.addAll(new PixelateOutTileImageElementChain(new TileImage(25, 80, 200, 800, 1, Emoticon.questionpig), 125).getElements());

//    	elements.add(new Text(20, 410, 200, 202, 2, new FadeTransitionIn(0), new FadeTransitionOut(0), "I'VE TAKEN\nOVER! AHAHA!", 14));
//    	elements.add(new Text(20, 410, 204, 206, 2, new FadeTransitionIn(0), new FadeTransitionOut(0), "I'VE TAKEN\nOVER! AHAHA!", 14));
//    	elements.add(new Text(20, 410, 208, 210, 2, new FadeTransitionIn(0), new FadeTransitionOut(0), "I'VE TAKEN\nOVER! AHAHA!", 14));
//    	elements.add(new Text(20, 410, 212, 300, 2, new FadeTransitionIn(0), new FadeTransitionOut(0), "I'VE TAKEN\nOVER! AHAHA!", 14));

    	Color piggyPink = new Color(180, 20, 30);
    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 200, 300, 2, "I'VE TAKEN\nOVER! AHAHA!", 14, piggyPink), 45).getElements());
    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 300, 380, 2, "YOUR FIRST\nQUESTION:", 14, piggyPink), 30).getElements());
    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 380, 450, 2, "HOW ARE YOU?", 14, piggyPink), 30).getElements());
    	elements.add(new Text(50, 400, 450, 500, 4, "K, NO ONE\nASKED :\\", 11, piggyPink));
    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 500, 555, 2, "OK, FOR YOUR\nNEXT QUESTI---", 14, piggyPink), 55).getElements());
    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 555, 600, 2, "AHGUHEHUEJXZ-\nHKCRQZRAKMEH-\nUHAHUHUTEHHU-", 14, new Color(80, 10, 10)), 35).getElements());
//    	elements.addAll(new TypingTextElementChain(new Text(20, 410, 600, 675, 2, "THE PIGGY\nVIRUS!!!!!!!!", 14, new Color(0, 0, 0)), 18).getElements());
    	elements.addAll(new PixelateOutTextElementChain(new Text(20, 410, 600, 750, 2, "THE PIGGY\nVIRUS!!!!!!!!", 14, new Color(0, 0, 0)), 58).getElements()); //TODO center each size?
    	elements.addAll(new TypingTextElementChain(new Text(90, 411, 750, 795, 2, " I'M..... \nDEAD", 14, new Color(100, 100, 100)), 45).getElements());

    	elements.addAll(new FractalElementChain(new Fractal(200, 200, 600, 800, 2, "11", 7), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(100, 150, 615, 800, 2, "11\n01", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(300, 400, 620, 800, 2, "1\n1", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(10, 10, 630, 800, 2, "10\n01\n10", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(50, 10, 635, 800, 2, "01\n01\n11", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(40, 400, 640, 800, 2, "1101", 5), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(300, 20, 650, 800, 2, "1\n1", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(300, 20, 650, 800, 2, "1\n1", 6), 150).getElements());
    	elements.addAll(new FractalElementChain(new Fractal(400, 400, 650, 800, 2, "1\n0\n1\n1", 6), 150).getElements());
    	elements.add(new Fractal(0, 0, 770, 800, 2, "111\n111", 7));
    	elements.add(new Fractal(1, 1, 785, 800, 1, "11\n11", 8));

    	Color inverseLightBlue = new Color(70, 50, 0);
    	elements.add(new TileImage(110, 60, 850, 1000, 1, new FadeTransitionIn(.5), new TransitionOut(), Emoticon.bran).inverseIgnoreTransparent());
		elements.add(new Text(95, 415, 850, 870, 3, new FadeTransitionIn(.5), new TransitionOut(), "IT IS I.", 13, inverseLightBlue).inverseIgnoreTransparent());
		elements.add(new Text(115, 415, 870, 900, 4, new FadeTransitionIn(.7), new TransitionOut(), "BRAN", 12, inverseLightBlue).inverseIgnoreTransparent());
		elements.add(new Text(60, 390, 900, 925, 3, new FadeTransitionIn(.9), new TransitionOut(), "  I HAVE\n DEFEATED\nQUESTIONPIG", 10, inverseLightBlue).inverseIgnoreTransparent());
		elements.add(new Text(15, 410, 925, 950, 2, new FadeTransitionIn(.9), new TransitionOut(), "WITH MY NOVEL\nPIGGY VIRUS.", 14, inverseLightBlue).inverseIgnoreTransparent());
		elements.add(new Text(20, 400, 950, 985, 4, new FadeTransitionIn(1), new FadeTransitionOut(.08), "I'VE SAVED\n    YOU", 9, inverseLightBlue).inverseIgnoreTransparent());

//    	elements.add(new TileImage(70, 70, 1000, 1050, 2, new FadeTransitionIn(.5), new TransitionOut(), Emoticon.heart));
//    	elements.add(new TileImage(70, 70, 1000, 1100, 2, new FadeTransitionIn(.5), new TransitionOut(), Emoticon.heart));
//    	elements.addAll(new PixelateOutTileImageElementChain(new TileImage(70, 70, 1100, 1200, 2, Emoticon.heart), 100).getElements());
    	elements.addAll(new BlurOutTileImageElementChain(new TileImage(70, 70, 1000, 1200, 2, new FadeTransitionIn(.5), new TransitionOut(), Emoticon.heart), 130, 18, true, true, true).getElements());

    	elements.add(new NoiseTileBackground(1200, 1220, 4, 8, 129557, width, height));
    	elements.add(new NoiseTileBackground(1220, 1240, 4, 9, 229557, width, height));
    	elements.add(new NoiseTileBackground(1240, 1260, 4, 10, 329557, width, height));
    	elements.add(new NoiseTileBackground(1260, 1280, 4, 11, 429557, width, height));
    	elements.add(new TileImage(0, 120, 1200, 1280, 1, Emoticon.hug).inverseTransparent());
    	elements.add(new TileImage(0, 121, 1200, 1280, 1, Emoticon.hug));

    	elements.add(new Text(35, 210, 1280, 1281, 5, "THE END", 10));
    	elements.add(new Text(10, 310, 1280, 1281, 2, "REWIND/REPLAY WITH\nTHIS SLIDER\nOR THE ARROW\nKEYS/SPACEBAR!", 10));
    	elements.add(new TileImage(365, 350, 1280, 1281, 1, Emoticon.arrow));
    	TileImage smallImage = new TileImage(190, 40, 1280, 1281, 1, Emoticon.sleep);
    	smallImage.setText(smallImage.pixelate(2, 2, smallImage.getText()));
    	elements.add(smallImage);

//    	elements.addAll(new BlurOutTileImageElementChain(new TileImage(70, 70, 1280, 1480, 2, Emoticon.heart), 150, 30, true, true, true).getElements());
    	for (Element e : elements)
    		e.removeUnusedTiles(width, height);

    	JFrame frame = new JFrame("A message from bran");
    	Window message = new Window(elements, 1280, frame, width, height);
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
