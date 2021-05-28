package bran.java.customizewindow;
import java.awt.Color;

public class Tile {

	private boolean active;
	private Color color;
	private final Color TRANSPARENT = Color.WHITE;

	public Tile(boolean active, Color color) {
		this.active = active;
		this.color = active ? color : TRANSPARENT;
	}

	public Tile(Color color, boolean active) {
		active = (color.getRGB() != TRANSPARENT.getRGB());
		this.color = active ? color : TRANSPARENT;
	}
	
	public Tile(boolean active) {
		this.active = active;
		this.color = Color.BLACK;
	}

	public Tile(Color color) {
		active = (color.getRGB() != TRANSPARENT.getRGB());
		this.color = active ? color : TRANSPARENT;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
