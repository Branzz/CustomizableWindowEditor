package bran.java.elements;

import bran.java.elements.text.Text;
public class TypingTextElementChain extends ElementChain {

	public TypingTextElementChain(Text element, int timeTyping) {
		super(element);
		String str = element.getStr();
		for (int i = 0; i < str.length(); i++)
			elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + i * timeTyping / str.length(), element.getEnterTime() + (i + 1) * timeTyping / str.length(), element.getThickness(), str.substring(0, i+1), element.getSize(), element.getColor()));
		elements.add(new Text(element.getX(), element.getY(), element.getEnterTime() + timeTyping, element.getDieTime(), element.getThickness(), str, element.getSize(), element.getColor()));
		}

	public String toString() {
		return "Typing " + element.toString();
	}

}
