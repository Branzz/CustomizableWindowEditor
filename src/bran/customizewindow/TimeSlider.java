package bran.customizewindow;
//import java.awt.*;
//import java.applet.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.geom.Ellipse2D;
//import java.util.ArrayList;
//import java.awt.Graphics2D;
//import javax.swing.Timer;
//
//
//public class TimeSlider extends Applet implements MouseListener {
//
//	private final int DELAY = 10;
//	private int maxTime;
//	private int dialX;
//	private int width;
//	private int height;
//	private Window window;
//
//	public TimeSlider(int maxTime, Window window) {
//		this.maxTime = maxTime;
//		this.window = window;
//	}
//
//	public void init() {
//		
//		dialX = 0;
//		this.addMouseListener(this);
////        this.addMouseWheelListener(this);
////        this.addKeyListener(this);
//
//		width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//		this.resize(width,
//					(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
//		
//		ActionListener taskPerformer = new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				repaint();
//			}
//		};
//		
//		new Timer(DELAY, taskPerformer).start();
//		
//	}
//		
//	public void update(Graphics g) {
//		Graphics offgc;
//		Image offscreen = null;
//		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//
//		offscreen = createImage(d.width, d.height);
//		offgc = offscreen.getGraphics();
//
//		offgc.setColor(getBackground());
//		offgc.fillRect(0,0,d.width,d.height);
//		offgc.setColor(getForeground());
//
//		paint(offgc);
//
//		g.drawImage(offscreen, 0, 0, this);
//
//	}
//	
//	public void paint(Graphics g) {
//
//		Graphics2D g1 = (Graphics2D) g;
//		Ellipse2D dial = new Ellipse2D.Double(8 + window.getTime() / maxTime, 8, 16, 16);
//		System.out.println(8 + window.getTime() / maxTime);
//		g1.drawLine(16, 16, 496, 16);
//		g1.fill(dial);
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//}