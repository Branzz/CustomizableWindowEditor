package bran.java.elements;

import bran.java.elements.list.ListElement;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ElementChain extends ListElement {

	public ArrayList<Element> elements;
	public Element element;

//	public ElementChain() {
//		elements = new ArrayList<Element>();
//	}

	public ElementChain(Element element) {
		this.element = element;
		elements = new ArrayList<Element>();
	}
	
	public ArrayList<Element> getElements() {
		return elements;
	}

//	public String toString() {
//		return elements.get(0).toString() + " Chain";
//	}
	public void addTo(DefaultListModel<ListElement> elem) {
		for (Element e : elements)
			elem.addElement(e);
	}

	public void addTo(ArrayList<Element> elements) {
		elements.addAll(elements);
	}

	public String toString() {
//		if (element == null)
//			return "Undeclared Element Chain";
		return element.toString() + " (Chain)";
	}

}
