package bran.java.elements.background;
import bran.java.customizewindow.Tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class NoiseTileBackground extends TileBackground {

	private int level;
	private double seed;
	private int design;

	public NoiseTileBackground(int enterTime, int dieTime, int thickness, double seed, int design, int width, int height) {
		super(enterTime, dieTime, thickness);
		this.seed = Math.abs(seed);
		level = width;
		this.design = Math.abs(design);
		setText(getNoise(thickness, width, height));
	}

	private ArrayList<ArrayList<Tile>> getNoise(int thickness, int width, int height) {
		ArrayList<ArrayList<Tile>> noise = new ArrayList<ArrayList<Tile>>();
		int range = (int) Math.pow(2, 23);
		for (int w = 0; w < width / thickness; w++) {
			noise.add(new ArrayList<Tile>());
			for (int h = 0; h < height / thickness; h++) {
				noise.get(w).add(new Tile(true, new Color((int) (nextRand() * range))));
			}
		}
		return noise;
	}

	public void draw(Graphics2D g, int time) {
		defaultDraw(g, getText(), super.getX(), super.getY(), getThickness());
	}

	public double nextRand() {
		level++;
		double rand = 1;
		double range = level * level * design;
		while (rand <= range) {
			rand *= 1.981;
		}
		while (seed <= 100) {
			seed *= 2.21;
		}

//		rand /= .981 + seed;
//		System.out.println(rand / range);
		return (rand % seed) / seed;
//		return rand / range;
	}

	public String toString() {
		return "Noise Background " + design;
	}

}
