package bran.java.elements.list;

import bran.java.elements.Element;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public abstract class ListElement {

	public abstract void addTo(DefaultListModel<ListElement> elem);

	public abstract void addTo(ArrayList<Element> elements);

}
