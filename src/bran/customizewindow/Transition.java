package bran.customizewindow;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Transition extends Effect {

	private int timeActive;

	public Transition() {
		
	}

	public Transition(int timeActive) {
		this.timeActive = timeActive;
	}

	public int getTimeActive() {
		return timeActive;
	}

	public void setTimeActive(int timeActive) {
		this.timeActive = timeActive;
	}

	public void draw(Graphics2D g, ArrayList<ArrayList<Tile>> text, double x, double y, int thickness, double time) {
		
	}

}
