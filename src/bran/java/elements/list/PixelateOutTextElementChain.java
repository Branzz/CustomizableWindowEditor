package bran.java.elements.list;

import bran.java.elements.text.Text;
import bran.java.elements.ElementChain;
public class PixelateOutTextElementChain extends ElementChain {

//	public PixelateOutTextElementChain(Text element, int timePixelatingOut) { // Doesn't use Pixelatable interface, just the Text size
//		super();
////		int width = element.getThickness() * element.getTextColumns();
//		int size = element.getSize();
//		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime(), element.getDieTime() - timePixelatingOut, element.getThickness(), element.getTransitionIn(), element.getTransitionOut(), element.getStr(), size, element.getColor()));
//		for (int i = 0; i < size; i++) {
//			Text t = new Text(element.getX(), element.getY(), element.getDieTime() - timePixelatingOut + i * timePixelatingOut / size,
//					element.getDieTime() - timePixelatingOut + (i + 1) * timePixelatingOut / size, 0, element.getStr(), size - (i + 1), element.getColor());
//			try {
//				t.setThickness((element.getThickness() * element.getTextColumns()) / t.getTextColumns());
//			} catch (ArithmeticException e) {
//				t.setThickness(0);
//			}
//			elements.add(t);
//
////			elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / element.getSize(),
////					element.getEnterTime() + (i + 1) * timePixelatingOut / element.getSize(), element.getStr(), element.getSize() - (i + 1), width, element.getColor()));
////
////			System.out.println(element.getEnterTime() + i * timePixelatingOut / element.getSize() + " " +
////					element.getEnterTime() + (i + 1) * timePixelatingOut / element.getSize() + " " +
////					(element.getSize() - (i + 1)) + " " +
////					width);
//		}
//
////		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + i * timePixelatingOut / element.getSize(),
////				element.getEnterTime() + (i + 1) * timePixelatingOut / element.getSize(), element.getThickness(), element.getStr(), element.getSize() - (i + 1), element.getColor()));
//	}
//	public PixelateOutTextElementChain(Text element, int timePixelatingOut) { // Doesn't use Pixelatable interface, just the Text size
//		super();
//		int size = element.getSize();
//		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime(), element.getDieTime() - timePixelatingOut, element.getThickness(), element.getTransitionIn(), element.getTransitionOut(), element.getStr(), size, element.getColor()));
//		for (int i = 0; i < size; i++) {
//			Text t = new Text(element.getX(), element.getY(), element.getDieTime() - timePixelatingOut + i * timePixelatingOut / size,
//					element.getDieTime() - timePixelatingOut + (i + 1) * timePixelatingOut / size, 0, element.getStr(), size - (i + 1), element.getColor());
//			t.setThickness(t.getTextColumns() == 0 ? 0 : element.getThickness() * element.getTextColumns() / t.getTextColumns());
//			elements.add(t);	
//		}
//	}
	public PixelateOutTextElementChain(Text element, int timePixelatingOut) {// centered
		super(element);
		int size = element.getSize();
		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime(), element.getDieTime() - timePixelatingOut, element.getThickness(), element.getTransitionIn(), element.getTransitionOut(), element.getStr(), size, element.getColor()));
		for (int i = 0; i < size; i++) {
			Text t = new Text(0, 0, element.getDieTime() - timePixelatingOut + i * timePixelatingOut / size,
					element.getDieTime() - timePixelatingOut + (i + 1) * timePixelatingOut / size, 0, element.getStr(), size - (i + 1), element.getColor());
			t.setThickness(t.getTextColumns() == 0 ? 0 : element.getThickness() * element.getTextColumns() / t.getTextColumns());
			t.setX(element.getX() + (element.getTextColumns() - t.getTextColumns()) / 2);
			t.setY(element.getY() + (element.getTextRows() - t.getTextRows()) / 2);
			elements.add(t);	
		}
	}

//	public String toString() {
//	return "Pixelating Out " + element.toString();
//}

}
