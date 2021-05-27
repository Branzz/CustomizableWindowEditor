package bran.customizewindow;
import java.util.ArrayList;

public class Fractal extends TileElement {

	private final char SPACE = ' ';
	private final char FILL = 'O';
	private final char BUFFER = '.';
	private char[][] seed;
	private int size;

	public Fractal(double x, double y, double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut, char[][] seed, int size) {
		super(x, y, enterTime, dieTime, thickness, transitionIn, transitionOut);
		this.seed = seed;
		this.size = size;
		calculateText();
	}

	public Fractal(double x, double y, double enterTime, double dieTime, int thickness, TransitionIn transitionIn, TransitionOut transitionOut, String seedString, int size) {
		super(x, y, enterTime, dieTime, thickness, transitionIn, transitionOut);
		calculateSeed(seedString);
		this.size = size;
		calculateText();
	}
	
	public Fractal(double x, double y, double enterTime, double dieTime, int thickness, String seedString, int size) {
		super(x, y, enterTime, dieTime, thickness);
		calculateSeed(seedString);
		this.size = size;		
		calculateText();
	}

	public Fractal(double x, double y, double enterTime, double dieTime, int thickness, char[][] seed, int size) {
		super(x, y, enterTime, dieTime, thickness);
		this.seed = seed;
		this.size = size;		
		calculateText();
	}

	private void calculateSeed(String seedString) {
		String[] seedStringSplit = seedString.replace('0', SPACE).replace('1', FILL).split("\n");
		seed = new char[seedStringSplit.length][seedStringSplit[0].length()];
		for (int r = 0; r < seed.length; r++)
			seed[r] = seedStringSplit[r].toCharArray();
	}

	public void calculateText() { //TODO an different types of fractals | an option of how many times to wrap it / clone , uses itself as the seed
		ArrayList<ArrayList<Tile>> text = new ArrayList<ArrayList<Tile>>();
		char[][] charText = iterate(size);
		for (int r = 0; r < charText.length; r++) {
			text.add(new ArrayList<Tile>());
			for (int c = 0; c < charText[r].length; c++)
				text.get(r).add(new Tile(charText[r][c] != SPACE));
		}
		setText(text);
	}

	public char[][] iterate(int size) {
		if (size <= 0) {
			char[][] empty = {{}};
			return empty;
		}
		if (size == 1) {
			char[][] point = {{FILL}};
			return point;
		}
		return unbuffer(wrap(clone(iterate(size - 1))));
	}

	private char[][] unbuffer(char[][] formation) {
		char[][] unbuffered = new char[formation.length][formation[0].length];
		for (int r = 0; r < unbuffered.length; r++)
			for (int c = 0; c < unbuffered[r].length; c++) {
				if (formation[r][c] == BUFFER)
					unbuffered[r][c] = SPACE;
				else
					unbuffered[r][c] = formation[r][c];
			}					
		return unbuffered;
	}

	public char[][] clone(char[][] formation) {
		char[][] cloned = new char[(formation.length + 1) * seed.length - 1][(formation[0].length + 1) * seed[0].length - 1];
		for (int r = 0; r < seed.length; r++)
			for (int c = 0; c < seed[r].length; c++)
				if (seed[r][c] == FILL)
					for (int rCopy = 0; rCopy < formation.length; rCopy++)
						for (int cCopy = 0; cCopy < formation[rCopy].length; cCopy++)
							cloned[rCopy + r * (formation.length + 1)][cCopy + c * (formation[0].length + 1)] = formation[rCopy][cCopy];
		for (int r = 0; r < cloned.length; r++)
			for (int c = 0; c < cloned[r].length; c++)
				if (cloned[r][c] == 0)
					cloned[r][c] = SPACE;
		return cloned;
	}

	public char[][] wrap(char[][] formation) {
		char[][] wrapped = new char[formation.length + 4][formation[0].length + 4];
		for (int r = 0; r < formation.length; r++)
			for (int c = 0; c < formation[r].length; c++)
				wrapped[r + 2][c + 2] = formation[r][c];
		for (int r = 0; r < wrapped.length; r++)
			for (int c = 0; c < wrapped[r].length; c++)
				if (wrapped[r][c] == 0)
					wrapped[r][c] = SPACE;
		for (int r = 1; r < wrapped.length - 1; r++)
			for (int c = 1; c < wrapped[r].length - 1; c++)
				if (wrapped[r][c] == FILL)
					for (int hor = -1; hor <= 1; hor++)
						for (int ver = -1; ver <= 1; ver++)
							if (wrapped[r + ver][c + hor] == SPACE && !(hor == 0 && ver == 0))
								wrapped[r + ver][c + hor] = BUFFER;
		for (int r = 0; r < wrapped.length; r++)
			for (int c = 0; c < wrapped[r].length; c++)
				if (wrapped[r][c] == SPACE && ((r != 0 && wrapped[r - 1][c] == BUFFER) || (r != wrapped.length - 1 && wrapped[r + 1][c] == BUFFER) || (c != 0 && wrapped[r][c - 1] == BUFFER) || (c != wrapped[r].length - 1 && wrapped[r][c + 1] == BUFFER)))
					wrapped[r][c] = FILL;
		return wrapped;
	}

	public char[][] getSeed() {
		return seed;
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		String str = "";
		for (char[] line : seed)
			for (char cha : line)
				str += cha;
		return "Fractal " + str;
	}

}
