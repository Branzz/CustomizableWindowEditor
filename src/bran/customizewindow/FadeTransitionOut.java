package bran.customizewindow;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class FadeTransitionOut extends TransitionOut {

	private double fadeRate;

	public FadeTransitionOut(double fadeRate) {
		super();
		this.fadeRate = fadeRate;
		calculateTimeActive();
	}

	public void calculateTimeActive() {
		setTimeActive((int) (1 / fadeRate));
	}

	@Override
	public void draw(Graphics2D g, ArrayList<ArrayList<Tile>> text, double x, double y, int thickness, double time) {
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (1 - fadeRate * time)));
//		System.out.println(time + " " + (float) (1 - fadeRate * time));
		defaultDraw(g, text, x, y, thickness);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
	}

	public String toString() {
		return "Fade Out " + fadeRate;
	}

}
