package bran.java.elements.list;

import bran.java.elements.text.Text;
import bran.java.elements.ElementChain;
public class PixelateInTextElementChain extends ElementChain {

	public PixelateInTextElementChain(Text element, int timePixelatingOut) {
		super(element);
		for (int i = 0; i < element.getSize(); i++)
			elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / element.getSize(),
					element.getEnterTime() + (i + 1) * timePixelatingOut / element.getSize(), element.getThickness(), element.getStr(), i, element.getColor()));
		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + timePixelatingOut, element.getDieTime(),
				element.getThickness(), element.getStr(), element.getSize(), element.getColor()));
		}

//	public String toString() {
//	return "Pixelating In " + element.toString();
//}

}
