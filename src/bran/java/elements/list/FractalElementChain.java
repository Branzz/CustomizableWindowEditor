package bran.java.elements.list;

import bran.java.elements.ElementChain;
import bran.java.elements.list.Fractal;
public class FractalElementChain extends ElementChain {

	public FractalElementChain(Fractal element, int timeTyping) {
		super(element);
		for (int i = 0; i < element.getSize(); i++)
			elements.add(new Fractal(element.getX(), element.getY(), element.getEnterTime() + i * timeTyping / element.getSize(), element.getEnterTime() + (i + 1) * timeTyping / element.getSize(), element.getThickness(), element.getSeed(), i + 1));
		elements.add(new Fractal(element.getX(), element.getY(), element.getEnterTime() + timeTyping, element.getDieTime(), element.getThickness(), element.getSeed(), element.getSize()));
		}

	public String toString() {
//		if (element == null)
//			return "Undeclared Fractal Element Chain";
		return "Shrinking " + element.toString();
	}


}
