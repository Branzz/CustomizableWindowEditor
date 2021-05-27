package bran.customizewindow;
import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class EditorWindow extends Applet
//implements MouseListener, KeyListener
{

	private static final long serialVersionUID = 1L;
//	private JFrame frame;
	private int width;
	private int height;

	private final int DELAY = 5;
	private int tick;
	private int tickIncrease;
	private int maxTime;
//	private int dialX;
	private ArrayList<Element> elements;

//	private boolean tickUp;
	private boolean paused;
//	private boolean showTimer;
	private boolean mouseSliding;
	private long startTime;

	public EditorWindow(ArrayList<Element> elements, int maxTime, int width, int height) {
		this.elements = elements;
		this.maxTime = maxTime;
//		this.frame = frame;
		this.width = width;
		this.height = height;
	}

	public synchronized void init() {

		tick = 0;
//		tick = maxTime * DELAY;

		tickIncrease = 1;
		mouseSliding = false;

		startTime = System.currentTimeMillis();
//        this.addKeyListener(this);
//		this.addMouseListener(this);
//      this.addMouseWheelListener(this);

//		this.resize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
//					(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
//		this.resize(width, height);
		
		ActionListener taskPerformer = new ActionListener() {
			public synchronized void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};

		new Timer(DELAY, taskPerformer).start();

	}

	public synchronized void update(Graphics g) {System.out.println("update");
		Graphics offgc;
		Image offscreen = null;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		offscreen = createImage(d.width, d.height);
		offgc = offscreen.getGraphics();

		offgc.setColor(getBackground());
		offgc.fillRect(0,0,d.width,d.height);
		offgc.setColor(getForeground());

		paint(offgc);

		g.drawImage(offscreen, 0, 0, this);

	}

	public synchronized void paint(Graphics g) {

		Graphics2D g1 = (Graphics2D) g;

		double time = getTime();

		System.out.println(time);
//		if (time < maxTime && !paused && !mouseSliding) {
//			tick += tickIncrease;
//			tickRangeCheck();
//		}

		for (int i = 0; i < elements.size(); i++) {
//			System.out.println(elements.get(i).getEnterTime() + " <= " + time + " && " + elements.get(i).getDieTime() + " >= " + time);
			if (elements.get(i).getEnterTime() <= time && elements.get(i).getDieTime() > time)
				elements.get(i).draw(g1, time);
		}

//		if (tick >= maxTime * DELAY && !showTimer) {
//			frame.setSize(frame.getWidth(), frame.getHeight() + 32);
//			showTimer = true;
//		}
//
//		if (showTimer) {
////			System.out.println(tick + " " + getTime());
//
//			g1.setColor(Color.LIGHT_GRAY);
//			g1.fill(new Rectangle2D.Double(0, height, width, 32));
//
//			g1.setColor(Color.BLACK);
//			g1.drawLine(16, height + 16, width - 20, height + 16);
//			g1.fill(new Ellipse2D.Double(8 + (width - 32) * tick / DELAY / maxTime, height + 8, 16, 16));
//		}
//
////		if (getTime() == 200)
////			frame.setTitle("A message from QUESTIONPIGGGGGG!!!!!!!! (HACKED)");
////		
////		if (getTime() == 870)
////			frame.setTitle("A message from BRAN!!");
//
//		if (getTime() >= 870)
//			frame.setTitle("A message from BRAN!!");
//		else if (getTime() >= 200)
//			frame.setTitle("A message from QUESTIONPIGGGGGG!!!!!!! (HACKED)");
	}

	public synchronized double getTime() {
		return (System.currentTimeMillis() - startTime) / (50.0);
	}

//	public synchronized double getTime() {
//		return (double) tick / DELAY;
//	}
//	
	public synchronized void setTime(double time) {
		tick  = (int) (time * DELAY);
	}
	
	public synchronized void tickRangeCheck() {
		if (tick < 0)
			tick = 0;
		else if (tick > maxTime * DELAY)
			tick = maxTime * DELAY;
	}

//	@Override
//	public void mouseClicked(MouseEvent e) {}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {}
//
//	@Override
//	public void mouseExited(MouseEvent e) {}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
////		if (16 > Math.sqrt(Math.pow(e.getX() - (8 + (512 - 16) * getTime() / maxTime), 2) + Math.pow(e.getY() - (512 + 8), 2)))
//		if (showTimer)
//			if (16 > Math.abs(e.getY() - (height + 8))) {
//	//			paused = true;
//				mouseSliding = true;
//			}
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		if (showTimer)
//			if (mouseSliding) {
//				tick = (int) (DELAY * (e.getX() - 16) / (width - 32.0) * maxTime);
//				tickRangeCheck();
////				paused = false;
//				mouseSliding = false;
//			}
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		if (showTimer)
//			switch (e.getKeyCode()) {
//			case KeyEvent.VK_LEFT :
//				tick -= 10 * DELAY;
//				tickRangeCheck();
//				break;
//			case KeyEvent.VK_RIGHT :
//				tick += 10 * DELAY;
//				tickRangeCheck();
//				break;
//			case KeyEvent.VK_UP :
//				tickIncrease = tickIncrease == - 1 ? 1 : tickIncrease + 1;
//					;
//				break;
//			case KeyEvent.VK_DOWN :
//	//			tickIncrease = Math.max(0, --tickIncrease);
//				tickIncrease = tickIncrease == 1 ? - 1 : tickIncrease - 1;
//				break;
//			case KeyEvent.VK_SPACE :
//				paused = (paused == mouseSliding);
//				break;
//			}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {}
//
//	@Override
//	public void keyTyped(KeyEvent e) {}

}